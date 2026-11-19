"""Run the trusted iOS basemap probe after XCTest launches its own simulator app."""

import errno
import json
import os
from pathlib import Path
import plistlib
import re
import shutil
import stat
import subprocess
import sys
import tempfile
import time
from urllib.parse import unquote


PACKAGE = "ru.sulgik.mapkit.test.mapinteractionapp"
TARGET = "MapInteractionTests"
PRODUCTS = Path("tests/map-interaction/build/xcode/Build/Products")
POI_DIRECTORY = Path("Library/TrustedPoi")
RUN_TIMEOUT = 110
READY_TIMEOUT = 45


class PoiRunnerError(RuntimeError):
    pass


def run_command(*command, timeout=5, capture_error=False):
    return subprocess.run(
        command,
        check=False,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE if capture_error else subprocess.DEVNULL,
        timeout=timeout,
    )


def already_stopped(result):
    if result.returncode != errno.ESRCH:
        return False
    lines = [line.strip() for line in result.stderr.splitlines() if line.strip()]
    domain = b"NSPOSIXErrorDomain, code=3"
    reported = b"An error was encountered processing the command (domain=" + domain + b"):"
    absent = b"found nothing to terminate"
    return lines in (
        [reported, f"Simulator device failed to terminate {PACKAGE}.".encode(), absent],
        [
            reported,
            b"Simulator device returned an error for the requested operation.",
            absent,
            b"Underlying error (domain=" + domain + b"):",
            f'The request to terminate "{PACKAGE}" failed. found nothing to terminate'.encode(),
            absent,
        ],
    )


class Simulator:
    def __init__(self, udid):
        self.udid = udid
        self.app_data = (
            Path.home() / "Library/Developer/CoreSimulator/Devices" / udid / "data/Containers/Data/Application"
        ).resolve()

    def validated_container(self, path):
        container = path.resolve()
        if container.parent != self.app_data:
            raise PoiRunnerError("The POI app container is outside the selected simulator.")
        return container

    def container(self):
        result = run_command("xcrun", "simctl", "get_app_container", self.udid, PACKAGE, "data")
        if result.returncode:
            return None
        container = self.validated_container(Path(os.fsdecode(result.stdout).strip()))
        return container if container.is_dir() else None

    def terminate_app(self):
        result = run_command("xcrun", "simctl", "terminate", self.udid, PACKAGE, capture_error=True)
        if result.returncode and not already_stopped(result):
            raise PoiRunnerError("Could not confirm the POI app stopped during cleanup.")


def test_spec_with_run_id(source, token):
    data = plistlib.loads(source.read_bytes())
    targets = [
        target
        for configuration in data.get("TestConfigurations", [])
        for target in configuration.get("TestTargets", [])
        if target.get("BlueprintName") == TARGET
        or target.get("TestBundlePath", "").endswith(f"/{TARGET}.xctest")
    ]
    if isinstance(data.get(TARGET), dict):
        targets.append(data[TARGET])
    if len(targets) != 1:
        raise PoiRunnerError("Expected the map interaction UI test target.")
    target = targets[0]
    target.setdefault("EnvironmentVariables", {})["MAPKIT_TRUSTED_POI_RUN_ID"] = token
    target["SystemAttachmentLifetime"] = "keepNever"
    target["UserAttachmentLifetime"] = "keepNever"
    return plistlib.dumps(data)


def poi_directory(container):
    directory = container / POI_DIRECTORY
    if directory.resolve() != directory:
        raise PoiRunnerError("The POI credential directory is outside its app container.")
    return directory


def has_regular_file(path):
    try:
        return stat.S_ISREG(path.lstat().st_mode)
    except FileNotFoundError:
        return False


def wait_for_launch(device, process, token, deadline):
    while process.poll() is None and time.monotonic() < deadline:
        container = device.container()
        if container is not None and has_regular_file(poi_directory(container) / f"{token}.ready"):
            return container
        time.sleep(0.25)
    raise PoiRunnerError("XCUITest did not launch a ready POI app.")


def stage_key(directory, token, key):
    with tempfile.NamedTemporaryFile(dir=directory, prefix=f".{token}-") as pending:
        pending.write(key)
        pending.flush()
        os.link(pending.name, directory / f"{token}.key")


def stop_process(process):
    if process is None or process.poll() is not None:
        return
    process.terminate()
    try:
        process.wait(timeout=3)
    except subprocess.TimeoutExpired:
        process.kill()
        process.wait(timeout=2)


def is_probe(identifier):
    probe = f"{TARGET}/testTrustedBasemapPoiTap"
    normalized = unquote(identifier).removesuffix("()")
    return normalized == probe or (normalized.startswith("test://") and normalized.endswith(f"/{probe}"))


