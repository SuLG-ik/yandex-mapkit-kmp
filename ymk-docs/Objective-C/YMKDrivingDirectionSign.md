---
title: "YMKDrivingDirectionSign"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSign"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSign.html"
---
# YMKDrivingDirectionSign

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSign : NSObject
```

The sign showing named directions.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSign *)directionSignWithPosition:(nonnull YMKPolylinePosition *)position
                                                     direction:(nullable NSNumber *)direction
                                                         items:(nonnull NSArray<YMKDrivingDirectionSignItem *> *)items;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the sign

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *direction;
```

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingDirectionSignItem *> *items;
```

## Class methods

### directionSignWithPosition:direction:items:

```objectivec
+ (nonnull YMKDrivingDirectionSign *)directionSignWithPosition:(nonnull YMKPolylinePosition *)position
                                                     direction:(nullable NSNumber *)direction
                                                         items:(nonnull NSArray<YMKDrivingDirectionSignItem *> *)items;
```

## Properties

### position

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolylinePosition *position;
```

The position of the sign.

### direction

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *direction;
```

Optional field, can be nil.

### items

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingDirectionSignItem *> *items;
```
