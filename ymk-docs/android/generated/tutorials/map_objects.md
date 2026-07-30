---
title: "Объекты карты"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Объекты карты"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_objects.html"
---
# Объекты карты

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_objects.html)

MapKit SDK позволяет отображать на карте объекты. Все объекты карты настраиваемые: вы можете создавать уникальные пользовательские сценарии с учетом потребностей разработчиков.

## Метки

Добавьте пользовательские метки изображения на карту с помощью метода [MapObjectCollection.addPlacemark](../../../com/yandex/mapkit/map/MapObjectCollection.md#addplacemark) из поля [Map.getMapObjects](../../../com/yandex/mapkit/map/Map.md#getmapobjects).

Метод создает экземпляр метки на карте, который можно сконфигурировать: указать [Point](../../../com/yandex/mapkit/geometry/Point.md) с координатами для метки и иконку с помощью класса [ImageProvider](../../../com/yandex/runtime/image/ImageProvider.md), для инициализации которого используются ассеты

```kotlin
val placemark = map.mapObjects.addPlacemark().apply {
    geometry = Point(59.939638, 30.339916)
    setIcon(ImageProvider.fromResource(this, R.drawable.ic_pin))
}
```

С помощью приведенного выше кода создается экземпляр класса [PlacemarkMapObject](../../../com/yandex/mapkit/map/PlacemarkMapObject.md), который расширяет интерфейс [MapObject](../../../com/yandex/mapkit/map/MapObject.md).

Интерфейс [MapObject](../../../com/yandex/mapkit/map/MapObject.md) представляет каждый видимый объект на карте. Существует несколько способов настройки объектов карты: изменение видимости, разрешение перетаскивания, изменение z-индекса, настройка обработчика событий касания или перетаскивания и многое другое.

Подробнее об этом можно почитать в разделе [MapObject](../../../com/yandex/mapkit/map/MapObject.md).

### Настройка текста

Вы можете создавать текстовые надписи рядом с метками. Для этого используйте метод  [PlacemarkMapObject.setText](../../../com/yandex/mapkit/map/PlacemarkMapObject.md#settextjavalangstring).

Чтобы изменить внешний вид меток, включая их размер, цвет и положение текста относительно значка, используйте метод [TextStyle](../../../com/yandex/mapkit/map/TextStyle.md).

```kotlin
placemark.setText(
    "Special place",
    TextStyle(/* args */)
)
```

### Стили значков

Вы можете настроить представление значков меток с помощью класса [IconStyle](../../../com/yandex/mapkit/map/IconStyle.md). Он позволяет изменять положение привязки, размер, тип поворота, z-индекс, кликабельные области, видимость и плоскость по отношению к карте.

```kotlin
placemark.setIconStyle(
    IconStyle().apply {
        anchor = PointF(0.5f, 1.0f)
        scale = 0.6f
        zIndex = 10
    }
)
```

### Составные значки

Объедините несколько значков, чтобы создать составной.

1. Создайте значок по умолчанию с помощью [MapObjectCollection.addPlacemark](../../../com/yandex/mapkit/map/MapObjectCollection.md#addplacemark).
2. Используйте [PlacemarkMapObject.useCompositeIcon](../../../com/yandex/mapkit/map/PlacemarkMapObject.md#usecompositeicon), чтобы создать составной значок.
3. Используйте [CompositeIcon.setIcon](../../../com/yandex/mapkit/map/CompositeIcon.md#seticonjavalangstring-imageprovider-iconstyle), чтобы добавить новый значок к составному значку.

Полный пример кода для создания составного значка:

```kotlin
val placemark = map.mapObjects.addPlacemark().apply {
    geometry = Point(59.939638, 30.339916)
    setText(
        "Special place",
        TextStyle().apply {
            size = 10f
            placement = Placement.RIGHT
            offset = 5f
        },
    )
}

placemark.useCompositeIcon().apply {
    setIcon(
        "pin",
        ImageProvider.fromResource(this@Activity, R.drawable.ic_dollar_pin),
        IconStyle().apply {
            anchor = PointF(0.5f, 1.0f)
            scale = 0.9f
        }
    )
    setIcon(
        "point",
        ImageProvider.fromResource(this@Activity, R.drawable.ic_circle),
        IconStyle().apply {
            anchor = PointF(0.5f, 0.5f)
            flat = true
            scale = 0.05f
        }
    )
}
```

Результат:

![Пример составного значка](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_composite_icon.png)

### Анимированные метки

Вы можете создать анимированную метку из анимированного PNG-файла.

1. Создайте метку с помощью [MapObjectCollection.addPlacemark](../../../com/yandex/mapkit/map/MapObjectCollection.md#addplacemark).

   ```kotlin
   val placemark = map.mapObjects.addPlacemark() {
       geometry = Point(59.939638, 30.339916)
   }
   ```
2. Используйте метод [PlacemarkMapObject.useAnimation](../../../com/yandex/mapkit/map/PlacemarkMapObject.md#useanimation) для создания объекта анимации. Задать ресурс анимации можно при помощи экземпляра [AnimatedImageProvider](../../../com/yandex/runtime/image/AnimatedImageProvider.md).

   ```kotlin
   val animation = placemark.useAnimation().apply {
       setIcon(AnimatedImageProvider.fromAsset(this, "animation.png"))
   }
   ```
3. Запустите анимацию, управляя ею с помощью объекта [PlacemarkAnimation](../../../com/yandex/mapkit/map/PlacemarkAnimation.md).

   ```kotlin
   animation.play()
   ```

## Коллекции меток

Коллекции меток используются для группировки нескольких меток в новую коллекцию вложенных объектов карты.

1. Чтобы создать коллекцию вложенных объектов карты, используйте метод [MapObjectCollection.addCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md#addcollection).

   ```kotlin
   val pinsCollection = map.mapObjects.addCollection()
   ```
2. Теперь вы можете использовать новую коллекцию `pinsCollection` для отображения меток и других объектов карты.

   ```kotlin
   val points = listOf(
       Point(59.936046, 30.326869),
       Point(59.938185, 30.32808),
       Point(59.937376, 30.33621),
       Point(59.934517, 30.335059),
   )

   val imageProvider = ImageProvider.fromResource(this, R.drawable.ic_pin)

   points.forEach { point ->
       pinsCollection.addPlacemark().apply {
           geometry = point
           setIcon(imageProvider)
       }
   }
   ```

   > [!NOTE] Примечание
   > Используйте один экземпляр [ImageProvider](../../../com/yandex/runtime/image/ImageProvider.md), если вам нужно отобразить несколько **похожих** меток. Это будет эффективнее, чем создавать новый экземпляр для каждой метки.

   Как это выглядит после добавления меток в коллекцию новых объектов карты:
   ![Карта с коллекцией меток](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_placemarks_collection.png)

После создания коллекции `pinCollection` вы можете добавить в нее пины так же, как и для объектов [Map.getMapObjects](../../../com/yandex/mapkit/map/Map.md#getmapobjects), поскольку они имеют тот же тип [MapObjectCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md).

> [!NOTE] Примечание
> Интерфейс [MapObjectCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md) расширяет [MapObject](../../../com/yandex/mapkit/map/MapObject.md), поэтому допускается создавать вложенные коллекции и добавлять их в другие.
>
>
> Все методы, имеющие интерфейс [MapObject](../../../com/yandex/mapkit/map/MapObject.md), также доступны в [MapObjectCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md).

Вы можете итерироваться по элементам [MapObjectCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md), используя метод [BaseMapObjectCollection.traverse](../../../com/yandex/mapkit/map/BaseMapObjectCollection.md#traversemapobjectvisitor).

## Геометрии

MapKit SDK позволяет рисовать на карте примитивные геометрические объекты, такие как полигоны, полилинии и круги. Все они настраиваемые и реализуют интерфейс [MapObject](../../../com/yandex/mapkit/map/MapObject.md).

### Полигоны

Используйте полигон, когда вам нужно отобразить **область** карты для пользователей.

1. Начните с создания экземпляра [Polygon](../../../com/yandex/mapkit/geometry/Polygon.md).

   ```kotlin
   val points = listOf(
       Point(59.936046, 30.326869),
       Point(59.938185, 30.32808),
       Point(59.937376, 30.33621),
       Point(59.934517, 30.335059),
   )
   val polygon = Polygon(LinearRing(points), emptyList())
   ```
2. Используйте метод [MapObjectCollection.addPolygon](../../../com/yandex/mapkit/map/MapObjectCollection.md#addpolygonpolygon) для создания полигонального объекта карты.

   ```kotlin
   val polygonMapObject = map.mapObjects.addPolygon(polygon)
   ```

   После завершения сборки вы увидите полигон в стиле по умолчанию:
   ![Карта с полигоном по умолчанию](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_polygon.png)
3. Задайте **внутренние** точки при создании полигона, чтобы исключить часть внутри него.

   ```kotlin
   val points = listOf(
       Point(59.936046, 30.326869),
       Point(59.938185, 30.32808),
       Point(59.937376, 30.33621),
       Point(59.934517, 30.335059),
   )
   val innerPoints = listOf(
       Point(59.937487, 30.330034),
       Point(59.936688, 30.33127),
       Point(59.937116, 30.33328),
       Point(59.937704, 30.331842),
   )
   val polygon = Polygon(LinearRing(points), listOf(LinearRing(innerPoints)))
   ```

   Полигон с внутренними точками:
   ![Карта с полигоном с использованием внутренних точек](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_polygon_inner.png)
4. Измените цвет заливки и обводки по умолчанию, используя созданный экземпляр [PolygonMapObject](../../../com/yandex/mapkit/map/PolygonMapObject.md).

   ```kotlin
   polygonMapObject.apply {
       strokeWidth = 1.5f
       strokeColor = ContextCompat.getColor(this@Activity, R.color.olive)
       fillColor = ContextCompat.getColor(this@Activity, R.color.green)
   }
   ```

   ![Карта со стилизованным полигоном](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_polygon_styled.png)

Подробнее про настройку полигонов см. в разделе [PolygonMapObject](../../../com/yandex/mapkit/map/PolygonMapObject.md).

### Полилинии

Полилинии часто используются для отображения маршрутов и траекторий.

1. Создайте экземпляр [Polyline](../../../com/yandex/mapkit/geometry/Polyline.md) с искомой геометрией и добавьте на карту объект полилинейной карты с помощью метода [MapObjectCollection.addPolyline](../../../com/yandex/mapkit/map/MapObjectCollection.md#addpolylinepolyline).

   ```kotlin
   val points = listOf(
       Point(59.936046, 30.326869),
       Point(59.938185, 30.32808),
       Point(59.937376, 30.33621),
       Point(59.934517, 30.335059),
   )
   val polyline = Polyline(points)

   val polylineObject = map.mapObjects.addPolyline(polyline)
   ```
2. Настройте стили полилиний, используя переменную [PolylineMapObject](../../../com/yandex/mapkit/map/PolylineMapObject.md).

   ```kotlin
   polylineObject.apply {
       strokeWidth = 5f
       setStrokeColor(ContextCompat.getColor(this@Activity, R.color.gray))
       outlineWidth = 1f
       outlineColor = ContextCompat.getColor(this@Activity, R.color.black)
   }
   ```

   Результат после добавления полилинии на карту:
   ![Карта с добавленной полилинией](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_polyline.png)

Подробнее об этом можно почитать в разделе [PolylineMapObject](../../../com/yandex/mapkit/map/PolylineMapObject.md).

### Круги

Круги используются для отображения круглых областей.

1. Создайте экземпляр [Circle](../../../com/yandex/mapkit/geometry/Circle.md) с искомой геометрией: центральной точкой и радиусом в метрах.

   ```kotlin
   val circle = Circle(
       Point(59.935493, 30.327392),
       400f
   )
   ```
2. С помощью метода [MapObjectCollection.addCircle](../../../com/yandex/mapkit/map/MapObjectCollection.md#addcirclecircle) добавьте на карту объект круга.

   ```kotlin
   map.mapObjects.addCircle(circle).apply {
       strokeWidth = 2f
       strokeColor = ContextCompat.getColor(this, R.color.red)
       fillColor = ContextCompat.getColor(this, R.color.red_alpha)
   }
   ```

   Результат после добавления круга на карту:
   ![Карта с кругом](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_circle.png)

Подробнее о том, как настроить круговой объект карты, можно почитать в разделе [CircleMapObject](../../../com/yandex/mapkit/map/CircleMapObject.md).

## Кластеры

Кластеризованные коллекции используются для отображения нескольких меток.

1. Начните с создания [ClusterListener](../../../com/yandex/mapkit/map/ClusterListener.md) с одним методом [ClusterListener.onClusterAdded](../../../com/yandex/mapkit/map/ClusterListener.md#onclusteraddedcluster), который управляет внешним видом кластера на карте.

   ```kotlin
   val clusterListener = ClusterListener { cluster ->
       cluster.appearance.setView(
           ViewProvider(
               ClusterView(this).apply {
                   setText("${cluster.placemarks.size}")
               }
           )
       )
   }
   ```

   Свойство [Cluster.getAppearance](../../../com/yandex/mapkit/map/Cluster.md#getappearance) возвращает объект [PlacemarkMapObject](../../../com/yandex/mapkit/map/PlacemarkMapObject.md). В нашем примере мы используем метод [PlacemarkMapObject.setView](../../../com/yandex/mapkit/map/PlacemarkMapObject.md#setviewviewprovider), чтобы изменить внешний вид кластера.
   `ClusterView` — это определяемый пользователем класс. Чтобы узнать, как он реализован, посмотрите код в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-android-demo).
2. Создайте новую вложенную коллекцию с помощью метода [MapObjectCollection.addClusterizedPlacemarkCollection](../../../com/yandex/mapkit/map/MapObjectCollection.md#addclusterizedplacemarkcollectionclusterlistener).

   ```kotlin
   val clusterizedCollection = map.mapObjects.addClusterizedPlacemarkCollection(clusterListener)
   ```
3. Добавьте несколько меток в новый `clusterizedCollection`.

   ```kotlin
   val points = listOf(
       Point(59.936046, 30.326869),
       Point(59.938185, 30.32808),
       Point(59.937376, 30.33621),
       Point(59.934517, 30.335059),
   )
   val imageProvider = ImageProvider.fromResource(this, R.drawable.ic_pin)

   points.forEach { point ->
       clusterizedCollection.addPlacemark().apply {
           geometry = point
           setIcon(imageProvider)
       }
   }
   ```
4. Вызовите метод [ClusterizedPlacemarkCollection.clusterPlacemarks](../../../com/yandex/mapkit/map/ClusterizedPlacemarkCollection.md#clusterplacemarksdouble-int). Он принимает два аргумента:

   - `clusterRadius` — минимальное расстояние в единицах между объектами, которые остаются в отдельных кластерах.
   - `minZoom` — минимальный уровень масштабирования, отображающий кластеры.

   ```kotlin
   clusterizedCollection.clusterPlacemarks(60.0, 15)
   ```

   > [!WARNING] Важно
   > [ClusterizedPlacemarkCollection.clusterPlacemarks](../../../com/yandex/mapkit/map/ClusterizedPlacemarkCollection.md#clusterplacemarksdouble-int) следует вызывать явно каждый раз, когда метки добавляются в кластеризованные коллекции или удаляются из них.
   >
   >
   > Иначе кластеризованные метки не будут повторно отображаться.

   Кластеризованные метки с разным масштабом:
   ![Кластеры](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_clusters.gif)

## Разрешение конфликтов

При добавлении объектов [PlacemarkMapObject](../../../com/yandex/mapkit/map/PlacemarkMapObject.md) на карту, они могут накладываться как друг на друга, так и на иконки и подписи карты. Для разрешения конфликтов наложения предусмотрен механизм [ConflictResolutionMode](../../../com/yandex/mapkit/ConflictResolutionMode.md).

Разрешение конфликтов происходит в соотвествии с порядком отрисовки, то есть объект отрисованый выше, может вытеснить объект, отрисованый ниже, но не наоборот. Порядок отрисовки формируется на основе свойств zIndex объекта `PlacemarkMapObject` и `MapObjectCollection` которой он принадлежит. При равных `zIndex` объекты отрисовываются в том же порядке, в котором они были добавлены.

Для выставления режима разрешения конфликтов используйте метод [RootMapObjectCollection.setConflictResolutionMode](../../../com/yandex/mapkit/map/RootMapObjectCollection.md#setconflictresolutionmodeconflictresolutionmode).

> [!NOTE] Примечание
> Mapkit поддерживает настройку режима разрешения конфликтов только для корневой коллекции. Любые дочерние элементы/коллекции будут использовать режим разрешения конфликтов корневой коллекции.
> По умолчанию режим разрешения конфликтов — `ConflictResolution.Ignore`.

Пример проблемы:

![Разрешение конфликтов по умолчанию](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_resolution_ignore.png)

При установке значения `ConflictResolution.Major` для коллекции добавленные объекты начинают вытеснять подписи и иконки на карте:

![Выставленное разрешение конфликтов](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_objects/objects_resolution_major.png)

## Исходный код

Полные примеры кода из руководства смотрите в приложении `map-objects` в нашем [GitHub репозитории](https://github.com/yandex/mapkit-android-demo).
