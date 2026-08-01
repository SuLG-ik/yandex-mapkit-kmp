# Sample app

The [sample project](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/sample) is a
Compose Multiplatform application that exercises the whole wrapper. All of its map code lives in
`commonMain`; the Android and iOS projects only start it.

## Running it

The API key comes from `local.properties`, and the build fails with an explicit message without it.

=== "local.properties"

    ```
    MAPKIT_API_KEY=<API-KEY>
    ```

=== "Android"

    ```bash
    ./gradlew :sample:composeApp:installDebug
    ```

=== "iOS"

    Open `sample/iosApp/iosApp.xcworkspace` in Xcode and run.

[BuildKonfig](https://github.com/yshrsmz/BuildKonfig) generates the key into common code, which is
the pattern described in [Quick start](getting-started/quick-start.md).

## What is inside

The app opens on a menu of screens, each covering a slice of the API.

| Screen | What it shows |
|---|---|
| **Old api objects** | the Controller API — `MapControllerEffect` plus imperative MapKit code, including clustering |
| **New api objects** | the States API — `Placemark`, `Circle`, `Polygon`, `Polyline`, `Clustering`, composable icons |
| **Layers, listeners and states** | `MapObjectCollection`, `MapObjectLayer`, `TileLayer`, `TrafficLayer`, `MapListeners`, the state objects and `traverse` |
| **Storage, offline cache, i18n** | `StorageManager`, `OfflineCacheManager`, `I18nManager` and the MapKit log stream |

Every screen keeps an on-screen event log, so a tap, a camera move or a failed call is visible
without a debugger — which is also how the wrapper's own behaviour was verified.

It is a rewrite of the
[official Yandex MapKit demo](https://github.com/yandex/mapkit-android-demo) on top of this library,
so the same scenarios can be compared side by side with the original Android code.
