# Adding a map object composable, end to end

Worked example following `compose/Circle.kt` and `compose/Placemark.kt`. Everything lives in one
file named after the composable, under `commonMain/.../compose/`.

## 1. State holder + Saver

```kotlin
@Composable
public fun rememberCircleState(geometry: Circle, key: String? = null): CircleState {
    return rememberSaveable(
        key = key,
        saver = CircleState.Saver,
    ) { CircleState(geometry) }
}

@Immutable
public class CircleState(geometry: Circle) {

    public var geometry: Circle by mutableStateOf(geometry)

    public companion object {
        public val Saver: Saver<CircleState, Any> = listSaver(
            save = {
                listOf(
                    it.geometry.center.latitude.value,
                    it.geometry.center.longitude.value,
                    it.geometry.radius,
                )
            },
            restore = {
                CircleState(
                    geometry = Circle(
                        center = Point(it[0].toDouble(), it[1].toDouble()),
                        radius = it[2].toFloat(),
                    )
                )
            }
        )
    }
}
```

Why it looks like this:

- `listSaver` flattens to primitives because `rememberSaveable` must survive process death, where
  only bundle-friendly values are guaranteed.
- The `key: String?` parameter lets callers disambiguate several states of the same type in one
  composable — `rememberSaveable` keys off call-site position otherwise.
- Fields the library writes but users only read are `internal set`
  (`PlacemarkState.isDragging`, updated from the drag listener).
- The KDoc on `rememberXxxState` states the tradeoff plainly ("Other use cases may be better served
  syncing … with a data model") — keep that honesty when adding a new one.

## 2. Public composable

```kotlin
@[YandexMapComposable Composable]
public fun Circle(
    state: CircleState,
    color: Color = DefaultFillColor,
    strokeColor: Color = DefaultStrokeColor,
    strokeWidth: Float = DefaultStrokeWidth,
    geodesic: Boolean = DefaultGeodesic,
    visible: Boolean = true,
    zIndex: Float = 0.0f,
    onTap: ((Point) -> Boolean)? = null,
) {
    CircleImpl(
        state = state,
        color = color,
        strokeColor = strokeColor,
        strokeWidth = strokeWidth,
        geodesic = geodesic,
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
    )
}
```

Parameter order across the module: `state` first, then object-specific appearance, then the common
tail `visible`, `draggable`, `zIndex`, `opacity`, `onTap`. Colors are Compose colors. `onTap` returns
`Boolean` because MapKit uses the return value to mark the event consumed.

## 3. Impl + node wiring

```kotlin
@[YandexMapComposable Composable]
internal fun CircleImpl(
    state: CircleState,
    color: Color = DefaultFillColor,
    …
) {
    val collection = LocalMapObjectCollection.current
    MapObjectNode(
        visible = visible,
        zIndex = zIndex,
        onTap = onTap,
        factory = {
            val mapObject = collection.addCircle(state.geometry)
            mapObject.strokeColor = strokeColor.toMapkitColor()
            mapObject.fillColor = color.toMapkitColor()
            CircleNode(mapObject = mapObject, tapListener = onTap)
        },
        update = {
            update(state.geometry) { this.mapObject.geometry = it }
            update(strokeColor) { mapObject.strokeColor = strokeColor.toMapkitColor() }
            update(color) { mapObject.fillColor = color.toMapkitColor() }
        }
    )
}

internal class CircleNode(
    mapObject: CircleMapObject,
    tapListener: ((Point) -> Boolean)?
) : MapObjectNode<CircleMapObject>(mapObject, tapListener)

private val DefaultStrokeColor = Color(0xFF66FF00)
private const val DefaultStrokeWidth = 5f
private val DefaultFillColor = Color(0x9966FF00)
private const val DefaultGeodesic = false
```

`MapObjectNode` (in `compose/MapObject.kt`) already handles `visible`, `zIndex` and the tap listener,
so nodes only add what is specific to their object. It also fails fast when used outside the map
composition:

```kotlin
val mapApplier = currentComposer.applier as? MapApplier
    ?: error("Creating ${T::class} from not YandexMapComposable is not supported")
```

The base `MapObjectNode` removes itself from its parent collection on `onRemoved()` and drops the tap
listener — a node that adds anything else (a drag listener, child placemarks) must undo it there too:

```kotlin
internal class PlacemarkNode(…) : MapObjectNode<PlacemarkMapObject>(mapObject, tapListener) {

    private var nativeDragListener: MapObjectDragListener? = MapObjectDragListener(
        onMapObjectDrag = { _, point -> state.geometry = point },
        onMapObjectDragStart = { _ -> state.isDragging = true },
        onMapObjectDragEnd = { _ -> state.isDragging = false }
    )

    override fun onAttached() {
        super.onAttached()
        mapObject.setDragListener(nativeDragListener?.asWeakRef())
    }

    override fun onRemoved() {
        mapObject.setDragListener(null)
        super.onRemoved()
    }

    override fun onCleared() {
        super.onCleared()
        nativeDragListener = null
    }
}
```

Note the direction: `onAttached`/`onRemoved` call `super` in the order that keeps the object alive
while its listeners are being managed, and `onCleared` nulls references so the native listener does
not outlive the composition.

## 4. Variants that reuse Impl

`PlacemarkImpl` is `inline` and takes `init: PlacemarkNode.() -> Unit` and
`update: @DisallowComposableCalls Updater<PlacemarkNode>.() -> Unit` hooks, which is how
`TitledPlacemark` adds text without duplicating node wiring:

```kotlin
PlacemarkImpl(
    state = state,
    …,
    init = { mapObject.setText(title, titleStyle) },
    update = {
        update(title) { this.mapObject.setText(title, titleStyle) }
        update(titleStyle) { this.mapObject.setTextStyle(titleStyle) }
    }
)
```

`@DisallowComposableCalls` on the update lambda is required — the `Updater` block runs outside
composition, so a composable call there would be a runtime crash.

Stateful nodes that need more than property updates (like `ClusterNode`) keep custom `var`s with
setters that push into MapKit, and re-cluster when the group list or config changes. Look at
`Clustering.kt` before writing anything with a collection of child objects.

## 5. Wire-up beyond the file

- Add any new wrapper type appearing in a composable signature to
  `compose_compiler_stability_config.conf`.
- Document the composable in `docs/compose/mapobjects.md` with a `=== "Kotlin"` tab, and add it to
  the "List of supported nodes" list in that page.
- If it needs an icon, check whether `imageProvider(resource)` covers it, or whether the experimental
  `imageProvider { … }` content variant is warranted — the latter returns `ImageProvider?`, so the
  composable emits its node only once the icon has been rendered.
- Consider a state-restoration test mirroring the shape kept in
  `commonTest/.../MapObjectStatesRestorationTest.kt`.
