# Migration from MapKit

Porting existing Android map code is mostly a change of import prefix. This page lists the places
where it is not.

## 1. Change the package prefix

Packages mirror MapKit's own, with `com.yandex.mapkit` replaced by `ru.sulgik.mapkit`.

| MapKit | Wrapper |
|---|---|
| `com.yandex.mapkit.geometry` | `ru.sulgik.mapkit.geometry` |
| `com.yandex.mapkit.map` | `ru.sulgik.mapkit.map` |
| `com.yandex.mapkit.mapview` | `ru.sulgik.mapkit.mapview` |
| `com.yandex.mapkit.location` | `ru.sulgik.mapkit.location` |
| `com.yandex.mapkit.user_location` | `ru.sulgik.mapkit.user_location` |
| `com.yandex.mapkit.layers` | `ru.sulgik.mapkit.layers` |
| `com.yandex.mapkit.logo` | `ru.sulgik.mapkit.logo` |
| `com.yandex.mapkit.indoor` | `ru.sulgik.mapkit.indoor` |
| `com.yandex.mapkit.traffic` | `ru.sulgik.mapkit.traffic` |
| `com.yandex.mapkit.offline_cache` | `ru.sulgik.mapkit.offline_cache` |
| `com.yandex.mapkit.storage` | `ru.sulgik.mapkit.storage` |
| `com.yandex.mapkit.uri` | `ru.sulgik.mapkit.uri` |
| `com.yandex.runtime` | `ru.sulgik.mapkit.runtime` |
| `com.yandex.mapkit.MapKitFactory` | `ru.sulgik.mapkit.MapKit` |

!!! info "Example"
    === "Before"

        ```kotlin
        val startPosition = com.yandex.mapkit.map.CameraPosition(/* ... */)

        fun setupMap(map: com.yandex.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```

    === "After"

        ```kotlin
        val startPosition = ru.sulgik.mapkit.map.CameraPosition(/* ... */)

        fun setupMap(map: ru.sulgik.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```

## 2. Move the code into `commonMain`

The map logic goes to common code; the platform side only creates the view and converts it.

=== "Kotlin (androidMain)"

    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            MapKit.initialize(this)
            setContentView(R.layout.activity_main)
            val mapView = findViewById<com.yandex.mapkit.mapview.MapView>(R.id.map)
            setupMap(mapView.mapWindow.map.toCommon())
        }
    }
    ```

=== "Kotlin (iosMain)"

    ```kotlin
    fun setupMap(mapView: YMKMapView) {
        setupMap(mapView.mapWindow.toCommon().map)
    }
    ```

`toCommon()` and `toNative()` exist for every wrapped type and live in the platform source sets
only — `commonMain` has no idea a native type exists.

## 3. Wrap listeners in `WeakRef`

MapKit stores listeners weakly and removes them by identity. In the wrapper that is spelled out in
the signature: subscriptions take `WeakRef<Listener>`.

=== "Before"

    ```kotlin
    map.addInputListener(inputListener)
    ```

=== "After"

    ```kotlin
    map.addInputListener(inputListener.asWeakRef())
    ```

The listener must be held by something else — a field of whatever owns the subscription — or it is
collected and the subscription silently stops firing. This was true in MapKit too; the wrapper only
makes it visible.

Listeners are also lambdas now. Every listener has a factory function with the same name as the
type:

```kotlin
private val inputListener = InputListener(
    onMapTap = { _, point -> println("tap at $point") },
    onMapLongTap = { _, point -> println("long tap at $point") },
)

private val tapListener = MapObjectTapListener { mapObject, _ ->
    mapObject.userData != null
}
```

## 4. Kotlin types instead of raw numbers

| MapKit | Wrapper |
|---|---|
| `Animation(SMOOTH, 0.3f)` | `Animation(Animation.Type.SMOOTH, 300.milliseconds)` |
| `long` timestamps | `kotlin.time.Instant` |
| `int` colours (`0xFF0000FF`) | `Color`, built with `Color.fromArgb(argb)` and read with `toArgb()` |
| `Point(lat, lon)` with raw doubles | `Point(lat, lon)`, backed by the `Latitude` / `Longitude` value classes |
| sentinel values for "unset" | nullable types — `poiLimit: Int?`, `focusRect: ScreenRect?` |

In the Compose module, `androidx.compose.ui.graphics.Color` is used instead, and converted for you.

## 5. Names that changed

- `MapKitFactory` is `MapKit`: `MapKitFactory.getInstance()` → `MapKit.getInstance()`,
  `MapKitFactory.setApiKey(key)` → `MapKit.setApiKey(key)`. `MapKit.initialize(Context)` exists in
  `androidMain` only, matching MapKit itself.
- `MapObjectCollection.addPlacemark(point, icon)` and its overloads are gone; MapKit deprecated them
  in favour of `addPlacemark()` plus property assignment:

    ```kotlin
    mapObjects.addPlacemark().apply {
        geometry = point
        setIcon(icon)
    }
    ```

- `PolylineMapObject.setStrokeColors` takes **palette indexes**, not colours, as MapKit does.
  Define the palette with `setPaletteColor(index, color)` first. See
  [Map objects](../wrapper/mapobjects.md#polyline).
- `Logging.subscribe` and every other subscription take a `WeakRef`.
- Getters and setters became properties: `map.isNightModeEnabled = true`,
  `mapObject.userData = data`.

## 6. What to expect from equality

Types standing for a live MapKit object — `Map`, `MapWindow`, the `MapObject` hierarchy, managers,
layers — are **handles**. A fresh wrapper is built every time such an object crosses the boundary,
so the placemark a tap listener hands you is not the same wrapper instance you added.

They compare by the object behind them, so this works:

```kotlin
val placemark = collection.addPlacemark()

val tapListener = MapObjectTapListener { tapped, _ -> tapped == placemark }
```

[Handle identity](../wrapper/overview.md#handle-identity) has the details, including the one type
that compares by value.

## 7. Not available

Anything the **lite** SDK does not ship — search, routing, panoramas, road events, personalization —
is absent. [What is wrapped](../wrapper/coverage.md#not-wrapped) lists the rest.
