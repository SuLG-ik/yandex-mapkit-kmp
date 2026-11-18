#!/usr/bin/env bash
set -euo pipefail

fixture="tests/map-interaction"
if [[ $# -ne 1 ]]; then
  echo "Usage: bash .github/scripts/test-ios-map-interaction.sh <simulator UDID>" >&2
  exit 2
fi

./gradlew ":tests:map-interaction:podInstall"
mkdir -p "$fixture/build"
xcodebuild test \
  -workspace "$fixture/iosApp/MapInteractionApp.xcworkspace" \
  -scheme MapInteractionApp \
  -destination "platform=iOS Simulator,id=$1" \
  -parallel-testing-enabled NO \
  -derivedDataPath "$fixture/build/xcode" \
  -resultBundlePath "$fixture/build/MapInteraction-$(date +%s).xcresult"
