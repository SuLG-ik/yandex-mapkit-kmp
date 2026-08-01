# Что обёрнуто

Обёртка нацелена на сборку **lite** MapKit (`{{ mapkit_version }}`). Всё, что lite SDK отдаёт и на
Android, и на iOS, доступно из общего кода; эта страница — карта того, где что искать.

!!! warning "Официальная документация описывает full SDK"
    На [yandex.ru/dev/mapkit](https://yandex.ru/dev/mapkit/doc/ru/) описана сборка full. Тип,
    описанный там, не обязательно есть в lite-артефакте — раздел «Что не обёрнуто» ниже перечисляет,
    чего это лишает.

## Карта и объекты карты

`ru.sulgik.mapkit.map` повторяет `com.yandex.mapkit.map`: `Map`, `MapWindow`, `CameraPosition`,
`VisibleRegion`, `CameraBounds`, иерархия `MapObject` (`PlacemarkMapObject`, `PolylineMapObject`,
`PolygonMapObject`, `CircleMapObject`, `MapObjectCollection`, `RootMapObjectCollection`,
`ClusterizedPlacemarkCollection`) и все слушатели, которых зовёт MapKit.

Меткой можно управлять либо через методы-сокращения (`setIcon`, `setText`, `setScaleFunction`), либо
через объекты представления: `useIcon()`, `useCompositeIcon()`, `useModel()`, `useAnimation()` и
`text` возвращают `Icon`, `CompositeIcon`, `Model`, `PlacemarkAnimation` и `PlacemarkText`.

Анимированные иконки и заливка полигонов принимают `AnimatedImageProvider`, который собирается либо
из сырых данных (`fromByteArray`, `fromFile`), либо покадрово через `AnimatedImage` и `Frame`.

→ [Карта и камера](map.md), [Объекты карты](mapobjects.md)

## Объекты базовой карты

Нажатие на POI, здание или топоним приходит как `layers.GeoObjectTapEvent` с `GeoObject` внутри. Его
метаданные читаются через типизированные свойства `selectionMetadata`, `inspectionMetadata` и
`tags` — MapKit хранит их в словаре с ключами-нативными классами, у которого нет общего
представления, поэтому обёртка отдаёт записи, а не сам контейнер. `uriMetadata` и
`personalizedPoiMetadata` читают остальные виды метаданных, которые прикрепляет lite SDK.
`Map.selectGeoObject` принимает метаданные выделения обратно.

`Map.setMapLoadedListener` сообщает `MapLoadStatistics`, как только видимые тайлы отрисованы.

→ [Объекты базовой карты](geoobjects.md)

## Слои и тайлы

`Map.addTileLayer` создаёт свой тайловый слой: переданный в него `TileDataSourceBuilder` принимает
`tiles.UrlProvider` или `tiles.TileProvider`, `geometry.geo.Projection`, список `ZoomRange` и
`TileFormat`. Полученный `layers.Layer` даёт доступ к своему `DataSourceLayer`, который управляет
видимостью, JSON-стилями и подписками `LayerLoadedListener` / `DataSourceListener`.
`Map.addMapObjectLayer` делает то же самое для коллекции объектов карты.

→ [Слои и тайлы](layers.md)

## Пробки, хранилище и офлайн-карты

`MapKit.createTrafficLayer` возвращает `traffic.TrafficLayer` со своим `TrafficListener` и
`TrafficLevel`. `MapKit.storageManager` считает и ограничивает место, которое занимает MapKit;
`MapKit.offlineCacheManager` качает регионы, сообщает их `RegionState` и прогресс и переносит кеш в
другую папку.

→ [Слои и тайлы](layers.md#пробки), [Офлайн-карты и хранилище](offline.md)

## Геолокация

Кроме `LocationManager` и `LocationListener` обёртка покрывает симуляцию:
`MapKit.createLocationSimulator` проигрывает `Polyline` с `SimulationSettings` и `LocationSettings`,
а `MapKit.createDummyLocationManager` принимает позиции вручную. `lastKnownLocation()` возвращает
последнюю позицию, которую получил MapKit.

MapKit наследует `LocationSimulator` от `LocationManager`. Kotlin не может выразить это наследование
сразу на двух платформах, поэтому `LocationSimulator.asLocationManager()` возвращает тот же объект,
но как `LocationManager` — там живут `subscribeForLocationUpdates`, `requestSingleUpdate`,
`unsubscribe`, `suspend` и `resume`. Симулятор создаётся **приостановленным**, и `startSimulation`
его не возобновляет, поэтому вызовите `resume()` на этом представлении, чтобы `isActive` стал
`true`, а симулированные позиции дошли до подписчиков:

=== "Kotlin"

    ```kotlin
    val simulator = mapKit.createLocationSimulator(route)
    simulator.asLocationManager().resume()
    simulator.startSimulation(settings)
    ```

Результат — обычный `LocationManager`, поэтому его можно передать и в `MapKit.setLocationManager()`,
и в `toLocationViewSource()`.

Точно так же MapKit наследует от `LocationManager` и `DummyLocationManager`, поэтому
`DummyLocationManager.asLocationManager()` открывает те же пять членов для менеджера, чьи позиции
приложение задаёт через `setLocation`:

=== "Kotlin"

    ```kotlin
    val dummy = mapKit.createDummyLocationManager()
    dummy.asLocationManager().subscribeForLocationUpdates(settings, locationListener.asWeakRef())
    dummy.setLocation(location, DummyLocationQuality.HIGH)
    ```

→ [Геолокация](location.md)

## Runtime

`runtime.Error` и его подтипы (`LocalError`, `DiskFullError`, `NetworkError`, `RemoteError`, …)
типизируют ошибки, о которых сообщают слушатели. `runtime.logging.Logging` подписывается на поток
логов MapKit, а `runtime.i18n.I18nManager` форматирует расстояния, длительности, скорости и объёмы
данных для текущей локали.

→ [Runtime](runtime.md)

## Compose

`yandex-mapkit-kmp-compose` рисует объекты карты (`Placemark`, `Polyline`, `Polygon`, `Circle`,
`Clustering`), группирует их через `MapObjectCollection` или выносит на отдельный слой через
`MapObjectLayer`, а также добавляет слои карты — `TrafficLayer` и `TileLayer`. `MapConfig`
покрывает `Map` и `MapWindow`; `MapListeners` покрывает события карты.

Всё, что нельзя выразить параметром, живёт на объекте состояния: любой `MapObjectState` анимирует
видимость через `setVisible(visible, animation)`, `PlacemarkState` достаёт `useIcon()`,
`useCompositeIcon()`, `useModel()`, `useAnimation()`, `text` и `setScaleFunction()`, `PolylineState`
выделяет и прячет подломаные и красит сегменты через палитру, `PolygonState` задаёт анимированную
заливку, а `MapObjectCollectionState` достаёт общий `PlacemarksStyler` и `traverse`. Всё остальное —
в одном `MapEffect` от вас.

→ [Обзор Compose](../compose/overview.md)

## Что не обёрнуто

- **API сборки full.** Поиска, маршрутизации, панорам, дорожных событий и API персонализации
  (`MapKit.setAccount`, `MapKit.createOffscreenMapWindow`) в сборке lite нет.
- **`BaseDataSourceBuilder` и `mapkit.images`.** Типы в lite есть, но их никто не отдаёт наружу —
  `Map.addTileLayer` строит `TileDataSourceBuilder`.
- **`ViewProvider`.** MapKit умеет отрисовывать нативную `View` / `UIView` в иконку. Общей формы для
  этого нет; Compose-модуль закрывает ту же задачу через `imageProvider { }`.
- **`ImageProvider.id` / `isCacheable`.** Они есть только на Android — iOS MapKit принимает обычный
  `UIImage`, — поэтому остались параметрами Android-фабрик.

Всё из этого списка по-прежнему достижимо через `toNative()` из платформенных исходников.
