from contextlib import redirect_stdout
from io import StringIO
from pathlib import Path
import tempfile
import unittest
from unittest.mock import patch
from xml.etree import ElementTree

from android_benchmark import (
    BenchmarkError,
    Device,
    KEY_PATH,
    PACKAGE,
    bounds_for_label,
    is_complete,
    main,
    read_runner_key,
    run_cohort,
    write_results,
)
from summarize import CASE_ORDER
from test_summarize import trial


class RecordingDevice:
    def __init__(self):
        self.calls = []
        self.keys = []

    def clear(self):
        self.calls.append("clear")

    def open_first_trial(self, cohort, button, key):
        self.calls.append((cohort, button))
        self.keys.append(key)

    def collect(self, cohort, case, seen):
        self.calls.append(f"native tap: {case}")
        record = {
            "cohort": cohort,
            "case": case,
            "viewport": "780x780",
            "sdk": "4.45.0-lite",
            "mode": "real",
            "end": "complete",
            "ready_ms": 12,
            "tap_ms": 380,
            "mounts": 0 if case == "retained" else 1,
            "tiles": "retained" if case == "retained" else "loaded",
            "tile_ms": "na" if case == "retained" else 290,
        }
        seen[case] = record
        return record

    def tap_label(self, label):
        self.calls.append(label)

    def stop(self):
        self.calls.append("stop and preserve storage")


class AndroidBenchmarkTest(unittest.TestCase):
    def test_cohort_restarts_without_clearing_and_reinjects_the_runtime_key(self):
        device = RecordingDevice()
        key = b"fixture-key"
        seen = {}
        rows = run_cohort(device, key, "trial_01", seen)
        self.assertEqual(device.keys, [key, key])
        self.assertEqual(device.calls, [
            "clear",
            ("trial_01", "Open after clearing app data"),
            "native tap: cold",
            "Details (unmount map)",
            "Return to map",
            "native tap: reopen",
            "Other tab (retain map)",
            "Return to map",
            "native tap: retained",
            "stop and preserve storage",
            ("trial_01", "Open after process restart"),
            "native tap: restart",
        ])
        self.assertTrue(is_complete(rows))
        seen["restart"]["tile_ms"] = "na"
        self.assertFalse(is_complete(rows))

    def test_key_is_only_adb_stdin_and_launch_must_consume_the_private_file(self):
        device = Device("emulator-5554")
        key = b"fixture-key"
        with patch.object(device, "adb", side_effect=["key-ready", "", ""]) as adb:
            device.launch(key)

        stage, launch, remove_check = adb.call_args_list
        self.assertEqual(stage.kwargs["data"], key)
        self.assertTrue(all(key.decode() not in argument for argument in stage.args + launch.args + remove_check.args))
        self.assertEqual(remove_check.args, ("shell", "-T", f"run-as {PACKAGE} test ! -e {KEY_PATH}"))
        self.assertNotIn("data", launch.kwargs)

    def test_key_file_must_be_private_and_is_unlinked_after_read(self):
        with tempfile.TemporaryDirectory() as directory, patch.dict("os.environ", RUNNER_TEMP=directory):
            path = Path(directory, "mapkit-service-key.fixture")
            path.write_bytes(b"fixture-key")
            path.chmod(0o600)
            self.assertEqual(read_runner_key(path), b"fixture-key")
            self.assertFalse(path.exists())

            target = Path(directory, "unrelated-file")
            target.write_bytes(b"untouched")
            path.symlink_to(target)
            with self.assertRaises(BenchmarkError):
                read_runner_key(path)
            self.assertEqual(target.read_bytes(), b"untouched")

    def test_viewport_bounds_come_from_the_sample_window(self):
        tree = ElementTree.fromstring(
            "<hierarchy>"
            '<node package="other" text="map" bounds="[0,0][10,10]" />'
            f'<node package="{PACKAGE}" content-desc="map" bounds="[10,12][30,42]" />'
            "</hierarchy>"
        )
        self.assertEqual(bounds_for_label(tree, "map"), (20, 27))

    def test_partial_rows_survive_without_a_baseline_and_key_matches_are_rejected(self):
        with tempfile.TemporaryDirectory() as directory, patch("android_benchmark.OUTPUT", Path(directory)):
            row = trial("a1-3", "ready", "na", end="deadline")
            rows = {"a1-3": row}
            status = {"test_01": False}
            with self.assertRaises(BenchmarkError):
                write_results(rows, status, "Pixel fixture", "test-revision", b"test_01")
            self.assertEqual(list(Path(directory).iterdir()), [])

            write_results(rows, status, "Pixel fixture", "test-revision", b"fixture-key")
            metrics = Path(directory, "baseline.metrics").read_text()
            summary = Path(directory, "summary.md").read_text()
            self.assertEqual(len(metrics.splitlines()), 1)
            self.assertIn("tile_ms=na", metrics)
            self.assertIn("0/5", summary)
            self.assertNotIn("## real", summary)

    def test_run_rejects_five_complete_cohorts_with_different_viewports_or_sdk(self):
        for field, value in (("viewport", "520x520"), ("sdk", "4.46.0-lite")):
            with self.subTest(field=field), tempfile.TemporaryDirectory() as directory:
                def collect_cohort(device, key, name, seen):
                    number = int(name.split("_")[-1])
                    rows = []
                    for index, case in enumerate(CASE_ORDER, 1):
                        retained = case == "retained"
                        record = trial(
                            f"a{number}-{index}", "na" if retained else "mount", "na" if retained else 35,
                        )
                        record.update(
                            cohort=name,
                            case=case,
                            tap_ms=380,
                            mounts=0 if retained else 1,
                            tiles="retained" if retained else "loaded",
                        )
                        if number == 5:
                            record[field] = value
                        seen[record["id"]] = record
                        rows.append(record)
                    self.assertTrue(is_complete(rows))
                    return rows

                environment = {
                    "GITHUB_ACTIONS": "true",
                    "GITHUB_REPOSITORY": "SuLG-ik/yandex-mapkit-kmp",
                    "GITHUB_REF": "refs/heads/main",
                    "GITHUB_EVENT_NAME": "workflow_dispatch",
                    "GITHUB_SHA": "a" * 40,
                }
                arguments = ["android_benchmark.py", "emulator-5554", "sample.apk", "--key-file", "fixture"]
                with (
                    patch.dict("os.environ", environment, clear=True),
                    patch("sys.argv", arguments),
                    patch("android_benchmark.Device") as device,
                    patch("android_benchmark.read_runner_key", return_value=b"fixture-key"),
                    patch("android_benchmark.run_cohort", side_effect=collect_cohort),
                    patch("android_benchmark.OUTPUT", Path(directory)),
                    redirect_stdout(StringIO()),
                ):
                    device.return_value.adb.return_value = "1"
                    with self.assertRaisesRegex(SystemExit, "different SDK versions or viewport sizes"):
                        main()

                summary = Path(directory, "summary.md").read_text()
                metrics = Path(directory, "baseline.metrics").read_text()
                self.assertIn("5/5", summary)
                self.assertIn("No comparable baseline was produced", summary)
                self.assertNotIn("## real", summary)
                self.assertEqual(len(metrics.splitlines()), 20)
                self.assertIn(f"{field}={value}", metrics)


if __name__ == "__main__":
    unittest.main()
