import importlib.util
import os
from pathlib import Path
import unittest
from unittest.mock import patch


SCRIPT = Path(__file__).resolve().parents[2] / ".github/scripts/mapkit-live-checks.py"
SPEC = importlib.util.spec_from_file_location("live_checks", SCRIPT)
live_checks = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(live_checks)


class RoutingDiagnosticsTest(unittest.TestCase):
    def test_provider_no_route_keeps_mixed_modes_and_discards_unrecognized_markers(self):
        self.assertEqual(
            self.run_routing(13, "driving 0\nwalking 13\ncycling 12\ntransit unknown\nother 0\n"),
            ("provider-no-route", {
                "driving": "passed",
                "walking": "provider-no-route",
                "cycling": "wrapper-or-result-shape",
                "transit": "not-run",
            }),
        )

    def test_runner_deadline_keeps_completed_modes_when_cleanup_fails(self):
        self.assertEqual(
            self.run_routing(None, "driving 11\n", cleanup_status=70),
            ("runner-deadline-cleanup-incomplete", {
                "driving": "provider-or-network",
                "walking": "not-run",
                "cycling": "not-run",
                "transit": "not-run",
            }),
        )

    def run_routing(self, status, markers, cleanup_status=0):
        calls = []

        def fixture(command, environment, timeout, stdout=None):
            calls.append(command[-1])
            self.assertNotIn("MAPKIT_LIVE_KEY_FILE", environment)
            if command[-1] == "fixture-device":
                self.assertEqual(environment["MAPKIT_TEST_API_KEY"], "fixture")
                return status
            self.assertNotIn("MAPKIT_TEST_API_KEY", environment)
            if command[-1] == "--modes":
                stdout.write(markers)
                return 0
            return cleanup_status

        with patch.dict(os.environ, MAPKIT_TEST_API_KEY="inherited", MAPKIT_LIVE_KEY_FILE="handoff"):
            with patch.object(live_checks, "run_process", side_effect=fixture):
                result = live_checks.run_check("routing", "ios", "fixture-device", "fixture")
        self.assertEqual(calls, ["fixture-device", "--modes", "--cleanup"])
        return result


if __name__ == "__main__":
    unittest.main()
