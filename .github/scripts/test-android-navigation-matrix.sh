#!/usr/bin/env bash
set -euo pipefail

expected_api=${1:?Usage: bash .github/scripts/test-android-navigation-matrix.sh <expected API>}
diagnostics=build/device-matrix/android
mkdir -p "$diagnostics"
python3 .github/scripts/prepare-android-emulator.py "$diagnostics/logcat.txt"
adb -e logcat -b all -v threadtime > "$diagnostics/logcat.txt" &
logcat_pid=$!
trap 'kill "$logcat_pid" 2>/dev/null || true; wait "$logcat_pid" 2>/dev/null || true' EXIT

actual_api=$(adb -e shell getprop ro.build.version.sdk | tr -d '\r')
release=$(adb -e shell getprop ro.build.version.release | tr -d '\r')
abi=$(adb -e shell getprop ro.product.cpu.abi | tr -d '\r')
runtime="Android $release, API $actual_api, ABI $abi (expected API $expected_api)"
echo "$runtime" | tee "$diagnostics/runtime.txt"
if [[ -n "${GITHUB_STEP_SUMMARY:-}" ]]; then
  echo "$runtime" >> "$GITHUB_STEP_SUMMARY"
fi
if [[ "$actual_api" != "$expected_api" ]]; then
  echo "::error::The Android emulator booted a different API level."
  exit 1
fi

attempts="$diagnostics/$(date +%s)-$$"
results=yandex-mapkit-kmp-compose/build/outputs/androidTest-results/connected
reports=yandex-mapkit-kmp-compose/build/reports/androidTests/connected
for attempt in 1 2 3; do
  iteration="$attempts/iteration-$attempt"
  mkdir -p "$iteration"
  touch "$iteration/started"
  status=0
  ./gradlew :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest --rerun -PskipIosTarget=true \
    2>&1 | tee "$iteration/gradle.log" || status=$?
  if [[ -d "$reports" ]]; then
    cp -R "$reports" "$iteration/report"
  fi
  python3 .github/scripts/device-test-results.py record android "$results" "$iteration" "$status" \
    --since "$iteration/started"
done
python3 .github/scripts/device-test-results.py summarize "$attempts" 3
