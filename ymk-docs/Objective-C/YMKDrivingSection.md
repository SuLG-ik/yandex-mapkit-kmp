---
title: "YMKDrivingSection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSection.html"
---
# YMKDrivingSection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSection : NSObject
```

Route section.

## Summary

### Class methods

```objectivec
+ (nonnull YMKDrivingSection *)sectionWithMetadata:(nonnull YMKDrivingSectionMetadata *)metadata
                                          geometry:(nonnull YMKSubpolyline *)geometry;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSectionMetadata *metadata;
```

Metadata information for the route section

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

A polyline of the route section

## Class methods

### sectionWithMetadata:geometry:

```objectivec
+ (nonnull YMKDrivingSection *)sectionWithMetadata:(nonnull YMKDrivingSectionMetadata *)metadata
                                          geometry:(nonnull YMKSubpolyline *)geometry;
```

## Properties

### metadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingSectionMetadata *metadata;
```

Metadata information for the route section.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

A polyline of the route section.
