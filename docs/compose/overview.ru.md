# Обзор Compose

`yandex-mapkit-kmp-compose` рисует карту из общего кода средствами Compose Multiplatform. Он
предлагает два API, и в пределах одного экрана они смешиваются только через `MapEffect`.

| | Когда использовать |
|---|---|
| [API состояний](#api-состояний) | почти всегда — декларативные объекты карты, камера и конфигурация |
| [API контроллера](#api-контроллера) | когда у вас уже есть императивный код MapKit и нужна только view |

## API состояний

`YandexMap()` создаёт `MapView` и запускает свой `content` как **вторую композицию**, узлы которой —
объекты карты. У этой композиции свой applier, поэтому она принимает только composable-функции,
помеченные `@YandexMapComposable`: `Text` или `Box` внутри неё не скомпилируется.

### Простейшая настройка

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val cameraPositionState = rememberCameraPositionState { position = startPosition }
    YandexMap(
        cameraPositionState = cameraPositionState,
        modifier = Modifier.fillMaxSize(),
    )
}
```

`rememberAndInitializeMapKit().bindToLifecycleOwner()` нужен один раз на экран, и его можно опустить,
если MapKit инициализируется где-то ещё — см. [Быстрый старт](../getting-started/quick-start.md).

### Камера

`CameraPositionState` — единственный источник правды о положении камеры. Чтение `position` вызывает
рекомпозицию при движении камеры; запись — двигает камеру.

```kotlin
val cameraPositionState = rememberCameraPositionState { position = startPosition }

LaunchedEffect(selected) {
    cameraPositionState.position = CameraPosition(selected, zoom = 16f, azimuth = 0f, tilt = 0f)
}

if (cameraPositionState.isMoving) {
    LinearProgressIndicator()
}
```

`isMoving` и `updateReason` (`GESTURES` или `APPLICATION`) говорят, что делает камера и кто это
начал: жест пользователя или ваш собственный код.

!!! warning "Один `CameraPositionState` на одну `YandexMap`"
    Общий объект состояния для двух карт заставит их драться за камеру.

Внутри содержимого карты `currentCameraPositionState` достаёт состояние окружающей карты, не
протаскивая его через параметры.

### Конфигурация карты

`MapConfig` покрывает `Map` и `MapWindow`. Все свойства nullable, и `null` означает «оставить на
усмотрение MapKit».

```kotlin
YandexMap(
    cameraPositionState = cameraPositionState,
    config = MapConfig(
        isNightModeEnabled = isSystemInDarkTheme(),
        poiLimit = 5,
        isRotateGesturesEnabled = false,
        isTiltGesturesEnabled = false,
        isScrollGesturesEnabled = true,
        isZoomGesturesEnabled = true,
        mapType = MapType.VECTOR_MAP,
        mode = MapMode.MAP,
        use2dMode = true,
        isHdModeEnabled = true,
        isIndoorEnabled = true,
        mapStyle = """[{"tags": {"any": ["building"]}, "stylers": {"visibility": "off"}}]""",
        focusRect = ScreenRect(ScreenPoint(0f, 0f), ScreenPoint(width, height * 0.6f)),
        pointOfView = PointOfView.SCREEN_CENTER,
        scaleFactor = 1f,
        fps = 30,
        cameraBounds = MapCameraBoundsConfig(
            minZoomPreference = 10f,
            maxZoomPreference = 18f,
        ),
        logo = MapLogoConfig(
            alignment = LogoAlignment(
                horizontalAlignment = LogoHorizontalAlignment.LEFT,
                verticalAlignment = LogoVerticalAlignment.BOTTOM,
            ),
            padding = LogoPadding(horizontalPadding = 16, verticalPadding = 16),
        ),
    ),
    modifier = Modifier.fillMaxSize(),
)
```

!!! info "`null` — это не то же самое, что значение по умолчанию"
    `null` означает, что обёртка вообще не трогает это свойство. Задать значение, а потом вернуть
    `null` — не значит восстановить умолчание MapKit: это лишь перестанет его обновлять.

`MapConfig` по умолчанию следует системной теме:
`MapConfig(isNightModeEnabled = isSystemInDarkTheme())`.

### События карты

`MapListeners` подписывается на всё время нахождения в композиции. Каждый колбэк необязателен, и
соответствующий слушатель MapKit подключается, только если он не `null`.

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    MapListeners(
        onMapTap = { point -> println("tap at $point") },
        onMapLongTap = { point -> println("long tap at $point") },
        onGeoObjectTap = { event ->
            val metadata = event.geoObject.selectionMetadata ?: return@MapListeners false
            selection = metadata
            true
        },
        onMapLoaded = { statistics -> println("loaded in ${statistics.fullyLoaded}") },
        onMapWindowSizeChanged = { width, height -> println("$width x $height") },
        onActivePlanFocused = { plan -> indoorPlan = plan },
        onActivePlanLeft = { indoorPlan = null },
        onActiveLevelChanged = { levelId -> activeLevel = levelId },
    )
}
```

Вернуть `false` из `onGeoObjectTap` — пропустить событие дальше, на карту, откуда оно дойдёт и до
`onMapTap`.

### Местоположение пользователя

Перегрузка `YandexMap`, принимающая `UserLocationState`, сама создаёт и держит `UserLocationLayer`:

```kotlin
@Composable
fun MapScreen() {
    val locationState = rememberUserLocationState()
    YandexMap(
        locationState = locationState,
        locationConfig = UserLocationConfig(
            isVisible = true,
            isHeadingEnabled = true,
            isAutoZoomEnabled = true,
            anchor = UserLocationConfig.Anchor(
                normal = PointF(width * 0.5f, height * 0.5f),
                course = PointF(width * 0.5f, height * 0.75f),
            ),
            pin = UserLocationConfig.LocationIcon(image = pinImage),
            arrow = UserLocationConfig.LocationIcon(image = arrowImage),
            accuracy = UserLocationConfig.LocationAccuracy(fillColor = Color(0x334CAF50)),
        ),
        modifier = Modifier.fillMaxSize(),
    )
}
```

`locationState.cameraPosition` следует за собственной позицией камеры слоя или равен `null`, пока
позиции нет. Разрешения по-прежнему запрашиваете вы — см. [Геолокацию](../wrapper/location.md).

### Пробки

```kotlin
var level by remember { mutableStateOf<TrafficLevel?>(null) }

YandexMap(modifier = Modifier.fillMaxSize()) {
    TrafficLayer(
        visible = true,
        onTrafficChanged = { level = it },
        onTrafficLoading = { },
        onTrafficExpired = { },
    )
}
```

### Группировка объектов карты

`MapObjectCollection` помещает своё содержимое во вложенную коллекцию. Коллекция сама является
объектом карты, поэтому `visible` прячет всю группу разом, а `zIndex` действует на всё; выход из
композиции убирает группу с карты.

`MapObjectCollectionState` достаёт то, что нельзя выразить параметром: общий для всех меток группы
`PlacemarksStyler` и `traverse`.

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

### Свои тайловые слои

`TileLayer` добавляет слой ваших тайлов и убирает его при выходе из композиции. `layerId` называет
слой и определяет его место в порядке отрисовки; `createTileDataSource` вызывается один раз на слой,
поэтому источник данных не следует за последующими рекомпозициями.

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    TileLayer(
        layerId = "weather",
        options = LayerOptions(transparent = true, nightModeAvailable = false),
        active = true,
        onLayerLoaded = { println("weather tiles are on screen") },
        onDataSourceUpdated = { },
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
```

`MapObjectLayer` делает то же самое для объектов карты: его содержимое попадает в независимую
коллекцию, привязанную к указанному слою, а не в коллекцию по умолчанию.

```kotlin
MapObjectLayer(layerId = "my-routes") {
    Polyline(state = rememberPolylineState(route))
}
```

!!! info "Коллекция переиспользуется"
    MapKit связывает одну коллекцию с идентификатором слоя на всю жизнь карты и не умеет её
    отвязывать, поэтому коллекция создаётся один раз на идентификатор и переиспользуется: выход из
    композиции её опустошает, повторный вход наполняет ту же самую.

### Спуск к MapKit

`MapEffect` отдаёт экземпляр `Map`, которым управляет композиция, — для всего, что не покрыто
composable-функциями. Он помечен `@YandexMapComposable` и работает только внутри содержимого
`YandexMap`.

```kotlin
YandexMap(
    cameraPositionState = cameraPositionState,
    modifier = Modifier.fillMaxSize(),
) {
    MapEffect(selection) { map ->
        val metadata = selection
        if (metadata != null) map.selectGeoObject(metadata) else map.deselectGeoObject()
    }
}
```

Как и `LaunchedEffect`, он перезапускается при смене ключей и работает в корутинном скоупе,
привязанном к композиции карты.

## API контроллера

У `YandexMap()` есть и перегрузка, принимающая `YandexMapController` и не делающая больше ничего: ни
композиции объектов карты, ни конфигурации, ни состояния камеры. Вы получаете `MapWindow` и
управляете MapKit императивно.

```kotlin
@Composable
fun MapScreen() {
    rememberAndInitializeMapKit().bindToLifecycleOwner()
    val mapController = rememberYandexMapController()
    YandexMap(
        controller = mapController,
        modifier = Modifier.fillMaxSize(),
    )
}
```

`YandexMapController.mapWindow` равен `null`, пока view не создана.

`MapControllerEffect` запускается, когда `MapWindow` уже существует, и отдаёт его не-null:

```kotlin
@Composable
fun MapScreen() {
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

Внутри этого блока применимо всё со страниц [Карта и камера](../wrapper/map.md) и
[Объекты карты](../wrapper/mapobjects.md) — включая правило, что слушателей нужно держать в поле, а
не создавать по месту.

## Что дальше

- [Объекты карты](mapobjects.md) — метки, ломаные, полигоны, окружности, кластеризация.
- [Изображения](image-resources.md) — иконки из ресурсов Compose и из composable-содержимого.
