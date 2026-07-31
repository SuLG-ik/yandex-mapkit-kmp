---
title: "Маршрутизация"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / Руководство / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_routing.html"
---
# Маршрутизация

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/tutorials/map_routing.html)

MapKit SDK можно использовать для построения оптимальных [маршрутов](map_routes.md) по промежуточным точкам. Маршрутизация осуществляется с учетом параметров построения маршрута и особенностей вашего транспортного средства.

> [!WARNING] Важно
> Функционал построения маршрутов доступен в [full](../getting_started.md#add-library)-версии MapKit SDK.

## Запрос построения маршрутов

1. Создайте экземпляр класса [DrivingRouter](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md).

   ```kotlin
   val drivingRouter = DirectionsFactory.getInstance().createDrivingRouter()
   ```
2. Задайте [параметры построения маршрута](map_routing.md#driving-options) при помощи класса [DrivingOptions](../../../com/yandex/mapkit/directions/driving/DrivingOptions.md).
   Пример создания параметров маршрута для запроса трех маршрутов.

   ```kotlin
   val drivingOptions = DrivingOptions().apply {
       routesCount = 3
   }
   ```
3. Чтобы определить [параметры транспортного средства](map_routing.md#vehicle-options) используйте класс [VehicleOptions](../../../com/yandex/mapkit/directions/driving/VehicleOptions.md).

   ```kotlin
   val vehicleOptions = VehicleOptions()
   ```
4. Создайте новую [сессию построения маршрута](map_routing.md#driving-session) при помощи метода [DrivingRouter.requestRoutes](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutesjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingroutelistener).
   Пример запроса построения маршрута по двум точками.

   ```kotlin
   val points = buildList {
       add(RequestPoint(Point(55.757048, 37.615005), RequestPointType.WAYPOINT, null, null, null))
       add(RequestPoint(Point(55.776384, 37.585504), RequestPointType.WAYPOINT, null, null, null))
   }

   val drivingSession = drivingRouter.requestRoutes(
       points,
       drivingOptions,
       vehicleOptions,
       drivingRouteListener
   )
   ```
5. Используйте следующий механизм для получения [результатов построения маршрута](map_routing.md#request-results).
   Создайте объект с типом интерфейса [DrivingRouteListener](../../../com/yandex/mapkit/directions/driving/DrivingRouteListener.md):

   ```kotlin
   val drivingRouteListener = object : DrivingRouteListener {
       override fun onDrivingRoutes(drivingRoutes: MutableList<DrivingRoute>) {
           // Handle request routes success ...
       }

       override fun onDrivingRoutesError(error: Error) {
           // Handle request routes error ...
       }
   }
   ```

   Реализация данного интерфейса передается в качестве аргумента во все методы создания сессии построения маршрутов.

## Параметры построения маршрута

Класс [DrivingOptions](../../../com/yandex/mapkit/directions/driving/DrivingOptions.md) позволяет задать следующие параметры построения маршрута:

- `initialAzimuth` - задает направление движения в начальной точке маршрута, что позволяет определить, нужно ли делать разворот, и на какой полосе движется транспортное средство - на попутной или противоположной;
- `routesCount` - количество альтернативных маршрутов;
- `avoidanceFlags` - позволяет не строить маршруты по дорогам с указанными свойствами (платным, в плохом состоянии и пр.), если это возможно;
- `departureTime` - время отправления.

## Параметры транспортного средства

При помощи класса [VehicleOptions](../../../com/yandex/mapkit/directions/driving/VehicleOptions.md) можно задать вид транспортного средства, на котором передвигается пользователь. Поддерживаются следующие типы [VehicleType](../../../com/yandex/mapkit/directions/driving/VehicleType.md) транспортных средств:

- стандартный - легковой автомобиль;
- грузовик;
- мотоцикл.

Построение маршрута происходит с учетом различных особенностей выбранного транспортного средства. Для разных типов маршруты могут отличаться. Для грузового транспорта, например, маршрут будет построен с учетом указанных грузовых ограничений.

Существуют следующие виды грузовых ограничений:

- габариты: высота, длина и ширина;
- масса: общий вес, вес подвески, максимально допустимый вес и т.д.;
- наличие прицепа и эко-класс транспорта.

## Построение заранее рассчитанного маршрута

Если у вас уже есть координаты маршрута для автомобиля, рассчитанные в стороннем сервисе, вы можете передать их в MapKit SDK для визуализации и использования в вашем приложении. Для этого используется метод [matchRoute](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#matchroutepolyline-drivingoptions-vehicleoptions-drivingroutelistener), в который передается маршрут в формате полилинии.

MapKit SDK построит маршрут по предложенным координатам, а также автоматически скорректирует его, если точки маршрута пересекают пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#matchroutepolyline-drivingoptions-vehicleoptions-drivingroutelistener) поддерживает полилинии, состоящие не более чем из 2000 точек.

> [!NOTE] Примечание
> В настоящее время данная функциональность доступна только по дополнительному запросу.
>
>
> Для того что бы оставить запрос свяжитесь с нами по почте <{{sales_email}}>.

## Сессия построения маршрутов

Для создания новой сессии построения маршрутов используется метод [DrivingRouter.requestRoutes](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutesjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingroutelistener). Построение маршрутов происходит по списку точек, которые передаются в качестве первого аргумента.

Точки маршрута делятся на два вида:

1. [WAYPOINT](../../../com/yandex/mapkit/RequestPointType.md#waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
2. [VIAPOINT](../../../com/yandex/mapkit/RequestPointType.md#viapoint) - используются для корректировки траектории маршрута. Маршрут обязательно должен быть построен через все via-точки.

В результате вызова метода построения маршрутов [DrivingRouter.requestRoutes](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutesjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingroutelistener) будет создана сессия запроса маршрутов. Сессия построения маршрутов представлена классом [DrivingSession](../../../com/yandex/mapkit/directions/driving/DrivingSession.md). Она позволяет управлять состоянием процесса запроса маршрутов при помощи следующих методов:

- `retry` - перезапуск запроса построения маршрута;
- `cancel` - отмена текущего запроса.

> [!WARNING] Важно
> Приложение должно хранить ссылку на полученный объект [DrivingSession](../../../com/yandex/mapkit/directions/driving/DrivingSession.md). Иначе запрос маршрутов будет отменен.

## Результаты построения маршрутов

Для получения результатов запроса построения маршрутов используется подписка на интерфейс [DrivingRouteListener](../../../com/yandex/mapkit/directions/driving/DrivingRouteListener.md). Его реализация передается во время вызова метода создания сессии построения маршрута [DrivingRouter.requestRoutes](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutesjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingroutelistener).

Поддерживается два типа методов-обработчиков:

1. `onDrivingRoutes` - построение [маршрутов](map_routes.md) прошло успешно, предоставляет список полученных маршрутов [DrivingRoute](../../../com/yandex/mapkit/directions/driving/DrivingRoute.md).
2. `onDrivingRoutesError` - оповещает о неудачном завершении построении маршрутов.

## Запрос информации о маршрутах без геометрии

Кроме функционала построения маршрутов класс [DrivingRouter](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md) используется для получения информации о маршрутах. Этот запрос представляет собой упрощенную версию [запроса построения маршрутов](map_routing.md#build-routes). В результате него данные о геометрии маршрутов, которые при передаче по сети потребляют наибольшее количество ресурсов, не передаются. Он используется в сценариях, когда нужно построить маршрут, но отображать на карте его не требуется, например, чтобы узнать расстояние или время движения по возможным маршрутам.

При помощи метода [DrivingRouter.requestRoutesrequestRoutesSummary](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutessummaryjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingsummarylistener) можно получить следующую информацию о маршрутах:

- дистанцию;
- продолжительность по времени с учетом пробок и без;
- список флагов [Flags](../../../com/yandex/mapkit/directions/driving/Flags.md), которые характеризуют маршрут, например, наличие платной дороги, паромной переправы, парковки и т.д.

При помощи интерфейса [DrivingSummaryListener](../../../com/yandex/mapkit/directions/driving/DrivingSummaryListener.md) можно получить результаты запроса сводки маршрутов. Он передается в качестве аргумента при вызове метода [DrivingRouter.requestRoutesrequestRoutesSummary](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md#requestroutessummaryjavautillistrequestpoint-drivingoptions-vehicleoptions-drivingsummarylistener).

## Исходный код

Подробнее с примерами использования API можно ознакомиться в `map-routing` демо-приложении в нашем [репозитории на Github](https://github.com/yandex/mapkit-android-demo).
