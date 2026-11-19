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

## Decompose child stack

`DecomposeStackTest` on Android and `DecomposeStackTests` on iOS run a separate mode of
the test host. A native map tap pushes details. Popping details creates a fresh map attachment
for the retained component. Both drivers verify the native camera target, zoom, and marker
geometry against known per-child coordinates. The scenario switches between two keyed map
children and holds the replacement fade with both native windows alive. One tap reaches the
incoming map while the stopped outgoing child has already released its listener. The test then
releases the fade, backgrounds and resumes the host, and opens details from the replacement.
The 200 dp viewport and 30 FPS cap bound the virtual GPU load while the native windows overlap.

The trace records the child lifecycle separately from composition overlap, map attachment and
listener ownership. On Android the driver changes the actual activity lifecycle. On iOS it
backgrounds and reactivates the app with XCTest. Decompose is a dependency of the test host and
Android device tests only.

## Navigation 3

The Android instrumentation test and the iOS XCTest target both mount a test-only `NavDisplay`.
Their two tab stacks each own serialized destination keys and saved state. Map A and Map B set
different native viewports and selections. A native camera listener saves completed movements
independently of marker selection. Each new window applies its stored camera once on attachment.
Readiness observes the actual camera and marker visibility after the NavDisplay entry is resumed.

The drivers tap the projected map position to open details and check the complete tap recipient
trace after returning, replacing entries and switching stacks. Android projects into the on-screen
bounds of the current native MapView. It sends system Back and uses
`ActivityScenario.recreate()` with a details entry on the secondary tab, then waits for its content
to be laid out in the new Activity. The iOS test waits for the details entry and its actual text. The iOS simulator sends
an edge swipe, observes progress through Navigation Event, and checks that a short, low-velocity swipe
leaves details in place while a full swipe pops it.

Navigation 3 and its gesture observer are dependencies of the test targets. The fixture uses the
[Navigation 3 versions documented for Compose Multiplatform 1.11](https://kotlinlang.org/docs/multiplatform/whats-new-compose-111.html)
and the Navigation Event version declared by the published Navigation 3 artifact.

## Modal sheets and multiple panes

`MapPanesTest` on Android and the `--map-panes` launch in `MapInteractionTests` on iOS
exercise a real Material 3 modal sheet above a live map. A tap in the exposed map region
must be stopped by the scrim while the sheet is open. The sheet's draggable control and
button receive native input. After dismissal, the same map must receive the next tap.
The iOS driver checks that the 48 dp controls fit and have separate hit frames. The XCTest
result contains screenshots of the toolbar, the modal sheet and the resized split layout.

The scenario opens a second native map in a split layout, changes the two cameras
one at a time, and taps the untouched map at its previous camera position after each
move. Each callback must come from the native map for the pane that received the
touch. The scenario then resizes and pads one pane, applies an asymmetric MapKit focus
rectangle, and verifies the new projection before tapping both maps again. Removing
the second pane must leave the first interactive. Android also checks that the removed
pane's native window is invalidated.
