#!/usr/bin/env bash
set -euo pipefail

platform=${1:?Usage: bash verification/lite-consumer/run.sh android|ios device-id [with-resources|base|with-integrations] [lite|full] [smoke|suggestions|prepare-live-search]}
device=${2:?Provide an Android emulator serial or iOS simulator UUID}
fixture="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
root="$(cd "$fixture/../.." && pwd)"
resources_mode=${3:-with-resources}
edition=${4:-lite}
mode=${5:-smoke}
case "$edition" in
    lite|full) ;;
    *) echo "Unknown SDK edition: $edition" >&2; exit 2 ;;
esac
case "$mode" in
    smoke) ;;
    suggestions)
        if [[ "$edition" != full ]]; then
            echo "The suggestions editor requires the Full edition." >&2
            exit 2
        fi
        ;;
    prepare-live-search)
        if [[ "$edition" != full || -z "${GITHUB_OUTPUT:-}" || -n "${MAPKIT_TEST_API_KEY:-}" ]]; then
            echo "Prepare the Full service app in a GitHub Actions step without the test key." >&2
            exit 2
        fi
        ;;
    *) echo "Unknown consumer mode: $mode" >&2; exit 2 ;;
esac
unset MAPKIT_TEST_API_KEY
case "$platform" in
    android) producer_flags=(-PskipIosTarget=true) ;;
    ios) producer_flags=(-PskipIosTarget=false) ;;
    *) echo "Unknown platform: $platform" >&2; exit 2 ;;
esac
with_moko=false
case "$resources_mode" in
    with-resources) with_resources=true ;;
    with-integrations) with_resources=true; with_moko=true ;;
    base) with_resources=false ;;
    *) echo "Unknown resources mode: $resources_mode" >&2; exit 2 ;;
esac

logs="$root/build/lite-consumer/$platform/$resources_mode"
if [[ "$edition" == full ]]; then
    logs="$root/build/full-consumer/$platform/$resources_mode"
fi
if [[ "$mode" == suggestions ]]; then
    logs="$logs/suggestions"
fi
mkdir -p "$logs"
temp_dir="$(mktemp -d "${RUNNER_TEMP:-${TMPDIR:-/tmp}}/ymk-lite-consumer.XXXXXX")"
cleanup() {
    if [[ $? == 0 && "$mode" != prepare-live-search ]]; then
        rm -rf "$temp_dir"
    else
        echo "Consumer files: $temp_dir"
    fi
    echo "Diagnostic logs: $logs"
}
trap cleanup EXIT

candidate_version="$(sed -n 's/^library_version=//p' "$root/gradle.properties")"
sdk_version="$(sed -n 's/^yandex-mapkit = "\(.*\)"$/\1/p' "$root/gradle/libs.versions.toml")"
[[ -n "$candidate_version" && "$sdk_version" == *-lite ]]
sdk_version="${sdk_version%-lite}-$edition"
modules=(yandex-mapkit-kmp yandex-mapkit-kmp-compose)
if [[ "$with_resources" == true ]]; then
    modules+=(yandex-mapkit-kmp-compose-resources)
fi
if [[ "$with_moko" == true ]]; then
    modules+=(yandex-mapkit-kmp-moko yandex-mapkit-kmp-moko-compose)
fi
publish_tasks=()
for module in "${modules[@]}"; do
    publish_tasks+=(":$module:publishAllPublicationsToLiteConsumerRepository")
done

"$root/gradlew" -p "$root" --no-configuration-cache --console=plain --stacktrace \
    -I "$fixture/candidate-repository.init.gradle.kts" \
    -PcandidateRepository="$temp_dir/maven" -PmapkitEdition="$edition" \
    "${producer_flags[@]}" "${publish_tasks[@]}" 2>&1 | tee "$logs/publication.log"

if [[ "$edition" == full ]]; then
    "$root/gradlew" -p "$root" --no-configuration-cache --console=plain --stacktrace \
        -I "$fixture/candidate-repository.init.gradle.kts" \
        -PcandidateRepository="$temp_dir/maven" -PmapkitEdition=lite "${producer_flags[@]}" \
        :yandex-mapkit-kmp:publishAllPublicationsToLiteConsumerRepository \
        2>&1 | tee "$logs/publication-lite-for-conflict.log"
fi

# Run the consumer outside the source tree, with its own settings and no project substitution.
consumer="$temp_dir/app"
mkdir -p "$consumer/gradle"
cp -R "$fixture/." "$consumer/"
cp -p "$root/gradlew" "$consumer/"
cp -R "$root/gradle/wrapper" "$consumer/gradle/"
cp "$root/gradle/libs.versions.toml" "$consumer/gradle/"
cat >> "$consumer/gradle.properties" <<EOF
candidateRepository=$temp_dir/maven
candidateVersion=$candidate_version
consumerPlatform=$platform
withComposeResources=$with_resources
withMokoResources=$with_moko
mapkitEdition=$edition
EOF
gradle=("$consumer/gradlew" -p "$consumer" --console=plain --stacktrace)
token="$(date +%s)-$$"

