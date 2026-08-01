# Geolocation

`MapKit` hands out three kinds of location source and one map layer that draws the result.

| | What it is |
|---|---|
| `createLocationManager()` | the device's own positioning |
| `createLocationSimulator(polyline)` | replays a route |
| `createDummyLocationManager()` | positions your code pushes in |
| `createUserLocationLayer(mapWindow)` | the arrow, pin and accuracy circle on the map |

!!! warning "Permissions are yours to request"
    The wrapper does not ask for location permissions — do it the platform way before subscribing,
    or the manager reports `LocationStatus.NOT_AVAILABLE`.

## Subscribing to positions

```kotlin
class LocationController(private val mapKit: MapKit) {

    private val locationManager = mapKit.createLocationManager()

    private val locationListener = LocationListener(
        onLocationUpdated = { location -> show(location.position) },
        onLocationStatusUpdated = { status ->
            if (status == LocationStatus.NOT_AVAILABLE) showUnavailable()
        },
    )

    fun start() {
        locationManager.subscribeForLocationUpdates(
            subscriptionSettings = SubscriptionSettings(
                useInBackground = UseInBackground.DISALLOW,
                purpose = LocationPurpose.GENERAL,
            ),
            locationListener = locationListener.asWeakRef(),
        )
    }

    fun stop() {
        locationManager.unsubscribe(locationListener.asWeakRef())
    }
}
```

`purpose` tells MapKit what the position is for — `GENERAL`, `AUTOMOTIVE_NAVIGATION`,
`PEDESTRIAN_NAVIGATION`, `BICYCLE_NAVIGATION`, `SCOOTER_NAVIGATION`, `STATIC_DISPLAY_LOCATION` — and
`useInBackground` whether it may keep working while the application is in the background.

For a single fix instead of a stream:

```kotlin
locationManager.requestSingleUpdate(locationListener.asWeakRef())
```

`suspend()` and `resume()` pause and continue the subscriptions without dropping them.

### What a position carries

```kotlin
data class Location(
    val position: Point,
    val accuracy: Double?,
    val altitude: Double?,
    val altitudeAccuracy: Double?,
    val heading: Double?,
    val speed: Double?,
    val indoorLevelId: String?,
    val absoluteTimestamp: Instant,
    val relativeTimestamp: Duration,
)
```

Everything MapKit may not know is nullable. `absoluteTimestamp` is wall-clock time,
`relativeTimestamp` is monotonic time since the device booted, which is what you compare positions
by.

The last position MapKit received, without subscribing at all:

```kotlin
val last: Location? = lastKnownLocation()
```

## Drawing the user on the map

```kotlin
class UserLocationController(mapKit: MapKit, mapWindow: MapWindow) {

    private val layer = mapKit.createUserLocationLayer(mapWindow)

    private val tapListener = UserLocationTapListener { point -> openDetails(point) }

    private val objectListener = UserLocationObjectListener(
        onObjectAdded = { view ->
            view.pin.setIcon(pinImage)
            view.arrow.setIcon(arrowImage)
            view.accuracyCircle.fillColor = Color.fromArgb(0x334CAF50)
        },
        onObjectRemoved = { },
        onObjectUpdated = { _, _ -> },
    )

    init {
        layer.isVisible = true
        layer.isHeadingModeActive = true
        layer.setTapListener(tapListener.asWeakRef())
        layer.setObjectListener(objectListener.asWeakRef())
    }
}
```

`UserLocationView` is three map objects — `arrow`, `pin` and `accuracyCircle` — so everything on
[Map objects](mapobjects.md) applies to them. `onObjectAdded` is where they are styled; MapKit
creates them lazily, after the first fix.

### Anchoring

Anchor mode keeps the user's marker at a fixed point of the screen and moves the map under it, which
is what navigation looks like. Two anchors are given: one for the normal state, one while the map
follows the course.

```kotlin
layer.setAnchor(
    anchorNormal = PointF(width * 0.5f, height * 0.5f),
    anchorCourse = PointF(width * 0.5f, height * 0.75f),
)
layer.isAutoZoomEnabled = true
```

`resetAnchor()` leaves the mode; `isAnchorEnabled` reports whether it is on. Any camera movement by
the user turns it off, so re-arm it when you want it back.

`layer.cameraPosition` is the position the layer would move the camera to, or `null` while there is
no fix.

### Feeding the layer from another source

```kotlin
layer.setSource(simulator.asLocationManager().toLocationViewSource())
layer.setDefaultSource()
```

