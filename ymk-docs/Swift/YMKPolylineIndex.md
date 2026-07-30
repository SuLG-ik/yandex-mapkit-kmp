---
title: "YMKPolylineIndex"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolylineIndex"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineIndex.html"
---
# YMKPolylineIndex

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineIndex.html)

```swift
class YMKPolylineIndex : NSObject
```

Provides methods for binding locations to a polyline

## Summary

### Instance methods

```swift
func closestPolylinePosition(with point: YMKPoint,
                               priority: YMKPolylineIndexPriority,
                        maxLocationBias: Double) -> YMKPolylinePosition?
```

Finds closest polyline position

```swift
func closestPolylinePosition(with point: YMKPoint,
                           positionFrom: YMKPolylinePosition,
                             positionTo: YMKPolylinePosition,
                        maxLocationBias: Double) -> YMKPolylinePosition?
```

Finds the closest polyline position between the two positions

## Instance methods

### closestPolylinePosition(with:priority:maxLocationBias:)

```swift
func closestPolylinePosition(with point: YMKPoint,
                               priority: YMKPolylineIndexPriority,
                        maxLocationBias: Double) -> YMKPolylinePosition?
```

Finds closest polyline position. Returns null if there is no position that satisfies the condition distance(point, position) < maxLocationBias.

Two modes are available: 1. Find the closest polyline position to a raw point YMKPolylineIndexPriorityClosestToRawPoint 2. Find the closest polyline position to the polyline start YMKPolylineIndexPriorityClosestToStart.

### closestPolylinePosition(with:positionFrom:positionTo:maxLocationBias:)

```swift
func closestPolylinePosition(with point: YMKPoint,
                           positionFrom: YMKPolylinePosition,
                             positionTo: YMKPolylinePosition,
                        maxLocationBias: Double) -> YMKPolylinePosition?
```

Finds the closest polyline position between the two positions. Returns null if there is no position that satisfies the condition distance(point, position) < maxLocationBias.
