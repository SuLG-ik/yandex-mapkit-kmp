---
title: "YMKSearchResponse"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchResponse"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchResponse.html"
---
# YMKSearchResponse

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchResponse.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchResponse : NSObject
```

Top level structure for search response.

## Summary

### Class methods

```swift
 init(metadata: YMKSearchMetadata,
    collection: YMKGeoObjectCollection,
     isOffline: Bool)
```

### Properties

```swift
var metadata: YMKSearchMetadata { get }
```

Extended response information

```swift
var collection: YMKGeoObjectCollection { get }
```

List of objects (organizations, toponyms) in search response

```swift
var isOffline: Bool { get }
```

Flag describing if this response was built offline

## Class methods

### init(metadata:collection:isOffline:)

```swift
 init(metadata: YMKSearchMetadata,
    collection: YMKGeoObjectCollection,
     isOffline: Bool)
```

## Properties

### metadata

```swift
var metadata: YMKSearchMetadata { get }
```

Extended response information.

### collection

```swift
var collection: YMKGeoObjectCollection { get }
```

List of objects (organizations, toponyms) in search response.

### isOffline

```swift
var isOffline: Bool { get }
```

Flag describing if this response was built offline.
