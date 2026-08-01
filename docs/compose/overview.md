# Compose overview

`yandex-mapkit-kmp-compose` draws the map from common code with Compose Multiplatform. It offers two
APIs, and they can be mixed within one screen only through `MapEffect`.

| | When to use |
|---|---|
| [States API](#states-api) | almost always — declarative map objects, camera and configuration |
| [Controller API](#controller-api) | when you already have imperative MapKit code and only need a view |

## States API

`YandexMap()` creates the `MapView` and runs its `content` as a **second composition** whose nodes
are map objects. That composition has its own applier, so it accepts only composables marked
`@YandexMapComposable` — a `Text` or a `Box` inside it will not compile.

### Simple setup

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState { position = startPosition }
    YandexMap(
        cameraPositionState = cameraPositionState,
        modifier = Modifier.fillMaxSize(),
    )
}
```

`rememberAndInitializeMapKit().bindToLifecycleOwner()` is needed once per screen and can be dropped
if MapKit is initialized elsewhere — see [Quick start](../getting-started/quick-start.md).

### The camera

`CameraPositionState` is the single source of truth for where the camera is. Reading `position`
recomposes when the camera moves; writing it moves the camera.

```kotlin
val cameraPositionState = rememberCameraPositionState { position = startPosition }

LaunchedEffect(selected) {
    cameraPositionState.position = CameraPosition(selected, zoom = 16f, azimuth = 0f, tilt = 0f)
}

if (cameraPositionState.isMoving) {
    LinearProgressIndicator()
}
```

`isMoving` and `updateReason` (`GESTURES` or `APPLICATION`) tell what the camera is doing and who
started it — a gesture from the user or your own code.

!!! warning "One `CameraPositionState` per `YandexMap`"
    Sharing a state object between two maps makes them fight over the camera.

Inside map content, `currentCameraPositionState` reaches the state of the enclosing map without
threading it through.

### Configuring the map

`MapConfig` covers `Map` and `MapWindow`. Every property is nullable, and `null` means "leave it to
MapKit".

```kotlin
YandexMap(
    cameraPositionState = cameraPositionState,
    config = MapConfig(
        isNightModeEnabled = isSystemInDarkTheme(),
        poiLimit = 5,
        isRotateGesturesEnabled = false,
        isTiltGesturesEnabled = false,
        isScrollGesturesEnabled = true,
        isZoomGesturesEnabled = true,
        mapType = MapType.VECTOR_MAP,
        mode = MapMode.MAP,
        use2dMode = true,
        isHdModeEnabled = true,
        isIndoorEnabled = true,
        mapStyle = """[{"tags": {"any": ["building"]}, "stylers": {"visibility": "off"}}]""",
        focusRect = ScreenRect(ScreenPoint(0f, 0f), ScreenPoint(width, height * 0.6f)),
        pointOfView = PointOfView.SCREEN_CENTER,
        scaleFactor = 1f,
        fps = 30,
        cameraBounds = MapCameraBoundsConfig(
            minZoomPreference = 10f,
            maxZoomPreference = 18f,
        ),
        logo = MapLogoConfig(
            alignment = LogoAlignment(
                horizontalAlignment = LogoHorizontalAlignment.LEFT,
                verticalAlignment = LogoVerticalAlignment.BOTTOM,
            ),
            padding = LogoPadding(horizontalPadding = 16, verticalPadding = 16),
        ),
    ),
    modifier = Modifier.fillMaxSize(),
)
```

!!! info "`null` is not the same as a default"
    `null` means the wrapper does not touch that property at all. Setting a value and then putting
    `null` back does not restore MapKit's default — it just stops updating it.

The default `MapConfig` follows the system theme: `MapConfig(isNightModeEnabled = isSystemInDarkTheme())`.

### Map events

`MapListeners` subscribes for as long as it stays in the composition. Every callback is optional, and
the matching MapKit listener is attached only when it is not `null`.

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    MapListeners(
        onMapTap = { point -> println("tap at $point") },
        onMapLongTap = { point -> println("long tap at $point") },
        onGeoObjectTap = { event ->
            val metadata = event.geoObject.selectionMetadata ?: return@MapListeners false
            selection = metadata
            true
        },
        onMapLoaded = { statistics -> println("loaded in ${statistics.fullyLoaded}") },
        onMapWindowSizeChanged = { width, height -> println("$width x $height") },
        onActivePlanFocused = { plan -> indoorPlan = plan },
        onActivePlanLeft = { indoorPlan = null },
        onActiveLevelChanged = { levelId -> activeLevel = levelId },
    )
}
```

Returning `false` from `onGeoObjectTap` lets the event propagate to the map, which then also reaches
`onMapTap`.

### User location

The `YandexMap` overload that takes a `UserLocationState` creates and owns the
`UserLocationLayer`:

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
            anchor = UserLocationConfig.Anchor(
                normal = PointF(width * 0.5f, height * 0.5f),
                course = PointF(width * 0.5f, height * 0.75f),
            ),
            pin = UserLocationConfig.LocationIcon(image = pinImage),
            arrow = UserLocationConfig.LocationIcon(image = arrowImage),
            accuracy = UserLocationConfig.LocationAccuracy(fillColor = Color(0x334CAF50)),
        ),
        modifier = Modifier.fillMaxSize(),
    )
}
```

`locationState.cameraPosition` follows the layer's own camera position, or is `null` while there is
no fix. Permissions are still yours to request — see [Geolocation](../wrapper/location.md).

### Traffic

```kotlin
var level by remember { mutableStateOf<TrafficLevel?>(null) }

