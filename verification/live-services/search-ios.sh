#!/usr/bin/env bash
set -euo pipefail
set +x

device=${1:?Provide an iOS simulator UUID}
package=ru.sulgik.liteconsumer
token=${MAPKIT_LIVE_SEARCH_TOKEN:?Launch through the trusted checker}
[[ "$token" =~ ^[0-9]+-[0-9]+$ ]]

if [[ "${2:-}" == --cleanup ]]; then
    xcrun simctl terminate "$device" "$package" >/dev/null 2>&1 || true
    app_data=$(xcrun simctl get_app_container "$device" "$package" data)
    [[ -n "$app_data" && -d "$app_data" ]]
    temporary="$app_data/tmp"
    rm -f -- "$temporary/live-search-key" "$temporary/$token-LIVE_SEARCH-"{0,10,11,12,70}
    exit 0
fi

app=${MAPKIT_LIVE_SEARCH_APP:?Prepare the Full search app without credentials first}
key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY
xcrun simctl install "$device" "$app" >/dev/null
app_data=$(xcrun simctl get_app_container "$device" "$package" data)
[[ -n "$app_data" && -d "$app_data" ]]
temporary="$app_data/tmp"
umask 077
mkdir -p "$temporary"
printf '%s' "$key" > "$temporary/live-search-key"
unset key
xcrun simctl launch --terminate-running-process "$device" "$package" "$token" live-search >/dev/null

for attempt in {1..45}; do
    for status in 0 10 11 12 70; do
        if [[ -f "$temporary/$token-LIVE_SEARCH-$status" ]]; then
            exit "$status"
        fi
    done
    sleep 1
done
exit 70
