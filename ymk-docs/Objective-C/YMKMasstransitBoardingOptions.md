---
title: "YMKMasstransitBoardingOptions"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitBoardingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitBoardingOptions.html"
---
# YMKMasstransitBoardingOptions

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitBoardingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitBoardingOptions : NSObject
```

Contains information about underground or railway boarding recommendations.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitBoardingOptions *)boardingOptionsWithArea:(nonnull NSArray<YMKMasstransitBoardingOptionsBoardingArea *> *)area
                                                    railwayOptions:(nonnull YMKMasstransitRailwayOptions *)railwayOptions;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitBoardingOptionsBoardingArea *> *area;
```

Vector of recommended areas to board

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRailwayOptions *railwayOptions;
```

Options about boarding to trains

## Class methods

### boardingOptionsWithArea:railwayOptions:

```objectivec
+ (nonnull YMKMasstransitBoardingOptions *)boardingOptionsWithArea:(nonnull NSArray<YMKMasstransitBoardingOptionsBoardingArea *> *)area
                                                    railwayOptions:(nonnull YMKMasstransitRailwayOptions *)railwayOptions;
```

## Properties

### area

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitBoardingOptionsBoardingArea *> *area;
```

Vector of recommended areas to board.

### railwayOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitRailwayOptions *railwayOptions;
```

Options about boarding to trains.
