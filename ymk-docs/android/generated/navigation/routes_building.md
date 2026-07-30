---
title: "Построение маршрутов"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / NaviKit SDK / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/routes_building.html"
---
# Построение маршрутов

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/generated/navigation/routes_building.html)

Входной точкой в API NaviKit SDK является класс [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md). В нем содержится основной функционал, связанный с навигацией и построением маршрутов.

## Создание Navigation

Для создания нового экземпляра навигации используется вызов [NavigationFactory.createNavigation](../../../com/yandex/mapkit/navigation/automotive/NavigationFactory.md#createnavigationdrivingroutertype).

```kotlin
val navigation = NavigationFactory.createNavigation(DrivingRouterType.COMBINED)
```

## Запрос маршрутов

[Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) предоставляет возможность строить оптимальные [маршруты](../tutorials/map_routes.md) с помощью промежуточных точек маршрута.

Для запроса маршрутов используется метод [Navigation.requestRoutes](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#requestroutesjavautillistrequestpoint-routeoptions).

```kotlin
// Coordinates routes are requested for
val requestPoints = listOf(
    RequestPoint(Point(25.190614, 55.265616), RequestPointType.Waypoint, null),
    RequestPoint(Point(25.187532, 55.275413), RequestPointType.Waypoint, null),
    RequestPoint(Point(25.189279, 55.282246), RequestPointType.Viapoint, null),
    RequestPoint(Point(25.196605, 55.280940), RequestPointType.Waypoint, null),
)
navigation.requestRoutes(
    requestPoints,
    navigation.guidance.location?.heading,
    3,
)
```

Первым аргументом передается список координат [RequestPoint](../../../com/yandex/mapkit/RequestPoint.md), через которые будет проходить маршрут.

Точки маршрута делятся на два типа:

- [WAYPOINT](../../../com/yandex/mapkit/RequestPointType.md#waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
- [VIAPOINT](../../../com/yandex/mapkit/RequestPointType.md#viapoint) - используются для корректировки траектории маршрута. Маршрут будет проходить через все via-точки.

Вторым аргументом передается объект [DrivingOptions](../../../com/yandex/mapkit/directions/driving/DrivingOptions.md) с параметрами ведения:

- `initialAzimuth` - задает азимут направления пользователя в исходной точке маршрута.
- `routesCount` - количество маршрутов для построения.

> [!NOTE] Примечание
> Количество одновременных запросов маршрутов через [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) ограничено, активный запрос может быть только один. Если создать новый запрос до того, как предыдущий выполнится, то предыдущий будет отменен.

Как получить результат запроса маршрутов смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Запрос маршрута по uri

[Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) предоставляет возможность запрашивать маршрут по заранее сохраненному [URI маршрута](../tutorials/map_routes.md#uri), при помощи метода [Navigation.resolveUri](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#resolveurijavalangstring).

Получение результатов запроса рассмотрено в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Построение заранее рассчитанного маршрута

Если у вас уже есть заранее рассчитанный маршрут для автомобиля, вы можете использовать его в NaviKit SDK для навигации. Для этого используется метод [matchRoute](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#matchroutepolyline), в который передается маршрут в формате полилинии.

NaviKit SDK построит маршрут по заданным координатам и автоматически скорректирует его, если точки маршрута попадают на пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#matchroutepolyline) поддерживает полилинии, содержащие не более 2000 точек.

По умолчанию, NaviKit SDK автоматически перестраивает маршрут, если водитель отклоняется от него.
Если необходимо запретить перестроение маршрута, вызовите метод [setEnableReroutes](../../../com/yandex/mapkit/navigation/automotive/Guidance.md#setenablereroutesboolean) со значением `false`. Это позволит навигатору продолжать вести по изначально загруженному маршруту, даже если пользователь съехал с него.

## Запрос альтернативных маршрутов

В ходе ведения по текущему маршруту существует возможность построить список альтернативных маршрутов. В терминологии NaviKit SDK такие маршруты называются глобальными альтернативами. Они требуют выполнения отдельного запроса.

Для этого используется асинхронный вызов [Navigation.requestAlternatives](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#requestalternatives).

Как получить результат запроса альтернатив смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## События

При помощи интерфейса [NavigationListener](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) существует возможность подписаться на сущность [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), для получения событий об изменении внутреннего состояния навигации.

### Результат запроса маршрутов

Вызовы [Navigation.requestRoutes](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#requestroutesjavautillistrequestpoint-routeoptions) и [Navigation.requestAlternatives](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#requestalternatives) являются асинхронными, так как реализованы через сетевой запрос. Для обработки результата запроса нужно подписаться на события навигации при помощи [NavigationListener](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) интерфейса.

```kotlin
val navigationListener = object : NavigationListener {
    override fun onRoutesBuilt() {
        val routes = navigation.routes
        val fastestRoute = routes[0]
        // Routes received successfully ...
    }

    override fun onRoutesRequestError(error: Error) {
        // An error occurred when requesting routes ...
    }

    // Override other listener's methods
}

// You have to subscribe to Navigation before calling the route/alternative request
navigation.addListener(navigationListener)
```

Метод-обработчик [NavigationListener.onRoutesBuilt](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesbuilt) вызывается после успешного запроса маршрутов. Результат запроса маршрутов можно получить используя метод [Navigation.getRoutes](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#getroutes), который возвращает список маршрутов, соответствующих последнему запросу. Маршруты в этом списке отсортированы по возрастанию продолжительности поездки, самый быстрый маршрут будет находиться в списке первым.

О возникновении ошибки при запросе маршрутов можно узнать, реализовав метод [NavigationListener.onRoutesRequestError](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesrequesterrorerror).

### Создание нового запроса

При помощи [NavigationListener](../../../com/yandex/mapkit/navigation/automotive/Navigation.md) можно подписаться на события создания нового запроса к [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md), в зависимости от типа запрашиваемых маршрутов.

```kotlin
val navigationListener = object : NavigationListener {
    override fun onRoutesRequested(requestPoints: List<RequestPoint>) {
        // ...
    }

    override fun onAlternativesRequested(currentRoute: DrivingRoute) {
        // ...
    }

    // Override other listener's methods
}
navigation.addListener(navigationListener)
```

- [NavigationListener.onRoutesRequested](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onroutesrequestedjavautillistrequestpoint) оповещает о создании нового запроса на построение маршрутов.
- [NavigationListener.onAlternativesRequested](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onalternativesrequesteddrivingroute) оповещает о создании нового запроса на получение альтернативных маршрутов.

### Сброс маршрутов

При помощи метода [NavigationListener.onResetRoutes](../../../com/yandex/mapkit/navigation/automotive/NavigationListener.md#onresetroutes) можно подписаться на событие сброса состояния маршрутов.

## Параметры запроса маршрутов

Существует возможность запроса маршрута с учетом дополнительных параметров, которые применяются с помощью метода [Navigation](../../../com/yandex/mapkit/navigation/automotive/Navigation.md):

- [Navigation.setAvoidanceFlags](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#setavoidanceflagsavoidanceflags) - избегание дорог с указанными свойствами (платных, в плохом состоянии и пр.).

## Грузовая навигация

NaviKit SDK способен запрашивать маршруты с учетом особенностей различных транспортных средств. Для применения параметров транспортных средств используйте вызов [Navigation.setVehicleOptions](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#setvehicleoptionsvehicleoptions).

Параметры транспортного средства передаются с помощью класса [VehicleOptions](../../../com/yandex/mapkit/directions/driving/VehicleOptions.md), в нем хранятся все данные, используемые при грузовых ограничениях. Например: габариты (высота, ширина, длина), параметры массы (фактическая, разрешенная, нагрузка на ось, грузоподъемность) и прочая информация (наличие прицепа, экологический класс и т.д.).

Пример запроса маршрутов для грузового транспортного средства с параметрами высоты 4,5 метра и общей массой 45 тонн:

```kotlin
navigation.vehicleOptions = VehicleOptions().apply {
    vehicleType = VehicleType.TRUCK,
    height = 4.5f,
    weight = 45f,
}
navigation.requestRoutes(somePoints, someDrivingOptions)
```

После запроса маршрута с использованием [VehicleOptions](../../../com/yandex/mapkit/directions/driving/VehicleOptions.md), он будет построен с учетом переданных параметров выбранного транспортного средства.
