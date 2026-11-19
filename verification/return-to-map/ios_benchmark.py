"""Run the existing sample's real-tile benchmark on a disposable hosted iPhone simulator."""

import argparse
from contextlib import redirect_stdout
import json
import os
from pathlib import Path
import plistlib
import re
import stat
import subprocess
import tempfile
import time

from summarize import CASE_ORDER, NUMERIC_FIELDS, PREFIX, TEXT_FIELDS, parse_record, print_summary


COHORT_COUNT = 5
PACKAGE = "ru.sulgik.ymk.sample.sample"
TEST_TARGET = "ReturnMapBenchmarkTests"
KEY_FILES = ("cold.key", "restart.key")
COHORT_TIMEOUT = 300
OUTPUT = Path("build/return-to-map/ios")


class BenchmarkError(RuntimeError):
    pass


def read_runner_key(path):
    root = Path(os.environ["RUNNER_TEMP"]).resolve()
    if path.parent.resolve() != root or not path.name.startswith("mapkit-service-key."):
        raise BenchmarkError("Invalid runner credential handoff path.")
    try:
        mode = path.lstat().st_mode
        if not stat.S_ISREG(mode) or mode & 0o077:
            raise BenchmarkError("The runner credential handoff must be a private regular file.")
        key = path.read_bytes()
    finally:
        path.unlink(missing_ok=True)
    if not key.strip():
        raise BenchmarkError("MAPKIT_TEST_API_KEY is unset.")
    return key


def run_command(*command, timeout=60, check=True):
    try:
        result = subprocess.run(command, stdout=subprocess.PIPE, stderr=subprocess.DEVNULL, timeout=timeout)
    except (subprocess.TimeoutExpired, OSError) as error:
        raise BenchmarkError(f"{command[0]} could not start or exceeded its deadline.") from error
    if check and result.returncode:
        raise BenchmarkError(f"{command[0]} failed.")
    return result


class Simulator:
    def __init__(self, udid):
        self.udid = udid
        self.app_data = (
            Path.home() / "Library/Developer/CoreSimulator/Devices" / udid / "data/Containers/Data/Application"
        ).resolve()

    def simctl(self, *arguments, check=True):
        return run_command("xcrun", "simctl", arguments[0], self.udid, *arguments[1:], check=check)

    def container(self, *, required=True):
        result = self.simctl("get_app_container", PACKAGE, "data", check=required)
        if result.returncode:
            return None
        try:
            path = Path(os.fsdecode(result.stdout).strip()).resolve(strict=True)
        except FileNotFoundError:
            if required:
                raise
            return None
        if path.parent != self.app_data:
            raise BenchmarkError("The sample data container is outside the selected simulator.")
        return path

    def remove_app(self):
        self.simctl("uninstall", PACKAGE, check=False)
        if self.simctl("get_app_container", PACKAGE, "data", check=False).returncode == 0:
            raise BenchmarkError("The sample remained installed after removal.")


def test_spec_for(source, cohort):
    spec = plistlib.loads(source.read_bytes())
    if "TestConfigurations" in spec:
        targets = [target for config in spec["TestConfigurations"] for target in config["TestTargets"]]
        target = targets[0] if len(targets) == 1 and targets[0].get("BlueprintName") == TEST_TARGET else None
    else:
        target = spec.get(TEST_TARGET)
    if target is None:
        raise BenchmarkError("The build did not produce the expected sample UI test target.")
    target.setdefault("EnvironmentVariables", {})["MAPKIT_RETURN_COHORT"] = cohort
    target["SystemAttachmentLifetime"] = "keepNever"
    target["UserAttachmentLifetime"] = "keepNever"
    return plistlib.dumps(spec)


def wait_for_launch(device, process, phase, deadline, expected_container=None):
    while process.poll() is None and time.monotonic() < deadline:
        container = device.container(required=False)
        if container is not None:
            if expected_container is not None and container != expected_container:
                raise BenchmarkError("The restart changed the sample's data container.")
            directory = container / "Library/ReturnMapBenchmark"
            if (directory / f"{phase}.ready").is_file():
                if directory.resolve() != directory:
                    raise BenchmarkError("The credential directory is outside the sample container.")
                return container
        time.sleep(0.25)
    raise BenchmarkError(f"XCUITest did not start a ready {phase} app process.")


