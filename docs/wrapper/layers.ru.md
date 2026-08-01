# Слои и тайлы

Слой — это горизонтальный срез карты со своим местом в порядке отрисовки. Собственные слои MapKit
названы в `LayerIds`; свои вы добавляете рядом с ними — либо со своими тайлами, либо с отдельной
коллекцией объектов карты.

## Свой тайловый слой

`Map.addTileLayer` принимает идентификатор, настройки слоя и колбэк, который настраивает источник
данных. Колбэк выполняется один раз, при создании слоя.

```kotlin
val layer: Layer = map.addTileLayer(
    layerId = "weather",
    layerOptions = LayerOptions(
        transparent = true,
        nightModeAvailable = false,
        cacheable = true,
    ),
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
```

`layerId` заодно определяет место слоя: MapKit упорядочивает слои по идентификатору вместе со
своими, поэтому идентификатор, сопоставленный с `LayerIds`, — это способ оказаться выше или ниже
слоя пробок, зданий или объектов карты.

### `LayerOptions`

| Параметр | По умолчанию | Что делает |
|---|---|---|
| `active` | `true` | неактивный слой ничего не рисует и не запрашивает тайлы |
| `nightModeAvailable` | `false` | у слоя есть ночной вариант |
| `cacheable` | `true` | тайлы сохраняются на диск |
| `animateOnActivation` | `true` | активация проявляется плавно |
| `tileAppearingAnimationDuration` | `150.milliseconds` | длительность проявления тайла |
| `overzoomMode` | `DISABLED` | `ENABLED` / `WITH_PREFETCH` закрывают пропуски тайлами соседних зумов |
| `transparent` | `false` | сквозь слой видно нижние |
| `versionSupport` | `false` | слой версионируется |

### Отдавать тайлы самому

`setTileProvider` заменяет URL функцией, которая возвращает байты — так отдают тайлы,
отрисованные на устройстве или прочитанные из файла в поставке:

```kotlin
builder.setTileProvider(
    TileProvider { tileId, version, _, etag ->
        RawTile(
            version = version,
            features = emptyMap(),
            etag = etag,
            useCache = RawTile.UseCache.YES,
            state = RawTile.State.OK,
            rawData = render(tileId),
        )
    },
)
```

Возвращайте `RawTile.State.NOT_MODIFIED`, когда `etag` говорит, что тайл не изменился, и
`RawTile.State.ERROR`, когда его не удалось получить.

### Управление слоем после создания

Сам `Layer` умеет только удаляться; всё остальное — на его `DataSourceLayer`:

```kotlin
val dataSource = layer.dataSourceLayer()

dataSource.isActive = false
dataSource.setStyle(id = 0, style = """[{"stylers": {"opacity": 0.5}}]""")
dataSource.resetStyles()
dataSource.clear()

layer.remove()
```

О происходящем со слоем сообщают две подписки. Обе принимают одного слушателя, а `null` его
снимает:

```kotlin
private val layerLoadedListener = LayerLoadedListener { println("tiles on screen") }
private val dataSourceListener = DataSourceListener { println("data source updated") }

dataSource.setLayerLoadedListener(layerLoadedListener.asWeakRef())
dataSource.setDataSourceListener(dataSourceListener.asWeakRef())
```

### Проекции

`Projections.wgs84Mercator` — то, чем пользуются тайлы Яндекса; `Projections.sphericalMercator` —
web-mercator, который отдаёт большинство сторонних тайловых серверов. `map.projection()` возвращает
проекцию самой карты и переводит мировые координаты в тайловые и обратно:

```kotlin
val xy: XYPoint = map.projection().worldToXY(Point(55.751225, 37.629540), zoom = 15)
val back: Point = map.projection().xyToWorld(xy, zoom = 15)
```

## Слой объектов карты

`Map.addMapObjectLayer` возвращает `RootMapObjectCollection`, который не является коллекцией карты
по умолчанию и находится на названном вами слое — так группу объектов помещают выше или ниже того,
что рисует MapKit.

```kotlin
val routeObjects = map.addMapObjectLayer("my-routes")
routeObjects.addPolyline(Polyline(points))
```

!!! warning "Одна коллекция на идентификатор, на всю жизнь карты"
    MapKit связывает коллекцию с идентификатором слоя и не умеет её отвязывать, поэтому повторный
    запрос того же идентификатора бросает исключение. Создайте её один раз и держите; чтобы
    опустошить, используйте `clear()`.

    Compose-версия `MapObjectLayer` делает это за вас — она кеширует коллекцию по идентификатору и
    только очищает её, когда composable покидает композицию.

## Пробки

```kotlin
class TrafficController(mapKit: MapKit, mapWindow: MapWindow) {

    private val layer = mapKit.createTrafficLayer(mapWindow)

    private val trafficListener = TrafficListener(
        onTrafficChanged = { level ->
            if (level != null) show(level.level, level.color)
        },
        onTrafficLoading = { showSpinner() },
        onTrafficExpired = { showStale() },
    )

    init {
        layer.isTrafficVisible = true
        layer.addTrafficListener(trafficListener.asWeakRef())
    }
}
```

`TrafficLevel` — это число от 0 до 10 плюс `TrafficColor` (`GREEN`, `YELLOW`, `RED`).
`onTrafficChanged` вызывается с `null`, пока уровень неизвестен.

Слой принимает и JSON-стили:

```kotlin
layer.setTrafficStyle("""[{"stylers": {"opacity": 0.6}}]""")
layer.setTrafficStyle(id = 1, style = dimJams)
layer.resetTrafficStyles()
```

Оба сеттера стиля возвращают, был ли стиль принят.

## В Compose

Оба вида слоёв — это composable-функции, которые снимают себя при выходе из композиции:

```kotlin
YandexMap(modifier = Modifier.fillMaxSize()) {
    TrafficLayer(onTrafficChanged = { level = it })

    TileLayer(
        layerId = "weather",
        options = LayerOptions(transparent = true),
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

    MapObjectLayer(layerId = "my-routes") {
        Polyline(state = rememberPolylineState(route))
    }
}
```

Параметры описаны в [Обзоре Compose](../compose/overview.md#свои-тайловые-слои).
