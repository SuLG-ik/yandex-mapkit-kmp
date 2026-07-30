---
title: "YMKDrivingDirectionSignExit"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingDirectionSignExit"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignExit.html"
---
# YMKDrivingDirectionSignExit

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingDirectionSignExit.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingDirectionSignExit : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingDirectionSignExit *)directionSignExitWithName:(nonnull NSString *)name
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

### directionSignExitWithName:style:

```objectivec
+ (nonnull YMKDrivingDirectionSignExit *)directionSignExitWithName:(nonnull NSString *)name
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
