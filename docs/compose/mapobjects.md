# Map objects

## States API

The `content` of `YandexMap()` is a composition of its own, with map objects as nodes. Its
composables are marked `@YandexMapComposable`, and Compose UI composables cannot be placed there.

| Composable | Draws |
|---|---|
| `Placemark` | a point with an icon |
| `TitledPlacemark` | a placemark with a text label |
| `Polyline` | a line |
| `Polygon` | a filled area |
| `Circle` | a circle with a radius in metres |
| `Clustering` | placemarks grouped into clusters |
| `MapObjectCollection` | a nested group |
| `MapObjectLayer` | a group on a separate layer |
| `TileLayer`, `TrafficLayer` | map-wide layers |
| `MapListeners` | map events |

Every object composable takes a state object created with `rememberXxxState()`. Geometry lives on
the state, not in a parameter, so moving an object is a state write and does not recompose the
subtree.

### Placemark

```kotlin
val placemarkGeometry = Point(55.751225, 37.629540)

@Composable
fun MapScreen() {
    val cameraPositionState = rememberCameraPositionState { position = startPosition }
    YandexMap(
        cameraPositionState = cameraPositionState,
        modifier = Modifier.fillMaxSize(),
    ) {
        Placemark(
            state = rememberPlacemarkState(placemarkGeometry),
            icon = imageProvider(Res.drawable.pin_red),
            iconStyle = IconStyle(anchor = PointF(0.5f, 1f), scale = 1.2f),
            onTap = { point -> true },
            visible = true,
            draggable = false,
            zIndex = 1f,
            opacity = 1f,
            userData = poi,
        )
    }
}
```

`imageProvider(Res.drawable.pin_red)` builds the icon from a Compose Multiplatform resource — see
[Image resources](image-resources.md).

`TitledPlacemark` adds a label:

```kotlin
TitledPlacemark(
    state = rememberPlacemarkState(placemarkGeometry),
    icon = imageProvider(Res.drawable.pin_red),
    title = "Red Square",
    titleStyle = TextStyle(size = 10f, placement = TextStyle.Placement.BOTTOM, offset = 4f),
)
```

### Circle

```kotlin
Circle(
    state = rememberCircleState(Circle(center = point, radius = 500f)),
    color = Color.Red.copy(alpha = 0.2f),
    strokeColor = Color.Red,
    strokeWidth = 2f,
    geodesic = false,
    onTap = { true },
)
```

### Polyline

```kotlin
Polyline(
    state = rememberPolylineState(Polyline(points)),
    strokeColor = Color.Green,
    strokeWidth = 5f,
    outlineColor = Color.DarkGray,
    outlineWidth = 1f,
    dashLength = 8f,
    gapLength = 4f,
    turnRadius = 10f,
)
```

### Polygon

```kotlin
Polygon(
    state = rememberPolygonState(
        Polygon(outerRing = LinearRing(outerPoints), innerRings = listOf(LinearRing(hole))),
    ),
    color = Color.Blue.copy(alpha = 0.2f),
    strokeColor = Color.Blue,
    strokeWidth = 2f,
    geodesic = true,
    pattern = imageProvider(Res.drawable.hatch),
    patternScale = 1f,
)
```

## What the state adds

The state object is where everything a parameter cannot express lives. It is bound to the map object
while the composable is in the composition, so these calls belong in an effect or an event handler,
not in the composition itself.

### Any object

```kotlin
mapObjectState.setVisible(
    visible = false,
    animation = Animation(Animation.Type.SMOOTH, 300.milliseconds),
)

mapObjectState.isValid
```

### Placemark

`PlacemarkState` reaches the presentation objects and the scale function:

```kotlin
val placemarkState = rememberPlacemarkState(point)

LaunchedEffect(Unit) {
    placemarkState.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
    placemarkState.useCompositeIcon().setIcon("badge", badgeImage, IconStyle(zIndex = 1f))
    placemarkState.text.text = "Red Square"
}
```

`geometry`, `direction` and `isDragging` are observable properties of the state:

```kotlin
val placemarkState = rememberPlacemarkState(point)

Placemark(state = placemarkState, icon = icon, draggable = true)

if (placemarkState.isDragging) {
    Text("Dragging from ${placemarkState.geometry}")
}
```

### Polyline segment colours

A polyline is coloured through a palette. `setPaletteColor(colorIndex, color)` defines the colour
stored under an index, and `setStrokeColors(paletteIndices)` assigns one of those indexes to every
segment — a polyline of _n_ points has _n − 1_ segments. By default every segment uses palette index
0, which is what the `strokeColor` parameter sets.

`getStrokeColor(segmentIndex)` returns the **palette index** of a segment, not its colour; resolve it
with `getPaletteColor(colorIndex)`.

