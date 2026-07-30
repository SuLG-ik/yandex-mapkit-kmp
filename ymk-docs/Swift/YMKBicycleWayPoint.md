---
title: "YMKBicycleWayPoint"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleWayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleWayPoint.html"
---
# YMKBicycleWayPoint

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleWayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleWayPoint : NSObject
```

A waypoint is the origin, destination or intermediate destination on the route. For each way point, the corresponding selected arrival point can be stored.

## Summary

### Class methods

```swift
 init(position: YMKPoint, selectedArrivalPoint: YMKPoint?)
```

### Properties

```swift
var position: YMKPoint { get }
```

Coordinates of the original waypoint from the request

```swift
var selectedArrivalPoint: YMKPoint? { get }
```

Coordinates of the selected arrival point

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

Coordinates of the original waypoint from the request.

### selectedArrivalPoint

```swift
var selectedArrivalPoint: YMKPoint? { get }
```

Coordinates of the selected arrival point.

Optional field, can be nil.
