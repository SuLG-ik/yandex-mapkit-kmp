---
title: "YMKFitnessOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKFitnessOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKFitnessOptions.html"
---
# YMKFitnessOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKFitnessOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKFitnessOptions : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKFitnessOptions *)fitnessOptionsWithAvoidSteep:( BOOL)avoidSteep
                                                avoidStairs:( BOOL)avoidStairs;
```

### Instance methods

```objectivec
- (nonnull YMKFitnessOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly) BOOL avoidSteep;
```

If true, router will try avoid steep (in height meaning) routes

```objectivec
@property (nonatomic, readonly) BOOL avoidStairs;
```

If true, router will try avoid stairs

## Class methods

### fitnessOptionsWithAvoidSteep:avoidStairs:

```objectivec
+ (nonnull YMKFitnessOptions *)fitnessOptionsWithAvoidSteep:( BOOL)avoidSteep
                                                avoidStairs:( BOOL)avoidStairs;
```

## Instance methods

### init

```objectivec
- (nonnull YMKFitnessOptions *)init;
```

## Properties

### avoidSteep

```objectivec
@property (nonatomic, readonly) BOOL avoidSteep;
```

If true, router will try avoid steep (in height meaning) routes.

### avoidStairs

```objectivec
@property (nonatomic, readonly) BOOL avoidStairs;
```

If true, router will try avoid stairs.
