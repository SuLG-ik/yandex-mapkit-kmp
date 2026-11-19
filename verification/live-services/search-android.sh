#!/usr/bin/env bash
set -euo pipefail
set +x

device=${1:?Provide an Android emulator serial}
app=${MAPKIT_LIVE_SEARCH_APP:?Prepare the Full search APK without credentials first}
key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY
package=ru.sulgik.liteconsumer
token="$(date +%s)-$$"
result="files/$token-LIVE_SEARCH"
cleanup() {
    adb -s "$device" shell am force-stop "$package" >/dev/null 2>&1 || true
    adb -s "$device" shell "run-as $package rm -f files/live-search-key $result" >/dev/null 2>&1 || true
}
trap cleanup EXIT

adb -s "$device" install -r "$app" >/dev/null
printf '%s' "$key" | adb -s "$device" exec-in "run-as $package sh -c 'umask 077; mkdir -p files && cat > files/live-search-key'"
unset key
adb -s "$device" shell am start -W -S -n "$package/.MainActivity" \
    --es smokeToken "$token" --ez liveSearch true >/dev/null

for attempt in {1..45}; do
    status=$(adb -s "$device" exec-out "run-as $package cat $result" 2>/dev/null || true)
    case "$status" in
        0|10|11|12|70) exit "$status" ;;
    esac
    sleep 1
done
exit 70
