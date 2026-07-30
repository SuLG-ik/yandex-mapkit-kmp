---
title: "YMKSearchMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchMetadata.html"
---
# YMKSearchMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchMetadata : NSObject, YMKBaseMetadata
```

Additional info for search response;

## Summary

### Class methods

```swift
 init(found: Int,
 displayType: YMKSearchDisplayType,
 boundingBox: YMKBoundingBox?,
       sort: YMKSearchSort?,
    toponym: YMKGeoObject?,
 toponymResultMetadata: YMKSearchToponymResultMetadata?,
 businessResultMetadata: YMKSearchBusinessResultMetadata?,
      reqid: String,
    context: String,
 requestText: String,
 correctedRequestText: String?,
 request requestBoundingBox: YMKBoundingBox?)
```

### Properties

```swift
var found: Int { get }
```

Approximate number of found objects

```swift
var displayType: YMKSearchDisplayType { get }
```

Display type

```swift
var boundingBox: YMKBoundingBox? { get }
```

Bounding box of the response as a whole

```swift
var sort: YMKSearchSort? { get }
```

Server-chosen sorting

```swift
var toponym: YMKGeoObject? { get }
```

Geocoder response to the toponym part of the query

```swift
var toponymResultMetadata: YMKSearchToponymResultMetadata? { get }
```

Additional info for the response from toponym search

```swift
var businessResultMetadata: YMKSearchBusinessResultMetadata? { get }
```

Additional info for the response from organization search

```swift
var reqid: String { get }
```

Server-generated request ID

```swift
var context: String { get }
```

Server-generated request context

```swift
var requestText: String { get }
```

Initial request text

```swift
var correctedRequestText: String? { get }
```

Initial request text with correction of spelling mistakes

```swift
var requestBoundingBox: YMKBoundingBox? { get }
```

Initial request bounding box

## Class methods

### init(found:displayType:boundingBox:sort:toponym:toponymResultMetadata:businessResultMetadata:reqid:context:requestText:correctedRequestText:request:)

```swift
 init(found: Int,
 displayType: YMKSearchDisplayType,
 boundingBox: YMKBoundingBox?,
       sort: YMKSearchSort?,
    toponym: YMKGeoObject?,
 toponymResultMetadata: YMKSearchToponymResultMetadata?,
 businessResultMetadata: YMKSearchBusinessResultMetadata?,
      reqid: String,
    context: String,
 requestText: String,
 correctedRequestText: String?,
 request requestBoundingBox: YMKBoundingBox?)
```

## Properties

### found

```swift
var found: Int { get }
```

Approximate number of found objects.

### displayType

```swift
var displayType: YMKSearchDisplayType { get }
```

Display type.

### boundingBox

```swift
var boundingBox: YMKBoundingBox? { get }
```

Bounding box of the response as a whole.

Optional field, can be nil.

### sort

```swift
var sort: YMKSearchSort? { get }
```

Server-chosen sorting.

Optional field, can be nil.

### toponym

```swift
var toponym: YMKGeoObject? { get }
```

Geocoder response to the toponym part of the query.

Optional field, can be nil.

### toponymResultMetadata

```swift
var toponymResultMetadata: YMKSearchToponymResultMetadata? { get }
```

Additional info for the response from toponym search.

Optional field, can be nil.

### businessResultMetadata

```swift
var businessResultMetadata: YMKSearchBusinessResultMetadata? { get }
```

Additional info for the response from organization search.

Optional field, can be nil.

### reqid

```swift
var reqid: String { get }
```

Server-generated request ID.

### context

```swift
var context: String { get }
```

Server-generated request context.

### requestText

```swift
var requestText: String { get }
```

Initial request text.

### correctedRequestText

```swift
var correctedRequestText: String? { get }
```

Initial request text with correction of spelling mistakes.

Optional field, can be nil.

### requestBoundingBox

```swift
var requestBoundingBox: YMKBoundingBox? { get }
```

Initial request bounding box.

Optional field, can be nil.
