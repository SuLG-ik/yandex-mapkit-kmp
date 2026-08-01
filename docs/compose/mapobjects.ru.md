# Объекты карты

## API состояний

`content` у `YandexMap()` — это отдельная композиция, узлы которой являются объектами карты. Её
composable-функции помечены `@YandexMapComposable`, и composable-функции Compose UI туда поставить
нельзя.

| Composable | Что рисует |
|---|---|
| `Placemark` | точку с иконкой |
| `TitledPlacemark` | метку с текстовой подписью |
| `Polyline` | линию |
| `Polygon` | залитую область |
| `Circle` | окружность с радиусом в метрах |
| `Clustering` | метки, сгруппированные в кластеры |
| `MapObjectCollection` | вложенную группу |
| `MapObjectLayer` | группу на отдельном слое |
| `TileLayer`, `TrafficLayer` | слои карты |
| `MapListeners` | события карты |

Каждая composable-функция объекта принимает объект состояния, созданный через `rememberXxxState()`.
Геометрия живёт в состоянии, а не в параметре, поэтому перемещение объекта — это запись в состояние,
которая не рекомпонует поддерево.

### Метка

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

`imageProvider(Res.drawable.pin_red)` собирает иконку из ресурса Compose Multiplatform — см.
[Изображения](image-resources.md).

`TitledPlacemark` добавляет подпись:

```kotlin
TitledPlacemark(
    state = rememberPlacemarkState(placemarkGeometry),
    icon = imageProvider(Res.drawable.pin_red),
    title = "Красная площадь",
    titleStyle = TextStyle(size = 10f, placement = TextStyle.Placement.BOTTOM, offset = 4f),
)
```

### Окружность

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

### Ломаная

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

### Полигон

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

## Что добавляет состояние

Объект состояния — место для всего, что нельзя выразить параметром. Он связан с объектом карты, пока
composable находится в композиции, поэтому такие вызовы делают в эффекте или обработчике события, а
не в самой композиции.

### Любой объект

```kotlin
mapObjectState.setVisible(
    visible = false,
    animation = Animation(Animation.Type.SMOOTH, 300.milliseconds),
)

mapObjectState.isValid
```

### Метка

`PlacemarkState` достаёт объекты представления и функцию масштаба:

```kotlin
val placemarkState = rememberPlacemarkState(point)

LaunchedEffect(Unit) {
    placemarkState.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
    placemarkState.useCompositeIcon().setIcon("badge", badgeImage, IconStyle(zIndex = 1f))
    placemarkState.text.text = "Красная площадь"
}
```

`geometry`, `direction` и `isDragging` — наблюдаемые свойства состояния:

```kotlin
val placemarkState = rememberPlacemarkState(point)

Placemark(state = placemarkState, icon = icon, draggable = true)

if (placemarkState.isDragging) {
    Text("Dragging from ${placemarkState.geometry}")
}
```

### Цвета сегментов ломаной

Ломаная красится через палитру. `setPaletteColor(colorIndex, color)` задаёт цвет под индексом, а
`setStrokeColors(paletteIndices)` раздаёт эти индексы сегментам — у ломаной из _n_ точек _n − 1_
сегментов. По умолчанию все сегменты используют нулевой индекс палитры, который и задаёт параметр
`strokeColor`.

`getStrokeColor(segmentIndex)` возвращает **индекс палитры** сегмента, а не его цвет; разрешите его
через `getPaletteColor(colorIndex)`.

```kotlin
polylineState.setPaletteColor(0, Color.Red)
polylineState.setPaletteColor(1, Color.Green)
polylineState.setPaletteColor(2, Color.Blue)
polylineState.setStrokeColors(listOf(0, 1, 2))
```

`PolylineState` также выделяет и прячет участки линии и добавляет стрелки:

```kotlin
polylineState.select(Color.Blue, subpolyline)
polylineState.hide(subpolyline)

polylineState.addArrow(
    position = PolylinePosition(segmentIndex = 2, segmentPosition = 0.0),
    length = 12f,
    fillColor = Color.Black,
)
```

### Заливка полигона

```kotlin
polygonState.setPattern(animatedHatch, scale = 1f)
polygonState.resetPattern()
```

### Коллекции

```kotlin
collectionState.setPlacemarksScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))

collectionState.traverse(visitor)
```

## Кластеризация

`Clustering` собирает `ClusterizedPlacemarkCollection` и перекластеризует, когда меняются группы. У
каждой `ClusterGroup` своя иконка метки; иконка кластера — общая.

=== "Одна группа"

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

=== "Несколько групп"

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

=== "С данными на элемент"

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

`groups` — это `ImmutableList` намеренно: так Compose может пропустить рекомпозицию, когда список не
менялся, а перекластеризация дорогая.

Иконки кластеров тоже могут быть composable-содержимым — см.
[Изображения](image-resources.md#composable-как-иконка-кластера).

## API контроллера

С перегрузкой-контроллером композиции объектов карты нет: `MapControllerEffect` отдаёт `MapWindow`,
как только тот появится, а дальше вы работаете напрямую через API обёртки.

=== "Метка"

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

=== "Окружность"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addCircle(circleGeometry)
    }
    ```

=== "Ломаная"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addPolyline(polylineGeometry)
    }
    ```

=== "Полигон"

    ```kotlin
    MapControllerEffect(mapController) { mapWindow ->
        mapWindow.map.mapObjects.addPolygon(polygonGeometry)
    }
    ```

Кластеризация делается так же, как в обёртке, вместе со слушателями:

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

!!! warning "Слушателей нужно `remember`"
    Подписки слабые. Слушатель, созданный по месту в композиции, будет собран на следующей
    рекомпозиции и перестанет срабатывать — оберните его в `remember` или держите там, кому
    принадлежит экран.
