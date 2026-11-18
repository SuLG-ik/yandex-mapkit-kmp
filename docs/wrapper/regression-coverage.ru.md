# Покрытие регрессионными тестами

Список составлен по [дампам публичного ABI][abi] и исходникам тестов на коммите [`c6049906`][snapshot].
В таблицах указано проверенное поведение. Доступные API и ограничения платформ описаны на странице
[«Что обёрнуто»](coverage.md).

| Платформа | Задача и команда CI |
| --- | --- |
| **Android JVM** | [Tests (Android)][android-host] запускает `libraryAssemble libraryTests -PskipIosTarget=true`, включая JVM-тесты конвертеров и Compose. |
| **Эмулятор Android** | [Tests (Android emulator)][android-device] запускает `connectedAndroidDeviceTest` ядра и Compose на API 30. |
| **Симулятор iOS** | [Tests (iOS)][ios] запускает `libraryIosTests` на симуляторе arm64. Та же задача компилирует код для устройства iOS и линкует его Objective-C-фреймворки. |
| **Публичный ABI** | [Public API][api] запускает `libraryApiCheck` по дампам Android и Kotlin всех пяти публикуемых модулей. |

## Ядро обёртки

| Публичный API | Проверенное поведение, тесты и платформы | Оставшиеся сценарии |
| --- | --- | --- |
| [`MapKit`, `MapView` и `MapWindow`](map.md) | Нативное окно отдаёт размеры, фокус, масштаб и проекцию. В [LiveMapWindowTest · Android][a-window] и на [LiveMapWindowTest · iOS][i-window] проверено преобразование между экранными и географическими координатами в обе стороны. [NativeYandexMapLifecycleTest · Закрытие Android Activity][a-lifecycle] проверяет нативное представление через Compose. | Жизненный цикл MapKit при пересоздании экрана и повторном запуске и остановке [#70][70]. Несколько карт и расположение оверлеев [#83][83]. |
| [`Map.move`, `CameraPosition`, параметры жестов и `CameraListener`](map.md) | [LiveMapTest · Android][a-map] и [LiveMapTest · iOS][i-map] проверяют изменение позиции после программного перемещения и соответствие флагов жестов. [LiveCameraListenerDeliveryTest · Тест iOS][i-camera] наблюдает вызов слушателя после перемещения. | Доставка событий камеры на Android, жесты, прерывание анимации и жизненный цикл камеры в Compose [#69][69]. |
| [`InputListener`, `GeoObjectTapListener`, `MapLoadedListener` и метаданные карты](geoobjects.md) | Подписка, отписка или очистка слушателей в [Android][a-map] и на [iOS][i-map]. Тесты конвертации авторства, изображений, тайлов и текста в [NativeBackedConverterTest · Android][a-native] и на [NativeBackedConverterTest · iOS][i-native]. | Нативные касания и проверка попадания в объект [#66][66], [#67][67]. События POI базовой карты, готовность карты и преобразование метаданных на контролируемых данных [#85][85]. |
| [`MapObjectCollection`, `PlacemarkMapObject` и остальные фигуры](mapobjects.md) | Добавление, обход, очистка, слушатели, конкретные подтипы и создание кластерной коллекции в [LiveMapObjectCollectionTest · Android][a-collection] и на [LiveMapObjectCollectionTest · iOS][i-collection]. Геометрия, стиль, видимость и идентичность метки в [LivePlacemarkMapObjectTest · Android][a-pin] и на [LivePlacemarkMapObjectTest · iOS][i-pin]. | Обновление объектов и кластеров, видимость, перетаскивание и попадание в объект [#67][67], [#68][68]. |
| [`toNative()`, `toCommon()`, `WeakRef` и фабрики слушателей](overview.md) | Стабильная идентичность нативного адаптера и чтение слабой ссылки в [LiveListenerIdentityTest · Android][a-listener] и на [LiveListenerIdentityTest · iOS][i-listener]. Равенство обёрток нативных объектов на [HandleIdentityTest · Android JVM][a-identity] и на [HandleIdentityTest · iOS][i-identity]. | Удержание слушателя и отмена подписки при пересоздании карты [#71][71]. |
| `Point`, `Polyline`, `IconStyle`, длительности, структуры и перечисления | Порядок полей, единицы измерения и отображение перечислений на [Android JVM][a-converters] и на [iOS][i-converters]. Дополнительные проверки геометрии и стилей с нативными объектами и nullable-полями в [PolylineConverterTest · Android][a-geometry]/[IconStyleConverterTest · стили][a-style] и на [GeometryConverterTest · iOS][i-geometry]/[IconStyleConverterTest · стили][i-style]. | Проверки преобразования в обе стороны для новых API [#86][86] и соответствие редакций SDK [#81][81]. |
| [`MapKit.createUserLocationLayer`, `LocationManager` и симуляция геопозиции](location.md) | Видимость, ориентация, привязки, адаптеры слушателей и состояние камеры без координат в [LiveUserLocationLayerTest · Android][a-location] и на [LiveUserLocationLayerTest · iOS][i-location]. | Доставка подставной позиции, вращение и перемещение камеры к известной позиции на одной Compose-карте [#69][69]. |
| [`Map.addTileLayer`, `addMapObjectLayer`, `Logo`, состояние indoor и оверлеи](layers.md) | Независимая коллекция объектов, стили карты, флаги indoor, доступ к логотипу и проекции в [Android][a-map] и на [iOS][i-map]. | Контролируемый источник тайлов, колбэки стилей и загрузки, переходы indoor и отрисовка оверлеев [#85][85], [#83][83]. |
| [`TrafficLayer`, `StorageManager` и `OfflineCacheManager`](offline.md) | Перечисления для пробок и регионов в тестах преобразования на [Android JVM][a-converters] и на [iOS][i-converters]. Запросы к сервисам и жизненный цикл хранилища ещё предстоит проверить. | Пробки, жизненный цикл региона и ошибки кеша [#85][85]. Холодный и прогретый кеш и изолированные релизные сценарии [#74][74], [#82][82]. |
| [`Logging`, `I18nManager` и ошибки Runtime](runtime.md) | Уровень логов, фильтрация, доставка и отписка в [LiveLoggingTest · Android][a-logs] и на [LiveLoggingTest · iOS][i-logs]. Преобразование настроек локали и перечислений на [Android JVM][a-converters] и на [iOS][i-converters]. | Результаты форматирования и колбэки ошибок от контролируемых источников [#85][85]. |

## Compose и ресурсы

| Публичный API | Проверенное поведение, тесты и платформы | Оставшиеся сценарии |
| --- | --- | --- |
| [`YandexMap`, `MapEffect`, `MapConfig` и `MapListeners`](../compose/overview.md) | [Тест на эмуляторе Android][a-lifecycle] завершает Activity, пока `YandexMap` остаётся в композиции. Тесты ядра в [Android][a-map] и на [iOS][i-map] проверяют настройки и адаптеры слушателей нативной карты. | Нативное касание и повторное открытие на обеих платформах [#66][66]. Доставка касаний в Compose [#67][67], закрытие и пересоздание [#70][70], переходы по стеку экранов [#72][72], [#73][73]. |
| [`Placemark`, `Polyline`, `Polygon`, `Circle`, `MapObjectCollection` и `Clustering`](../compose/mapobjects.md) | [MapNodeInsertOrderTest · Порядок вставки узла][map-order] проверяется на Android JVM, эмуляторе Android и симуляторе iOS. [MapObjectStatesRestorationTest · Восстановление состояния][a-savers] проверено на Android, [MapObjectStateSaversTest · сохранение состояния][i-savers] фигур и камеры в обе стороны проверено на iOS. | Состав нативных коллекций, видимость и замена обработчика [#68][68]. Сохранение состояния после возврата к карте [#75][75]. |
| [`YandexMap` с `UserLocationState`, `TrafficLayer`, `TileLayer` и `MapObjectLayer`](../compose/overview.md) | Тесты ядра выше проверяют часть геолокации и слоёв. Обновление и удаление слоёв в Compose ещё предстоит проверить. | Симуляция позиции и движение камеры [#69][69], замена слоя и колбэки [#85][85]. |
| [`ImageBitmap.toImageProvider()` и `imageProvider { … }`](../compose/image-resources.md) | [ComposeMapObjectRendererTest · Тест рендера Compose][renderer] проверяет кадр и перерисовку после смены состояния на эмуляторе Android и симуляторе iOS. [ComposeMapObjectRendererIosTest · Тест размеров на iOS][i-renderer] проверяет внутренний размер и масштаб. [ColorConvertionTest · Преобразование цветов][color] проверяет ARGB в общих тестах. | Установка иконки на настоящую метку или кластер, привязка, замена и отмена [#84][84]. |
| [`imageProvider(DrawableResource)`](../compose/image-resources.md#compose-multiplatform-resources) в `-compose-resources` | [Публичный ABI][api] включает опциональную точку входа. [PR #61][split] перенёс зависимость от ресурсов в этот модуль. Автоматическую проверку чтения drawable и его установки на нативную метку ещё предстоит добавить. | Отдельное приложение с опубликованными артефактами на Android и iOS [#76][76], поведение изображений [#84][84]. |
| [`MOKOImageLoader.fromResource` и `rememberMOKOImageLoader`](image-resources.md) в `-moko` и `-moko-compose` | [Публичный ABI][api] проверяет оба модуля. Ещё нужно проверить декодирование ресурса Moko, флаг кеширования и сохранение загрузчика в Compose. | Опциональные интеграции изображений [#84][84]. |
| [Установка опубликованных модулей](../getting-started/installation.md) | [iOS][ios] компилирует и линкует фреймворки библиотек. [Android JVM][android-host] собирает библиотеки. Установка в отдельное приложение отслеживается отдельно. | Собрать и запустить изолированное приложение из Maven-артефактов [#76][76]. Релизные проверки и матрица ОС [#82][82]. |

## Отчёты о регрессиях

| Отчёт | Ближайшая проверка на этом коммите | Оставшиеся сценарии |
| --- | --- | --- |
| [#20][20] Касание карты | Подписка и отписка в ядре на [Android][a-map] и [iOS][i-map]. | Направить реальное касание в нативную карту [#66][66], [#67][67]. |
| [#32][32] Перемещение к позиции пользователя на одной карте | [Пример][location-sample] анимирует перемещение на той же карте. Тесты слоя геолокации проверяют состояние без позиции. | Подать тестовую позицию и проверить завершение движения камеры [#69][69]. |
| [#33][33] Ошибка iOS cinterop в приложении | [Руководство по установке](../getting-started/installation.md) описывает CocoaPods и линковку. [CI iOS][ios] линкует фреймворк самой библиотеки. | Установить, слинковать и запустить отдельное приложение с Maven-артефактами [#76][76]. |
| [#34][34] Пропавшее событие камеры на iOS | [LiveCameraListenerDeliveryTest][i-camera] на нативной карте сохраняет слушатель и проверяет его вызов после `move`. | Доставка событий о жестах и через Compose [#69][69]. |
| [#42][42] Compose Resources как зависимость основного Compose-модуля | [Разделение модулей][split] и [проверка ABI][api] покрывают публичную перегрузку. | Проверить зависимости опубликованных артефактов и загрузку drawable в приложении [#76][76], [#84][84]. |
| [#55][55] Сбой при закрытии карты Compose | [NativeYandexMapLifecycleTest][a-lifecycle] инициализирует MapKit, создаёт карту и завершает Activity. | Скрытие и показ, пересоздание и повторное закрытие [#70][70]. |

[Ограничения API](coverage.md) применимы и к тестам. Поиск, маршрутизация и другие API сборки Full
недоступны для Lite. Проверки раздельного подключения сборок описаны в [#77][77], остальные API
Full отслеживаются в [#81][81]. При добавлении тестов или обнаружении пробела используйте
[процесс проверки регрессий](../getting-started/contributing.md#regressions).

[abi]: ../getting-started/contributing.md#public-api
[snapshot]: https://github.com/SuLG-ik/yandex-mapkit-kmp/commit/c60499064c8a42531a3fcf344d3c0a40a6a38cd6
[android-host]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693889
[android-device]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693535
[ios]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693602
[api]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44406693288/job/135163693728
[a-converters]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit
[i-converters]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit
[split]: https://github.com/SuLG-ik/yandex-mapkit-kmp/pull/61
[location-sample]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/sample/composeApp/src/commonMain/kotlin/ru/sulgik/mapkit/sample/NewMap.kt#L148
[a-window]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapWindowTest.kt
[i-window]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapWindowTest.kt
[a-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/NativeYandexMapLifecycleTest.kt
[a-map]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapTest.kt
[i-map]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapTest.kt
[i-camera]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveCameraListenerDeliveryTest.kt
[a-native]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/NativeBackedConverterTest.kt
[i-native]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/NativeBackedConverterTest.kt
[a-collection]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LiveMapObjectCollectionTest.kt
[i-collection]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LiveMapObjectCollectionTest.kt
[a-pin]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/LivePlacemarkMapObjectTest.kt
[i-pin]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/LivePlacemarkMapObjectTest.kt
[a-listener]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/LiveListenerIdentityTest.kt
[i-listener]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/LiveListenerIdentityTest.kt
[a-identity]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit/HandleIdentityTest.kt
[i-identity]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/HandleIdentityTest.kt
[a-geometry]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/geometry/PolylineConverterTest.kt
[i-geometry]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/geometry/GeometryConverterTest.kt
[a-style]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/map/IconStyleConverterTest.kt
[i-style]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/map/IconStyleConverterTest.kt
[a-location]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/user_location/LiveUserLocationLayerTest.kt
[i-location]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/user_location/LiveUserLocationLayerTest.kt
[a-logs]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/runtime/logging/LiveLoggingTest.kt
[i-logs]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/runtime/logging/LiveLoggingTest.kt
[map-order]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/MapNodeInsertOrderTest.kt
[a-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/MapObjectStatesRestorationTest.kt
[i-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/MapObjectStateSaversTest.kt
[renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererTest.kt
[i-renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererIosTest.kt
[color]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/ColorConvertionTest.kt
[20]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/20
[32]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/32
[33]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/33
[34]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/34
[42]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/42
[55]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/55
[66]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/66
[67]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/67
[68]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/68
[69]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/69
[70]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/70
[71]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/71
[72]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/72
[73]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/73
[74]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74
[75]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/75
[76]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/76
[77]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/77
[81]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/81
[82]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/82
[83]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/83
[84]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/84
[85]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/85
[86]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/86
