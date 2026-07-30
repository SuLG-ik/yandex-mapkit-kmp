---
title: "YMKDrivingDirectionSignRoad"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignRoad"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignRoad.html"
---
# YMKDrivingDirectionSignRoad

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignRoad.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignRoad : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignRoad *)directionSignRoadWithName:(nonnull NSString *)name
                                                             style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```

## Class methods

### directionSignRoadWithName:style:

```objectivec
+ (nonnull YMKDrivingDirectionSignRoad *)directionSignRoadWithName:(nonnull NSString *)name
                                                             style:(nonnull YMKDrivingDirectionSignStyle *)style;
```

## Properties

### name

```objectivec
@property (nonatomic, readonly, nonnull) NSString *name;
```

### style

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingDirectionSignStyle *style;
```
