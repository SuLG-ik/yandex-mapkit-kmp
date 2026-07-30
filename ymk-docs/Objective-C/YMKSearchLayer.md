---
title: "YMKSearchLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayer.html"
---
# YMKSearchLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchLayer : NSObject
```

The search layer handles the map search requests and displays the results on the map automatically. It also handles the map movements and resubmits searches when needed.

## Summary

### Instance methods

```objectivec
- (void)submitQueryWithQuery:(nonnull NSString *)query
               searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search query with search options

```objectivec
- (void)submitQueryWithQuery:(nonnull NSString *)query
                    geometry:(nonnull YMKGeometry *)geometry
               searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search query with search options near provided geometry

```objectivec
- (void)searchByUriWithUri:(nonnull NSString *)uri
             searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search request for URI resolution

```objectivec
- (void)resubmit;
```

Manual resubmit

```objectivec
- (void)enableRequestsOnMapMovesWithEnable:(BOOL)enable;
```

Enable or disable search requests (resubmits and submits) when the map is moved

```objectivec
- (void)enableMapMoveOnSearchResponseWithEnable:(BOOL)enable;
```

Enable or disable moving the map on primary search response

```objectivec
- (BOOL)hasNextPage;
```

Check if more results could be loaded

```objectivec
- (void)fetchNextPage;
```

Load the next page of results

```objectivec
- (void)clear;
```

Clear the displayed search results from the map

```objectivec
- (nonnull NSArray<YMKSearchResultItem *> *)getSearchResultsList;
```

Get the list of search results

```objectivec
- (nullable YMKSearchMetadata *)searchMetadata;
```

Get the last search response metadata

```objectivec
- (void)setSearchManagerWithSearchManager:
    (nonnull YMKSearchManager *)searchManager;
```

Set the search manager

```objectivec
- (void)addSearchResultListenerWithSearchResultListener:
    (nonnull id<YMKSearchLayerResponseHandler>)searchResultListener;
```

Add the search result listener, which will receive notifications from the search layer

```objectivec
- (void)removeSearchResultListenerWithSearchResultListener:
    (nonnull id<YMKSearchLayerResponseHandler>)searchResultListener;
```

Remove search result listener

```objectivec
- (void)addPlacemarkListenerWithPlacemarkListener:
    (nonnull id<YMKSearchLayerTapHandler>)placemarkListener;
```

Add a placemark listener, which will receive notifications from the search layer

```objectivec
- (void)removePlacemarkListenerWithPlacemarkListener:
    (nonnull id<YMKSearchLayerTapHandler>)placemarkListener;
```

Remove placemark listener

```objectivec
- (void)setSortByDistanceWithOrigin:(nonnull YMKGeometry *)origin;
```

Set sort order of the results by distance from given geometry

```objectivec
- (void)setPolylinePositionWithPosition:(nonnull YMKPolylinePosition *)position;
```

When sorting by distance from polyline sets position on this polyline

```objectivec
- (void)resetSort;
```

Reset the sort if it was previously set

```objectivec
- (void)setFilterCollectionWithFilters:
    (nullable YMKSearchFilterCollection *)filters;
```

Set search filters

```objectivec
- (void)setFiltersWithFilters:
    (nonnull NSArray<YMKSearchBusinessFilter *> *)filters;
```

search

```objectivec
- (void)setAssetsProviderWithProvider:(nonnull id<YMKAssetsProvider>)provider;
```

Set a custom assets provider, which provides images, sizes and icon styles for placemarks

```objectivec
- (void)resetAssetsProvider;
```

Reset the assets provider to default

```objectivec
- (void)selectPlacemarkWithGeoObjectId:(nonnull NSString *)geoObjectId;
```

Select the placemark by ID

```objectivec
- (nullable NSString *)selectedPlacemarkId;
```

Selected placemark ID

```objectivec
- (void)deselectPlacemark;
```

Deselect all placemarks

```objectivec
- (void)forceUpdateIconWithGeoObjectId:(nonnull NSString *)geoObjectId
                              iconType:(YMKPlacemarkIconType)iconType
                                 image:(nonnull UIImage *)image
                                 style:(nonnull YMKIconStyle *)style;
```

Update the icon image for each suitable placemark

```objectivec
- (void)forceUpdateMapObjects;
```

Force reloading all visible pins from AssetProvider

```objectivec
- (void)obtainAdIconsWithEnable:(BOOL)enable;
```

