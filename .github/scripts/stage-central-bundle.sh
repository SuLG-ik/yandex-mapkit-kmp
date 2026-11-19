#!/usr/bin/env bash
set -euo pipefail

version=${1:?Pass the release version}
mode=${2:?Pass rehearsal or release}
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
staging="$(mktemp -d "${RUNNER_TEMP:-${TMPDIR:-/tmp}}/mapkit-central.XXXXXX")"
export GNUPGHOME="$staging/verify"
mkdir -m 700 "$GNUPGHOME"

cleanup() {
  if [[ "$mode" == rehearsal ]]; then
    gpgconf --homedir "$staging/sign" --kill all || true
  fi
  gpgconf --homedir "$GNUPGHOME" --kill all || true
  rm -rf "$staging"
}
trap cleanup EXIT

release_key_packets() {
  if [[ "$ORG_GRADLE_PROJECT_signingInMemoryKey" == *"-----BEGIN PGP PRIVATE KEY BLOCK-----"* ]]; then
    printf '%s\n' "$ORG_GRADLE_PROJECT_signingInMemoryKey" | gpg --batch --dearmor
  else
    printf '%s' "$ORG_GRADLE_PROJECT_signingInMemoryKey" | python3 -c '
import base64
import sys

encoded = b"".join(sys.stdin.buffer.read().split())
sys.stdout.buffer.write(base64.b64decode(encoded, validate=True))
'
  fi
}

case "$mode" in
  rehearsal)
    mkdir -m 700 "$staging/sign"
    gpg --homedir "$staging/sign" --batch --quiet --pinentry-mode loopback --passphrase '' \
      --quick-generate-key mapkit-release-rehearsal@example.invalid rsa2048 sign 1d
    ORG_GRADLE_PROJECT_signingInMemoryKey="$(gpg --homedir "$staging/sign" --batch --armor --export-secret-keys)"
    export ORG_GRADLE_PROJECT_signingInMemoryKey
    unset ORG_GRADLE_PROJECT_signingInMemoryKeyId ORG_GRADLE_PROJECT_signingInMemoryKeyPassword
    gpg --homedir "$staging/sign" --batch --export | gpg --batch --quiet --import
    ;;
  release)
    : "${ORG_GRADLE_PROJECT_signingInMemoryKey:?Maven Central signing key is missing}"
    release_key_packets | gpgsplit --secret-to-public --no-split | gpg --batch --quiet --import
    ;;
  *) echo "Expected rehearsal or release" >&2; exit 2 ;;
esac

key_count="$(gpg --batch --with-colons --list-keys | awk -F: '$1 == "pub" { count++ } END { print count + 0 }')"
if [[ "$key_count" != 1 ]]; then
  echo "Expected exactly one trusted signing certificate" >&2
  exit 1
fi

for edition in lite full; do
  "$root/gradlew" -p "$root" --no-daemon --no-configuration-cache \
    -I "$root/verification/lite-consumer/candidate-repository.init.gradle.kts" \
    -PskipIosTarget=false -PmapkitEdition="$edition" \
    -PcandidateSigning=true -PcandidateRepository="$staging/$edition" \
    publishAllPublicationsToLiteConsumerRepository
done

unset ORG_GRADLE_PROJECT_signingInMemoryKey ORG_GRADLE_PROJECT_signingInMemoryKeyPassword
python3 "$root/.github/scripts/central-bundle.py" \
  assemble "$version" "$staging" "$root/build/central-release/central-bundle.zip"
