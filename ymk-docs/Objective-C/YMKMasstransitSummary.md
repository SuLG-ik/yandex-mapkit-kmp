---
title: "YMKMasstransitSummary"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSummary.html"
---
# YMKMasstransitSummary

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSummary : NSObject
```

Contains brief information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitSummary *)summaryWithWeight:(nonnull YMKMasstransitWeight *)weight
                                          estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                               flags:(nullable YMKMasstransitFlags *)flags;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route time, distance of the walking part, and the number of transfers

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations for time-dependent routes

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFlags *flags;
```

Specific properties of the route

## Class methods

### summaryWithWeight:estimation:flags:

```objectivec
+ (nonnull YMKMasstransitSummary *)summaryWithWeight:(nonnull YMKMasstransitWeight *)weight
                                          estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                               flags:(nullable YMKMasstransitFlags *)flags;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route time, distance of the walking part, and the number of transfers.

### estimation

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations for time-dependent routes.

Optional field, can be nil.

### flags

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFlags *flags;
```

Specific properties of the route.

Optional field, can be nil.
