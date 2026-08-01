# Геолокация

`MapKit` отдаёт три вида источника местоположения и один слой карты, который рисует результат.

| | Что это |
|---|---|
| `createLocationManager()` | собственное позиционирование устройства |
| `createLocationSimulator(polyline)` | проигрывает маршрут |
| `createDummyLocationManager()` | позиции, которые задаёт ваш код |
| `createUserLocationLayer(mapWindow)` | стрелка, пин и круг точности на карте |

!!! warning "Разрешения запрашиваете вы"
    Обёртка не запрашивает разрешения на геолокацию — сделайте это платформенным способом до
    подписки, иначе менеджер сообщит `LocationStatus.NOT_AVAILABLE`.

## Подписка на позиции

```kotlin
class LocationController(private val mapKit: MapKit) {

    private val locationManager = mapKit.createLocationManager()

    private val locationListener = LocationListener(
        onLocationUpdated = { location -> show(location.position) },
        onLocationStatusUpdated = { status ->
            if (status == LocationStatus.NOT_AVAILABLE) showUnavailable()
        },
    )

    fun start() {
        locationManager.subscribeForLocationUpdates(
            subscriptionSettings = SubscriptionSettings(
                useInBackground = UseInBackground.DISALLOW,
                purpose = LocationPurpose.GENERAL,
            ),
            locationListener = locationListener.asWeakRef(),
        )
    }

    fun stop() {
        locationManager.unsubscribe(locationListener.asWeakRef())
    }
}
```

`purpose` сообщает MapKit, для чего нужна позиция — `GENERAL`, `AUTOMOTIVE_NAVIGATION`,
`PEDESTRIAN_NAVIGATION`, `BICYCLE_NAVIGATION`, `SCOOTER_NAVIGATION`, `STATIC_DISPLAY_LOCATION`, — а
`useInBackground` определяет, можно ли продолжать работу, когда приложение в фоне.

Одна позиция вместо потока:

```kotlin
locationManager.requestSingleUpdate(locationListener.asWeakRef())
```

`suspend()` и `resume()` приостанавливают и продолжают подписки, не снимая их.

### Что несёт позиция

```kotlin
data class Location(
    val position: Point,
    val accuracy: Double?,
    val altitude: Double?,
    val altitudeAccuracy: Double?,
    val heading: Double?,
    val speed: Double?,
    val indoorLevelId: String?,
    val absoluteTimestamp: Instant,
    val relativeTimestamp: Duration,
)
```

Всё, чего MapKit может не знать, — nullable. `absoluteTimestamp` — календарное время,
`relativeTimestamp` — монотонное время с момента загрузки устройства, именно по нему сравнивают
позиции.

Последняя позиция, которую получил MapKit, без всякой подписки:

```kotlin
val last: Location? = lastKnownLocation()
```

## Рисование пользователя на карте

```kotlin
class UserLocationController(mapKit: MapKit, mapWindow: MapWindow) {

    private val layer = mapKit.createUserLocationLayer(mapWindow)

    private val tapListener = UserLocationTapListener { point -> openDetails(point) }

    private val objectListener = UserLocationObjectListener(
        onObjectAdded = { view ->
            view.pin.setIcon(pinImage)
            view.arrow.setIcon(arrowImage)
            view.accuracyCircle.fillColor = Color.fromArgb(0x334CAF50)
        },
        onObjectRemoved = { },
        onObjectUpdated = { _, _ -> },
    )

    init {
        layer.isVisible = true
        layer.isHeadingModeActive = true
        layer.setTapListener(tapListener.asWeakRef())
        layer.setObjectListener(objectListener.asWeakRef())
    }
}
```

`UserLocationView` — это три объекта карты: `arrow`, `pin` и `accuracyCircle`, — поэтому к ним
применимо всё со страницы [Объекты карты](mapobjects.md). `onObjectAdded` — место, где их
стилизуют; MapKit создаёт их лениво, после первой позиции.

### Якорь

Режим якоря удерживает маркер пользователя в фиксированной точке экрана и двигает карту под ним —
так выглядит навигация. Задаются два якоря: один для обычного состояния, второй — когда карта
следует за курсом.

```kotlin
layer.setAnchor(
    anchorNormal = PointF(width * 0.5f, height * 0.5f),
    anchorCourse = PointF(width * 0.5f, height * 0.75f),
)
layer.isAutoZoomEnabled = true
```

`resetAnchor()` выходит из режима; `isAnchorEnabled` говорит, включён ли он. Любое движение камеры
пользователем его выключает, так что взводите заново, когда он снова нужен.

`layer.cameraPosition` — позиция, в которую слой сдвинул бы камеру, или `null`, пока позиции нет.

### Другой источник для слоя

```kotlin
layer.setSource(simulator.asLocationManager().toLocationViewSource())
layer.setDefaultSource()
```

