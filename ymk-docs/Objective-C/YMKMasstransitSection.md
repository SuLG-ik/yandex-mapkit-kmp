---
title: "YMKMasstransitSection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSection.html"
---
# YMKMasstransitSection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSection : NSObject
```

Contains information about an individual section of a mass transit YMKMasstransitRoute. The only fields that are always set are YMKMasstransitSection::metadata.YMKMasstransitSectionMetadata::weight, YMKMasstransitSection::geometry and YMKMasstransitSection::metadata.YMKMasstransitSectionMetadata::data.

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitSection *)sectionWithMetadata:(nonnull YMKMasstransitSectionMetadata *)metadata
                                              geometry:(nonnull YMKSubpolyline *)geometry
                                                 stops:(nonnull NSArray<YMKMasstransitRouteStop *> *)stops
                                              rideLegs:(nonnull NSArray<YMKSubpolyline *> *)rideLegs;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitSectionMetadata *metadata;
```

General information about a section of a route

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Geometry of the section as a fragment of a YMKMasstransitRoute polyline

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitRouteStop *> *stops;
```

Vector of stops along the route

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSubpolyline *> *rideLegs;
```

Vector of polylines each connecting two consecutive stops

## Class methods

### sectionWithMetadata:geometry:stops:rideLegs:

```objectivec
+ (nonnull YMKMasstransitSection *)sectionWithMetadata:(nonnull YMKMasstransitSectionMetadata *)metadata
                                              geometry:(nonnull YMKSubpolyline *)geometry
                                                 stops:(nonnull NSArray<YMKMasstransitRouteStop *> *)stops
                                              rideLegs:(nonnull NSArray<YMKSubpolyline *> *)rideLegs;
```

## Properties

### metadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKMasstransitSectionMetadata *metadata;
```

General information about a section of a route.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Geometry of the section as a fragment of a YMKMasstransitRoute polyline.

### stops

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitRouteStop *> *stops;
```

Vector of stops along the route. The first stop in the vector is the stop for boarding the transport, and the last stop in the vector is the stop for exiting the transport.

### rideLegs

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKSubpolyline *> *rideLegs;
```

Vector of polylines each connecting two consecutive stops. This vector is only filled for mass transit ride sections, so this geometry represents a part of the mass transit thread geometry between two stops.
