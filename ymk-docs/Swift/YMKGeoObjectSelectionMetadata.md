---
title: "YMKGeoObjectSelectionMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeoObjectSelectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectSelectionMetadata.html"
---
# YMKGeoObjectSelectionMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectSelectionMetadata.html)

```swift
class YMKGeoObjectSelectionMetadata : NSObject, YMKBaseMetadata
```

Geo object metadata which is needed to select object.

## Summary

### Class methods

```swift
 init(objectId: String,
 dataSourceName: String,
       layerId: String,
       groupId: NSNumber?)
```

### Properties

```swift
var objectId: String { get }
```

Object ID

```swift
var dataSourceName: String { get }
```

Data source name

```swift
var layerId: String { get }
```

Layer ID

```swift
var groupId: NSNumber? { get }
```

Group ID

## Class methods

### init(objectId:dataSourceName:layerId:groupId:)

```swift
 init(objectId: String,
 dataSourceName: String,
       layerId: String,
       groupId: NSNumber?)
```

## Properties

### objectId

```swift
var objectId: String { get }
```

Object ID.

### dataSourceName

```swift
var dataSourceName: String { get }
```

Data source name.

### layerId

```swift
var layerId: String { get }
```

Layer ID.

### groupId

```swift
var groupId: NSNumber? { get }
```

Group ID.

Optional field, can be nil.
