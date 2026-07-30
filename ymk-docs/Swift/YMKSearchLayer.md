---
title: "YMKSearchLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayer.html"
---
# YMKSearchLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchLayer : NSObject
```

The search layer handles the map search requests and displays the results on the map automatically. It also handles the map movements and resubmits searches when needed.

## Summary

### Instance methods

```swift
func submitQuery(withQuery query: String, searchOptions: YMKSearchOptions)
```

Submit search query with search options

```swift
func submitQuery(withQuery query: String,
                        geometry: YMKGeometry,
                   searchOptions: YMKSearchOptions)
```

Submit search query with search options near provided geometry

```swift
func searchByUri(withUri uri: String, searchOptions: YMKSearchOptions)
```

Submit search request for URI resolution

```swift
func resubmit()
```

Manual resubmit

```swift
func enableRequestsOnMapMoves(withEnable enable: Bool)
```

Enable or disable search requests (resubmits and submits) when the map is moved

```swift
func enableMapMoveOnSearchResponse(withEnable enable: Bool)
```

Enable or disable moving the map on primary search response

```swift
func hasNextPage() -> Bool
```

Check if more results could be loaded

```swift
func fetchNextPage()
```

Load the next page of results

```swift
func clear()
```

Clear the displayed search results from the map

```swift
func getSearchResultsList() -> [YMKSearchResultItem]
```

Get the list of search results

```swift
func searchMetadata() -> YMKSearchMetadata?
```

Get the last search response metadata

```swift
func setSearchManagerWith(_ searchManager: YMKSearchManager)
```

Set the search manager

```swift
func addSearchResultListener(withSearchResultListener searchResultListener: any YMKSearchLayerResponseHandler)
```

Add the search result listener, which will receive notifications from the search layer

```swift
func removeSearchResultListener(withSearchResultListener searchResultListener: any YMKSearchLayerResponseHandler)
```

Remove search result listener

```swift
func addPlacemarkListener(withPlacemarkListener placemarkListener: any YMKSearchLayerTapHandler)
```

Add a placemark listener, which will receive notifications from the search layer

```swift
func removePlacemarkListener(withPlacemarkListener placemarkListener: any YMKSearchLayerTapHandler)
```

Remove placemark listener

```swift
func setSortByDistanceWithOrigin(_ origin: YMKGeometry)
```

Set sort order of the results by distance from given geometry

```swift
func setPolylinePositionWith(_ position: YMKPolylinePosition)
```

When sorting by distance from polyline sets position on this polyline

```swift
func resetSort()
```

Reset the sort if it was previously set

```swift
func setFilterCollectionWithFilters(_ filters: YMKSearchFilterCollection?)
```

Set search filters

```swift
func setFiltersWith(_ filters: [YMKSearchBusinessFilter])
```

search

```swift
func setAssetsProviderWith(_ provider: any YMKAssetsProvider)
```

Set a custom assets provider, which provides images, sizes and icon styles for placemarks

```swift
func resetAssetsProvider()
```

Reset the assets provider to default

```swift
func selectPlacemark(withGeoObjectId geoObjectId: String)
```

Select the placemark by ID

```swift
func selectedPlacemarkId() -> String?
```

Selected placemark ID

```swift
func deselectPlacemark()
```

Deselect all placemarks

```swift
func forceUpdateIcon(withGeoObjectId geoObjectId: String,
                                        iconType: YMKPlacemarkIconType,
                                           image: UIImage,
                                           style: YMKIconStyle)
```

Update the icon image for each suitable placemark

```swift
func forceUpdateMapObjects()
```

Force reloading all visible pins from AssetProvider

```swift
func obtainAdIcons(withEnable enable: Bool)
```

If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider

```swift
func setInsetsWithTop(_ top: UInt, left: UInt, bottom: UInt, right: UInt)
```

Apply insets (in pixels) to the screen

### Properties

```swift
var isVisible: Bool { get set }
```

Search layer visibility

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### submitQuery(withQuery:searchOptions:)

```swift
func submitQuery(withQuery query: String, searchOptions: YMKSearchOptions)
```

Submit search query with search options.

| Parameters |   |
| --- | --- |
| query | User query |
| searchOptions | Search options |

### submitQuery(withQuery:geometry:searchOptions:)

```swift
func submitQuery(withQuery query: String,
                        geometry: YMKGeometry,
                   searchOptions: YMKSearchOptions)
