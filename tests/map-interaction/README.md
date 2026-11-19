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

## iOS

Choose an available simulator UDID from `xcrun simctl list devices available`. With Xcode,
CocoaPods and JDK 21 installed, run:

```sh
bash .github/scripts/test-ios-map-interaction.sh SIMULATOR_UDID
```

The script installs pods and runs `MapInteractionTests` against a test-only app. XCUITest taps
the projected UIKit coordinate and verifies the ordered trace through accessibility. The result
bundle is under `tests/map-interaction/build`.

## Navigation 3

The Android instrumentation test and the iOS XCTest target both mount a test-only `NavDisplay`.
Their two tab stacks each own serialized destination keys and saved state. Map A and Map B set
different native viewports and selections. A native camera listener saves completed movements
independently of marker selection. Each new window applies its stored camera once on attachment.
Readiness observes the actual camera and marker visibility after the NavDisplay entry is resumed.

The drivers tap the projected map position to open details and check the complete tap recipient
trace after returning, replacing entries and switching stacks. Android sends system Back and uses
`ActivityScenario.recreate()` with a details entry on the secondary tab, then waits for its content
to be laid out in the new Activity. The iOS test waits for the details entry and its actual text. The iOS simulator sends
an edge swipe, observes a Navigation Event gesture start and idle, and checks that a short swipe
leaves details in place while a full swipe pops it.

Navigation 3 and its gesture observer are dependencies of the test targets. The fixture uses the
[Navigation 3 versions documented for Compose Multiplatform 1.11](https://kotlinlang.org/docs/multiplatform/whats-new-compose-111.html)
and the Navigation Event version declared by the published Navigation 3 artifact.
