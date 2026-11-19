#!/usr/bin/env bash
set -eu

mode=${1:-ci}
case "$mode" in
  ci|release) ;;
  *)
    echo "Usage: bash .github/scripts/test-android-device.sh [ci|release]" >&2
    exit 2
    ;;
esac

# The action shuts down the emulator as soon as this script returns.
logcat_path="${RUNNER_TEMP}/android-emulator-logcat.txt"
python3 .github/scripts/prepare-android-emulator.py "$logcat_path"
adb -e logcat -b all -v threadtime > "$logcat_path" &
logcat_pid=$!
trap 'kill "$logcat_pid" 2>/dev/null || true; wait "$logcat_pid" 2>/dev/null || true' EXIT

./gradlew :yandex-mapkit-kmp:connectedAndroidDeviceTest :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest -PskipIosTarget=true

device=$(adb -e get-serialno)
bash verification/lite-consumer/run.sh android "$device"
if [[ "$mode" == release ]]; then
  bash verification/lite-consumer/run.sh android "$device" with-integrations full
fi
