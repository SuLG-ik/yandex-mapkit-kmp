---
title: "Маршруты"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Данные о маршруте"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_routes.html"
---
# Маршруты

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_routes.html)

Маршрут - это последовательность координат на карте, путь, по которому должен двигаться пользователь чтобы попасть из точки `A` в точку `B`. Маршрут может включать в себя промежуточные via-точки.

Помимо данных о траектории поездки, маршрут содержит различную дополнительную информацию. Например, дорожные предупреждения, дистанцию, примерное время движения по маршруту и т.д.

В MapKit SDK маршрут представлен классом [YMKDrivingRoute](../../../Swift/YMKDrivingRoute.md), рассмотрим его основной функционал.

## Метаданные

Метаданные [YMKDrivingRouteMetadata](../../../Swift/YMKDrivingRouteMetadata.md) содержат информацию об описании маршрута, его параметрах и характеристиках, дистанцию и примерное время движения по маршруту.

Для получения метаданных используется метод [YMKDrivingRoute.metadata](../../../Swift/YMKDrivingRoute.md#metadata).

### URI маршрута

**URI** представляет собой строковый идентификатор маршрута.

Для получения **URI** маршрута, используется метод [YMKDrivingRouteMetadata.uri](../../../Swift/YMKDrivingRouteMetadata.md#uri).

## Позиция

Маршрут может содержать информацию о текущей позиции, она отражает какая часть маршрута была пройдена.

Для получения текущей позиции используется метод [YMKDrivingRoute.position](../../../Swift/YMKDrivingRoute.md#position).

## Предупреждения и события

**Дорожные события** на маршруте позволяют узнать о некоторых событиях, которые происходят на дороге. Используйте метод [YMKDrivingRoute.events](../../../Swift/YMKDrivingRoute.md#events) для получения информации о дорожных событиях на маршруте.

**Предупреждения** на маршруте содержат информацию о различных объектах на маршруте. Среди объектов встречаются светофоры ([YMKDrivingRoute.trafficLights](../../../Swift/YMKDrivingRoute.md#trafficlights)), железнодорожные переправы ([YMKDrivingRoute.railwayCrossings](../../../Swift/YMKDrivingRoute.md#railwaycrossings)), лежачие полицейские ([YMKDrivingRoute.speedBumps](../../../Swift/YMKDrivingRoute.md#speedbumps)) и т.д. Подробнее об этом можно узнать в [YMKDrivingRoute](../../../Swift/YMKDrivingRoute.md) API.

## Пробки на маршруте

С помощью метода [YMKDrivingRoute.jamSegments](../../../Swift/YMKDrivingRoute.md#jamsegments) можно получить информацию о загруженности дорог на маршруте. Данный метод возвращает список из [YMKJamSegment](../../../Swift/YMKJamSegment.md) объектов. Каждый элемент списка описывает состояние загруженности дороги и среднюю скорость движения по ней на соответствующем отрезке маршрута. Отрезок с номером **N** соответствует участку маршрута, который находится между **N** и **N + 1** точками геометрии маршрута, которые можно получить с помощью вызова [YMKDrivingRoute.geometry](../../../Swift/YMKDrivingRoute.md#geometry).

## Подписка на обновление

В течении жизненного цикла маршрута некоторые данные о маршруте могут измениться. MapKit SDK предоставляет возможность подписаться на изменения информации о маршруте при помощи интерфейса [YMKDrivingConditionsListener](../../../Swift/YMKDrivingConditionsListener.md).

## Расчет прогресса по маршруту

Прогрессом по маршруту называется доля от изначального маршрута, которая была пройдена.

Ниже приведен фрагмент кода для вычисления данного значения:

```swift
func routeProgress(route: YMKDrivingRoute) -> Double {
    let startPosition = YMKPolylinePosition(segmentIndex: .zero, segmentPosition: .zero)
    let distanceFull = route.metadataAt(with: startPosition).weight.distance.value
    let distanceLeft = route.metadata.weight.distance.value
    return 1.0 - distanceLeft / distanceFull
}
```

Для вычисления доли пройденного маршрута нужно рассчитать общую и пройденную дистанцию маршрута, а затем разделить одну величину на другую.

## Расстояние между точками маршрута

Для вычисления расстояния между двумя произвольными точками маршрута используются методы из [YMKPolylineUtils](../../../Swift/YMKPolylineUtils.md). Выполните следующие шаги:

1. Создайте объект [YMKPolylineIndex](../../../Swift/YMKPolylineIndex.md), привязанный к вашему маршруту, используя [YMKPolylineUtils.createPolylineIndex(with:)](../../../Swift/YMKPolylineUtils.md#createpolylineindexwith).
2. Используйте метод [YMKPolylineIndex.closestPolylinePosition(with:priority:maxLocationBias:)](../../../Swift/YMKPolylineIndex.md#closestpolylinepositionwithprioritymaxlocationbias) для получения [YMKPolylinePosition](../../../Swift/YMKPolylinePosition.md) точек на маршруте.
3. Вычислите значение расстояния между двумя точками на маршруте, с помощью [YMKPolylineUtils.distanceBetweenPolylinePositions(with:from:to:)](../../../Swift/YMKPolylineUtils.md#distancebetweenpolylinepositionswithfromto).

Пример вычисления значения расстояния между двумя произвольными точками маршрута:

```swift
func distanceBetweenPointsOnRoute(route: YMKDrivingRoute, first: YMKPoint, second: YMKPoint) -> Double {
    let polylineIndex = YMKPolylineUtils.createPolylineIndex(with: route.geometry)
    let firstPosition = polylineIndex.closestPolylinePosition(
        with: first,
        priority: .closestToRawPoint,
        maxLocationBias: 1.0
    )!
    let secondPosition = polylineIndex.closestPolylinePosition(
        with: second,
        priority: .closestToRawPoint,
        maxLocationBias: 1.0
    )!
    return Double(
        YMKPolylineUtils.distanceBetweenPolylinePositions(
            with: route.geometry,
            from: firstPosition,
            to: secondPosition
        )
    )
}
```

## Время между точками маршрута

Рассмотрим алгоритм нахождения времени поездки между текущей точкой маршрута и произвольной точкой на маршруте, которая следует по маршруту позже.

1. Нужно найти расстояние между текущей точкой маршрута и второй точкой. Для этого можно использовать [алгоритм](map_routes.md#distance-between-points) из предыдущего пункта.
2. При помощи метода [YMKRoutePosition.advance(withDistance:)](../../../Swift/YMKRoutePosition.md#advancewithdistance) рассчитайте значение [YMKRoutePosition](../../../Swift/YMKRoutePosition.md) второй точки.
3. Используя метод [YMKRoutePosition.timeToFinish()](../../../Swift/YMKRoutePosition.md#timetofinish) найдите разницу времени поездки между текущей точкой маршрута и второй точкой.

Пример вычисления времени поездки от текущей позиции маршрута до произвольной точки маршрута:

```swift
func timeTravelToPoint(route: YMKDrivingRoute, point: YMKPoint) -> Double {
    let currentPosition = route.routePosition
    let distance = distanceBetweenPointsOnRoute(
        route: route,
        first: currentPosition.point,
        second: point
    )
    let targetPosition = currentPosition.advance(withDistance: distance)
    return targetPosition.timeToFinish() - currentPosition.timeToFinish()
}
```

Для вычисления времени поездки между двумя произвольными точками на маршруте, используйте разницу между результатами вычисления `timeTravelToPoint` для обоих точек.
