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