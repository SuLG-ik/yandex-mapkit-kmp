# Wrapper overview

`yandex-mapkit-kmp` is the module that makes MapKit reachable from common code. It mirrors MapKit's
packages, types and members, so the
[official documentation](https://yandex.ru/dev/mapkit/doc/ru/) keeps describing what a member does;
this page describes what the wrapper adds on top.

## It does not draw anything

The module wraps the API, not the view. You create a `MapView` on the platform side exactly as the
official SDK asks, convert it, and hand the result to common code.

!!! info "Example"
    === "Kotlin (commonMain)"

        ```kotlin
        fun setupMap(map: Map) {
            map.move(
                CameraPosition(Point(55.751225, 37.629540), zoom = 15f, azimuth = 0f, tilt = 0f),
            )
        }
        ```

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

To have the view itself created from common code, add
[`yandex-mapkit-kmp-compose`](../compose/overview.md).

## Crossing the boundary

Exactly two names spell every crossing, and both live in the platform source sets only:

```kotlin
public fun NativePoint.toCommon(): Point
public fun Point.toNative(): NativePoint
```

`commonMain` never sees a native type, which is what lets the same common code compile for both
platforms. Everything MapKit hands out has a `toCommon()`, and everything the wrapper holds has a
`toNative()`, so falling back to the platform SDK for something the wrapper does not cover is always
possible.

## Three kinds of type

Knowing which kind you are holding explains its behaviour.

**Value types** are immutable data — `Point`, `CameraPosition`, `IconStyle`, `Animation`,
`Location`, `LogMessage`. They are `data class`es in common code and compare by their fields.

**Handle types** stand for a live MapKit object you drive — `Map`, `MapWindow`, `PlacemarkMapObject`,
`LocationManager`, `TrafficLayer`, `Icon`. They hold the native object and forward every call to it.

**Listeners** are abstract classes with a lambda factory of the same name:

```kotlin
val tapListener = MapObjectTapListener { mapObject, point -> true }

val inputListener = InputListener(
    onMapTap = { _, point -> println("tap at $point") },
    onMapLongTap = { _, point -> println("long tap at $point") },
)
```

## Listeners and `WeakRef`

MapKit does not retain listeners: it keeps them in a weak collection and removes them by identity.
Every subscription in the wrapper therefore takes a `WeakRef<Listener>`, and the caller keeps the
strong reference.

```kotlin
class MapController(private val map: Map) {

    private val inputListener = InputListener(
        onMapTap = { _, point -> onTap(point) },
        onMapLongTap = { _, _ -> },
    )

    init {
        map.addInputListener(inputListener.asWeakRef())
    }

    fun dispose() {
        map.removeInputListener(inputListener.asWeakRef())
    }
}
```

!!! warning "Keep the listener alive yourself"
    `map.addInputListener(InputListener { /* ... */ }.asWeakRef())` compiles and then never fires:
    nothing holds the listener, so it is collected. Store it in a field of whatever owns the
    subscription — a controller, a Compose node, a screen model.

Unsubscribing works with a fresh `WeakRef` around the same listener, because the wrapper's
`toNative()` returns one stored native instance per listener for its whole life, and MapKit compares
by that instance.

`WeakRef` also has `get(): T?` and `withValue { }` for reading the referent back.

## Handle identity

A fresh wrapper is built every time a native object crosses the boundary, so the placemark a tap
listener hands you is never the same wrapper instance you added.

Handles therefore compare by the object behind them: **two handles are equal when they have the same
type and wrap the same native object**, and `hashCode()` is the wrapped object's, so a handle works
as a `Map` key or in a `Set`.

!!! info "Example"
    === "Kotlin"

        ```kotlin
        val placemark = collection.addPlacemark()

        val tapListener = MapObjectTapListener { tapped, _ ->
            tapped == placemark
        }
        ```

The type is part of the comparison on purpose. `MapObject.toCommon()` falls back to the base wrapper
for a subtype the wrapper does not know, so a plain `MapObject` and a `PlacemarkMapObject` can stand
for the same object; making them equal would break the symmetry of `equals`.

Both members are safe on an invalidated handle (`isValid == false`), where every other member throws:
they compare references and never call into MapKit.

Value types — `Point`, `CameraPosition`, `IconStyle` and the rest of the `data class`es — keep
comparing by their fields.

!!! note "`OfflineCacheError` compares by value on iOS"
    Wrapping the same native object always makes two handles equal, but on one type it is not the
    only way to be equal. `offline_cache.OfflineCacheError` wraps an `NSError` on iOS and a
    `runtime.Error` on Android, and `NSError` overrides `isEqual:` and `hash` with value semantics.
    Two distinct errors carrying the same domain, code and `userInfo` therefore compare equal on
    iOS and unequal on Android. `NSError` is immutable, so its hash never drifts; treat
    `OfflineCacheError` equality as "the same failure", not as "the same object".

## Lifetime and `isValid`

MapKit invalidates its objects when what they belong to goes away — a map object removed from its
collection, a layer removed from the map, everything after `MapKit.onTerminate()`. Touching an
invalidated object throws.

Handles expose that as `isValid`, and it is worth checking wherever an object can outlive the map:

```kotlin
if (placemark.isValid) {
    placemark.geometry = point
}
```

`equals` and `hashCode` are the exception — they never call into MapKit and stay usable.

## Kotlin instead of raw values

- `kotlin.time.Duration` for durations, `kotlin.time.Instant` for timestamps.
- Nullable types instead of sentinel values: `poiLimit: Int?`, `focusRect: ScreenRect?`,
  `lastKnownLocation(): Location?`.
- `Color`, a value class over ARGB, built with `Color.fromArgb(argb)` and read with `toArgb()`. The
  Compose module takes `androidx.compose.ui.graphics.Color` and converts it.
- `Latitude` and `Longitude` value classes behind `Point`, so the argument order cannot silently
  swap.
- Enums instead of integer constants, with no default branch: an unknown native value throws rather
  than being silently mapped onto something plausible.

## Threading

MapKit calls back on the main thread and expects to be driven from it. The wrapper adds no threading
of its own: a callback arrives on the thread MapKit chose, and a call goes straight through. Treat
every wrapper object as main-thread-only unless MapKit says otherwise.

## What is next

- [What is wrapped](coverage.md) — package-by-package coverage.
- [Map and camera](map.md), [Map objects](mapobjects.md), [Base map objects](geoobjects.md).
- [Geolocation](location.md), [Layers and tiles](layers.md),
  [Offline maps and storage](offline.md), [Runtime](runtime.md).
