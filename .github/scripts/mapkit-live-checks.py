import argparse
import json
import os
import signal
import subprocess
import time
from pathlib import Path


CHECKS = ("search", "routing", "poi")
HOOK_DIRECTORY = Path("verification/live-services")
EXIT_CATEGORIES = {
    0: "passed",
    10: "authorization",
    11: "provider-or-network",
    12: "wrapper-or-result-shape",
}


def hook(check, platform):
    return HOOK_DIRECTORY / f"{check}-{platform}.sh"


def emit_summary(line):
    print(line)
    if summary := os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(summary, "a", encoding="utf-8") as file:
            print(line, file=file)


def is_trusted():
    return (
        os.environ.get("GITHUB_ACTIONS") == "true"
        and os.environ.get("GITHUB_REPOSITORY", "").lower() == "sulg-ik/yandex-mapkit-kmp"
        and os.environ.get("GITHUB_REF") == "refs/heads/main"
        and os.environ.get("GITHUB_EVENT_NAME") in {"schedule", "workflow_dispatch"}
    )


def run_process(command, environment, timeout):
    try:
        process = subprocess.Popen(
            command,
            stdin=subprocess.DEVNULL,
            stdout=subprocess.DEVNULL,
            stderr=subprocess.DEVNULL,
            start_new_session=True,
            env=environment,
        )
        return process.wait(timeout=timeout)
    except subprocess.TimeoutExpired:
        try:
            os.killpg(process.pid, signal.SIGKILL)
        except ProcessLookupError:
            pass
        try:
            process.wait(timeout=2)
        except subprocess.TimeoutExpired:
            pass
        return None
    except OSError:
        return 70


def run_check(check, platform, device, api_key):
    command = ["bash", str(hook(check, platform)), device]
    environment = dict(os.environ, MAPKIT_LIVE_SEARCH_TOKEN=f"{time.time_ns()}-{os.getpid()}")
    environment.pop("MAPKIT_TEST_API_KEY", None)
    environment.pop("MAPKIT_LIVE_KEY_FILE", None)
    status = run_process(command, dict(environment, MAPKIT_TEST_API_KEY=api_key), timeout=120)
    category = "runner-deadline" if status is None else EXIT_CATEGORIES.get(status, "runner-or-fixture")
    if run_process(command + ["--cleanup"], environment, timeout=15) != 0:
        return f"{category}-cleanup-incomplete"
    return category


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("mode", choices=["plan", "run"])
    parser.add_argument("platform", choices=["android", "ios"])
    parser.add_argument("device", nargs="?")
    parser.add_argument("--key-file", type=Path)
    arguments = parser.parse_args()
    platform = arguments.platform
    available = {check for check in CHECKS if hook(check, platform).is_file()}
    api_key = os.environ.get("MAPKIT_TEST_API_KEY", "")
    if not is_trusted():
        skip = "untrusted execution context"
    elif arguments.mode == "run" and arguments.key_file is not None:
        key_file = arguments.key_file
        runner_temp = Path(os.environ["RUNNER_TEMP"]).resolve()
        if (
            key_file.is_symlink()
            or key_file.parent.resolve() != runner_temp
            or not key_file.name.startswith("mapkit-service-key.")
        ):
            raise SystemExit("Invalid runner credential handoff path.")
        try:
            api_key = key_file.read_text(encoding="utf-8")
        finally:
            key_file.unlink(missing_ok=True)
        if not api_key.strip():
            raise SystemExit("The trusted runner credential handoff was empty.")
        skip = None if available else "no service hooks have landed for this platform"
    elif not api_key.strip():
        skip = "MAPKIT_TEST_API_KEY is unset"
    elif not available:
        skip = "no service hooks have landed for this platform"
    else:
        skip = None
    if arguments.mode == "plan":
        with open(os.environ["GITHUB_OUTPUT"], "a", encoding="utf-8") as output:
            print(f"enabled={'true' if skip is None else 'false'}", file=output)
        if skip:
            emit_summary(f"MapKit live checks on {platform}: skipped ({skip}).")
        return
    if skip:
        emit_summary(f"MapKit live checks on {platform}: skipped ({skip}).")
        return
    if arguments.device is None:
        parser.error("run requires a device identifier")
    results = {}
    for check in CHECKS:
        result = run_check(check, platform, arguments.device, api_key) if check in available else "skipped-no-hook"
        results[check] = result
        emit_summary(f"MapKit live {check} on {platform}: {result}.")
    diagnostics = Path("build/device-matrix/live") / platform
    diagnostics.mkdir(parents=True, exist_ok=True)
    (diagnostics / "results.json").write_text(json.dumps(results, indent=2) + "\n")
    if any(result not in {"passed", "skipped-no-hook"} for result in results.values()):
        raise SystemExit(1)


if __name__ == "__main__":
    main()
