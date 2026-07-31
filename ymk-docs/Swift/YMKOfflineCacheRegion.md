---
title: "YMKOfflineCacheRegion"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKOfflineCacheRegion"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegion.html"
---
# YMKOfflineCacheRegion

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOfflineCacheRegion.html)

```swift
class YMKOfflineCacheRegion : NSObject
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Class methods

```swift
 init(id: UInt,
    name: String,
 country: String,
  center: YMKPoint,
    size: YMKLocalizedValue,
 releaseTime: Date,
 parentId: NSNumber?)
```

### Properties

```swift
var id: UInt { get }
```

Region ID

```swift
var name: String { get }
```

Name of the region

```swift
var country: String { get }
```

Country of the region

```swift
var center: YMKPoint { get }
```

Center point

```swift
var size: YMKLocalizedValue { get }
```

Region size

```swift
var releaseTime: Date { get }
```

Returns the region creation time

```swift
var parentId: NSNumber? { get }
```

Region id of the parent region

## Class methods

### init(id:name:country:center:size:releaseTime:parentId:)

```swift
 init(id: UInt,
    name: String,
 country: String,
  center: YMKPoint,
    size: YMKLocalizedValue,
 releaseTime: Date,
 parentId: NSNumber?)
```

## Properties

### id

```swift
var id: UInt { get }
```

Region ID.

### name

```swift
var name: String { get }
```

Name of the region.

### country

```swift
var country: String { get }
```

Country of the region.

### center

```swift
var center: YMKPoint { get }
```

Center point.

### size

```swift
var size: YMKLocalizedValue { get }
```

Region size

### releaseTime

```swift
var releaseTime: Date { get }
```

Returns the region creation time.

### parentId

```swift
var parentId: NSNumber? { get }
```

Region id of the parent region.

Optional field, can be nil.
