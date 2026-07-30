---
title: "YMKBicycleLeg"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleLeg"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleLeg.html"
---
# YMKBicycleLeg

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleLeg.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleLeg : NSObject
```

Leg of the route.

## Summary

### Class methods

```swift
 init(weight: YMKBicycleWeight, geometry: YMKSubpolyline)
```

### Properties

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route leg

```swift
var geometry: YMKSubpolyline { get }
```

Path of the route polyline for the route leg

## Class methods

### init(weight:geometry:)

```swift
 init(weight: YMKBicycleWeight, geometry: YMKSubpolyline)
```

## Properties

### weight

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route leg.

### geometry

```swift
var geometry: YMKSubpolyline { get }
```

Path of the route polyline for the route leg.
