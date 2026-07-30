---
title: "Маршрутизация"
kind: "Guide"
platform: "flutter"
language: "Dart"
section: "Flutter / Руководство / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_routing.html"
---
# Маршрутизация

`FLUTTER` · `Dart` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/flutter/generated/tutorials/map_routing.html)

MapKit SDK можно использовать для построения оптимальных [маршрутов](map_routes.md) по промежуточным точкам. Маршрутизация осуществляется с учетом параметров построения маршрута и особенностей вашего транспортного средства.

> [!WARNING] Важно
> Функционал построения маршрутов доступен в [full](https://pub.dev/packages/yandex_maps_mapkit)-версии MapKit SDK.

## Запрос построения маршрутов

1. Создайте экземпляр класса [DrivingRouter](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter-class.html).

   ```dart
   final drivingRouter = DirectionsFactory.instance.createDrivingRouter(DrivingRouterType.Combined);
   ```
2. Задайте [параметры построения маршрута](map_routing.md#driving-options) при помощи класса [DrivingOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingOptions-class.html).
   Пример создания параметров маршрута для запроса трех маршрутов.

   ```dart
   final drivingOptions = DrivingOptions(routesCount: 3);
   ```
3. Чтобы определить [параметры транспортного средства](map_routing.md#vehicle-options) используйте класс [DrivingVehicleOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingVehicleOptions-class.html).

   ```dart
   final vehicleOptions = DrivingVehicleOptions();
   ```
4. Создайте новую [сессию построения маршрута](map_routing.md#driving-session) при помощи метода [DrivingRouter.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutes.html).
   Пример запроса построения маршрута по двум точками.

   ```dart
   final points = [
     RequestPoint(Point(latitude: 25.196141, longitude: 55.278543), RequestPointType.Waypoint, null, null)),
     RequestPoint(Point(latitude: 25.171148, longitude: 55.238034), RequestPointType.Waypoint, null, null)),
   ];

   final drivingSession = drivingRouter.requestRoutes(
     drivingOptions,
     vehicleOptions,
     drivingRouteListener,
     points: points,
   );
   ```
5. Используйте следующий механизм для получения [результатов построения маршрута](map_routing.md#request-results).
   Создайте объект с типом интерфейса [DrivingSessionRouteListener](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingSessionRouteListener-class.html):

   ```dart
   final class DrivingSessionRouteListenerImpl implements DrivingSessionRouteListener {

     @override
     void onDrivingRoutes(List<DrivingRoute> routes) {
       // Handle request routes success ...
     }

     @override
     void onDrivingRoutesError(Error error) {
       // Handle request routes error ...
     }
   }
   ```

   Реализация данного интерфейса передается в качестве аргумента во все методы создания сессии построения маршрутов.

## Параметры построения маршрута

Класс [DrivingOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingOptions-class.html) позволяет задать следующие параметры построения маршрута:

- `initialAzimuth` - задает направление движения в начальной точке маршрута, что позволяет определить, нужно ли делать разворот, и на какой полосе движется транспортное средство - на попутной или противоположной;
- `routesCount` - количество альтернативных маршрутов;
- `avoidanceFlags` - позволяет не строить маршруты по дорогам с указанными свойствами (платным, в плохом состоянии и пр.), если это возможно;
- `departureTime` - время отправления.

## Параметры транспортного средства

При помощи класса [DrivingVehicleOptions](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingVehicleOptions-class.html) можно задать вид транспортного средства, на котором передвигается пользователь. Поддерживаются следующие типы [DrivingVehicleType](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingVehicleType.html) транспортных средств:

- стандартный - легковой автомобиль;
- грузовик;
- мотоцикл.

Построение маршрута происходит с учетом различных особенностей выбранного транспортного средства. Для разных типов маршруты могут отличаться. Для грузового транспорта, например, маршрут будет построен с учетом указанных грузовых ограничений.

Существуют следующие виды грузовых ограничений:

- габариты: высота, длина и ширина;
- масса: общий вес, вес подвески, максимально допустимый вес и т.д.;
- наличие прицепа и эко-класс транспорта.

## Построение заранее рассчитанного маршрута

Если у вас уже есть координаты маршрута для автомобиля, рассчитанные в стороннем сервисе, вы можете передать их в MapKit SDK для визуализации и использования в вашем приложении. Для этого используется метод [matchRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/matchRoute.html), в который передается маршрут в формате полилинии.

MapKit SDK построит маршрут по предложенным координатам, а также автоматически скорректирует его, если точки маршрута пересекают пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/matchRoute.html) поддерживает полилинии, состоящие не более чем из 2000 точек.

> [!NOTE] Примечание
> В настоящее время данная функциональность доступна только по дополнительному запросу.
>
>
> Для того что бы оставить запрос свяжитесь с нами по почте <{{sales_email}}>.

## Сессия построения маршрутов

Для создания новой сессии построения маршрутов используется метод [DrivingRouter.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutes.html). Построение маршрутов происходит по списку точек, которые передаются в качестве первого аргумента.

Точки маршрута делятся на два вида:

1. [Waypoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RequestPointType.html#Waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
2. [Viapoint](https://pub.dev/documentation/yandex_maps_navikit/latest/mapkit/RequestPointType.html#Viapoint) - используются для корректировки траектории маршрута. Маршрут обязательно должен быть построен через все via-точки.

В результате вызова метода построения маршрутов [DrivingRouter.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutes.html) будет создана сессия запроса маршрутов. Сессия построения маршрутов представлена классом [DrivingSession](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingSession-class.html). Она позволяет управлять состоянием процесса запроса маршрутов при помощи следующих методов:

- `retry` - перезапуск запроса построения маршрута;
- `cancel` - отмена текущего запроса.

> [!WARNING] Важно
> Приложение должно хранить ссылку на полученный объект [DrivingSession](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingSession-class.html). Иначе запрос маршрутов будет отменен.

## Результаты построения маршрутов

Для получения результатов запроса построения маршрутов используется подписка на интерфейс [DrivingSessionRouteListener](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingSessionRouteListener-class.html). Его реализация передается во время вызова метода создания сессии построения маршрута [DrivingRouter.requestRoutes](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutes.html)

Поддерживается два типа методов-обработчиков:

1. `onDrivingRoutes` - построение [маршрутов](map_routes.md) прошло успешно, предоставляет список полученных маршрутов [DrivingRoute](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRoute-class.html).
2. `onDrivingRoutesError` - оповещает о неудачном завершении построении маршрутов.

## Запрос информации о маршрутах без геометрии

Кроме функционала построения маршрутов класс [DrivingRouter](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter-class.html) используется для получения информации о маршрутах. Этот запрос представляет собой упрощенную версию [запроса построения маршрутов](map_routing.md#build-routes). В результате него данные о геометрии маршрутов, которые при передаче по сети потребляют наибольшее количество ресурсов, не передаются. Он используется в сценариях, когда нужно построить маршрут, но отображать на карте его не требуется, например, чтобы узнать расстояние или время движения по возможным маршрутам.

При помощи метода [DrivingRouter.requestRoutesSummary](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutesSummary.html) можно получить следующую информацию о маршрутах:

- дистанцию;
- продолжительность по времени с учетом пробок и без;
- список флагов [DrivingFlags](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingFlags-class.html), которые характеризуют маршрут, например, наличие платной дороги, паромной переправы, парковки и т.д.

При помощи интерфейса [DrivingSummarySessionSummaryListener](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingSummarySessionSummaryListener-class.html) можно получить результаты запроса сводки маршрутов. Он передается в качестве аргумента при вызове метода [DrivingRouter.requestRoutesSummary](https://pub.dev/documentation/yandex_maps_navikit/latest/directions/DrivingRouter/requestRoutesSummary.html).

## Исходный код

Подробнее с примерами использования API можно ознакомиться в `map_routing` демо-приложении в нашем [репозитории на GitHub](https://github.com/yandex/mapkit-flutter-demo).
