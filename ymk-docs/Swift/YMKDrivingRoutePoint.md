---
title: "YMKDrivingRoutePoint"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingRoutePoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRoutePoint.html"
---
# YMKDrivingRoutePoint

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRoutePoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingRoutePoint : NSObject
```

Route point metadata (exists for both waypoints and via points).

## Summary

### Class methods

```swift
 init(position: YMKPoint, selectedArrivalPoint: YMKPoint?)
```

### Properties

```swift
var position: YMKPoint { get }
```

Position of original route point

```swift
var selectedArrivalPoint: YMKPoint? { get }
```

Arrival point selected for routing

## Class methods

### init(position:selectedArrivalPoint:)

```swift
 init(position: YMKPoint, selectedArrivalPoint: YMKPoint?)
```

## Properties

### position

```swift
var position: YMKPoint { get }
```

Position of original route point.

### selectedArrivalPoint

```swift
var selectedArrivalPoint: YMKPoint? { get }
```

Arrival point selected for routing.

Optional field, can be nil.
