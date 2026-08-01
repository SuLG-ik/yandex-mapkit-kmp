# Пример приложения

[Проект-пример](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/sample) — приложение на
Compose Multiplatform, которое прогоняет всю обёртку. Весь код карты в нём лежит в `commonMain`;
проекты Android и iOS только запускают его.

## Как запустить

API-ключ берётся из `local.properties`, и без него сборка падает с явным сообщением.

=== "local.properties"

    ```
    MAPKIT_API_KEY=<API-KEY>
    ```

=== "Android"

    ```bash
    ./gradlew :sample:composeApp:installDebug
    ```

=== "iOS"

    Откройте `sample/iosApp/iosApp.xcworkspace` в Xcode и запустите.

[BuildKonfig](https://github.com/yshrsmz/BuildKonfig) генерирует ключ в общий код — это тот же
приём, что описан в [Быстром старте](getting-started/quick-start.md).

## Что внутри

Приложение открывается меню экранов, каждый из которых покрывает свой срез API.

| Экран | Что показывает |
|---|---|
| **Old api objects** | API контроллера — `MapControllerEffect` и императивный код MapKit, включая кластеризацию |
| **New api objects** | API состояний — `Placemark`, `Circle`, `Polygon`, `Polyline`, `Clustering`, composable-иконки |
| **Layers, listeners and states** | `MapObjectCollection`, `MapObjectLayer`, `TileLayer`, `TrafficLayer`, `MapListeners`, объекты состояния и `traverse` |
| **Storage, offline cache, i18n** | `StorageManager`, `OfflineCacheManager`, `I18nManager` и поток логов MapKit |

На каждом экране есть журнал событий прямо на экране, так что нажатие, движение камеры или
неудавшийся вызов видны без отладчика — именно так проверялось и поведение самой обёртки.

Это переписанное на этой библиотеке
[официальное демо Yandex MapKit](https://github.com/yandex/mapkit-android-demo), поэтому одни и те же
сценарии можно сравнивать бок о бок с оригинальным Android-кодом.
