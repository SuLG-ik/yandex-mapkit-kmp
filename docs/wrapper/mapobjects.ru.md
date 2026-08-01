# Объекты карты

Всё, что вы рисуете на карте, живёт в коллекции. `map.mapObjects` — корневая, это
`RootMapObjectCollection`, а `addCollection()` создаёт вложенные.

```kotlin
val objects = map.mapObjects
val pois = objects.addCollection()
```

Вкладывать стоит: коллекция сама является объектом карты, поэтому её сокрытие прячет всю группу,
`zIndex` действует на всё содержимое, а `clear()` опустошает её одним вызовом.

## Метка

```kotlin
val placemark = objects.addPlacemark().apply {
    geometry = Point(55.751225, 37.629540)
    setIcon(icon)
    setIconStyle(IconStyle(anchor = PointF(0.5f, 1.0f), scale = 1.2f))
    userData = poi
}
```

!!! info "`addPlacemark()` не принимает аргументов"
    MapKit объявил перегрузки `addPlacemark(point, icon)` устаревшими; объект сначала создаётся, а
    настраивается потом. Исключение — [`PlacemarkCreatedCallback`](#массовое-создание-меток).

`geometry`, `direction` и `opacity` — свойства. `setIcon(image, style)` задаёт иконку и её стиль
сразу, а `setScaleFunction(points)` делает размер зависимым от зума: каждый `PointF` — это пара
`(зум, масштаб)`:

```kotlin
placemark.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
```

### Текст

```kotlin
placemark.setText(
    text = "Красная площадь",
    style = TextStyle(
        size = 10f,
        color = Color.fromArgb(0xFF212121.toInt()),
        placement = TextStyle.Placement.BOTTOM,
        offset = 4f,
    ),
)
```

`placemark.text` возвращает живой `PlacemarkText`, у которого `text` и `style` можно менять позже.

### Объекты представления

`setIcon` — это сокращение поверх представления метки. Если запросить представление напрямую, можно
больше: составную иконку из нескольких именованных частей, 3D-модель или анимацию.

=== "Иконка"

    ```kotlin
    val icon: Icon = placemark.useIcon()
    icon.setImage(image, IconStyle(zIndex = 10f))
    icon.style = IconStyle(scale = 2f)
    ```

=== "Составная иконка"

    ```kotlin
    val composite: CompositeIcon = placemark.useCompositeIcon()
    composite.setIcon(name = "pin", image = pinImage, style = IconStyle(anchor = PointF(0.5f, 1f)))
    composite.setIcon(name = "badge", image = badgeImage, style = IconStyle(zIndex = 1f))

    composite.setIconStyle("badge", IconStyle(isVisible = false))
    composite.removeIcon("badge")
    ```

=== "Модель"

    ```kotlin
    val model: Model = placemark.useModel()
    model.modelStyle = ModelStyle(
        scale = 1f,
        unitType = ModelStyle.UnitType.NORMALIZED,
        renderMode = ModelStyle.RenderMode.USER_MODEL,
    )
    model.setData(gltfDataProvider, Callback { println("model loaded") })
    ```

=== "Анимация"

    ```kotlin
    val animation: PlacemarkAnimation = placemark.useAnimation()
    animation.setIcon(animatedImage, IconStyle())
    animation.isReversed = false
    animation.play(Callback { println("finished") })

    animation.pause()
    animation.resume()
    animation.stop()
    ```

Вызов `useIcon()` после `useModel()` заменяет представление — у метки оно ровно одно.

## Ломаная

```kotlin
val polyline = objects.addPolyline(Polyline(points))

polyline.style = LineStyle(
    strokeWidth = 5f,
    outlineWidth = 1f,
    outlineColor = Color.fromArgb(0xFF1B5E20.toInt()),
    dashLength = 8f,
    gapLength = 4f,
)
polyline.setStrokeColor(Color.fromArgb(0xFF4CAF50.toInt()))
```

### Раскраска сегментов

У ломаной из _n_ точек _n − 1_ сегментов, и каждый сегмент несёт **индекс палитры**, а не цвет.
Сначала задайте палитру, потом раздайте индексы:

```kotlin
polyline.setPaletteColor(0, Color.fromArgb(0xFF4CAF50.toInt()))
polyline.setPaletteColor(1, Color.fromArgb(0xFFFFC107.toInt()))
polyline.setPaletteColor(2, Color.fromArgb(0xFFF44336.toInt()))

polyline.setStrokeColors(listOf(0, 1, 2, 1))
```

!!! warning "`getStrokeColor` возвращает индекс"
    `getStrokeColor(segmentIndex)` отдаёт индекс палитры этого сегмента; разрешите его через
    `getPaletteColor(colorIndex)`. `setStrokeColor(color)` — другое дело: это настоящий цвет, и он
    записывает нулевой элемент палитры, которым по умолчанию пользуются все сегменты.

Перегрузка с весами распределяет цвета по ломаной пропорционально длине, а не по сегментам:

```kotlin
polyline.setStrokeColors(paletteIndices = listOf(0, 2), weights = listOf(0.7, 0.3))
```

### Выделение и сокрытие участков

```kotlin
val part = Subpolyline(
    begin = PolylinePosition(segmentIndex = 0, segmentPosition = 0.0),
    end = PolylinePosition(segmentIndex = 4, segmentPosition = 0.5),
)

polyline.select(Color.fromArgb(0xFF2196F3.toInt()), part)
polyline.hide(part)
```

### Стрелки

```kotlin
val arrow = polyline.addArrow(
    position = PolylinePosition(segmentIndex = 2, segmentPosition = 0.0),
    length = 12f,
    fillColor = Color.fromArgb(0xFF212121.toInt()),
)
arrow.outlineWidth = 1f
arrow.isVisible = true
```

`polyline.arrows` перечисляет их.

## Полигон

```kotlin
val polygon = objects.addPolygon(
    Polygon(
        outerRing = LinearRing(outerPoints),
        innerRings = listOf(LinearRing(holePoints)),
    ),
).apply {
    fillColor = Color.fromArgb(0x334CAF50)
    strokeColor = Color.fromArgb(0xFF4CAF50.toInt())
    strokeWidth = 2f
    isGeodesic = true
}
```

Заливкой может быть повторяющееся изображение, статичное или анимированное:

```kotlin
polygon.setPattern(hatchImage, scale = 1f)
polygon.setPattern(animatedHatch, scale = 1f)
polygon.resetPattern()
```

## Окружность

```kotlin
objects.addCircle(Circle(center = Point(55.751225, 37.629540), radius = 500f)).apply {
    fillColor = Color.fromArgb(0x332196F3)
    strokeColor = Color.fromArgb(0xFF2196F3.toInt())
    strokeWidth = 2f
}
```

Радиус — в метрах.

## Общее для всех объектов

```kotlin
mapObject.isVisible = false
mapObject.zIndex = 10f
mapObject.isDraggable = true
mapObject.userData = poi
```

`parent` — коллекция, которой принадлежит объект, а `isValid` становится `false`, как только объект
удалён.

Сокрытие можно анимировать, с колбэком по завершении анимации:

```kotlin
mapObject.setVisible(
    visible = false,
    animation = Animation(Animation.Type.SMOOTH, 300.milliseconds),
    onFinished = Callback { println("hidden") },
)
```

### `userData`

`userData` — это обычный `Any?`, который MapKit хранит рядом с объектом и отдаёт обратно в каждом
колбэке. `getCastedUserData<T>()` читает его типизированно:

```kotlin
data class Poi(val id: String, val title: String)

placemark.userData = Poi("1", "Красная площадь")

val tapListener = MapObjectTapListener { mapObject, _ ->
    val poi = mapObject.getCastedUserData<Poi>() ?: return@MapObjectTapListener false
    open(poi)
    true
}
```

### Нажатия и перетаскивание

```kotlin
class ObjectsController(private val objects: MapObjectCollection) {

    private val tapListener = MapObjectTapListener { mapObject, point ->
        select(mapObject)
        true
    }

    private val dragListener = MapObjectDragListener(
        onMapObjectDragStart = { it.opacity = 0.5f },
        onMapObjectDrag = { _, point -> preview(point) },
        onMapObjectDragEnd = { it.opacity = 1f },
    )

    fun add(point: Point, icon: ImageProvider) {
        objects.addPlacemark().apply {
            geometry = point
            setIcon(icon)
            isDraggable = true
            addTapListener(tapListener.asWeakRef())
            setDragListener(dragListener.asWeakRef())
        }
    }
}
```

Вернуть `true` из слушателя нажатия — остановить событие; `false` пропускает его дальше, до
`InputListener` карты. Оба слушателя лежат в полях, потому что подписки слабые — см.
[Слушатели и `WeakRef`](overview.md#слушатели-и-weakref).

`PlacemarkMapObject.opacity` — свойство метки; пример выше использует его, чтобы притушить объект во
время перетаскивания.

## Работа с коллекцией

```kotlin
objects.remove(mapObject)
objects.clear()
```

`addListener` сообщает, что добавляется и удаляется — MapKit добавляет объекты асинхронно, когда в
дело вступает кластеризация:

```kotlin
private val collectionListener = MapObjectCollectionListener(
    onMapObjectAdded = { println("added $it") },
    onMapObjectRemoved = { println("removed $it") },
)

objects.addListener(collectionListener.asWeakRef())
```

`placemarksStyler` задаёт функцию масштаба, общую для всех меток коллекции, вместо того чтобы
задавать её каждой по отдельности:

```kotlin
objects.placemarksStyler.setScaleFunction(listOf(PointF(10f, 0.5f), PointF(16f, 1f)))
```

### Обход дерева

`traverse` обходит всё содержимое коллекции, спускаясь во вложенные, когда стартовый колбэк
возвращает `true`:

```kotlin
private val visitor = MapObjectVisitor(
    onPlacemarkVisited = { println("placemark at ${it.geometry}") },
    onPolylineVisited = { },
    onPolygonVisited = { },
    onCircleVisited = { },
    onCollectionVisitStart = { true },
    onCollectionVisitEnd = { },
    onClusterizedCollectionVisitStart = { true },
    onClusterizedCollectionVisitEnd = { },
)

objects.traverse(visitor.asWeakRef())
```

### Конфликты подписей

Корневая коллекция решает, что происходит при наложении подписей:

```kotlin
map.mapObjects.conflictResolutionMode = ConflictResolutionMode.MAJOR
```

## Кластеризация

`ClusterizedPlacemarkCollection` группирует близкие метки в одну иконку. `ClusterListener`
вызывается для каждого кластера, который строит MapKit, и именно там задаётся иконка кластера.

```kotlin
class ClusterController(
    private val objects: MapObjectCollection,
    private val clusterIcon: ImageProvider,
) {

    private val clusterTapListener = ClusterTapListener { cluster ->
        zoomTo(cluster.placemarks.map { it.geometry })
        true
    }

    private val clusterListener = ClusterListener { cluster ->
        cluster.appearance.setIcon(clusterIcon)
        cluster.appearance.setText("${cluster.size}")
        cluster.addClusterTapListener(clusterTapListener.asWeakRef())
    }

    private val collection = objects.addClusterizedPlacemarkCollection(clusterListener.asWeakRef())

    fun show(points: List<Point>, icon: ImageProvider) {
        collection.addPlacemarks(points, icon, IconStyle())
        collection.clusterPlacemarks(clusterRadius = 60.0, minZoom = 15)
    }
}
```

`clusterPlacemarks` нужно вызывать заново после изменения содержимого — MapKit не перекластеризует
сам. `clusterRadius` измеряется в размерах метки, `minZoom` — зум, выше которого кластеризация
прекращается.

`cluster.appearance` — это `PlacemarkMapObject`, поэтому к нему применимо всё с этой страницы.

### Массовое создание меток

`addEmptyPlacemarks(points)` добавляет объекты без иконок, что заметно дешевле на большом наборе; их
вы заполняете сами.

```kotlin
val placemarks = collection.addEmptyPlacemarks(points)
placemarks.forEachIndexed { index, placemark ->
    placemark.setIcon(icons[index])
    placemark.userData = pois[index]
}
```

`PlacemarkCreatedCallback` — второй массовый путь: MapKit сам создаёт объект и зовёт вас с ним, что
позволяет ему отложить работу.

```kotlin
private val createdCallback = PlacemarkCreatedCallback { placemark ->
    placemark.setIcon(icon)
}

collection.addPlacemark(createdCallback)
```

## Анимированные изображения

`AnimatedImageProvider` питает анимированные иконки и заливки полигонов. Он собирается либо из
данных, либо из кадров:

```kotlin
val fromData = AnimatedImageProvider.fromByteArray(bytes)
val fromFile = AnimatedImageProvider.fromFile(path)

val built = AnimatedImageProvider.fromAnimatedImage(
    AnimatedImage(loopCount = 0).apply {
        addFrame(frameOne, 100.milliseconds)
        addFrame(frameTwo, 100.milliseconds)
    },
)
```

`loopCount = 0` означает бесконечный цикл. Откуда берётся статичный `ImageProvider`, описано на
странице [Изображения](image-resources.md).
