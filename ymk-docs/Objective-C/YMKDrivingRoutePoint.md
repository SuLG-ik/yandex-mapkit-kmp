---
title: "YMKDrivingRoutePoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRoutePoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoutePoint.html"
---
# YMKDrivingRoutePoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoutePoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRoutePoint : NSObject
```

Route point metadata (exists for both waypoints and via points).

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRoutePoint *)routePointWithPosition:(nonnull YMKPoint *)position
                                    selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Position of original route point

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedArrivalPoint;
```

Arrival point selected for routing

## Class methods

### routePointWithPosition:selectedArrivalPoint:

```objectivec
+ (nonnull YMKDrivingRoutePoint *)routePointWithPosition:(nonnull YMKPoint *)position
                                    selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Position of original route point.

### selectedArrivalPoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedArrivalPoint;
```

Arrival point selected for routing.

Optional field, can be nil.
