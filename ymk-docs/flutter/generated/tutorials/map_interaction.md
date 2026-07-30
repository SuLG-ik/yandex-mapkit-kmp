---
title: "Взаимодействие с картой"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Взаимодействие c картой"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_interaction.html"
---
# Взаимодействие с картой

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_interaction.html)

Карта является одной из центральных сущностей MapKit SDK. Пользователи могут взаимодействовать с картой при помощи специальных жестов.

В этом разделе рассматриваются основные возможности MapKit SDK для реализации взаимодействия с картой.

## Координаты

В MapKit SDK используется две системы координат:

- **World**: Характеризует положение точки в реальном мире, представлена в виде класса [Point](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Point-class.html). Точка задается при помощи географических координат, ее широта меняется в диапазоне от -90 до 90 градусов, а долгота от -180 до 180 градусов.
- **Screen**: система координат экрана, представлена классом [ScreenPoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/ScreenPoint-class.html). Задает точку относительно размеров экрана устройства в пикселях. Меняется в диапазоне от (0, 0) - это верхняя левая точка экрана, до ([MapWindow.width](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/width.html), [MapWindow.height](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/height.html)) - нижняя правая точка экрана.

Для перевода координат из одной систем в другую используются методы:

- [MapWindow.screenToWorld](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/screenToWorld.html) - переводит точку из **Screen** в **World**.
- [MapWindow.worldToScreen](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/worldToScreen.html) - переводит точку из **World** в **Screen**.

Пример добавления метки на карту в центр экрана:

```dart
final centerX = mapWindow.width() / 2.0;
final centerY = mapWindow.height() / 2.0;
final centerPoint = ScreenPoint(x: centerX, y: centerY);

// For example, worldPoint = Point(latitude: 59.935493, longitude: 30.327392)
final worldPoint = mapWindow.screenToWorld(centerPoint);

mapWindow.map.mapObjects.addPlacemark()
  ..geometry = worldPoint!
  ..setIcon(ImageProvider.fromImageProvider(const AssetImage("assets/ic_pin.png")));
```

В результате выполнения фрагмента кода выше, в центре UI-компонента карты будет отображена метка.

## Камера

Карту MapKit SDK можно перемещать, поворачивать, наклонять, масштабировать при помощи жестов экрана или программным способом. За данный функционал отвечает отдельная сущность — камера, она определяет в каком положении будет отображена карта на экране устройства пользователя.

### Позиция камеры

Позиция камеры представлена классом [CameraPosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CameraPosition-class.html). Для получения текущей позиции камеры используется метод [Map.cameraPosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/cameraPosition.html).

Ниже приведены параметры, которые характеризуют позицию камеры.

#### Target

