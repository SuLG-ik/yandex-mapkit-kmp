---
title: "Построение маршрутов"
kind: "Guide"
platform: "ios"
language: "Swift/Objective-C"
section: "iOS / NaviKit SDK / Построение маршрутов"
source: "https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/routes_building.html"
---
# Построение маршрутов

`IOS` · `Swift/Objective-C` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/ios/generated/navigation/routes_building.html)

Входной точкой в API NaviKit SDK является класс [YMKNavigation](../../../Swift/YMKNavigation.md). В нем содержится основной функционал, связанный с навигацией и построением маршрутов.

## Создание Navigation

Для создания нового экземпляра навигации используется вызов [YMKNavigationFactory.createNavigation(with:)](../../../Swift/YMKNavigationFactory.md#createnavigationwith).

```swift
let navigation = YMKNavigationFactory.createNavigation(with: .combined)
```

## Запрос маршрутов

[YMKNavigation](../../../Swift/YMKNavigation.md) предоставляет возможность строить оптимальные [маршруты](../tutorials/map_routes.md) с помощью промежуточных точек маршрута.

Для запроса маршрутов используется метод [YMKNavigation.requestRoutes(with:initialAzimuth:)](../../../Swift/YMKNavigation.md#requestrouteswithrouteoptions).

```swift
// Coordinates routes are requested for
let requestPoints = [
    YMKRequestPoint(
        point: YMKPoint(latitude: 25.190614, longitude: 55.265616),
        type: .waypoint,
        pointContext: nil,
        drivingArrivalPointId: nil
    ),
    YMKRequestPoint(
        point: YMKPoint(latitude: 25.187532, longitude: 55.275413),
        type: .waypoint,
        pointContext: nil,
        drivingArrivalPointId: nil
    ),
    YMKRequestPoint(
        point: YMKPoint(latitude: 25.189279, longitude: 55.282246),
        type: .waypoint,
        pointContext: nil,
        drivingArrivalPointId: nil
    ),
    YMKRequestPoint(
        point: YMKPoint(latitude: 25.196605, longitude: 55.280940),
        type: .waypoint,
        pointContext: nil,
        drivingArrivalPointId: nil
    )
]

navigation.requestRoutes(
    with: requestPoints,
    initialAzimuth: navigation.guidance.location?.heading
)
```

Первым аргументом передается список координат [YMKRequestPoint](../../../Swift/YMKRequestPoint.md), через которые будет проходить маршрут.

Точки маршрута делятся на два типа:

- [waypoint](../../../Swift/YMKRequestPointType.md#waypoint) - используются для точек назначения. Например, для точек откуда, куда и точек остановок.
- [viapoint](../../../Swift/YMKRequestPointType.md#viapoint) - используются для корректировки траектории маршрута. Маршрут будет проходить через все via-точки.

Вторым аргументом передается объект [YMKDrivingOptions](../../../Swift/YMKDrivingOptions.md) с параметрами ведения:

- `initialAzimuth` - задает азимут направления пользователя в исходной точке маршрута.
- `routesCount` - количество маршрутов для построения.

> [!NOTE] Примечание
> Количество одновременных запросов маршрутов через [YMKNavigation](../../../Swift/YMKNavigation.md) ограничено, активный запрос может быть только один. Если создать новый запрос до того, как предыдущий выполнится, то предыдущий будет отменен.

Как получить результат запроса маршрутов смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Запрос маршрута по uri

[YMKNavigation](../../../Swift/YMKNavigation.md) предоставляет возможность запрашивать маршрут по заранее сохраненному [URI маршрута](../tutorials/map_routes.md#uri), при помощи метода [YMKNavigation.resolveUri(withUri:)](../../../Swift/YMKNavigation.md#resolveuriwithuri).

Получение результатов запроса рассмотрено в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## Построение заранее рассчитанного маршрута

Если у вас уже есть заранее рассчитанный маршрут для автомобиля, вы можете использовать его в NaviKit SDK для навигации. Для этого используется метод [matchRoute](../../../Swift/YMKNavigation.md#matchroutewith), в который передается маршрут в формате полилинии.

NaviKit SDK построит маршрут по заданным координатам и автоматически скорректирует его, если точки маршрута попадают на пешеходные зоны, здания или другие недоступные участки.

Метод [matchRoute](../../../Swift/YMKNavigation.md#matchroutewith) поддерживает полилинии, содержащие не более 2000 точек.

По умолчанию, NaviKit SDK автоматически перестраивает маршрут, если водитель отклоняется от него.
Если необходимо запретить перестроение маршрута, вызовите метод [setEnableReroutes](../../../Swift/YMKGuidance.md#isenablealternatives) со значением `false`. Это позволит навигатору продолжать вести по изначально загруженному маршруту, даже если пользователь съехал с него.

## Запрос альтернативных маршрутов

В ходе ведения по текущему маршруту существует возможность построить список альтернативных маршрутов. В терминологии NaviKit SDK такие маршруты называются глобальными альтернативами. Они требуют выполнения отдельного запроса.

Для этого используется асинхронный вызов [YMKNavigation.requestAlternatives()](../../../Swift/YMKNavigation.md#requestalternatives).

Как получить результат запроса альтернатив смотрите в разделе [Результат запроса маршрутов](routes_building.md#events-request-result).

## События

При помощи интерфейса [YMKNavigationListener](../../../Swift/YMKNavigationListener.md) существует возможность подписаться на сущность [YMKNavigation](../../../Swift/YMKNavigation.md), для получения событий об изменении внутреннего состояния навигации.

### Результат запроса маршрутов

Вызовы [YMKNavigation.requestRoutes(with:initialAzimuth:)](../../../Swift/YMKNavigation.md#requestrouteswithrouteoptions) и [YMKNavigation.requestAlternatives()](../../../Swift/YMKNavigation.md#requestalternatives) являются асинхронными, так как реализованы через сетевой запрос. Для обработки результата запроса нужно подписаться на события навигации при помощи [YMKNavigationListener](../../../Swift/YMKNavigationListener.md) интерфейса.

```swift
class NavigationListener: NSObject, YMKNavigationListener {
    func onRoutesBuilt() {
        let routes = navigation.routes
        let fastestRoute = routes[0]
        // Routes received successfully ...
    }

    func onRoutesRequestErrorWithError(_ error: Error) {
        // An error occurred when requesting routes ...
    }

    // Override other listener's methods
}

// You have to subscribe to Navigation before calling the route/alternative request
navigation.addListener(navigationListener)
```

Метод-обработчик [YMKNavigationListener.onRoutesBuilt()](../../../Swift/YMKNavigationListener.md#onroutesbuilt) вызывается после успешного запроса маршрутов. Результат запроса маршрутов можно получить используя метод [YMKNavigation.routes](../../../Swift/YMKNavigation.md#routes), который возвращает список маршрутов, соответствующих последнему запросу. Маршруты в этом списке отсортированы по возрастанию продолжительности поездки, самый быстрый маршрут будет находиться в списке первым.

О возникновении ошибки при запросе маршрутов можно узнать, реализовав метод [YMKNavigationListener.onRoutesRequestErrorWithError(_:)](../../../Swift/YMKNavigationListener.md#onroutesrequesterrorwitherror_).

### Создание нового запроса

При помощи [YMKNavigationListener](../../../Swift/YMKNavigationListener.md) можно подписаться на события создания нового запроса к [YMKNavigation](../../../Swift/YMKNavigation.md), в зависимости от типа запрашиваемых маршрутов.

```swift
class NavigationListener: NSObject, YMKNavigationListener {
    func onRoutesRequested(with points: [YMKRequestPoint]) {
        // ...
    }

    func onAlternativesRequested(withCurrentRoute currentRoute: YMKDrivingRoute) {
        // ...
    }

    // Override other listener's methods
}

navigation.addListener(navigationListener)
```

- [YMKNavigationListener.onRoutesRequested(with:)](../../../Swift/YMKNavigationListener.md#onroutesrequestedwith) оповещает о создании нового запроса на построение маршрутов.
- [YMKNavigationListener.onAlternativesRequested(withCurrentRoute:)](../../../Swift/YMKNavigationListener.md#onalternativesrequestedwithcurrentroute) оповещает о создании нового запроса на получение альтернативных маршрутов.

### Сброс маршрутов

При помощи метода [YMKNavigationListener.onResetRoutes()](../../../Swift/YMKNavigationListener.md#onresetroutes) можно подписаться на событие сброса состояния маршрутов.

## Параметры запроса маршрутов

Существует возможность запроса маршрута с учетом дополнительных параметров, которые применяются с помощью метода [YMKNavigation](../../../Swift/YMKNavigation.md):

- [YMKNavigation.avoidanceFlags](../../../Swift/YMKNavigation.md#avoidanceflags) - избегание дорог с указанными свойствами (платных, в плохом состоянии и пр.).

## Грузовая навигация

NaviKit SDK способен запрашивать маршруты с учетом особенностей различных транспортных средств. Для применения параметров транспортных средств используйте вызов [YMKNavigation.vehicleOptions](../../../Swift/YMKNavigation.md#vehicleoptions).

Параметры транспортного средства передаются с помощью класса [YMKDrivingVehicleOptions](../../../Swift/YMKDrivingVehicleOptions.md), в нем хранятся все данные, используемые при грузовых ограничениях. Например: габариты (высота, ширина, длина), параметры массы (фактическая, разрешенная, нагрузка на ось, грузоподъемность) и прочая информация (наличие прицепа, экологический класс и т.д.).

Пример запроса маршрутов для грузового транспортного средства с параметрами высоты 4,5 метра и общей массой 45 тонн:

```swift
navigation.vehicleOptions = {
    let options = YMKDrivingVehicleOptions()
    options.vehicleType = .truck
    options.height = 4.5,
    options.weight = 45
}()
navigation.requestRoutes(with: somePoints, initialAzimuth: nil)
```

После запроса маршрута с использованием [YMKDrivingVehicleOptions](../../../Swift/YMKDrivingVehicleOptions.md), он будет построен с учетом переданных параметров выбранного транспортного средства.