```

Submit search query with search options near provided geometry.

| Parameters |   |
| --- | --- |
| query | User query. |
| geometry | Geometry to search near. Supported types: point, bounding box, polyline and polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to the first) and no inner rings. |
| searchOptions | Search options. |

### searchByUri(withUri:searchOptions:)

```swift
func searchByUri(withUri uri: String, searchOptions: YMKSearchOptions)
```

Submit search request for URI resolution. Allows multiple objects in response.

| Parameters |   |
| --- | --- |
| uri | Object URI. |
| searchOptions | Additional search parameters. See YMKSearchOptions definition for details, and 'searchByURI' method in YMKSearchManager for currently supported options. |

### resubmit()

```swift
func resubmit()
```

Manual resubmit.

### enableRequestsOnMapMoves(withEnable:)

```swift
func enableRequestsOnMapMoves(withEnable enable: Bool)
```

Enable or disable search requests (resubmits and submits) when the map is moved. Requests are enabled by default.

| Parameters |   |
| --- | --- |
| enable | Enable requests if true, disable otherwise. |

### enableMapMoveOnSearchResponse(withEnable:)

```swift
func enableMapMoveOnSearchResponse(withEnable enable: Bool)
```

Enable or disable moving the map on primary search response. Map moving is enabled by default.

| Parameters |   |
| --- | --- |
| enable | Enable map moving if true, disable otherwise. |

### hasNextPage()

```swift
func hasNextPage() -> Bool
```

Check if more results could be loaded.

### fetchNextPage()

```swift
func fetchNextPage()
```

Load the next page of results.

### clear()

```swift
func clear()
```

Clear the displayed search results from the map.

### getSearchResultsList()

```swift
func getSearchResultsList() -> [YMKSearchResultItem]
```

Get the list of search results.

### searchMetadata()

```swift
func searchMetadata() -> YMKSearchMetadata?
```

Get the last search response metadata.

### setSearchManagerWith(_:)

```swift
func setSearchManagerWith(_ searchManager: YMKSearchManager)
```

Set the search manager. Do not use this method; it is for internal use only.

| Parameters |   |
| --- | --- |
| searchManager | Search manager |

### addSearchResultListener(withSearchResultListener:)

```swift
func addSearchResultListener(withSearchResultListener searchResultListener: any YMKSearchLayerResponseHandler)
```

Add the search result listener, which will receive notifications from the search layer.

The class does not retain the object in the 'searchResultListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| searchResultListener | Search result listener to add. |

### removeSearchResultListener(withSearchResultListener:)

```swift
func removeSearchResultListener(withSearchResultListener searchResultListener: any YMKSearchLayerResponseHandler)
```

Remove search result listener.

| Parameters |   |
| --- | --- |
| searchResultListener | Search result listener to remove. |

### addPlacemarkListener(withPlacemarkListener:)

```swift
func addPlacemarkListener(withPlacemarkListener placemarkListener: any YMKSearchLayerTapHandler)
```

Add a placemark listener, which will receive notifications from the search layer.

The class does not retain the object in the 'placemarkListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| placemarkListener | Placemark listener to add. |

### removePlacemarkListener(withPlacemarkListener:)

```swift
func removePlacemarkListener(withPlacemarkListener placemarkListener: any YMKSearchLayerTapHandler)
```

Remove placemark listener

| Parameters |   |
| --- | --- |
| placemarkListener | Placemark listener to remove. |

### setSortByDistanceWithOrigin(_:)

```swift
func setSortByDistanceWithOrigin(_ origin: YMKGeometry)
```

Set sort order of the results by distance from given geometry.

### setPolylinePositionWith(_:)

```swift
func setPolylinePositionWith(_ position: YMKPolylinePosition)
```

When sorting by distance from polyline sets position on this polyline. Has the same effect as sorting by distance from the sub-polyline from `position` to the end of the polyline. Throws if no polyline is set or position is out of range.

| Parameters |   |
| --- | --- |
| position | new polyline position value |

### resetSort()

```swift
func resetSort()
```

Reset the sort if it was previously set.

### setFilterCollectionWithFilters(_:)

```swift
func setFilterCollectionWithFilters(_ filters: YMKSearchFilterCollection?)
```

Set search filters.

| Parameters |   |
| --- | --- |
| filters | Business filters |

### setFiltersWith(_:)

```swift
func setFiltersWith(_ filters: [YMKSearchBusinessFilter])
```

search.FilterCollection)} instead.

> [!CAUTION] Внимание
> Use {@link SearchLayer#setFilterCollection(const optional

### setAssetsProviderWith(_:)

```swift
func setAssetsProviderWith(_ provider: any YMKAssetsProvider)
```

Set a custom assets provider, which provides images, sizes and icon styles for placemarks.

The class does not retain the object in the 'provider' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| provider | Assets provider (must not be null) |

### resetAssetsProvider()

```swift
func resetAssetsProvider()
```

Reset the assets provider to default.

### selectPlacemark(withGeoObjectId:)

```swift
func selectPlacemark(withGeoObjectId geoObjectId: String)
```

Select the placemark by ID.

| Parameters |   |
| --- | --- |
| geoObjectId | Placemark identifier |

### selectedPlacemarkId()

```swift
func selectedPlacemarkId() -> String?
```

Selected placemark ID.

**Returns**

Placemark identifier if any placemark is selected, otherwise

none.

### deselectPlacemark()

```swift
func deselectPlacemark()
```

Deselect all placemarks.

### forceUpdateIcon(withGeoObjectId:iconType:image:style:)

```swift
func forceUpdateIcon(withGeoObjectId geoObjectId: String,
                                        iconType: YMKPlacemarkIconType,
                                           image: UIImage,
                                           style: YMKIconStyle)
