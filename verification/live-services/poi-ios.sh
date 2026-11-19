#!/usr/bin/env bash
set -euo pipefail
set +x

exec python3 -B "$(dirname "${BASH_SOURCE[0]}")/poi_ios.py" "$@"
