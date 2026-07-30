---
title: "Session"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Session"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Session.html"
---
# Session

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Session.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface Session`

Interface denoting ongoing search session.

Allows search cancellation and retry.  For many request types allows further searches.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Cancels the current request. |
| `void` | `retry(@NonNull SearchListener searchListener)`<br>Retries the last request. |
| `boolean` | `hasNextPage()`<br>Check the availability of the next result page. |
| `void` | `fetchNextPage(@NonNull SearchListener searchListener)`<br>Request the next page of search results. |
| `void` | `setFilters(@NonNull java.util.List<BusinessFilter> filters)` |
| `void` | `setSortByDistance(@NonNull Geometry origin)`<br>Requests sorting by distance for future resubmits. |
| `void` | `resetSort()`<br>Resets the sort if it was previously set (for example by [mapkit.search.Session#setSortByDistance(Geometry)](Session.md#setsortbydistancegeometry)) for future resubmits. |
| `void` | `setSearchArea(@NonNull Geometry area)`<br>Sets the search area for future resubmits. |
| `void` | `setSearchOptions(@NonNull SearchOptions searchOptions)`<br>Set searchOptions for future resubmits. |
| `void` | `resubmit(@NonNull SearchListener searchListener)`<br>Redo the last search with currently set values of search area, search options, filters, sort type and sort origin. |

## Methods

### cancel

```java
void cancel()
```

Cancels the current request.

### retry

```java
void retry(@NonNull SearchListener searchListener)
```

Retries the last request.

If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| `searchListener` | Listener to handle search result. |

### hasNextPage

```java
boolean hasNextPage()
```

Check the availability of the next result page.

**Returns**

True if there are more search results and one can call [mapkit.search.Session#fetchNextPage(SearchListener)](Session.md#fetchnextpagesearchlistener), false otherwise.

### fetchNextPage

```java
void fetchNextPage(@NonNull SearchListener searchListener)
```

Request the next page of search results.

Ignored if the current request isn't ready. Will throw if called when **search.Session#hasNextPage()** is false.

| Parameters |   |
| --- | --- |
| `searchListener` | Listener to handle search result. |

### setFilters

```java
@Deprecated
void setFilters(@NonNull java.util.List<BusinessFilter> filters)
```

> [!CAUTION] Внимание
> Use **SearchOptions#filters** instead.

### setSortByDistance

```java
void setSortByDistance(@NonNull Geometry origin)
```

Requests sorting by distance for future resubmits.

Supported geometry types: point, polyline.

| Parameters |   |
| --- | --- |
| `origin` | Origin to sort by distance from. |

### resetSort

```java
void resetSort()
```

Resets the sort if it was previously set (for example by [mapkit.search.Session#setSortByDistance(Geometry)](Session.md#setsortbydistancegeometry)) for future resubmits.

### setSearchArea

```java
void setSearchArea(@NonNull Geometry area)
```

Sets the search area for future resubmits.

Supported geometry types: bounding box, polyline, polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if last point is equal to first) and no inner rings.

| Parameters |   |
| --- | --- |
| `area` | Search area for future resubmits. |

### setSearchOptions

```java
void setSearchOptions(@NonNull SearchOptions searchOptions)
```

Set searchOptions for future resubmits.

| Parameters |   |
| --- | --- |
| `searchOptions` | Additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md). Supported options: [mapkit.search.SearchOptions#origin](SearchOptions.md#origin), [mapkit.search.SearchOptions#userPosition](SearchOptions.md#userposition). |

### resubmit

```java
void resubmit(@NonNull SearchListener searchListener)
```

Redo the last search with currently set values of search area, search options, filters, sort type and sort origin.

Isn't applicable to reverse geosearch and URI resolving. Ignored it the current request is the first one; cancels current request otherwise.

| Parameters |   |
| --- | --- |
| `searchListener` | Listener to handle search result. |
