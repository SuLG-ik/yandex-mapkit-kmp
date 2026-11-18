#!/usr/bin/env bash
set -euo pipefail

platform=${1:?Usage: bash verification/lite-consumer/run.sh android|ios device-id [with-resources|base]}
device=${2:?Provide an Android emulator serial or iOS simulator UUID}
fixture="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
root="$(cd "$fixture/../.." && pwd)"
resources_mode=${3:-with-resources}
case "$platform" in
    android) producer_flags=(-PskipIosTarget=true) ;;
    ios) producer_flags=(-PskipIosTarget=false) ;;
    *) echo "Unknown platform: $platform" >&2; exit 2 ;;
esac
case "$resources_mode" in
    with-resources) with_resources=true ;;
    base) with_resources=false ;;
    *) echo "Unknown resources mode: $resources_mode" >&2; exit 2 ;;
esac

logs="$root/build/lite-consumer/$platform/$resources_mode"
mkdir -p "$logs"
temp_dir="$(mktemp -d "${RUNNER_TEMP:-${TMPDIR:-/tmp}}/ymk-lite-consumer.XXXXXX")"
launcher_pid=
cleanup() {
    if [[ -n "$launcher_pid" ]]; then
        kill "$launcher_pid" 2>/dev/null || true
        wait "$launcher_pid" 2>/dev/null || true
    fi
    echo "Consumer files: $temp_dir"
    echo "Diagnostic logs: $logs"
}
trap cleanup EXIT

candidate_version="$(sed -n 's/^library_version=//p' "$root/gradle.properties")"
sdk_version="$(sed -n 's/^yandex-mapkit = "\(.*\)"$/\1/p' "$root/gradle/libs.versions.toml")"
[[ -n "$candidate_version" && "$sdk_version" == *-lite ]]
modules=(yandex-mapkit-kmp yandex-mapkit-kmp-compose)
if [[ "$with_resources" == true ]]; then
    modules+=(yandex-mapkit-kmp-compose-resources)
fi
publish_tasks=()
for module in "${modules[@]}"; do
    publish_tasks+=(":$module:publishAllPublicationsToLiteConsumerRepository")
done

"$root/gradlew" -p "$root" --no-configuration-cache --console=plain --stacktrace \
    -I "$fixture/candidate-repository.init.gradle.kts" \
    -PcandidateRepository="$temp_dir/maven" "${producer_flags[@]}" "${publish_tasks[@]}" \
    2>&1 | tee "$logs/publication.log"

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
EOF
gradle=("$consumer/gradlew" -p "$consumer" --console=plain --stacktrace)
token="$(date +%s)-$$"

if [[ "$platform" == android ]]; then
    "${gradle[@]}" :androidApp:dependencies --configuration debugRuntimeClasspath \
        2>&1 | tee "$logs/dependencies.log"
    "${gradle[@]}" :androidApp:verifyLiteSdk :androidApp:assembleDebug \
        2>&1 | tee "$logs/build.log"
    adb -s "$device" install -r "$consumer/androidApp/build/outputs/apk/debug/androidApp-debug.apk"
    adb -s "$device" shell am start -W -S -n ru.sulgik.liteconsumer/.MainActivity --es smokeToken "$token" \
        | tee "$logs/launch.log"
else
    (
        cd "$consumer/iosApp"
        ruby generate-project.rb
    )
    "${gradle[@]}" :shared:dependencies --configuration iosSimulatorArm64CompileKlibraries 2>&1 | tee "$logs/dependencies.log"
    "${gradle[@]}" :shared:cinteropYandexMapsMobileIosSimulatorArm64 :shared:podInstall \
        2>&1 | tee "$logs/pods.log"
    cp "$consumer/iosApp/Podfile.lock" "$logs/"
    grep -Fx "  - YandexMapsMobile ($sdk_version)" "$logs/Podfile.lock"
    xcodebuild -workspace "$consumer/iosApp/LiteConsumerApp.xcworkspace" -scheme LiteConsumerApp \
        -configuration Debug -destination "id=$device" -derivedDataPath "$temp_dir/xcode" \
        CODE_SIGNING_ALLOWED=NO build 2>&1 | tee "$logs/build.log"
    xcrun simctl install "$device" "$temp_dir/xcode/Build/Products/Debug-iphonesimulator/LiteConsumerApp.app"
    app_data="$(xcrun simctl get_app_container "$device" ru.sulgik.liteconsumer data)"
    xcrun simctl launch --console-pty --terminate-running-process "$device" ru.sulgik.liteconsumer "$token" \
        > "$logs/device.log" 2>&1 &
    launcher_pid=$!
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
    if [[ -n "$launcher_pid" ]] && ! kill -0 "$launcher_pid" 2>/dev/null; then
        break
    fi
    sleep 1
done

echo "Consumer never reported a valid map and placemark. See $logs/device.log." >&2
exit 1
