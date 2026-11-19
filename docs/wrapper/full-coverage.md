# MapKit Full coverage

This inventory compares the native SDK's Lite and Full artifacts at **4.45.0**. It records the work
needed to make the Full API available in common Kotlin. Check the [release notes][releases] for
features shipped in a particular wrapper version. At this inventory's baseline the released wrapper
is Lite. The [Full packaging checks][77] launched standalone [Android][full-android-ci] and
[iOS][full-ios-ci] consumers and created a native `ONLINE` search manager from common Kotlin.
The candidate also supports [text queries](full-text-search.md), results and cancellation.

The comparison uses the Android AARs for `com.yandex.android:maps.mobile` and the iOS
`YandexMapsMobile` CocoaPods XCFrameworks for `4.45.0-lite` and `4.45.0-full`. Native names below come
from `classes.jar` and the device slice's `Headers`. The [Android guide][android-setup],
[iOS guide][ios-setup] and [SDK changelog][sdk-versions] describe the product editions.

## Coverage by family

**Planned** means an implementation issue exists. **Partial** refers to the candidate Full
wrapper and names the part it exercises. **Platform** means the native type stays on its own
platform, or a supported caller still needs to be verified. Native declarations alone do not
establish service access.

| Family | Android entry points | iOS entry points | Common Kotlin status |
| --- | --- | --- | --- |
| Text search | `search.SearchFactory`, `Search.createSearchManager`, `SearchManager.submit(String, Geometry, …)`, `Session`, `Response` | `YMKSearchFactory`, `YMKSearch.createSearchManagerWithSearchManagerType:`, `YMKSearchManager.submitWithText:geometry:searchOptions:responseHandler:`, `YMKSearchSession`, `YMKSearchResponse` | **Partial** in [#78][78]. The [common API](full-text-search.md) submits text for an area, decodes results and errors, and cancels a pending session. |
| Autocomplete | `SearchManager.createSuggestSession`, `SuggestSession.suggest`, `reset` | `YMKSearchManager.createSuggestSession`, `YMKSearchSuggestSession.suggestWithText:window:suggestOptions:responseHandler:`, `reset` | **Partial** in [#79][79]. The [common API](full-text-search.md#suggestions-while-typing) exposes text suggestions, session reset and request replacement. |
| Reverse geocoding | `SearchManager.submit(Point, Integer, …)`, `ToponymObjectMetadata`, `Address` | `YMKSearchManager.submitWithPoint:zoom:searchOptions:responseHandler:`, `YMKSearchToponymObjectMetadata`, `YMKSearchAddress` | **Planned** in [#95][95]. This uses the existing search family. The zoom is nullable on both platforms. |
| Search layers and advanced results | `Search.createSearchLayer`, `search.search_layer.SearchLayer`, `SearchManager.searchByURI`, `searchByBusinessOids`, along-polyline `submit` | `YMKSearch.createSearchLayerWithMapWindow:`, `YMKSearchLayer`, `YMKSearchManager.searchByURIWithUri:…`, `searchByBusinessOidsWithBusinessOids:…`, `submitWithText:polyline:…` | **Planned** in [#96][96]. Includes filtered business results, marker assets and layer callbacks. [Native layer reference][native-search-layer] |
| Driving | `directions.DirectionsFactory`, `Directions.createDrivingRouter`, `directions.driving.{DrivingRouter, DrivingSession, DrivingRoute}` | `YMKDirectionsFactory`, `YMKDirections.createDrivingRouterWithType:`, `YMKDriving{Router,Session,Route}` | **Partial** in [#80][80]. [Common driving routing](full-routing.md) forwards ordered points and options, delivers alternatives with geometry, and cancels the current session. Summaries, external route matching and additional metadata are available through the native SDK. |
| Walking, cycling and public transit | `transport.TransportFactory`, `Transport.createPedestrianRouter`, `createBicycleRouterV2`, `createMasstransitRouter`; `transport.masstransit` sessions and route data | `YMKTransportFactory`, `YMKTransport.createPedestrianRouter`, `createBicycleRouterV2`, `createMasstransitRouter`; `YMKPedestrianRouter`, `YMKBicycleRouterV2`, `YMKMasstransit{Router,Session,Route}` | **Partial** in [#80][80]. [Common transport routing](full-routing.md) provides all three factories, route sections and session retry and cancellation. [Adapter checks](full-routing.md#regression-checks) cover native filter values, metadata and callback ownership. The separate `transport.bicycle` classes and `YMKBicycleRouter` implement the deprecated V1 path. |
| Route summaries, micromobility, serialization and presentation | `Transport.createScooterRouter`, `createElectricBikeRouter`, `transport.time.AdjustedClock`, `MasstransitRouteSerializer`, `DrivingJamsPainter`, `RouteHelper`, `annotations.Speaker` | `YMKTransport.createScooterRouter`, `createElectricBikeRouter`, `YMKAdjustedClock`, `YMKMasstransitRouteSerializer`, `YMKMasstransitDrivingJamsPainter`, `YMKRouteHelper`, `YMKSpeaker` | **Planned** follow-up [#101][101] after the basic request modes. |
| Panorama service, player and map overlay | `places.PlacesFactory`, `Places.createPanoramaService`, `createPanoramaLayer`, `PanoramaService.findNearest`, `places.panorama.Player`, `PanoramaView` | `YMKPlacesFactory`, `YMKPlaces.createPanoramaService`, `createPanoramaLayerWithMapWindow:`, `YMKPanoramaService.findNearestWithPosition:searchHandler:`, `YMKPanoramaPlayer`, `YMKPanoView` | **Planned** in [#97][97] for shared lookup and player behavior. **Platform** for the Android view and iOS UIView hosts. [Native lookup reference][native-panorama] |
| MRC photo and track players | `Places.createMrcPhotoPlayer`, `createMrcPhotoTrackPlayer`, `places.mrc.MrcPhoto{Player,TrackPlayer,View,TrackView}` | `YMKPlaces.createMrcPhotoPlayerWithPlatformView:`, `createMrcPhotoTrackPlayerWithPlatformView:`, `YMKMrcPhoto{Player,TrackPlayer,View,TrackView}` | **Platform** in the inventory. [#97][97] tracks a supported loading path and sample assets before exposing these players. |
| Parking and road events | `Directions.createCarparksLayer`, `directions.carparks.CarparksLayer`, `MapKit.createRoadEventsManager`, `road_events.RoadEventsManager`, `road_events_layer.StyleProvider` | `YMKDirections.createCarparksLayerWithMapWindow:`, `YMKCarparksLayer`, `YMKMapKit.createRoadEventsManager`, `YMKRoadEventsManager`, `YMKRoadEventsLayerStyleProvider` | **Planned** in [#98][98] for parking and event details. The style types need a supported MapKit Full attachment path before wrapping. |
| Account and personalized search | `MapKit.setAccount`, `com.yandex.runtime.auth.{Account,TokenListener}`, `search.DeleteAllPersonalSuggestSession` | `YMKMapKit.setAccount:`, `YRTAccount`, `YRTTokenDelegate`, `YMKSearchDeleteAllPersonalSuggestSession` | **Planned** account adapter in [#99][99]. The delete session is declared with no creation entry point on the inspected public search factories. |
| Offscreen capture | `MapKit.createOffscreenMapWindow`, `OffscreenMapWindow.captureScreenshot` → `Bitmap` | `YMKMapKit.createOffscreenMapWindowWithWidth:height:`, `YMKOffscreenMapWindow.captureScreenshot` → `UIImage` | **Planned** in [#100][100]. Both factory variants accept dimensions and an optional scale-factor overload. **Platform** for the native image returned by capture. [Native offscreen guide][native-offscreen] |

The Lite artifacts already declare `OffscreenMapWindow` and `RoadEventsManager` and their iOS
counterparts. Full adds the factories that hand those handles out, plus the account setter.
The [SDK changelog][sdk-versions] mentions bookmarks. This comparison found no bookmark entry point
in the pinned MapKit artifacts. Confirm the appropriate artifact before promising a wrapper.
The [NaviKit setup][navikit] uses a separate edition for active navigation and guidance.

## Scenarios and verification

For the planned work below, use controlled fixtures to test mapping, lifecycle and cancellation
on both platforms. The trusted [service checks][82] track tests that require provider data
or credentials.

| Uncovered behavior | Required inputs | Acceptance check |
| --- | --- | --- |
| Live search and suggestion service [#82][82] | A Full key, a known query and viewport | Validate result and error delivery for text search, and validate suggestion response fields independently of provider ranking. [Android search][android-search] · [iOS search][ios-search] |
| Geocoding and advanced search [#95][95] [#96][96] | A fixed coordinate, controlled result/marker assets, and known provider URI/ID for live lookup | Map to an optional structured address. Select and clear a result layer, page where supported and detach its callbacks when the map closes. |
| Routes and route utility APIs [#80][80] [#101][101] | Fixed waypoints, geometry/metadata fixtures and live mode coverage in the target region | Draw a route, replace and cancel the request, and validate no-route delivery and supported modes. Check summary and serialization round-trips separately. [Native routing guide][android-routes] |
| Panorama and place imagery [#97][97] | Fixed panorama identifier or controlled session; a known photo/track asset for any verified MRC path | Resolve the nearest panorama and close the player safely, including error and cancellation. Verify a real photo/track loading path before wrapping either MRC player. |
| Parking and road events [#98][98] | Fixed style, controlled event response and supported live map/event data | Toggle and reset parking styling. Request details, handle success/error/cancel and detach any supported styling callback. |
| Account integration [#99][99] | A fake account with no real credentials in PR CI; trusted credentials only if validating real authenticated service behavior | Install and clear the account. Verify token success/failure and invalidation adapters without logging tokens. |
| Offscreen maps [#100][100] | Fixed-size map window and local marker or geometry | Render without a visible map view. Check output dimensions, scale/cleanup and the two native image types. |

## Repeat the comparison on an SDK upgrade

1. Read the version from `gradle/libs.versions.toml`. Obtain the two exact AARs and the two exact
   CocoaPods XCFrameworks for the same native version. Check the dependency resolution and
   `Podfile.lock` against the [Android][android-setup] and [iOS][ios-setup] setup guides.
2. In a scratch directory, set `version` to the native version and `lite_headers`/`full_headers`
   to the two `ios-arm64/YandexMapsMobile.framework/Headers` paths. Compare top-level Android
   types and shared signatures, then compare iOS headers.

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

3. Compare those boundaries with the wrapper's common source and ABI for the release being
   documented. Update both languages and link a test or follow-up for each changed family.
   Names marked undocumented or with no supported factory need a verified caller before gaining
   a common API. Keep real service entitlement and asset requirements in the relevant tests.

At 4.45.0 this yields **286** extra Android top-level declarations in **14** packages and **141**
additional iOS header filenames. The shared iOS header with a declaration change is
`YMKMapkit.h`. The added Android signatures on shared top-level types are in `MapKit`.
These counts describe different units. To review a specific addition, inspect the relevant
`javap -public` output, including any nested callback types, and the actual iOS declaration
rather than inferring behavior from a filename.

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
