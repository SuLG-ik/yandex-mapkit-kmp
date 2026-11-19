#!/usr/bin/env bash
set -euo pipefail
set +x

device=${1:?Provide an Android emulator serial}
probe=${2:?Provide a Full service probe}
package=ru.sulgik.liteconsumer
token=${MAPKIT_LIVE_SEARCH_TOKEN:?Launch through the trusted checker}
[[ "$token" =~ ^[0-9]+-[0-9]+$ ]]

case "$probe" in
    search) marker=LIVE_SEARCH; launch=liveSearch; attempts=65; modes=(text suggestions) ;;
    routing) marker=LIVE_ROUTING; launch=liveRouting; attempts=90; modes=(driving walking cycling transit) ;;
    *) exit 70 ;;
esac
key_file="files/live-$probe-key"
result="files/$token-$marker"

if [[ "${3:-}" == --cleanup ]]; then
    adb -s "$device" shell am force-stop "$package" >/dev/null 2>&1 || true
    files=("$key_file" "$result")
    for mode in "${modes[@]}"; do files+=("$result-$mode"); done
    adb -s "$device" shell -T "run-as $package rm -f ${files[*]}" >/dev/null
    exit 0
fi

app=${MAPKIT_LIVE_SEARCH_APP:?Prepare the Full service APK without credentials first}
key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY

adb -s "$device" install -r "$app" >/dev/null
ready=$(printf '%s' "$key" | adb -s "$device" shell -T \
    "run-as $package sh -c 'umask 077; mkdir -p files && cat > $key_file && echo key-ready'")
unset key
[[ "$ready" == key-ready ]]
adb -s "$device" shell am start -W -S -n "$package/.MainActivity" \
    --es smokeToken "$token" --ez "$launch" true >/dev/null

for ((attempt = 0; attempt < attempts; attempt++)); do
    status=$(adb -s "$device" exec-out "run-as $package cat $result" 2>/dev/null || true)
    case "$status" in
        0)
            for mode in "${modes[@]}"; do
                mode_status=$(adb -s "$device" exec-out "run-as $package cat $result-$mode" 2>/dev/null || true)
                [[ "$mode_status" == 0 ]] || exit 70
            done
            exit 0
            ;;
        10|11|12|70) exit "$status" ;;
    esac
    sleep 1
done
exit 70
