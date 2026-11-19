# Full routing

Driving, walking, cycling and public transit routing are part of the Full edition. Use the candidate
`ru.sulgik.mapkit:yandex-mapkit-kmp-full` and `yandex-mapkit-kmp-compose-full` coordinates and
`YandexMapsMobile` {{ mapkit_version_full }} on iOS. The
[Full consumer fixture](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/verification/lite-consumer)
documents the isolated candidate repository and distribution checks.

## Driving

Initialize MapKit and start its lifecycle before creating the router. Call the router and session
on the UI thread.

```kotlin
val router = Directions.getInstance().createDrivingRouter(DrivingRouterType.ONLINE)
val points = listOf(
    RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT),
    RequestPoint(Point(55.76, 37.61), RequestPointType.VIAPOINT),
    RequestPoint(Point(55.77, 37.60), RequestPointType.WAYPOINT),
)
val session = router.requestRoutes(
    points = points,
    drivingOptions = DrivingOptions(
        routesCount = 2,
        avoidanceFlags = AvoidanceFlags(avoidTolls = true),
    ),
    vehicleOptions = VehicleOptions(),
    routeListener = DrivingRouteListener(
        onDrivingRoutes = { alternatives -> showRoutes(alternatives) },
        onDrivingRoutesError = { failure -> showFailure(failure) },
    ),
)
```

Keep the session in the screen or controller that owns the request. Cancel that wrapper before
starting a replacement or disposing the screen. `retry` swaps the listener for that request while
retaining the native session. Every wrapper of that native session shares the current request.
Cancellation or retry through any alias silences the previous callback, even when that alias
was created before the new request. Native successes can contain an empty list. Errors retain their native representation and
expose the underlying typed MapKit error when available.

The Full fixture includes a
[controller example](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullDrivingExample.kt).
Instantiate it with a live map's `mapObjects`. `replaceRoute` cancels the previous request, draws the
first alternative in its own collection and presents all alternatives to its callback. `clear`
cancels the request and removes its lines. Call `dispose` before leaving the screen. Building the
fixture exercises the example's public API calls. A live route request needs a valid MapKit key.

## Walking

Create the router with `TransportFactory.getInstance().createPedestrianRouter()`. Pass ordered
`RequestPoint` values, `TimeOptions` and `RouteOptions`. Set either departure or arrival time for
time-dependent requests. The Android binding represents the timestamp in UTC milliseconds. The
iOS bridge uses `NSDate`. `FitnessOptions` can request avoidance of steep sections and stairs.

Use `Session.RouteListener` when porting a native Android listener. The `RouteListener(...)`
factory builds the same type from Kotlin callbacks.

```kotlin
val listener: Session.RouteListener = RouteListener(
    onMasstransitRoutes = { alternatives -> showRoutes(alternatives) },
    onMasstransitRoutesError = { failure -> showFailure(failure) },
)
val session = router.requestRoutes(points, TimeOptions(), RouteOptions(), listener)
```

The [walking route example][transport-example] owns the same lifetime as the driving example.
Keep the `Session`, cancel the previous request, and draw `route.geometry` in a separate map object
collection. `Route.metadata` preserves waypoint order, distance, travel time and transfers.
`routeId`, `settings`, `flags` and `estimation` retain the SDK's nullability. `Section.geometry`
describes a fragment of the whole route. `Section.metadata.data` distinguishes waiting, walking,
transfer, taxi and transit information. Detailed payments and transport contours are accessible through
the underlying native objects.

## Cycling

Use `TransportFactory.getInstance().createBicycleRouterV2()`. It accepts the same ordered points, time
and route preferences as the walking router. Bicycle sections preserve `FitnessType.BICYCLE` and
the projected via points in `Section.metadata.data.fitness`. `replaceCyclingRoute` in the
[transport example][transport-example] draws the result, cancels the previous request and clears
its own geometry.

## Public transit

Create the router with `TransportFactory.getInstance().createMasstransitRouter()`. Pass the requested
points, `TransitOptions` and `RouteOptions`. Combine excluded `FilterVehicleTypes` values with
`or` in `TransitOptions.avoid`. Use `TimeOptions` for either departure or arrival time when
the request depends on time.

```kotlin
val avoid = FilterVehicleTypes.BUS.value or FilterVehicleTypes.TRAMWAY.value
val transitOptions = TransitOptions(avoid = avoid)
```

`Section.metadata.data.transports` holds the lines for a ride. `Section.stops` lists the stops
from boarding to exiting. `Section.rideLegs` gives the subpolylines between stops. Entrance
and exit data, estimated times and route identifiers preserve the SDK's nullability.
`replaceTransitRoute` in the [transport example][transport-example] cancels an earlier
session and draws its replacement in a collection the screen can clear.

## Use native route and session handles

Draw and inspect routes from shared code through the wrapper. In an Android or iOS source set,
call `toNative()` when a platform API expects a MapKit handle. Call `toCommon()` on a handle
you receive from native code before passing it into shared code.

```kotlin
import ru.sulgik.mapkit.transport.masstransit.Route
import ru.sulgik.mapkit.transport.masstransit.toCommon

fun routeFromNativeInterop(route: Route): Route {
    val nativeRoute = route.toNative()
    // Share nativeRoute with platform code that uses native MapKit.
    return nativeRoute.toCommon()
}
```

