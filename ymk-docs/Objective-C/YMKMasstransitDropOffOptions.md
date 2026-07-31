---
title: "YMKMasstransitDropOffOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitDropOffOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitDropOffOptions.html"
---
# YMKMasstransitDropOffOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitDropOffOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitDropOffOptions : NSObject
```

Options about railway station dropoff expectations.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitDropOffOptions *)dropOffOptionsWithRailwayOptions:(nonnull YMKMasstransitRailwayOptions *)railwayOptions;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRailwayOptions *railwayOptions;
```

Options about dropoff from trains

## Class methods

### dropOffOptionsWithRailwayOptions:

```objectivec
+ (nonnull YMKMasstransitDropOffOptions *)dropOffOptionsWithRailwayOptions:(nonnull YMKMasstransitRailwayOptions *)railwayOptions;
```

## Properties

### railwayOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRailwayOptions *railwayOptions;
```

Options about dropoff from trains.
