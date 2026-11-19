import plistlib
import tempfile
import unittest
from pathlib import Path
from unittest.mock import Mock, call, patch

import ios_benchmark
from summarize import CASE_ORDER, NUMERIC_FIELDS, PREFIX, TEXT_FIELDS


def records(cohort="trial_01", viewport="780x780", sdk="4.45.0"):
    rows = []
    for sequence, route in enumerate(CASE_ORDER, start=1):
        retained = route == "retained"
        row = dict.fromkeys(NUMERIC_FIELDS, "na")
        row.update(
            id=f"a{cohort[-2:]}-{sequence}" if route != "restart" else f"b{cohort[-2:]}-1",
            cohort=cohort,
            case=route,
            mode="real",
            sdk=sdk,
            scope="post_init",
            viewport=viewport,
            ready_ms=35,
            tap_ms=400,
            tile_ms="na" if retained else 1000,
            tile_registered="na" if retained else "mount",
            tiles="retained" if retained else "loaded",
            end="complete",
            mounts=0 if retained else 1,
            markers=0 if retained else 3,
            icons=0 if retained else 1,
        )
        rows.append(row)
    return rows


def encode(row):
    return PREFIX + "|".join(f"{field}={row[field]}" for field in TEXT_FIELDS + NUMERIC_FIELDS) + "\n"


def built_target():
    return {
        "BlueprintName": ios_benchmark.TEST_TARGET,
        "DependentProductPaths": ["__TESTROOT__/Debug-iphonesimulator/sample.app"],
        "TestBundlePath": "__TESTHOST__/PlugIns/ReturnMapBenchmarkTests.xctest",
        "TestHostPath": "__TESTROOT__/Debug-iphonesimulator/ReturnMapBenchmarkTests-Runner.app",
        "TestHostBundleIdentifier": "ru.sulgik.ymk.sample.sample.ReturnMapBenchmarkTests.xctrunner",
        "UITargetAppPath": "__TESTROOT__/Debug-iphonesimulator/sample.app",
        "EnvironmentVariables": {"ORIGINAL": "keep"},
    }


