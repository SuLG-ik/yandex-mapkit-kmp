import importlib.util
import json
from pathlib import Path
import plistlib
import tempfile
import unittest
from unittest.mock import Mock, patch


SCRIPT = Path(__file__).with_name("poi_ios.py")
SPEC = importlib.util.spec_from_file_location("poi_ios", SCRIPT)
poi_ios = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(poi_ios)

TOKEN = "20261120-42"
KEY = b"synthetic-only"
TEST_CASE = "MapInteractionTests/testTrustedBasemapPoiTap()"


class TrustedPoiRunnerTest(unittest.TestCase):
    def setUp(self):
        self.temporary = tempfile.TemporaryDirectory()
        self.addCleanup(self.temporary.cleanup)
        self.root = Path(self.temporary.name).resolve()
        self.products = self.root / "products"
        self.products.mkdir()
        products_patch = patch.object(poi_ios, "PRODUCTS", self.products)
        products_patch.start()
        self.addCleanup(products_patch.stop)
        self.source = self.products / "MapInteractionApp.xctestrun"
        self.source.write_bytes(plistlib.dumps({
            poi_ios.TARGET: {
                "TestHostPath": "__TESTROOT__/MapInteractionTests-Runner.app",
                "UITargetAppPath": "__TESTROOT__/MapInteractionApp.app",
                "EnvironmentVariables": {"ORIGINAL": "keep"},
            }
        }))
        self.spec = self.products / f"mapkit-poi-{TOKEN}.xctestrun"
        self.scratch = self.root / f"mapkit-poi-{TOKEN}"
        self.stale = self.root / "before-xctest"
        self.final = self.root / "after-xctest"
        for container in (self.stale, self.final):
            self.directory(container).mkdir(parents=True)
        (self.directory(self.stale) / "previous.ready").touch()
        (self.directory(self.final) / f"{TOKEN}.ready").touch()

    def directory(self, container):
        return container / poi_ios.POI_DIRECTORY

    def test_xctest_install_replaces_container_before_atomic_private_handoff(self):
        device = Mock(udid="test-simulator")
        device.container.side_effect = [None, self.stale, self.final, self.final, self.final]
        process = Mock()
        process.poll.return_value = None

        def start(command, **kwargs):
            device.container.assert_not_called()
            spec = Path(command[command.index("-xctestrun") + 1])
            configured = plistlib.loads(spec.read_bytes())[poi_ios.TARGET]
            self.assertEqual(configured["EnvironmentVariables"], {
                "ORIGINAL": "keep", "MAPKIT_TRUSTED_POI_RUN_ID": TOKEN,
            })
            self.assertEqual(configured["UITargetAppPath"], "__TESTROOT__/MapInteractionApp.app")
            self.assertEqual(configured["SystemAttachmentLifetime"], "keepNever")
            self.assertEqual(configured["UserAttachmentLifetime"], "keepNever")
            self.assertNotIn("UseDestinationArtifacts", configured)
            self.assertNotIn(KEY, spec.read_bytes())
            self.assertNotIn(KEY.decode(), " ".join(command))
            self.assertEqual(kwargs["stdout"], poi_ios.subprocess.DEVNULL)
            self.assertEqual(kwargs["stderr"], poi_ios.subprocess.DEVNULL)
            return process

        def finish(*, timeout):
            self.assertGreater(timeout, 0)
            original = self.directory(self.stale)
            self.assertEqual([p.name for p in original.iterdir()], ["previous.ready"])
            directory = self.directory(self.final)
            handoff = directory / f"{TOKEN}.key"
            self.assertEqual(handoff.read_bytes(), KEY)
            self.assertEqual(handoff.stat().st_mode & 0o777, 0o600)
            handoff.unlink()
            (directory / f"{TOKEN}.consumed").touch()
            process.poll.return_value = 0
            return 0

        process.wait.side_effect = finish
        with (
            patch.object(poi_ios.subprocess, "Popen", side_effect=start),
            patch.object(poi_ios.time, "sleep"),
            patch.object(poi_ios, "result_category", return_value=0),
        ):
            self.assertEqual(poi_ios.run_probe(device, TOKEN, KEY, self.scratch, self.spec), 0)
        self.assertEqual(list(self.directory(self.final).iterdir()), [])

    def test_consumed_marker_in_a_different_container_does_not_pass(self):
        device = Mock(udid="test-simulator")
        device.container.side_effect = [self.final, self.final, self.stale]
        process = Mock()
        process.poll.return_value = None

        def finish(*, timeout):
            directory = self.directory(self.final)
            (directory / f"{TOKEN}.key").unlink()
            (directory / f"{TOKEN}.consumed").touch()
            process.poll.return_value = 0
            return 0

        process.wait.side_effect = finish
        with (
            patch.object(poi_ios.subprocess, "Popen", return_value=process),
            patch.object(poi_ios, "result_category") as result,
            self.assertRaisesRegex(poi_ios.PoiRunnerError, "did not consume"),
        ):
            poi_ios.run_probe(device, TOKEN, KEY, self.scratch, self.spec)
        result.assert_not_called()
        self.assertEqual(list(self.directory(self.final).iterdir()), [])

    def test_cleanup_erases_staged_container_even_after_device_churn(self):
        directory = self.directory(self.final)
        (directory / f"{TOKEN}.key").write_bytes(KEY)
        (directory / f".{TOKEN}-interrupted").write_bytes(KEY)
        self.scratch.mkdir()
        (self.scratch / "container").write_text(str(self.final))
        self.spec.touch()
        device = Mock()
        device.validated_container.side_effect = lambda path: path
        poi_ios.cleanup(device, TOKEN, self.scratch, self.spec)
        self.assertEqual(list(directory.iterdir()), [])
        self.assertFalse(self.scratch.exists())
        self.assertFalse(self.spec.exists())
        device.terminate_app.assert_called_once()

    def test_xcresult_only_accepts_the_exact_probe_and_public_categories(self):
        for result, status, report in (
            (11, 65, {"testFailures": [{
                "testIdentifierString": TEST_CASE,
                "failureText": "failed - MAPKIT_TRUSTED_POI provider-or-network",
            }]}),
            (12, 65, {"testFailures": [{
                "testIdentifierString": TEST_CASE,
                "failureText": "failed - MAPKIT_TRUSTED_POI wrapper-or-result-shape",
            }]}),
            (70, 65, {"testFailures": [{
                "testIdentifierString": "OtherTests/testSomethingElse()",
                "failureText": "failed - MAPKIT_TRUSTED_POI provider-or-network",
            }]}),
            (0, 0, {"testNodes": [{"nodeType": "Test Case", "nodeIdentifier": TEST_CASE, "result": "Passed"}]}),
            (70, 0, {"testNodes": [{"nodeType": "Test Case", "nodeIdentifier": TEST_CASE, "result": "Skipped"}]}),
        ):
            command = Mock(returncode=0, stdout=json.dumps(report).encode())
            with patch.object(poi_ios, "run_command", return_value=command):
                self.assertEqual(poi_ios.result_category(self.root / "Result.xcresult", status), result)


if __name__ == "__main__":
    unittest.main()
