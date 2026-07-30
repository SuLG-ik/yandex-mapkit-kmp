---
title: "YMKDrivingRouteMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouteMetadata.html"
---
# YMKDrivingRouteMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRouteMetadata : NSObject <YMKBaseMetadata>
```

Information about driving route metadata.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingRouteMetadata *)routeMetadataWithWeight:(nonnull YMKDrivingWeight *)weight
                                                       flags:(nonnull YMKDrivingFlags *)flags
                                                 routePoints:(nonnull NSArray<YMKDrivingRoutePoint *> *)routePoints
                                                         uri:(nullable NSString *)uri
                                          nonAvoidedFeatures:(nullable YMKDrivingNonAvoidedFeatures *)nonAvoidedFeatures;
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
    NSArray<YMKDrivingRoutePoint *> *routePoints;
```

Route points

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Route URI

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nullable)
    YMKDrivingNonAvoidedFeatures *nonAvoidedFeatures;
```

Route features that cannot be avoided

Optional field, can be nil

## Class methods

### routeMetadataWithWeight:flags:routePoints:uri:nonAvoidedFeatures:

```objectivec
+ (nonnull YMKDrivingRouteMetadata *)routeMetadataWithWeight:(nonnull YMKDrivingWeight *)weight
                                                       flags:(nonnull YMKDrivingFlags *)flags
                                                 routePoints:(nonnull NSArray<YMKDrivingRoutePoint *> *)routePoints
                                                         uri:(nullable NSString *)uri
                                          nonAvoidedFeatures:(nullable YMKDrivingNonAvoidedFeatures *)nonAvoidedFeatures;
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

### routePoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRoutePoint *> *routePoints;
```

Route points. In addition to point coordinates each route point may have a selected arrival point

### uri

```objectivec
@property (nonatomic, readonly, nullable) NSString *uri;
```

Route URI

Optional field, can be nil.

### nonAvoidedFeatures

```objectivec
@property (nonatomic, readonly, nullable)
    YMKDrivingNonAvoidedFeatures *nonAvoidedFeatures;
```

Route features that cannot be avoided

Optional field, can be nil.
