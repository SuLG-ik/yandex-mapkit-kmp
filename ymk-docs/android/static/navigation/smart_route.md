---
title: "Построение маршрута с учетом запаса батареи или топлива"
kind: "Guide"
platform: "android"
language: "Kotlin/Java"
section: "Android / NaviKit SDK / Маршрут с учетом запаса хода"
source: "https://yandex.ru/maps-api/docs/mapkit/android/static/navigation/smart_route.html"
---
# Построение маршрута с учетом запаса батареи или топлива

`ANDROID` · `Kotlin/Java` · `Guide` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/android/static/navigation/smart_route.html)

В [демоприложении](https://github.com/yandex/mapkit-android-demo) реализована возможность планирования маршрута c автоматическим добавлением зарядных станций и АЗС, чтобы заряда батареи и топлива хватило на весь маршрут. Для этого учитываются:

- расстояниe, которое может проехать автомобиль на текущем уровне заряда батареи или остатка топлива;
- максимальный запас хода при полной заряде батареи или баке;
- минимальный запас хода, который всегда должен быть доступен;
- тип коннектора, который поддерживает автомобиль, либо тип топлива.

> [!WARNING] Важно
> Допускается, что маршруты могут быть не оптимальными.
> Для построения более оптимального маршрута рекомендуем в [DrivingOptions](../../../com/yandex/mapkit/directions/driving/DrivingOptions.md) не передавать `avoidanceFlags`.

## Описание алгоритма

Конкретные описания классов и их реализацию можно найти в [демоприложении](https://github.com/yandex/mapkit-android-demo).
Возможность построения маршрута с учетом запаса батареи или топлива реализована не в рамках NaviKit SDK, а предоставляется как вариант использования Navikit SDK. Вы можете копировать и изменять алгоритм для реализации вашей бизнес-логики.

### Входные параметры

Описание структуры `SmartRouteOptions`.

```kotlin
data class SmartRouteOptions(
    val chargingType: ChargingType,
    val fuelConnectorTypes: Set<FuelConnectorType>,
    val maxTravelDistanceInMeters: Double,
    val currentRangeLvlInMeters: Double,
    val thresholdDistanceInMeters: Double,
    val drivingOptions: DrivingOptions,
    val vehicleOptions: VehicleOptions,
)
```

- `chargingType` - тип двигателя `ELECTRO` или `GASOLINE`;
- `fuelConnectorTypes` - тип конекторов, полный список поддерживаемых коннекторов и типов топлива можно найти в файле `FuelConnectorType.kt` демоприложения;
- `maxTravelDistanceInMeters` - максимальное количество метров, которое может проехать автомобиль при полном заряде;
- `currentRangeLvlInMeters` - максимальное количество метров, которое может проехать автомобиль при текущем заряде;
- `thresholdDistanceInMeters` - пороговое значения кол-ва метров, ниже которого заряд не должен опускаться;
- `drivingOptions` - объект [DrivingOptions](../../../com/yandex/mapkit/directions/driving/DrivingOptions.md) для учета платных, грунтовых, плохих и других дорог;
- `vehicleOptions` - объект [VehicleOptions](../../../com/yandex/mapkit/directions/driving/VehicleOptions.md) для учета параметров автомобиля.

### Выходные параметры

Описание структуры `SmartRouteResult`.

```kotlin
sealed class SmartRouteResult {
    data class Success(
        val points: List<SmartRoutePoint>,
        val finishRangeLvlInMeters: Double
    ) : SmartRouteResult()

    data class Error(
        val reason: String,
        val error: Exception? = null
    ) : SmartRouteResult()
}

sealed class SmartRoutePoint {
    abstract val point: RequestPoint
    data class ChargingPoint(override val point: RequestPoint, val geoObject: GeoObject) : SmartRoutePoint()
    data class RegularPoint(override val point: RequestPoint) : SmartRoutePoint()
}
```

При успешном построении маршрута будет получен код `SmartRouteResult.Success` и следующие данные:

- `points` - список объектов `SmartRoutePoint`, одного из двух типов:

  - точки для зарядки аккомулятора или заправки `SmartRoutePoint.ChargingPoint`. В нем содержится  [GeoObject](../../../com/yandex/mapkit/GeoObject.md), с информацей о зарядных станция / АЗС;
  - пользовательские промежуточные точки, которые были переданы в алгоритм на вход `SmartRoutePoint.RegularPoint`.
- `finishRangeLvlInMeters` - количество метров, которое машина сможет еще проехать в момент приезда в точку назначения.

В случае если маршрут не смог быть построен, будет передан код `SmartRouteResult.Error`.

### Алгоритм построения маршрута

Для построения маршрута с автоматическим добавлением зарядных станций и АЗС выполняется следующая последовательность:

1. Создается объект `SmartRouteOptions` и `SmartRoutePlanningFactory`.
2. Вызывается `SmartRoutePlanningFactory.requestRoutes` c нужным списком промежуточных точек `points`.
3. Обрабатывается ответ от алгоритма. Ответ будет содержать список пользовательских промежуточных точек, а так же точек для зарядки / заправки автомобиля.
4. Происходит построение маршрута с помощью [Navigation.requestRoutes](../../../com/yandex/mapkit/navigation/automotive/Navigation.md#requestroutesjavautillistrequestpoint-routeoptions) по точкам из ответа алгоритма.

```kotlin
val smartRouteOptions = SmartRouteOptions(...)
val smartRoutePlannigFactory = SmartRoutePlanningFactoryImpl(...)
val result = smartRoutePlannigFactory.requestRoutes(
    points,
    smartRouteOptions
)
// Handle result
```

### Алгоритм поиска промежуточных точек для маршрута

1. Строится маршрут через [DrivingRouter](../../../com/yandex/mapkit/directions/driving/DrivingRouter.md) c указанием начальной и конечной точки, а так же промежуточных точек.
2. С учетом входных параметров (текущего запаса хода, максимального запаса хода и т.д.) находится отрезок маршрута, до которого хватит запаса хода автомобиля.
3. С помощью [SearchManager](../../../com/yandex/mapkit/search/SearchManager.md) выполняется поиск зарядной / заправочной станции, которая ближе всех расположена к концу найденного отрезка.
4. Выполняется сохранение найденной зарядной / заправочной станции. Алгоритм устанавливает местоположение машины как проекцию точки зарядки на полилинию маршрута.
5. Алгоритм повторяется с шага 2 и останавливается когда запаса хода хватает для проезда всего маршрута.
