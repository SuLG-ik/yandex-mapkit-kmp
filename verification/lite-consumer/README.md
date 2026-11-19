# Standalone MapKit consumer

This verification stages candidate core and Compose artifacts in a disposable Maven
repository, copies this app outside the repository, and resolves the published artifacts
with its own Gradle settings. Only the local candidate repository can supply
`ru.sulgik.mapkit` artifacts.

Start an emulator or simulator and use its ID from `adb devices` or `xcrun simctl list devices booted`.

```sh
bash verification/lite-consumer/run.sh android emulator-5554
bash verification/lite-consumer/run.sh ios SIMULATOR_UUID
```

Android checks the version selected on the application runtime classpath, packages the app,
and launches it. iOS installs the documented CocoaPods dependency, runs Kotlin cinterop,
checks the Podfile lock and links and launches the app using Xcode. The Kotlin framework uses
the same static linkage as the repository sample. The smoke screen creates
a native map and a placemark through the published Compose and core APIs. It uses an
offline test key and checks map object creation without expecting tiles or service responses.

The default also installs the optional Compose Resources artifact and assigns a drawable to
the placemark using its public API. Pass `base` as the third argument to use just the core
and Compose artifacts. `with-integrations` also resolves both moko-resources modules.

## Full packaging proof

```sh
bash verification/lite-consumer/run.sh android emulator-5554 with-integrations full
bash verification/lite-consumer/run.sh ios SIMULATOR_UUID with-integrations full
```

The current public coordinates keep the Lite SDK. For the Full candidate the same source
projects publish these artifacts in the scratch repository:

| Module | Full candidate artifact |
| --- | --- |
| Core | `ru.sulgik.mapkit:yandex-mapkit-kmp-full` |
| Compose | `ru.sulgik.mapkit:yandex-mapkit-kmp-compose-full` |
| Compose Resources | `ru.sulgik.mapkit:yandex-mapkit-kmp-compose-resources-full` |
| Moko | `ru.sulgik.mapkit:yandex-mapkit-kmp-moko-full` |
| Moko Compose | `ru.sulgik.mapkit:yandex-mapkit-kmp-moko-compose-full` |

Choose one edition for the entire dependency graph. Full core's Gradle Module Metadata rejects
the Lite core coordinates, including platform artifacts. Keep Gradle Module Metadata enabled to
retain the rejection constraint. The Full core also pins the Android SDK's Full version. On iOS, use the matched
`YandexMapsMobile` pod in the app's CocoaPods integration. For the pinned Full SDK the declaration is
`pod 'YandexMapsMobile', '4.45.0-full'`. The fixture links a static Kotlin framework against that
pod and checks the pod version in its lockfile.

A Full run separately stages the Lite core to exercise the mixed graph. After that negative
check it builds a Full app, creates a map and obtains an online SearchManager from common Kotlin.
The unattended smoke check creates and resets a suggestion session without sending a query.

### Try the Full suggestions editor

Launch the manual profile on the running emulator or simulator.

```sh
bash verification/lite-consumer/run.sh android emulator-5554 base full suggestions
bash verification/lite-consumer/run.sh ios SIMULATOR_UUID base full suggestions
```

Enter a valid MapKit Full key in the masked field and select **Open editor**. The field clears after
configuration. The fixture keeps the key out of build arguments, launch arguments and diagnostic logs.
Type a place name for the preset Moscow viewport. Rapid edits replace the request, clearing the text
resets its session, and **Close editor** disposes it. Open the editor again to start a fresh session.
Relaunch the manual profile to enter a different key. The script returns once it opens the setup
screen. Requests begin when you type in the editor.

The pinned 4.45.0 SDK release ships both editions on Android and iOS. Compressed upstream
artifact sizes are 46,046,811 bytes (Lite) and 61,346,821 bytes (Full) for the Android AAR and
199,668,819 bytes (Lite) and 259,160,882 bytes (Full) for the iOS CocoaPods archive. Final app
sizes also depend on architecture selection and packaging. The default ABI check validates Lite
against the existing baselines. The Full workflow runs the search adapter tests and verifies
the Full Android and Kotlin snapshots in `yandex-mapkit-kmp/api/full`.

The regular release workflow publishes the existing Lite coordinates. The Full workflow verifies
the candidate packaging on an Android emulator and an iOS simulator.

Dependency trees, build output, Podfile.lock and device diagnostics are retained under
`build/lite-consumer/<platform>/<mode>` and `build/full-consumer/<platform>/<mode>`. The temporary
application and Maven repository are removed after success. Run with JDK 21 and the repository's
documented Android SDK. The iOS run needs CocoaPods, its `xcodeproj` gem and an arm64 simulator.
