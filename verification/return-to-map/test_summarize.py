from contextlib import redirect_stdout
from io import StringIO
import unittest

from summarize import FIELDS, parse_record, print_summary


def trial(trial_id, phase, tile_ms, mount_ms=10, end="complete"):
    fields = dict.fromkeys(FIELDS, "na")
    fields.update(
        id=trial_id,
        cohort="test_01",
        case="reopen",
        mode="real",
        sdk="4.45.0",
        scope="post_init",
        viewport="260x260",
        tile_registered=phase,
        tiles="timeout" if end == "deadline" else "loaded",
        end=end,
        ready_ms=20,
        tile_ms=tile_ms,
        mount_ms=mount_ms,
    )
    return parse_record("|".join(f"{key}={value}" for key, value in fields.items()))


class TileRegistrationSummaryTest(unittest.TestCase):
    def test_separates_tile_metrics_by_phase_and_pools_route_metrics(self):
        output = StringIO()
        with redirect_stdout(output):
            print_summary([
                trial("a1-1", "mount", 35),
                trial("a1-2", "ready", 250, mount_ms=18),
                trial("a1-3", "ready", "na", mount_ms=14, end="deadline"),
            ])

        route, stages = output.getvalue().split("#### Tile metrics · registered at mount")
        mount, ready = stages.split("#### Tile metrics · registered at ready")
        self.assertIn("| mount_ms | 14 [10–18] (3/3) |", route)
        self.assertNotIn("| tile_ms |", route)
        self.assertNotIn("| ready_to_tiles_ms |", route)
        self.assertIn("| tile_ms | 35 [35–35] (1/1) |", mount)
        self.assertIn("| ready_to_tiles_ms | 15 [15–15] (1/1) |", mount)
        self.assertIn("| tile_ms | 250 [250–250] (1/2) |", ready)
        self.assertIn("| ready_to_tiles_ms | 230 [230–230] (1/2) |", ready)
        self.assertNotIn("142.5", output.getvalue())


if __name__ == "__main__":
    unittest.main()
