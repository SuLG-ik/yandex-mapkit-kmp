#!/usr/bin/env bash
set -euo pipefail

sdk_package=${1:?Provide the installed Android SDK package version}
target=${2:?Provide the installed Android system image target}
sdk=${ANDROID_HOME:?The runner must have the Android SDK configured}
serial=emulator-5556
name=mapkit-live-service

if [[ -n "${MAPKIT_TEST_API_KEY+x}" || -n "${MAPKIT_LIVE_KEY_FILE+x}" ]]; then
    echo "Boot the emulator before staging the test credential." >&2
    exit 1
fi
if timeout 5 adb -s "$serial" get-state >/dev/null 2>&1; then
    echo "The Android service emulator's port is already in use." >&2
    exit 1
fi
image="system-images;android-$sdk_package;$target;x86_64"
printf 'no\n' | "$sdk/cmdline-tools/latest/bin/avdmanager" create avd --force --name "$name" --package "$image" --device pixel_7
log="${RUNNER_TEMP:?}/mapkit-service-emulator.log"
nohup "$sdk/emulator/emulator" -avd "$name" -port 5556 -memory 4096 \
    -no-window -gpu swiftshader_indirect -no-snapshot -noaudio -no-boot-anim > "$log" 2>&1 < /dev/null &
pid=$!
trap 'kill "$pid" 2>/dev/null || true' EXIT
deadline=$((SECONDS + 180))
while (( SECONDS < deadline )); do
    status=$(timeout 5 adb -s "$serial" shell getprop sys.boot_completed 2>/dev/null | tr -d '\r' || true)
    if [[ "$status" == 1 ]] && timeout 5 adb -s "$serial" shell pm path android >/dev/null 2>&1; then
        timeout 5 adb -s "$serial" shell input keyevent 82
        printf 'serial=%s\n' "$serial" >> "$GITHUB_OUTPUT"
        trap - EXIT
        exit 0
    fi
    if ! kill -0 "$pid" 2>/dev/null; then
        break
    fi
    sleep 2
done
echo "The dedicated Android service emulator did not become ready. See $log." >&2
exit 1
