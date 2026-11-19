# Standalone MapKit Lite consumer

This verification publishes the current core and Compose modules to a disposable Maven
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
and Compose artifacts.

Dependency trees, build output, Podfile.lock and device diagnostics are retained under
`build/lite-consumer/<platform>/<mode>`. Run with JDK 21 and the repository's documented
Android SDK. The iOS run needs CocoaPods, its `xcodeproj` gem and an arm64 simulator.