def result_category(bundle, status):
    report = run_command(
        "xcrun", "xcresulttool", "get", "test-results", "summary" if status else "tests",
        "--path", str(bundle), timeout=5,
    )
    if report.returncode:
        return 70
    output = json.loads(report.stdout)
    if status:
        messages = [
            failure.get("failureText", "")
            for failure in output.get("testFailures", [])
            if is_probe(failure.get("testIdentifierURL") or failure.get("testIdentifierString") or "")
        ]
        if any("MAPKIT_TRUSTED_POI provider-or-network" in message for message in messages):
            return 11
        if any("MAPKIT_TRUSTED_POI wrapper-or-result-shape" in message for message in messages):
            return 12
        return 70

    outcomes = []
    nodes = list(output.get("testNodes", []))
    while nodes:
        node = nodes.pop()
        nodes.extend(node.get("children", []))
        identifier = node.get("nodeIdentifierURL") or node.get("nodeIdentifier") or ""
        if node.get("nodeType") == "Test Case" and is_probe(identifier):
            outcomes.append(node.get("result", "").casefold())
    return 0 if outcomes == ["passed"] else 70


def erase_handoff(directory, token):
    for suffix in ("key", "ready", "consumed"):
        (directory / f"{token}.{suffix}").unlink(missing_ok=True)
    for temporary in directory.glob(f".{token}-*"):
        temporary.unlink(missing_ok=True)


def run_probe(device, token, key, scratch, spec):
    sources = [path for path in PRODUCTS.glob("*.xctestrun") if not path.name.startswith("mapkit-poi-")]
    if len(sources) != 1:
        raise PoiRunnerError("Expected one credential-free XCTest specification.")
    scratch.mkdir()
    spec.write_bytes(test_spec_with_run_id(sources[0], token))
    bundle = scratch / "Result.xcresult"
    deadline = time.monotonic() + RUN_TIMEOUT
    process = None
    directory = None
    try:
        process = subprocess.Popen(
            [
                "xcodebuild", "test-without-building", "-xctestrun", str(spec),
                "-destination", f"platform=iOS Simulator,id={device.udid}",
                "-parallel-testing-enabled", "NO",
                f"-only-testing:{TARGET}/{TARGET}/testTrustedBasemapPoiTap",
                "-resultBundlePath", str(bundle),
            ],
            stdin=subprocess.DEVNULL, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL,
        )
        container = wait_for_launch(device, process, token, min(deadline, time.monotonic() + READY_TIMEOUT))
        if device.container() != container:
            raise PoiRunnerError("The POI app container changed after launch.")
        directory = poi_directory(container)
        (scratch / "container").write_text(str(container), encoding="utf-8")
        stage_key(directory, token, key)
        status = process.wait(timeout=max(0, deadline - time.monotonic()))
        if (
            device.container() != container
            or (directory / f"{token}.key").exists()
            or not has_regular_file(directory / f"{token}.consumed")
        ):
            raise PoiRunnerError("The final POI app did not consume its credential handoff.")
        return result_category(bundle, status)
    finally:
        try:
            stop_process(process)
        finally:
            if directory is not None:
                erase_handoff(directory, token)


def erase_device_handoffs(device, token, pointer):
    staged = None
    try:
        if pointer.is_file():
            staged = device.validated_container(Path(pointer.read_text(encoding="utf-8")))
            erase_handoff(poi_directory(staged), token)
    finally:
        current = device.container()
        if current is not None and current != staged:
            erase_handoff(poi_directory(current), token)


def cleanup(device, token, scratch, spec):
    try:
        device.terminate_app()
    finally:
        try:
            erase_device_handoffs(device, token, scratch / "container")
        finally:
            try:
                spec.unlink(missing_ok=True)
            finally:
                if scratch.exists():
                    shutil.rmtree(scratch)


def main():
    key = os.environ.pop("MAPKIT_TEST_API_KEY", "")
    token = os.environ.get("MAPKIT_LIVE_SEARCH_TOKEN", "")
    arguments = sys.argv[1:]
    if not arguments or len(arguments) > 2 or (len(arguments) == 2 and arguments[1] != "--cleanup"):
        return 70
    if (
        re.fullmatch(r"[0-9]+-[0-9]+", token) is None
        or re.fullmatch(r"[0-9A-Fa-f]{8}(?:-[0-9A-Fa-f]{4}){3}-[0-9A-Fa-f]{12}", arguments[0]) is None
    ):
        return 70
    try:
        os.umask(0o077)
        device = Simulator(arguments[0])
        scratch = Path(os.environ["RUNNER_TEMP"]) / f"mapkit-poi-{token}"
        spec = PRODUCTS / f"mapkit-poi-{token}.xctestrun"
        if arguments[1:] == ["--cleanup"]:
            cleanup(device, token, scratch, spec)
            return 0
        if not key.strip():
            return 70
        return run_probe(device, token, key.encode(), scratch, spec)
    except (KeyError, OSError, PoiRunnerError, subprocess.SubprocessError, ValueError):
        return 70


if __name__ == "__main__":
    raise SystemExit(main())
