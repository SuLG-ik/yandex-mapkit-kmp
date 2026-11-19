#!/usr/bin/env bash
set -euo pipefail

version=${1:?Pass the release version}
mode=${2:?Pass rehearsal or release}
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
staging="$(mktemp -d "${RUNNER_TEMP:-${TMPDIR:-/tmp}}/mapkit-central.XXXXXX")"
trap 'rm -rf "$staging"' EXIT

case "$mode" in
  rehearsal)
    export GNUPGHOME="$staging/gnupg"
    mkdir -m 700 "$GNUPGHOME"
    gpg --batch --quiet --pinentry-mode loopback --passphrase '' \
      --quick-generate-key mapkit-release-rehearsal@example.invalid rsa2048 sign 1d
    ORG_GRADLE_PROJECT_signingInMemoryKey="$(gpg --batch --armor --export-secret-keys)"
    export ORG_GRADLE_PROJECT_signingInMemoryKey
    unset ORG_GRADLE_PROJECT_signingInMemoryKeyId ORG_GRADLE_PROJECT_signingInMemoryKeyPassword
    ;;
  release)
    : "${ORG_GRADLE_PROJECT_signingInMemoryKey:?Maven Central signing key is missing}"
    ;;
  *) echo "Expected rehearsal or release" >&2; exit 2 ;;
esac

for edition in lite full; do
  "$root/gradlew" -p "$root" --no-daemon --no-configuration-cache \
    -I "$root/verification/lite-consumer/candidate-repository.init.gradle.kts" \
    -PskipIosTarget=false -PmapkitEdition="$edition" \
    -PcandidateSigning=true -PcandidateRepository="$staging/$edition" \
    publishAllPublicationsToLiteConsumerRepository
done

python3 "$root/.github/scripts/central-bundle.py" \
  assemble "$version" "$staging" "$root/build/central-release/central-bundle.zip" "$mode"
