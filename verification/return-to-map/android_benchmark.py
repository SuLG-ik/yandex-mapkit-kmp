"""Drive the existing sample benchmark on a disposable hosted Android emulator."""

import argparse
from contextlib import redirect_stdout
import os
from pathlib import Path
import re
import stat
import subprocess
import time
from xml.etree import ElementTree

from summarize import CASE_ORDER, NUMERIC_FIELDS, PREFIX, TEXT_FIELDS, parse_record, print_summary


PACKAGE = "ru.sulgik.ymk.sample"
KEY_PATH = "files/return-map-benchmark-key"
METRIC_PATH = "files/return-map-benchmark.metrics"
UI_PATH = "/data/local/tmp/mapkit-return-benchmark.xml"
OUTPUT = Path("build/return-to-map/android")
COHORT_INPUT = "Return map benchmark cohort"
VIEWPORT = "Return map benchmark viewport"
READY = "Tap near the map center once"
COHORT_COUNT = 5


class BenchmarkError(RuntimeError):
    pass


def read_runner_key(path):
    runner_temp = Path(os.environ["RUNNER_TEMP"]).resolve()
    if path.parent.resolve() != runner_temp or not path.name.startswith("mapkit-service-key."):
        raise BenchmarkError("Invalid runner credential handoff path.")
    try:
        mode = path.lstat().st_mode
        if not stat.S_ISREG(mode) or mode & 0o077:
            raise BenchmarkError("The runner credential handoff must be a private regular file.")
        key = path.read_bytes()
    except OSError as error:
        raise BenchmarkError("Cannot read the runner credential handoff.") from error
    finally:
        path.unlink(missing_ok=True)
    if not key.strip():
        raise BenchmarkError("MAPKIT_TEST_API_KEY is unset.")
    return key


class Device:
    def __init__(self, serial):
        self.serial = serial

    def adb(self, *arguments, data=None, optional=False, timeout=20, preserve_output=False):
        try:
            result = subprocess.run(
                ["adb", "-s", self.serial, *arguments],
                input=data,
                stdout=subprocess.PIPE,
                stderr=subprocess.DEVNULL,
                timeout=timeout,
                check=False,
            )
        except (subprocess.TimeoutExpired, OSError) as error:
            if optional:
                return ""
            raise BenchmarkError("An Android runner command exceeded its deadline or could not start.") from error
        if result.returncode:
            if optional:
                return ""
            raise BenchmarkError("An Android runner command failed.")
        output = result.stdout.decode("utf-8", errors="replace")
        return output if preserve_output else output.strip()

    def clear(self):
        if self.adb("shell", "pm", "clear", PACKAGE) != "Success":
            raise BenchmarkError("Could not clear the sample app's data for the cold trial.")

    def stop(self):
        self.adb("shell", "am", "force-stop", PACKAGE)
        if self.adb("shell", "pidof", PACKAGE, optional=True):
            raise BenchmarkError("The sample app remained running after force-stop.")

    def launch(self, key):
        command = (
            f"run-as {PACKAGE} sh -c 'umask 077; mkdir -p files && "
            f"cat > {KEY_PATH} && echo key-ready'"
        )
        if self.adb("shell", "-T", command, data=key) != "key-ready":
            raise BenchmarkError("Could not stage the private benchmark key.")
        self.adb("shell", "am", "start", "-W", "-n", f"{PACKAGE}/.MainActivity", timeout=45)
        self.adb("shell", "-T", f"run-as {PACKAGE} test ! -e {KEY_PATH}")

    def read_ui(self):
        self.adb("shell", "rm", "-f", UI_PATH, optional=True)
        self.adb("shell", "uiautomator", "dump", UI_PATH, optional=True, timeout=12)
        payload = self.adb("exec-out", "cat", UI_PATH, optional=True)
        try:
            return ElementTree.fromstring(payload)
        except ElementTree.ParseError:
            return None

    def tap_label(self, label, *, when=None):
        deadline = time.monotonic() + 35
        while time.monotonic() < deadline:
            tree = self.read_ui()
            if tree is not None and (when is None or bounds_for_label(tree, when)):
                point = bounds_for_label(tree, label)
                if point is not None:
                    if when == READY:
                        time.sleep(0.35)
                    self.adb("shell", "input", "tap", *(str(value) for value in point))
                    return
            time.sleep(0.2)
        raise BenchmarkError(f"The benchmark did not expose the expected UI control: {label}.")

    def open_first_trial(self, cohort, button, key):
        self.launch(key)
        self.tap_label("Measure return to map")
        self.tap_label("Native view only")
        self.tap_label(COHORT_INPUT)
        self.adb("shell", "input", "text", cohort)
        self.tap_label(button)

    def read_metrics(self):
        payload = self.adb("exec-out", "run-as", PACKAGE, "cat", METRIC_PATH, optional=True, preserve_output=True)
        complete_lines = payload.split("\n")[:-1]
        return [parse_record(line[len(PREFIX):]) for line in complete_lines if line.startswith(PREFIX)]

    def collect(self, cohort, case, seen):
        self.tap_label(VIEWPORT, when=READY)
        deadline = time.monotonic() + 35
        while time.monotonic() < deadline:
            for record in self.read_metrics():
                if record["cohort"] == cohort and record["case"] == case and record["id"] not in seen:
                    seen[record["id"]] = record
                    return record
            time.sleep(0.2)
        raise BenchmarkError(f"No metric row for the {case} trial.")

    def cleanup(self):
        self.adb("shell", "am", "force-stop", PACKAGE, optional=True)
        self.adb("shell", "-T", f"run-as {PACKAGE} rm -f {KEY_PATH}", optional=True)
        self.adb("shell", "rm", "-f", UI_PATH, optional=True)


