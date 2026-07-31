---
title: "YMKRoutePosition"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoutePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoutePosition.html"
---
# YMKRoutePosition

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoutePosition.html)

```swift
class YMKRoutePosition : NSObject
```

## Summary

### Instance methods

```swift
func onRoute(withRouteId routeId: String) -> Bool
```

Check if this position on the same route as passed

```swift
func positionOnRoute(withRouteId routeId: String) -> YMKPolylinePosition?
```

Return polyline position on route

```swift
func advance(withDistance distance: Double) -> YMKRoutePosition
```

Create position shifted by distance

```swift
func distanceToWith(to: YMKRoutePosition) -> NSNumber?
```

Distance to another point on the route

```swift
func precedes(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position precedes another position on the route

```swift
func precedesOrEquals(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position precedes or equals another position on the route

```swift
func equals(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position equals another position on the route

```swift
func heading() -> Double
```

Heading movement on the route at this position

```swift
func distanceToFinish() -> Double
```

Distance to the end of the route

```swift
func timeToFinish() -> Double
```

Time to the end of the route

### Properties

```swift
var point: YMKPoint { get }
```

As point on the map

## Instance methods

### onRoute(withRouteId:)

```swift
func onRoute(withRouteId routeId: String) -> Bool
```

Check if this position on the same route as passed.

### positionOnRoute(withRouteId:)

```swift
func positionOnRoute(withRouteId routeId: String) -> YMKPolylinePosition?
```

Return polyline position on route. If the position not on the passed route none will be returned.

### advance(withDistance:)

```swift
func advance(withDistance distance: Double) -> YMKRoutePosition
```

Create position shifted by distance. If the distance is more than remains route length, the end of the route will be returned. If the distance is less than a negative distance from the start, the beginning of the route will be returned.

### distanceToWith(to:)

```swift
func distanceToWith(to: YMKRoutePosition) -> NSNumber?
```

Distance to another point on the route. Return none if point on another route. May be less 0 if position "to" stay before this position.

### precedes(withAnother:)

```swift
func precedes(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position precedes another position on the route. Throws if another position belongs to another route.

### precedesOrEquals(withAnother:)

```swift
func precedesOrEquals(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position precedes or equals another position on the route. Throws if another position belongs to another route.

### equals(withAnother:)

```swift
func equals(withAnother another: YMKRoutePosition) -> Bool
```

Determines if position equals another position on the route. Throws if another position belongs to another route.

### heading()

```swift
func heading() -> Double
```

Heading movement on the route at this position. It is equal heading of the segment which is belonged position.

### distanceToFinish()

```swift
func distanceToFinish() -> Double
```

Distance to the end of the route.

### timeToFinish()

```swift
func timeToFinish() -> Double
```

Time to the end of the route.

## Properties

### point

```swift
var point: YMKPoint { get }
```

As point on the map
