---
title: "YMKPolygon"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolygon"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolygon.html"
---
# YMKPolygon

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolygon.html)

```objectivec
@interface YMKPolygon : NSObject
```

A polygon with one or more polygons in it. The exterior and interior areas are specified using LinearRing.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPolygon *)polygonWithOuterRing:(nonnull YMKLinearRing *)outerRing
                                  innerRings:(nonnull NSArray<YMKLinearRing *> *)innerRings;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKLinearRing *outerRing;
```

The ring specifying the area

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKLinearRing *> *innerRings;
```

The list of rings in the specified area

## Class methods

### polygonWithOuterRing:innerRings:

```objectivec
+ (nonnull YMKPolygon *)polygonWithOuterRing:(nonnull YMKLinearRing *)outerRing
                                  innerRings:(nonnull NSArray<YMKLinearRing *> *)innerRings;
```

## Properties

### outerRing

```objectivec
@property (nonatomic, readonly, nonnull) YMKLinearRing *outerRing;
```

The ring specifying the area.

### innerRings

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKLinearRing *> *innerRings;
```

The list of rings in the specified area.
