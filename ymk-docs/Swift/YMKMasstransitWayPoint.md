---
title: "YMKMasstransitWayPoint"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitWayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitWayPoint.html"
---
# YMKMasstransitWayPoint

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitWayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitWayPoint : NSObject
```

A waypoint is the origin, destination or intermediate destination on the route. For each waypoint, the corresponding selected arrival point can be stored.

## Summary

### Class methods

```swift
 init(position: YMKPoint,
 selectedArrivalPoint: YMKPoint?,
 selectedDeparturePoint: YMKPoint?,
       context: String?,
       levelId: String?,
     levelName: String?)
```

### Properties

```swift
var position: YMKPoint { get }
```

Coordinates of the original waypoint from the request

```swift
var selectedArrivalPoint: YMKPoint? { get }
```

Coordinates of the arrival point that was selected for arrival at the waypoint

```swift
var selectedDeparturePoint: YMKPoint? { get }
```

Coordinates of the arrival point that was selected for departure from the waypoint

```swift
var context: String? { get }
```

request's context for this point

Optional field, can be nil

```swift
var levelId: String? { get }
```

Indoor level (floor) id

Optional field, can be nil

```swift
var levelName: String? { get }
```

Indoor level (floor) name

Optional field, can be nil

## Class methods

### init(position:selectedArrivalPoint:selectedDeparturePoint:context:levelId:levelName:)

```swift
 init(position: YMKPoint,
 selectedArrivalPoint: YMKPoint?,
 selectedDeparturePoint: YMKPoint?,
       context: String?,
       levelId: String?,
     levelName: String?)
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

Coordinates of the arrival point that was selected for arrival at the waypoint.

Optional field, can be nil.

### selectedDeparturePoint

```swift
var selectedDeparturePoint: YMKPoint? { get }
```

Coordinates of the arrival point that was selected for departure from the waypoint.

Optional field, can be nil.

### context

```swift
var context: String? { get }
```

request's context for this point

Optional field, can be nil.

### levelId

```swift
var levelId: String? { get }
```

Indoor level (floor) id

Optional field, can be nil.

### levelName

```swift
var levelName: String? { get }
```

Indoor level (floor) name

Optional field, can be nil.
