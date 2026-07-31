---
title: "YMKRouteOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRouteOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteOptions.html"
---
# YMKRouteOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRouteOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKRouteOptions : NSObject
```

Settings for router, which help personalize or optimize routes

## Summary

### Class methods

```objectivec
+ (nonnull YMKRouteOptions *)routeOptionsWithFitnessOptions:(nonnull YMKFitnessOptions *)fitnessOptions;
```

### Instance methods

```objectivec
- (nonnull YMKRouteOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKFitnessOptions *fitnessOptions;
```

## Class methods

### routeOptionsWithFitnessOptions:

```objectivec
+ (nonnull YMKRouteOptions *)routeOptionsWithFitnessOptions:(nonnull YMKFitnessOptions *)fitnessOptions;
```

## Instance methods

### init

```objectivec
- (nonnull YMKRouteOptions *)init;
```

## Properties

### fitnessOptions

```objectivec
@property (nonatomic, readonly, nonnull) YMKFitnessOptions *fitnessOptions;
```
