---
title: "YMKMasstransitFitness"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitFitness"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitFitness.html"
---
# YMKMasstransitFitness

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitFitness.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitFitness : NSObject
```

Represent a section where we have to move by ourself (like pedestrian, or by bicycle and scooter)

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitFitness *)fitnessWithType:( YMKMasstransitFitnessType)type
                                     constructions:(nonnull NSArray<YMKMasstransitConstructionSegment *> *)constructions
                                 restrictedEntries:(nonnull NSArray<YMKRestrictedEntry *> *)restrictedEntries
                                         viaPoints:(nonnull NSArray<YMKPolylinePosition *> *)viaPoints
                                       annotations:(nonnull NSArray<YMKMasstransitAnnotation *> *)annotations
                                      trafficTypes:(nonnull NSArray<YMKMasstransitTrafficTypeSegment *> *)trafficTypes
                                     elevationData:(nullable YMKMasstransitElevationData *)elevationData
                                    indoorSegments:(nonnull NSArray<YMKMasstransitIndoorSegment *> *)indoorSegments;
```

### Properties

```objectivec
@property (nonatomic, readonly) YMKMasstransitFitnessType type;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitConstructionSegment *> *constructions;
```

Compressed information about constructions along the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKRestrictedEntry *> *restrictedEntries;
```

List of restricted entries with their coordinates along the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPolylinePosition *> *viaPoints;
```

List of via points on the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitAnnotation *> *annotations;
```

List of annotations on the path

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTrafficTypeSegment *> *trafficTypes;
```

List of traffic types on path

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitElevationData *elevationData;
```

Information on elevation gain and loss in a fitness section

Optional field, can be nil

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitIndoorSegment *> *indoorSegments;
```

List of indoor segments (levels or connectors) on path

## Class methods

### fitnessWithType:constructions:restrictedEntries:viaPoints:annotations:trafficTypes:elevationData:indoorSegments:

```objectivec
+ (nonnull YMKMasstransitFitness *)fitnessWithType:( YMKMasstransitFitnessType)type
                                     constructions:(nonnull NSArray<YMKMasstransitConstructionSegment *> *)constructions
                                 restrictedEntries:(nonnull NSArray<YMKRestrictedEntry *> *)restrictedEntries
                                         viaPoints:(nonnull NSArray<YMKPolylinePosition *> *)viaPoints
                                       annotations:(nonnull NSArray<YMKMasstransitAnnotation *> *)annotations
                                      trafficTypes:(nonnull NSArray<YMKMasstransitTrafficTypeSegment *> *)trafficTypes
                                     elevationData:(nullable YMKMasstransitElevationData *)elevationData
                                    indoorSegments:(nonnull NSArray<YMKMasstransitIndoorSegment *> *)indoorSegments;
```

## Properties

### type

```objectivec
@property (nonatomic, readonly) YMKMasstransitFitnessType type;
```

### constructions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitConstructionSegment *> *constructions;
```

Compressed information about constructions along the path. YMKMasstransitConstructionSegment::subpolyline fields of all segments cover the entire geometry of corresponding section".

### restrictedEntries

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKRestrictedEntry *> *restrictedEntries;
```

List of restricted entries with their coordinates along the path.

### viaPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPolylinePosition *> *viaPoints;
```

List of via points on the path. A via point is described by the index of the point in the route geometry polyline.

### annotations

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitAnnotation *> *annotations;
```

List of annotations on the path.

### trafficTypes

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitTrafficTypeSegment *> *trafficTypes;
```

List of traffic types on path

### elevationData

```objectivec
@property (nonatomic, readonly, nullable)
    YMKMasstransitElevationData *elevationData;
```

Information on elevation gain and loss in a fitness section

Optional field, can be nil.

### indoorSegments

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKMasstransitIndoorSegment *> *indoorSegments;
```

List of indoor segments (levels or connectors) on path. Compressed information about levels along the path. YMKMasstransitIndoorSegment::subpolyline fields of all indoor segments cover only the indoor geometry, it does not cover outdoor parts.
