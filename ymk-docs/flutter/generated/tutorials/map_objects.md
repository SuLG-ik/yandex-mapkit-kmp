---
title: "Объекты карты"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Объекты карты"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_objects.html"
---
# Объекты карты

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_objects.html)

MapKit SDK позволяет отображать на карте объекты. Все объекты карты настраиваемые: вы можете создавать уникальные пользовательские сценарии с учетом потребностей разработчиков.

## Метки

Добавьте пользовательские метки изображения на карту с помощью метода [MapObjectCollection.addPlacemark](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addPlacemark.html) из поля [Map.mapObjects](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/mapObjects.html).

Метод создает экземпляр метки на карте, который можно сконфигурировать: указать [Point](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Point-class.html) с координатами для метки и иконку с помощью класса [ImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/image/ImageProvider-class.html), для инициализации которого используются ассеты

```dart
final placemark = map.mapObjects.addPlacemark()
  ..geometry = const Point(latitude: 59.939638, longitude: 30.339916)
  ..setIcon(ImageProvider.fromImageProvider(const AssetImage("assets/ic_pin.png")));
```

С помощью приведенного выше кода создается экземпляр класса [PlacemarkMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject-class.html), который расширяет интерфейс [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html).

Интерфейс [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html) представляет каждый видимый объект на карте. Существует несколько способов настройки объектов карты: изменение видимости, разрешение перетаскивания, изменение z-индекса, настройка обработчика событий касания или перетаскивания и многое другое.

Подробнее об этом можно почитать в разделе [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html).

### Настройка текста

Вы можете создавать текстовые надписи рядом с метками. Для этого используйте метод  [PlacemarkMapObject.setText](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject/setText.html).

Чтобы изменить внешний вид меток, включая их размер, цвет и положение текста относительно значка, используйте метод [TextStyle](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/TextStyle-class.html).

```dart
placemark
  ..setText("Special place")
  ..setTextStyle(TextStyle(/* args */));
```

### Стили значков

Вы можете настроить представление значков меток с помощью класса [IconStyle](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/IconStyle-class.html). Он позволяет изменять положение привязки, размер, тип поворота, z-индекс, кликабельные области, видимость и плоскость по отношению к карте.

```kotlin
placemark.setIconStyle(
  IconStyle(
    anchor: Point(0.5, 1.0)
    scale: 0.6
    zIndex: 10.0
  )
);
```

### Составные значки

Объедините несколько значков, чтобы создать составной.

1. Создайте значок по умолчанию с помощью [MapObjectCollection.addPlacemark](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addPlacemark.html).
2. Используйте [PlacemarkMapObject.useCompositeIcon](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject/useCompositeIcon.html), чтобы создать составной значок.
3. Используйте [CompositeIcon.setIcon](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CompositeIcon/setIcon.html), чтобы добавить новый значок к составному значку.

Полный пример кода для создания составного значка:

```dart
final placemark = map.mapObjects.addPlacemark()
  ..geometry = const Point(latitude: 59.939638, longitude: 30.339916)
  ..setText("Special place")
  ..setTextStyle(
      const mapkit.TextStyle(
        size: 10.0,
        color: Colors.black,
        outlineColor: Colors.white,
        placement: TextStylePlacement.Right,
        offset: 5.0,
      )
  );

placemark.useCompositeIcon()
  ..setIcon(
      ImageProvider.fromImageProvider(const AssetImage("assets/ic_dollar_pin.png")),
      const IconStyle(
        anchor: Point(0.5, 1.0),
        scale: 4.0,
      ),
      name: "pin",
    )
  ..setIcon(
      ImageProvider.fromImageProvider(const AssetImage("assets/ic_circle.png")),
      const IconStyle(
        anchor: Point(0.5, 0.5)
        flat: true
        scale: 0.2
      )
      name: "point",
    );
}
```

Результат:

![Пример составного значка](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_composite_icon.png)

### Анимированные метки

Вы можете создать анимированную метку из анимированного PNG-файла.

