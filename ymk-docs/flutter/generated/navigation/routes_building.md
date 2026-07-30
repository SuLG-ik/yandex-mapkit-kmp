---
title: "Построение маршрутов"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / NaviKit SDK / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/routes_building.html"
---
# Построение маршрутов

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/navigation/routes_building.html)

Входной точкой в API NaviKit SDK является класс [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html). В нем содержится основной функционал, связанный с навигацией и построением маршрутов.

## Создание Navigation

Для создания нового экземпляра навигации используется вызов [NavigationFactory.createNavigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationFactory/createNavigation.html).

```dart
final navigation = NavigationFactory.createNavigation(DrivingRouterType.Combined);
```

## Запрос маршрутов

[Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) предоставляет возможность строить оптимальные [маршруты](../tutorials/map_routes.md) с помощью промежуточных точек маршрута.

Для запроса маршрутов используется метод [Navigation.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/requestRoutes.html).

```dart
// Coordinates routes are requested for
final requestPoints = [
  RequestPoint(
    const Point(latitude: 25.190614, longitude: 55.265616), RequestPointType.Waypoint, null, null
  ),
  RequestPoint(
    const Point(latitude: 25.187532, longitude: 55.275413), RequestPointType.Waypoint, null, null
  ),
  RequestPoint(
    const Point(latitude: 25.189279, longitude: 55.282246), RequestPointType.Viapoint, null, null
  ),
  RequestPoint(
    const Point(latitude: 25.196605, longitude: 55.280940), RequestPointType.Waypoint, null, null
  ),
];

navigation.requestRoutes(
  points: requestPoints,
  initialAzimuth: navigation.guidance.location?.heading,
  routesCount: 3,
);
```

Первым аргументом передается список координат [RequestPoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RequestPoint-class.html), через которые будет проходить маршрут.

Точки маршрута делятся на два типа:

