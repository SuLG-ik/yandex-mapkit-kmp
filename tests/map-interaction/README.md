# Native map interaction tests

The shared fixture mounts a fixed-size Compose map with a local marker and a button that closes
or reopens the map. The test uses an inert MapKit key and `MapType.NONE`. The fixture waits for a
measured native map window and the requested camera zoom, then projects its tap point with
`worldToScreen()`. The event trace includes mount, readiness, tap and unmount with a screen
ID and a map attachment ID. A wrong world coordinate is reported in the trace.

A second fixture uses the declarative map API. It positions the camera on each tap target.
The Android driver projects the target through the measured native map window, and the iOS driver
uses the viewport's default centered focus point. Both send native taps and a 900 ms long press.
Two separate camera targets keep
empty-map gestures away from the overlapping placemark and polygon. Coordinates are compared
within 0.0001° on each axis to allow for the platform's screen-point rounding. The ordered trace
checks z-order, polygon and placemark visibility, parent consumption, and map callbacks through
registration, replacement, removal, and reattachment. The fixture taps the same empty map point
before and after enabling callbacks, then checks an isolated polygon hit before introducing the
overlapping placemark. Map touches are separated by MapKit's single/double-tap interval so each
case exercises one gesture. On Android, a regular activity keeps MapKit composition work on the UI
thread and verifies that each pointer release reaches the window at the intended location. If the
first enabled callback is missing, the report also records the result from a separately registered
MapKit input listener after preserving the original assertion failure.

## Android

Start an emulator and run:

```sh
./gradlew :yandex-mapkit-kmp-compose:connectedAndroidDeviceTest -PskipIosTarget=true
```

`MapInteractionTest` sends down/up pointer events via Android instrumentation to the projected
point in the MapKit view.

`CameraRegressionTest` drives a real Android activity. Its drag and two-pointer pinch use screen
coordinates from the measured Compose map. The camera fixture checks direction and completion
with independent scroll and zoom flags. It starts new camera listeners on distinct native maps,
checks interruption, and waits past the previous animation's deadline. The location case reads
`UserLocationState.cameraPosition`, moves the same map to each injected fix, and checks a custom
pin on screen while toggling `UserLocationConfig.isVisible`. The test host installs a dummy
location manager before enabling the layer and restores the default during cleanup.

## iOS

Choose an available simulator UDID from `xcrun simctl list devices available`. With Xcode,
CocoaPods and JDK 21 installed, run:

```sh
bash .github/scripts/test-ios-map-interaction.sh SIMULATOR_UDID
```

The script installs pods and runs `MapInteractionTests` against a test-only app. XCUITest taps
the projected UIKit coordinate and verifies the ordered trace through accessibility. The result
bundle is under `tests/map-interaction/build`.

The camera scenarios use the same simulator test target. XCUITest drags and pinches the UIKit
map and selects the animation and location controls. The controls and fixture are test-only.
