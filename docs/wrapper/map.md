# Map and camera

`MapWindow` is the surface, `Map` is what you drive. `mapView.mapWindow.map` on the platform side,
`mapWindow.map` once it reaches common code.

## Moving the camera

`CameraPosition` is a value type: a target, a zoom, an azimuth and a tilt.

```kotlin
val moscow = CameraPosition(
    target = Point(55.751225, 37.629540),
    zoom = 15f,
    azimuth = 0f,
    tilt = 0f,
)

map.move(moscow)
```

With an `Animation`, and a `CameraCallback` that reports whether the movement finished or was
cancelled by a later one:

```kotlin
map.move(
    cameraPosition = moscow,
    animation = Animation(Animation.Type.SMOOTH, 1.seconds),
    cameraCallback = CameraCallback { completed ->
        if (completed) println("arrived")
    },
)
```

!!! info "Durations are `kotlin.time.Duration`"
    MapKit takes seconds as a `Float`; the wrapper takes `1.seconds`, `300.milliseconds` and
    converts.

### Fitting a geometry into the view

`cameraPosition(geometry)` computes the position that projects a geometry into the focus rect,
without moving anything:

```kotlin
val route = Polyline(points)

map.move(
    map.cameraPosition(route.toGeometry()),
    Animation(Animation.Type.SMOOTH, 500.milliseconds),
)
```

`focusRect`, `azimuth` and `tilt` are optional and default to what the map currently uses:

```kotlin
map.cameraPosition(
    geometry = boundingBox.toGeometry(),
    focusRect = ScreenRect(ScreenPoint(0f, 0f), ScreenPoint(width, height * 0.6f)),
    azimuth = 0f,
    tilt = 0f,
)
```

Every geometry type converts with `toGeometry()` — `Point`, `Polyline`, `Polygon`, `MultiPolygon`,
`BoundingBox`, `Circle`.

### Bounding the camera

```kotlin
map.cameraBounds.apply {
    setMinZoomPreference(10f)
    setMaxZoomPreference(18f)
    latLngBounds = BoundingBox(
        southWest = Point(55.55, 37.35),
        northEast = Point(55.95, 37.85),
    )
}
```

`resetMinMaxZoomPreference()` gives the limits back to MapKit.

### Following the camera

```kotlin
class MapController(private val map: Map) {

    private val cameraListener = CameraListener { _, position, reason, finished ->
        if (finished && reason == CameraUpdateReason.GESTURES) {
            reload(position.target)
        }
    }

    init {
        map.addCameraListener(cameraListener.asWeakRef())
    }
}
```

