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
on a live map for both a placemark and a cluster. The probes sample horizontal and vertical
strips to check the anchor, transparent margin over a colored backing placemark, and the icon
dimensions. The cluster members have a distinct color so a visible member cannot pass as the
cluster image. A mark drawn at the raised density confirms the icon was rerendered even on iOS,
where the logical size should stay the same. The next step resizes the content at that density.

The fixture uses a local Coil fetcher with two attempts for the same model. The first attempt
shows a placeholder and an error, then the painter restarts the request and shows the fetched
image. The fixture later releases both a superseded request and a request whose map object was
removed. Each final pixel check waits for Coil's cancellation callback. The
[standalone consumer](../../verification/lite-consumer/README.md) exercises the published
drawable adapter.
