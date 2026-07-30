---
title: "YMKManoeuvre"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKManoeuvre"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvre.html"
---
# YMKManoeuvre

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKManoeuvre.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKManoeuvre : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKManoeuvre *)manoeuvreWithAction:( YMKDrivingAction)action
                                     distance:(nonnull YMKLocalizedValue *)distance
                                 nextRoadName:(nullable NSString *)nextRoadName;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKDrivingAction action;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

```objectivec
@property (nonatomic, readonly, nullable) NSString *nextRoadName;
```

Optional field, can be nil

## Class methods

### manoeuvreWithAction:distance:nextRoadName:

```objectivec
+ (nonnull YMKManoeuvre *)manoeuvreWithAction:( YMKDrivingAction)action
                                     distance:(nonnull YMKLocalizedValue *)distance
                                 nextRoadName:(nullable NSString *)nextRoadName;
```

## Properties

### action

```objectivec
@property (nonatomic, readonly) YMKDrivingAction action;
```

### distance

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

### nextRoadName

```objectivec
@property (nonatomic, readonly, nullable) NSString *nextRoadName;
```

Optional field, can be nil.
