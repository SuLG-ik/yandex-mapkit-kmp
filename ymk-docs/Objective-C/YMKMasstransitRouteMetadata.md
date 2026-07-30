---
title: "YMKMasstransitRouteMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteMetadata.html"
---
# YMKMasstransitRouteMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouteMetadata : NSObject <YMKBaseMetadata>
```

Contains information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitRouteMetadata *)routeMetadataWithWeight:(nonnull YMKMasstransitWeight *)weight
                                                        settings:(nullable YMKMasstransitRouteSettings *)settings
                                                      estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                       wayPoints:(nonnull NSArray<YMKMasstransitWayPoint *> *)wayPoints
                                                         routeId:(nullable NSString *)routeId
                                                           flags:(nullable YMKMasstransitFlags *)flags
                                                     comfortTags:(nonnull NSArray<NSNumber *> *)comfortTags
                                                   stairsSummary:(nonnull YMKMasstransitStairsSummary *)stairsSummary
                                                  paymentOptions:(nonnull NSArray<YMKMasstransitRoutePaymentOption *> *)paymentOptions
                                                routeExplanation:(nullable NSString *)routeExplanation;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route time, distance of the walking part, and the number of transfers

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitRouteSettings *settings;
```

Route settings that were used by the mass transit router

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations for time-dependent routes

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitWayPoint *> *wayPoints;
```

List of route waypoints

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeId;
```

Unique route id

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFlags *flags;
```

Flags which contains route properties

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *comfortTags;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitStairsSummary *stairsSummary;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitRoutePaymentOption *> *paymentOptions;
```

List of payment options with prices for the whole route

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeExplanation;
```

Optional field, can be nil

## Class methods

### routeMetadataWithWeight:settings:estimation:wayPoints:routeId:flags:comfortTags:stairsSummary:paymentOptions:routeExplanation:

```objectivec
+ (nonnull YMKMasstransitRouteMetadata *)routeMetadataWithWeight:(nonnull YMKMasstransitWeight *)weight
                                                        settings:(nullable YMKMasstransitRouteSettings *)settings
                                                      estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                       wayPoints:(nonnull NSArray<YMKMasstransitWayPoint *> *)wayPoints
                                                         routeId:(nullable NSString *)routeId
                                                           flags:(nullable YMKMasstransitFlags *)flags
                                                     comfortTags:(nonnull NSArray<NSNumber *> *)comfortTags
                                                   stairsSummary:(nonnull YMKMasstransitStairsSummary *)stairsSummary
                                                  paymentOptions:(nonnull NSArray<YMKMasstransitRoutePaymentOption *> *)paymentOptions
                                                routeExplanation:(nullable NSString *)routeExplanation;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route time, distance of the walking part, and the number of transfers.

### settings

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitRouteSettings *settings;
```

Route settings that were used by the mass transit router.

Optional field, can be nil.

### estimation

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations for time-dependent routes.

Optional field, can be nil.

### wayPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitWayPoint *> *wayPoints;
```

List of route waypoints. See YMKMasstransitWayPoint for details

### routeId

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeId;
```

Unique route id.

Optional field, can be nil.

### flags

```objectivec
@property (nonatomic, readonly, nullable) YMKMasstransitFlags *flags;
```

Flags which contains route properties

Optional field, can be nil.

### comfortTags

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *comfortTags;
```

### stairsSummary

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitStairsSummary *stairsSummary;
```

### paymentOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitRoutePaymentOption *> *paymentOptions;
```

List of payment options with prices for the whole route.

### routeExplanation

```objectivec
@property (nonatomic, readonly, nullable) NSString *routeExplanation;
```

Optional field, can be nil.