`CameraUpdateReason` distinguishes `GESTURES` from `APPLICATION`. The listener must be held in a
field — see [Listeners and `WeakRef`](overview.md#listeners-and-weakref).

## The visible region

`visibleRegion` is the four corners of what is on screen; `visibleRegion(cameraPosition)` computes
them for a position the camera has not reached yet.

```kotlin
val region: VisibleRegion = map.visibleRegion

val bounds: BoundingBox = region.getBounds()
val geometry: Geometry = region.toPolygon()

val visible = pois.filter { poi ->
    poi.latitude in bounds.southWest.latitude..bounds.northEast.latitude &&
        poi.longitude in bounds.southWest.longitude..bounds.northEast.longitude
}
```

`Latitude` and `Longitude` are `Comparable` value classes, which is what makes the range check
above compile.

`getBounds()` also exists on `Point`, `Polyline`, `LinearRing`, `Polygon`, `BoundingBox` and on a
pair of bounding boxes, which is how you grow a box over a set of objects.

## Screen and world coordinates

```kotlin
val screenPoint: ScreenPoint? = mapWindow.worldToScreen(Point(55.751225, 37.629540))
val worldPoint: Point? = mapWindow.screenToWorld(ScreenPoint(100f, 200f))
```

Both return `null` when the point cannot be projected — behind the horizon, or outside the window.

`mapWindow.width` and `mapWindow.height` are the size in physical pixels, and
`addSizeChangedListener` reports changes:

```kotlin
private val sizeChangedListener = SizeChangedListener { _, width, height ->
    println("$width x $height")
}

mapWindow.addSizeChangedListener(sizeChangedListener.asWeakRef())
```

## Focus and point of view

`focusRect` narrows the part of the window the camera reasons about — useful when a bottom sheet
covers the lower half of the map, so that "centred" means centred in what is still visible.

```kotlin
mapWindow.focusRect = ScreenRect(
    topLeft = ScreenPoint(0f, 0f),
    bottomRight = ScreenPoint(mapWindow.width.toFloat(), mapWindow.height * 0.6f),
)
```

`focusPoint` moves the point the camera rotates and zooms around, `gestureFocusPoint` does the same
for gestures only, and `gestureFocusPointMode` decides whether it applies always or only during a
gesture. `focusRegion` is the visible region of the focus rect.

`pointOfView` switches between `SCREEN_CENTER` and `ADAPT_TO_FOCUS_POINT_HORIZONTALLY`.

`scaleFactor` scales the map content — labels, icons, line widths — against the screen density.

## Gestures and appearance

```kotlin
map.isRotateGesturesEnabled = false
map.isTiltGesturesEnabled = false
map.isScrollGesturesEnabled = true
map.isZoomGesturesEnabled = true

map.isFastTapEnabled = true
map.isNightModeEnabled = isDarkTheme
map.poiLimit = 5
map.mapType = MapType.VECTOR_MAP
map.set2DMode(true)
```

`mapType` selects `NONE`, `MAP`, `SATELLITE`, `HYBRID` or `VECTOR_MAP`. `mode` selects the map's
purpose — `MAP`, `TRANSIT`, `DRIVING`, `ADMIN`, `LEGACY_MAP`, `FUTURE_MAP`, `HYBRID` — and changes
what the base map emphasises.

`isHdModeEnabled`, `isAwesomeModelsEnabled`, `isTransparentBackgroundEnabled` and
`isBuildingsAboveIndoorEnabled` are the remaining rendering switches. `poiLimit = null` gives the
limit back to MapKit.

## Map styles

A JSON style transformation, in the format described by
[the official documentation](https://yandex.ru/dev/mapkit/doc/ru/android/generated/style):

```kotlin
val applied = map.setMapStyle(
    """[{"tags": {"any": ["building"]}, "stylers": {"visibility": "off"}}]""",
)
```

Several styles can coexist under different ids, and `resetMapStyles()` drops them all:

```kotlin
map.setMapStyle(id = 1, style = hideBuildings)
map.setMapStyle(id = 2, style = dimRoads)
map.resetMapStyles()
```

## Taps on the map

`InputListener` reports taps that hit the map itself rather than an object on it.

```kotlin
class MapController(private val map: Map) {

    private val inputListener = InputListener(
        onMapTap = { _, point -> addPlacemark(point) },
        onMapLongTap = { _, point -> openMenu(point) },
    )

    init {
        map.addInputListener(inputListener.asWeakRef())
    }
}
```

A tap on a POI, a building or a toponym goes to `GeoObjectTapListener` first — see
[Base map objects](geoobjects.md).

## Waiting for the map to be drawn

`MapLoadedListener` fires once the visible tiles are rendered, with the timings and the object count:

```kotlin
private val mapLoadedListener = MapLoadedListener { statistics ->
    println("fully loaded in ${statistics.fullyLoaded}, ${statistics.renderObjectCount} objects")
}

map.setMapLoadedListener(mapLoadedListener.asWeakRef())
```

Pass `null` to stop listening.

## Indoor plans

When the camera is over a building with an indoor plan, MapKit reports it and lets you switch
levels:

```kotlin
class IndoorController(private val map: Map) {

    private var plan: IndoorPlan? = null

    private val indoorStateListener = IndoorStateListener(
        onActivePlanFocused = { plan = it },
        onActivePlanLeft = { plan = null },
        onActiveLevelChanged = { levelId -> println("level $levelId") },
    )

    init {
        map.isIndoorEnabled = true
        map.addIndoorStateListener(indoorStateListener.asWeakRef())
    }

    fun selectLevel(levelId: String) {
        plan?.activeLevelId = levelId
    }
}
```

`IndoorPlan.levels` lists the `IndoorLevel`s of the current plan.

## The Yandex logo

MapKit requires the logo to stay visible; it can only be moved.

```kotlin
map.logo.setAlignment(
    LogoAlignment(
        horizontalAlignment = LogoHorizontalAlignment.LEFT,
        verticalAlignment = LogoVerticalAlignment.BOTTOM,
    ),
)
map.logo.setPadding(LogoPadding(horizontalPadding = 16, verticalPadding = 16))
```

## Overlays

`addRasterScreenOverlay()` puts a raster image on top of the map in screen coordinates — a legend, a
compass, a weather scale:

```kotlin
val overlay = mapWindow.addRasterScreenOverlay()
overlay.setImage(legendImage, ScreenRect(ScreenPoint(16f, 16f), ScreenPoint(216f, 96f)))

overlay.remove()
```

## Geometry helpers

`Geo` covers the calculations MapKit exposes:

```kotlin
val metres = Geo.distance(from, to)
val bearing = Geo.course(from, to)
val nearest = Geo.closestPoint(point, Segment(from, to))
val midpoint = Geo.pointOnSegmentByFactor(Segment(from, to), factor = 0.5)
```

`PolylineUtils` and `SubpolylineHelper` work on polylines and their positions, `Projection` (from
`map.projection()`) converts between world and `XYPoint` tile coordinates.

## Frame rate

```kotlin
mapWindow.setMaxFps(30)
```

## Clearing the map

`map.wipe()` removes everything MapKit has drawn and cached for this map. It is a heavy operation
that is meant for the moment a map is being torn down, not for hiding objects — use
`mapObjects.clear()` for that.
