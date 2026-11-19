#!/usr/bin/env bash
set -euo pipefail

expected_api=${1:?Usage: bash .github/scripts/test-android-navigation-matrix.sh <expected API>}
diagnostics=build/device-matrix/android
mkdir -p "$diagnostics"
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

adb -e logcat -b all -v threadtime > "$diagnostics/logcat.txt" &
logcat_pid=$!
trap 'kill "$logcat_pid" 2>/dev/null || true; wait "$logcat_pid" 2>/dev/null || true' EXIT

passed=0
failed=0
reports=yandex-mapkit-kmp-compose/build/reports/androidTests/connected
for attempt in 1 2 3; do
  if ./gradlew :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest --rerun -PskipIosTarget=true \
    2>&1 | tee "$diagnostics/iteration-$attempt.log"; then
    passed=$((passed + 1))
  else
    failed=$((failed + 1))
  fi
  if [[ -d "$reports" ]]; then
    cp -R "$reports" "$diagnostics/report-$attempt"
  fi
done

summary="Android Compose device suite repetitions: $passed passed, $failed failed."
echo "$summary"
if [[ -n "${GITHUB_STEP_SUMMARY:-}" ]]; then
  echo "$summary" >> "$GITHUB_STEP_SUMMARY"
fi
if (( passed > 0 && failed > 0 )); then
  echo "::warning::Android device suite repetitions had mixed outcomes. Compare the per-run reports."
fi
test "$failed" -eq 0
