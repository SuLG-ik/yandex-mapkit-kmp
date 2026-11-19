# Покрытие MapKit Full

Здесь сравниваются нативные артефакты Lite и Full версии **4.45.0**. Страница показывает,
какие возможности Full предстоит открыть в общем Kotlin-коде. Возможности конкретной версии
обёртки указаны в [описаниях релизов][releases]. На момент сравнения опубликованная обёртка
использует Lite. В рамках [проверки Full-артефактов][77] отдельные приложения
[Android][full-android-ci] и [iOS][full-ios-ci] запустились и создали нативный менеджер
поиска `ONLINE` из общего Kotlin-кода. Кандидат также поддерживает [текстовые запросы](full-text-search.ru.md),
их результаты и отмену.

Для сравнения использованы Android AAR `com.yandex.android:maps.mobile` и CocoaPods
XCFramework `YandexMapsMobile` для `4.45.0-lite` и `4.45.0-full`. Имена нативных типов и функций
сверены по `classes.jar` и `Headers` для физических устройств iOS. Варианты SDK описаны
в руководствах для [Android][android-setup] и [iOS][ios-setup] и в [истории версий][sdk-versions].

## Покрытие по семействам

**Запланировано** означает, что для реализации есть задача. **Частично** означает, что часть
поведения проверяет кандидат Full-обёртки. **Платформенные** типы остаются на своей платформе
или требуют подтверждения поддерживаемого способа вызова. Наличие нативного объявления
само по себе не подтверждает доступ к сервису.

