---
title: "YMKProjection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKProjection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKProjection.html"
---
# YMKProjection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKProjection.html)

```swift
class YMKProjection : NSObject
```

Makes two conversions: world->XY and XY->world, where XY are tile indexes. There are two main derived classes: spherical mercator (google, osm) and wgs84 mercator (yandex).

## Summary

### Instance methods

```swift
func worldToXY(withGeoPoint geoPoint: YMKPoint, zoom: Int) -> YMKXYPoint
```

Converts the world coordinates to a flat world position

```swift
func xyToWorld(with xyPoint: YMKXYPoint, zoom: Int) -> YMKPoint
```

Converts the flat world position to world coordinates

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### worldToXY(withGeoPoint:zoom:)

```swift
func worldToXY(withGeoPoint geoPoint: YMKPoint, zoom: Int) -> YMKXYPoint
```

Converts the world coordinates to a flat world position.

### xyToWorld(with:zoom:)

```swift
func xyToWorld(with xyPoint: YMKXYPoint, zoom: Int) -> YMKPoint
```

Converts the flat world position to world coordinates.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
