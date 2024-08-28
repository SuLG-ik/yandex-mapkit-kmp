# Map objects

Adding map objects depends on API type that you use.

## First. States API.

It's use `YandexMap()` as States API you is able to add map objects using composable context

### Single map objects

`YandexMap()` composable has `content` parameter that's run as different composition context 
with own nodes marked as `@YandexMapComposable`. That's mean that you is not able to place Compose UI
components here, only components supported by `YandexMap`.

List of supported nodes:

- Placemark
- Circle
- Polygon
- Polyline

=== "Placemark"
    ```kotlin
    val placemarkGeometry = Point(/* */)

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            val imageProvider = imageProvider(Res.drawable.pin_red) // Using compose multiplatform resources
            Placemark(
                state = rememberPlacemarkState(placemarkGeometry),
                icon = imageProvider,
            )
        }
    }
    ```
=== "Circle"
    ```kotlin
    val circleGeometry = Circle(/* */)

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Circle(
                state = rememberCircleState(circleGeometry),
                color =  Color.Red.copy(alpha = 0.6f), // optional
            )
        }
    }
    ```
=== "Polyline"
    ```kotlin
    val polylineGeometry = Polyline(/* */)

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Polyline(
                state = rememberPolylineState(polylineGeometry),
                outlineColor = Color.DarkGray.copy(alpha = 0.4f), // optional
                strokeColor = Color.Gray.copy(alpha = 0.4f), // optional
            )
        }
    }
    ```
=== "Polygon"
    ```kotlin
    val polgygonGeometry = Polyline(/* */)

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Polygon(
                state = rememberPolygonState(polgygonGeometry),
                outlineColor = Color.DarkGray.copy(alpha = 0.4f), // optional
                strokeColor = Color.Gray.copy(alpha = 0.4f), // optional
            )
        }
    }
    ```

### Clustering

Clustering is feature to group multiple Placemark.


=== "Single group"
    ```kotlin
    val placemarks: List<Point> = /* */

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        val pinRedImageProvider = imageProvider(Res.drawable.pin_red)
        val clusterImageProvider = imageProvider(Res.drawable.cluster)

        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Clustering(
                group = ClusterGroup(
                    placemarks = redPlacemarks,
                    icon = pinRedImageProvider,
                ),
                icon = clusterImageProvider,
            )
        }
    }
    ```
=== "Multiple groups"
    ```kotlin
    val redPlacemarks: List<Point> = /* */
    val greenPlacemarks: List<Point> = /* */
    val yellowPlacemarks: List<Point> = /* */

    @Composable
    fun MapScreen() {
        val cameraPositionState = rememberCameraPositionState { position = startPosition }
        val pinRedImageProvider = imageProvider(Res.drawable.pin_red)
        val pinGreenImageProvider = imageProvider(Res.drawable.pin_green)
        val pinYellowImageProvider = imageProvider(Res.drawable.pin_yellow)
        val clusterImageProvider = imageProvider(Res.drawable.cluster)

        YandexMap(
            cameraPositionState = cameraPositionState,
            modifier = Modifier.fillMaxSize(),
        ) {
            Clustering(
                groups = persistentListOf(
                    ClusterGroup(
                        placemarks = redPlacemarks,
                        icon = pinRedImageProvider,
                    ),
                    ClusterGroup(
                        placemarks = greenPlacemarks,
                        icon = pinGreenImageProvider,
                    ),
                    ClusterGroup(
                        placemarks = yellowPlacemarks,
                        icon = pinYellowImageProvider,
                    ),
                ),
                icon = clusterImageProvider,
            )
        }
    }
    ```

## Second. Controller API.

### Single map objects

You can use `MapControllerEffect` on your `YandexMapController` instance to add map objects.

Effect will be launched once with initialized non-null `MapWindow` instance. For more info follow
official documentation. Use `MapWindow.map.mapObjects` to add new map object.

=== "PlacemarkMapObject"
    ```kotlin
    val placemarkGeometry = Point(/* */)
    @Composable
    fun MapScreen() {
        val mapController = rememberYandexMapController()
        val pinGreenImage = imageProvider(Res.drawable.pin_green)
        MapControllerEffect(mapController) { mapWindow ->
            mapWindow.map.mapObjects.addPlacemark().apply {
                geometry = placemarkGeometry
                setIcon(pinGreenImage)
            }
        }
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```
=== "CircleMapObject"
    ```kotlin
    val circleGeometry = Circle(/* */)
    @Composable
    fun MapScreen() {
        val mapController = rememberYandexMapController()
        MapControllerEffect(mapController) { mapWindow ->
            mapWindow.map.mapObjects.addCircle(circleGeometry)
        }
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```
=== "PolylineMapObject"
    ```kotlin
    val polylineGeometry = Polyline(/* */)
    @Composable
    fun MapScreen() {
        val mapController = rememberYandexMapController()
        MapControllerEffect(mapController) { mapWindow ->
            mapWindow.map.mapObjects.addPolyline(polylineGeometry)
        }
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```
=== "PolygonMapObject"
    ```kotlin
    val polygonGeometry = Polygon(/* */)
    @Composable
    fun MapScreen() {
        val mapController = rememberYandexMapController()
        MapControllerEffect(mapController) { mapWindow ->
            mapWindow.map.mapObjects.addPolygon(polygonGeometry)
        }
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```


### Clustering

You can use `MapControllerEffect` on your `YandexMapController` instance to add Placemarks.

Effect will be launched once with initialized non-null `MapWindow` instance. For more info follow
official documentation. Use `MapWindow.map.mapObjects` to add new map object.

=== "Kotlin"
    ```kotlin
    val placemarks: List<Pair<Point, MapObjectUserData>> = /* */ 
    @Composable
    fun MapScreen() {
        val pinRedImageProvider = imageProvider(Res.drawable.pin_red)
        val pinGreenImageProvider = imageProvider(Res.drawable.pin_green)
        val pinYellowImageProvider = imageProvider(Res.drawable.pin_yellow)
        val clusterImageProvider = imageProvider(Res.drawable.cluster)
        val mapController = rememberYandexMapController()
        MapControllerEffect(mapController) { mapWindow ->
            val typeToImageMap = mapOf(
                MapObjectType.YELLOW to pinYellowImage,
                MapObjectType.RED to pinRedImage,
                MapObjectType.GREEN to pinGreenImage
            )
            val cluster =
                mapWindow.map.mapObjects.addClusterizedPlacemarkCollection(clusterListener)
            placemarks.forEach { (point, data) ->
                cluster.addPlacemark().apply {
                    geometry = point
                    setIcon(typeToImageMap[data.type]!!)
                    userData = data
                    addTapListener(mapObjectTapListener)
                }
            }
            cluster.clusterPlacemarks(60.0, 15)
        }}
        YandexMap(
            controller = mapController,
            modifier = Modifier.fillMaxSize(),
        )
    }
    ```
