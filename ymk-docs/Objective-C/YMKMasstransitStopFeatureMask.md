---
title: "YMKMasstransitStopFeatureMask"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitStopFeatureMask"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStopFeatureMask.html"
---
# YMKMasstransitStopFeatureMask

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStopFeatureMask.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitStopFeatureMask : NSObject
```

Describes various features a stop can have.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitStopFeatureMask *)stopFeatureMaskWithCooled:( BOOL)cooled
                                                              heated:( BOOL)heated;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL cooled;
```

The stop is cooled at hot weather conditions

```objectivec
@property (nonatomic, readonly) BOOL heated;
```

The stop is heated at cold weather conditions

## Class methods

### stopFeatureMaskWithCooled:heated:

```objectivec
+ (nonnull YMKMasstransitStopFeatureMask *)stopFeatureMaskWithCooled:( BOOL)cooled
                                                              heated:( BOOL)heated;
```

## Properties

### cooled

```objectivec
@property (nonatomic, readonly) BOOL cooled;
```

The stop is cooled at hot weather conditions.

### heated

```objectivec
@property (nonatomic, readonly) BOOL heated;
```

The stop is heated at cold weather conditions.
