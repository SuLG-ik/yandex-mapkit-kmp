---
title: "YMKGeo"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeo"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeo.html"
---
# YMKGeo

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeo.html)

```swift
class YMKGeo : NSObject
```

## Summary

### Class methods

```swift
class func distance(withFirstPoint firstPoint: YMKPoint,
                                  secondPoint: YMKPoint) -> Double
```

Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en

```swift
class func closestPoint(with point: YMKPoint, segment: YMKSegment) -> YMKPoint
```

Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point

```swift
class func pointOnSegmentByFactor(with segment: YMKSegment,
                                        factor: Double) -> YMKPoint
```

Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1]

```swift
class func course(withFirstPoint firstPoint: YMKPoint,
                                secondPoint: YMKPoint) -> Double
```

Calculate the course (bearing) between two points in degrees in the range [0, 360]

## Class methods

### distance(withFirstPoint:secondPoint:)

```swift
class func distance(withFirstPoint firstPoint: YMKPoint,
                                  secondPoint: YMKPoint) -> Double
```

Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en.wikipedia.org/wiki/Haversine_formula

This formula is numerically better-conditioned for small distances, according to http://en.wikipedia.org/wiki/Great-circle_distance

### closestPoint(with:segment:)

```swift
class func closestPoint(with point: YMKPoint, segment: YMKSegment) -> YMKPoint
```

Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point.

### pointOnSegmentByFactor(with:factor:)

```swift
class func pointOnSegmentByFactor(with segment: YMKSegment,
                                        factor: Double) -> YMKPoint
```

Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1].

### course(withFirstPoint:secondPoint:)

```swift
class func course(withFirstPoint firstPoint: YMKPoint,
                                secondPoint: YMKPoint) -> Double
```

Calculate the course (bearing) between two points in degrees in the range [0, 360].
