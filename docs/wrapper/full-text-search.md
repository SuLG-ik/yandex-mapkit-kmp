# Full text search

Use a `SearchManager` to search a geographic area by text from common Kotlin. MapKit returns
organizations and toponyms as [geo objects](geoobjects.md). An empty result collection is a
successful response.

## Installation

The Full wrapper is an unreleased candidate. The [consumer fixture] builds its artifacts into
a temporary Maven repository and resolves them there. Start an Android emulator or iOS simulator,
then run the corresponding command from the repository root. Substitute the ID from `adb devices`
or `xcrun simctl list devices booted`.

```sh
bash verification/lite-consumer/run.sh android emulator-5554 with-integrations full
bash verification/lite-consumer/run.sh ios SIMULATOR_UUID with-integrations full
```

The fixture resolves the matching `-full` coordinates for the core wrapper and optional modules.
It uses `com.yandex.android:maps.mobile:{{ mapkit_version_full }}` on Android and
`YandexMapsMobile ({{ mapkit_version_full }})` with CocoaPods on iOS. It verifies installation
and manager creation without a live query. For a live query in your app, use the
[platform initialization steps](../getting-started/quick-start.md) and an active MapKit key.

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

## Suggestions while typing

On the UI thread, use one `manager.createSuggestSession()` per query editor. Hold the session while
the editor is open, and pass the visible map window as a `BoundingBox` on every call.

```kotlin
session.suggest(
    text = query,
    window = window,
    suggestOptions = SuggestOptions(
        suggestTypes = SuggestType.GEO.value or SuggestType.BIZ.value,
        strictBounds = true,
    ),
    suggestListener = SuggestListener(
        onResponse = { response -> showSuggestions(response.items) },
        onError = { failure -> showFailure(failure.description ?: "Suggestions unavailable") },
    ),
)
```

A new `suggest()` replaces the pending request. The wrapper keeps its listener until it receives a
response, receives an error, or discards the request. Call `reset()` when the query is cleared or
the editor closes. MapKit then starts a new backend session on the next query. The
[Full suggestions example] clears visible results on edit and uses a query generation to keep a
superseded reply from overwriting newer UI state. Reopening creates a new editor and session.

An empty item list is a successful response. Display `item.displayText ?: item.title.text`.
`title.spans` contains highlight ranges, and `center` and `distance` are optional. When the user
selects an item, use `item.action` to choose between submitting `searchText`, substituting it in
the editor, or following `link`. Use a MapKit key for a live query. The Full consumer smoke only
creates and resets a session, and the adapter tests supply deterministic replies. See the official
[Android Geosuggest guide] and [iOS Geosuggest guide].

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
[Full suggestions example]: https://github.com/SuLG-ik/yandex-mapkit-kmp/blob/main/verification/lite-consumer/shared/src/fullMain/kotlin/ru/sulgik/liteconsumer/FullSuggestionsExample.kt
[Android Geosuggest guide]: https://yandex.com/maps-api/docs/mapkit/android/generated/tutorials/map_suggest.html
[iOS Geosuggest guide]: https://yandex.com/maps-api/docs/mapkit/ios/generated/tutorials/map_suggest.html
