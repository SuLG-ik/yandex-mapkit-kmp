---
title: "Взаимодействие с картой"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Взаимодействие c картой"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_interaction.html"
---
# Взаимодействие с картой

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_interaction.html)

Карта является одной из центральных сущностей MapKit SDK. Пользователи могут взаимодействовать с картой при помощи специальных жестов.

В этом разделе рассматриваются основные возможности MapKit SDK для реализации взаимодействия с картой.

## Координаты

В MapKit SDK используется две системы координат:

- **World**: Характеризует положение точки в реальном мире, представлена в виде класса [Point](../../../com/yandex/mapkit/geometry/Point.md). Точка задается при помощи географических координат, ее широта меняется в диапазоне от -90 до 90 градусов, а долгота от -180 до 180 градусов.
- **Screen**: система координат экрана, представлена классом [ScreenPoint](../../../com/yandex/mapkit/ScreenPoint.md). Задает точку относительно размеров экрана устройства в пикселях. Меняется в диапазоне от (0, 0) - это верхняя левая точка экрана, до ([MapWindow.width](../../../com/yandex/mapkit/map/MapWindow.md#width), [MapWindow.height](../../../com/yandex/mapkit/map/MapWindow.md#height)) - нижняя правая точка экрана.

Для перевода координат из одной систем в другую используются методы:

- [MapWindow.screenToWorld](../../../com/yandex/mapkit/map/MapWindow.md#screentoworldscreenpoint) - переводит точку из **Screen** в **World**.
- [MapWindow.worldToScreen](../../../com/yandex/mapkit/map/MapWindow.md#worldtoscreenpoint) - переводит точку из **World** в **Screen**.

Пример добавления метки на карту в центр экрана:

```kotlin
val centerX = mapWindow.width / 2f
val centerY = mapWindow.height / 2f
val centerPoint = ScreenPoint(centerX, centerY)
// For example, worldPoint = (59.935493, 30.327392)
val worldPoint = mapWindow.screenToWorld(centerPoint)
map.mapObjects.addPlacemark().apply {
    geometry = worldPoint
    setIcon(ImageProvider.fromResource(this, R.drawable.ic_pin))
}
```

В результате выполнения фрагмента кода выше, в центре UI-компонента карты будет отображена метка.

## Камера

Карту MapKit SDK можно перемещать, поворачивать, наклонять, масштабировать при помощи жестов экрана или программным способом. За данный функционал отвечает отдельная сущность — камера, она определяет в каком положении будет отображена карта на экране устройства пользователя.

### Позиция камеры

Позиция камеры представлена классом [CameraPosition](../../../com/yandex/mapkit/map/CameraPosition.md). Для получения текущей позиции камеры используется метод [Map.getCameraPosition](../../../com/yandex/mapkit/map/Map.md#getcameraposition).

Ниже приведены параметры, которые характеризуют позицию камеры.

#### Target

Задает положение карты. Соответствующая данной координате локация будет отображена в [focus point](map_interaction.md#focus-point) точке экрана.

#### Zoom

Уровень масштаба карты. Чем больше значение зума, тем более детальной становится подложка карты. При максимальном [CameraBounds.getMaxZoom](../../../com/yandex/mapkit/map/CameraBounds.md#getmaxzoom) значении зума карта будет наиболее приближена, а при минимальном [CameraBounds.getMinZoom](../../../com/yandex/mapkit/map/CameraBounds.md#getminzoom) отобразится карта всего мира.

#### Azimuth

Текущее направление камеры. Характеризуется углом в градусах относительно направления на север и отвечает за вращение камеры. При увеличении значения азимута вращение карты происходит по направлению против часовой стрелки. Меняется в диапазоне от 0 до 360 градусов.

#### Tilt

Значение наклона камеры. Задает угол, под которым камера смотрит на поверхность карты. При значении 0 можно просматривать карту сверху, при дальнейшем увеличении данного параметра наклон карты будет увеличиваться.

### Перемещение камеры

Для перемещения камеры используется вызов [Map.move](../../../com/yandex/mapkit/map/Map.md#movecameraposition-animation-cameracallback), который применяет к камере новое значение позиции.

```kotlin
val cameraCallback = object : CameraCallback {
    override fun onMoveFinished(isFinished: Boolean) {
        // Handle camera move finished ...
    }
}

map.move(
    CameraPosition(
        /* target */ Point(59.935493, 30.327392)
        /* zoom */ 13f,
        /* azimuth */ 0f,
        /* tilt */ 0f,
    ),
    Animation(Animation.Type.LINEAR, 1f),
    cameraCallback
)
```

При помощи объекта [Animation](../../../com/yandex/mapkit/Animation.md), можно задать анимацию движения камеры, определить ее тип и длительность. Последний опциональный параметр — [CameraCallback](../../../com/yandex/mapkit/map/CameraCallback.md). Это объект, при помощи которого можно подписаться на событие окончания выполнения движения.

### Фокус камеры на объекте

Один из распространенных сценариев перемещения камеры на карте — фокусировка на различных объектах.

Если объект представляет собой отдельную метку, то переместить камеру на него не составляет труда. Для этого достаточно использовать метод [перемещения камеры](map_interaction.md#map-move) и передать ему позицию метки.

В случае если объект задает некоторую область на карте следует использовать метод [Map.cameraPosition](../../../com/yandex/mapkit/map/Map.md#camerapositiongeometry-float-float-screenrect). Он принимает на вход геометрию объекта и возвращает значение [CameraPosition](../../../com/yandex/mapkit/map/CameraPosition.md). После перемещения камеры в данную позицию произойдет автоматическая фокусировка на заданном объекте с учетом ограничения [видимой области карты](map_interaction.md#focus-rect).

При помощи [Map.cameraPosition](../../../com/yandex/mapkit/map/Map.md#camerapositiongeometry-float-float-screenrect) можно получить новую позицию камеры, например, для объекта полилинии, и переместить камеру в новую позицию.

```kotlin
val geometry = Geometry.fromPolyline(polyline)
val position = Map.cameraPosition(
    geometry,
    /* azimuth */ null,
    /* tilt */ null,
    /* focusRect */ null
)
map.move(position)
```

Вызов [Map.cameraPosition](../../../com/yandex/mapkit/map/Map.md#camerapositiongeometry-float-float-screenrect), помимо геометрии объекта, принимает значения параметров позиции камеры, которые будут применены во время движения.

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_interaction/map_interaction_focus.png)

### Focus Rect

Часто в ходе разработки карточных приложений дополнительный пользовательский UI размещается поверх MapKit SDK карты. В таких случаях расчет правильной позиции камеры с учетом перекрытых областей карты может оказаться достаточно непростой задачей. MapKit SDK предоставляет инструмент, который решает данную проблему.

**Focus rect** - задает область экрана устройства, которая участвует в расчетах позиции камеры. Для изменения значения используется метод [MapWindow.setFocusRect](../../../com/yandex/mapkit/map/MapWindow.md#setfocusrectscreenrect). По умолчанию, используется вся область карты.

Пример работы логики **focus rect** при фокусировке на геометрии объекта:

![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_interaction/map_interaction_focus_rect_off.png) ![](https://yandex.ru/maps-api/docs/mapkit/android/_assets/yandex/map_interaction/map_interaction_focus_rect_on.png)

На первом скриншоте объект полилинии перекрывается элементами пользовательского UI: снизу карточкой, а справа кнопками зума. Во втором примере область **focus rect** была рассчитана с учетом размеров UI элементов.

Пример кода для расчета **focus rect**:

```kotlin
val bottomPadding = binding.layoutBottomCard.measuredHeight
val rightPadding = binding.buttonMinus.measuredWidth

mapWindow.focusRect = ScreenRect(
    ScreenPoint(0f, 0f),
    ScreenPoint(
        mapWindow.width().toFloat() - rightPadding,
        mapWindow.height().toFloat() - bottomPadding,
    )
)
```

### Focus Point

**Focus point** - определяет точку экрана, относительно которой происходит движение камеры, также она участвует в расчетах позиции камеры. Например, после вызова [Map.move](../../../com/yandex/mapkit/map/Map.md#movecameraposition-animation-cameracallback) камера будет перемещена таким образом, что текущая позиция камеры окажется в **focus point** точке экрана. Для ее изменения используется метод [MapWindow.setFocusPoint](../../../com/yandex/mapkit/map/MapWindow.md#setfocuspointscreenpoint). По умолчанию, если точка не указана, используется значение текущего центра [focus rect](map_interaction.md#focus-rect).

## События карты

Карта MapKit SDK поддерживает большое количество событий: нажатия на карту, различные жесты, изменение позиции камеры и т.д.

### Тапы

При помощи интерфейса [InputListener](../../../com/yandex/mapkit/map/InputListener.md) можно подписаться на события тапов по карте.

```kotlin
val inputListener = object : InputListener {
    override fun onMapTap(map: Map, point: Point) {
        // Handle single tap ...
    }

    override fun onMapLongTap(map: Map, point: Point) {
        // Handle long tap ...
    }
}
map.addInputListener(inputListener)
```

События нажатия на карту разделяются на два вида: обычный тап и долгий тап. Оба вида событий позволяют узнать, к какой карте и координате было применено нажатие.

### Жесты

Карта умеет считывать жесты пользователя. Каждый параметр из состояния [позиции камеры](map_interaction.md#position) может быть изменен при помощи жеста:

- **[Target](map_interaction.md#target)** - изменяется при скролле карты, когда [Map.setScrollGesturesEnabled](../../../com/yandex/mapkit/map/Map.md#setscrollgesturesenabledboolean) выставлен в `true`.
- **[Zoom](map_interaction.md#zoom)** - изменяется по жесту щипка или двойного нажатия на карту, когда [Map.setZoomGesturesEnabled](../../../com/yandex/mapkit/map/Map.md#setzoomgesturesenabledboolean) выставлен в `true`.
- **[Azimuth](map_interaction.md#azimuth)** - изменяется по жесту вращения двумя пальцам, когда [Map.setRotateGesturesEnabled](../../../com/yandex/mapkit/map/Map.md#setrotategesturesenabledboolean) выставлен в `true`.
- **[Tilt](map_interaction.md#tilt)** - изменяется при вертикальном свайпе двумя пальцами, когда [Map.setTiltGesturesEnabled](../../../com/yandex/mapkit/map/Map.md#settiltgesturesenabledboolean) выставлен в `true`.

### Загрузка карты

Существует возможность подписаться на событие успешной загрузки карты, при помощи [MapLoadedListener](../../../com/yandex/mapkit/map/MapLoadedListener.md) интерфейса. Карта считается загруженной, если все ее текущие тайлы были скачаны. В некоторых случаях карта может загружаться весьма длительное время, например, при постоянном скроллинге или при отсутствии подключения к интернету.

> [!NOTE] Примечание
> Оповещение о событии загрузки карты срабатывает только один раз после загрузки и показа всех ее видимых тайлов. Для оповещения о новых событиях необходимо подписываться на [MapLoadedListener](../../../com/yandex/mapkit/map/MapLoadedListener.md) повторно.

### Изменение позиции камеры

Для получения актуальных данных о состоянии камеры можно подписаться на события изменения позиции камеры при помощи интерфейса [CameraListener](../../../com/yandex/mapkit/map/CameraListener.md).

### Изменения размера карты

Для подписки на изменение размеров карты используется [SizeChangedListener](../../../com/yandex/mapkit/map/SizeChangedListener.md) интерфейс.

```kotlin
val sizeChangedListener = object : SizeChangedListener {
    override fun onMapWindowSizeChanged(mapWindow: MapWindow, width: Int, height: Int) {
        // Handle window size changed ...
    }
}
```

## POI

POI (points of interests) - это специальные точки на карте MapKit, которые обозначают интересные места, объекты или организации. Например: магазины, рестораны, музеи, достопримечательности, парки и любые другие объекты, которые могут быть интересны пользователю.

MapKit SDK позволяет взаимодействовать с POI.

### Нажатия на POI

Для обработки события нажатия на POI используется интерфейс [GeoObjectTapListener](../../../com/yandex/mapkit/layers/GeoObjectTapListener.md).

```kotlin
val geoObjectTapListener = object : GeoObjectTapListener {
    override fun onObjectTap(event: GeoObjectTapEvent): Boolean {
        // Handle GeoObjectTapEvent ...
    }
}
map.addTapListener(geoObjectTapListener)
```

Метод-обработчик события клика принимает объект [GeoObjectTapEvent](../../../com/yandex/mapkit/layers/GeoObjectTapEvent.md), который инкапсулирует информацию об объекте на карте, по которому было произведено нажатие.

### Выделение POI

При помощи метода [Map.selectGeoObject](../../../com/yandex/mapkit/map/Map.md#selectgeoobjectgeoobjectselectionmetadata) можно выделить произвольный POI на карте. Для того что бы от отменить выделение используется метод [Map.deselectGeoObject](../../../com/yandex/mapkit/map/Map.md#deselectgeoobject).

### Гео-объект

Используя вызов [GeoObjectTapEvent.getGeoObject](../../../com/yandex/mapkit/layers/GeoObjectTapEvent.md#getgeoobject) можно получить доступ к информации гео-объекта.

Класс [GeoObject](../../../com/yandex/mapkit/GeoObject.md) - это сущность MapKit SDK, которая предоставляет информацию об объектах на карте. Гео-объектом может являться организация, здание или какой-нибудь географический объект, например страна, город или море.

[GeoObject](../../../com/yandex/mapkit/GeoObject.md) содержит большое количество методов, предоставляя доступ к следующим данным:

- название;
- описание;
- геометрия;
- [BoundingBox](../../../com/yandex/mapkit/geometry/BoundingBox.md);
- атрибуты;
- коллекция мета-данных, например, получение [GeoObjectSelectionMetadata](../../../com/yandex/mapkit/map/GeoObjectSelectionMetadata.md) и [UriObjectMetadata](../../../com/yandex/mapkit/uri/UriObjectMetadata.md);

## Исходный код

Подробнее с примерами использования MapKit SDK для взаимодействия с картой можно ознакомиться в `map-interaction` демо-приложении в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-android-demo).
