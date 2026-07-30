---
title: "YMKNavigationSpeedLimitsRules"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationSpeedLimitsRules"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSpeedLimitsRules.html"
---
# YMKNavigationSpeedLimitsRules

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationSpeedLimitsRules.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationSpeedLimitsRules : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKNavigationSpeedLimitsRules *)navigationSpeedLimitsRulesWithUrban:( YMKNavigationSpeedLimitsRulesType)urban
                                                                         rural:( YMKNavigationSpeedLimitsRulesType)rural
                                                                    expressway:( YMKNavigationSpeedLimitsRulesType)expressway;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType urban;
```

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType rural;
```

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType expressway;
```

## Class methods

### navigationSpeedLimitsRulesWithUrban:rural:expressway:

```objectivec
+ (nonnull YMKNavigationSpeedLimitsRules *)navigationSpeedLimitsRulesWithUrban:( YMKNavigationSpeedLimitsRulesType)urban
                                                                         rural:( YMKNavigationSpeedLimitsRulesType)rural
                                                                    expressway:( YMKNavigationSpeedLimitsRulesType)expressway;
```

## Properties

### urban

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType urban;
```

### rural

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType rural;
```

### expressway

```objectivec
@property (nonatomic, readonly) YMKNavigationSpeedLimitsRulesType expressway;
```
