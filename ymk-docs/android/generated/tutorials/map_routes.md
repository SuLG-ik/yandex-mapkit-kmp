---
title: "Маршруты"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Данные о маршруте"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_routes.html"
---
# Маршруты

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_routes.html)

Маршрут - это последовательность координат на карте, путь, по которому должен двигаться пользователь чтобы попасть из точки `A` в точку `B`. Маршрут может включать в себя промежуточные via-точки.

Помимо данных о траектории поездки, маршрут содержит различную дополнительную информацию. Например, дорожные предупреждения, дистанцию, примерное время движения по маршруту и т.д.

В MapKit SDK маршрут представлен классом [DrivingRoute](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md), рассмотрим его основной функционал.

## Метаданные

Метаданные [DrivingRouteMetadata](../../../com/yandex/mapkit/directions/driving/DrivingRouteMetadata.md) содержат информацию об описании маршрута, его параметрах и характеристиках, дистанцию и примерное время движения по маршруту.

Для получения метаданных используется метод [DrivingRoute.getMetadata](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getmetadata).

### URI маршрута

**URI** представляет собой строковый идентификатор маршрута.

Для получения **URI** маршрута, используется метод [DrivingRouteMetadata.getUri](../../../com/yandex/mapkit/directions/driving/DrivingRouteMetadata.md#geturi).

## Позиция

Маршрут может содержать информацию о текущей позиции, она отражает какая часть маршрута была пройдена.

Для получения текущей позиции используется метод [DrivingRoute.getPosition](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getposition).

## Предупреждения и события

**Дорожные события** на маршруте позволяют узнать о некоторых событиях, которые происходят на дороге. Используйте метод [DrivingRoute.getEvents](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getevents) для получения информации о дорожных событиях на маршруте.

**Предупреждения** на маршруте содержат информацию о различных объектах на маршруте. Среди объектов встречаются светофоры ([DrivingRoute.getTrafficLights](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#gettrafficlights)), железнодорожные переправы ([DrivingRoute.getRailwayCrossings](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getrailwaycrossings)), лежачие полицейские ([DrivingRoute.getSpeedBumps](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getspeedbumps)) и т.д. Подробнее об этом можно узнать в [DrivingRoute](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md) API.

## Пробки на маршруте

С помощью метода [DrivingRoute.getJamSegments](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getjamsegments) можно получить информацию о загруженности дорог на маршруте. Данный метод возвращает список из [JamSegment](../../../com/yandex/mapkit/navigation/JamSegment.md) объектов. Каждый элемент списка описывает состояние загруженности дороги и среднюю скорость движения по ней на соответствующем отрезке маршрута. Отрезок с номером **N** соответствует участку маршрута, который находится между **N** и **N + 1** точками геометрии маршрута, которые можно получить с помощью вызова [DrivingRoute.getGeometry](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md#getgeometry).

## Подписка на обновление

В течении жизненного цикла маршрута некоторые данные о маршруте могут измениться. MapKit SDK предоставляет возможность подписаться на изменения информации о маршруте при помощи интерфейса [ConditionsListener](../../../com/yandex/mapkit/directions/driving/ConditionsListener.md).

## Расчет прогресса по маршруту

Прогрессом по маршруту называется доля от изначального маршрута, которая была пройдена.

Ниже приведен фрагмент кода для вычисления данного значения:

```kotlin
fun routeProgress(route: DrivingRoute): Float {
    val startPosition = PolylinePosition(0, 0.0)
    val distanceFull = route.metadataAt(startPosition).weight.distance.value
    val distanceLeft = route.metadata.weight.distance.value
    return 1f - distanceLeft / distanceFull
}
```

Для вычисления доли пройденного маршрута нужно рассчитать общую и пройденную дистанцию маршрута, а затем разделить одну величину на другую.

## Расстояние между точками маршрута

Для вычисления расстояния между двумя произвольными точками маршрута используются методы из [PolylineUtils](../../../com/yandex/mapkit/geometry/geo/PolylineUtils.md). Выполните следующие шаги:

1. Создайте объект [PolylineIndex](../../../com/yandex/mapkit/geometry/geo/PolylineIndex.md), привязанный к вашему маршруту, используя [PolylineUtils.createPolylineIndex](../../../com/yandex/mapkit/geometry/geo/PolylineUtils.md#createpolylineindexpolyline).
2. Используйте метод [PolylineIndex.closestPolylinePosition](../../../com/yandex/mapkit/geometry/geo/PolylineIndex.md#closestpolylinepositionpoint-priority-double) для получения [PolylinePosition](../../../com/yandex/mapkit/geometry/PolylinePosition.md) точек на маршруте.
3. Вычислите значение расстояния между двумя точками на маршруте, с помощью [PolylineUtils.distanceBetweenPolylinePositions](../../../com/yandex/mapkit/geometry/geo/PolylineUtils.md#distancebetweenpolylinepositionspolyline-polylineposition-polylineposition).

Пример вычисления значения расстояния между двумя произвольными точками маршрута:

```kotlin
fun distanceBetweenPointsOnRoute(route: DrivingRoute, first: Point, second: Point): Float {
    val polylineIndex = PolylineUtils.createPolylineIndex(route.geometry)
    val firstPosition = polylineIndex.closestPolylinePosition(first, Priority.CLOSEST_TO_RAW_POINT, 1.0)!!
    val secondPosition = polylineIndex.closestPolylinePosition(second, Priority.CLOSEST_TO_RAW_POINT, 1.0)!!
    return PolylineUtils.distanceBetweenPolylinePositions(route.geometry, firstPosition, secondPosition)
}
```

## Время между точками маршрута

Рассмотрим алгоритм нахождения времени поездки между текущей точкой маршрута и произвольной точкой на маршруте, которая следует по маршруту позже.

1. Нужно найти расстояние между текущей точкой маршрута и второй точкой. Для этого можно использовать [алгоритм](map_routes.md#distance-between-points) из предыдущего пункта.
2. При помощи метода [RoutePosition.advance](../../../com/yandex/mapkit/navigation/RoutePosition.md#advancedouble) рассчитайте значение [RoutePosition](../../../com/yandex/mapkit/navigation/RoutePosition.md) второй точки.
3. Используя метод [RoutePosition.timeToFinish](../../../com/yandex/mapkit/navigation/RoutePosition.md#timetofinish) найдите разницу времени поездки между текущей точкой маршрута и второй точкой.

Пример вычисления времени поездки от текущей позиции маршрута до произвольной точки маршрута:

```kotlin
fun timeTravelToPoint(route: DrivingRoute, point: Point): Float {
    val currentPosition = route.routePosition
    val distance = distanceBetweenPointsOnRoute(route, currentPosition.point, point)
    val targetPosition = currentPosition.advance(distance)
    return targetPosition.timeToFinish() - currentPosition.timeToFinish()
}
```

Для вычисления времени поездки между двумя произвольными точками на маршруте, используйте разницу между результатами вычисления `timeTravelToPoint` для обоих точек.
