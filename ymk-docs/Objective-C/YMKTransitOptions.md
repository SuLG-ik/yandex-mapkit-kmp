---
title: "YMKTransitOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKTransitOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransitOptions.html"
---
# YMKTransitOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKTransitOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKTransitOptions : NSObject
```

User-defined options, like time options and filter options.

## Summary

### Class methods

```objectivec
+ (nonnull YMKTransitOptions *)transitOptionsWithAvoid:( YMKFilterVehicleTypes)avoid
                                           timeOptions:(nonnull YMKTimeOptions *)timeOptions;
```

### Instance methods

```objectivec
- (nonnull YMKTransitOptions *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKFilterVehicleTypes avoid;
```

Transport types that the router will avoid

```objectivec
@property (nonatomic, readonly, nonnull) YMKTimeOptions *timeOptions;
```

Desired departure/arrival time settings

## Class methods

### transitOptionsWithAvoid:timeOptions:

```objectivec
+ (nonnull YMKTransitOptions *)transitOptionsWithAvoid:( YMKFilterVehicleTypes)avoid
                                           timeOptions:(nonnull YMKTimeOptions *)timeOptions;
```

## Instance methods

### init

```objectivec
- (nonnull YMKTransitOptions *)init;
```

## Properties

### avoid

```objectivec
@property (nonatomic, readonly) YMKFilterVehicleTypes avoid;
```

Transport types that the router will avoid. The value should be one of YMKFilterVehicleTypes, or their bitwise 'OR' combination.

### timeOptions

```objectivec
@property (nonatomic, readonly, nonnull) YMKTimeOptions *timeOptions;
```

Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent.
