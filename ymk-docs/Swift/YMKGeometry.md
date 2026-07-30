---
title: "YMKGeometry"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeometry.html"
---
# YMKGeometry

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeometry.html)

```swift
class YMKGeometry : NSObject
```

A container of other geometry objects. Point - A point on the map. Polyline - A polyline between a number of points. Polygon - A polygon with one or more polygons in it. BoundingBox - A rectangular box around the object. Circle - A circle around the specified point.

## Summary

### Class methods

```swift
 init(point: YMKPoint)
```

```swift
 init(polyline: YMKPolyline)
```

```swift
 init(polygon: YMKPolygon)
```

```swift
 init(multiPolygon: YMKMultiPolygon)
```

```swift
 init(boundingBox: YMKBoundingBox)
```

```swift
 init(circle: YMKCircle)
```

### Properties

```swift
var point: YMKPoint? { get }
```

```swift
var polyline: YMKPolyline? { get }
```

```swift
var polygon: YMKPolygon? { get }
```

```swift
var multiPolygon: YMKMultiPolygon? { get }
```

```swift
var boundingBox: YMKBoundingBox? { get }
```

```swift
var circle: YMKCircle? { get }
```

## Class methods

### init(point:)

```swift
 init(point: YMKPoint)
```

### init(polyline:)

```swift
 init(polyline: YMKPolyline)
```

### init(polygon:)

```swift
 init(polygon: YMKPolygon)
```

### init(multiPolygon:)

```swift
 init(multiPolygon: YMKMultiPolygon)
```

### init(boundingBox:)

```swift
 init(boundingBox: YMKBoundingBox)
```

### init(circle:)

```swift
 init(circle: YMKCircle)
```

## Properties

### point

```swift
var point: YMKPoint? { get }
```

### polyline

```swift
var polyline: YMKPolyline? { get }
```

### polygon

```swift
var polygon: YMKPolygon? { get }
```

### multiPolygon

```swift
var multiPolygon: YMKMultiPolygon? { get }
```

### boundingBox

```swift
var boundingBox: YMKBoundingBox? { get }
```

### circle

```swift
var circle: YMKCircle? { get }
```
