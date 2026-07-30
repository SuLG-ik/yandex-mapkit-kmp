---
title: "YMKBoundingBoxHelper"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBoundingBoxHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBoundingBoxHelper.html"
---
# YMKBoundingBoxHelper

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBoundingBoxHelper.html)

```swift
class YMKBoundingBoxHelper : NSObject
```

## Summary

### Class methods

```swift
class func getBoundsWithBbox(_ bbox: YMKBoundingBox) -> YMKBoundingBox
```

Gets bounds based on a bounding box

```swift
class func getBoundsWith(_ point: YMKPoint) -> YMKBoundingBox
```

Gets bounds based on a point

```swift
class func getBoundsWith(_ polyline: YMKPolyline) -> YMKBoundingBox
```

Gets bounds based on a polyline

```swift
class func getBoundsWith(_ ring: YMKLinearRing) -> YMKBoundingBox
```

Gets bounds based on a linear ring

```swift
class func getBoundsWith(_ polygon: YMKPolygon) -> YMKBoundingBox
```

Gets bounds based on a polygon

```swift
class func getBoundsWithFirst(_ first: YMKBoundingBox,
                               second: YMKBoundingBox) -> YMKBoundingBox
```

Gets bounds based on two bounding boxes

## Class methods

### getBoundsWithBbox(_:)

```swift
class func getBoundsWithBbox(_ bbox: YMKBoundingBox) -> YMKBoundingBox
```

Gets bounds based on a bounding box.

### getBoundsWith(_:)

```swift
class func getBoundsWith(_ point: YMKPoint) -> YMKBoundingBox
```

Gets bounds based on a point.

### getBoundsWith(_:)

```swift
class func getBoundsWith(_ polyline: YMKPolyline) -> YMKBoundingBox
```

Gets bounds based on a polyline.

### getBoundsWith(_:)

```swift
class func getBoundsWith(_ ring: YMKLinearRing) -> YMKBoundingBox
```

Gets bounds based on a linear ring.

### getBoundsWith(_:)

```swift
class func getBoundsWith(_ polygon: YMKPolygon) -> YMKBoundingBox
```

Gets bounds based on a polygon.

### getBoundsWithFirst(_:second:)

```swift
class func getBoundsWithFirst(_ first: YMKBoundingBox,
                               second: YMKBoundingBox) -> YMKBoundingBox
```

Gets bounds based on two bounding boxes.
