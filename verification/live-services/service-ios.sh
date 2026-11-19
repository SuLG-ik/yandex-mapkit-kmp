#!/usr/bin/env bash
set -euo pipefail
set +x

device=${1:?Provide an iOS simulator UUID}
probe=${2:?Provide a Full service probe}
package=ru.sulgik.liteconsumer
token=${MAPKIT_LIVE_SEARCH_TOKEN:?Launch through the trusted checker}
[[ "$token" =~ ^[0-9]+-[0-9]+$ ]]

case "$probe" in
    search) marker=LIVE_SEARCH; attempts=65; modes=(text suggestions) ;;
    routing) marker=LIVE_ROUTING; attempts=90; modes=(driving walking cycling transit) ;;
    *) exit 70 ;;
esac
key_name="live-$probe-key"
result="$token-$marker"

if [[ "${3:-}" == --cleanup ]]; then
    xcrun simctl terminate "$device" "$package" >/dev/null 2>&1 || true
    app_data=$(xcrun simctl get_app_container "$device" "$package" data)
    [[ -n "$app_data" && -d "$app_data" ]]
    temporary="$app_data/tmp"
    files=("$temporary/$key_name" "$temporary/$result-"{0,10,11,12,70})
    for mode in "${modes[@]}"; do files+=("$temporary/$result-$mode-"{0,10,11,12,70}); done
    rm -f -- "${files[@]}"
    exit 0
fi

app=${MAPKIT_LIVE_SEARCH_APP:?Prepare the Full service app without credentials first}
key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY
xcrun simctl install "$device" "$app" >/dev/null
app_data=$(xcrun simctl get_app_container "$device" "$package" data)
[[ -n "$app_data" && -d "$app_data" ]]
temporary="$app_data/tmp"
umask 077
mkdir -p "$temporary"
printf '%s' "$key" > "$temporary/$key_name"
unset key
xcrun simctl launch --terminate-running-process "$device" "$package" "$token" "live-$probe" >/dev/null

for ((attempt = 0; attempt < attempts; attempt++)); do
    for status in 0 10 11 12 70; do
        if [[ -f "$temporary/$result-$status" ]]; then
            if [[ "$status" == 0 ]]; then
                for mode in "${modes[@]}"; do
                    [[ -f "$temporary/$result-$mode-0" ]] || exit 70
                done
            fi
            exit "$status"
        fi
    done
    sleep 1
done
exit 70
