---
title: "YMKLaneSignBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLaneSignBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLaneSignBalloon.html"
---
# YMKLaneSignBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLaneSignBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKLaneSignBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKLaneSignBalloon *)laneSignBalloonWithLaneSign:(nonnull YMKDrivingLaneSign *)laneSign
                                              directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingLaneSign *laneSign;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil

## Class methods

### laneSignBalloonWithLaneSign:directionSign:

```objectivec
+ (nonnull YMKLaneSignBalloon *)laneSignBalloonWithLaneSign:(nonnull YMKDrivingLaneSign *)laneSign
                                              directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

## Properties

### laneSign

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingLaneSign *laneSign;
```

### directionSign

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil.
