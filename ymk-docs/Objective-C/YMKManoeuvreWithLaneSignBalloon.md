---
title: "YMKManoeuvreWithLaneSignBalloon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKManoeuvreWithLaneSignBalloon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvreWithLaneSignBalloon.html"
---
# YMKManoeuvreWithLaneSignBalloon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvreWithLaneSignBalloon.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKManoeuvreWithLaneSignBalloon : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKManoeuvreWithLaneSignBalloon *)manoeuvreWithLaneSignBalloonWithManoeuvre:(nonnull YMKManoeuvre *)manoeuvre
                                                                              laneSign:(nonnull YMKDrivingLaneSign *)laneSign
                                                                         directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKManoeuvre *manoeuvre;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingLaneSign *laneSign;
```

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil

## Class methods

### manoeuvreWithLaneSignBalloonWithManoeuvre:laneSign:directionSign:

```objectivec
+ (nonnull YMKManoeuvreWithLaneSignBalloon *)manoeuvreWithLaneSignBalloonWithManoeuvre:(nonnull YMKManoeuvre *)manoeuvre
                                                                              laneSign:(nonnull YMKDrivingLaneSign *)laneSign
                                                                         directionSign:(nullable YMKDrivingDirectionSign *)directionSign;
```

## Properties

### manoeuvre

```objectivec
@property (nonatomic, readonly, nonnull) YMKManoeuvre *manoeuvre;
```

### laneSign

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingLaneSign *laneSign;
```

### directionSign

```objectivec
@property (nonatomic, readonly, nullable) YMKDrivingDirectionSign *directionSign;
```

Optional field, can be nil.
