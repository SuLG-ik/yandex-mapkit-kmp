#!/usr/bin/env bash
set -euo pipefail
set +x

exec bash "$(dirname "${BASH_SOURCE[0]}")/service-android.sh" "$1" search "${2:-}"