| Семейство | Точки входа Android | Точки входа iOS | Состояние в общем Kotlin-коде |
| --- | --- | --- | --- |
| Текстовый поиск | `search.SearchFactory`, `Search.createSearchManager`, `SearchManager.submit(String, Geometry, …)`, `Session`, `Response` | `YMKSearchFactory`, `YMKSearch.createSearchManagerWithSearchManagerType:`, `YMKSearchManager.submitWithText:geometry:searchOptions:responseHandler:`, `YMKSearchSession`, `YMKSearchResponse` | **Частично** в [#78][78]. [Общий API](full-text-search.ru.md) отправляет текстовый запрос по области, обрабатывает результаты и ошибки и отменяет текущую сессию. |
| Поисковые подсказки | `SearchManager.createSuggestSession`, `SuggestSession.suggest`, `reset` | `YMKSearchManager.createSuggestSession`, `YMKSearchSuggestSession.suggestWithText:window:suggestOptions:responseHandler:`, `reset` | **Запланировано** в [#79][79]. |
| Обратное геокодирование | `SearchManager.submit(Point, Integer, …)`, `ToponymObjectMetadata`, `Address` | `YMKSearchManager.submitWithPoint:zoom:searchOptions:responseHandler:`, `YMKSearchToponymObjectMetadata`, `YMKSearchAddress` | **Запланировано** в [#95][95]. Использует существующий API поиска. Масштаб может отсутствовать на обеих платформах. |
| Слои поиска и расширенные результаты | `Search.createSearchLayer`, `search.search_layer.SearchLayer`, `SearchManager.searchByURI`, `searchByBusinessOids`, `submit` для поиска вдоль полилинии | `YMKSearch.createSearchLayerWithMapWindow:`, `YMKSearchLayer`, `YMKSearchManager.searchByURIWithUri:…`, `searchByBusinessOidsWithBusinessOids:…`, `submitWithText:polyline:…` | **Запланировано** в [#96][96]. Включает фильтры организаций, изображения меток и колбэки слоя. [Справочник слоя][native-search-layer] |
| Автомобильные маршруты | `directions.DirectionsFactory`, `Directions.createDrivingRouter`, `directions.driving.{DrivingRouter, DrivingSession, DrivingRoute}` | `YMKDirectionsFactory`, `YMKDirections.createDrivingRouterWithType:`, `YMKDriving{Router,Session,Route}` | **Запланировано** в [#80][80], включая геометрию, отмену и параметры транспорта, доступные на обеих платформах. |
| Пешеходные, велосипедные маршруты и общественный транспорт | `transport.TransportFactory`, `Transport.createPedestrianRouter`, `createBicycleRouterV2`, `createMasstransitRouter`, сессии и данные маршрутов из `transport.masstransit` | `YMKTransportFactory`, `YMKTransport.createPedestrianRouter`, `createBicycleRouterV2`, `createMasstransitRouter`, `YMKPedestrianRouter`, `YMKBicycleRouterV2`, `YMKMasstransit{Router,Session,Route}` | **Запланировано** в [#80][80]. Отдельные классы `transport.bicycle` и `YMKBicycleRouter` относятся к устаревшему API V1. |
| Сводки маршрутов, микромобильность, сериализация и отображение | `Transport.createScooterRouter`, `createElectricBikeRouter`, `transport.time.AdjustedClock`, `MasstransitRouteSerializer`, `DrivingJamsPainter`, `RouteHelper`, `annotations.Speaker` | `YMKTransport.createScooterRouter`, `createElectricBikeRouter`, `YMKAdjustedClock`, `YMKMasstransitRouteSerializer`, `YMKMasstransitDrivingJamsPainter`, `YMKRouteHelper`, `YMKSpeaker` | **Запланировано** в [#101][101] после базовых режимов маршрутизации. |
| Поиск, плеер и слой панорам | `places.PlacesFactory`, `Places.createPanoramaService`, `createPanoramaLayer`, `PanoramaService.findNearest`, `places.panorama.Player`, `PanoramaView` | `YMKPlacesFactory`, `YMKPlaces.createPanoramaService`, `createPanoramaLayerWithMapWindow:`, `YMKPanoramaService.findNearestWithPosition:searchHandler:`, `YMKPanoramaPlayer`, `YMKPanoView` | Поиск и управление плеером **запланированы** в [#97][97]. Android View и iOS UIView **платформенные**. [Справочник поиска панорам][native-panorama] |
| Плееры снимков и треков MRC | `Places.createMrcPhotoPlayer`, `createMrcPhotoTrackPlayer`, `places.mrc.MrcPhoto{Player,TrackPlayer,View,TrackView}` | `YMKPlaces.createMrcPhotoPlayerWithPlatformView:`, `createMrcPhotoTrackPlayerWithPlatformView:`, `YMKMrcPhoto{Player,TrackPlayer,View,TrackView}` | **Платформенные** в этой инвентаризации. В [#97][97] нужно подтвердить поддерживаемый способ загрузки и найти тестовые данные до добавления обёртки. |
| Парковки и дорожные события | `Directions.createCarparksLayer`, `directions.carparks.CarparksLayer`, `MapKit.createRoadEventsManager`, `road_events.RoadEventsManager`, `road_events_layer.StyleProvider` | `YMKDirections.createCarparksLayerWithMapWindow:`, `YMKCarparksLayer`, `YMKMapKit.createRoadEventsManager`, `YMKRoadEventsManager`, `YMKRoadEventsLayerStyleProvider` | Слой парковок и детали событий **запланированы** в [#98][98]. Для типов стилей нужно подтвердить способ подключения в MapKit Full. |
| Аккаунт и персонализированный поиск | `MapKit.setAccount`, `com.yandex.runtime.auth.{Account,TokenListener}`, `search.DeleteAllPersonalSuggestSession` | `YMKMapKit.setAccount:`, `YRTAccount`, `YRTTokenDelegate`, `YMKSearchDeleteAllPersonalSuggestSession` | Адаптер аккаунта **запланирован** в [#99][99]. Сессия удаления объявлена, но в проверенных публичных фабриках поиска нет способа её создать. |
| Захват изображения карты без экрана | `MapKit.createOffscreenMapWindow`, `OffscreenMapWindow.captureScreenshot` → `Bitmap` | `YMKMapKit.createOffscreenMapWindowWithWidth:height:`, `YMKOffscreenMapWindow.captureScreenshot` → `UIImage` | **Запланировано** в [#100][100]. Обе фабрики принимают размеры и имеют перегрузки с коэффициентом масштаба. Нативное изображение **платформенное**. [Руководство по рендерингу без экрана][native-offscreen] |

В Lite уже объявлены `OffscreenMapWindow` и `RoadEventsManager` и их аналоги на iOS. В Full
добавлены фабрики, которые возвращают эти объекты, и метод установки аккаунта.
В [истории версий SDK][sdk-versions] упоминаются закладки. В проверенных артефактах MapKit точка
входа для закладок не найдена. Для неё нужно сначала подтвердить подходящий артефакт.
Для активной навигации и ведения [руководство NaviKit][navikit] использует отдельную редакцию SDK.

## Сценарии и проверки

Для задач ниже используйте контролируемые данные, чтобы проверить преобразования, жизненный
цикл и отмену на обеих платформах. Сценарии с реальными данными провайдера или учётными данными
запланированы в доверенных [интеграционных проверках][82].

| Непокрытое поведение | Необходимые данные | Приёмочная проверка |
| --- | --- | --- |
| Проверка поиска с сервисом [#82][82] и подсказки [#79][79] | Ключ Full и известный текстовый запрос, контролируемые ответы для тестов подсказок | Проверить результаты и ошибки запроса к сервису. При очистке или изменении запроса подсказок отбросить предыдущий ответ. [Поиск на Android][android-search] · [Поиск на iOS][ios-search] |
| Геокодирование и расширенный поиск [#95][95] [#96][96] | Фиксированная координата, тестовый результат и изображение метки, известный URI или ID для живого запроса | Преобразовать необязательный структурированный адрес. Выбрать и очистить результат слоя, получить следующую страницу там, где она доступна, и отписаться при закрытии карты. |
| Маршруты и дополнительные функции [#80][80] [#101][101] | Фиксированные точки, тестовая геометрия и метаданные, доступность нужного режима в регионе для живой проверки | Отрисовать маршрут, заменить и отменить запрос, проверить отсутствие маршрута и поддерживаемые режимы. Сводки и сериализацию проверять отдельно. [Руководство по маршрутизации][android-routes] |
| Панорамы и изображения мест [#97][97] | Известный ID панорамы или контролируемая сессия, тестовый снимок или трек для подтверждённого MRC API | Найти ближайшую панораму и закрыть плеер с проверкой ошибок и отмены. Подтвердить загрузку реального снимка или трека до добавления обёртки MRC. |
| Парковки и дорожные события [#98][98] | Фиксированный стиль, контролируемый ответ события, поддерживаемая область карты и источник событий для живой проверки | Включить и сбросить стиль парковок. Получить детали события, проверить успех, ошибку и отмену и отключить колбэк стиля, если он доступен. |
| Интеграция аккаунта [#99][99] | Тестовый аккаунт без реальных учётных данных в CI для PR. Доверенные учётные данные нужны только для проверки реального сервиса | Установить и сбросить аккаунт. Проверить получение токена, ошибку и отзыв токена без вывода токенов в журнал. |
| Карта без экрана [#100][100] | Окно карты фиксированного размера с локальной меткой или геометрией | Отрисовать карту без видимого View. Проверить размеры изображения, масштаб, освобождение ресурсов и оба нативных типа изображения. |

## Как повторить сравнение при обновлении SDK

1. Возьмите версию из `gradle/libs.versions.toml`. Получите две версии AAR и две версии
   CocoaPods XCFramework одного и того же SDK. Сверьте результат разрешения зависимостей и
   `Podfile.lock` с руководствами для [Android][android-setup] и [iOS][ios-setup].
2. Во временной папке задайте `version` для версии SDK, а `lite_headers` и `full_headers` для
   двух путей к `ios-arm64/YandexMapsMobile.framework/Headers`. Сравните верхнеуровневые типы
   и общие сигнатуры Android, затем заголовки iOS.

    ```sh
    export LC_ALL=C
    for edition in lite full; do
        unzip -p "maps.mobile-$version-$edition.aar" classes.jar > "$edition.jar"
        jar tf "$edition.jar" |
            sed -n '/^com\/yandex\//{ /\$/d; /\/internal\//d; s/\.class$//p; }' |
            tr '/' '.' | sort > "$edition.types"
    done
    comm -13 lite.types full.types > android-full-only.types
    comm -12 lite.types full.types > android-shared.types
    for edition in lite full; do
        xargs javap -public -classpath "$edition.jar" < android-shared.types > "$edition.shared-api"
    done
    diff -u lite.shared-api full.shared-api
    diff -r "$lite_headers" "$full_headers"
    ```

3. Сопоставьте эти границы с общими исходниками и ABI документируемого релиза обёртки.
   Обновите обе локали и укажите тест или задачу для каждого изменившегося семейства.
   Для недокументированных объявлений и типов без фабрики сначала подтвердите способ вызова.
   Требования к сервису и тестовым данным фиксируйте в соответствующих проверках.

В версии 4.45.0 получаются **286** дополнительных верхнеуровневых объявлений в **14** пакетах
Android и **141** дополнительное имя заголовка iOS. Из общих заголовков iOS объявления изменились
в `YMKMapkit.h`. Из общих верхнеуровневых типов Android сигнатуры добавлены в `MapKit`.
Число типов и число заголовков измеряют разные вещи. Для отдельного изменения сверяйте
`javap -public` с учётом вложенных типов колбэков и само объявление iOS.

[android-setup]: https://yandex.ru/maps-api/docs/mapkit/android/generated/getting_started.html
[ios-setup]: https://yandex.com/maps-api/docs/mapkit/ios/generated/getting_started.html
[sdk-versions]: https://yandex.com/maps-api/docs/mapkit/versions.html
[android-search]: https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_search.html
[ios-search]: https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_search.html
[android-routes]: https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_routes.html
[native-panorama]: https://yandex.com/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaService.html
[native-search-layer]: https://yandex.com/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchLayer.html
[native-offscreen]: https://yandex.com/maps-api/docs/mapkit/android/static/tutorials/map_surface.html
[navikit]: https://yandex.com/maps-api/docs/mapkit/ios/generated/navigation/getting_started.html
[full-android-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44432360794/job/135252651813
[full-ios-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/runs/44432360794/job/135252652111
[releases]: https://github.com/SuLG-ik/yandex-mapkit-kmp/releases
[77]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/77
[78]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/78
[79]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/79
[80]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/80
[82]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/82
[95]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/95
[96]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/96
[97]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/97
[98]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/98
[99]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/99
[100]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/100
[101]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/101
