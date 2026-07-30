---
title: "YMKGeo"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeo"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeo.html"
---
# YMKGeo

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeo.html)

```objectivec
@interface YMKGeo : NSObject
```

## Summary

### Class methods

```objectivec
+ (double)distanceWithFirstPoint:(nonnull YMKPoint *)firstPoint
                     secondPoint:(nonnull YMKPoint *)secondPoint;
```

Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en

```objectivec
+ (nonnull YMKPoint *)closestPointWithPoint:(nonnull YMKPoint *)point
                                    segment:(nonnull YMKSegment *)segment;
```

Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point

```objectivec
+ (nonnull YMKPoint *)pointOnSegmentByFactorWithSegment:
                          (nonnull YMKSegment *)segment
                                                 factor:(double)factor;
```

Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1]

```objectivec
+ (double)courseWithFirstPoint:(nonnull YMKPoint *)firstPoint
                   secondPoint:(nonnull YMKPoint *)secondPoint;
```

Calculate the course (bearing) between two points in degrees in the range [0, 360]

## Class methods

### distanceWithFirstPoint:secondPoint:

```objectivec
+ (double)distanceWithFirstPoint:(nonnull YMKPoint *)firstPoint
                     secondPoint:(nonnull YMKPoint *)secondPoint;
```

Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en.wikipedia.org/wiki/Haversine_formula

This formula is numerically better-conditioned for small distances, according to http://en.wikipedia.org/wiki/Great-circle_distance

### closestPointWithPoint:segment:

```objectivec
+ (nonnull YMKPoint *)closestPointWithPoint:(nonnull YMKPoint *)point
                                    segment:(nonnull YMKSegment *)segment;
```

Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point.

### pointOnSegmentByFactorWithSegment:factor:

```objectivec
+ (nonnull YMKPoint *)pointOnSegmentByFactorWithSegment:
                          (nonnull YMKSegment *)segment
                                                 factor:(double)factor;
```

Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1].

### courseWithFirstPoint:secondPoint:

```objectivec
+ (double)courseWithFirstPoint:(nonnull YMKPoint *)firstPoint
                   secondPoint:(nonnull YMKPoint *)secondPoint;
```

Calculate the course (bearing) between two points in degrees in the range [0, 360].