- [Waypoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RequestPointType.html#Waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
- [Viapoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RequestPointType.html#Viapoint) - используются для корректировки траектории маршрута. Маршрут будет проходить через все via-точки.

Вторым аргументом передается объект [DrivingOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingOptions-class.html) с параметрами ведения:

- `initialAzimuth` - задает азимут направления пользователя в исходной точке маршрута.
- `routesCount` - количество маршрутов для построения.

> [!NOTE] Примечание
> Количество одновременных запросов маршрутов через [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) ограничено, активный запрос может быть только один. Если создать новый запрос до того, как предыдущий выполнится, то предыдущий будет отменен.

Как получить результат запроса маршрутов смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Запрос маршрута по uri

[Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html) предоставляет возможность запрашивать маршрут по заранее сохраненному [URI маршрута](../tutorials/map_routes.md#uri), при помощи метода [Navigation.resolveUri](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/resolveUri.html).

Получение результатов запроса рассмотрено в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Построение заранее рассчитанного маршрута

Если у вас уже есть заранее рассчитанный маршрут для автомобиля, вы можете использовать его в NaviKit SDK для навигации. Для этого используется метод [matchRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/matchRoute.html), в который передается маршрут в формате полилинии.

NaviKit SDK построит маршрут по заданным координатам и автоматически скорректирует его, если точки маршрута попадают на пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/matchRoute.html) поддерживает полилинии, содержащие не более 2000 точек.

По умолчанию, NaviKit SDK автоматически перестраивает маршрут, если водитель отклоняется от него.
Если необходимо запретить перестроение маршрута, вызовите метод [setEnableReroutes](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Guidance/enableReroutes.html) со значением `false`. Это позволит навигатору продолжать вести по изначально загруженному маршруту, даже если пользователь съехал с него.

## Запрос альтернативных маршрутов

В ходе ведения по текущему маршруту существует возможность построить список альтернативных маршрутов. В терминологии NaviKit SDK такие маршруты называются глобальными альтернативами. Они требуют выполнения отдельного запроса.

Для этого используется асинхронный вызов [Navigation.requestAlternatives](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/requestAlternatives.html).

Как получить результат запроса альтернатив смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## События

При помощи интерфейса [NavigationListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener-class.html) существует возможность подписаться на сущность [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), для получения событий об изменении внутреннего состояния навигации.

### Результат запроса маршрутов

Вызовы [Navigation.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/requestRoutes.html) и [Navigation.requestAlternatives](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/requestAlternatives.html) являются асинхронными, так как реализованы через сетевой запрос. Для обработки результата запроса нужно подписаться на события навигации при помощи [NavigationListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener-class.html) интерфейса.

```dart
final class NavigationListenerImpl implements NavigationListener {

  @override
  void onRoutesBuilt() {
    final routes = navigation.routes;
    final fastestRoute = routes[0];
    // Routes received successfully
  }

  @override
  void onRoutesRequestError(Error error) {
    // An error occured when requesting routes...
  }

  // Override other listener's methods
}

// You have to subscribe to Navigation before calling the route/alternative request
final NavigationListener listener = NavigationListenerImpl();
navigation.addListener(listener);
```

Метод-обработчик [NavigationListener.onRoutesBuilt](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesBuilt.html) вызывается после успешного запроса маршрутов. Результат запроса маршрутов можно получить используя метод [Navigation.routes](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/routes.html), который возвращает список маршрутов, соответствующих последнему запросу. Маршруты в этом списке отсортированы по возрастанию продолжительности поездки, самый быстрый маршрут будет находиться в списке первым.

О возникновении ошибки при запросе маршрутов можно узнать, реализовав метод [NavigationListener.onRoutesRequestError](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesRequestError.html).

### Создание нового запроса

При помощи [NavigationListener](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener-class.html) можно подписаться на события создания нового запроса к [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html), в зависимости от типа запрашиваемых маршрутов.

```dart
final class NavigationListenerImpl implements NavigationListener {

  @override
  void onRoutesRequested(List<RequestPoint> points) {
    // ...
  }

  @override
  void onAlternativesRequested(DrivingRoute currentRoute) {
    // ...
  }

  // Override other listener's methods
}

final NavigationListener listener = NavigationListenerImpl();
navigation.addListener(listener);
```

- [NavigationListener.onRoutesRequested](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onRoutesRequested.html) оповещает о создании нового запроса на построение маршрутов.
- [NavigationListener.onAlternativesRequested](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onAlternativesRequested.html) оповещает о создании нового запроса на получение альтернативных маршрутов.

### Сброс маршрутов

При помощи метода [NavigationListener.onResetRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/NavigationListener/onResetRoutes.html) можно подписаться на событие сброса состояния маршрутов.

## Параметры запроса маршрутов

Существует возможность запроса маршрута с учетом дополнительных параметров, которые применяются с помощью метода [Navigation](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation-class.html):

- [Navigation.avoidanceFlags](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/avoidanceFlags.html) - избегание дорог с указанными свойствами (платных, в плохом состоянии и пр.).

## Грузовая навигация

NaviKit SDK способен запрашивать маршруты с учетом особенностей различных транспортных средств. Для применения параметров транспортных средств используйте вызов [Navigation.vehicleOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/navigation/Navigation/vehicleOptions.html).

Параметры транспортного средства передаются с помощью класса [DrivingVehicleOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingVehicleOptions-class.html), в нем хранятся все данные, используемые при грузовых ограничениях. Например: габариты (высота, ширина, длина), параметры массы (фактическая, разрешенная, нагрузка на ось, грузоподъемность) и прочая информация (наличие прицепа, экологический класс и т.д.).

Пример запроса маршрутов для грузового транспортного средства с параметрами высоты 4,5 метра и общей массой 45 тонн:

```dart
navigation.vehicleOptions = DrivingVehicleOptions(
  vehicleType: DrivingVehicleType.Truck,
  weight: 45.0,
  height: 4.5,
);
navigation.requestRoutes(somePoints, someInitialAzimuth, someRoutesCount)
```

После запроса маршрута с использованием [DrivingVehicleOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingVehicleOptions-class.html), он будет построен с учетом переданных параметров выбранного транспортного средства.
