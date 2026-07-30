---
title: "YMKDrivingLaneSign"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingLaneSign"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLaneSign.html"
---
# YMKDrivingLaneSign

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingLaneSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingLaneSign : NSObject
```

The sign showing a lane.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingLaneSign *)laneSignWithPosition:(nonnull YMKPolylinePosition *)position
                                           annotated:(nullable NSNumber *)annotated
                                               lanes:(nonnull NSArray<YMKDrivingLane *> *)lanes;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the sign

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *annotated;
```

Determines whether the sign should be annotated

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingLane *> *lanes;
```

The lane to display the sign in

## Class methods

### laneSignWithPosition:annotated:lanes:

```objectivec
+ (nonnull YMKDrivingLaneSign *)laneSignWithPosition:(nonnull YMKPolylinePosition *)position
                                           annotated:(nullable NSNumber *)annotated
                                               lanes:(nonnull NSArray<YMKDrivingLane *> *)lanes;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the sign.

### annotated

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *annotated;
```

Determines whether the sign should be annotated.

Optional field, can be nil.

### lanes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingLane *> *lanes;
```

The lane to display the sign in.
