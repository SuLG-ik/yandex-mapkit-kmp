---
title: "SearchLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search.search_layer"
section: "Android / Справочник / com.yandex.mapkit.search.search_layer / SearchLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchLayer.html"
---
# SearchLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/search_layer/SearchLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search.search_layer

`interface SearchLayer`

The search layer handles the map search requests and displays the results on the map automatically.

It also handles the map movements and resubmits searches when needed.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `submitQuery(@NonNull java.lang.String query, @NonNull SearchOptions searchOptions)`<br>Submit search query with search options. |
| `void` | `submitQuery(@NonNull java.lang.String query, @NonNull Geometry geometry, @NonNull SearchOptions searchOptions)`<br>Submit search query with search options near provided geometry. |
| `void` | `searchByUri(@NonNull java.lang.String uri, @NonNull SearchOptions searchOptions)`<br>Submit search request for URI resolution. |
| `void` | `resubmit()`<br>Manual resubmit. |
| `void` | `enableRequestsOnMapMoves(boolean enable)`<br>Enable or disable search requests (resubmits and submits) when the map is moved. |
| `void` | `enableMapMoveOnSearchResponse(boolean enable)`<br>Enable or disable moving the map on primary search response. |
| `boolean` | `hasNextPage()`<br>Check if more results could be loaded. |
| `void` | `fetchNextPage()`<br>Load the next page of results. |
| `void` | `clear()`<br>Clear the displayed search results from the map. |
| `java.util.List<SearchResultItem>` | `getSearchResultsList()`<br>Get the list of search results. |
| `SearchMetadata` | `searchMetadata()`<br>Get the last search response metadata. |
| `void` | `setSearchManager(@NonNull SearchManager searchManager)`<br>Set the search manager. |
| `void` | `addSearchResultListener(@NonNull SearchResultListener searchResultListener)`<br>Add the search result listener, which will receive notifications from the search layer. |
| `void` | `removeSearchResultListener(@NonNull SearchResultListener searchResultListener)`<br>Remove search result listener. |
| `void` | `addPlacemarkListener(@NonNull PlacemarkListener placemarkListener)`<br>Add a placemark listener, which will receive notifications from the search layer. |
| `void` | `removePlacemarkListener(@NonNull PlacemarkListener placemarkListener)`<br>Remove placemark listener |
| `void` | `setSortByDistance(@NonNull Geometry origin)`<br>Set sort order of the results by distance from given geometry. |
| `void` | `setPolylinePosition(@NonNull PolylinePosition position)`<br>When sorting by distance from polyline sets position on this polyline. |
| `void` | `resetSort()`<br>Reset the sort if it was previously set. |
| `void` | `setFilterCollection(@Nullable FilterCollection filters)`<br>Set search filters. |
| `void` | `setFilters(@NonNull java.util.List<BusinessFilter> filters)` |
| `void` | `setAssetsProvider(@NonNull AssetsProvider provider)`<br>Set a custom assets provider, which provides images, sizes and icon styles for placemarks. |
| `void` | `resetAssetsProvider()`<br>Reset the assets provider to default. |
| `void` | `selectPlacemark(@NonNull java.lang.String geoObjectId)`<br>Select the placemark by ID. |
| `java.lang.String` | `selectedPlacemarkId()`<br>Selected placemark ID. |
| `void` | `deselectPlacemark()`<br>Deselect all placemarks. |
| `void` | `forceUpdateIcon(@NonNull java.lang.String geoObjectId, @NonNull PlacemarkIconType iconType, @NonNull ImageProvider image, @NonNull IconStyle style)`<br>Update the icon image for each suitable placemark. |
| `void` | `forceUpdateMapObjects()`<br>Force reloading all visible pins from AssetProvider. |
| `void` | `obtainAdIcons(boolean enable)`<br>If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider. |
| `void` | `setInsets(int top, int left, int bottom, int right)`<br>Apply insets (in pixels) to the screen. |
| `boolean` | `isVisible()`<br>Search layer visibility. |
| `void` | `setVisible(boolean visible)` |
| `boolean` | `isValid()`<br>Tells if this **SearchLayer** is valid or not. |

## Methods

### submitQuery

```java
void submitQuery(@NonNull java.lang.String query,
                 @NonNull SearchOptions searchOptions)
```

Submit search query with search options.

| Parameters |   |
| --- | --- |
| `query` | User query |
| `searchOptions` | Search options |

### submitQuery

```java
void submitQuery(@NonNull java.lang.String query,
                 @NonNull Geometry geometry,
                 @NonNull SearchOptions searchOptions)
```

Submit search query with search options near provided geometry.

| Parameters |   |
| --- | --- |
| `query` | User query. |
| `geometry` | Geometry to search near. Supported types: point, bounding box, polyline and polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to the first) and no inner rings. |
| `searchOptions` | Search options. |

### searchByUri

```java
void searchByUri(@NonNull java.lang.String uri,
                 @NonNull SearchOptions searchOptions)
```

Submit search request for URI resolution.

Allows multiple objects in response.

| Parameters |   |
| --- | --- |
| `uri` | Object URI. |
| `searchOptions` | Additional search parameters. See [mapkit.search.SearchOptions](../SearchOptions.md) definition for details, and 'searchByURI' method in [mapkit.search.SearchManager](../SearchManager.md) for currently supported options. |

### resubmit

```java
void resubmit()
```

Manual resubmit.

### enableRequestsOnMapMoves

```java
void enableRequestsOnMapMoves(boolean enable)
```

Enable or disable search requests (resubmits and submits) when the map is moved.

Requests are enabled by default.

| Parameters |   |
| --- | --- |
| `enable` | Enable requests if true, disable otherwise. |

### enableMapMoveOnSearchResponse

