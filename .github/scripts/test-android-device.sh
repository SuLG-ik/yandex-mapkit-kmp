#!/usr/bin/env bash
set -eu

# The action shuts down the emulator as soon as this script returns.
adb -e logcat -b all -v threadtime > "${RUNNER_TEMP}/android-emulator-logcat.txt" &
logcat_pid=$!
trap 'kill "$logcat_pid" 2>/dev/null || true; wait "$logcat_pid" 2>/dev/null || true' EXIT

./gradlew :yandex-mapkit-kmp:connectedAndroidDeviceTest :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest -PskipIosTarget=true

bash verification/lite-consumer/run.sh android "$(adb -e get-serialno)"
