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

## Listener ownership

The Android and iOS drivers use the same `ListenerOwnershipFixture`, with a real MapKit
collection and a weak subscription to its native add events. They force recomposition and
run one GC probe while retaining the listener in the current composition. The probe allocates
2 MiB and asks the platform to collect garbage. The assertion checks event delivery to the
retained listener regardless of collection timing.

The fixture uses a compact native map and pairs actions in rows so the controls fit on shorter
simulator screens. Each action has its own 48 dp touch target. XCTest checks that the frame
fits inside the window and taps its center.

The drivers replace and explicitly unsubscribe the listener. They keep each retired listener
strongly referenced through the next native add, then drop that reference. Any extra callback
appears in the exact trace even if the SDK retains subscriptions weakly.

The drivers then suspend work started by a real native callback on a gate. The screen immediately
remounts, and the tests wait for the old scope to cancel before releasing the gate. Each mount
checks that the new native root has no tag and sets its own `userData` tag. This detects reuse
without retaining the disposed map. A late continuation records a failure event before it can
try to mutate the old object through a weak reference.

## On-map icon rendering

`MapIconRenderingTest` on Android and `MapIconRenderingTests` on iOS run the same fixture
on a live map for both a placemark and a cluster. The probes sample horizontal and vertical
strips to check the anchor, transparent margin over a colored backing placemark, and the icon
dimensions. The Android bitmap case checks both axes in physical pixels because its source
bitmap has a fixed pixel size. The Compose cases measure relative to the viewport. Distinct
colors distinguish cluster members from the cluster image. A mark drawn at the raised density
confirms the icon was rerendered even on iOS,
where its logical size should stay the same. The next step resizes the content at that density.
The 240 dp viewport leaves space for the 48 dp advance control and a two-line diagnostic on
compact simulators. XCTest checks containment and taps the control's center.

The fixture uses a local Coil fetcher with two attempts for the same model. The first attempt
shows a placeholder and an error. The painter then restarts the request and shows the fetched
image. The fixture later releases both a superseded request and a request whose map object was
removed. Each final pixel check waits for Coil's cancellation callback. The
[standalone consumer](../../verification/lite-consumer/README.md) exercises the published
drawable adapter.
