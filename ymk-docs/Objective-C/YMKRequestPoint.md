---
title: "YMKRequestPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRequestPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRequestPoint.html"
---
# YMKRequestPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRequestPoint.html)

```objectivec
@interface YMKRequestPoint : NSObject
```

There are two types of request points. A waypoint is a destination. Use it when you plan to stop there. Via points (throughpoints) correct the route to make it pass through all the via points. Waypoints are guaranteed to be between sections in the resulting route. Via points are embedded into sections.

For each request point, you can provide a point context. It's an opaque string that describe entrances, driving arrival points and so on. If such context is provided then a client will get routes to those additional points.

## Summary

### Class methods

```objectivec
+ (nonnull YMKRequestPoint *)requestPointWithPoint:(nonnull YMKPoint *)point
                                              type:( YMKRequestPointType)type
                                      pointContext:(nullable NSString *)pointContext
                             drivingArrivalPointId:(nullable NSString *)drivingArrivalPointId
                                     indoorLevelId:(nullable NSString *)indoorLevelId;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

The request point

```objectivec
@property (nonatomic, readonly) YMKRequestPointType type;
```

The type of request point specified

```objectivec
@property (nonatomic, readonly, nullable) NSString *pointContext;
```

Opaque string that describe entrances, driving arrival points and so on

```objectivec
@property (nonatomic, readonly, nullable) NSString *drivingArrivalPointId;
```

Specifies what driving arrival point to use

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevelId;
```

Indoor level (floor) id

Optional field, can be nil

## Class methods

### requestPointWithPoint:type:pointContext:drivingArrivalPointId:indoorLevelId:

```objectivec
+ (nonnull YMKRequestPoint *)requestPointWithPoint:(nonnull YMKPoint *)point
                                              type:( YMKRequestPointType)type
                                      pointContext:(nullable NSString *)pointContext
                             drivingArrivalPointId:(nullable NSString *)drivingArrivalPointId
                                     indoorLevelId:(nullable NSString *)indoorLevelId;
```

## Properties

### point

```objectivec
@property (nonatomic, readonly, nonnull) YMKPoint *point;
```

The request point.

### type

```objectivec
@property (nonatomic, readonly) YMKRequestPointType type;
```

The type of request point specified.

### pointContext

```objectivec
@property (nonatomic, readonly, nullable) NSString *pointContext;
```

Opaque string that describe entrances, driving arrival points and so on.

Optional field, can be nil.

### drivingArrivalPointId

```objectivec
@property (nonatomic, readonly, nullable) NSString *drivingArrivalPointId;
```

Specifies what driving arrival point to use. If point is not specified then server will select one.

Optional field, can be nil.

### indoorLevelId

```objectivec
@property (nonatomic, readonly, nullable) NSString *indoorLevelId;
```

Indoor level (floor) id

Optional field, can be nil.
