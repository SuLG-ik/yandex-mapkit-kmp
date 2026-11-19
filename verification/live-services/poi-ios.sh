#!/usr/bin/env bash
set -euo pipefail
set +x

device=${1:?Provide an iOS simulator UUID}
token=${MAPKIT_LIVE_SEARCH_TOKEN:?Launch through the trusted checker}
[[ "$token" =~ ^[0-9]+-[0-9]+$ ]]
bundle=ru.sulgik.mapkit.test.mapinteractionapp
products="tests/map-interaction/build/xcode/Build/Products"
run_file="$products/mapkit-poi-$token.xctestrun"
scratch="${RUNNER_TEMP:?}/mapkit-poi-$token"

if [[ "${2:-}" == --cleanup ]]; then
    rm -f -- "$run_file"
    rm -rf -- "$scratch"
    xcrun simctl terminate "$device" "$bundle" >/dev/null 2>&1 || true
    container=$(xcrun simctl get_app_container "$device" "$bundle" data)
    [[ -n "$container" && -d "$container" ]]
    rm -f -- "$container/Library/Caches/mapkit-poi-key-$token"
    exit 0
fi

key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY

shopt -s nullglob
runs=()
for path in "$products/"*.xctestrun; do
    [[ "$path" != "$products/mapkit-poi-"*.xctestrun ]] || continue
    runs+=("$path")
done
[[ ${#runs[@]} == 1 ]]
app="$products/Debug-iphonesimulator/MapInteractionApp.app"
[[ -d "$app" ]]
umask 077
mkdir "$scratch"

python3 - "${runs[0]}" "$run_file" "$token" <<'PY'
import plistlib
import sys
from pathlib import Path

base, destination, run_id = sys.argv[1:]
data = plistlib.loads(Path(base).read_bytes())
targets = [
    target
    for configuration in data.get("TestConfigurations", [])
    for target in configuration.get("TestTargets", [])
    if target.get("BlueprintName") == "MapInteractionTests"
    or target.get("TestBundlePath", "").endswith("/MapInteractionTests.xctest")
]
if isinstance(data.get("MapInteractionTests"), dict):
    targets.append(data["MapInteractionTests"])
if len(targets) != 1:
    raise SystemExit(70)
targets[0].setdefault("EnvironmentVariables", {})["MAPKIT_TRUSTED_POI_RUN_ID"] = run_id
Path(destination).write_bytes(plistlib.dumps(data))
PY

xcrun simctl install "$device" "$app" >/dev/null
container=$(xcrun simctl get_app_container "$device" "$bundle" data)
[[ -n "$container" && -d "$container" ]]
mkdir -p "$container/Library/Caches"
handoff="$container/Library/Caches/mapkit-poi-key-$token"
printf '%s' "$key" > "$handoff"
unset key

status=0
xcodebuild test-without-building -xctestrun "$run_file" \
    -destination "platform=iOS Simulator,id=$device" \
    -parallel-testing-enabled NO \
    -only-testing:MapInteractionTests/MapInteractionTests/testTrustedBasemapPoiTap \
    -resultBundlePath "$scratch/Result.xcresult" \
    > "$scratch/xcodebuild.log" 2>&1 || status=$?

if (( status != 0 )); then
    if grep -Fq 'MAPKIT_TRUSTED_POI provider-or-network' "$scratch/xcodebuild.log"; then
        exit 11
    fi
    if grep -Fq 'MAPKIT_TRUSTED_POI wrapper-or-result-shape' "$scratch/xcodebuild.log"; then
        exit 12
    fi
    exit 70
fi

[[ ! -e "$handoff" ]] || exit 70
xcrun xcresulttool get test-results tests --path "$scratch/Result.xcresult" > "$scratch/results.json"
python3 - "$scratch/results.json" <<'PY'
import json
import sys
from pathlib import Path
from urllib.parse import unquote

report = json.loads(Path(sys.argv[1]).read_text())
nodes = list(report.get("testNodes", []))
outcomes = []
while nodes:
    node = nodes.pop()
    nodes.extend(node.get("children", []))
    if node.get("nodeType") != "Test Case":
        continue
    identifier = unquote(node.get("nodeIdentifierURL") or node.get("nodeIdentifier") or "")
    if identifier.removesuffix("()").endswith("MapInteractionTests/testTrustedBasemapPoiTap"):
        outcomes.append(node.get("result", "").casefold())

if outcomes != ["passed"]:
    raise SystemExit(70)
PY
