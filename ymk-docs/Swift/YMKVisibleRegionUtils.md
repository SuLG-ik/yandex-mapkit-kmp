---
title: "YMKVisibleRegionUtils"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKVisibleRegionUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKVisibleRegionUtils.html"
---
# YMKVisibleRegionUtils

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKVisibleRegionUtils.html)

```swift
class YMKVisibleRegionUtils : NSObject
```

## Summary

### Class methods

```swift
class func toPolygon(with visibleRegion: YMKVisibleRegion) -> YMKGeometry
```

Converts visible region to polygon geometry

```swift
class func getBoundsWith(_ visibleRegion: YMKVisibleRegion) -> YMKBoundingBox
```

## Class methods

### toPolygon(with:)

```swift
class func toPolygon(with visibleRegion: YMKVisibleRegion) -> YMKGeometry
```

Converts visible region to polygon geometry

### getBoundsWith(_:)

```swift
class func getBoundsWith(_ visibleRegion: YMKVisibleRegion) -> YMKBoundingBox
```

**Returns**

BoundingBox for provided YMKVisibleRegion
