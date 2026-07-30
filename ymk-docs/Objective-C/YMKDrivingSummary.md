---
title: "YMKDrivingSummary"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSummary.html"
---
# YMKDrivingSummary

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSummary : NSObject
```

Route summary.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingSummary *)summaryWithWeight:(nonnull YMKDrivingWeight *)weight
                                           flags:(nonnull YMKDrivingFlags *)flags
                              nonAvoidedFeatures:(nonnull YMKDrivingNonAvoidedFeatures *)nonAvoidedFeatures;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *weight;
```

Route "weight"

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingFlags *flags;
```

Overall route characteristics

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingNonAvoidedFeatures *nonAvoidedFeatures;
```

Route features that cannot be avoided

## Class methods

### summaryWithWeight:flags:nonAvoidedFeatures:

```objectivec
+ (nonnull YMKDrivingSummary *)summaryWithWeight:(nonnull YMKDrivingWeight *)weight
                                           flags:(nonnull YMKDrivingFlags *)flags
                              nonAvoidedFeatures:(nonnull YMKDrivingNonAvoidedFeatures *)nonAvoidedFeatures;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *weight;
```

Route "weight".

### flags

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingFlags *flags;
```

Overall route characteristics.

### nonAvoidedFeatures

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingNonAvoidedFeatures *nonAvoidedFeatures;
```

Route features that cannot be avoided
