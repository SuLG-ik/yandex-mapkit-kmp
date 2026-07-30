---
title: "YMKRequestPoint"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRequestPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRequestPoint.html"
---
# YMKRequestPoint

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRequestPoint.html)

```swift
class YMKRequestPoint : NSObject
```

There are two types of request points. A waypoint is a destination. Use it when you plan to stop there. Via points (throughpoints) correct the route to make it pass through all the via points. Waypoints are guaranteed to be between sections in the resulting route. Via points are embedded into sections.

For each request point, you can provide a point context. It's an opaque string that describe entrances, driving arrival points and so on. If such context is provided then a client will get routes to those additional points.

## Summary

### Class methods

```swift
 init(point: YMKPoint,
       type: YMKRequestPointType,
 pointContext: String?,
 drivingArrivalPointId: String?,
 indoorLevelId: String?)
```

### Properties

```swift
var point: YMKPoint { get }
```

The request point

```swift
var type: YMKRequestPointType { get }
```

The type of request point specified

```swift
var pointContext: String? { get }
```

Opaque string that describe entrances, driving arrival points and so on

```swift
var drivingArrivalPointId: String? { get }
```

Specifies what driving arrival point to use

```swift
var indoorLevelId: String? { get }
```

Indoor level (floor) id

Optional field, can be nil

## Class methods

### init(point:type:pointContext:drivingArrivalPointId:indoorLevelId:)

```swift
 init(point: YMKPoint,
       type: YMKRequestPointType,
 pointContext: String?,
 drivingArrivalPointId: String?,
 indoorLevelId: String?)
```

## Properties

### point

```swift
var point: YMKPoint { get }
```

The request point.

### type

```swift
var type: YMKRequestPointType { get }
```

The type of request point specified.

### pointContext

```swift
var pointContext: String? { get }
```

Opaque string that describe entrances, driving arrival points and so on.

Optional field, can be nil.

### drivingArrivalPointId

```swift
var drivingArrivalPointId: String? { get }
```

Specifies what driving arrival point to use. If point is not specified then server will select one.

Optional field, can be nil.

### indoorLevelId

```swift
var indoorLevelId: String? { get }
```

Indoor level (floor) id

Optional field, can be nil.
