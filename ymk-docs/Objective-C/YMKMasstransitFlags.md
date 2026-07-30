---
title: "YMKMasstransitFlags"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitFlags.html"
---
# YMKMasstransitFlags

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitFlags : NSObject
```

Indicates whether the suggested route has one or more of the specified properties.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitFlags *)flagsWithRequiresAccessPass:( BOOL)requiresAccessPass
                                                 hasAutoRoad:( BOOL)hasAutoRoad;
```

### Instance methods

```objectivec
- (nonnull YMKMasstransitFlags *)init;
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
+ (nonnull YMKMasstransitFlags *)flagsWithRequiresAccessPass:( BOOL)requiresAccessPass
                                                 hasAutoRoad:( BOOL)hasAutoRoad;
```

## Instance methods

### init

```objectivec
- (nonnull YMKMasstransitFlags *)init;
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
