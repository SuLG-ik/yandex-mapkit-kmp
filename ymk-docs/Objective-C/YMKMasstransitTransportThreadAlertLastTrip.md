---
title: "YMKMasstransitTransportThreadAlertLastTrip"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportThreadAlertLastTrip"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertLastTrip.html"
---
# YMKMasstransitTransportThreadAlertLastTrip

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertLastTrip.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportThreadAlertLastTrip : NSObject
```

Last trip for the thread. Allows to get the time it takes to get to the end of the route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertLastTrip *)lastTripWithTime:(nonnull YMKTime *)time;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *time;
```

Time required to finish the trip

## Class methods

### lastTripWithTime:

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertLastTrip *)lastTripWithTime:(nonnull YMKTime *)time;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *time;
```

Time required to finish the trip.