def stage_key(directory, phase, key):
    with tempfile.NamedTemporaryFile(dir=directory, prefix=f".{phase}-") as pending:
        pending.write(key)
        pending.flush()
        os.link(pending.name, directory / f"{phase}.key")


def stop_process(process):
    if process is not None and process.poll() is None:
        process.terminate()
        try:
            process.wait(timeout=10)
        except subprocess.TimeoutExpired:
            process.kill()
            process.wait()


def collect_rows(directory, cohort, seen):
    metrics = directory / "baseline.metrics"
    if not metrics.exists():
        return []
    rows = []
    for line in metrics.read_text(encoding="utf-8").split("\n")[:-1]:
        if not line.startswith(PREFIX):
            raise BenchmarkError("The sample wrote a non-metric row.")
        row = parse_record(line[len(PREFIX):])
        if row["cohort"] != cohort or row["id"] in seen:
            raise BenchmarkError("The sample reported a stale or duplicate metric row.")
        seen[row["id"]] = row
        rows.append(row)
    return rows


def is_complete(rows):
    if tuple(row["case"] for row in rows) != CASE_ORDER:
        return False
    if len({(row["cohort"], row["viewport"], row["sdk"]) for row in rows}) != 1:
        return False
    process_ids = [row["id"].rsplit("-", 1)[0] for row in rows]
    if len(set(process_ids[:3])) != 1 or process_ids[-1] == process_ids[0]:
        return False
    for row in rows:
        if row["mode"] != "real" or row["end"] != "complete" or row["viewport"] == "0x0":
            return False
        if row["ready_ms"] == "na" or row["tap_ms"] == "na" or row["tap_ms"] < row["ready_ms"]:
            return False
        counters = (row["mounts"], row["markers"], row["icons"])
        if row["case"] == "retained":
            if counters != (0, 0, 0) or row["tiles"] != "retained":
                return False
        elif counters != (1, 3, 1) or row["tiles"] != "loaded" or row["tile_ms"] == "na":
            return False
    return True


def run_cohort(device, test_spec, cohort, key, seen, containers, private_root):
    spec = test_spec.with_name(f"ReturnMapBenchmark-{cohort}.xctestrun")
    spec.write_bytes(test_spec_for(test_spec, cohort))
    process = None
    directory = None
    try:
        device.remove_app()
        deadline = time.monotonic() + COHORT_TIMEOUT
        process = subprocess.Popen(
            [
                "xcodebuild", "test-without-building", "-xctestrun", str(spec),
                "-destination", f"platform=iOS Simulator,id={device.udid}",
                "-parallel-testing-enabled", "NO",
                "-resultBundlePath", str(private_root / f"{cohort}.xcresult"),
            ],
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL,
        )
        container = wait_for_launch(device, process, "cold", deadline)
        if container in containers:
            raise BenchmarkError("The cold trial reused a previous sample app container.")
        containers.add(container)
        directory = container / "Library/ReturnMapBenchmark"
        stage_key(directory, "cold", key)
        wait_for_launch(device, process, "restart", deadline, expected_container=container)
        if (directory / "cold.key").exists():
            raise BenchmarkError("The cold app process did not consume its credential handoff.")
        stage_key(directory, "restart", key)
        if process.wait(timeout=max(0, deadline - time.monotonic())):
            raise BenchmarkError("XCUITest did not finish the four native tap scenarios.")
        if device.container() != container:
            raise BenchmarkError("The XCUITest run replaced the installed app's data container.")
        if (directory / "restart.key").exists():
            raise BenchmarkError("The restarted app process did not consume its credential handoff.")
    except subprocess.TimeoutExpired as error:
        raise BenchmarkError("XCUITest exceeded the cohort deadline.") from error
    finally:
        try:
            stop_process(process)
        finally:
            spec.unlink(missing_ok=True)
            try:
                rows = collect_rows(directory, cohort, seen) if directory is not None else []
            finally:
                if directory is not None:
                    for name in KEY_FILES:
                        (directory / name).unlink(missing_ok=True)
                device.remove_app()
    return is_complete(rows)


