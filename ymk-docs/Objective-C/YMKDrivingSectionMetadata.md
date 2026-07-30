---
title: "YMKDrivingSectionMetadata"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSectionMetadata.html"
---
# YMKDrivingSectionMetadata

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSectionMetadata : NSObject
```

Information about section metadata.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingSectionMetadata *)sectionMetadataWithLegIndex:( NSUInteger)legIndex
                                                            weight:(nonnull YMKDrivingWeight *)weight
                                                        annotation:(nonnull YMKDrivingAnnotation *)annotation
                                                 viaPointPositions:(nonnull NSArray<NSNumber *> *)viaPointPositions;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger legIndex;
```

A leg is a section of the route between two consecutive waypoints

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *weight;
```

The "weight" of the section

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingAnnotation *annotation;
```

Section annotation

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *viaPointPositions;
```

Via points (throughpoints) can appear only at nodes of the section's geometry

## Class methods

### sectionMetadataWithLegIndex:weight:annotation:viaPointPositions:

```objectivec
+ (nonnull YMKDrivingSectionMetadata *)sectionMetadataWithLegIndex:( NSUInteger)legIndex
                                                            weight:(nonnull YMKDrivingWeight *)weight
                                                        annotation:(nonnull YMKDrivingAnnotation *)annotation
                                                 viaPointPositions:(nonnull NSArray<NSNumber *> *)viaPointPositions;
```

## Properties

### legIndex

```objectivec
@property (nonatomic, readonly) NSUInteger legIndex;
```

A leg is a section of the route between two consecutive waypoints.

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingWeight *weight;
```

The "weight" of the section.

### annotation

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingAnnotation *annotation;
```

Section annotation.

### viaPointPositions

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *viaPointPositions;
```

Via points (throughpoints) can appear only at nodes of the section's geometry. The vector contains the positions of all corresponding nodes. These positions should be listed in ascending order.