prepare_app() {
    if [[ "$mode" == prepare-live-search ]]; then
        printf 'app=%s\n' "$1" >> "$GITHUB_OUTPUT"
        exit 0
    fi
}

if [[ "$edition" == full ]]; then
    "${gradle[@]}" -PmixMapKitEditions=true :shared:verifyMixedMapKitEditions \
        2>&1 | tee "$logs/mixed-editions.log"
fi

if [[ "$platform" == android ]]; then
    "${gradle[@]}" :androidApp:dependencies --configuration debugRuntimeClasspath \
        2>&1 | tee "$logs/dependencies.log"
    "${gradle[@]}" :androidApp:verifyMapKitSdk :androidApp:assembleDebug \
        2>&1 | tee "$logs/build.log"
    app="$consumer/androidApp/build/outputs/apk/debug/androidApp-debug.apk"
    prepare_app "$app"
    adb -s "$device" install -r "$app"
    if [[ "$mode" == suggestions ]]; then
        adb -s "$device" shell am start -W -S -n ru.sulgik.liteconsumer/.MainActivity --ez suggestions true \
            | tee "$logs/launch.log"
    else
        adb -s "$device" shell am start -W -S -n ru.sulgik.liteconsumer/.MainActivity --es smokeToken "$token" \
            | tee "$logs/launch.log"
    fi
else
    (
        cd "$consumer/iosApp"
        ruby generate-project.rb
    )
    "${gradle[@]}" :shared:dependencies --configuration iosSimulatorArm64CompileKlibraries 2>&1 | tee "$logs/dependencies.log"
    "${gradle[@]}" :shared:cinteropYandexMapsMobileIosSimulatorArm64 :shared:podInstall \
        2>&1 | tee "$logs/pods.log"
    cp "$consumer/iosApp/Podfile.lock" "$logs/"
    selected_sdk="$(sed -n 's/^  - YandexMapsMobile (\([^()]*\))$/\1/p' "$logs/Podfile.lock")"
    if [[ "$selected_sdk" != "$sdk_version" ]]; then
        echo "Expected exactly one YandexMapsMobile ($sdk_version), found: $selected_sdk" >&2
        exit 1
    fi
    echo "Verified YandexMapsMobile ($sdk_version)"
    xcodebuild -workspace "$consumer/iosApp/LiteConsumerApp.xcworkspace" -scheme LiteConsumerApp \
        -configuration Debug -destination "id=$device" -derivedDataPath "$temp_dir/xcode" \
        CODE_SIGNING_ALLOWED=NO build 2>&1 | tee "$logs/build.log"
    app="$temp_dir/xcode/Build/Products/Debug-iphonesimulator/LiteConsumerApp.app"
    prepare_app "$app"
    xcrun simctl install "$device" "$app"
    if [[ "$mode" == suggestions ]]; then
        xcrun simctl launch --terminate-running-process "$device" ru.sulgik.liteconsumer \
            mapkit-suggestions 2>&1 | tee "$logs/launch.log"
    else
        app_data="$(xcrun simctl get_app_container "$device" ru.sulgik.liteconsumer data)"
        xcrun simctl launch --stdout="$logs/stdout.log" --stderr="$logs/device.log" \
            --terminate-running-process "$device" ru.sulgik.liteconsumer "$token" 2>&1 | tee "$logs/launch.log"
    fi
fi

if [[ "$mode" == suggestions ]]; then
    echo "Open the Full suggestions editor by entering a key in the app."
    exit 0
fi

for attempt in {1..60}; do
    if [[ "$platform" == android ]]; then
        adb -s "$device" logcat -d -b main -b crash -s MapKitLiteConsumer:I AndroidRuntime:E \
            > "$logs/device.log"
        if grep -F "$token MAP_READY" "$logs/device.log"; then
            exit 0
        fi
    elif [[ -f "$app_data/tmp/$token-MAP_READY" ]]; then
        echo "$token MAP_READY"
        exit 0
    fi
    sleep 1
done

if [[ "$platform" == ios ]]; then
    for report in "$HOME/Library/Logs/DiagnosticReports"/LiteConsumerApp-*.ips; do
        if [[ -f "$report" && "$report" -nt "$logs/launch.log" ]]; then
            cp "$report" "$logs/"
        fi
    done
fi
echo "Consumer never reported a valid map and placemark. See $logs/device.log." >&2
exit 1