```kotlin
polylineState.setPaletteColor(0, Color.Red)
polylineState.setPaletteColor(1, Color.Green)
polylineState.setPaletteColor(2, Color.Blue)
polylineState.setStrokeColors(listOf(0, 1, 2))
```

`PolylineState` also selects and hides parts of the line, and adds arrows:

```kotlin
polylineState.select(Color.Blue, subpolyline)
polylineState.hide(subpolyline)

polylineState.addArrow(
    position = PolylinePosition(segmentIndex = 2, segmentPosition = 0.0),
    length = 12f,
    fillColor = Color.Black,
)
```

### Polygon pattern

```kotlin
polygonState.setPattern(animatedHatch, scale = 1f)
polygonState.resetPattern()
```

### Collections

```kotlin
collectionState.setPlacemarksScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))

collectionState.traverse(visitor)
```

## Clustering

`Clustering` builds a `ClusterizedPlacemarkCollection` and reclusters when its groups change. Each
`ClusterGroup` has its own placemark icon; the cluster icon is shared.

=== "Single group"

    ```kotlin
    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        val pinRed = imageProvider(Res.drawable.pin_red)
        val clusterIcon = imageProvider(Res.drawable.cluster)

        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Clustering(
                group = ClusterGroup(points = redPoints, icon = pinRed),
                icon = clusterIcon,
                config = ClusterizingConfig(clusterRadius = 60.0, minZoom = 15),
                onItemTap = { item -> true },
                onClusterTap = { cluster -> true },
            )
        }
    }
    ```

=== "Multiple groups"

    ```kotlin
    Clustering(
        groups = persistentListOf(
            ClusterGroup(points = redPoints, icon = pinRed),
            ClusterGroup(points = greenPoints, icon = pinGreen),
            ClusterGroup(points = yellowPoints, icon = pinYellow),
        ),
        icon = clusterIcon,
    )
    ```

=== "With data per item"

    ```kotlin
    Clustering(
        group = ClusterGroup(
            placemarks = pois.map { ClusterItem(geometry = it.point, data = it) }.toPersistentList(),
            icon = pinRed,
            text = "POI",
        ),
        icon = clusterIcon,
        onItemTap = { item ->
            val poi = item.data as? Poi ?: return@Clustering false
            open(poi)
            true
        },
    )
    ```

`groups` is an `ImmutableList` on purpose: Compose can then skip recomposition when the list has not
changed, and reclustering is expensive.

Cluster icons can also be composable content — see
[Image resources](image-resources.md#composable-as-cluster-icon).

## Controller API

With the controller overload there is no composition of map objects: `MapControllerEffect` gives you
the `MapWindow` once it exists, and you use the wrapper API directly.

=== "Placemark"

    ```kotlin
    @Composable
    fun MapScreen() {
        val mapController = rememberYandexMapController()
        val pinGreen = imageProvider(Res.drawable.pin_green)
        MapControllerEffect(mapController) { mapWindow ->
            mapWindow.map.mapObjects.addPlacemark().apply {
                geometry = placemarkGeometry
                setIcon(pinGreen)
            }
        }
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```

=== "Circle"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addCircle(circleGeometry)
    }
    ```

=== "Polyline"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addPolyline(polylineGeometry)
    }
    ```

=== "Polygon"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addPolygon(polygonGeometry)
    }
    ```

Clustering is the same as in the wrapper, listeners included:

```kotlin
@Composable
fun MapScreen() {
    val mapController = rememberYandexMapController()
    val clusterIcon = imageProvider(Res.drawable.cluster)
    val pinRed = imageProvider(Res.drawable.pin_red)

    val clusterTapListener = remember { ClusterTapListener { true } }
    val itemTapListener = remember { MapObjectTapListener { _, _ -> true } }
    val clusterListener = remember(clusterIcon) {
        ClusterListener { cluster ->
            cluster.appearance.setIcon(clusterIcon)
            cluster.appearance.setText("${cluster.size}")
            cluster.addClusterTapListener(clusterTapListener.asWeakRef())
        }
    }

    MapControllerEffect(mapController) { mapWindow ->
        val collection = mapWindow.map.mapObjects
            .addClusterizedPlacemarkCollection(clusterListener.asWeakRef())
        points.forEach { point ->
            collection.addPlacemark().apply {
                geometry = point
                setIcon(pinRed)
                addTapListener(itemTapListener.asWeakRef())
            }
        }
        collection.clusterPlacemarks(clusterRadius = 60.0, minZoom = 15)
    }

    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

!!! warning "`remember` the listeners"
    Subscriptions are weak. A listener created inline in a composition is collected on the next
    recomposition and stops firing — `remember` it, or keep it in whatever owns the screen.
