---
title: "YMKMasstransitSectionMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionMetadata.html"
---
# YMKMasstransitSectionMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSectionMetadata : NSObject
```

General information about a section of a route. The YMKMasstransitSectionMetadata::data field describes the type of section: wait, walk, transfer, or transport, and related data. Related data can be set for walk and transfer sections. This data is a vector of construction types of corresponding geometry segments.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitSectionMetadata *)sectionMetadataWithWeight:(nonnull YMKMasstransitWeight *)weight
                                                                data:(nonnull YMKMasstransitSectionMetadataSectionData *)data
                                                          estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                            legIndex:( NSUInteger)legIndex
                                                      paymentOptions:(nonnull NSArray<YMKMasstransitSectionPaymentOption *> *)paymentOptions;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route traveling time, distance of the walking part, and the number of transfers

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitSectionMetadataSectionData *data;
```

Contains information that is specific to a section type: wait, walk, transfer, or ride transport

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations

```objectivec
@property (nonatomic, readonly) NSUInteger legIndex;
```

Part of the route polyline for the route leg

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitSectionPaymentOption *> *paymentOptions;
```

List of payment options with prices for the current section

## Class methods

### sectionMetadataWithWeight:data:estimation:legIndex:paymentOptions:

```objectivec
+ (nonnull YMKMasstransitSectionMetadata *)sectionMetadataWithWeight:(nonnull YMKMasstransitWeight *)weight
                                                                data:(nonnull YMKMasstransitSectionMetadataSectionData *)data
                                                          estimation:(nullable YMKMasstransitTravelEstimation *)estimation
                                                            legIndex:( NSUInteger)legIndex
                                                      paymentOptions:(nonnull NSArray<YMKMasstransitSectionPaymentOption *> *)paymentOptions;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitWeight *weight;
```

Contains the route traveling time, distance of the walking part, and the number of transfers.

### data

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKMasstransitSectionMetadataSectionData *data;
```

Contains information that is specific to a section type: wait, walk, transfer, or ride transport.

### estimation

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitTravelEstimation *estimation;
```

Arrival and departure time estimations. This field is set only for time-dependent routes.

Optional field, can be nil.

### legIndex

```objectivec
@property (nonatomic, readonly) NSUInteger legIndex;
```

Part of the route polyline for the route leg. A leg is a part of the route between two consecutive waypoints.

### paymentOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitSectionPaymentOption *> *paymentOptions;
```

List of payment options with prices for the current section.