The driving types use the same methods in `ru.sulgik.mapkit.directions.driving`. Use wrapper
`retry()` and `cancel()` for sessions you create through the wrapper so every alias shares
the listener and cancellation state.

For a single vehicle flag, call `FilterVehicleTypes.BUS.toNative()`. On Android the native enum
converts back with `nativeFlag.toCommon()`. On iOS call `FilterVehicleTypes.toCommon(nativeFlag)`
because the native mask is an unsigned integer shared by multiple SDK types. For combined masks,
convert the entire `TransitOptions` object to preserve all 32 bits of `avoid`.

## Mode parity in MapKit 4.45.0 Full

Both pinned SDKs have the factories below. Android returns results through listener interfaces.
iOS uses handlers with a nullable routes array and `NSError`. The bridges forward errors
separately from successful route lists and preserves the native alternative order.

| Mode | Native factories and options | Geometry and lifetime | Wrapper delivery and verification |
| --- | --- | --- | --- |
| Driving | Android `DirectionsFactory.getInstance().createDrivingRouter(type)`, iOS `YMKDirectionsFactory.instance().createDrivingRouter(withType:)`. Ordered request points, `DrivingOptions` and `VehicleOptions`. | `DrivingRoute.geometry` and waypoint positions, `DrivingSession.cancel/retry`. | Request and geometry slice implemented. Android checks input and alternative order, geometry, no route, error, retry and cancellation. iOS checks native waypoint and geometry values, empty results, errors and shared cancellation state through a surrogate identity. Live requests require a MapKit key. |
| Walking | `Transport.createPedestrianRouter()` / `YMKTransport.createPedestrianRouter()` with ordered request points, `TimeOptions` and `RouteOptions`. | `transport.masstransit.Route` / `YMKMasstransitRoute` expose a polyline and sections. The shared transport session supports cancel and retry. | Request and shared transport types implemented. Android adapter checks input order, alternatives, geometry and session lifetime. iOS fixture checks metadata, nullable values and the handler. Hosted and live verification pending. |
| Cycling | `Transport.createBicycleRouterV2()` / `YMKTransport.createBicycleRouterV2()` with the same `TimeOptions` and `RouteOptions` as walking. | Same route and session as walking. | Factory and request implemented. Android checks via points, options, geometry and cancellation. iOS checks native bicycle section type and via positions. Hosted and live verification pending. |
| Public transit | `Transport.createMasstransitRouter()` / `YMKTransport.createMasstransitRouter()` takes `TransitOptions` and `RouteOptions`. `TransitOptions` carries departure/arrival time settings and a vehicle-type filter. | Same route and session as walking. Route sections distinguish transit legs and transfers. | Factory and request implemented. Android checks native filter bits, walking and transit alternatives, geometry, and cancellation. iOS checks filter bits, ride line, ordered stops and nullable entrances. Hosted and live verification pending. |

The driving slice exposes route identifiers, polylines, waypoint positions and originating request
points. Route metadata, vehicle restrictions in returned routes, summaries, external route
matching and live driving-condition subscriptions are separate native surfaces. For transport,
payment details, line threads and detailed construction data are accessible through native
objects. Device runs, Full ABI snapshots and scheduled live routes remain tracked in [#80](https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/80).

## Regression checks

Run the device suites and the isolated Full apps in GitHub Actions with a running Android
emulator and a booted iOS simulator.

```bash
./gradlew -PmapkitEdition=full -PskipIosTarget=true :yandex-mapkit-kmp:connectedAndroidDeviceTest
./gradlew -PmapkitEdition=full :yandex-mapkit-kmp:iosSimulatorArm64Test
bash verification/lite-consumer/run.sh android "$ANDROID_SERIAL" with-integrations full
bash verification/lite-consumer/run.sh ios "$IOS_DEVICE_UDID" with-integrations full
```

The first two commands exercise `DrivingAdapterTest` and `TransportAdapterTest`. Android runs
on a device because `RequestPoint` and `Polyline` constructors call JNI. Tests create aliases
before the first binding and before `retry`, cancel through the older alias, and assert that a
native callback arriving during or after cancellation reaches no retired listener.

Before reporting `MAP_READY` the Full app creates, replaces and clears actual map polylines.
In the installed app tap **Draw route**, **Replace route**, then **Clear route**. A thick blue
line appears, changes to the alternative and disappears. This offline preview exercises the
same drawing and clearing code as the request examples. The scheduled service probe uses a test MapKit key. It replaces an in-flight request in
each of the four modes, validates the returned geometry, and clears it from the map.

The iOS adapter tests use a surrogate identity for shared session ownership because MapKit
creates the native sessions. The tests still invoke the native response handlers.

If an ABI check finds a difference, [Full CI][full-workflow] uploads the actual Android or iOS
dump. Review and update the snapshots in `api/full`, then rerun both mandatory checks.

[Android routing reference](https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_routing.html) ·
[iOS routing reference](https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_routing.html)

[android-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidDeviceTest/kotlin/ru/sulgik/mapkit/directions/driving/DrivingAdapterTest.kt
[ios-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/directions/driving/DrivingAdapterTest.kt
[full-workflow]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/workflows/full-consumer.yml
[transport-example]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullTransportExample.kt
