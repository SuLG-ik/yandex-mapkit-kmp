---
title: "YMKPolylineIndex"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylineIndex"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineIndex.html"
---
# YMKPolylineIndex

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineIndex.html)

```objectivec
@interface YMKPolylineIndex : NSObject
```

Provides methods for binding locations to a polyline

## Summary

### Instance methods

```objectivec
- (nullable YMKPolylinePosition *)
    closestPolylinePositionWithPoint:(nonnull YMKPoint *)point
                            priority:(YMKPolylineIndexPriority)priority
                     maxLocationBias:(double)maxLocationBias;
```

Finds closest polyline position

```objectivec
- (nullable YMKPolylinePosition *)
    closestPolylinePositionWithPoint:(nonnull YMKPoint *)point
                        positionFrom:(nonnull YMKPolylinePosition *)positionFrom
                          positionTo:(nonnull YMKPolylinePosition *)positionTo
                     maxLocationBias:(double)maxLocationBias;
```

Finds the closest polyline position between the two positions

## Instance methods

### closestPolylinePositionWithPoint:priority:maxLocationBias:

```objectivec
- (nullable YMKPolylinePosition *)
    closestPolylinePositionWithPoint:(nonnull YMKPoint *)point
                            priority:(YMKPolylineIndexPriority)priority
                     maxLocationBias:(double)maxLocationBias;
```

Finds closest polyline position. Returns null if there is no position that satisfies the condition distance(point, position) < maxLocationBias.

Two modes are available: 1. Find the closest polyline position to a raw point YMKPolylineIndexPriorityClosestToRawPoint 2. Find the closest polyline position to the polyline start YMKPolylineIndexPriorityClosestToStart.

### closestPolylinePositionWithPoint:positionFrom:positionTo:maxLocationBias:

```objectivec
- (nullable YMKPolylinePosition *)
    closestPolylinePositionWithPoint:(nonnull YMKPoint *)point
                        positionFrom:(nonnull YMKPolylinePosition *)positionFrom
                          positionTo:(nonnull YMKPolylinePosition *)positionTo
                     maxLocationBias:(double)maxLocationBias;
```

Finds the closest polyline position between the two positions. Returns null if there is no position that satisfies the condition distance(point, position) < maxLocationBias.
