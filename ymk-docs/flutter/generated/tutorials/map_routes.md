---
title: "Маршруты"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Данные о маршруте"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_routes.html"
---
# Маршруты

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_routes.html)

Маршрут - это последовательность координат на карте, путь, по которому должен двигаться пользователь чтобы попасть из точки `A` в точку `B`. Маршрут может включать в себя промежуточные via-точки.

Помимо данных о траектории поездки, маршрут содержит различную дополнительную информацию. Например, дорожные предупреждения, дистанцию, примерное время движения по маршруту и т.д.

В MapKit SDK маршрут представлен классом [DrivingRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute-class.html), рассмотрим его основной функционал.

## Метаданные

Метаданные [DrivingRouteMetadata](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouteMetadata-class.html) содержат информацию об описании маршрута, его параметрах и характеристиках, дистанцию и примерное время движения по маршруту.

Для получения метаданных используется метод [DrivingRoute.metadata](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/metadata.html).

### URI маршрута

**URI** представляет собой строковый идентификатор маршрута.

Для получения **URI** маршрута, используется метод [DrivingRouteMetadata.uri](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouteMetadata/uri.html).

## Позиция

Маршрут может содержать информацию о текущей позиции, она отражает какая часть маршрута была пройдена.

Для получения текущей позиции используется метод [DrivingRoute.position](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/position.html).

## Предупреждения и события

**Дорожные события** на маршруте позволяют узнать о некоторых событиях, которые происходят на дороге. Используйте метод [DrivingRoute.events](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/events.html) для получения информации о дорожных событиях на маршруте.

**Предупреждения** на маршруте содержат информацию о различных объектах на маршруте. Среди объектов встречаются светофоры ([DrivingRoute.trafficLights](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/trafficLights.html)), железнодорожные переправы ([DrivingRoute.railwayCrossings](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/railwayCrossings.html)), лежачие полицейские ([DrivingRoute.speedBumps](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/speedBumps.html)) и т.д. Подробнее об этом можно узнать в [DrivingRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute-class.html) API.

## Пробки на маршруте

С помощью метода [DrivingRoute.jamSegments](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/jamSegments.html) можно получить информацию о загруженности дорог на маршруте. Данный метод возвращает список из [JamSegment](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/JamSegment-class.html) объектов. Каждый элемент списка описывает состояние загруженности дороги и среднюю скорость движения по ней на соответствующем отрезке маршрута. Отрезок с номером **N** соответствует участку маршрута, который находится между **N** и **N + 1** точками геометрии маршрута, которые можно получить с помощью вызова [DrivingRoute.geometry](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute/geometry.html).

## Подписка на обновление

В течении жизненного цикла маршрута некоторые данные о маршруте могут измениться. MapKit SDK предоставляет возможность подписаться на изменения информации о маршруте при помощи интерфейса [DrivingConditionsListener](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingConditionsListener-class.html).

## Расчет прогресса по маршруту

Прогрессом по маршруту называется доля от изначального маршрута, которая была пройдена.

Ниже приведен фрагмент кода для вычисления данного значения:

```dart
double routeProgress(DrivingRoute route) {
  const startPosition = PolylinePosition(segmentIndex: 0, segmentPosition: 0.0);
  final distanceFull = route.metadataAt(startPosition).weight.distance.value;
  final distanceLeft = route.metadata.weight.distance.value;
  return 1.0 - distanceLeft / distanceFull;
}
```

Для вычисления доли пройденного маршрута нужно рассчитать общую и пройденную дистанцию маршрута, а затем разделить одну величину на другую.

## Расстояние между точками маршрута

Для вычисления расстояния между двумя произвольными точками маршрута используются методы из [PolylineUtils](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineUtils-class.html). Выполните следующие шаги:

1. Создайте объект [PolylineIndex](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineIndex-class.html), привязанный к вашему маршруту, используя [PolylineUtils.createPolylineIndex](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineUtils/createPolylineIndex.html).
2. Используйте метод [PolylineIndex.closestPolylinePositionWithPriority](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineIndex/closestPolylinePositionWithPriority.html) для получения [PolylinePosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylinePosition-class.html) точек на маршруте.
3. Вычислите значение расстояния между двумя точками на маршруте, с помощью [PolylineUtils.distanceBetweenPolylinePositions](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/PolylineUtils/distanceBetweenPolylinePositions.html).

Пример вычисления значения расстояния между двумя произвольными точками маршрута:

```dart
double distanceBetweenPointsOnRoute(DrivingRoute route, Point first, Point second) {
  final polylineIndex = PolylineUtils.createPolylineIndex(route.geometry);

  final firstPosition = polylineIndex.closestPolylinePositionWithPriority(
    first,
    PolylineIndexPriority.ClosestToRawPoint,
    maxLocationBiast: 1.0
  )!;

  final secondPosition = polylineIndex.closestPolylinePositionWithPriority(
    second,
    PolylineIndexPriority.ClosestToRawPoint,
    maxLocationBiast: 1.0
  )!;

  return PolylineUtils.distanceBetweenPolylinePositions(route.geometry, firstPosition, secondPosition);
}
```

## Время между точками маршрута

Рассмотрим алгоритм нахождения времени поездки между текущей точкой маршрута и произвольной точкой на маршруте, которая следует по маршруту позже.

1. Нужно найти расстояние между текущей точкой маршрута и второй точкой. Для этого можно использовать [алгоритм](map_routes.md#distance-between-points) из предыдущего пункта.
2. При помощи метода [RoutePosition.advance](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RoutePosition/advance.html) рассчитайте значение [RoutePosition](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RoutePosition-class.html) второй точки.
3. Используя метод [RoutePosition.timeToFinish](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RoutePosition/timeToFinish.html) найдите разницу времени поездки между текущей точкой маршрута и второй точкой.

Пример вычисления времени поездки от текущей позиции маршрута до произвольной точки маршрута:

```dart
double timeTravelToPoint(DrivingRoute route, Point point) {
  final currentPosition = route.routePosition;
  final distance = distanceBetweenPointsOnRoute(route, currentPosition.point, point);
  final targetPosition = currentPosition.advance(distance);
  return targetPosition.timeToFinish() - currentPosition.timeToFinish();
}
```

Для вычисления времени поездки между двумя произвольными точками на маршруте, используйте разницу между результатами вычисления `timeTravelToPoint` для обоих точек.
