# Маршрутизация Full

Автомобильный маршрутизатор входит в редакцию Full. Используйте кандидатные координаты
`ru.sulgik.mapkit:yandex-mapkit-kmp-full` и `yandex-mapkit-kmp-compose-full`, а для iOS
`YandexMapsMobile` {{ mapkit_version_full }}.
[Проверочное приложение Full](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/verification/lite-consumer)
описывает изолированный репозиторий кандидата и проверки зависимостей.

## Автомобильный маршрут

Инициализируйте MapKit и запустите его жизненный цикл до создания маршрутизатора. Вызывайте
методы маршрутизатора и сессии в UI-потоке.

```kotlin
val router = Directions.getInstance().createDrivingRouter(DrivingRouterType.ONLINE)
val points = listOf(
    RequestPoint(Point(55.75, 37.62), RequestPointType.WAYPOINT),
    RequestPoint(Point(55.76, 37.61), RequestPointType.VIAPOINT),
    RequestPoint(Point(55.77, 37.60), RequestPointType.WAYPOINT),
)
val session = router.requestRoutes(
    points = points,
    drivingOptions = DrivingOptions(
        routesCount = 2,
        avoidanceFlags = AvoidanceFlags(avoidTolls = true),
    ),
    vehicleOptions = VehicleOptions(),
    routeListener = DrivingRouteListener(
        onDrivingRoutes = { alternatives -> showRoutes(alternatives) },
        onDrivingRoutesError = { failure -> showFailure(failure) },
    ),
)
```

Храните сессию в экране или контроллере, которому принадлежит запрос. Отменяйте эту обёртку
перед заменой запроса или при уходе с экрана. `retry` меняет слушателя запроса и сохраняет нативную
сессию. Обёртки одного нативного объекта делят текущее состояние. Отмена или повтор через
любую из них отключает прежний обработчик, даже если обёртка создана до нового запроса. Успешный
ответ SDK может содержать пустой список. Ошибка сохраняет нативное представление и предоставляет
типизированную ошибку MapKit, если она доступна.

В проверочном приложении есть
[пример контроллера](https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullDrivingExample.kt).
Передайте ему `mapObjects` действующей карты. `replaceRoute` отменяет предыдущий запрос, рисует
первый вариант в отдельной коллекции и передаёт все варианты в callback. `clear` отменяет запрос
и удаляет линии. Вызывайте `dispose` перед уходом с экрана. Сборка приложения проверяет вызовы
публичного API из примера. Для живого запроса маршрута нужен действующий ключ MapKit.

## Пеший маршрут

Создайте маршрутизатор через `Transport.getInstance().createPedestrianRouter()`.
Передайте упорядоченные `RequestPoint`, `TimeOptions` и `RouteOptions`. Для
запроса по времени задайте либо отправление, либо прибытие. Время на Android
хранится в миллисекундах UTC, на iOS преобразуется в `NSDate`. В `FitnessOptions` можно
попросить маршрутизатор избегать лестниц и крутых участков.

[Пример управления пешим маршрутом][transport-example] использует тот же принцип, что и
автомобильный. Храните `Session`, отменяйте устаревший запрос и рисуйте `route.geometry` в
собственной коллекции. `Route.metadata` сохраняет порядок точек, расстояние, время и количество
пересадок. `routeId`, `settings`, `flags` и `estimation` содержат данные только тогда, когда
их вернул SDK. `Section.geometry` описывает фрагмент общей линии. Тип поездки, ожидания или
перехода определяется полями `Section.metadata.data`. Дополнительные платёжные поля и
контуры доступны через нативные объекты.

## Велосипедный маршрут

Используйте `Transport.getInstance().createBicycleRouterV2()`. Он принимает те же упорядоченные
точки и параметры времени и маршрута, что пеший режим. В `Section.metadata.data.fitness`
велосипедный участок сохраняет `FitnessType.BICYCLE` и позиции точек проезда.
`replaceCyclingRoute` в [примере транспорта][transport-example] строит и рисует этот маршрут,
отменяет предыдущий запрос и очищает свою коллекцию.

## Общественный транспорт

Создайте маршрутизатор через `Transport.getInstance().createMasstransitRouter()`. Передайте
точки, `TransitOptions` и `RouteOptions`. В `TransitOptions.avoid` объединяйте значения
`FilterVehicleTypes` с помощью `or`. Для маршрута, зависящего от времени, задайте отправление
или прибытие через `TimeOptions`.

`Section.metadata.data.transports` содержит линии для поездки. `Section.stops` перечисляет
остановки от посадки до выхода. `Section.rideLegs` возвращает фрагменты полилинии между
остановками. Данные входа, выхода, оценка времени и идентификатор маршрута остаются
nullable, когда их не вернул SDK. `replaceTransitRoute` в [примере транспорта][transport-example]
отменяет старую сессию, рисует выбранный маршрут и позволяет очистить выделенную коллекцию.

## Режимы в MapKit 4.45.0 Full

Проверенные версии Android и iOS содержат следующие фабрики. Android возвращает результат через
интерфейсы слушателей. iOS использует обработчики с nullable-массивом маршрутов и `NSError`.
Обёртки отделяют ошибку от успешного результата и сохраняют порядок вариантов SDK.

