---
title: "YMKSearchSession"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSession.html"
---
# YMKSearchSession

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchSession : NSObject
```

Interface denoting ongoing search session. Allows search cancellation and retry. For many request types allows further searches.

## Summary

### Instance methods

```swift
func cancel()
```

Cancels the current request

```swift
func retry(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Retries the last request

```swift
func hasNextPage() -> Bool
```

Check the availability of the next result page

```swift
func fetchNextPage(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Request the next page of search results

```swift
func setFiltersWith(_ filters: [YMKSearchBusinessFilter])
```

```swift
func setSortByDistanceWithOrigin(_ origin: YMKGeometry)
```

Requests sorting by distance for future resubmits

```swift
func resetSort()
```

Resets the sort if it was previously set (for example by YMKSearchSession::setSortByDistanceWithOrigin:) for future resubmits

```swift
func setSearchAreaWithArea(_ area: YMKGeometry)
```

Sets the search area for future resubmits

```swift
func setSearchOptionsWith(_ searchOptions: YMKSearchOptions)
```

Set searchOptions for future resubmits

```swift
func resubmit(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Redo the last search with currently set values of search area, search options, filters, sort type and sort origin

## Instance methods

### cancel()

```swift
func cancel()
```

Cancels the current request.

### retry(responseHandler:)

```swift
func retry(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Retries the last request. If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| searchListener | Listener to handle search result. |

### hasNextPage()

```swift
func hasNextPage() -> Bool
```

Check the availability of the next result page.

**Returns**

True if there are more search results and one can call

YMKSearchSession::fetchNextPageWithResponseHandler:, false otherwise.

### fetchNextPage(responseHandler:)

```swift
func fetchNextPage(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Request the next page of search results. Ignored if the current request isn't ready. Will throw if called when {@link search.Session#hasNextPage()} is false.

- parameter: searchListener Listener to handle search result.

### setFiltersWith(_:)

```swift
func setFiltersWith(_ filters: [YMKSearchBusinessFilter])
```

> [!CAUTION] Внимание
> Use {@link SearchOptions#filters} instead.

### setSortByDistanceWithOrigin(_:)

```swift
func setSortByDistanceWithOrigin(_ origin: YMKGeometry)
```

Requests sorting by distance for future resubmits. Supported geometry types: point, polyline.

| Parameters |   |
| --- | --- |
| origin | Origin to sort by distance from. |

### resetSort()

```swift
func resetSort()
```

Resets the sort if it was previously set (for example by YMKSearchSession::setSortByDistanceWithOrigin:) for future resubmits.

### setSearchAreaWithArea(_:)

```swift
func setSearchAreaWithArea(_ area: YMKGeometry)
```

Sets the search area for future resubmits. Supported geometry types: bounding box, polyline, polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if last point is equal to first) and no inner rings.

| Parameters |   |
| --- | --- |
| area | Search area for future resubmits. |

### setSearchOptionsWith(_:)

```swift
func setSearchOptionsWith(_ searchOptions: YMKSearchOptions)
```

Set searchOptions for future resubmits.

| Parameters |   |
| --- | --- |
| searchOptions | Additional search parameters, see YMKSearchOptions. Supported options: YMKSearchOptions::origin, YMKSearchOptions::userPosition. |

### resubmit(responseHandler:)

```swift
func resubmit(responseHandler: @escaping YMKSearchSessionResponseHandler)
```

Redo the last search with currently set values of search area, search options, filters, sort type and sort origin. Isn't applicable to reverse geosearch and URI resolving. Ignored it the current request is the first one; cancels current request otherwise.

| Parameters |   |
| --- | --- |
| searchListener | Listener to handle search result. |
