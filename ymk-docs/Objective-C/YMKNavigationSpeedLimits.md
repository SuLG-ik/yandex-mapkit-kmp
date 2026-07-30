---
title: "YMKNavigationSpeedLimits"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationSpeedLimits"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSpeedLimits.html"
---
# YMKNavigationSpeedLimits

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSpeedLimits.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationSpeedLimits : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKNavigationSpeedLimits *)navigationSpeedLimitsWithUrban:(nonnull YMKLocalizedValue *)urban
                                                               rural:(nonnull YMKLocalizedValue *)rural
                                                          expressway:(nonnull YMKLocalizedValue *)expressway;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *urban;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *rural;
```

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *expressway;
```

## Class methods

### navigationSpeedLimitsWithUrban:rural:expressway:

```objectivec
+ (nonnull YMKNavigationSpeedLimits *)navigationSpeedLimitsWithUrban:(nonnull YMKLocalizedValue *)urban
                                                               rural:(nonnull YMKLocalizedValue *)rural
                                                          expressway:(nonnull YMKLocalizedValue *)expressway;
```

## Properties

### urban

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *urban;
```

### rural

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *rural;
```

### expressway

```objectivec
@property (nonatomic, readonly, nonnull) YMKLocalizedValue *expressway;
```