def bounds_for_label(tree, label):
    for node in tree.iter("node"):
        if node.get("package") != PACKAGE or label not in {node.get("text"), node.get("content-desc")}:
            continue
        match = re.fullmatch(r"\[(\d+),(\d+)\]\[(\d+),(\d+)\]", node.get("bounds", ""))
        if match is None:
            continue
        left, top, right, bottom = map(int, match.groups())
        if label == VIEWPORT and right - left != bottom - top:
            continue
        if right > left and bottom > top:
            return ((left + right) // 2, (top + bottom) // 2)
    return None


def run_cohort(device, key, cohort, seen):
    device.clear()
    device.open_first_trial(cohort, "Open after clearing app data", key)
    cold = device.collect(cohort, "cold", seen)

    device.tap_label("Details (unmount map)")
    device.tap_label("Return to map")
    reopen = device.collect(cohort, "reopen", seen)

    device.tap_label("Other tab (retain map)")
    device.tap_label("Return to map")
    retained = device.collect(cohort, "retained", seen)

    device.stop()
    device.open_first_trial(cohort, "Open after process restart", key)
    restart = device.collect(cohort, "restart", seen)
    return cold, reopen, retained, restart


def is_complete(cohort):
    if tuple(row["case"] for row in cohort) != CASE_ORDER:
        return False
    if len({(row["cohort"], row["viewport"], row["sdk"]) for row in cohort}) != 1:
        return False
    for row in cohort:
        if row["mode"] != "real" or row["end"] != "complete" or row["ready_ms"] == "na" or row["tap_ms"] == "na":
            return False
        if row["case"] == "retained":
            if row["mounts"] != 0 or row["tiles"] != "retained":
                return False
        elif row["mounts"] != 1 or row["tiles"] != "loaded" or row["tile_ms"] == "na":
            return False
    return True


def write_results(seen, status, device_label, revision, key):
    OUTPUT.mkdir(parents=True, exist_ok=True)
    rows = tuple(seen.values())
    payload = "".join(
        PREFIX + "|".join(f"{field}={row[field]}" for field in TEXT_FIELDS + NUMERIC_FIELDS) + "\n"
        for row in rows
    )
    if key and key in (payload + device_label).encode():
        raise BenchmarkError("A captured value matches the credential. No benchmark artifacts were written.")
    (OUTPUT / "baseline.metrics").write_text(payload, encoding="utf-8")
    with (OUTPUT / "summary.md").open("w", encoding="utf-8") as report, redirect_stdout(report):
        print("# Android return-to-map observations\n")
        print(f"Runtime: {device_label}. Revision: {revision}.")
        print("Input driver waits 350 ms after seeing the viewport-ready prompt.")
        print(f"Complete cold/warm/retained/restart cohorts: {sum(status.values())}/{COHORT_COUNT}.")
        for cohort, complete in status.items():
            print(f"- {cohort}: {'complete' if complete else 'incomplete'}")
        matched = [row for row in rows if status.get(row["cohort"])]
        if matched:
            try:
                print_summary(matched)
            except ValueError:
                print("\nThe captures could not be grouped at the same viewport and SDK.")


def main():
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("device")
    parser.add_argument("apk", type=Path)
    parser.add_argument("--key-file", type=Path, required=True)
    arguments = parser.parse_args()
    if (
        os.environ.get("GITHUB_ACTIONS") != "true"
        or os.environ.get("GITHUB_REPOSITORY", "").lower() != "sulg-ik/yandex-mapkit-kmp"
        or os.environ.get("GITHUB_REF") != "refs/heads/main"
        or os.environ.get("GITHUB_EVENT_NAME") != "workflow_dispatch"
        or re.fullmatch(r"emulator-[0-9]+", arguments.device) is None
    ):
        raise SystemExit("This benchmark runs only on a trusted manual main-branch emulator.")
    revision = os.environ.get("GITHUB_SHA", "")
    if re.fullmatch(r"[a-f0-9]{40}", revision) is None:
        raise SystemExit("The hosted run did not provide a revision.")

    device = Device(arguments.device)
    seen = {}
    status = {}
    device_label = "Android emulator"
    key = None
    can_cleanup = False
    try:
        key = read_runner_key(arguments.key_file)
        if device.adb("shell", "getprop", "ro.kernel.qemu") != "1" and device.adb(
            "shell", "getprop", "ro.boot.qemu"
        ) != "1":
            raise BenchmarkError("This benchmark requires a disposable emulator.")
        can_cleanup = True
        model = device.adb("shell", "getprop", "ro.product.model")
        runtime = device.adb("shell", "getprop", "ro.build.version.release")
        api = device.adb("shell", "getprop", "ro.build.version.sdk")
        device_label = f"{model}, Android {runtime} (API {api})"
        device.adb("install", "-r", str(arguments.apk), timeout=90)
        for number in range(1, COHORT_COUNT + 1):
            cohort = f"trial_{number:02d}"
            try:
                status[cohort] = is_complete(run_cohort(device, key, cohort, seen))
            except (BenchmarkError, ValueError):
                status[cohort] = False
                try:
                    seen.update({row["id"]: row for row in device.read_metrics() if row["cohort"] == cohort})
                except (BenchmarkError, ValueError):
                    pass
                device.cleanup()
            print(f"{cohort}: {'complete' if status[cohort] else 'incomplete'}")
    except BenchmarkError as error:
        print(error)
    finally:
        if can_cleanup:
            device.cleanup()
            device.adb("shell", "pm", "clear", PACKAGE, optional=True)
        try:
            write_results(seen, status, device_label, revision, key)
        except BenchmarkError as error:
            raise SystemExit(str(error)) from None
    if sum(status.values()) != COHORT_COUNT:
        raise SystemExit("The real-tile baseline is incomplete. Review the extracted metric rows.")


if __name__ == "__main__":
    main()
