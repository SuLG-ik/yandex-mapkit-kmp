# Карта и камера

`MapWindow` — это поверхность, `Map` — то, чем вы управляете. На платформе это
`mapView.mapWindow.map`, а в общем коде — `mapWindow.map`.

## Движение камеры

`CameraPosition` — value-тип: точка, зум, азимут и наклон.

```kotlin
val moscow = CameraPosition(
    target = Point(55.751225, 37.629540),
    zoom = 15f,
    azimuth = 0f,
    tilt = 0f,
)

map.move(moscow)
```

С анимацией и `CameraCallback`, который сообщает, завершилось движение или было отменено следующим:

```kotlin
map.move(
    cameraPosition = moscow,
    animation = Animation(Animation.Type.SMOOTH, 1.seconds),
    cameraCallback = CameraCallback { completed ->
        if (completed) println("arrived")
    },
)
```

!!! info "Длительности — это `kotlin.time.Duration`"
    MapKit принимает секунды как `Float`; обёртка принимает `1.seconds`, `300.milliseconds` и
    конвертирует сама.

### Вписать геометрию в экран

`cameraPosition(geometry)` вычисляет позицию, которая проецирует геометрию в фокус-прямоугольник,
ничего при этом не двигая:

```kotlin
val route = Polyline(points)

map.move(
    map.cameraPosition(route.toGeometry()),
    Animation(Animation.Type.SMOOTH, 500.milliseconds),
)
```

`focusRect`, `azimuth` и `tilt` необязательны и по умолчанию берутся из текущего состояния карты:

```kotlin
map.cameraPosition(
    geometry = boundingBox.toGeometry(),
    focusRect = ScreenRect(ScreenPoint(0f, 0f), ScreenPoint(width, height * 0.6f)),
    azimuth = 0f,
    tilt = 0f,
)
```

Любой тип геометрии превращается в `Geometry` через `toGeometry()` — `Point`, `Polyline`, `Polygon`,
`MultiPolygon`, `BoundingBox`, `Circle`.

### Ограничить камеру

```kotlin
map.cameraBounds.apply {
    setMinZoomPreference(10f)
    setMaxZoomPreference(18f)
    latLngBounds = BoundingBox(
        southWest = Point(55.55, 37.35),
        northEast = Point(55.95, 37.85),
    )
}
```

`resetMinMaxZoomPreference()` возвращает ограничения зума обратно MapKit.

### Следить за камерой

```kotlin
class MapController(private val map: Map) {

    private val cameraListener = CameraListener { _, position, reason, finished ->
        if (finished && reason == CameraUpdateReason.GESTURES) {
            reload(position.target)
        }
    }

    init {
        map.addCameraListener(cameraListener.asWeakRef())
    }
}
```

