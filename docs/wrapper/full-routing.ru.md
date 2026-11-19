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

## Режимы в MapKit 4.45.0 Full

Проверенные версии Android и iOS содержат следующие фабрики. Android возвращает результат через
интерфейсы слушателей. iOS использует обработчики с nullable-массивом маршрутов и `NSError`.
Автомобильная обёртка отделяет ошибку от успешного результата и сохраняет порядок вариантов SDK.

| Режим | Нативные фабрики и параметры | Геометрия и жизненный цикл | Реализация и проверка |
| --- | --- | --- | --- |
| Автомобиль | Android `DirectionsFactory.getInstance().createDrivingRouter(type)`, iOS `YMKDirectionsFactory.instance().createDrivingRouter(withType:)`. Упорядоченные точки, `DrivingOptions` и `VehicleOptions`. | `DrivingRoute.geometry` и позиции точек, `DrivingSession.cancel/retry`. | Реализованы запрос и геометрия. Android-тест проверяет порядок и геометрию вариантов, отсутствие маршрута, ошибку, повтор и отмену. iOS-тест проверяет значения точек и геометрии, nullable-поля и обработчик. Обе платформы проверяют завершение текущего запроса через другую обёртку. Сетевая проверка требует ключа MapKit. |
| Пешком | `Transport.createPedestrianRouter()` / `YMKTransport.createPedestrianRouter()` принимает упорядоченные точки, `TimeOptions` и `RouteOptions`. | `transport.masstransit.Route` / `YMKMasstransitRoute` предоставляют полилинию и участки. Общая сессия поддерживает отмену и повтор. | Следующий шаг. Обернуть общую сессию, маршрут и параметры транспорта, проверить порядок точек и геометрию участков, затем добавить плановый живой запрос. |
| Велосипед | `Transport.createBicycleRouterV2()` / `YMKTransport.createBicycleRouterV2()` с теми же `TimeOptions` и `RouteOptions`, что для пешего маршрута. | Те же типы маршрута и сессии, что для пешего режима. | Переиспользовать транспортные адаптеры пешего режима и отдельно проверить фабрику, обработчик результата и отображение на карте. |
| Общественный транспорт | `Transport.createMasstransitRouter()` / `YMKTransport.createMasstransitRouter()` принимает `TransitOptions` и `RouteOptions`. `TransitOptions` включает время отправления или прибытия и фильтр транспорта. | Те же типы маршрута и сессии, что для пешего режима. Участки различают поездки и пересадки. | Добавить параметры общественного транспорта. Проверить пешие и транспортные альтернативы, геометрию и отмену. Запустить детерминированные тесты и доверенный живой запрос. |

Автомобильная обёртка предоставляет идентификаторы маршрутов, полилинии, позиции точек и параметры
исходной последовательности точек. Метаданные маршрута, ограничения транспорта в ответе, сводные
запросы, сопоставление внешнего маршрута и подписки на дорожную обстановку остаются отдельными
сценариями. Следующие шаги для пеших, велосипедных и транспортных маршрутов описаны в
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
`RequestPoint` и `Polyline` вызывают JNI. Обе версии теста создают обёртки до первого запроса
и до `retry`, затем отменяют текущий запрос через более раннюю обёртку и проверяют события,
которые нативный обработчик доставляет во время и после отмены.

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
