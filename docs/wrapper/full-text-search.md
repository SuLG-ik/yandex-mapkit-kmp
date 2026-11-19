# Full text search

Use a `SearchManager` to search a geographic area by text from common Kotlin. MapKit returns
organizations and toponyms as [geo objects](geoobjects.md). An empty result collection is a
successful response.

## Installation

Add the Full wrapper. Use the matching `-full` coordinates for every optional wrapper module
your app uses.

```kotlin
commonMain.dependencies {
    implementation("ru.sulgik.mapkit:yandex-mapkit-kmp-full:{{ version }}")
}
```

Android resolves `com.yandex.android:maps.mobile:{{ mapkit_version_full }}` through the wrapper.
On iOS, pin `YandexMapsMobile` to the matching Full SDK in the shared module and Xcode app.

```kotlin
cocoapods {
    ios.deploymentTarget = "15.0"
    pod("YandexMapsMobile") {
        version = "{{ mapkit_version_full }}"
        packageName = "YandexMapKit"
    }
}
```

Use the [platform initialization steps](../getting-started/quick-start.md) and an active MapKit
key. The [consumer fixture] verifies Full installation and manager creation without a live query.

## Run a query

An owned screen model stores the manager and the active session. On the UI thread, submit the query
with a point, a bounding box, a polyline, or a rectangular polygon. A rectangular polygon needs four
corner points, with an optional closing point and no interior rings.

```kotlin
val manager = Search.getInstance().createSearchManager(SearchManagerType.ONLINE)
val area = BoundingBox(southWest, northEast).toGeometry()
val session = manager.submit(
    text = "coffee",
    geometry = area,
    searchOptions = SearchOptions(searchTypes = SearchType.BIZ.value, geometry = true),
    searchListener = SearchListener(
        onSearchResponse = { response ->
            val places = response.collection.children.mapNotNull { it.obj }
            showPlaces(places.mapNotNull { obj ->
                val name = obj.name
                val point = obj.geometry.firstNotNullOfOrNull { it.point }
                if (name != null && point != null) name to point else null
            })
        },
        onSearchError = { error -> showFailure(error.description ?: "Search failed") },
    ),
)
```

Store `session` in a field. Cancel it before replacing the query and on screen disposal. The wrapper
holds the listener while the request is pending and clears it on completion or cancellation. A
native callback arriving after cancellation is ignored. The cancellation guard also applies when
calling `cancel()` on a common handle converted back from the same native session. Callbacks run on
the UI thread.

`SearchError.error` exposes the typed MapKit error on Android and on iOS when the SDK attaches one.
`SearchError.description` exposes the iOS message. The [compiled consumer example] retains each
session, discards results from a superseded query, and reads places in nested collections.

The common API currently covers the initial text request and cancellation. The platform methods
are available through `toNative()`. See the [Android search guide] and [iOS search guide] for
provider behavior.

## Regression checks

The [Android adapter test] and [iOS adapter test] supply responses locally. They check options,
named coordinates, empty responses, native errors and late callbacks after disposal. The
[Full consumer workflow] also builds and launches the separate app on Android and iOS.

[consumer fixture]: https://github.com/SuLG-ik/yandex-mapkit-kmp/tree/main/verification/lite-consumer
[compiled consumer example]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullTextSearchExample.kt
[Android search guide]: https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_search.html
[iOS search guide]: https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_search.html
[Android adapter test]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullAndroidHostTest/kotlin/ru/sulgik/mapkit/search/SearchAdapterTest.kt
[iOS adapter test]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/yandex-mapkit-kmp/src/fullIosTest/kotlin/ru/sulgik/mapkit/search/SearchAdapterTest.kt
[Full consumer workflow]: https://github.com/SuLG-ik/yandex-mapkit-kmp/actions/workflows/full-consumer.yml
