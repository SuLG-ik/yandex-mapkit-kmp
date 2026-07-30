---
title: "YMKLinearRing"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLinearRing"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLinearRing.html"
---
# YMKLinearRing

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLinearRing.html)

```objectivec
@interface YMKLinearRing : NSObject
```

A sequence of four or more vertices, with all points along the linearly-interpolated curves (line segments) between each pair of consecutive vertices. A ring must have either 0, 4 or more points. The first and last points of the ring must be in the same position. The ring must not intersect with itself.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLinearRing *)linearRingWithPoints:(nonnull NSArray<YMKPoint *> *)points;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPoint *> *points;
```

The list of points to connect

## Class methods

### linearRingWithPoints:

```objectivec
+ (nonnull YMKLinearRing *)linearRingWithPoints:(nonnull NSArray<YMKPoint *> *)points;
```

## Properties

### points

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKPoint *> *points;
```

The list of points to connect.
