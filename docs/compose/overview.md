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
                        horizontalAlignment = LogoHorizontalAlignment.LEFT,
                        verticalAlignment = LogoVerticalAlignment.TOP,
                    ),
                ),
            ),
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```

### Map events

`MapListeners` subscribes to the map events for as long as it stays in the composition. Every
callback is optional and the matching MapKit listener is attached only when it is not `null`.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        YandexMap(modifier = Modifier.fillMaxSize()) {
            MapListeners(
                onMapTap = { point -> println("tap at $point") },
                onGeoObjectTap = { event ->
                    val metadata = event.geoObject.selectionMetadata ?: return@MapListeners false
                    controller.map?.selectGeoObject(metadata)
                    true
                },
                onMapLoaded = { statistics -> println("loaded in ${statistics.fullyLoaded}") },
            )
        }
    }
    ```

### Traffic

`TrafficLayer` shows the traffic jams layer and removes it when it leaves the composition.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        var level by remember { mutableStateOf<TrafficLevel?>(null) }
        YandexMap(modifier = Modifier.fillMaxSize()) {
            TrafficLayer(onTrafficChanged = { level = it })
        }
    }
    ```

### Grouping map objects

`MapObjectCollection` puts its content into a nested collection. The collection is a map object
itself, so `visible` hides the whole group at once and `zIndex` applies to all of it; leaving the
composition removes the group from the map.

`MapObjectCollectionState` reaches what a parameter cannot express — the `PlacemarksStyler` shared
by every placemark of the group, and `traverse`.

=== "Kotlin"
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
once per layer.

=== "Kotlin"
    ```kotlin
    @Composable
    fun MapScreen() {
        YandexMap(modifier = Modifier.fillMaxSize()) {
            TileLayer(
                layerId = "weather",
                options = LayerOptions(transparent = true, nightModeAvailable = false),
                onLayerLoaded = { println("weather tiles are on screen") },
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
    }
    ```

`MapObjectLayer` does the same for map objects: its content is added to an independent collection
linked to the given layer instead of the default one.

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