| Режим | Нативные фабрики и параметры | Геометрия и жизненный цикл | Реализация и проверка |
| --- | --- | --- | --- |
| Автомобиль | Android `DirectionsFactory.getInstance().createDrivingRouter(type)`, iOS `YMKDirectionsFactory.instance().createDrivingRouter(withType:)`. Упорядоченные точки, `DrivingOptions` и `VehicleOptions`. | `DrivingRoute.geometry` и позиции точек, `DrivingSession.cancel/retry`. | Реализованы запрос и геометрия. Android-тест проверяет порядок и геометрию вариантов, отсутствие маршрута, ошибку, повтор и отмену. iOS проверяет нативные значения точек и геометрии, пустой ответ и обработку ошибок. Общая логика отмены на iOS проверяется через тестовый объект. Сетевая проверка требует ключа MapKit. |
| Пешком | `Transport.createPedestrianRouter()` / `YMKTransport.createPedestrianRouter()` принимает упорядоченные точки, `TimeOptions` и `RouteOptions`. | `transport.masstransit.Route` / `YMKMasstransitRoute` предоставляют полилинию и участки. Общая сессия поддерживает отмену и повтор. | Запрос и общая обёртка транспорта добавлены. Android проверяет порядок точек и вариантов, геометрию и сессию. iOS проверяет метаданные, nullable-поля и обработчик. CI и живой запрос ещё впереди. |
| Велосипед | `Transport.createBicycleRouterV2()` / `YMKTransport.createBicycleRouterV2()` с теми же `TimeOptions` и `RouteOptions`, что для пешего маршрута. | Те же типы маршрута и сессии, что для пешего режима. | Фабрика и запрос добавлены. Android проверяет точки проезда, параметры, геометрию и отмену. iOS проверяет тип и точки проезда в участке. Прогоны CI и живого запроса впереди. |
| Общественный транспорт | `Transport.createMasstransitRouter()` / `YMKTransport.createMasstransitRouter()` принимает `TransitOptions` и `RouteOptions`. `TransitOptions` включает время отправления или прибытия и фильтр транспорта. | Те же типы маршрута и сессии, что для пешего режима. Участки различают поездки и пересадки. | Фабрика и запрос добавлены. Android проверяет нативные маски, пешую и транспортную альтернативы, геометрию и отмену. iOS проверяет маску, линии, порядок остановок и nullable-входы. Прогоны CI и живого запроса впереди. |

Автомобильная обёртка предоставляет идентификаторы маршрутов, полилинии, позиции точек и параметры
исходной последовательности точек. Метаданные маршрута, ограничения транспорта в ответе, сводные
запросы, сопоставление внешнего маршрута и подписки на дорожную обстановку остаются отдельными
сценариями. В транспортной обёртке расширенные платёжные данные, нити маршрутов и
детализация конструкций остаются доступны через нативные объекты. Прогоны платформ,
снимки ABI Full и плановые живые запросы отслеживаются в
[#80](https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/80).

## Проверки регрессий

В GitHub Actions с уже подключённым Android-эмулятором и загруженным симулятором iOS
запустите обе платформенные проверки и отдельное приложение Full.

```bash
./gradlew -PmapkitEdition=full -PskipIosTarget=true :yandex-mapkit-kmp:connectedAndroidDeviceTest
./gradlew -PmapkitEdition=full :yandex-mapkit-kmp:iosSimulatorArm64Test
bash verification/lite-consumer/run.sh android "$ANDROID_SERIAL" with-integrations full
bash verification/lite-consumer/run.sh ios "$IOS_DEVICE_UDID" with-integrations full
```

Первые две команды включают [DrivingAdapterTest · Android][android-adapter] и
[DrivingAdapterTest · iOS][ios-adapter]. Android выполняет их на устройстве, потому что
`RequestPoint` и `Polyline` вызывают JNI. Android вызывает нативный адаптер с двумя маршрутами и проверяет порядок, геометрию и отмену.
iOS использует настоящие значения точек и полилиний, а для проверки общей логики отмены
сессии передаёт тестовый `NSObject` в тот же реестр. SDK создаёт объекты маршрута и
сессии через маршрутизатор. Проверка ответа iOS с непустым списком альтернатив ждёт
сетевого запуска с ключом.

До `MAP_READY` отдельное приложение Full создаёт, заменяет и очищает нативные полилинии
на карте. В установленном приложении нажмите **Draw route**, **Replace route** и
**Clear route**. Синяя линия должна появиться, смениться другой и исчезнуть. Превью
использует тот же код отрисовки, что и пример с реальным запросом. Для сетевой проверки
автомобильного маршрута и замены запроса до получения ответа нужен тестовый ключ MapKit.

При расхождении ABI [Full CI][full-workflow] сохраняет фактические Android и iOS dump-файлы.
Обновляйте проверенные снимки в `api/full` и запускайте обе проверки ещё раз, сохраняя
обязательные проверки ABI активными.

[Документация Android](https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_routing.html) ·
[Документация iOS](https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_routing.html)

[android-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidDeviceTest/kotlin/ru/sulgik/mapkit/directions/driving/DrivingAdapterTest.kt
[ios-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/directions/driving/DrivingAdapterTest.kt
[full-workflow]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/workflows/full-consumer.yml
[transport-example]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullTransportExample.kt