```java
void enableMapMoveOnSearchResponse(boolean enable)
```

Enable or disable moving the map on primary search response.

Map moving is enabled by default.

| Parameters |   |
| --- | --- |
| `enable` | Enable map moving if true, disable otherwise. |

### hasNextPage

```java
boolean hasNextPage()
```

Check if more results could be loaded.

### fetchNextPage

```java
void fetchNextPage()
```

Load the next page of results.

### clear

```java
void clear()
```

Clear the displayed search results from the map.

### getSearchResultsList

```java
@NonNull
java.util.List<SearchResultItem> getSearchResultsList()
```

Get the list of search results.

### searchMetadata

```java
@Nullable
SearchMetadata searchMetadata()
```

Get the last search response metadata.

### setSearchManager

```java
void setSearchManager(@NonNull SearchManager searchManager)
```

Set the search manager.

Do not use this method; it is for internal use only.

| Parameters |   |
| --- | --- |
| `searchManager` | Search manager |

### addSearchResultListener

```java
void addSearchResultListener(@NonNull SearchResultListener searchResultListener)
```

Add the search result listener, which will receive notifications from the search layer.

The class does not retain the object in the 'searchResultListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `searchResultListener` | Search result listener to add. |

### removeSearchResultListener

```java
void removeSearchResultListener(@NonNull SearchResultListener searchResultListener)
```

Remove search result listener.

| Parameters |   |
| --- | --- |
| `searchResultListener` | Search result listener to remove. |

### addPlacemarkListener

```java
void addPlacemarkListener(@NonNull PlacemarkListener placemarkListener)
```

Add a placemark listener, which will receive notifications from the search layer.

The class does not retain the object in the 'placemarkListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `placemarkListener` | Placemark listener to add. |

### removePlacemarkListener

```java
void removePlacemarkListener(@NonNull PlacemarkListener placemarkListener)
```

Remove placemark listener

| Parameters |   |
| --- | --- |
| `placemarkListener` | Placemark listener to remove. |

### setSortByDistance

```java
void setSortByDistance(@NonNull Geometry origin)
```

Set sort order of the results by distance from given geometry.

### setPolylinePosition

```java
void setPolylinePosition(@NonNull PolylinePosition position)
```

When sorting by distance from polyline sets position on this polyline.

Has the same effect as sorting by distance from the sub-polyline from `position` to the end of the polyline. Throws if no polyline is set or position is out of range.

| Parameters |   |
| --- | --- |
| `position` | new polyline position value |

### resetSort

```java
void resetSort()
```

Reset the sort if it was previously set.

### setFilterCollection

```java
void setFilterCollection(@Nullable FilterCollection filters)
```

Set search filters.

| Parameters |   |
| --- | --- |
| `filters` | Business filters |

### setFilters

```java
@Deprecated
void setFilters(@NonNull java.util.List<BusinessFilter> filters)
```

> [!CAUTION] Внимание
> Use } instead.

### setAssetsProvider

```java
void setAssetsProvider(@NonNull AssetsProvider provider)
```

Set a custom assets provider, which provides images, sizes and icon styles for placemarks.

The class does not retain the object in the 'provider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `provider` | Assets provider (must not be null) |

### resetAssetsProvider

```java
void resetAssetsProvider()
```

Reset the assets provider to default.

### selectPlacemark

```java
void selectPlacemark(@NonNull java.lang.String geoObjectId)
```

Select the placemark by ID.

| Parameters |   |
| --- | --- |
| `geoObjectId` | Placemark identifier |

### selectedPlacemarkId

```java
@Nullable
java.lang.String selectedPlacemarkId()
```

Selected placemark ID.

**Returns**

Placemark identifier if any placemark is selected, otherwise none.

### deselectPlacemark

```java
void deselectPlacemark()
```

Deselect all placemarks.

### forceUpdateIcon

```java
void forceUpdateIcon(@NonNull java.lang.String geoObjectId,
                     @NonNull PlacemarkIconType iconType,
                     @NonNull ImageProvider image,
                     @NonNull IconStyle style)
```

Update the icon image for each suitable placemark.

If the placemark is not found, the image will be put in a queue and will be applied once when the placemark is created. This is not the normal way to set the image. It is highly advisable to return the right image from AssetsProvider.

| Parameters |   |
| --- | --- |
| `geoObjectId` | Placemark identifier |
| `iconType` | Icon type |
| `image` | Icon image |
| `style` | Icon style |

### forceUpdateMapObjects

```java
void forceUpdateMapObjects()
```

Force reloading all visible pins from AssetProvider.

Use when there is a reason to update ALL the icons simultaneously (for example icon theme change, day/night mode, and other). This can be a pretty expensive operation, as it wipes all the map objects off of the layer and creates them from scratch. Use only if absolutely necessary.

### obtainAdIcons

```java
void obtainAdIcons(boolean enable)
```

If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider.

| Parameters |   |
| --- | --- |
| `enable` | Enable mode if true, disable otherwise |

### setInsets

```java
void setInsets(int top,
               int left,
               int bottom,
               int right)
```

Apply insets (in pixels) to the screen.

If inset is not zero, search in the cut-off area will not be performed.

| Parameters |   |
| --- | --- |
| `top` | Top inset. |
| `left` | Left inset. |
| `bottom` | Bottom inset. |
| `right` | Right inset. |

### isVisible

```java
boolean isVisible()
```

Search layer visibility.

Visible by default. While the layer is invisible resubmits are not performed on map moves, but all the state changing methods (`submitQuery`, `resubmit`, `deselectPlacemark`, and other) are executed as usual.

### setVisible

```java
void setVisible(boolean visible)
```

### isValid

```java
boolean isValid()
```

Tells if this **SearchLayer** is valid or not.

Any other method (except for this one) called on an invalid **SearchLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
