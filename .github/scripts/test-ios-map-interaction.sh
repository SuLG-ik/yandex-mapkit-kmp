#!/usr/bin/env bash
set -euo pipefail

fixture="tests/map-interaction"
if [[ $# -ne 1 ]]; then
  echo "Usage: bash .github/scripts/test-ios-map-interaction.sh <simulator UDID>" >&2
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

xcodebuild test-without-building "${xcode_args[@]}" \
  -resultBundlePath "$fixture/build/MapInteraction-$(date +%s).xcresult"