YandexMap(modifier = Modifier.fillMaxSize()) {
    TrafficLayer(
        visible = true,
        onTrafficChanged = { level = it },
        onTrafficLoading = { },
        onTrafficExpired = { },
    )
}
```

### Grouping map objects

`MapObjectCollection` puts its content into a nested collection. The collection is a map object
itself, so `visible` hides the whole group at once and `zIndex` applies to all of it; leaving the
composition removes the group from the map.

`MapObjectCollectionState` reaches what a parameter cannot express — the `PlacemarksStyler` shared
by every placemark of the group, and `traverse`.

```kotlin
@Composable
fun MapScreen(showPois: Boolean) {
    val poisState = rememberMapObjectCollectionState()
    YandexMap(modifier = Modifier.fillMaxSize()) {
        MapObjectCollection(state = poisState, visible = showPois, zIndex = 1f) {
            pois.forEach { poi ->
                Placemark(state = rememberPlacemarkState(poi.point), icon = icon)
            }
        }
    }
    LaunchedEffect(Unit) {
        poisState.setPlacemarksScaleFunction(
            listOf(PointF(10f, 0.5f), PointF(16f, 1f)),
        )
    }
}
```

### Custom tile layers

`TileLayer` adds a layer of your own tiles and removes it when it leaves the composition.
`layerId` names the layer and picks its place in the render order; `createTileDataSource` is called
once per layer, so a data source does not follow later recompositions.

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    TileLayer(
        layerId = "weather",
        options = LayerOptions(transparent = true, nightModeAvailable = false),
        active = true,
        onLayerLoaded = { println("weather tiles are on screen") },
        onDataSourceUpdated = { },
    ) { builder ->
        builder.setTileUrlProvider(
            UrlProvider { tileId, _, _ ->
                "https://tiles.example.com/${tileId.z}/${tileId.x}/${tileId.y}.png"
            },
        )
        builder.setProjection(Projections.wgs84Mercator)
        builder.setZoomRanges(listOf(ZoomRange(zMin = 0, zMax = 19)))
        builder.setTileFormat(TileFormat.PNG)
    }
}
```

`MapObjectLayer` does the same for map objects: its content goes into an independent collection
linked to the given layer instead of the default one.

```kotlin
MapObjectLayer(layerId = "my-routes") {
    Polyline(state = rememberPolylineState(route))
}
```

!!! info "The collection is reused"
    MapKit links one collection to a layer id for the lifetime of the map and cannot unlink it, so
    the collection is created once per id and reused: leaving the composition empties it, entering
    it again fills the same one.

### Escaping to MapKit

`MapEffect` hands over the `Map` instance the composition is driving, for anything the composables
do not cover. It is `@YandexMapComposable` and only runs inside `YandexMap` content.

```kotlin
YandexMap(
    cameraPositionState = cameraPositionState,
    modifier = Modifier.fillMaxSize(),
) {
    MapEffect(selection) { map ->
        val metadata = selection
        if (metadata != null) map.selectGeoObject(metadata) else map.deselectGeoObject()
    }
}
```

Like `LaunchedEffect`, it restarts when its keys change and runs in a coroutine scope tied to the
map composition.

## Controller API

`YandexMap()` also has an overload that takes a `YandexMapController` and does nothing else: no
composition of map objects, no config, no camera state. You get the `MapWindow` and drive MapKit
imperatively.

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val mapController = rememberYandexMapController()
    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

`YandexMapController.mapWindow` is `null` until the view has been created.

`MapControllerEffect` runs once the `MapWindow` exists, and hands it over non-null:

```kotlin
@Composable
fun MapScreen() {
    val mapController = rememberYandexMapController()
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.move(startPosition)
        mapWindow.map.isZoomGesturesEnabled = true
    }
    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

Everything on [Map and camera](../wrapper/map.md) and [Map objects](../wrapper/mapobjects.md)
applies inside that block — including the rule that listeners must be held in a field, not created
inline.

## What is next

- [Map objects](mapobjects.md) — placemarks, polylines, polygons, circles, clustering.
- [Image resources](image-resources.md) — icons from Compose resources and from composable content.
