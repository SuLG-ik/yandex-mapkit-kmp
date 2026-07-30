---
title: "YMKDrivingWeight"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingWeight"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingWeight.html"
---
# YMKDrivingWeight

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingWeight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingWeight : NSObject
```

Quantitative characteristics of any segment of the route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                             timeWithTraffic:(nonnull YMKLocalizedValue *)timeWithTraffic
                                    distance:(nonnull YMKLocalizedValue *)distance;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Time to travel, not considering traffic

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *timeWithTraffic;
```

Time to travel, considering traffic

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

Distance to travel

## Class methods

### weightWithTime:timeWithTraffic:distance:

```objectivec
+ (nonnull YMKDrivingWeight *)weightWithTime:(nonnull YMKLocalizedValue *)time
                             timeWithTraffic:(nonnull YMKLocalizedValue *)timeWithTraffic
                                    distance:(nonnull YMKLocalizedValue *)distance;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *time;
```

Time to travel, not considering traffic.

### timeWithTraffic

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *timeWithTraffic;
```

Time to travel, considering traffic.

### distance

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *distance;
```

Distance to travel.
