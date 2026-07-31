---
title: "YMKSearchSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSession.html"
---
# YMKSearchSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchSession : NSObject
```

Interface denoting ongoing search session. Allows search cancellation and retry. For many request types allows further searches.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Cancels the current request

```objectivec
- (void)retryWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Retries the last request

```objectivec
- (BOOL)hasNextPage;
```

Check the availability of the next result page

```objectivec
- (void)fetchNextPageWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Request the next page of search results

```objectivec
- (void)setFiltersWithFilters:
    (nonnull NSArray<YMKSearchBusinessFilter *> *)filters;
```

```objectivec
- (void)setSortByDistanceWithOrigin:(nonnull YMKGeometry *)origin;
```

Requests sorting by distance for future resubmits

```objectivec
- (void)resetSort;
```

Resets the sort if it was previously set (for example by YMKSearchSession::setSortByDistanceWithOrigin:) for future resubmits

```objectivec
- (void)setSearchAreaWithArea:(nonnull YMKGeometry *)area;
```

Sets the search area for future resubmits

```objectivec
- (void)setSearchOptionsWithSearchOptions:
    (nonnull YMKSearchOptions *)searchOptions;
```

Set searchOptions for future resubmits

```objectivec
- (void)resubmitWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Redo the last search with currently set values of search area, search options, filters, sort type and sort origin

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Cancels the current request.

### retryWithResponseHandler:

```objectivec
- (void)retryWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Retries the last request. If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| searchListener | Listener to handle search result. |

### hasNextPage

```objectivec
- (BOOL)hasNextPage;
```

Check the availability of the next result page.

**Returns**

True if there are more search results and one can call

YMKSearchSession::fetchNextPageWithResponseHandler:, false otherwise.

### fetchNextPageWithResponseHandler:

```objectivec
- (void)fetchNextPageWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Request the next page of search results. Ignored if the current request isn't ready. Will throw if called when {@link search.Session#hasNextPage()} is false.

- parameter: searchListener Listener to handle search result.

### setFiltersWithFilters:

```objectivec
- (void)setFiltersWithFilters:
    (nonnull NSArray<YMKSearchBusinessFilter *> *)filters;
```

> [!CAUTION] Внимание
> Use {@link SearchOptions#filters} instead.

### setSortByDistanceWithOrigin:

```objectivec
- (void)setSortByDistanceWithOrigin:(nonnull YMKGeometry *)origin;
```

Requests sorting by distance for future resubmits. Supported geometry types: point, polyline.

| Parameters |   |
| --- | --- |
| origin | Origin to sort by distance from. |

### resetSort

```objectivec
- (void)resetSort;
```

Resets the sort if it was previously set (for example by YMKSearchSession::setSortByDistanceWithOrigin:) for future resubmits.

### setSearchAreaWithArea:

```objectivec
- (void)setSearchAreaWithArea:(nonnull YMKGeometry *)area;
```

Sets the search area for future resubmits. Supported geometry types: bounding box, polyline, polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if last point is equal to first) and no inner rings.

| Parameters |   |
| --- | --- |
| area | Search area for future resubmits. |

### setSearchOptionsWithSearchOptions:

```objectivec
- (void)setSearchOptionsWithSearchOptions:
    (nonnull YMKSearchOptions *)searchOptions;
```

Set searchOptions for future resubmits.

| Parameters |   |
| --- | --- |
| searchOptions | Additional search parameters, see YMKSearchOptions. Supported options: YMKSearchOptions::origin, YMKSearchOptions::userPosition. |

### resubmitWithResponseHandler:

```objectivec
- (void)resubmitWithResponseHandler:
    (nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Redo the last search with currently set values of search area, search options, filters, sort type and sort origin. Isn't applicable to reverse geosearch and URI resolving. Ignored it the current request is the first one; cancels current request otherwise.

| Parameters |   |
| --- | --- |
| searchListener | Listener to handle search result. |
