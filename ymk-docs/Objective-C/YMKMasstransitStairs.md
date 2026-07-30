---
title: "YMKMasstransitStairs"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitStairs"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStairs.html"
---
# YMKMasstransitStairs

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStairs.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitStairs : NSObject
```

Represents stairs objects along the route

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitStairs *)stairsWithDirection:( YMKMasstransitStairsDirection)direction
                                              hasRamp:( BOOL)hasRamp;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKMasstransitStairsDirection direction;
```

```objectivec
@property (nonatomic, readonly) BOOL hasRamp;
```

Does stairs have a ramp

## Class methods

### stairsWithDirection:hasRamp:

```objectivec
+ (nonnull YMKMasstransitStairs *)stairsWithDirection:( YMKMasstransitStairsDirection)direction
                                              hasRamp:( BOOL)hasRamp;
```

## Properties

### direction

```objectivec
@property (nonatomic, readonly) YMKMasstransitStairsDirection direction;
```

### hasRamp

```objectivec
@property (nonatomic, readonly) BOOL hasRamp;
```

Does stairs have a ramp