def write_results(seen, complete, device_label, revision, key):
    rows = tuple(seen.values())
    payload = "".join(
        PREFIX + "|".join(f"{field}={row[field]}" for field in TEXT_FIELDS + NUMERIC_FIELDS) + "\n"
        for row in rows
    )
    matched = [row for row in rows if complete.get(row["cohort"])]
    mixed = len({(row["viewport"], row["sdk"]) for row in matched}) > 1
    if key and key in (payload + device_label).encode():
        raise BenchmarkError("A captured value matches the credential. No benchmark artifacts were written.")
    OUTPUT.mkdir(parents=True, exist_ok=True)
    (OUTPUT / "baseline.metrics").write_text(payload, encoding="utf-8")
    with (OUTPUT / "summary.md").open("w", encoding="utf-8") as report, redirect_stdout(report):
        print("# iOS return-to-map observations\n")
        print(f"Runtime: {device_label}. Revision: {revision}.")
        print("XCUITest waits 350 ms after observing the viewport-ready prompt before sending a native tap.")
        print(f"Complete cold/warm/retained/restart cohorts: {sum(complete.values())}/{COHORT_COUNT}.")
        for cohort, passed in complete.items():
            print(f"- {cohort}: {'complete' if passed else 'incomplete'}")
        if mixed:
            print("\nThe complete cohorts used different measured viewports or SDK versions. No pooled baseline was calculated.")
        elif matched:
            print_summary(matched)
    return not mixed and sum(complete.values()) == COHORT_COUNT


def get_device_label(device, metadata):
    runtime = json.loads(metadata.read_bytes())
    state = json.loads(run_command("xcrun", "simctl", "list", "devices", "booted", "-j").stdout)
    matches = [
        phone for phone in state["devices"].get(runtime["runtime"], [])
        if phone["udid"] == device.udid and phone["name"] == runtime["device"] and phone["state"] == "Booted"
    ]
    if len(matches) != 1 or runtime["udid"] != device.udid or not runtime["device"].startswith("iPhone"):
        raise BenchmarkError("The selected iPhone simulator is not booted on the measured runtime.")
    return f'{runtime["device"]} Simulator, iOS {runtime["version"]} ({runtime["build"]})'


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("device")
    parser.add_argument("test_spec", type=Path)
    parser.add_argument("runtime_metadata", type=Path)
    parser.add_argument("--key-file", type=Path, required=True)
    arguments = parser.parse_args()

    revision = os.environ.get("GITHUB_SHA", "")
    if (
        os.environ.get("GITHUB_ACTIONS") != "true"
        or os.environ.get("GITHUB_REPOSITORY", "").lower() != "sulg-ik/yandex-mapkit-kmp"
        or os.environ.get("GITHUB_REF") != "refs/heads/main"
        or os.environ.get("GITHUB_EVENT_NAME") != "workflow_dispatch"
        or re.fullmatch("[0-9A-Fa-f]{8}(?:-[0-9A-Fa-f]{4}){3}-[0-9A-Fa-f]{12}", arguments.device) is None
        or re.fullmatch("[0-9a-f]{40}", revision) is None
    ):
        raise SystemExit("This benchmark runs only on a trusted manual main-branch iPhone simulator.")

    seen = {}
    complete = {}
    containers = set()
    device_label = "iPhone simulator"
    key = None
    device = Simulator(arguments.device)
    try:
        key = read_runner_key(arguments.key_file)
        device_label = get_device_label(device, arguments.runtime_metadata)
        with tempfile.TemporaryDirectory(prefix="mapkit-return-xcresults-", dir=os.environ["RUNNER_TEMP"]) as temporary:
            for number in range(1, COHORT_COUNT + 1):
                cohort = f"trial_{number:02d}"
                try:
                    complete[cohort] = run_cohort(
                        device, arguments.test_spec, cohort, key, seen, containers, Path(temporary)
                    )
                except BenchmarkError as error:
                    print(f"{cohort}: {error}")
                    complete[cohort] = False
                except (KeyError, OSError, ValueError):
                    print(f"{cohort}: Could not process the simulator data or test configuration.")
                    complete[cohort] = False
                print(f"{cohort}: {'complete' if complete[cohort] else 'incomplete'}")
    except (BenchmarkError, KeyError, OSError, ValueError):
        print("The iPhone runtime or the benchmark credential could not be prepared.")

    try:
        passed = write_results(seen, complete, device_label, revision, key)
    except BenchmarkError as error:
        raise SystemExit(str(error)) from None
    if not passed:
        raise SystemExit("The iOS real-tile baseline is incomplete. Review the extracted metric rows.")


if __name__ == "__main__":
    main()
