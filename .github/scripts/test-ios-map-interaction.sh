#!/usr/bin/env bash
set -euo pipefail

fixture="tests/map-interaction"
iterations=${2:-1}
if [[ $# -lt 1 || $# -gt 2 || ! "$iterations" =~ ^[1-9][0-9]*$ ]]; then
  echo "Usage: bash .github/scripts/test-ios-map-interaction.sh <simulator UDID> [iterations]" >&2
  exit 2
fi

device="$1"
diagnostics="$fixture/build/interaction-diagnostics"
mkdir -p "$diagnostics"

collect_diagnostics() {
  status=$?
  if (( status != 0 )); then
    xcrun simctl spawn "$device" log show --last 10m --style compact \
      --predicate 'process == "MapInteractionApp" OR (process == "testmanagerd" AND eventMessage CONTAINS "ru.sulgik.mapkit.test.mapinteractionapp")' \
      > "$diagnostics/simulator.log" 2>&1 || true
  fi
  exit "$status"
}
trap collect_diagnostics EXIT

./gradlew ":tests:map-interaction:podInstall"
xcode_args=(
  -workspace "$fixture/iosApp/MapInteractionApp.xcworkspace"
  -scheme MapInteractionApp
  -destination "platform=iOS Simulator,id=$device"
  -parallel-testing-enabled NO
  -derivedDataPath "$fixture/build/xcode"
)
xcodebuild build-for-testing "${xcode_args[@]}"

info_plist="$fixture/build/xcode/Build/Products/Debug-iphonesimulator/MapInteractionApp.app/Info.plist"
plutil -p "$info_plist" > "$diagnostics/Info.plist.txt"
for key in CFBundleShortVersionString CFBundleVersion; do
  version=$(plutil -extract "$key" raw -expect string -o - "$info_plist")
  test -n "$version"
done
test "$(plutil -extract CADisableMinimumFrameDurationOnPhone raw -expect bool -o - "$info_plist")" = true

run_id="$(date +%s)-$$"
passed=0
failed=0
for (( attempt = 1; attempt <= iterations; attempt++ )); do
  result="$fixture/build/MapInteraction-$run_id-$attempt.xcresult"
  if xcodebuild test-without-building "${xcode_args[@]}" -resultBundlePath "$result" \
    2>&1 | tee "$diagnostics/iteration-$attempt.log"; then
    passed=$((passed + 1))
  else
    failed=$((failed + 1))
  fi
  if [[ -d "$result" ]]; then
    xcrun xcresulttool get test-results summary --path "$result" \
      > "$diagnostics/iteration-$attempt.json" || true
  fi
done

summary="UIKit map interaction repetitions: $passed passed, $failed failed."
echo "$summary"
if [[ -n "${GITHUB_STEP_SUMMARY:-}" ]]; then
  echo "$summary" >> "$GITHUB_STEP_SUMMARY"
fi
if (( passed > 0 && failed > 0 )); then
  echo "::warning::UIKit map interaction repetitions had mixed outcomes. Compare the per-run result bundles."
fi
test "$failed" -eq 0
