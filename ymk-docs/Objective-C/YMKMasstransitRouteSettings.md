---
title: "YMKMasstransitRouteSettings"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouteSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteSettings.html"
---
# YMKMasstransitRouteSettings

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteSettings.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouteSettings : NSObject
```

Route settings that were used by the mass transit router for a specific route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRouteSettings *)routeSettingsWithAvoidTypes:(nonnull NSArray<NSString *> *)avoidTypes
                                                         acceptTypes:(nonnull NSArray<NSString *> *)acceptTypes;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *avoidTypes;
```

Transport types that the router avoided

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *acceptTypes;
```

Transport types that were allowed even if they are in the list of avoided types

## Class methods

### routeSettingsWithAvoidTypes:acceptTypes:

```objectivec
+ (nonnull YMKMasstransitRouteSettings *)routeSettingsWithAvoidTypes:(nonnull NSArray<NSString *> *)avoidTypes
                                                         acceptTypes:(nonnull NSArray<NSString *> *)acceptTypes;
```

## Properties

### avoidTypes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *avoidTypes;
```

Transport types that the router avoided.

### acceptTypes

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSString *> *acceptTypes;
```

Transport types that were allowed even if they are in the list of avoided types.
