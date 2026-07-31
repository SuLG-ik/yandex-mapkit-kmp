---
title: "YMKStylingBilinearFunctionMatrix"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKStylingBilinearFunctionMatrix"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStylingBilinearFunctionMatrix.html"
---
# YMKStylingBilinearFunctionMatrix

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKStylingBilinearFunctionMatrix.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKStylingBilinearFunctionMatrix : NSObject
```

defines function `func(zoom, tilt)` as `func(zooms[x], tilts[y]) == points[x][y]` for all x in [0, zooms.size()), y in [0, tilts.size()) https://en.wikipedia.org/wiki/Bilinear_interpolation

## Summary

### Class methods

```objectivec
+ (nonnull YMKStylingBilinearFunctionMatrix *)bilinearFunctionMatrixWithZooms:(nonnull NSArray<NSNumber *> *)zooms
                                                                        tilts:(nonnull NSArray<NSNumber *> *)tilts
                                                                       points:(nonnull NSArray<NSArray<NSNumber *> *> *)points;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *zooms;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tilts;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSArray<NSNumber *> *> *points;
```

requires: points

## Class methods

### bilinearFunctionMatrixWithZooms:tilts:points:

```objectivec
+ (nonnull YMKStylingBilinearFunctionMatrix *)bilinearFunctionMatrixWithZooms:(nonnull NSArray<NSNumber *> *)zooms
                                                                        tilts:(nonnull NSArray<NSNumber *> *)tilts
                                                                       points:(nonnull NSArray<NSArray<NSNumber *> *> *)points;
```

## Properties

### zooms

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *zooms;
```

### tilts

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *tilts;
```

### points

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSArray<NSNumber *> *> *points;
```

requires: points.size() == zooms.size() subpoints.size() == tilts.size() for all subpoints in points
