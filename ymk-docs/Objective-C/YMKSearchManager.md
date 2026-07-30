---
title: "YMKSearchManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchManager.html"
---
# YMKSearchManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchManager.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchManager : NSObject
```

Main interface to start search.

## Summary

### Instance methods

```objectivec
- (nonnull YMKSearchSession *)
     submitWithText:(nonnull NSString *)text
           geometry:(nonnull YMKGeometry *)geometry
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request for searching a user query near given geometry

```objectivec
- (nonnull YMKSearchSession *)
     submitWithText:(nonnull NSString *)text
           polyline:(nonnull YMKPolyline *)polyline
           geometry:(nonnull YMKGeometry *)geometry
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request that is used to search for a user query along the given polyline inside the given window

```objectivec
- (nonnull YMKSearchSession *)
    submitWithPoint:(nonnull YMKPoint *)point
               zoom:(nullable NSNumber *)zoom
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Reverse search request (to search objects at the given coordinates)

```objectivec
- (nonnull YMKSearchSession *)
    resolveURIWithUri:(nonnull NSString *)uri
        searchOptions:(nonnull YMKSearchOptions *)searchOptions
      responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request for URI resolution

```objectivec
- (nonnull YMKSearchSession *)
    searchByURIWithUri:(nonnull NSString *)uri
         searchOptions:(nonnull YMKSearchOptions *)searchOptions
       responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request with URI

```objectivec
- (nonnull YMKSearchSession *)
    searchByBusinessOidsWithBusinessOids:
        (nonnull NSArray<NSString *> *)businessOids
                           searchOptions:
                               (nonnull YMKSearchOptions *)searchOptions
                         responseHandler:
                             (nonnull YMKSearchSessionResponseHandler)
                                 responseHandler;
```

Search request for multiple business objects by their OIDs

```objectivec
- (nonnull YMKSearchSuggestSession *)createSuggestSession;
```

Creates session for suggest requests

## Instance methods

### submitWithText:geometry:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
     submitWithText:(nonnull NSString *)text
           geometry:(nonnull YMKGeometry *)geometry
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request for searching a user query near given geometry.

| Parameters |   |
| --- | --- |
| text | User query. |
| geometry | Geometry to search near. Supported types: point, bounding box, polyline and polygon. If the polyline is provided, setSortByDistance(polyline) is assumed on the first request. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to the first) and no inner rings. |
| searchOptions | Various additional search parameters, see YMKSearchOptions definition for details. |
| searchListener | Listener to handle search result. |

**Returns**

YMKSearchSession which allows further searches, cancel and

retry.

### submitWithText:polyline:geometry:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
     submitWithText:(nonnull NSString *)text
           polyline:(nonnull YMKPolyline *)polyline
           geometry:(nonnull YMKGeometry *)geometry
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request that is used to search for a user query along the given polyline inside the given window.

@link search.Session#setSortByDistance(const mapkit.geometry.Geometry)} is assumed on the first request. - parameter: geometry Geometry to search near; supported types: point, bounding box, polyline and polygon. Polygon is expected to be a search window: 4 points in outer ring (or 5 if the last point is equal to first) and no inner rings. - parameter: searchOptions Various additional search parameters, see YMKSearchOptions definition for details. - parameter: searchListener Listener to handle search result.

- returns: YMKSearchSession which allows further searches, cancel and retry. Session should be stored by user or search is automatically cancelled.

| Parameters |   |
| --- | --- |
| text | User query. |
| polyline | Polyline to search near; { |

### submitWithPoint:zoom:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
    submitWithPoint:(nonnull YMKPoint *)point
               zoom:(nullable NSNumber *)zoom
      searchOptions:(nonnull YMKSearchOptions *)searchOptions
    responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Reverse search request (to search objects at the given coordinates)

| Parameters |   |
| --- | --- |
| point | Coordinates to search at. |
| zoom | Current zoom level. Skips objects that are too small for a given zoom level. |
| searchOptions | Additional search parameters, see YMKSearchOptions definition for details. Currently the only supported options are YMKSearchOptions::origin, YMKSearchOptions::searchTypes and YMKSearchOptions::snippets. Only 'geo' and 'biz' types are supported and not at the same time. |
| searchListener | Listener to handle search result. |

**Returns**

YMKSearchSession which allows further searches, cancel and

retry. Session should be stored by user or search is automatically

cancelled.

### resolveURIWithUri:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
    resolveURIWithUri:(nonnull NSString *)uri
        searchOptions:(nonnull YMKSearchOptions *)searchOptions
      responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request for URI resolution.

| Parameters |   |
| --- | --- |
| uri | Object uri. |
| searchOptions | Additional search parameters, see YMKSearchOptions definition for details. Currently the only supported options are YMKSearchOptions::origin and YMKSearchOptions::snippets. |
| searchListener | Listener to handle search result. |

**Returns**

YMKSearchSession which allows search cancel and retry. Should

be stored by user or search is automatically cancelled.

### searchByURIWithUri:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
    searchByURIWithUri:(nonnull NSString *)uri
         searchOptions:(nonnull YMKSearchOptions *)searchOptions
       responseHandler:(nonnull YMKSearchSessionResponseHandler)responseHandler;
```

Search request with URI. Allows multiple results in response.

| Parameters |   |
| --- | --- |
| uri | Object uri. |
| searchOptions | Additional search parameters, see YMKSearchOptions definition for details. Currently the only supported options are YMKSearchOptions::origin, YMKSearchOptions::snippets, YMKSearchOptions::resultPageSize, YMKSearchOptions::similarOrgsRequest, YMKSearchOptions::searchArea, YMKSearchOptions::overriddenSerpId, YMKSearchOptions::discovery and YMKSearchOptions::toponymDiscoveryGeoId. |
| searchListener | Listener to handle search result. |

**Returns**

YMKSearchSession which allows search cancel and retry. Should

be stored by user or search is automatically cancelled.

### searchByBusinessOidsWithBusinessOids:searchOptions:responseHandler:

```objectivec
- (nonnull YMKSearchSession *)
    searchByBusinessOidsWithBusinessOids:
        (nonnull NSArray<NSString *> *)businessOids
                           searchOptions:
                               (nonnull YMKSearchOptions *)searchOptions
                         responseHandler:
                             (nonnull YMKSearchSessionResponseHandler)
                                 responseHandler;
```

Search request for multiple business objects by their OIDs.

| Parameters |   |
| --- | --- |
| businessOids | List of business object identifiers (OIDs). |
| searchOptions | Additional search parameters, see YMKSearchOptions definition for details. Currently the only supported options are YMKSearchOptions::origin, YMKSearchOptions::snippets and YMKSearchOptions::resultPageSize. |
| searchListener | Listener to handle search result. |

**Returns**

YMKSearchSession which allows search cancel and retry. Should

be stored by user or search is automatically cancelled.

### createSuggestSession

```objectivec
- (nonnull YMKSearchSuggestSession *)createSuggestSession;
```

Creates session for suggest requests.