If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider

```objectivec
- (void)setInsetsWithTop:(NSUInteger)top
                    left:(NSUInteger)left
                  bottom:(NSUInteger)bottom
                   right:(NSUInteger)right;
```

Apply insets (in pixels) to the screen

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Search layer visibility

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### submitQueryWithQuery:searchOptions:

```objectivec
- (void)submitQueryWithQuery:(nonnull NSString *)query
               searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search query with search options.

| Parameters |   |
| --- | --- |
| query | User query |
| searchOptions | Search options |

### submitQueryWithQuery:geometry:searchOptions:

```objectivec
- (void)submitQueryWithQuery:(nonnull NSString *)query
                    geometry:(nonnull YMKGeometry *)geometry
               searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search query with search options near provided geometry.

| Parameters |   |
| --- | --- |
| query | User query. |
| geometry | Geometry to search near. Supported types: point, bounding box, polyline and polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to the first) and no inner rings. |
| searchOptions | Search options. |

### searchByUriWithUri:searchOptions:

```objectivec
- (void)searchByUriWithUri:(nonnull NSString *)uri
             searchOptions:(nonnull YMKSearchOptions *)searchOptions;
```

Submit search request for URI resolution. Allows multiple objects in response.

| Parameters |   |
| --- | --- |
| uri | Object URI. |
| searchOptions | Additional search parameters. See YMKSearchOptions definition for details, and 'searchByURI' method in YMKSearchManager for currently supported options. |

### resubmit

```objectivec
- (void)resubmit;
```

Manual resubmit.

### enableRequestsOnMapMovesWithEnable:

```objectivec
- (void)enableRequestsOnMapMovesWithEnable:(BOOL)enable;
```

Enable or disable search requests (resubmits and submits) when the map is moved. Requests are enabled by default.

| Parameters |   |
| --- | --- |
| enable | Enable requests if true, disable otherwise. |

### enableMapMoveOnSearchResponseWithEnable:

```objectivec
- (void)enableMapMoveOnSearchResponseWithEnable:(BOOL)enable;
```

Enable or disable moving the map on primary search response. Map moving is enabled by default.

| Parameters |   |
| --- | --- |
| enable | Enable map moving if true, disable otherwise. |

### hasNextPage

```objectivec
- (BOOL)hasNextPage;
```

Check if more results could be loaded.

### fetchNextPage

```objectivec
- (void)fetchNextPage;
```

Load the next page of results.

### clear

```objectivec
- (void)clear;
```

Clear the displayed search results from the map.

### getSearchResultsList

```objectivec
- (nonnull NSArray<YMKSearchResultItem *> *)getSearchResultsList;
```

Get the list of search results.

### searchMetadata

```objectivec
- (nullable YMKSearchMetadata *)searchMetadata;
```

Get the last search response metadata.

### setSearchManagerWithSearchManager:

```objectivec
- (void)setSearchManagerWithSearchManager:
    (nonnull YMKSearchManager *)searchManager;
```

Set the search manager. Do not use this method; it is for internal use only.

| Parameters |   |
| --- | --- |
| searchManager | Search manager |

### addSearchResultListenerWithSearchResultListener:

```objectivec
- (void)addSearchResultListenerWithSearchResultListener:
    (nonnull id<YMKSearchLayerResponseHandler>)searchResultListener;
```

Add the search result listener, which will receive notifications from the search layer.

The class does not retain the object in the 'searchResultListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| searchResultListener | Search result listener to add. |

### removeSearchResultListenerWithSearchResultListener:

```objectivec
- (void)removeSearchResultListenerWithSearchResultListener:
    (nonnull id<YMKSearchLayerResponseHandler>)searchResultListener;
```

Remove search result listener.

| Parameters |   |
| --- | --- |
| searchResultListener | Search result listener to remove. |

### addPlacemarkListenerWithPlacemarkListener:

```objectivec
- (void)addPlacemarkListenerWithPlacemarkListener:
    (nonnull id<YMKSearchLayerTapHandler>)placemarkListener;
```

Add a placemark listener, which will receive notifications from the search layer.

The class does not retain the object in the 'placemarkListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| placemarkListener | Placemark listener to add. |

### removePlacemarkListenerWithPlacemarkListener:

```objectivec
- (void)removePlacemarkListenerWithPlacemarkListener:
    (nonnull id<YMKSearchLayerTapHandler>)placemarkListener;
```

Remove placemark listener

