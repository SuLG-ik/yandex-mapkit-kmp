---
title: "YMKPolygon"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolygon"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolygon.html"
---
# YMKPolygon

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolygon.html)

```swift
class YMKPolygon : NSObject
```

A polygon with one or more polygons in it. The exterior and interior areas are specified using LinearRing.

## Summary

### Class methods

```swift
 init(outerRing: YMKLinearRing, innerRings: [YMKLinearRing])
```

### Properties

```swift
var outerRing: YMKLinearRing { get }
```

The ring specifying the area

```swift
var innerRings: [YMKLinearRing] { get }
```

The list of rings in the specified area

## Class methods

### init(outerRing:innerRings:)

```swift
 init(outerRing: YMKLinearRing, innerRings: [YMKLinearRing])
```

## Properties

### outerRing

```swift
var outerRing: YMKLinearRing { get }
```

The ring specifying the area.

### innerRings

```swift
var innerRings: [YMKLinearRing] { get }
```

The list of rings in the specified area.
