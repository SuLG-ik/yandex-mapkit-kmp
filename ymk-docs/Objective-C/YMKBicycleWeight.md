---
title: "YMKBicycleWeight"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleWeight"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleWeight.html"
---
# YMKBicycleWeight

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleWeight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleWeight : NSObject
```

Quantitative characteristics of a route or route section.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                                    distance:(nonnull YMKLocalizedValue *)distance;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Time to travel

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

Distance to travel

## Class methods

### weightWithTime:distance:

```objectivec
+ (nonnull YMKBicycleWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                                    distance:(nonnull YMKLocalizedValue *)distance;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Time to travel.

### distance

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

Distance to travel.
