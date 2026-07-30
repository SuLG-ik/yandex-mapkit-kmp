---
title: "YMKBicycleSection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSection.html"
---
# YMKBicycleSection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleSection : NSObject
```

Section of the route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleSection *)sectionWithWeight:(nonnull YMKBicycleWeight *)weight
                                        geometry:(nonnull YMKSubpolyline *)geometry;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of a route or route section

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Path of the route polyline for this section

## Class methods

### sectionWithWeight:geometry:

```objectivec
+ (nonnull YMKBicycleSection *)sectionWithWeight:(nonnull YMKBicycleWeight *)weight
                                        geometry:(nonnull YMKSubpolyline *)geometry;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of a route or route section.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Path of the route polyline for this section.
