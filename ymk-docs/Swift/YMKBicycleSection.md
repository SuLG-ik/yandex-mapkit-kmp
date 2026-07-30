---
title: "YMKBicycleSection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSection.html"
---
# YMKBicycleSection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleSection : NSObject
```

Section of the route.

## Summary

### Class methods

```swift
 init(weight: YMKBicycleWeight, geometry: YMKSubpolyline)
```

### Properties

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of a route or route section

```swift
var geometry: YMKSubpolyline { get }
```

Path of the route polyline for this section

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

Quantitative characteristics of a route or route section.

### geometry

```swift
var geometry: YMKSubpolyline { get }
```

Path of the route polyline for this section.
