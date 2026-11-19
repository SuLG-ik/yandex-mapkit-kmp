# Покрытие регрессионными тестами

Список составлен по [дампам публичного ABI][abi] и исходникам тестов на коммите [`c6049906`][snapshot].
Задачи CI ниже относятся к этому коммиту. В таблицах также приведены более поздние проверки
[отдельных приложений][consumer], нативных жестов на [Android][a-map-taps-ci] и [iOS][i-map-taps-ci],
а также [жизненного цикла слушателей][71].
Доступные API и ограничения платформ описаны на странице
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
| [`MapKit`, `MapView` и `MapWindow`](map.md) | Нативное окно отдаёт размеры, фокус, масштаб и проекцию. В [LiveMapWindowTest · Android][a-window] и на [LiveMapWindowTest · iOS][i-window] проверено преобразование между экранными и географическими координатами в обе стороны. [NativeYandexMapLifecycleTest · Закрытие Android Activity][a-lifecycle] проверяет нативное представление через Compose. [MapLifecycleTest · Android][a-host-lifecycle] проверяет уход в фон и возврат, пересоздание Activity и потерю валидности освобождённых нативных окон. | Сценарии нескольких карт и ввода при открытой панели описаны в разделе Compose. |
| [`Map.move`, `CameraPosition`, параметры жестов и `CameraListener`](map.md) | [LiveMapTest · Android][a-map] и [LiveMapTest · iOS][i-map] проверяют изменение позиции после программного перемещения и соответствие флагов жестов. [LiveCameraListenerDeliveryTest · Тест iOS][i-camera] наблюдает вызов слушателя после перемещения. | Доставка событий камеры на Android, жесты, прерывание анимации и жизненный цикл камеры в Compose [#69][69]. |
| [`InputListener`, `GeoObjectTapListener`, `MapLoadedListener` и метаданные карты](geoobjects.md) | Подписка, отписка или очистка слушателей в [Android][a-map] и на [iOS][i-map]. Тесты конвертации авторства, изображений, тайлов и текста в [NativeBackedConverterTest · Android][a-native] и на [NativeBackedConverterTest · iOS][i-native]. Тесты нативного ввода на [Android][a-map-taps] и [iOS][i-map-taps] проверяют доставку короткого и долгого нажатия через Compose и их координаты. [LayerServiceAdapterTest · Android][a-layer-service-adapter] проверяет идентичность и оба результата обработки подставленного нативного события POI. | Доверенный прогон на известной области с реальными касаниями POI на iOS, событиями готовности и преобразованием метаданных [#82][82]. |
| [`MapObjectCollection`, `PlacemarkMapObject` и остальные фигуры](mapobjects.md) | Добавление, обход, очистка, слушатели, конкретные подтипы и создание кластерной коллекции в [LiveMapObjectCollectionTest · Android][a-collection] и на [LiveMapObjectCollectionTest · iOS][i-collection]. Геометрия, стиль, видимость и идентичность метки в [LivePlacemarkMapObjectTest · Android][a-pin] и на [LivePlacemarkMapObjectTest · iOS][i-pin]. | Перетаскивание объектов. |
| [`ImageProvider` и `AnimatedImageProvider`](image-resources.md) | [LivePlacemarkMapObjectTest · Android][a-pin] и [LivePlacemarkMapObjectTest · iOS][i-pin] подтверждают, что `useIcon()`, `useModel()` и `useAnimation()` возвращают валидные нативные объекты. | Декодировать иконку через платформенную фабрику и установить её на нативный объект. Проверить `AnimatedImageProvider.fromByteArray`, `fromFile` и `fromAnimatedImage`, воспроизведение анимации на метке и анимированную заливку полигона. |
| [`toNative()`, `toCommon()`, `WeakRef` и фабрики слушателей](overview.md) | Стабильная идентичность нативного адаптера и чтение слабой ссылки в [LiveListenerIdentityTest · Android][a-listener] и на [LiveListenerIdentityTest · iOS][i-listener]. Равенство обёрток нативных объектов на [HandleIdentityTest · Android JVM][a-identity] и на [HandleIdentityTest · iOS][i-identity]. [ListenerOwnershipTest · эмулятор Android][a-listener-ownership] и [MapInteractionTests · симулятор iOS][i-listener-ownership] проверяют доставку события после запроса GC, отписку при наличии сильной ссылки на прежний слушатель и отмену обработки события при создании новой карты [#71][71]. | — |
| `Point`, `Polyline`, `IconStyle`, длительности, структуры и перечисления | Порядок полей, единицы измерения и отображение перечислений на [Android JVM][a-converters] и на [iOS][i-converters]. Дополнительные проверки геометрии и стилей с нативными объектами и nullable-полями в [PolylineConverterTest · Android][a-geometry]/[IconStyleConverterTest · стили][a-style] и на [GeometryConverterTest · iOS][i-geometry]/[IconStyleConverterTest · стили][i-style]. | Проверки преобразования в обе стороны для новых API [#86][86] и соответствие редакций SDK [#81][81]. |
| [`MapKit.createUserLocationLayer`, `LocationManager` и симуляция геопозиции](location.md) | Видимость, ориентация, привязки, адаптеры слушателей и состояние камеры без координат в [LiveUserLocationLayerTest · Android][a-location] и на [LiveUserLocationLayerTest · iOS][i-location]. | Доставка подставной позиции, вращение и перемещение камеры к известной позиции на одной Compose-карте [#69][69]. |
| [`Map.addTileLayer`, `addMapObjectLayer`, `Logo`, состояние indoor и оверлеи](layers.md) | Независимая коллекция объектов, стили карты, флаги indoor, доступ к логотипу и проекции в [Android][a-map] и на [iOS][i-map]. [LiveTileLayerTest · Android][a-layer-tile-live] и [iOS][i-layer-tile-live] проверяют активацию, стиль и удаление нативного слоя. [TileLayerContractTest · Android][a-layer-tile-contract] и [iOS][i-layer-tile-contract] проверяют локальный PNG, поля запроса, использование кеша и состояния тайлов. На Android тест подаёт колбэки после замены слушателей. На iOS живой слой устанавливает, заменяет и очищает оба слушателя. | Доставка колбэков рендера iOS и удаление слоя при незавершённом запросе тайла [#85][85]. Переходы indoor и отрисовка оверлеев [#83][83]. |
| [`TrafficLayer`, `StorageManager` и `OfflineCacheManager`](offline.md) | `TrafficColor` и `RegionState` преобразуются в обе стороны в [EnumConverterTest · Android JVM][a-enums] и [EnumConverterTest · iOS][i-enums]. [LayerServiceAdapterTest · Android][a-layer-service-adapter] и [iOS][i-layer-service-adapter] проверяют загрузку, неопределённые данные, истечение срока действия пробок и передачу состояния и прогресса региона. [StorageManagerContractTest · Android][a-storage-contract] проверяет отложенные результаты, 64-битные и nullable-размеры и типизированные ошибки на заглушке в памяти. [StorageManagerContractTest · iOS][i-storage-contract] проверяет реальные байты в колбэке и регистрацию слушателя ошибок. Очистка и лимиты проверяются на заглушке Android. | Реальные пробки, лицензированная загрузка регионов и ошибки диска в доверенных запусках по расписанию [#82][82]. Замеры холодного и прогретого кеша [#74][74]. |
| [`Logging`, `I18nManager` и ошибки Runtime](runtime.md) | Уровень логов, фильтрация, доставка и отписка в [LiveLoggingTest · Android][a-logs] и на [LiveLoggingTest · iOS][i-logs]. Преобразование настроек локали и перечислений на [Android JVM][a-converters] и на [iOS][i-converters]. | Результаты форматирования и колбэки ошибок от контролируемых источников [#85][85]. |

## Compose и ресурсы

| Публичный API | Проверенное поведение, тесты и платформы | Оставшиеся сценарии |
| --- | --- | --- |
| [`YandexMap(controller = …)`, `YandexMapController` и `MapControllerEffect`](../compose/overview.md) | [NativeYandexMapLifecycleTest · эмулятор Android][a-lifecycle] создаёт карту с контроллером, проверяет доступность `controller.mapWindow` и завершает Activity, пока карта остаётся в композиции. [MapInteractionTest · Android][a-reopen] и [MapInteractionTests · iOS][i-reopen] проверяют реальные касания при первом и повторном открытии карты [#66][66]. Прогоны на [Android][a-reopen-ci] и [iOS][i-reopen-ci] прошли. [MapLifecycleTest · Android][a-host-lifecycle] и [MapLifecycleTests · iOS][i-host-lifecycle] проверяют касания при перекрытии карты, возврат приложения, повторное удаление карты во время анимации и восстановление камеры и выделения после пересоздания хоста. Оба теста сверяют точный порядок подключений и касаний. [Эмулятор Android][a-host-ci] · [Симулятор iOS][i-host-ci]. [Nav3MapTest · Android][a-nav3] и [Nav3MapTests · iOS][i-nav3] проверяют нативные касания при переходах, независимое сохранение камеры и выделения в двух стеках и сброс удалённого маршрута [#72][72]. Android проверяет системную кнопку «Назад» и пересоздание Activity. iOS проверяет отмену и завершение жеста «Назад». [Эмулятор Android][a-nav3-ci] · [Симулятор iOS][i-nav3-ci]. Тесты Decompose `DecomposeStackTest` (Android) и `DecomposeStackTests` (iOS) сверяют восстановленную камеру и геометрию метки и проверяют получателя касания, пока оба нативных окна ещё прикреплены [#73][73]. | — |
| [Карты с контроллером под модальной панелью и в двух областях экрана](../compose/overview.md) | [MapPanesTest · Android][a-panes] и [MapInteractionTests · iOS][i-panes] проверяют маршрутизацию ввода при открытой панели, камеру соседней карты после каждого перемещения и совпадение нативной карты в колбэке с источником касания. Тесты проверяют проекцию после изменения размеров с учётом отступов и области фокуса, затем касаются оставшейся карты после удаления соседней. [Эмулятор Android][a-panes-ci] · [Симулятор iOS][i-panes-ci]. | — |
| [Декларативная `YandexMap`, `MapEffect`, `MapConfig` и `MapListeners`](../compose/overview.md) | Отдельные приложения на [Android][a-consumer] и [iOS][i-consumer] создают декларативную `YandexMap` и валидную нативную метку внутри `MapEffect`. Тесты ядра на [Android][a-map] и [iOS][i-map] проверяют настройки и адаптеры слушателей нативной карты. [MapInteractionTest · эмулятор Android][a-map-taps] проверяет подписку при рекомпозиции, замену, удаление и повторное добавление колбэков. [MapInteractionTests · iOS XCTest][i-map-taps] проверяет те же колбэки. Прогоны на [Android][a-map-taps-ci] и [iOS][i-map-taps-ci] прошли [#67][67]. | Проверить обновление настроек, перезапуск и отмену эффекта [#69][69]. |
| [`Placemark`, `Polyline`, `Polygon`, `Circle`, `MapObjectCollection` и `Clustering`](../compose/mapobjects.md) | [MapNodeInsertOrderTest · Порядок вставки узла][map-order] проверяется на Android JVM, эмуляторе Android и симуляторе iOS. [MapObjectStatesRestorationTest · Восстановление состояния][a-savers] проверено на Android, [MapObjectStateSaversTest · сохранение состояния][i-savers] фигур и камеры в обе стороны проверено на iOS. [Тест нативного ввода на Android][a-map-taps] проверяет порядок попаданий в перекрывающиеся метку и полигон, изменение видимости и передачу события через родительскую коллекцию. [MapObjectMembershipTest · эмулятор Android][a-membership] и [MapObjectMembershipTests · XCTest на iOS][i-membership] добавляют сценарии для изменения геометрии объектов с ключами, видимости, удаления одного объекта после перестановки и касаний кластеров при смене масштаба и данных. Оба прогона прошли [#68][68]. [Эмулятор Android][a-membership-ci] · [симулятор iOS][i-membership-ci]. | Восстановить нативные объекты и состояние камеры при возврате к экрану карты [#75][75]. |
| [`YandexMap` с `UserLocationState`, `TrafficLayer`, `TileLayer` и `MapObjectLayer`](../compose/overview.md) | Тесты ядра выше проверяют часть геолокации и слоёв. Обновление и удаление слоёв в Compose ещё предстоит проверить. | Симуляция позиции и движение камеры [#69][69], замена слоя и колбэки [#85][85]. |
| [`ImageBitmap.toImageProvider()` и `imageProvider { … }`](../compose/image-resources.md) | [ComposeMapObjectRendererTest · Рендер Compose][renderer] проверяет кадр и обновление. [ComposeMapObjectRendererIosTest · Размеры на iOS][i-renderer] проверяет размер и масштаб. [ColorConvertionTest · Преобразование цветов][color] проверяет ARGB. [MapIconRenderingTest · Android][a-icon-rendering] и [MapIconRenderingTests · iOS][i-icon-rendering] проверяют привязку отрисованных иконок метки и кластера по обеим осям, прозрачность, изменение плотности отдельно от размера, видимость и запоздалый ответ Coil [#84][84]. | Для платформенных фабрик из файлов и нативной анимации нужны отдельные тесты. |
| [`imageProvider(DrawableResource)`](../compose/image-resources.md#ресурсы-compose-multiplatform) в `-compose-resources` | [Публичный ABI][api] включает опциональную точку входа. [PR #61][split] перенёс зависимость от ресурсов в этот модуль. Отдельные приложения на [Android][a-consumer] и [iOS][i-consumer] загружают PNG через опциональный модуль и устанавливают его на валидную нативную метку. | Проверить отдельное приложение в релизной матрице и на разных ОС [#82][82]. |
| [`MOKOImageLoader.fromResource` и `rememberMOKOImageLoader`](image-resources.md) в `-moko` и `-moko-compose` | [Публичный ABI][api] проверяет оба модуля. Ещё нужно проверить декодирование ресурса Moko, флаг кеширования и сохранение загрузчика в Compose. | Проверить упакованные ресурсы Moko на обеих платформах. |
| [Установка опубликованных модулей](../getting-started/installation.md) | [Проверка #76][consumer] подключает кандидатные артефакты из временного Maven-репозитория в изолированных приложениях на [Android][a-consumer] и [iOS][i-consumer]. Задачи проверяют выбор Lite SDK, собирают и запускают приложения и ждут создания нативной карты и метки. | Релизные проверки и матрица ОС [#82][82]. |

В примере [возврата к карте](../sample.md#возврат-к-карте) есть отдельный Android-тест
[ReturnMapRoutesTest][a-return-routes]. Он проверяет переход в детали, переключение вкладок,
сохранение и восстановление, завершение маршрута и правки меток. Вместо нативной карты тест
использует небольшой интерфейс. Прогоны примера на устройствах и замеры на одной области
отслеживаются в [#75][75] и [#74][74].

## Отчёты о регрессиях

| Отчёт | Проверенное поведение и тесты | Оставшиеся сценарии |
| --- | --- | --- |
| [#19][19] Асинхронное изображение Coil не отображается | Тесты [Android][a-icon-rendering] и [iOS][i-icon-rendering] повторяют запрос для той же модели после управляемой ошибки. Перед проверкой запоздалых результатов на карте они ждут завершения или отмены запроса Coil. | Отдельно остаются HTTP, декодирование и кеш приложения. |
| [#20][20] Касание карты | Подписка и отписка в ядре на [Android][a-map] и [iOS][i-map]. Тесты нативного ввода на [Android][a-map-taps] и [iOS][i-map-taps] отправляют короткое и долгое нажатие и проверяют колбэки и координаты. | События POI базовой карты [#85][85]. |
| [#32][32] Перемещение к позиции пользователя на одной карте | [Пример][location-sample] анимирует перемещение на той же карте. Тесты слоя геолокации проверяют состояние без позиции. | Подать тестовую позицию и проверить завершение движения камеры [#69][69]. |
| [#33][33] Ошибка iOS cinterop в приложении | [Руководство по установке](../getting-started/installation.md) описывает CocoaPods и линковку. [Отдельное приложение iOS][i-consumer] устанавливает pod Lite, выполняет cinterop, линкуется и запускается с кандидатными Maven-артефактами. | Запустить тест в релизной матрице ОС [#82][82]. |
| [#34][34] Пропавшее событие камеры на iOS | [LiveCameraListenerDeliveryTest][i-camera] на нативной карте сохраняет слушатель и проверяет его вызов после `move`. | Доставка событий о жестах и через Compose [#69][69]. |
| [#42][42] Compose Resources как зависимость основного Compose-модуля | [#61][split] перенёс перегрузку в опциональный модуль, [проверка ABI][api] проверяет её сигнатуру. Приложения на [Android][a-consumer] и [iOS][i-consumer] подключают опциональный артефакт и устанавливают PNG на метку. | Проверить отдельное приложение в релизной матрице и на разных ОС [#82][82]. |
| [#55][55] Сбой при закрытии карты Compose | [NativeYandexMapLifecycleTest][a-lifecycle] инициализирует MapKit, создаёт карту и завершает Activity. Тесты жизненного цикла на [Android][a-host-lifecycle] и [iOS][i-host-lifecycle] многократно удаляют карту во время анимации и требуют одного отсоединения для каждого старого экземпляра. Android также проверяет, что освобождённые окна теряют валидность. | Переходы по стеку экранов [#72][72], [#73][73]. |

## Поиск Full

[Тесты адаптеров Android и iOS](full-text-search.ru.md#проверки-регрессий) покрывают параметры
запроса, названия и координаты, пустой ответ, нативную ошибку и события после отмены. Тестовое
приложение Full создаёт нативный менеджер в рамках проверки редакций SDK из [#77][77].

[SuggestAdapterTest на Android JVM][a-suggest] и [на симуляторе iOS][i-suggest] проверяют
[подсказки и сброс сессии](full-text-search.ru.md#подсказки-при-вводе), включая параметры и поля
ответа, замену запроса, сброс через другую обёртку нативной сессии и запоздалые ответы.
Приложение Full создаёт и сбрасывает нативную сессию подсказок. Проверки сетевого ответа
отслеживаются в [#82][82].

Остальные API Full отслеживаются в [#81][81]. Новые сценарии проверяйте по
[процессу проверки регрессий](../getting-started/contributing.md#regressions).

[a-map-taps]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/a4cad8e0063f4ac78f945c4c626346e6fb0ead2d/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapInteractionTest.kt#L72
[i-map-taps]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/b8a9958310dd34265f11312c87031ab221a79498/tests/map-interaction/iosApp/MapInteractionTests.swift#L29
[a-map-taps-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44435197621/job/135262196868
[a-layer-tile-live]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/LiveTileLayerTest.kt
[i-layer-tile-live]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/LiveTileLayerTest.kt
[a-layer-tile-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/TileLayerContractTest.kt
[i-layer-tile-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/TileLayerContractTest.kt
[a-layer-service-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/layers/LayerServiceAdapterTest.kt
[i-layer-service-adapter]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/layers/LayerServiceAdapterTest.kt
[a-storage-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/storage/StorageManagerContractTest.kt
[i-storage-contract]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/storage/StorageManagerContractTest.kt
[a-enums]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/androidHostTest/kotlin/ru/sulgik/mapkit/EnumConverterTest.kt#L206-L238
[a-return-routes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/49449ba1394c264ca50748667faf7a95cc42e560/sample/composeApp/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/sample/ReturnMapRoutesTest.kt#L28-L97
[i-enums]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp/src/iosTest/kotlin/ru/sulgik/mapkit/EnumConverterTest.kt#L194-L226
[consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/pull/88
[a-consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44408195495/job/135169172609
[i-consumer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44408195495/job/135169172544
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
[a-panes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/89968e2ae59cf062389c850b4c0e52b8eb9a1950/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapPanesTest.kt
[i-panes]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/89968e2ae59cf062389c850b4c0e52b8eb9a1950/tests/map-interaction/iosApp/MapInteractionTests.swift#L188
[a-panes-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44551345975/job/135655604518
[i-panes-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44551345975/job/135655604326
[a-reopen]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/2dd192398ebafa1bc02f98fb6649237ef09f6649/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapInteractionTest.kt#L25
[i-reopen]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/2dd192398ebafa1bc02f98fb6649237ef09f6649/tests/map-interaction/iosApp/MapInteractionTests.swift#L4
[a-reopen-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44429584892/job/135243201327
[i-reopen-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44429584892/job/135243201431
[i-map-taps-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44440201914/job/135278848866
[a-host-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/69960e03a1efc1a6762bdeede715efc7ec9d783a/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapLifecycleTest.kt
[i-host-lifecycle]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/69960e03a1efc1a6762bdeede715efc7ec9d783a/tests/map-interaction/iosApp/MapLifecycleTests.swift
[a-host-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44433760924/job/135257507625
[i-host-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44433760924/job/135257508055
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
[a-listener-ownership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/ListenerOwnershipTest.kt
[i-listener-ownership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/tests/map-interaction/iosApp/MapInteractionTests.swift
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
[a-membership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/ddd37f2fe7a0b210e98050393e474cf206eebbca/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapObjectMembershipTest.kt#L33
[i-membership]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/ddd37f2fe7a0b210e98050393e474cf206eebbca/tests/map-interaction/iosApp/MapInteractionTests.swift#L141
[a-membership-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44532348374/job/135588678856
[i-membership-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44532348374/job/135588677985
[map-order]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/MapNodeInsertOrderTest.kt
[a-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/MapObjectStatesRestorationTest.kt
[i-savers]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/MapObjectStateSaversTest.kt
[renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererTest.kt
[i-renderer]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/iosTest/kotlin/ru/sulgik/mapkit/compose/ComposeMapObjectRendererIosTest.kt
[a-icon-rendering]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/9dbd32afeb09d81c6748d392f59e2b20206ae75f/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/MapIconRenderingTest.kt
[i-icon-rendering]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/fcd3b11bccf15c24fea5d4b709acb0aa0b072ef6/tests/map-interaction/iosApp/MapIconRenderingTests.swift
[color]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/c60499064c8a42531a3fcf344d3c0a40a6a38cd6/yandex-mapkit-kmp-compose/src/commonTest/kotlin/ru/sulgik/mapkit/ColorConvertionTest.kt
[19]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/19
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
[71]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/71
[72]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/72
[73]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/73
[74]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74
[75]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/75
[77]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/77
[81]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/81
[82]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/82
[83]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/83
[84]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/84
[85]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/85
[86]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/86
[a-suggest]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidHostTest/kotlin/ru/sulgik/mapkit/search/SuggestAdapterTest.kt
[i-suggest]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/search/SuggestAdapterTest.kt

[a-nav3]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/4adbf6cc0e960b89767ca5cef163f28b0d305960/yandex-mapkit-kmp-compose/src/androidDeviceTest/kotlin/ru/sulgik/mapkit/compose/Nav3MapTest.kt
[i-nav3]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/4adbf6cc0e960b89767ca5cef163f28b0d305960/tests/map-interaction/iosApp/Nav3MapTests.swift
[a-nav3-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44542390742/job/135623893971
[i-nav3-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44542390742/job/135623894416