Задает положение карты. Соответствующая данной координате локация будет отображена в [focus point](map_interaction.md#focus-point) точке экрана.

#### Zoom

Уровень масштаба карты. Чем больше значение зума, тем более детальной становится подложка карты. При максимальном [CameraBounds.getMaxZoom](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CameraBounds/getMaxZoom.html) значении зума карта будет наиболее приближена, а при минимальном [CameraBounds.getMinZoom](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CameraBounds/getMinZoom.html) отобразится карта всего мира.

#### Azimuth

Текущее направление камеры. Характеризуется углом в градусах относительно направления на север и отвечает за вращение камеры. При увеличении значения азимута вращение карты происходит по направлению против часовой стрелки. Меняется в диапазоне от 0 до 360 градусов.

#### Tilt

Значение наклона камеры. Задает угол, под которым камера смотрит на поверхность карты. При значении 0 можно просматривать карту сверху, при дальнейшем увеличении данного параметра наклон карты будет увеличиваться.

### Перемещение камеры

Для перемещения камеры используется вызов [Map.moveWithAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/moveWithAnimation.html), который применяет к камере новое значение позиции.

```dart
final cameraCallback = MapCameraCallback(onMoveFinished: (isFinished) {
  // Handle camera move finished ...
});

map.moveWithAnimation(
  CameraPosition(
    Point(latidude: 59.935493, longitude: 30.327392)
    zoom: 13.0,
    azimuth: 0.0,
    tilt: 0.0,
  ),
  Animation(AnimationType.Linear, duration: 1.0),
  cameraCallback: cameraCallback
)
```

При помощи объекта [Animation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Animation-class.html), можно задать анимацию движения камеры, определить ее тип и длительность. Последний опциональный параметр — [MapCameraCallback](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapCameraCallback-class.html). Это объект, при помощи которого можно подписаться на событие окончания выполнения движения.

### Фокус камеры на объекте

Один из распространенных сценариев перемещения камеры на карте — фокусировка на различных объектах.

Если объект представляет собой отдельную метку, то переместить камеру на него не составляет труда. Для этого достаточно использовать метод [перемещения камеры](map_interaction.md#map-move) и передать ему позицию метки.

В случае если объект задает некоторую область на карте следует использовать метод [Map.cameraPositionWithAzimuth](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/cameraPositionWithAzimut.html). Он принимает на вход геометрию объекта и возвращает значение [CameraPosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/CameraPosition-class.html). После перемещения камеры в данную позицию произойдет автоматическая фокусировка на заданном объекте с учетом ограничения [видимой области карты](map_interaction.md#focus-rect).

При помощи [Map.cameraPositionWithAzimuth](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/cameraPositionWithAzimut.html) можно получить новую позицию камеры, например, для объекта полилинии, и переместить камеру в новую позицию.

```dart
final geometry = Geometry.fromPolyline(polyline);
final position = map.cameraPositionForGeometry(geometry);
map.move(position);
```

Вызов [Map.cameraPositionWithAzimuth](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/cameraPositionWithAzimut.html), помимо геометрии объекта, принимает значения параметров позиции камеры, которые будут применены во время движения.

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_interaction/map_interaction_focus.png)

### Focus Rect

Часто в ходе разработки карточных приложений дополнительный пользовательский UI размещается поверх MapKit SDK карты. В таких случаях расчет правильной позиции камеры с учетом перекрытых областей карты может оказаться достаточно непростой задачей. MapKit SDK предоставляет инструмент, который решает данную проблему.

**Focus rect** - задает область экрана устройства, которая участвует в расчетах позиции камеры. Для изменения значения используется метод [MapWindow.focusRect](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/focusRect.html). По умолчанию, используется вся область карты.

Пример работы логики **focus rect** при фокусировке на геометрии объекта:

![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_interaction/map_interaction_focus_rect_off.png) ![](https://yandex.ru/maps-api/docs/mapkit/flutter/_assets/yandex/map_interaction/map_interaction_focus_rect_on.png)

На первом скриншоте объект полилинии перекрывается элементами пользовательского UI: снизу карточкой, а справа кнопками зума. Во втором примере область **focus rect** была рассчитана с учетом размеров UI элементов.

Пример кода для расчета **focus rect**:

```dart
final bottomPadding = layoutBottomCard.height;
final rightPadding = buttonMinus.width;

mapWindow.focusRect = ScreenRect(
  const ScreenPoint(x: 0.0, y: 0.0),
  ScreenPoint(
    x: mapWindow.width().toDouble() - rightPadding,
    y: mapWindow.height().toDouble() - bottomPadding,
  )
);
```

### Focus Point

**Focus point** - определяет точку экрана, относительно которой происходит движение камеры, также она участвует в расчетах позиции камеры. Например, после вызова [Map.moveWithAnimation](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/moveWithAnimation.html) камера будет перемещена таким образом, что текущая позиция камеры окажется в **focus point** точке экрана. Для ее изменения используется метод [MapWindow.focusPoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapWindow/focusPoint.html). По умолчанию, если точка не указана, используется значение текущего центра [focus rect](map_interaction.md#focus-rect).

## События карты

Карта MapKit SDK поддерживает большое количество событий: нажатия на карту, различные жесты, изменение позиции камеры и т.д.

### Тапы

При помощи интерфейса [MapInputListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapInputListener-class.html) можно подписаться на события тапов по карте.

```dart
final class MapInputListenerImpl implements MapInputListener {

  @override
  void onMapTap(Map map, Point point) {
    // Handle single tap ...
  }

  @override
  void onMapLongTap(Map map, Point point) {
    // Handle long tap ...
  }
}

final mapInputListener = MapInputListenerImpl();
map.addInputListener(mapInputListener);
```

События нажатия на карту разделяются на два вида: обычный тап и долгий тап. Оба вида событий позволяют узнать, к какой карте и координате было применено нажатие.

### Жесты

Карта умеет считывать жесты пользователя. Каждый параметр из состояния [позиции камеры](map_interaction.md#position) может быть изменен при помощи жеста:

- **[Target](map_interaction.md#target)** - изменяется при скролле карты, когда [Map.scrollGesturesEnabled](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/scrollGesturesEnabled.html) выставлен в `true`.
- **[Zoom](map_interaction.md#zoom)** - изменяется по жесту щипка или двойного нажатия на карту, когда [Map.zoomGesturesEnabled](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/zoomGesturesEnabled.html) выставлен в `true`.
- **[Azimuth](map_interaction.md#azimuth)** - изменяется по жесту вращения двумя пальцам, когда [Map.rotateGesturesEnabled](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/rotateGesturesEnabled.html) выставлен в `true`.
- **[Tilt](map_interaction.md#tilt)** - изменяется при вертикальном свайпе двумя пальцами, когда [Map.tiltGesturesEnabled](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/tiltGesturesEnabled.html) выставлен в `true`.

### Загрузка карты

Существует возможность подписаться на событие успешной загрузки карты, при помощи [MapLoadedListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapLoadedListener-class.html) интерфейса. Карта считается загруженной, если все ее текущие тайлы были скачаны. В некоторых случаях карта может загружаться весьма длительное время, например, при постоянном скроллинге или при отсутствии подключения к интернету.

> [!NOTE] Примечание
> Оповещение о событии загрузки карты срабатывает только один раз после загрузки и показа всех ее видимых тайлов. Для оповещения о новых событиях необходимо подписываться на [MapLoadedListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapLoadedListener-class.html) повторно.

### Изменение позиции камеры

Для получения актуальных данных о состоянии камеры можно подписаться на события изменения позиции камеры при помощи интерфейса [MapCameraListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapCameraListener-class.html).

### Изменения размера карты

Для подписки на изменение размеров карты используется [MapSizeChangedListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/MapSizeChangedListener-class.html) интерфейс.

```dart
final class SizeChangedListenerImpl implements MapSizeChangedListener {

  @override
  void onMapWindowSizeChanged(MapWindow mapWindow, int newWidth, int newHeight) {
    // Handle window size changed ...
  }
}
```

## POI

POI (points of interests) - это специальные точки на карте MapKit, которые обозначают интересные места, объекты или организации. Например: магазины, рестораны, музеи, достопримечательности, парки и любые другие объекты, которые могут быть интересны пользователю.

MapKit SDK позволяет взаимодействовать с POI.

### Нажатия на POI

Для обработки события нажатия на POI используется интерфейс [LayersGeoObjectTapListener](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/LayersGeoObjectTapListener-class.html).

```dart
class GeoObjectTapListenerImpl implements LayersGeoObjectTapListener {

  @override
  bool onObjectTap(GeoObjectTapEvent event) {
    // handle GeoObjectTapEvent
  }
}

final geoObjectTapListener = GeoObjectTapListenerImpl();
map.addTapListener(geoObjectTapListener);
```

Метод-обработчик события клика принимает объект [GeoObjectTapEvent](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObjectTapEvent-class.html), который инкапсулирует информацию об объекте на карте, по которому было произведено нажатие.

### Выделение POI

При помощи метода [Map.selectGeoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/selectGeoObject.html) можно выделить произвольный POI на карте. Для того что бы от отменить выделение используется метод [Map.deselectGeoObject()](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/Map/deselectGeoObject.html).

### Гео-объект

Используя вызов [GeoObjectTapEvent.geoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObjectTapEvent/geoObject.html) можно получить доступ к информации гео-объекта.

Класс [GeoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject-class.html) - это сущность MapKit SDK, которая предоставляет информацию об объектах на карте. Гео-объектом может являться организация, здание или какой-нибудь географический объект, например страна, город или море.

[GeoObject](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObject-class.html) содержит большое количество методов, предоставляя доступ к следующим данным:

- название;
- описание;
- геометрия;
- [BoundingBox](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/BoundingBox-class.html);
- атрибуты;
- коллекция мета-данных, например, получение [GeoObjectSelectionMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/GeoObjectSelectionMetadata-class.html) и [UriObjectMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/UriObjectMetadata-class.html);
