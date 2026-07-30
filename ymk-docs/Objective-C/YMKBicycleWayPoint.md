---
title: "YMKBicycleWayPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleWayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleWayPoint.html"
---
# YMKBicycleWayPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleWayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleWayPoint : NSObject
```

A waypoint is the origin, destination or intermediate destination on the route. For each way point, the corresponding selected arrival point can be stored.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleWayPoint *)wayPointWithPosition:(nonnull YMKPoint *)position
                                selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the original waypoint from the request

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedArrivalPoint;
```

Coordinates of the selected arrival point

## Class methods

### wayPointWithPosition:selectedArrivalPoint:

```objectivec
+ (nonnull YMKBicycleWayPoint *)wayPointWithPosition:(nonnull YMKPoint *)position
                                selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the original waypoint from the request.

### selectedArrivalPoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedArrivalPoint;
```

Coordinates of the selected arrival point.

Optional field, can be nil.
