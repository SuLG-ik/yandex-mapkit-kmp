---
title: "YMKMasstransitTransportTransportThread"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitTransportTransportThread"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportTransportThread.html"
---
# YMKMasstransitTransportTransportThread

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitTransportTransportThread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitTransportTransportThread : NSObject
```

YMKMasstransitThread specific properties of a mass transit ride section of a YMKMasstransitRoute.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitTransportTransportThread *)transportThreadWithThread:(nonnull YMKMasstransitThread *)thread
                                                                isRecommended:( BOOL)isRecommended
                                                                       alerts:(nonnull NSArray<YMKMasstransitTransportThreadAlert *> *)alerts
                                                       alternateDepartureStop:(nullable YMKMasstransitStop *)alternateDepartureStop
                                                              boardingOptions:(nullable YMKMasstransitBoardingOptions *)boardingOptions
                                                               dropOffOptions:(nonnull YMKMasstransitDropOffOptions *)dropOffOptions
                                                                   estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                                        stops:(nonnull NSArray<YMKMasstransitTransportStop *> *)stops
                                                                     geometry:(nonnull YMKPolyline *)geometry;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitThread *thread;
```

Mass transit thread

```objectivec
@property (nonatomic, readonly) BOOL isRecommended;
```

Indicates that the mass transit router considers this thread the best one for the current section of the constucted route

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportThreadAlert *> *alerts;
```

Collection of important annotations for the section

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitStop *alternateDepartureStop;
```

If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitBoardingOptions *boardingOptions;
```

Recommended underground or railway boarding options for this section

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitDropOffOptions *dropOffOptions;
```

Railway drop-off options for this section

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Time estimation for transport thread

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportStop *> *stops;
```

Collection of stops for the section

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Transport thread geometry

## Class methods

### transportThreadWithThread:isRecommended:alerts:alternateDepartureStop:boardingOptions:dropOffOptions:estimation:stops:geometry:

```objectivec
+ (nonnull YMKMasstransitTransportTransportThread *)transportThreadWithThread:(nonnull YMKMasstransitThread *)thread
                                                                isRecommended:( BOOL)isRecommended
                                                                       alerts:(nonnull NSArray<YMKMasstransitTransportThreadAlert *> *)alerts
                                                       alternateDepartureStop:(nullable YMKMasstransitStop *)alternateDepartureStop
                                                              boardingOptions:(nullable YMKMasstransitBoardingOptions *)boardingOptions
                                                               dropOffOptions:(nonnull YMKMasstransitDropOffOptions *)dropOffOptions
                                                                   estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                                        stops:(nonnull NSArray<YMKMasstransitTransportStop *> *)stops
                                                                     geometry:(nonnull YMKPolyline *)geometry;
```

## Properties

### thread

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitThread *thread;
```

Mass transit thread.

### isRecommended

```objectivec
@property (nonatomic, readonly) BOOL isRecommended;
```

Indicates that the mass transit router considers this thread the best one for the current section of the constucted route.

### alerts

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportThreadAlert *> *alerts;
```

Collection of important annotations for the section.

### alternateDepartureStop

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitStop *alternateDepartureStop;
```

If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section.

Optional field, can be nil.

### boardingOptions

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitBoardingOptions *boardingOptions;
```

Recommended underground or railway boarding options for this section.

Optional field, can be nil.

### dropOffOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitDropOffOptions *dropOffOptions;
```

Railway drop-off options for this section.

### estimation

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Time estimation for transport thread.

Optional field, can be nil.

### stops

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTransportStop *> *stops;
```

Collection of stops for the section. The first stop in the collection is the stop for boarding the transport, and the last stop in the collection is the stop for exiting the transport.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Transport thread geometry.
