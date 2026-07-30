---
title: "YMKLinearRing"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLinearRing"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLinearRing.html"
---
# YMKLinearRing

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLinearRing.html)

```swift
class YMKLinearRing : NSObject
```

A sequence of four or more vertices, with all points along the linearly-interpolated curves (line segments) between each pair of consecutive vertices. A ring must have either 0, 4 or more points. The first and last points of the ring must be in the same position. The ring must not intersect with itself.

## Summary

### Class methods

```swift
 init(points: [YMKPoint])
```

### Properties

```swift
var points: [YMKPoint] { get }
```

The list of points to connect

## Class methods

### init(points:)

```swift
 init(points: [YMKPoint])
```

## Properties

### points

```swift
var points: [YMKPoint] { get }
```

The list of points to connect.
