import argparse
import subprocess
import sys
import time
from pathlib import Path


ANIMATION_SCALES = ("window_animation_scale", "transition_animation_scale", "animator_duration_scale")


def adb_shell(deadline, *command):
    remaining = deadline - time.monotonic()
    if remaining <= 0:
        raise TimeoutError("Android test service readiness deadline expired.")
    result = subprocess.run(
        ["adb", "-e", "shell", *command],
        capture_output=True,
        check=True,
        text=True,
        timeout=min(remaining, 5),
    )
    return result.stdout.strip()


def prepare(deadline):
    if adb_shell(deadline, "getprop", "sys.boot_completed") != "1":
        raise RuntimeError("Android boot is still in progress.")
    adb_shell(deadline, "settings", "get", "global", ANIMATION_SCALES[0])
    for scale in ANIMATION_SCALES:
        adb_shell(deadline, "settings", "put", "global", scale, "0.0")
    for scale in ANIMATION_SCALES:
        if adb_shell(deadline, "settings", "get", "global", scale) not in {"0", "0.0"}:
            raise RuntimeError(f"The Settings service did not retain {scale}=0.0.")


def collect_failure_log(path, reason):
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("w", encoding="utf-8") as log:
        print(f"Android emulator preparation failed. {reason}", file=log, flush=True)
        try:
            subprocess.run(
                ["adb", "-e", "logcat", "-d", "-b", "all", "-v", "threadtime"],
                stdout=log,
                stderr=subprocess.STDOUT,
                timeout=10,
                check=True,
            )
        except (OSError, subprocess.SubprocessError) as error:
            print(f"Could not collect the emulator logcat snapshot: {error}", file=log)


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("failure_log", type=Path)
    arguments = parser.parse_args()
    deadline = time.monotonic() + 60
    last_failure = "Android test services were not ready."
    while time.monotonic() < deadline:
        try:
            prepare(deadline)
        except (RuntimeError, subprocess.SubprocessError) as error:
            stderr = getattr(error, "stderr", None)
            if isinstance(stderr, bytes):
                stderr = stderr.decode(errors="replace")
            last_failure = stderr or str(error)
            print(f"Waiting for Android test services. {last_failure.strip()}", file=sys.stderr)
            time.sleep(min(2, max(0, deadline - time.monotonic())))
        except OSError as error:
            last_failure = str(error)
            break
        else:
            print("Android test services are ready and animation scales are zero.")
            return 0

    collect_failure_log(arguments.failure_log, last_failure.strip())
    print(f"Android test services did not become ready. See {arguments.failure_log}.", file=sys.stderr)
    return 1


if __name__ == "__main__":
    raise SystemExit(main())
