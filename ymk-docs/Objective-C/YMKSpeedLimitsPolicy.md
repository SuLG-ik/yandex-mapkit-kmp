---
title: "YMKSpeedLimitsPolicy"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpeedLimitsPolicy"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedLimitsPolicy.html"
---
# YMKSpeedLimitsPolicy

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedLimitsPolicy.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKSpeedLimitsPolicy : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKNavigationSpeedLimits *)customSpeedLimitsWithToleranceRatio:
    (double)toleranceRatio;
```

For example ratio = 0

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKNavigationSpeedLimits *legalSpeedLimits;
```

For example for Russia 60/90/110 km/h

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKNavigationSpeedLimitsRules *speedLimitsRules;
```

## Instance methods

### customSpeedLimitsWithToleranceRatio:

```objectivec
- (nonnull YMKNavigationSpeedLimits *)customSpeedLimitsWithToleranceRatio:
    (double)toleranceRatio;
```

For example ratio = 0.8 and current speed limit is 60 km/h - for Russia: enforcement tolerance is 20 km/h for all speed limits => we should start warning the user when current speed > 60 + 20 * 0.8 = 76 km/h - for Turkey: enforcement tolerance is 10 percent over the speed limit => we should start warning the user when current speed > 60 + 60 * 0.1 * 0.8 = 64.8 km/h

## Properties

### legalSpeedLimits

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKNavigationSpeedLimits *legalSpeedLimits;
```

For example for Russia 60/90/110 km/h

### speedLimitsRules

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKNavigationSpeedLimitsRules *speedLimitsRules;
```
