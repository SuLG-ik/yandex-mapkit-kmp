---
title: "YMKBoundingBoxHelper"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBoundingBoxHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBoundingBoxHelper.html"
---
# YMKBoundingBoxHelper

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBoundingBoxHelper.html)

```objectivec
@interface YMKBoundingBoxHelper : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithBbox:(nonnull YMKBoundingBox *)bbox;
```

Gets bounds based on a bounding box

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPoint:(nonnull YMKPoint *)point;
```

Gets bounds based on a point

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Gets bounds based on a polyline

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithRing:(nonnull YMKLinearRing *)ring;
```

Gets bounds based on a linear ring

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPolygon:(nonnull YMKPolygon *)polygon;
```

Gets bounds based on a polygon

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithFirst:(nonnull YMKBoundingBox *)first
                                        second:(nonnull YMKBoundingBox *)second;
```

Gets bounds based on two bounding boxes

## Class methods

### getBoundsWithBbox:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithBbox:(nonnull YMKBoundingBox *)bbox;
```

Gets bounds based on a bounding box.

### getBoundsWithPoint:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPoint:(nonnull YMKPoint *)point;
```

Gets bounds based on a point.

### getBoundsWithPolyline:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPolyline:
    (nonnull YMKPolyline *)polyline;
```

Gets bounds based on a polyline.

### getBoundsWithRing:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithRing:(nonnull YMKLinearRing *)ring;
```

Gets bounds based on a linear ring.

### getBoundsWithPolygon:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithPolygon:(nonnull YMKPolygon *)polygon;
```

Gets bounds based on a polygon.

### getBoundsWithFirst:second:

```objectivec
+ (nonnull YMKBoundingBox *)getBoundsWithFirst:(nonnull YMKBoundingBox *)first
                                        second:(nonnull YMKBoundingBox *)second;
```

Gets bounds based on two bounding boxes.
