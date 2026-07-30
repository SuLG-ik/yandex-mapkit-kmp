---
title: "YMKBicycleFlags"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleFlags.html"
---
# YMKBicycleFlags

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleFlags : NSObject
```

Indicates whether the suggested route has one or more of the specified properties.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleFlags *)flagsWithRequiresAccessPass:( BOOL)requiresAccessPass
                                             hasAutoRoad:( BOOL)hasAutoRoad;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL requiresAccessPass;
```

Indicates whether the suggested route requires an access pass

```objectivec
@property (nonatomic, readonly) BOOL hasAutoRoad;
```

Indicates whether the suggested route includes automotive roads

## Class methods

### flagsWithRequiresAccessPass:hasAutoRoad:

```objectivec
+ (nonnull YMKBicycleFlags *)flagsWithRequiresAccessPass:( BOOL)requiresAccessPass
                                             hasAutoRoad:( BOOL)hasAutoRoad;
```

## Properties

### requiresAccessPass

```objectivec
@property (nonatomic, readonly) BOOL requiresAccessPass;
```

Indicates whether the suggested route requires an access pass.

### hasAutoRoad

```objectivec
@property (nonatomic, readonly) BOOL hasAutoRoad;
```

Indicates whether the suggested route includes automotive roads.
