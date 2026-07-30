---
title: "YMKBicycleLeg"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleLeg"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleLeg.html"
---
# YMKBicycleLeg

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleLeg.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleLeg : NSObject
```

Leg of the route.

## Summary

### Class methods

```objectivec
+ (nonnull YMKBicycleLeg *)legWithWeight:(nonnull YMKBicycleWeight *)weight
                                geometry:(nonnull YMKSubpolyline *)geometry;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route leg

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Path of the route polyline for the route leg

## Class methods

### legWithWeight:geometry:

```objectivec
+ (nonnull YMKBicycleLeg *)legWithWeight:(nonnull YMKBicycleWeight *)weight
                                geometry:(nonnull YMKSubpolyline *)geometry;
```

## Properties

### weight

```objectivec
@property (nonatomic, readonly, nonnull) YMKBicycleWeight *weight;
```

Quantitative characteristics of the route leg.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKSubpolyline *geometry;
```

Path of the route polyline for the route leg.
