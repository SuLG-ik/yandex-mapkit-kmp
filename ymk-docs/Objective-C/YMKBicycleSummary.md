---
title: "YMKBicycleSummary"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSummary.html"
---
# YMKBicycleSummary

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleSummary : NSObject
```

Contains brief information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleSummary *)summaryWithWeight:(nonnull YMKBicycleWeight *)weight
                                           flags:(nullable YMKBicycleFlags *)flags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route

```objectivec
@property (nonatomic, readonly, nullable) YMKBicycleFlags *flags;
```

Specific properties of the route

## Class methods

### summaryWithWeight:flags:

```objectivec
+ (nonnull YMKBicycleSummary *)summaryWithWeight:(nonnull YMKBicycleWeight *)weight
                                           flags:(nullable YMKBicycleFlags *)flags;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route.

### flags

```objectivec
@property (nonatomic, readonly, nullable) YMKBicycleFlags *flags;
```

Specific properties of the route.

Optional field, can be nil.
