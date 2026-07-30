---
title: "YMKMasstransitTransportThreadAlertClosedUntil"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportThreadAlertClosedUntil"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertClosedUntil.html"
---
# YMKMasstransitTransportThreadAlertClosedUntil

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportThreadAlertClosedUntil.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportThreadAlertClosedUntil : NSObject
```

Thread is not operational until specified time.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertClosedUntil *)closedUntilWithTime:(nonnull YMKTime *)time;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *time;
```

Time of the next trip

## Class methods

### closedUntilWithTime:

```objectivec
+ (nonnull YMKMasstransitTransportThreadAlertClosedUntil *)closedUntilWithTime:(nonnull YMKTime *)time;
```

## Properties

### time

```objectivec
@property (nonatomic, readonly, nonnull) YMKTime *time;
```

Time of the next trip.
