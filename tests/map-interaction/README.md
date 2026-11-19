# Native map interaction tests

The shared fixture mounts a fixed-size Compose map with a local marker and a button that closes
or reopens the map. The test uses an inert MapKit key and `MapType.NONE`. The fixture waits for a
measured native map window and the requested camera zoom, then projects its tap point with
`worldToScreen()`. The event trace includes mount, readiness, tap and unmount with a screen
ID and a map attachment ID. A wrong world coordinate is reported in the trace.

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

## On-map icon rendering

`MapIconRenderingTest` on Android and `MapIconRenderingTests` on iOS run the same fixture
on a live map for both a placemark and a cluster. The screen probe compares a row through the
icon with channel tolerances. It checks the anchor, transparent margin over a colored backing
placemark, and the width change after updating the content and density. The checks sample
local pixels without golden images or base-map tiles.

The fixture drives a local Coil fetcher through a placeholder, failure, retry and success.
It releases an older request after a newer image is visible, then releases a pending request
after removing its map object. The map keeps the newer image in the first case and stays clear
of the removed icon in the second. The [standalone consumer](../../verification/lite-consumer/README.md)
exercises the published drawable adapter.
