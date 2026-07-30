---
title: "YMKMasstransitTravelEstimation"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTravelEstimation"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTravelEstimation.html"
---
# YMKMasstransitTravelEstimation

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTravelEstimation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTravelEstimation : NSObject
```

Arrival and departure time estimations for time-dependent routes or sections of time-dependent routes.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTravelEstimation *)travelEstimationWithDepartureTime:(nonnull YMKTime *)departureTime
                                                                  arrivalTime:(nonnull YMKTime *)arrivalTime;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *departureTime;
```

Departure time for a route or a route section

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *arrivalTime;
```

Arrival time for a route or a route section

## Class methods

### travelEstimationWithDepartureTime:arrivalTime:

```objectivec
+ (nonnull YMKMasstransitTravelEstimation *)travelEstimationWithDepartureTime:(nonnull YMKTime *)departureTime
                                                                  arrivalTime:(nonnull YMKTime *)arrivalTime;
```

## Properties

### departureTime

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *departureTime;
```

Departure time for a route or a route section.

### arrivalTime

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *arrivalTime;
```

Arrival time for a route or a route section.
