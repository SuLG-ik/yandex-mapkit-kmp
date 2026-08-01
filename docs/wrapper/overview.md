# Wrapper overview

`yandex-mapkit-kmp` is main module to control Yandex MapKit from common code.

## Usage cases

`yandex-mapkit-kmp` module is not provide any abilities to draw map on your platform. It is provide 
only common wrapper in common code and actual implementations for Android and iOS targets.

You should create `MapView` on your platform and provide common instance to your map control
logic in common code by converting platform-specific type to common using `<NativeType>.toCommon()`
extension method.

!!! info "Example"
    All supporting platform-native types has converters to common types
    === "Kotlin commonMain"
        ```kotlin
        fun setupMap(map: ru.sulgik.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```
    === "Kotlin androidMain"
        ```kotlin
        class MainActivity : ComponentActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                // ...
                val mapView: com.yandex.mapkit.mapview.MapView = /* findViewById(), for example */
                setupMap(mapView.mapWindow.map.toCommon())
            }
        }
        ```

## Migrate your Android sources to common.

Library save original MapKit package name parts, class, methods naming in most cases.

- Change package name from `com.yandex.mapkit` to `ru.sulgik.mapkit` in map control logic.
- Call `<NativeType>.toCommon(): <CommonType>` extension method to convert native type to common.
- Pass common type to your map control logic

!!! info "Example"
    === "Was"
        ```kotlin
        val startPosition = com.yandex.mapkit.map.CameraPosition(/* ... */)
        fun setupMap(map: com.yandex.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```
    === "Became"
        ```kotlin
        val startPosition = ru.sulgik.mapkit.map.CameraPosition(/* ... */)
        fun setupMap(map: ru.sulgik.mapkit.map.Map) {
            map.move(startPosition)
        }
        ```

## Handle identity

Types that stand for a live MapKit object — `Map`, `MapWindow`, the `MapObject` hierarchy, the
presentation objects, the `Error` hierarchy, the managers and the layers — are handles. A fresh
wrapper is built every time such an object crosses the boundary, so the placemark a tap listener
hands you is never the same wrapper instance you added.

They therefore compare by the object behind them: **two handles are equal when they have the same
type and wrap the same native object**, and `hashCode()` is the wrapped object's, so a handle can be
used as a `Map` key or kept in a `Set`.

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
comparing by their fields as before.

!!! note "`OfflineCacheError` compares by value on iOS"
    Wrapping the same native object always makes two handles equal, but on one type it is not the
    only way to be equal. `offline_cache.OfflineCacheError` wraps an `NSError` on iOS and a
    `runtime.Error` on Android, and `NSError` overrides `isEqual:` and `hash` with value semantics.
    Two distinct errors carrying the same domain, code and `userInfo` therefore compare equal on
    iOS and unequal on Android. `NSError` is immutable, so its hash never drifts; treat
    `OfflineCacheError` equality as "the same failure", not as "the same object".
