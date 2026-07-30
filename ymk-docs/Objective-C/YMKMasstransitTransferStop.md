---
title: "YMKMasstransitTransferStop"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransferStop"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransferStop.html"
---
# YMKMasstransitTransferStop

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransferStop.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransferStop : NSObject
```

Represents a stop in path which is not a part of any transport trip but must be visited according travelling. For example, exit from subway may require transfer on other stop.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransferStop *)transferStopWithRouteStop:(nonnull YMKMasstransitRouteStop *)routeStop
                                                       transports:(nonnull NSArray<YMKMasstransitTransport *> *)transports;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitRouteStop *routeStop;
```

Stop information

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransport *> *transports;
```

Transports at the stops

## Class methods

### transferStopWithRouteStop:transports:

```objectivec
+ (nonnull YMKMasstransitTransferStop *)transferStopWithRouteStop:(nonnull YMKMasstransitRouteStop *)routeStop
                                                       transports:(nonnull NSArray<YMKMasstransitTransport *> *)transports;
```

## Properties

### routeStop

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitRouteStop *routeStop;
```

Stop information.

### transports

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransport *> *transports;
```

Transports at the stops