1. Создайте метку с помощью [MapObjectCollection.addPlacemark](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addPlacemark.html).

   ```dart
   final placemark = map.mapObjects.addPlacemark()
     ..geometry = const Point(latitude: 59.939638, longitude: 30.339916);
   ```
2. Используйте метод [PlacemarkMapObject.useAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject/useAnimation.html) для создания объекта анимации. Задать ресурс анимации можно при помощи экземпляра [AnimatedImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/image/AnimatedImageProvider-class.html).

   ```dart
   final animation = placemark.useAnimation()
     ..setIcon(AnimatedImageProvider.fromAsset("assets/animation.png"));
   ```
3. Запустите анимацию, управляя ею с помощью объекта [PlacemarkAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkAnimation-class.html).

   ```dart
   animation.play();
   ```

## Коллекции меток

Коллекции меток используются для группировки нескольких меток в новую коллекцию вложенных объектов карты.

1. Чтобы создать коллекцию вложенных объектов карты, используйте метод [MapObjectCollection.addCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addCollection.html).

   ```dart
   final pinsCollection = map.mapObjects.addCollection();
   ```
2. Теперь вы можете использовать новую коллекцию `pinsCollection` для отображения меток и других объектов карты.

   ```dart
   final points = [
       Point(latitude: 59.936046, longitude: 30.326869),
       Point(latitude: 59.938185, longitude: 30.32808),
       Point(latitude: 59.937376, longitude: 30.33621),
       Point(latitude: 59.934517, longitude: 30.335059),
   ];

   final imageProvider = ImageProvider.fromImageProvider(const AssetImage("assets/ic_pin.png"));

   points.forEach((point) {
     pinsCollection.addPlacemark()
       ..geometry = point
       ..setIcon(imageProvider);
   });
   ```

   > [!NOTE] Примечание
   > Используйте один экземпляр [ImageProvider](https://pub.dev/documentation/yandex_maps_navikit/latest/image/ImageProvider-class.html), если вам нужно отобразить несколько **похожих** меток. Это будет эффективнее, чем создавать новый экземпляр для каждой метки.

   Как это выглядит после добавления меток в коллекцию новых объектов карты:
   ![Карта с коллекцией меток](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_placemarks_collection.png)

После создания коллекции `pinCollection` вы можете добавить в нее пины так же, как и для объектов [Map.mapObjects](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/mapObjects.html), поскольку они имеют тот же тип [MapObjectCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection-class.html).

> [!NOTE] Примечание
> Интерфейс [MapObjectCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection-class.html) расширяет [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html), поэтому допускается создавать вложенные коллекции и добавлять их в другие.
>
>
> Все методы, имеющие интерфейс [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html), также доступны в [MapObjectCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection-class.html).

Вы можете итерироваться по элементам [MapObjectCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection-class.html), используя метод [BaseMapObjectCollection.traverse](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/BaseMapObjectCollection/traverse.html).

## Геометрии

MapKit SDK позволяет рисовать на карте примитивные геометрические объекты, такие как полигоны, полилинии и круги. Все они настраиваемые и реализуют интерфейс [MapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObject-class.html).

### Полигоны

Используйте полигон, когда вам нужно отобразить **область** карты для пользователей.

1. Начните с создания экземпляра [Polygon](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Polygon-class.html).

   ```kotlin
   final points = [
       Point(latitude: 59.936046, longitude: 30.326869),
       Point(latitude: 59.938185, longitude: 30.32808),
       Point(latitude: 59.937376, longitude: 30.33621),
       Point(latitude: 59.934517, longitude: 30.335059),
   ];

   final polygon = Polygon(LinearRing(points), []);
   ```
2. Используйте метод [MapObjectCollection.addPolygon](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addPolygon.html) для создания полигонального объекта карты.

   ```dart
   final polygonMapObject = map.mapObjects.addPolygon(polygon);
   ```

   После завершения сборки вы увидите полигон в стиле по умолчанию:
   ![Карта с полигоном по умолчанию](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_polygon.png)
3. Задайте **внутренние** точки при создании полигона, чтобы исключить часть внутри него.

   ```dart
   final points = [
       Point(latitude: 59.936046, longitude: 30.326869),
       Point(latitude: 59.938185, longitude: 30.32808),
       Point(latitude: 59.937376, longitude: 30.33621),
       Point(latitude: 59.934517, longitude: 30.335059),
   ];

   final innerPoints = [
       Point(latitude: 59.937487, longitude: 30.330034),
       Point(latitude: 59.936688, longitude: 30.33127),
       Point(latitude: 59.937116, longitude: 30.33328),
       Point(latitude: 59.937704, longitude: 30.331842),
   ];

   final polygon = Polygon(LinearRing(points), [LinearRing(innerPoints)])
   ```

   Полигон с внутренними точками:
   ![Карта с полигоном с использованием внутренних точек](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_polygon_inner.png)
4. Измените цвет заливки и обводки по умолчанию, используя созданный экземпляр [PolygonMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolygonMapObject-class.html).

   ```dart
   polygonMapObject
     ..strokeWidth = 5.0
     ..strokeColor = Colors.green[900]!
     ..fillColor = Colors.green.withAlpha(130);
   ```

   ![Карта со стилизованным полигоном](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_polygon_styled.png)

Подробнее про настройку полигонов см. в разделе [PolygonMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolygonMapObject-class.html).

### Полилинии

Полилинии часто используются для отображения маршрутов и траекторий.

1. Создайте экземпляр [Polyline](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Polyline-class.html) с искомой геометрией и добавьте на карту объект полилинейной карты с помощью метода [MapObjectCollection.addPolylineWithGeometry](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addPolylineWithGeometry.html).

   ```dart
   final points = [
       Point(latitude: 59.936046, longitude: 30.326869),
       Point(latitude: 59.938185, longitude: 30.32808),
       Point(latitude: 59.937376, longitude: 30.33621),
       Point(latitude: 59.934517, longitude: 30.335059),
   ];
   final polyline = Polyline(points);

   final polylineObject = map.mapObjects.addPolylineWithGeometry(polyline);
   ```
2. Настройте стили полилиний, используя переменную [PolylineMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineMapObject-class.html).

   ```dart
   polylineObject
     ..strokeWidth = 5.0
     ..setStrokeColor(Colors.grey)
     ..outlineWidth = 2.0
     ..outlineColor = Colors.black;
   ```

   Результат после добавления полилинии на карту:
   ![Карта с добавленной полилинией](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_polyline.png)

Подробнее об этом можно почитать в разделе [PolylineMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineMapObject-class.html).

### Круги

Круги используются для отображения круглых областей.

1. Создайте экземпляр [Circle](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Circle-class.html) с искомой геометрией: центральной точкой и радиусом в метрах.

   ```dart
   final circle = Circle(
     Point(latitude: 59.935493, longitude: 30.327392),
     radius: 400.0,
   );
   ```
2. С помощью метода [MapObjectCollection.addCircle](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addCircle.html) добавьте на карту объект круга.

   ```dart
   map.mapObjects.addCircle(circle)
     ..strokeWidth = 3.0
     ..strokeColor = Colors.red[700]!
     ..fillColor = Colors.red.withAlpha(130);
   ```

   Результат после добавления круга на карту:
   ![Карта с кругом](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_circle.png)

Подробнее о том, как настроить круговой объект карты, можно почитать в разделе [CircleMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CircleMapObject-class.html).

## Кластеры

Кластеризованные коллекции используются для отображения нескольких меток.

1. Начните с создания [ClusterListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/ClusterListener-class.html) с одним методом [ClusterListener.onClusterAdded](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/ClusterListener/onClusterAdded.html), который управляет внешним видом кластера на карте.

   ```dart
   final class ClusterListenerImpl implements ClusterListener {

     @override
     void onClusterAdded(Cluster cluster) {
       cluster.appearance.setView(
         ViewProvider(builder: () => ClusterView()..setText("${cluster.placemarks.length}"))
       );
     }
   }

   final clusterListener = ClusterListenerImpl();
   ```

   Свойство [Cluster.appearance](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Cluster/appearance.html) возвращает объект [PlacemarkMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject-class.html). В нашем примере мы используем метод [PlacemarkMapObject.setView](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject/setView.html), чтобы изменить внешний вид кластера.
   `ClusterView` — это определяемый пользователем класс. Чтобы узнать, как он реализован, посмотрите код в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
2. Создайте новую вложенную коллекцию с помощью метода [MapObjectCollection.addClusterizedPlacemarkCollection](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapObjectCollection/addClusterizedPlacemarkCollection.html).

   ```dart
   final clusterizedPlacemarkCollection = map.mapObjects.addClusterizedPlacemarkCollection(clusterListener);
   ```
3. Добавьте несколько меток в новый `clusterizedCollection`.

   ```dart
   final points = [
       Point(latitude: 59.936046, longitude: 30.326869),
       Point(latitude: 59.938185, longitude: 30.32808),
       Point(latitude: 59.937376, longitude: 30.33621),
       Point(latitude: 59.934517, longitude: 30.335059),
   ];

   final imageProvider = ImageProvider.fromImageProvider(const AssetImage("assets/ic_pin.png"));

   points.forEach((point) {
     clusterizedCollection.addPlacemark()
       ..geometry = point
       ..setIcon(imageProvider);
   });
   ```
4. Вызовите метод [ClusterizedPlacemarkCollection.clusterPlacemarks](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/ClusterizedPlacemarkCollection/clusterPlacemarks.html). Он принимает два аргумента:

   - `clusterRadius` — минимальное расстояние в единицах между объектами, которые остаются в отдельных кластерах.
   - `minZoom` — минимальный уровень масштабирования, отображающий кластеры.

   ```dart
   clusterizedPlacemarkCollection.clusterPlacemarks(clusterRadius: 60.0, minZoom: 15);
   ```

   > [!WARNING] Важно
   > [ClusterizedPlacemarkCollection.clusterPlacemarks](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/ClusterizedPlacemarkCollection/clusterPlacemarks.html) следует вызывать явно каждый раз, когда метки добавляются в кластеризованные коллекции или удаляются из них.
   >
   >
   > Иначе кластеризованные метки не будут повторно отображаться.

   Кластеризованные метки с разным масштабом:
   ![Кластеры](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_clusters.gif)

## Разрешение конфликтов

При добавлении объектов [PlacemarkMapObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PlacemarkMapObject-class.html) на карту, они могут накладываться как друг на друга, так и на иконки и подписи карты. Для разрешения конфликтов наложения предусмотрен механизм [ConflictResolutionMode](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineMapObject-class.html).

Разрешение конфликтов происходит в соотвествии с порядком отрисовки, то есть объект отрисованый выше, может вытеснить объект, отрисованый ниже, но не наоборот. Порядок отрисовки формируется на основе свойств zIndex объекта `PlacemarkMapObject` и `MapObjectCollection` которой он принадлежит. При равных `zIndex` объекты отрисовываются в том же порядке, в котором они были добавлены.

Для выставления режима разрешения конфликтов используйте метод [RootMapObjectCollection.setConflictResolutionMode](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineMapObject-class.html).

> [!NOTE] Примечание
> Mapkit поддерживает настройку режима разрешения конфликтов только для корневой коллекции. Любые дочерние элементы/коллекции будут использовать режим разрешения конфликтов корневой коллекции.
> По умолчанию режим разрешения конфликтов — `ConflictResolution.Ignore`.

Пример проблемы:

![Разрешение конфликтов по умолчанию](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_resolution_ignore.png)

При установке значения `ConflictResolution.Major` для коллекции добавленные объекты начинают вытеснять подписи и иконки на карте:

![Выставленное разрешение конфликтов](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_objects/objects_resolution_major.png)

## Исходный код

Полные примеры кода из руководства смотрите в приложении `map_objects` в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
