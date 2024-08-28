# Compose overview

`yandex-mapkit-kmp-compose` module contains features to draw map in your common code using Compose Multiplatform.
It contains two variants of API.

## First. States API.

It's use `YandexMap()` composable function draw map and composition context to add MapObjects.
All map configuration pass to `YandexMap()` and nested objects using compose runtime.

### Simple setup

`YandexMap()` composable creates MapView instance in place and draw using compose platform interop
features. `CameraPositionState` control it's map instance.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner() // if is not called earlier
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize()
        )
    }
    ```

!!! warning "`CameraPositionState` can't be provided to multiple `YandexMap`s"

### Configure map

States API provides `MapConfig` type to configure `Map` object.

!!! info "If `MapConfig`'s property is null, it's use MapKit built-in value"

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        // ...
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            config = MapConfig(
                isNightModeEnabled = isSystemInDarkTheme(),
                poiLimit = 5,
                isFastTapEnabled = null,
                isRotateGesturesEnabled = false,
                isTiltGesturesEnabled = false,
                isScrollGesturesEnabled = false,
                isZoomGesturesEnabled = true,
                mapType = null,
                use2dMode = true,
                logo = MapLogoConfig(
                    alignment = LogoAlignment(
                        horizontal = LogoHorizontalAlignment.LEFT,
                        vertical = LogoVerticalAlignment.TOP,
                    ),
                ),
            ),
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```

### Advanced. Map effect

States API useful in different cases and might be useful in most simple cases. But if necessary 
API is not covered with it you is able to use `MapEffect`.

`MapEffect` marked as `@YandexMapComposable` and can be launched only from `YandexMap` content.
`MapEffect` provides `Map` instance that is used in `YandexMap`

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            MapEffect { map ->
                map.move(startPosition)
            }
        }
    }
    ```

## Second. Controller API.

### Simple setup

It's use `YandexMap()` composable function draw map. It receives YandexMapController that control
map using common providing MapWindow instance via controller .

It is not use compose runtime to control map. It provide instance of `MapWindow` 
via `YandexMapController.mapWindow`.

!!! info "`YandexMapController.mapWindow` is null if it is not created by YandexMap yet"

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        rememberAndInitializeMapKit().bindToLifecycleOwner() // if is not called earlier
        val mapController = rememberYandexMapController()
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```

### Configure controller

Effect that receives created YandexMapController instance and launched only if `MapWindow` created.
Useful to setup controller.

!!! info "Provided `MapWindow` instance is non-null value"

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        //...
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
