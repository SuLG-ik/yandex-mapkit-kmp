import argparse
import json
import os
import shutil
import xml.etree.ElementTree as ET
from collections import defaultdict
from pathlib import Path


def android_results(source, attempt, marker, problems):
    tests = {}
    for report in sorted(source.rglob("TEST-*.xml")):
        if report.stat().st_mtime_ns < marker:
            continue
        saved = attempt / "junit" / report.relative_to(source)
        saved.parent.mkdir(parents=True, exist_ok=True)
        shutil.copyfile(report, saved)
        try:
            root = ET.parse(saved)
        except ET.ParseError as error:
            problems.append(f"Invalid JUnit report {report.name}: {error}")
            continue
        for case in root.iter("testcase"):
            suite, name = case.get("classname"), case.get("name")
            if not suite or not name:
                problems.append(f"JUnit test identity missing in {report.name}")
                continue
            if case.find("failure") is not None or case.find("error") is not None:
                outcome = "failed"
            elif case.find("skipped") is not None:
                outcome = "skipped"
            else:
                outcome = "passed"
            test = f"{suite}#{name}"
            if test in tests and tests[test] != outcome:
                problems.append(f"Conflicting JUnit results for {test} in one iteration")
                continue
            tests[test] = outcome
    return tests


def ios_results(source, problems):
    if not source.is_file():
        return {}
    try:
        root = json.loads(source.read_text())
    except (UnicodeDecodeError, json.JSONDecodeError) as error:
        problems.append(f"Invalid XCTest report: {error}")
        return {}
    tests = {}
    nodes = list(root.get("testNodes", []))
    while nodes:
        node = nodes.pop()
        if node.get("nodeType") != "Test Case":
            nodes.extend(node.get("children", []))
            continue
        test = node.get("nodeIdentifierURL") or node.get("nodeIdentifier")
        outcome = node.get("result", "").casefold()
        if outcome in {"expected failure", "not run"}:
            outcome = "skipped"
        if not test or outcome not in {"passed", "failed", "skipped"}:
            problems.append(f"Unrecognized XCTest result for {test or node.get('name', 'unnamed test')}")
            continue
        if test in tests and tests[test] != outcome:
            problems.append(f"Conflicting XCTest results for {test} in one iteration")
            continue
        tests[test] = outcome
    return tests


def record(arguments):
    problems = []
    if arguments.platform == "android":
        if arguments.since is None:
            raise SystemExit("Android results require a timestamp marker for the current iteration.")
        tests = android_results(arguments.source, arguments.attempt, arguments.since.stat().st_mtime_ns, problems)
    else:
        tests = ios_results(arguments.source, problems)
    if not tests:
        problems.append("No tests were reported.")
    failed = "failed" in tests.values()
    if arguments.status != 0 and not failed:
        problems.append(f"Runner exited {arguments.status} without a reported test failure.")
    if arguments.status == 0 and failed:
        problems.append("Runner exited successfully despite a reported test failure.")
    result = {"exit_status": arguments.status, "tests": tests, "infrastructure": problems}
    arguments.attempt.mkdir(parents=True, exist_ok=True)
    (arguments.attempt / "results.json").write_text(json.dumps(result, indent=2, sort_keys=True) + "\n")


def summarize(arguments):
    attempts = sorted(arguments.directory.glob("iteration-*/results.json"))
    outcomes = defaultdict(lambda: defaultdict(list))
    infrastructure = []
    reported_tests = {}
    if len(attempts) != arguments.iterations:
        infrastructure.append(f"Found {len(attempts)} of {arguments.iterations} iteration reports.")
    for path in attempts:
        attempt = path.parent.name
        result = json.loads(path.read_text())
        reported_tests[attempt] = set(result["tests"])
        infrastructure.extend(f"{attempt}: {problem}" for problem in result["infrastructure"])
        for test, outcome in result["tests"].items():
            outcomes[test][outcome].append(attempt)

    mixed = sorted(test for test, history in outcomes.items() if "passed" in history and "failed" in history)
    failures = sorted(test for test, history in outcomes.items() if "failed" in history)
    for attempt, tests in reported_tests.items():
        missing = set(outcomes) - tests
        if tests and missing:
            infrastructure.append(f"{attempt}: {len(missing)} tests observed in other iterations were not reported.")
    lines = [f"Repeated device tests: {len(attempts)} iterations, {len(failures)} tests failed at least once."]
    for test in mixed:
        passed = ", ".join(outcomes[test]["passed"])
        failed = ", ".join(outcomes[test]["failed"])
        lines.append(f"- Mixed result for {test} (passed in {passed}, failed in {failed}).")
    lines.extend(f"- Infrastructure: {problem}" for problem in infrastructure)
    summary = "\n".join(lines) + "\n"
    print(summary, end="")
    if path := os.environ.get("GITHUB_STEP_SUMMARY"):
        with open(path, "a", encoding="utf-8") as file:
            file.write(summary)
    (arguments.directory / "repetitions.txt").write_text(summary)
    return int(bool(failures or infrastructure))


def main():
    parser = argparse.ArgumentParser()
    commands = parser.add_subparsers(dest="command", required=True)
    record_parser = commands.add_parser("record")
    record_parser.add_argument("platform", choices=["android", "ios"])
    record_parser.add_argument("source", type=Path)
    record_parser.add_argument("attempt", type=Path)
    record_parser.add_argument("status", type=int)
    record_parser.add_argument("--since", type=Path)
    summarize_parser = commands.add_parser("summarize")
    summarize_parser.add_argument("directory", type=Path)
    summarize_parser.add_argument("iterations", type=int)
    arguments = parser.parse_args()
    if arguments.command == "record":
        record(arguments)
        return 0
    return summarize(arguments)


if __name__ == "__main__":
    raise SystemExit(main())
