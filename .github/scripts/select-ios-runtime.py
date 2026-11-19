import argparse
import json
import os
import subprocess
from pathlib import Path


def simctl_state():
    return json.loads(
        subprocess.check_output(["xcrun", "simctl", "list", "-j"], text=True, timeout=30)
    )


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("profile", choices=["oldest", "current"])
    parser.add_argument("diagnostics", type=Path)
    arguments = parser.parse_args()
    state = simctl_state()
    candidates = []
    for runtime in state["runtimes"]:
        identifier = runtime["identifier"]
        if not runtime["isAvailable"] or ".SimRuntime.iOS-" not in identifier:
            continue
        phones = [
            device
            for device in state["devices"].get(identifier, [])
            if device["isAvailable"] and device["name"].startswith("iPhone")
        ]
        if not phones:
            continue
        version = tuple(int(component) for component in runtime["version"].split("."))
        if version[0] >= 16:
            candidates.append((version, runtime, phones))
    if not candidates:
        raise SystemExit("No available iPhone simulator runtime supports the interaction fixture (iOS 16+).")
    ranked = sorted(candidates, key=lambda candidate: candidate[0])
    _, runtime, phones = ranked[0 if arguments.profile == "oldest" else -1]
    device = min(phones, key=lambda phone: (phone["state"] != "Booted", phone["name"], phone["udid"]))
    udid = device["udid"]
    subprocess.run(["xcrun", "simctl", "bootstatus", udid, "-b"], check=True, timeout=480)
    actual = next(
        (
            phone
            for phone in simctl_state()["devices"].get(runtime["identifier"], [])
            if phone["udid"] == udid and phone["state"] == "Booted"
        ),
        None,
    )
    if actual is None:
        raise SystemExit("The chosen iPhone did not boot under its selected iOS runtime.")
    metadata = {
        "profile": arguments.profile,
        "device": actual["name"],
        "udid": udid,
        "runtime": runtime["identifier"],
        "version": runtime["version"],
        "build": runtime["buildversion"],
        "available_versions": [candidate[1]["version"] for candidate in ranked],
    }
    arguments.diagnostics.mkdir(parents=True, exist_ok=True)
    (arguments.diagnostics / "runtime.json").write_text(json.dumps(metadata, indent=2) + "\n")
    if output := os.environ.get("GITHUB_OUTPUT"):
        with open(output, "a", encoding="utf-8") as file:
            print(f"udid={udid}", file=file)
    line = f'{arguments.profile}: {actual["name"]}, iOS {runtime["version"]} ({runtime["buildversion"]}), {udid}'
    print(line)
    if summary := os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(summary, "a", encoding="utf-8") as file:
            print(line, file=file)
            if len(ranked) == 1:
                print("The runner has one compatible installed runtime, so both profiles select it.", file=file)


if __name__ == "__main__":
    main()