```

Update the icon image for each suitable placemark. If the placemark is not found, the image will be put in a queue and will be applied once when the placemark is created. This is not the normal way to set the image. It is highly advisable to return the right image from AssetsProvider.

| Parameters |   |
| --- | --- |
| geoObjectId | Placemark identifier |
| iconType | Icon type |
| image | Icon image |
| style | Icon style |

### forceUpdateMapObjects()

```swift
func forceUpdateMapObjects()
```

Force reloading all visible pins from AssetProvider. Use when there is a reason to update ALL the icons simultaneously (for example icon theme change, day/night mode, and other). This can be a pretty expensive operation, as it wipes all the map objects off of the layer and creates them from scratch. Use only if absolutely necessary.

### obtainAdIcons(withEnable:)

```swift
func obtainAdIcons(withEnable enable: Bool)
```

If enabled, the search layer will obtain and set advertising icons without asking AssetsProvider.

| Parameters |   |
| --- | --- |
| enable | Enable mode if true, disable otherwise |

### setInsetsWithTop(_:left:bottom:right:)

```swift
func setInsetsWithTop(_ top: UInt, left: UInt, bottom: UInt, right: UInt)
```

Apply insets (in pixels) to the screen. If inset is not zero, search in the cut-off area will not be performed.

| Parameters |   |
| --- | --- |
| top | Top inset. |
| left | Left inset. |
| bottom | Bottom inset. |
| right | Right inset. |

## Properties

### isVisible

```swift
var isVisible: Bool { get set }
```

Search layer visibility. Visible by default. While the layer is invisible resubmits are not performed on map moves, but all the state changing methods (`submitQuery`, `resubmit`, `deselectPlacemark`, and other) are executed as usual.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
