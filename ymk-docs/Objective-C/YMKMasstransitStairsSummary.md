---
title: "YMKMasstransitStairsSummary"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitStairsSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStairsSummary.html"
---
# YMKMasstransitStairsSummary

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitStairsSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitStairsSummary : NSObject
```

Represents summary info about stairs along the route

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitStairsSummary *)stairsSummaryWithNumberOfStairs:( NSUInteger)numberOfStairs
                                                  numberOfStairsWithRamp:( NSUInteger)numberOfStairsWithRamp;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger numberOfStairs;
```

Number of stairs along the route

```objectivec
@property (nonatomic, readonly) NSUInteger numberOfStairsWithRamp;
```

Number of stairs with ramps along the route

## Class methods

### stairsSummaryWithNumberOfStairs:numberOfStairsWithRamp:

```objectivec
+ (nonnull YMKMasstransitStairsSummary *)stairsSummaryWithNumberOfStairs:( NSUInteger)numberOfStairs
                                                  numberOfStairsWithRamp:( NSUInteger)numberOfStairsWithRamp;
```

## Properties

### numberOfStairs

```objectivec
@property (nonatomic, readonly) NSUInteger numberOfStairs;
```

Number of stairs along the route.

### numberOfStairsWithRamp

```objectivec
@property (nonatomic, readonly) NSUInteger numberOfStairsWithRamp;
```

Number of stairs with ramps along the route.
