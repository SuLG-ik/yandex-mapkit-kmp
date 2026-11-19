import errno
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
TEST_URL = "test://com.apple.xcode/MapInteractionApp/MapInteractionTests/MapInteractionTests/testTrustedBasemapPoiTap%28%29"
NOT_RUNNING = (
    b"An error was encountered processing the command (domain=NSPOSIXErrorDomain, code=3):\n"
    + f"Simulator device failed to terminate {poi_ios.PACKAGE}.\n".encode()
    + b"found nothing to terminate\n"
)
NESTED_DETAILS = (
    b"Underlying error (domain=NSPOSIXErrorDomain, code=3):\n"
    + f'\tThe request to terminate "{poi_ios.PACKAGE}" failed. found nothing to terminate\n'.encode()
    + b"\tfound nothing to terminate\n"
)
NESTED_NOT_RUNNING = (
    b"An error was encountered processing the command (domain=NSPOSIXErrorDomain, code=3):\n"
    b"Simulator device returned an error for the requested operation.\n"
    b"found nothing to terminate\n"
    + NESTED_DETAILS
)
COMBINED_NOT_RUNNING = NOT_RUNNING + NESTED_DETAILS


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

    def test_xctest_install_retries_timeouts_and_confirms_the_ready_container(self):
        device = Mock(udid="test-simulator")
        device.container.side_effect = [
            poi_ios.subprocess.TimeoutExpired("simctl", 5),
            None,
            self.stale,
            self.final,
            poi_ios.subprocess.TimeoutExpired("simctl", 5),
            self.final,
            self.final,
        ]
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
        for call in device.container.call_args_list[:-1]:
            self.assertGreater(call.kwargs["timeout"], 0)
            self.assertLessEqual(call.kwargs["timeout"], poi_ios.CONTAINER_QUERY_TIMEOUT)

    def test_launch_recoverable_timeouts_cannot_reset_the_absolute_deadline(self):
        device = Mock()
        process = Mock()
        process.poll.return_value = None
        clock = 0.0
        attempts = []

        def advance(seconds):
            nonlocal clock
            clock += seconds

        def lookup(*, timeout):
            attempts.append(timeout)
            advance(timeout)
            raise poi_ios.subprocess.TimeoutExpired("simctl", timeout)

        device.container.side_effect = lookup
        with (
            patch.object(poi_ios.time, "monotonic", side_effect=lambda: clock),
            patch.object(poi_ios.time, "sleep", side_effect=advance),
            self.assertRaisesRegex(poi_ios.PoiRunnerError, "did not launch"),
        ):
            poi_ios.wait_for_launch(device, process, TOKEN, deadline=7.0)
        self.assertEqual(attempts, [5.0, 1.75])
        self.assertEqual(clock, 7.0)

    def test_confirmation_timeout_does_not_allow_switching_ready_container(self):
        device = Mock()
        device.container.side_effect = [self.final, poi_ios.subprocess.TimeoutExpired("simctl", 5), self.stale]
        process = Mock()
        process.poll.return_value = None
        with (
            patch.object(poi_ios.time, "sleep"),
            self.assertRaisesRegex(poi_ios.PoiRunnerError, "container changed"),
        ):
            poi_ios.wait_for_launch(device, process, TOKEN, deadline=float("inf"))

    def test_launch_does_not_retry_an_invalid_container(self):
        device = Mock()
        device.container.side_effect = poi_ios.PoiRunnerError("outside the selected simulator")
        process = Mock()
        process.poll.return_value = None
        with self.assertRaisesRegex(poi_ios.PoiRunnerError, "outside the selected simulator"):
            poi_ios.wait_for_launch(device, process, TOKEN, deadline=float("inf"))
        device.container.assert_called_once()

    def test_launch_does_not_accept_ready_marker_after_xctest_exits(self):
        device = Mock()
        device.container.return_value = self.final
        process = Mock()
        process.poll.side_effect = [None, 0]
        with self.assertRaisesRegex(poi_ios.PoiRunnerError, "did not launch"):
            poi_ios.wait_for_launch(device, process, TOKEN, deadline=float("inf"))
        device.container.assert_called_once()

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
        device.container.return_value = self.stale
        poi_ios.cleanup(device, TOKEN, self.scratch, self.spec)
        self.assertEqual(list(directory.iterdir()), [])
        self.assertFalse(self.scratch.exists())
        self.assertFalse(self.spec.exists())
        device.terminate_app.assert_called_once()
        device.container.assert_called_once_with()

    def test_termination_accepts_success_and_the_specific_already_stopped_result(self):
        device = poi_ios.Simulator("test-simulator")
        for code, diagnosis in (
            (0, b""),
            (errno.ESRCH, NOT_RUNNING),
            (errno.ESRCH, NESTED_NOT_RUNNING),
            (errno.ESRCH, COMBINED_NOT_RUNNING),
        ):
            with self.subTest(code=code):
                result = Mock(returncode=code, stderr=diagnosis)
                with patch.object(poi_ios, "run_command", return_value=result) as command:
                    device.terminate_app()
                command.assert_called_once_with(
                    "xcrun", "simctl", "terminate", device.udid, poi_ios.PACKAGE, capture_error=True
                )

    def test_termination_rejects_esrch_without_the_exact_not_running_diagnosis(self):
        device = poi_ios.Simulator("test-simulator")
        for code, diagnosis in (
            (errno.ESRCH, NOT_RUNNING.replace(poi_ios.PACKAGE.encode(), b"some.other.app")),
            (errno.ESRCH, COMBINED_NOT_RUNNING.replace(f'"{poi_ios.PACKAGE}"'.encode(), b'"some.other.app"')),
            (errno.ESRCH, COMBINED_NOT_RUNNING + b"Unexpected simulator transport failure\n"),
            (errno.ESRCH, NOT_RUNNING + b"Unexpected simulator transport failure\n"),
            (1, NOT_RUNNING),
        ):
            with self.subTest(code=code, diagnosis=diagnosis):
                result = Mock(returncode=code, stderr=diagnosis)
                with patch.object(poi_ios, "run_command", return_value=result), self.assertRaisesRegex(
                    poi_ios.PoiRunnerError, "Could not confirm"
                ):
                    device.terminate_app()

    def test_cleanup_rereads_container_and_scrubs_both_when_termination_fails(self):
        self.scratch.mkdir()
        (self.scratch / "container").write_text(str(self.stale))
        self.spec.touch()
        for container in (self.stale, self.final):
            directory = self.directory(container)
            (directory / f"{TOKEN}.key").write_bytes(KEY)
            (directory / f".{TOKEN}-partial").write_bytes(KEY)
            (directory / f"{TOKEN}.ready").touch()
            (directory / f"{TOKEN}.consumed").touch()
        device = poi_ios.Simulator("test-simulator")
        device.app_data = self.root
        failed = Mock(returncode=1, stderr=b"simulator failure: " + KEY)
        lookup = Mock(returncode=0, stdout=str(self.final).encode())

        with patch.object(poi_ios, "run_command", side_effect=[failed, lookup]) as command:
            with self.assertRaisesRegex(poi_ios.PoiRunnerError, "Could not confirm") as error:
                poi_ios.cleanup(device, TOKEN, self.scratch, self.spec)
        self.assertNotIn(KEY.decode(), str(error.exception))
        self.assertEqual([call.args[2] for call in command.call_args_list], ["terminate", "get_app_container"])
        self.assertEqual(list(self.directory(self.stale).iterdir()), [self.directory(self.stale) / "previous.ready"])
        self.assertEqual(list(self.directory(self.final).iterdir()), [])
        self.assertFalse(self.scratch.exists())
        self.assertFalse(self.spec.exists())

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
            (70, 65, {"testFailures": [{
                "testIdentifierString": "OtherMapInteractionTests/testTrustedBasemapPoiTap()",
                "failureText": "failed - MAPKIT_TRUSTED_POI provider-or-network",
            }]}),
            (0, 0, {"testNodes": [{"nodeType": "Test Case", "nodeIdentifier": TEST_CASE, "result": "Passed"}]}),
            (0, 0, {"testNodes": [{"nodeType": "Test Case", "nodeIdentifierURL": TEST_URL, "result": "Passed"}]}),
            (70, 0, {"testNodes": [{
                "nodeType": "Test Case",
                "nodeIdentifierURL": TEST_URL.replace("/MapInteractionTests/test", "/OtherMapInteractionTests/test"),
                "result": "Passed",
            }]}),
            (70, 0, {"testNodes": [{"nodeType": "Test Case", "nodeIdentifier": TEST_CASE, "result": "Skipped"}]}),
        ):
            command = Mock(returncode=0, stdout=json.dumps(report).encode())
            with patch.object(poi_ios, "run_command", return_value=command):
                self.assertEqual(poi_ios.result_category(self.root / "Result.xcresult", status), result)


if __name__ == "__main__":
    unittest.main()
