"""Summarize the return-to-map sample's opt-in measurement lines."""

import argparse
from collections import Counter, defaultdict
from pathlib import Path
from statistics import median


PREFIX = "MAPKIT_RETURN_METRIC|"
CASE_ORDER = ("cold", "reopen", "retained", "restart")
TIMINGS = ("mount_ms", "overlay_ms", "ready_ms", "tap_ms", "tile_ms")
SDK_TIMINGS = (
    "geometry_ms",
    "placemarks_ms",
    "labels_ms",
    "delayed_geometry_ms",
    "models_ms",
    "fully_loaded_ms",
    "fully_appeared_ms",
)
COUNTS = ("mounts", "markers", "icons", "render_objects", "tile_bytes")
NUMERIC_FIELDS = TIMINGS + SDK_TIMINGS + COUNTS
PAIRED_TIMINGS = {
    "mount_to_overlay_ms": ("overlay_ms", "mount_ms"),
    "ready_to_tap_ms": ("tap_ms", "ready_ms"),
    "ready_to_tiles_ms": ("tile_ms", "ready_ms"),
}
FIELDS = set(NUMERIC_FIELDS) | {"id", "case", "mode", "sdk", "viewport", "tiles", "end"}


def read_records(paths):
    records = {}
    for path in paths:
        with path.open(encoding="utf-8") as lines:
            for number, line in enumerate(lines, 1):
                if PREFIX not in line:
                    continue
                try:
                    record = parse_record(line.split(PREFIX, 1)[1].strip())
                except ValueError as error:
                    raise ValueError(f"{path}:{number}: invalid metric: {error}") from error
                previous = records.setdefault(record["id"], record)
                if record != previous:
                    raise ValueError(f"{path}:{number}: conflicting data for id {record['id']}")
    return list(records.values())


def parse_record(encoded):
    record = {}
    for field in encoded.split("|"):
        key, value = field.split("=", 1)
        if key in record or not value:
            raise ValueError(f"duplicate or empty field {key!r}")
        record[key] = int(value) if key in NUMERIC_FIELDS and value != "na" else value
    if record.keys() != FIELDS:
        raise ValueError(f"expected fields {sorted(FIELDS)}")
    if record["case"] not in CASE_ORDER:
        raise ValueError(f"unknown case {record['case']!r}")
    for field, (end, start) in PAIRED_TIMINGS.items():
        values = (record[end], record[start])
        record[field] = values[0] - values[1] if all(isinstance(value, int) for value in values) else "na"
    return record


def stats(records, field):
    values = [record[field] for record in records if isinstance(record[field], int)]
    if not values:
        return f"missing (0/{len(records)})"
    return f"{median(values):g} [{min(values)}–{max(values)}] ({len(values)}/{len(records)})"


def print_summary(records):
    groups = defaultdict(list)
    for record in records:
        groups[(record["sdk"], record["mode"])].append(record)
    for (sdk, mode), group in sorted(groups.items()):
        viewports = {row["viewport"] for row in group if row["viewport"] != "0x0"}
        if len(viewports) > 1:
            raise ValueError(f"mixed viewports for SDK {sdk} / {mode}: {', '.join(sorted(viewports))}")
        viewport = next(iter(viewports), "unknown")
        for case in CASE_ORDER:
            trials = [record for record in group if record["case"] == case]
            if not trials:
                continue
            tiles = ", ".join(f"{status}={count}" for status, count in sorted(Counter(
                record["tiles"] for record in trials
            ).items()))
            print(f"\n### {case} · {mode} · {sdk} · {viewport}")
            print(f"\nTrials: {len(trials)}. Deadlines: {sum(row['end'] == 'deadline' for row in trials)}. Tiles: {tiles}.")
            print("\n| Metric | Median [min–max] (observations/trials) |\n|---|---|")
            for field in NUMERIC_FIELDS + tuple(PAIRED_TIMINGS):
                print(f"| {field} | {stats(trials, field)} |")


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--device", required=True, help="One platform, device model and OS version per report")
    parser.add_argument("--revision", required=True, help="Git revision of the built sample")
    parser.add_argument("logs", nargs="+", type=Path)
    args = parser.parse_args()
    try:
        records = read_records(args.logs)
        if not records:
            raise ValueError(f"no {PREFIX} records found")
        print(f"# Return-to-map measurements\n\nDevice: {args.device}. Revision: {args.revision}.")
        print_summary(records)
    except (OSError, ValueError) as error:
        parser.exit(2, f"{error}\n")


if __name__ == "__main__":
    main()
