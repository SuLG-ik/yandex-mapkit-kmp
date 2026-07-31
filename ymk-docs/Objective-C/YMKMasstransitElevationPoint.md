---
title: "YMKMasstransitElevationPoint"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitElevationPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitElevationPoint.html"
---
# YMKMasstransitElevationPoint

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitElevationPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitElevationPoint : NSObject
```

Information of elevation in point

## Summary

### Class methods

```objectivec
+ (nonnull YMKMasstransitElevationPoint *)elevationPointWithElevation:( float)elevation;
```

### Instance methods

```objectivec
- (nonnull YMKMasstransitElevationPoint *)init;
```

### Properties

```objectivec
@property (nonatomic, readonly) float elevation;
```

Elevation levels in meters

## Class methods

### elevationPointWithElevation:

```objectivec
+ (nonnull YMKMasstransitElevationPoint *)elevationPointWithElevation:( float)elevation;
```

## Instance methods

### init

```objectivec
- (nonnull YMKMasstransitElevationPoint *)init;
```

## Properties

### elevation

```objectivec
@property (nonatomic, readonly) float elevation;
```

Elevation levels in meters