`CameraUpdateReason` отличает `GESTURES` от `APPLICATION`. Слушателя нужно держать в поле — см.
[Слушатели и `WeakRef`](overview.md#слушатели-и-weakref).

## Видимая область

`visibleRegion` — это четыре угла того, что сейчас на экране; `visibleRegion(cameraPosition)`
вычисляет их для позиции, до которой камера ещё не доехала.

```kotlin
val region: VisibleRegion = map.visibleRegion

val bounds: BoundingBox = region.getBounds()
val geometry: Geometry = region.toPolygon()

val visible = pois.filter { poi ->
    poi.latitude in bounds.southWest.latitude..bounds.northEast.latitude &&
        poi.longitude in bounds.southWest.longitude..bounds.northEast.longitude
}
```

`Latitude` и `Longitude` — value-классы, реализующие `Comparable`, поэтому проверка диапазона выше
компилируется.

`getBounds()` есть также у `Point`, `Polyline`, `LinearRing`, `Polygon`, `BoundingBox` и у пары
bounding box'ов — так наращивают общий прямоугольник по набору объектов.

## Экранные и мировые координаты

```kotlin
val screenPoint: ScreenPoint? = mapWindow.worldToScreen(Point(55.751225, 37.629540))
val worldPoint: Point? = mapWindow.screenToWorld(ScreenPoint(100f, 200f))
```

Оба возвращают `null`, если точку спроецировать нельзя — она за горизонтом или вне окна.

`mapWindow.width` и `mapWindow.height` — размер в физических пикселях, а `addSizeChangedListener`
сообщает об изменениях:

```kotlin
private val sizeChangedListener = SizeChangedListener { _, width, height ->
    println("$width x $height")
}

mapWindow.addSizeChangedListener(sizeChangedListener.asWeakRef())
```

## Фокус и точка обзора

`focusRect` сужает область окна, о которой рассуждает камера, — это нужно, когда нижнюю половину
карты закрывает bottom sheet и «по центру» должно означать по центру видимой части.

```kotlin
mapWindow.focusRect = ScreenRect(
    topLeft = ScreenPoint(0f, 0f),
    bottomRight = ScreenPoint(mapWindow.width.toFloat(), mapWindow.height * 0.6f),
)
```

`focusPoint` смещает точку, вокруг которой камера вращается и масштабируется, `gestureFocusPoint`
делает то же самое только для жестов, а `gestureFocusPointMode` решает, действует ли она всегда или
только во время жеста. `focusRegion` — видимая область фокус-прямоугольника.

`pointOfView` переключается между `SCREEN_CENTER` и `ADAPT_TO_FOCUS_POINT_HORIZONTALLY`.

`scaleFactor` масштабирует содержимое карты — подписи, иконки, толщину линий — относительно
плотности экрана.

## Жесты и внешний вид

```kotlin
map.isRotateGesturesEnabled = false
map.isTiltGesturesEnabled = false
map.isScrollGesturesEnabled = true
map.isZoomGesturesEnabled = true

map.isFastTapEnabled = true
map.isNightModeEnabled = isDarkTheme
map.poiLimit = 5
map.mapType = MapType.VECTOR_MAP
map.set2DMode(true)
```

`mapType` выбирает `NONE`, `MAP`, `SATELLITE`, `HYBRID` или `VECTOR_MAP`. `mode` выбирает назначение
карты — `MAP`, `TRANSIT`, `DRIVING`, `ADMIN`, `LEGACY_MAP`, `FUTURE_MAP`, `HYBRID` — и меняет то, что
подчёркивает базовая карта.

`isHdModeEnabled`, `isAwesomeModelsEnabled`, `isTransparentBackgroundEnabled` и
`isBuildingsAboveIndoorEnabled` — оставшиеся переключатели отрисовки. `poiLimit = null` возвращает
ограничение обратно MapKit.

## Стили карты

JSON-трансформация стиля в формате, описанном
[официальной документацией](https://yandex.ru/dev/mapkit/doc/ru/android/generated/style):

```kotlin
val applied = map.setMapStyle(
    """[{"tags": {"any": ["building"]}, "stylers": {"visibility": "off"}}]""",
)
```

Несколько стилей могут сосуществовать под разными идентификаторами, а `resetMapStyles()` снимает
все:

```kotlin
map.setMapStyle(id = 1, style = hideBuildings)
map.setMapStyle(id = 2, style = dimRoads)
map.resetMapStyles()
```

## Нажатия на карту

`InputListener` сообщает о нажатиях, которые попали в саму карту, а не в объект на ней.

```kotlin
class MapController(private val map: Map) {

    private val inputListener = InputListener(
        onMapTap = { _, point -> addPlacemark(point) },
        onMapLongTap = { _, point -> openMenu(point) },
    )

    init {
        map.addInputListener(inputListener.asWeakRef())
    }
}
```

Нажатие на POI, здание или топоним сначала уходит в `GeoObjectTapListener` — см.
[Объекты базовой карты](geoobjects.md).

## Дождаться отрисовки карты

`MapLoadedListener` срабатывает, когда видимые тайлы отрисованы, и приносит тайминги и количество
объектов:

```kotlin
private val mapLoadedListener = MapLoadedListener { statistics ->
    println("fully loaded in ${statistics.fullyLoaded}, ${statistics.renderObjectCount} objects")
}

map.setMapLoadedListener(mapLoadedListener.asWeakRef())
```

Передайте `null`, чтобы перестать слушать.

## Планы помещений

Когда камера над зданием с планом помещений, MapKit сообщает об этом и позволяет переключать этажи:

```kotlin
class IndoorController(private val map: Map) {

    private var plan: IndoorPlan? = null

    private val indoorStateListener = IndoorStateListener(
        onActivePlanFocused = { plan = it },
        onActivePlanLeft = { plan = null },
        onActiveLevelChanged = { levelId -> println("level $levelId") },
    )

    init {
        map.isIndoorEnabled = true
        map.addIndoorStateListener(indoorStateListener.asWeakRef())
    }

    fun selectLevel(levelId: String) {
        plan?.activeLevelId = levelId
    }
}
```

`IndoorPlan.levels` перечисляет `IndoorLevel` текущего плана.

## Логотип Яндекса

MapKit требует, чтобы логотип оставался видимым; его можно только переместить.

```kotlin
map.logo.setAlignment(
    LogoAlignment(
        horizontalAlignment = LogoHorizontalAlignment.LEFT,
        verticalAlignment = LogoVerticalAlignment.BOTTOM,
    ),
)
map.logo.setPadding(LogoPadding(horizontalPadding = 16, verticalPadding = 16))
```

## Оверлеи

`addRasterScreenOverlay()` кладёт растровое изображение поверх карты в экранных координатах —
легенду, компас, шкалу погоды:

```kotlin
val overlay = mapWindow.addRasterScreenOverlay()
overlay.setImage(legendImage, ScreenRect(ScreenPoint(16f, 16f), ScreenPoint(216f, 96f)))

overlay.remove()
```

## Геометрические помощники

`Geo` покрывает вычисления, которые отдаёт MapKit:

```kotlin
val metres = Geo.distance(from, to)
val bearing = Geo.course(from, to)
val nearest = Geo.closestPoint(point, Segment(from, to))
val midpoint = Geo.pointOnSegmentByFactor(Segment(from, to), factor = 0.5)
```

`PolylineUtils` и `SubpolylineHelper` работают с ломаными и позициями на них, а `Projection` (из
`map.projection()`) переводит мировые координаты в тайловые `XYPoint` и обратно.

## Частота кадров

```kotlin
mapWindow.setMaxFps(30)
```

## Очистка карты

`map.wipe()` удаляет всё, что MapKit нарисовал и закешировал для этой карты. Это тяжёлая операция,
рассчитанная на момент разрушения карты, а не на скрытие объектов — для этого есть
`mapObjects.clear()`.
