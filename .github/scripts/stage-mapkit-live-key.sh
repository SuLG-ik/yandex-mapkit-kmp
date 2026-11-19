#!/usr/bin/env bash
set -euo pipefail
set +x

key=${MAPKIT_TEST_API_KEY:?Provide the dedicated MapKit test key}
unset MAPKIT_TEST_API_KEY
umask 077
key_file=$(mktemp "${RUNNER_TEMP:?}/mapkit-service-key.XXXXXX")
trap 'rm -f -- "$key_file"' EXIT
printf '%s' "$key" > "$key_file"
unset key
printf 'file=%s\n' "$key_file" >> "$GITHUB_OUTPUT"
trap - EXIT