## Симуляция маршрута

Симулятор проигрывает `Polyline` — для демо, для скриншотов и для тестов, которые не должны зависеть
от того, где находится устройство.

```kotlin
val route = Polyline(routePoints)
val simulator = mapKit.createLocationSimulator(route)

val settings = listOf(
    SimulationSettings(
        geometry = route,
        locationSettings = LocationSettings(
            provideSpeed = true,
            speed = 20.0,
            provideAccuracy = true,
            accuracy = Range(from = 3.0, to = 5.0),
        ),
    ),
)

simulator.asLocationManager().resume()
simulator.startSimulation(settings)
```

!!! danger "Симулятор создаётся приостановленным"
    MapKit наследует `LocationSimulator` от `LocationManager`, и `startSimulation` его **не**
    возобновляет. Без `asLocationManager().resume()` симуляция идёт, `isActive` остаётся `false`, и
    до подписчиков ничего не доходит.

`asLocationManager()` — это то, что открывает `subscribeForLocationUpdates`, `requestSingleUpdate`,
`unsubscribe`, `suspend` и `resume`: Kotlin не может выразить наследование MapKit сразу на двух
платформах, поэтому связь записана как преобразование. Результат — обычный `LocationManager`, так
что его можно передать и в `MapKit.setLocationManager()`, и в `toLocationViewSource()`.

```kotlin
private val simulatorListener = LocationSimulatorListener { println("route finished") }

simulator.subscribeForSimulatorEvents(simulatorListener.asWeakRef())

val progress = simulator.polylinePosition()

simulator.stopSimulation()
```

`polylinePosition()` — то, где на маршруте сейчас находится симуляция.

!!! info "`speed` у симулятора устарел"
    MapKit перенёс это поле в `LocationSettings`. `startSimulation` целиком заменяет `settings`,
    поэтому значение, присвоенное `simulator.speed` заранее, будет затёрто; задавайте
    `LocationSettings.speed` вместе с `provideSpeed = true` в каждом `SimulationSettings`.

### Что задаёт `LocationSettings`

Каждый флаг `provideX` решает, будет ли поле сообщаться вообще, а соседнее значение — что именно
сообщать:

```kotlin
LocationSettings(
    provideAccuracy = true,
    accuracy = Range(from = 3.0, to = 5.0),
    provideSpeed = true,
    speed = 20.0,
    provideHeading = true,
    headingError = Range(from = 0.0, to = 2.0),
    locationTimeInterval = TimeInterval(from = 1.seconds, to = 2.seconds),
)
```

`LocationSettings.fineSettings()` и `LocationSettings.coarseSettings()` — готовые наборы от MapKit.

## Задание позиций вручную

`DummyLocationManager` сообщает ровно то, что вы ему дали — полезно в тестах и для проигрывания
записанного трека в своём темпе.

```kotlin
val dummy = mapKit.createDummyLocationManager()

dummy.asLocationManager().subscribeForLocationUpdates(
    subscriptionSettings = SubscriptionSettings(UseInBackground.DISALLOW, LocationPurpose.GENERAL),
    locationListener = locationListener.asWeakRef(),
)

dummy.setLocation(
    location = Location(
        position = Point(55.751225, 37.629540),
        accuracy = 5.0,
        altitude = null,
        altitudeAccuracy = null,
        heading = 0.0,
        speed = 0.0,
        indoorLevelId = null,
        absoluteTimestamp = Clock.System.now(),
        relativeTimestamp = 0.seconds,
    ),
    quality = DummyLocationQuality.HIGH,
)
```

Как и у симулятора, подписочные члены открывает `asLocationManager()`.

## Подмена глобального менеджера

`MapKit.setLocationManager()` заставляет все части MapKit — включая `UserLocationLayer` —
пользоваться вашим источником вместо устройства:

```kotlin
mapKit.setLocationManager(simulator.asLocationManager())

mapKit.resetLocationManagerToDefault()
```

## В Compose

У `YandexMap` есть перегрузка, которая сама владеет слоем, так что создавать ничего не нужно:

```kotlin
@Composable
fun MapScreen() {
    val locationState = rememberUserLocationState()
    YandexMap(
        locationState = locationState,
        locationConfig = UserLocationConfig(
            isVisible = true,
            isHeadingEnabled = true,
            isAutoZoomEnabled = true,
            pin = UserLocationConfig.LocationIcon(image = pinImage),
            arrow = UserLocationConfig.LocationIcon(image = arrowImage),
            accuracy = UserLocationConfig.LocationAccuracy(
                fillColor = Color(0x334CAF50),
            ),
        ),
        modifier = Modifier.fillMaxSize(),
    )
}
```

`locationState.cameraPosition` следует за `UserLocationLayer.cameraPosition`.
