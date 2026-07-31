---
title: "SearchResultListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / SearchResultListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchResultListener.html"
---
# SearchResultListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchResultListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

`interface SearchResultListener`

Interface for callbacks on search events.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onSearchStart(@NonNull RequestType requestType)`<br>Called when the search starts. |
| `void` | `onSearchSuccess(@NonNull RequestType requestType)`<br>Called after a succesful search. |
| `void` | `onSearchError(@NonNull Error error, @NonNull RequestType requestType)`<br>Called on any search error. |
| `void` | `onPresentedResultsUpdate()`<br>Called when presented results are updated and thus search results list can change. |
| `void` | `onAllResultsClear()`<br>Called before all results are cleared. |

## Methods

### onSearchStart

```java
@UiThread
void onSearchStart(@NonNull RequestType requestType)
```

Called when the search starts.

| Parameters |   |
| --- | --- |
| `requestType` | Type of the started request. |

### onSearchSuccess

```java
@UiThread
void onSearchSuccess(@NonNull RequestType requestType)
```

Called after a succesful search.

| Parameters |   |
| --- | --- |
| `requestType` | Type of the finished request. |

### onSearchError

```java
@UiThread
void onSearchError(@NonNull Error error,
                   @NonNull RequestType requestType)
```

Called on any search error.

| Parameters |   |
| --- | --- |
| `error` | Error occured. |
| `requestType` | Type of the finished request. |

### onPresentedResultsUpdate

```java
@UiThread
void onPresentedResultsUpdate()
```

Called when presented results are updated and thus search results list can change.

### onAllResultsClear

```java
@UiThread
void onAllResultsClear()
```

Called before all results are cleared.
