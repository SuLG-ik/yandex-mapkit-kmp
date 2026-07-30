---
title: "SearchManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchManager.html"
---
# SearchManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchManager.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface SearchManager`

Main interface to start search.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Session` | `submit(@NonNull java.lang.String text, @NonNull Geometry geometry, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Search request for searching a user query near given geometry. |
| `Session` | `submit(@NonNull java.lang.String text, @NonNull Polyline polyline, @NonNull Geometry geometry, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Search request that is used to search for a user query along the given polyline inside the given window. |
| `Session` | `submit(@NonNull Point point, @Nullable java.lang.Integer zoom, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Reverse search request (to search objects at the given coordinates) |
| `Session` | `resolveURI(@NonNull java.lang.String uri, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Search request for URI resolution. |
| `Session` | `searchByURI(@NonNull java.lang.String uri, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Search request with URI. |
| `Session` | `searchByBusinessOids(@NonNull java.util.List<java.lang.String> businessOids, @NonNull SearchOptions searchOptions, @NonNull SearchListener searchListener)`<br>Search request for multiple business objects by their OIDs. |
| `SuggestSession` | `createSuggestSession()`<br>Creates session for suggest requests. |

## Methods

### submit

```java
@NonNull
Session submit(@NonNull java.lang.String text,
               @NonNull Geometry geometry,
               @NonNull SearchOptions searchOptions,
               @NonNull SearchListener searchListener)
```

Search request for searching a user query near given geometry.

| Parameters |   |
| --- | --- |
| `text` | User query. |
| `geometry` | Geometry to search near. Supported types: point, bounding box, polyline and polygon. If the polyline is provided, setSortByDistance(polyline) is assumed on the first request. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to the first) and no inner rings. |
| `searchOptions` | Various additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows further searches, cancel and retry.

### submit

```java
@NonNull
Session submit(@NonNull java.lang.String text,
               @NonNull Polyline polyline,
               @NonNull Geometry geometry,
               @NonNull SearchOptions searchOptions,
               @NonNull SearchListener searchListener)
```

Search request that is used to search for a user query along the given polyline inside the given window.

| Parameters |   |
| --- | --- |
| `text` | User query. |
| `polyline` | Polyline to search near; } is assumed on the first request. |
| `geometry` | Geometry to search near; supported types: point, bounding box, polyline and polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to first) and no inner rings. |
| `searchOptions` | Various additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows further searches, cancel and retry. Session should be stored by user or search is automatically cancelled.

### submit

```java
@NonNull
Session submit(@NonNull Point point,
               @Nullable java.lang.Integer zoom,
               @NonNull SearchOptions searchOptions,
               @NonNull SearchListener searchListener)
```

Reverse search request (to search objects at the given coordinates)

| Parameters |   |
| --- | --- |
| `point` | Coordinates to search at. |
| `zoom` | Current zoom level. Skips objects that are too small for a given zoom level. |
| `searchOptions` | Additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. Currently the only supported options are [mapkit.search.SearchOptions#origin](SearchOptions.md#origin), [mapkit.search.SearchOptions#searchTypes](SearchOptions.md#searchtypes) and [mapkit.search.SearchOptions#snippets](SearchOptions.md#snippets). Only 'geo' and 'biz' types are supported and not at the same time. |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows further searches, cancel and retry. Session should be stored by user or search is automatically cancelled.

### resolveURI

```java
@NonNull
Session resolveURI(@NonNull java.lang.String uri,
                   @NonNull SearchOptions searchOptions,
                   @NonNull SearchListener searchListener)
```

Search request for URI resolution.

| Parameters |   |
| --- | --- |
| `uri` | Object uri. |
| `searchOptions` | Additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. Currently the only supported options are [mapkit.search.SearchOptions#origin](SearchOptions.md#origin) and [mapkit.search.SearchOptions#snippets](SearchOptions.md#snippets). |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows search cancel and retry. Should be stored by user or search is automatically cancelled.

### searchByURI

```java
@NonNull
Session searchByURI(@NonNull java.lang.String uri,
                    @NonNull SearchOptions searchOptions,
                    @NonNull SearchListener searchListener)
```

Search request with URI.

Allows multiple results in response.

| Parameters |   |
| --- | --- |
| `uri` | Object uri. |
| `searchOptions` | Additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. Currently the only supported options are [mapkit.search.SearchOptions#origin](SearchOptions.md#origin), [mapkit.search.SearchOptions#snippets](SearchOptions.md#snippets), [mapkit.search.SearchOptions#resultPageSize](SearchOptions.md#resultpagesize), [mapkit.search.SearchOptions#similarOrgsRequest](SearchOptions.md#similarorgsrequest), [mapkit.search.SearchOptions#searchArea](SearchOptions.md#searcharea), [mapkit.search.SearchOptions#overriddenSerpId](SearchOptions.md#overriddenserpid), [mapkit.search.SearchOptions#discovery](SearchOptions.md#discovery) and [mapkit.search.SearchOptions#toponymDiscoveryGeoId](SearchOptions.md#toponymdiscoverygeoid). |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows search cancel and retry. Should be stored by user or search is automatically cancelled.

### searchByBusinessOids

```java
@NonNull
Session searchByBusinessOids(@NonNull java.util.List<java.lang.String> businessOids,
                             @NonNull SearchOptions searchOptions,
                             @NonNull SearchListener searchListener)
```

Search request for multiple business objects by their OIDs.

| Parameters |   |
| --- | --- |
| `businessOids` | List of business object identifiers (OIDs). |
| `searchOptions` | Additional search parameters, see [mapkit.search.SearchOptions](SearchOptions.md) definition for details. Currently the only supported options are [mapkit.search.SearchOptions#origin](SearchOptions.md#origin), [mapkit.search.SearchOptions#snippets](SearchOptions.md#snippets) and [mapkit.search.SearchOptions#resultPageSize](SearchOptions.md#resultpagesize). |
| `searchListener` | Listener to handle search result. |

**Returns**

[mapkit.search.Session](Session.md) which allows search cancel and retry. Should be stored by user or search is automatically cancelled.

### createSuggestSession

```java
@NonNull
SuggestSession createSuggestSession()
```

Creates session for suggest requests.