## Simulating a route

The simulator replays a `Polyline` — for demos, for screenshots, and for tests that must not depend
on where the device is.

```kotlin
val route = Polyline(routePoints)
val simulator = mapKit.createLocationSimulator(route)

val settings = listOf(
    SimulationSettings(
        geometry = route,
        locationSettings = LocationSettings(
            provideSpeed = true,
            speed = 20.0,
            provideAccuracy = true,
            accuracy = Range(from = 3.0, to = 5.0),
        ),
    ),
)

simulator.asLocationManager().resume()
simulator.startSimulation(settings)
```

!!! danger "A simulator is created suspended"
    MapKit derives `LocationSimulator` from `LocationManager`, and `startSimulation` does **not**
    resume it. Without `asLocationManager().resume()` the simulation runs, `isActive` stays `false`
    and nothing reaches the subscribers.

`asLocationManager()` is what makes `subscribeForLocationUpdates`, `requestSingleUpdate`,
`unsubscribe`, `suspend` and `resume` reachable — Kotlin cannot express MapKit's inheritance across
two platforms, so the relation is spelled as a conversion. The result is a plain `LocationManager`,
so it also goes into `MapKit.setLocationManager()` or `toLocationViewSource()`.

```kotlin
private val simulatorListener = LocationSimulatorListener { println("route finished") }

simulator.subscribeForSimulatorEvents(simulatorListener.asWeakRef())

val progress = simulator.polylinePosition()

simulator.stopSimulation()
```

`polylinePosition()` is where along the route the simulation currently is.

!!! info "`speed` on the simulator is deprecated"
    MapKit moved it into `LocationSettings`. `startSimulation` replaces `settings` wholesale, so a
    value assigned to `simulator.speed` beforehand is overwritten; set `LocationSettings.speed`
    together with `provideSpeed = true` on every `SimulationSettings` instead.

### What `LocationSettings` controls

Each `provideX` flag decides whether the field is reported at all, and the value next to it says
what to report:

```kotlin
LocationSettings(
    provideAccuracy = true,
    accuracy = Range(from = 3.0, to = 5.0),
    provideSpeed = true,
    speed = 20.0,
    provideHeading = true,
    headingError = Range(from = 0.0, to = 2.0),
    locationTimeInterval = TimeInterval(from = 1.seconds, to = 2.seconds),
)
```

`LocationSettings.fineSettings()` and `LocationSettings.coarseSettings()` are MapKit's presets.

## Pushing positions in by hand

`DummyLocationManager` reports exactly what you give it — useful for tests and for replaying a
recorded track at your own pace.

```kotlin
val dummy = mapKit.createDummyLocationManager()

dummy.asLocationManager().subscribeForLocationUpdates(
    subscriptionSettings = SubscriptionSettings(UseInBackground.DISALLOW, LocationPurpose.GENERAL),
    locationListener = locationListener.asWeakRef(),
)

dummy.setLocation(
    location = Location(
        position = Point(55.751225, 37.629540),
        accuracy = 5.0,
        altitude = null,
        altitudeAccuracy = null,
        heading = 0.0,
        speed = 0.0,
        indoorLevelId = null,
        absoluteTimestamp = Clock.System.now(),
        relativeTimestamp = 0.seconds,
    ),
    quality = DummyLocationQuality.HIGH,
)
```

As with the simulator, `asLocationManager()` is what opens the subscription members.

## Replacing the global manager

`MapKit.setLocationManager()` makes every part of MapKit — including `UserLocationLayer` — use your
source instead of the device's:

```kotlin
mapKit.setLocationManager(simulator.asLocationManager())

mapKit.resetLocationManagerToDefault()
```

## In Compose

`YandexMap` has an overload that owns the layer, so nothing has to be created by hand:

```kotlin
@Composable
fun MapScreen() {
    val locationState = rememberUserLocationState()
    YandexMap(
        locationState = locationState,
        locationConfig = UserLocationConfig(
            isVisible = true,
            isHeadingEnabled = true,
            isAutoZoomEnabled = true,
            pin = UserLocationConfig.LocationIcon(image = pinImage),
            arrow = UserLocationConfig.LocationIcon(image = arrowImage),
            accuracy = UserLocationConfig.LocationAccuracy(
                fillColor = Color(0x334CAF50),
            ),
        ),
        modifier = Modifier.fillMaxSize(),
    )
}
```

`locationState.cameraPosition` follows `UserLocationLayer.cameraPosition`.
