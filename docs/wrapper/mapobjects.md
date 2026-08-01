# Map objects

Everything you draw on the map lives in a collection. `map.mapObjects` is the root one — a
`RootMapObjectCollection` — and `addCollection()` nests more inside it.

```kotlin
val objects = map.mapObjects
val pois = objects.addCollection()
```

Nesting is worth doing: a collection is a map object itself, so hiding it hides the whole group,
`zIndex` applies to all of it and `clear()` empties it in one call.

## Placemark

```kotlin
val placemark = objects.addPlacemark().apply {
    geometry = Point(55.751225, 37.629540)
    setIcon(icon)
    setIconStyle(IconStyle(anchor = PointF(0.5f, 1.0f), scale = 1.2f))
    userData = poi
}
```

!!! info "`addPlacemark()` takes no arguments"
    MapKit deprecated the `addPlacemark(point, icon)` overloads; the object is created first and
    configured afterwards. [`PlacemarkCreatedCallback`](#creating-placemarks-in-bulk) is the
    exception.

`geometry`, `direction` and `opacity` are properties. `setIcon(image, style)` sets the icon and its
style at once, and `setScaleFunction(points)` makes the size depend on the zoom — each `PointF` is
a `(zoom, scale)` pair:

```kotlin
placemark.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
```

### Text

```kotlin
placemark.setText(
    text = "Red Square",
    style = TextStyle(
        size = 10f,
        color = Color.fromArgb(0xFF212121.toInt()),
        placement = TextStyle.Placement.BOTTOM,
        offset = 4f,
    ),
)
```

`placemark.text` returns the live `PlacemarkText`, whose `text` and `style` can be changed later.

### Presentation objects

`setIcon` is a shortcut over a placemark's presentation. Asking for the presentation directly gives
more: a composite icon with several named parts, a 3D model, or an animation.

=== "Icon"

    ```kotlin
    val icon: Icon = placemark.useIcon()
    icon.setImage(image, IconStyle(zIndex = 10f))
    icon.style = IconStyle(scale = 2f)
    ```

=== "Composite icon"

    ```kotlin
    val composite: CompositeIcon = placemark.useCompositeIcon()
    composite.setIcon(name = "pin", image = pinImage, style = IconStyle(anchor = PointF(0.5f, 1f)))
    composite.setIcon(name = "badge", image = badgeImage, style = IconStyle(zIndex = 1f))

    composite.setIconStyle("badge", IconStyle(isVisible = false))
    composite.removeIcon("badge")
    ```

=== "Model"

    ```kotlin
    val model: Model = placemark.useModel()
    model.modelStyle = ModelStyle(
        scale = 1f,
        unitType = ModelStyle.UnitType.NORMALIZED,
        renderMode = ModelStyle.RenderMode.USER_MODEL,
    )
    model.setData(gltfDataProvider, Callback { println("model loaded") })
    ```

=== "Animation"

    ```kotlin
    val animation: PlacemarkAnimation = placemark.useAnimation()
    animation.setIcon(animatedImage, IconStyle())
    animation.isReversed = false
    animation.play(Callback { println("finished") })

    animation.pause()
    animation.resume()
    animation.stop()
    ```

Calling `useIcon()` after `useModel()` replaces the presentation — a placemark has exactly one.

## Polyline

```kotlin
val polyline = objects.addPolyline(Polyline(points))

polyline.style = LineStyle(
    strokeWidth = 5f,
    outlineWidth = 1f,
    outlineColor = Color.fromArgb(0xFF1B5E20.toInt()),
    dashLength = 8f,
    gapLength = 4f,
)
polyline.setStrokeColor(Color.fromArgb(0xFF4CAF50.toInt()))
```

### Colouring segments

A polyline of _n_ points has _n − 1_ segments, and each segment carries a **palette index**, not a
colour. Define the palette first, then assign indexes:

```kotlin
polyline.setPaletteColor(0, Color.fromArgb(0xFF4CAF50.toInt()))
polyline.setPaletteColor(1, Color.fromArgb(0xFFFFC107.toInt()))
polyline.setPaletteColor(2, Color.fromArgb(0xFFF44336.toInt()))

polyline.setStrokeColors(listOf(0, 1, 2, 1))
```

!!! warning "`getStrokeColor` returns an index"
    `getStrokeColor(segmentIndex)` gives back the palette index of that segment; resolve it with
    `getPaletteColor(colorIndex)`. `setStrokeColor(color)` is different — it is a real colour, and
    it writes palette entry 0, which every segment uses by default.

The overload with weights spreads the colours over the polyline by relative length instead of by
segment:

```kotlin
polyline.setStrokeColors(paletteIndices = listOf(0, 2), weights = listOf(0.7, 0.3))
```

### Selecting and hiding parts

```kotlin
val part = Subpolyline(
    begin = PolylinePosition(segmentIndex = 0, segmentPosition = 0.0),
    end = PolylinePosition(segmentIndex = 4, segmentPosition = 0.5),
)

polyline.select(Color.fromArgb(0xFF2196F3.toInt()), part)
polyline.hide(part)
```

### Arrows

```kotlin
val arrow = polyline.addArrow(
    position = PolylinePosition(segmentIndex = 2, segmentPosition = 0.0),
    length = 12f,
    fillColor = Color.fromArgb(0xFF212121.toInt()),
)
arrow.outlineWidth = 1f
arrow.isVisible = true
```

`polyline.arrows` lists them.

## Polygon

```kotlin
val polygon = objects.addPolygon(
    Polygon(
        outerRing = LinearRing(outerPoints),
        innerRings = listOf(LinearRing(holePoints)),
    ),
).apply {
    fillColor = Color.fromArgb(0x334CAF50)
    strokeColor = Color.fromArgb(0xFF4CAF50.toInt())
    strokeWidth = 2f
    isGeodesic = true
}
```

The fill can be a repeating image, static or animated:

```kotlin
polygon.setPattern(hatchImage, scale = 1f)
polygon.setPattern(animatedHatch, scale = 1f)
polygon.resetPattern()
```

## Circle

```kotlin
objects.addCircle(Circle(center = Point(55.751225, 37.629540), radius = 500f)).apply {
    fillColor = Color.fromArgb(0x332196F3)
    strokeColor = Color.fromArgb(0xFF2196F3.toInt())
    strokeWidth = 2f
}
```

The radius is in metres.

## Every object shares

```kotlin
mapObject.isVisible = false
mapObject.zIndex = 10f
mapObject.isDraggable = true
mapObject.userData = poi
```

`parent` is the collection the object belongs to, and `isValid` turns `false` once it has been
removed.

Hiding can be animated, with a callback when the animation ends:

```kotlin
mapObject.setVisible(
    visible = false,
    animation = Animation(Animation.Type.SMOOTH, 300.milliseconds),
    onFinished = Callback { println("hidden") },
)
```

### `userData`

`userData` is a plain `Any?` that MapKit stores next to the object and hands back on every callback.
`getCastedUserData<T>()` reads it typed:

```kotlin
data class Poi(val id: String, val title: String)

placemark.userData = Poi("1", "Red Square")

val tapListener = MapObjectTapListener { mapObject, _ ->
    val poi = mapObject.getCastedUserData<Poi>() ?: return@MapObjectTapListener false
    open(poi)
    true
}
```

### Taps and drags

```kotlin
class ObjectsController(private val objects: MapObjectCollection) {

    private val tapListener = MapObjectTapListener { mapObject, point ->
        select(mapObject)
        true
    }

    private val dragListener = MapObjectDragListener(
        onMapObjectDragStart = { it.opacity = 0.5f },
        onMapObjectDrag = { _, point -> preview(point) },
        onMapObjectDragEnd = { it.opacity = 1f },
    )

    fun add(point: Point, icon: ImageProvider) {
        objects.addPlacemark().apply {
            geometry = point
            setIcon(icon)
            isDraggable = true
            addTapListener(tapListener.asWeakRef())
            setDragListener(dragListener.asWeakRef())
        }
    }
}
```

Returning `true` from a tap listener stops the event; returning `false` lets it reach the map's
`InputListener`. Both listeners are fields, because subscriptions are weak — see
[Listeners and `WeakRef`](overview.md#listeners-and-weakref).

`PlacemarkMapObject.opacity` is a property of the placemark; the drag example above uses it to fade
the object while it is being moved.

## Working with a collection

```kotlin
objects.remove(mapObject)
objects.clear()
```

`addListener` reports what is being added and removed — MapKit adds objects asynchronously when
clustering is involved:

```kotlin
private val collectionListener = MapObjectCollectionListener(
    onMapObjectAdded = { println("added $it") },
    onMapObjectRemoved = { println("removed $it") },
)

objects.addListener(collectionListener.asWeakRef())
```

`placemarksStyler` sets a scale function shared by every placemark of the collection, instead of
setting it on each one:

```kotlin
objects.placemarksStyler.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
```

### Walking the tree

`traverse` visits everything in the collection, descending into nested collections when the start
callback returns `true`:

```kotlin
private val visitor = MapObjectVisitor(
    onPlacemarkVisited = { println("placemark at ${it.geometry}") },
    onPolylineVisited = { },
    onPolygonVisited = { },
    onCircleVisited = { },
    onCollectionVisitStart = { true },
    onCollectionVisitEnd = { },
    onClusterizedCollectionVisitStart = { true },
    onClusterizedCollectionVisitEnd = { },
)

objects.traverse(visitor.asWeakRef())
```

### Label conflicts

The root collection decides what happens when labels overlap:

```kotlin
map.mapObjects.conflictResolutionMode = ConflictResolutionMode.MAJOR
```

## Clustering

A `ClusterizedPlacemarkCollection` groups nearby placemarks into one icon. The `ClusterListener` is
called for every cluster MapKit builds, and it is where the cluster icon is set.

```kotlin
class ClusterController(
    private val objects: MapObjectCollection,
    private val clusterIcon: ImageProvider,
) {

    private val clusterTapListener = ClusterTapListener { cluster ->
        zoomTo(cluster.placemarks.map { it.geometry })
        true
    }

    private val clusterListener = ClusterListener { cluster ->
        cluster.appearance.setIcon(clusterIcon)
        cluster.appearance.setText("${cluster.size}")
        cluster.addClusterTapListener(clusterTapListener.asWeakRef())
    }

    private val collection = objects.addClusterizedPlacemarkCollection(clusterListener.asWeakRef())

    fun show(points: List<Point>, icon: ImageProvider) {
        collection.addPlacemarks(points, icon, IconStyle())
        collection.clusterPlacemarks(clusterRadius = 60.0, minZoom = 15)
    }
}
```

`clusterPlacemarks` has to be called again after the content changes — MapKit does not recluster on
its own. `clusterRadius` is in units of the placemark size, `minZoom` is the zoom above which
clustering stops.

`cluster.appearance` is a `PlacemarkMapObject`, so everything on this page applies to it.

### Creating placemarks in bulk

`addEmptyPlacemarks(points)` adds the objects without icons, which is much cheaper for a large set;
you then fill them in.

```kotlin
val placemarks = collection.addEmptyPlacemarks(points)
placemarks.forEachIndexed { index, placemark ->
    placemark.setIcon(icons[index])
    placemark.userData = pois[index]
}
```

`PlacemarkCreatedCallback` is the other bulk path: MapKit creates the object and calls you back with
it, which lets it defer the work.

```kotlin
private val createdCallback = PlacemarkCreatedCallback { placemark ->
    placemark.setIcon(icon)
}

collection.addPlacemark(createdCallback)
```

## Animated images

`AnimatedImageProvider` feeds animated icons and polygon patterns. It comes either from data or from
frames:

```kotlin
val fromData = AnimatedImageProvider.fromByteArray(bytes)
val fromFile = AnimatedImageProvider.fromFile(path)

val built = AnimatedImageProvider.fromAnimatedImage(
    AnimatedImage(loopCount = 0).apply {
        addFrame(frameOne, 100.milliseconds)
        addFrame(frameTwo, 100.milliseconds)
    },
)
```

`loopCount = 0` loops forever. Where the static `ImageProvider` comes from is described on
[Image resources](image-resources.md).
