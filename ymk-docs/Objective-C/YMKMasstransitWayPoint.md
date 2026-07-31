---
title: "YMKMasstransitWayPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitWayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWayPoint.html"
---
# YMKMasstransitWayPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitWayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitWayPoint : NSObject
```

A waypoint is the origin, destination or intermediate destination on the route. For each waypoint, the corresponding selected arrival point can be stored.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitWayPoint *)wayPointWithPosition:(nonnull YMKPoint *)position
                                    selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint
                                  selectedDeparturePoint:(nullable YMKPoint *)selectedDeparturePoint
                                                 context:(nullable NSString *)context
                                                 levelId:(nullable NSString *)levelId
                                               levelName:(nullable NSString *)levelName;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *position;
```

Coordinates of the original waypoint from the request

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedArrivalPoint;
```

Coordinates of the arrival point that was selected for arrival at the waypoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedDeparturePoint;
```

Coordinates of the arrival point that was selected for departure from the waypoint

```objectivec
@property (nonatomic, readonly, nullable) NSString *context;
```

request's context for this point

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *levelId;
```

Indoor level (floor) id

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable) NSString *levelName;
```

Indoor level (floor) name

Optional field, can be nil

## Class methods

### wayPointWithPosition:selectedArrivalPoint:selectedDeparturePoint:context:levelId:levelName:

```objectivec
+ (nonnull YMKMasstransitWayPoint *)wayPointWithPosition:(nonnull YMKPoint *)position
                                    selectedArrivalPoint:(nullable YMKPoint *)selectedArrivalPoint
                                  selectedDeparturePoint:(nullable YMKPoint *)selectedDeparturePoint
                                                 context:(nullable NSString *)context
                                                 levelId:(nullable NSString *)levelId
                                               levelName:(nullable NSString *)levelName;
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

Coordinates of the arrival point that was selected for arrival at the waypoint.

Optional field, can be nil.

### selectedDeparturePoint

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *selectedDeparturePoint;
```

Coordinates of the arrival point that was selected for departure from the waypoint.

Optional field, can be nil.

### context

```objectivec
@property (nonatomic, readonly, nullable) NSString *context;
```

request's context for this point

Optional field, can be nil.

### levelId

```objectivec
@property (nonatomic, readonly, nullable) NSString *levelId;
```

Indoor level (floor) id

Optional field, can be nil.

### levelName

```objectivec
@property (nonatomic, readonly, nullable) NSString *levelName;
```

Indoor level (floor) name

Optional field, can be nil.
