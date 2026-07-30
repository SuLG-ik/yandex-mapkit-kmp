---
title: "Маршрутизация"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / Руководство / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_routing.html"
---
# Маршрутизация

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/tutorials/map_routing.html)

MapKit SDK можно использовать для построения оптимальных [маршрутов](map_routes.md) по промежуточным точкам. Маршрутизация осуществляется с учетом параметров построения маршрута и особенностей вашего транспортного средства.

> [!WARNING] Важно
> Функционал построения маршрутов доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Запрос построения маршрутов

1. Создайте экземпляр класса [YMKDrivingRouter](../../../Swift/YMKDrivingRouter.md).

   ```swift
   let drivingRouter: YMKDrivingRouter = YMKDirections.sharedInstance().createDrivingRouter(withType: .combined)
   ```
2. Задайте [параметры построения маршрута](map_routing.md#driving-options) при помощи класса [YMKDrivingOptions](../../../Swift/YMKDrivingOptions.md).
   Пример создания параметров маршрута для запроса трех маршрутов.

   ```swift
   let drivingOptions: YMKDrivingOptions = {
       let options = YMKDrivingOptions()
       options.routesCount = 3
       return options
   }()
   ```
3. Чтобы определить [параметры транспортного средства](map_routing.md#vehicle-options) используйте класс [YMKDrivingVehicleOptions](../../../Swift/YMKDrivingVehicleOptions.md).

   ```swift
   let vehicleOptions = YMKDrivingVehicleOptions()
   ```
4. Создайте новую [сессию построения маршрута](map_routing.md#driving-session) при помощи метода [YMKDrivingRouter.requestRoutes(with:drivingOptions:vehicleOptions:routeHandler:)](../../../Swift/YMKDrivingRouter.md#requestrouteswithdrivingoptionsvehicleoptionsroutehandler).
   Пример запроса построения маршрута по двум точками.

   ```swift
   let points = [
       YMKRequestPoint(point: YMKPoint(latitude: 25.196141, longitude: 55.278543), type: .waypoint, pointContext: nil, drivingArrivalPointId: nil),
       YMKRequestPoint(point: YMKPoint(latitude: 25.171148, longitude: 55.238034), type: .waypoint, pointContext: nil, drivingArrivalPointId: nil)
   ]

   let drivingSession = drivingRouter.requestRoutes(
       with: requestPoints,
       drivingOptions: drivingOptions,
       vehicleOptions: vehicleOptions,
       routeHandler: drivingRouteHandler
   )
   ```
5. Используйте следующий механизм для получения [результатов построения маршрута](map_routing.md#request-results).
   Создайте объект типа [YMKDrivingSessionRouteHandler](../../../Swift/YMKDrivingSessionRouteHandler.md):

   ```swift
   func drivingRouteHandler(drivingRoutes: [YMKDrivingRoute]?, error: Error?) {
       if let error {
           // Handle request routes error
           return
       }

       guard let drivingRoutes else {
           return
       }

       // Handle request routes success
   }
   ```

   Данная функция-обработчик передается в качестве аргумента во все методы создания сессии построения маршрутов.

## Параметры построения маршрута

Класс [YMKDrivingOptions](../../../Swift/YMKDrivingOptions.md) позволяет задать следующие параметры построения маршрута:

- `initialAzimuth` - задает направление движения в начальной точке маршрута, что позволяет определить, нужно ли делать разворот, и на какой полосе движется транспортное средство - на попутной или противоположной;
- `routesCount` - количество альтернативных маршрутов;
- `avoidanceFlags` - позволяет не строить маршруты по дорогам с указанными свойствами (платным, в плохом состоянии и пр.), если это возможно;
- `departureTime` - время отправления.

## Параметры транспортного средства

При помощи класса [YMKDrivingVehicleOptions](../../../Swift/YMKDrivingVehicleOptions.md) можно задать вид транспортного средства, на котором передвигается пользователь. Поддерживаются следующие типы [YMKDrivingVehicleType](../../../Swift/YMKDrivingVehicleType.md) транспортных средств:

- стандартный - легковой автомобиль;
- грузовик;
- мотоцикл.

Построение маршрута происходит с учетом различных особенностей выбранного транспортного средства. Для разных типов маршруты могут отличаться. Для грузового транспорта, например, маршрут будет построен с учетом указанных грузовых ограничений.

Существуют следующие виды грузовых ограничений:

- габариты: высота, длина и ширина;
- масса: общий вес, вес подвески, максимально допустимый вес и т.д.;
- наличие прицепа и эко-класс транспорта.

## Построение заранее рассчитанного маршрута

Если у вас уже есть координаты маршрута для автомобиля, рассчитанные в стороннем сервисе, вы можете передать их в MapKit SDK для визуализации и использования в вашем приложении. Для этого используется метод [matchRoute](../../../Swift/YMKDrivingRouter.md#matchroutewithdrivingoptionsvehicleoptionsroutehandler), в который передается маршрут в формате полилинии.

MapKit SDK построит маршрут по предложенным координатам, а также автоматически скорректирует его, если точки маршрута пересекают пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](../../../Swift/YMKDrivingRouter.md#matchroutewithdrivingoptionsvehicleoptionsroutehandler) поддерживает полилинии, состоящие не более чем из 2000 точек.

> [!NOTE] Примечание
> В настоящее время данная функциональность доступна только по дополнительному запросу.
>
>
> Для того что бы оставить запрос свяжитесь с нами по почте <{{sales_email}}>.

## Сессия построения маршрутов

Для создания новой сессии построения маршрутов используется метод [YMKDrivingRouter.requestRoutes(with:drivingOptions:vehicleOptions:routeHandler:)](../../../Swift/YMKDrivingRouter.md#requestrouteswithdrivingoptionsvehicleoptionsroutehandler). Построение маршрутов происходит по списку точек, которые передаются в качестве первого аргумента.

Точки маршрута делятся на два вида:

1. [waypoint](../../../Swift/YMKRequestPointType.md#waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
2. [viapoint](../../../Swift/YMKRequestPointType.md#viapoint) - используются для корректировки траектории маршрута. Маршрут обязательно должен быть построен через все via-точки.

В результате вызова метода построения маршрутов [YMKDrivingRouter.requestRoutes(with:drivingOptions:vehicleOptions:routeHandler:)](../../../Swift/YMKDrivingRouter.md#requestrouteswithdrivingoptionsvehicleoptionsroutehandler) будет создана сессия запроса маршрутов. Сессия построения маршрутов представлена классом [YMKDrivingSession](../../../Swift/YMKDrivingSession.md). Она позволяет управлять состоянием процесса запроса маршрутов при помощи следующих методов:

- `retry` - перезапуск запроса построения маршрута;
- `cancel` - отмена текущего запроса.

> [!WARNING] Важно
> Приложение должно хранить ссылку на полученный объект [YMKDrivingSession](../../../Swift/YMKDrivingSession.md). Иначе запрос маршрутов будет отменен.

## Результаты построения маршрутов

Для получения результатов запроса построения маршрутов используется обработчик [YMKDrivingSessionRouteHandler](../../../Swift/YMKDrivingSessionRouteHandler.md). Он принимается в качестве аргумента при вызове метода создания запроса построения маршрутов [YMKDrivingRouter.requestRoutes(with:drivingOptions:vehicleOptions:routeHandler:)](../../../Swift/YMKDrivingRouter.md#requestrouteswithdrivingoptionsvehicleoptionsroutehandler).

В результате выполнения запроса построения маршрутов метод-обработчик может быть вызван со следующими опциональными аргументами:

1. `response` - оповещает об успешном завершении запроса построения [маршрутов](map_routes.md), если содержит не `nil` значение. Предоставляет список [YMKDrivingRoute](../../../Swift/YMKDrivingRoute.md), который содержит информацию о результатах запроса.
2. `error` - оповещает о завершении запроса построения маршрутов с ошибкой, если не `nil`.

## Запрос информации о маршрутах без геометрии

Кроме функционала построения маршрутов класс [YMKDrivingRouter](../../../Swift/YMKDrivingRouter.md) используется для получения информации о маршрутах. Этот запрос представляет собой упрощенную версию [запроса построения маршрутов](map_routing.md#build-routes). В результате него данные о геометрии маршрутов, которые при передаче по сети потребляют наибольшее количество ресурсов, не передаются. Он используется в сценариях, когда нужно построить маршрут, но отображать на карте его не требуется, например, чтобы узнать расстояние или время движения по возможным маршрутам.

При помощи метода [YMKDrivingRouter.requestRoutesSummary(with:drivingOptions:vehicleOptions:summaryHandler:)](../../../Swift/YMKDrivingRouter.md#requestroutessummarywithdrivingoptionsvehicleoptionssummaryhandler) можно получить следующую информацию о маршрутах:

- дистанцию;
- продолжительность по времени с учетом пробок и без;
- список флагов [YMKDrivingFlags](../../../Swift/YMKDrivingFlags.md), которые характеризуют маршрут, например, наличие платной дороги, паромной переправы, парковки и т.д.

При помощи интерфейса [YMKDrivingSummarySessionSummaryHandler](../../../Swift/YMKDrivingSummarySessionSummaryHandler.md) можно получить результаты запроса сводки маршрутов. Он передается в качестве аргумента при вызове метода [YMKDrivingRouter.requestRoutesSummary(with:drivingOptions:vehicleOptions:summaryHandler:)](../../../Swift/YMKDrivingRouter.md#requestroutessummarywithdrivingoptionsvehicleoptionssummaryhandler).

## Исходный код

Подробнее с примерами использования API можно ознакомиться в `MapRouting` демо-приложении в нашем [репозитории на Github](https://github.com/yandex/mapkit-ios-demo).