| Parameters |   |
| --- | --- |
| placemarkListener | Placemark listener to remove. |

### setSortByDistanceWithOrigin:

```objectivec
- (void)setSortByDistanceWithOrigin:(nonnull YMKGeometry *)origin;
```

Set sort order of the results by distance from given geometry.

### setPolylinePositionWithPosition:

```objectivec
- (void)setPolylinePositionWithPosition:(nonnull YMKPolylinePosition *)position;
```

When sorting by distance from polyline sets position on this polyline. Has the same effect as sorting by distance from the sub-polyline from `position` to the end of the polyline. Throws if no polyline is set or position is out of range.

| Parameters |   |
| --- | --- |
| position | new polyline position value |

### resetSort

```objectivec
- (void)resetSort;
```

Reset the sort if it was previously set.

### setFilterCollectionWithFilters:

```objectivec
- (void)setFilterCollectionWithFilters:
    (nullable YMKSearchFilterCollection *)filters;
```

Set search filters.

| Parameters |   |
| --- | --- |
| filters | Business filters |

### setFiltersWithFilters:

```objectivec
- (void)setFiltersWithFilters:
    (nonnull NSArray<YMKSearchBusinessFilter *> *)filters;
```

search.FilterCollection)} instead.

> [!CAUTION] Внимание
> Use {@link SearchLayer#setFilterCollection(const optional

### setAssetsProviderWithProvider:

```objectivec
- (void)setAssetsProviderWithProvider:(nonnull id<YMKAssetsProvider>)provider;
```

Set a custom assets provider, which provides images, sizes and icon styles for placemarks.

The class does not retain the object in the 'provider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| provider | Assets provider (must not be null) |

### resetAssetsProvider

```objectivec
- (void)resetAssetsProvider;
```

Reset the assets provider to default.

### selectPlacemarkWithGeoObjectId:

```objectivec
- (void)selectPlacemarkWithGeoObjectId:(nonnull NSString *)geoObjectId;
```

Select the placemark by ID.

| Parameters |   |
| --- | --- |
| geoObjectId | Placemark identifier |

### selectedPlacemarkId

```objectivec
- (nullable NSString *)selectedPlacemarkId;
```

Selected placemark ID.

**Returns**

Placemark identifier if any placemark is selected, otherwise

none.

### deselectPlacemark

```objectivec
- (void)deselectPlacemark;
```

Deselect all placemarks.

### forceUpdateIconWithGeoObjectId:iconType:image:style:

```objectivec
- (void)forceUpdateIconWithGeoObjectId:(nonnull NSString *)geoObjectId
                              iconType:(YMKPlacemarkIconType)iconType
                                 image:(nonnull UIImage *)image
                                 style:(nonnull YMKIconStyle *)style;
```

Update the icon image for each suitable placemark. If the placemark is not found, the image will be put in a queue and will be applied once when the placemark is created. This is not the normal way to set the image. It is highly advisable to return the right image from AssetsProvider.

| Parameters |   |
| --- | --- |
| geoObjectId | Placemark identifier |
| iconType | Icon type |
| image | Icon image |
| style | Icon style |

### forceUpdateMapObjects

```objectivec
- (void)forceUpdateMapObjects;
```

Force reloading all visible pins from AssetProvider. Use when there is a reason to update ALL the icons simultaneously (for example icon theme change, day/night mode, and other). This can be a pretty expensive operation, as it wipes all the map objects off of the layer and creates them from scratch. Use only if absolutely necessary.

### obtainAdIconsWithEnable:

```objectivec
- (void)obtainAdIconsWithEnable:(BOOL)enable;
```

If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider.

| Parameters |   |
| --- | --- |
| enable | Enable mode if true, disable otherwise |

### setInsetsWithTop:left:bottom:right:

```objectivec
- (void)setInsetsWithTop:(NSUInteger)top
                    left:(NSUInteger)left
                  bottom:(NSUInteger)bottom
                   right:(NSUInteger)right;
```

Apply insets (in pixels) to the screen. If inset is not zero, search in the cut-off area will not be performed.

| Parameters |   |
| --- | --- |
| top | Top inset. |
| left | Left inset. |
| bottom | Bottom inset. |
| right | Right inset. |

## Properties

### visible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Search layer visibility. Visible by default. While the layer is invisible resubmits are not performed on map moves, but all the state changing methods (`submitQuery`, `resubmit`, `deselectPlacemark`, and other) are executed as usual.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