class IosBenchmarkTest(unittest.TestCase):
    def test_cohort_requires_process_boundary_and_native_results(self):
        rows = records()
        self.assertTrue(ios_benchmark.is_complete(rows))
        for case, field, value in [
            (3, "id", "a01-4"),
            (1, "id", "a02-2"),
            (2, "icons", 1),
            (0, "tiles", "early_only"),
            (3, "tap_ms", "na"),
            (0, "viewport", "0x0"),
            (1, "sdk", "4.44.0"),
        ]:
            with self.subTest(case=case, field=field):
                changed = [row.copy() for row in rows]
                changed[case][field] = value
                self.assertFalse(ios_benchmark.is_complete(changed))

    def test_run_keeps_mixed_records_but_fails_without_pooling(self):
        with tempfile.TemporaryDirectory() as temporary, patch.object(ios_benchmark, "OUTPUT", Path(temporary)):
            rows = [
                row for i in range(1, 6)
                for row in records(f"trial_{i:02d}", viewport="520x520" if i == 5 else "780x780")
            ]
            seen = {row["id"]: row for row in rows}
            complete = {f"trial_{i:02d}": True for i in range(1, 6)}
            self.assertFalse(ios_benchmark.write_results(seen, complete, "iPhone", "revision", b"sample-secret"))
            self.assertEqual((Path(temporary) / "baseline.metrics").read_text().count(PREFIX), 20)
            summary = (Path(temporary) / "summary.md").read_text()
            self.assertIn("different measured viewports or SDK versions", summary)
            self.assertNotIn("## real", summary)

    def test_collection_retains_completed_rows_before_bad_record(self):
        with tempfile.TemporaryDirectory() as temporary:
            directory = Path(temporary)
            cold = records()[0]
            (directory / "baseline.metrics").write_text(encode(cold) + "unstructured text\n")
            seen = {}
            with self.assertRaises(ios_benchmark.BenchmarkError):
                ios_benchmark.collect_rows(directory, "trial_01", seen)
            self.assertEqual(set(seen), {cold["id"]})

    def test_configs_keep_xcode_install_and_add_only_the_cohort(self):
        name = ios_benchmark.TEST_TARGET
        specs = [
            ({name: built_target()}, lambda root: root[name]),
            (
                {"TestConfigurations": [{"TestTargets": [built_target()]}]},
                lambda root: root["TestConfigurations"][0]["TestTargets"][0],
            ),
        ]
        with tempfile.TemporaryDirectory() as temporary:
            source = Path(temporary) / "input.xctestrun"
            for spec, find_target in specs:
                source.write_bytes(plistlib.dumps(spec))
                configured = find_target(plistlib.loads(ios_benchmark.test_spec_for(source, "trial_01")))
                self.assertEqual(configured["EnvironmentVariables"], {
                    "ORIGINAL": "keep",
                    "MAPKIT_RETURN_COHORT": "trial_01",
                })
                self.assertNotIn("UseDestinationArtifacts", configured)
                for field in ("DependentProductPaths", "TestHostPath", "UITargetAppPath", "TestBundlePath"):
                    self.assertEqual(configured[field], built_target()[field])
                self.assertEqual(configured["SystemAttachmentLifetime"], "keepNever")
                self.assertEqual(configured["UserAttachmentLifetime"], "keepNever")
                self.assertEqual(plistlib.loads(source.read_bytes()), spec)

    def test_cohort_waits_for_each_launch_in_the_final_container(self):
        with tempfile.TemporaryDirectory() as temporary:
            root = Path(temporary).resolve()
            source = root / "ReturnMapBenchmark.xctestrun"
            source.write_bytes(plistlib.dumps({ios_benchmark.TEST_TARGET: built_target()}))
            replaced = root / "transient" / "Library/ReturnMapBenchmark"
            replaced.mkdir(parents=True)
            container = root / "container"
            directory = container / "Library/ReturnMapBenchmark"
            directory.mkdir(parents=True)
            (directory / "cold.ready").touch()
            device = Mock(udid="test-iphone")
            xcode = Mock()
            xcode.poll.return_value = None
            staging = iter((None, replaced.parents[1], container))

            def find_container(*, required=True):
                if required:
                    return container
                try:
                    return next(staging)
                except StopIteration:
                    self.assertEqual((directory / "cold.key").read_bytes(), b"sample-secret")
                    self.assertFalse((directory / "restart.key").exists())
                    self.assertEqual(list(replaced.iterdir()), [])
                    (directory / "cold.key").unlink()
                    (directory / "restart.ready").touch()
                    return container

            def start_xcode(command, **kwargs):
                self.assertEqual(device.mock_calls, [call.remove_app()])
                spec = Path(command[command.index("-xctestrun") + 1])
                self.assertNotIn(b"sample-secret", spec.read_bytes())
                return xcode

            def finish_xcode(*, timeout):
                self.assertEqual((directory / "restart.key").read_bytes(), b"sample-secret")
                (directory / "restart.key").unlink()
                (directory / "baseline.metrics").write_text("".join(map(encode, records())))
                xcode.poll.return_value = 0
                return 0

            device.container.side_effect = find_container
            xcode.wait.side_effect = finish_xcode
            seen = {}
            with patch.object(ios_benchmark.subprocess, "Popen", side_effect=start_xcode), patch.object(
                ios_benchmark.time, "sleep"
            ):
                self.assertTrue(ios_benchmark.run_cohort(device, source, "trial_01", b"sample-secret", seen, set(), root))
            self.assertEqual(device.mock_calls[-2:], [call.container(), call.remove_app()])
            self.assertEqual(len(seen), 4)

    def test_restart_rejects_a_different_container(self):
        device = Mock()
        device.container.return_value = Path("/different/container")
        process = Mock()
        process.poll.return_value = None
        with self.assertRaisesRegex(ios_benchmark.BenchmarkError, "changed the sample"):
            ios_benchmark.wait_for_launch(
                device, process, "restart", float("inf"), expected_container=Path("/first/container")
            )

    def test_handoffs_are_private_and_cannot_be_overwritten(self):
        with tempfile.TemporaryDirectory() as temporary:
            directory = Path(temporary)
            ios_benchmark.stage_key(directory, "cold", b"sample-secret")
            path = directory / "cold.key"
            self.assertEqual(path.read_bytes(), b"sample-secret")
            self.assertEqual(path.stat().st_mode & 0o777, 0o600)
            with self.assertRaises(FileExistsError):
                ios_benchmark.stage_key(directory, "cold", b"another-secret")
            self.assertEqual(path.read_bytes(), b"sample-secret")
            self.assertEqual(list(directory.iterdir()), [path])


if __name__ == "__main__":
    unittest.main()
