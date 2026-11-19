# Sample app

The [sample project](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/sample) is a
Compose Multiplatform application that exercises the whole wrapper. All of its map code lives in
`commonMain`; the Android and iOS projects only start it.

## Running it

Put a valid MapKit API key in `local.properties` to run the native map screens.

=== "local.properties"

    ```
    MAPKIT_API_KEY=<API-KEY>
    ```

=== "Android"

    ```bash
    ./gradlew :sample:androidApp:installDebug
    ```

=== "iOS"

    Run `./gradlew :sample:composeApp:podInstall` on a fresh checkout. Then open
    `sample/iosApp/iosApp.xcworkspace` in Xcode and run.

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
| **Return to map** | save the camera and marker selection while leaving a map tab or opening details |
| **Measure return to map** | Opt-in measurements for view creation, overlay restoration, input readiness and tile loading. [Run the benchmark](https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/verification/return-to-map). |

The API demonstrations show their events on screen, so you can inspect a tap, a camera move or
a failed call without a debugger.

It is a rewrite of the
[official Yandex MapKit demo](https://github.com/yandex/mapkit-android-demo) on top of this library,
so the same scenarios can be compared side by side with the original Android code.

## Return to map

Open **Return to map** and tap the southwest red marker on **Tab A**. Confirm the selection
`A-1`, move the camera slightly, then tap **Open details**, **Move marker** and **Back to map**.
The camera returns to the saved viewport and the green selection follows the same ID to its
updated position. Reopen its details, tap **Remove marker**, then **Back to map**. The selection
is cleared and the removed marker is absent.

Move the camera and select a marker in **Tab B**, then switch between tabs. Each tab has its own
`rememberSaveableStateHolder` entry keyed by tab ID. The entry holds the saveable camera,
selected marker ID and sample catalog edits. Opening details removes `YandexMap` from the composition.
On return, the newly attached map applies the camera through `CameraPositionState` once, then
renders the latest catalog. The two drawable image providers are created above the tab content and
reused during the life of the example. Use **Exit example** and reopen it to start with fresh state.

The saved-state registry can restore the tab entries when the host is recreated. A navigation
framework can give each map route a stable entry ID and remove the saved state when that entry is
permanently popped. Use your own durable store if a viewport or selection must survive a fresh launch
without saved UI state. Store values and IDs there. Native views, listeners and map objects belong
to their current host.

### Tile storage and offline regions

MapKit manages a separate temporary tile cache on disk. `StorageManager` can report its size and
set a limit. MapKit evicts old tiles at that limit and can fetch them again when needed.
A cache hit helps with map data. The route owner restores the camera and selected ID independently.
Use `OfflineCacheManager` to download supported regions when the application needs offline maps.
Region downloads require a paid MapKit license. [Storage reference](https://yandex.com/maps-api/docs/mapkit/com/yandex/mapkit/storage/StorageManager.html) · [Offline region guide](https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_offline.html)

The [sample workflow][sample-ci] checks sample changes in GitHub Actions. It runs the Android
route-state tests with a small UI in place of the native map and compiles the iOS simulator target.
Those jobs use a placeholder key and make no MapKit service requests. On a device, use the actual
example to check marker hits and camera restoration as the map opens and closes.

A comparison of view recreation with keeping
the tab mounted needs the same viewport, device and dataset on both runs. Compare native view
creation, the first usable frame, touch delivery and memory after [the baseline measurements][74].

[74]: https://github.com/SuLG-ik/yandex-mapkit-kmp/issues/74
[sample-ci]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/workflows/sample.yml
