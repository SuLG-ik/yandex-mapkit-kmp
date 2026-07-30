---
title: "YMKGeometry"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeometry.html"
---
# YMKGeometry

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeometry.html)

```objectivec
@interface YMKGeometry : NSObject
```

A container of other geometry objects. Point - A point on the map. Polyline - A polyline between a number of points. Polygon - A polygon with one or more polygons in it. BoundingBox - A rectangular box around the object. Circle - A circle around the specified point.

## Summary

### Class methods

```objectivec
+ (nonnull YMKGeometry *)geometryWithPoint:(nonnull YMKPoint *)point;
```

```objectivec
+ (nonnull YMKGeometry *)geometryWithPolyline:(nonnull YMKPolyline *)polyline;
```

```objectivec
+ (nonnull YMKGeometry *)geometryWithPolygon:(nonnull YMKPolygon *)polygon;
```

```objectivec
+ (nonnull YMKGeometry *)geometryWithMultiPolygon:(nonnull YMKMultiPolygon *)multiPolygon;
```

```objectivec
+ (nonnull YMKGeometry *)geometryWithBoundingBox:(nonnull YMKBoundingBox *)boundingBox;
```

```objectivec
+ (nonnull YMKGeometry *)geometryWithCircle:(nonnull YMKCircle *)circle;
```

### Properties

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *point
```

```objectivec
@property (nonatomic, readonly, nullable) YMKPolyline *polyline
```

```objectivec
@property (nonatomic, readonly, nullable) YMKPolygon *polygon
```

```objectivec
@property (nonatomic, readonly, nullable) YMKMultiPolygon *multiPolygon
```

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox
```

```objectivec
@property (nonatomic, readonly, nullable) YMKCircle *circle
```

## Class methods

### geometryWithPoint:

```objectivec
+ (nonnull YMKGeometry *)geometryWithPoint:(nonnull YMKPoint *)point;
```

### geometryWithPolyline:

```objectivec
+ (nonnull YMKGeometry *)geometryWithPolyline:(nonnull YMKPolyline *)polyline;
```

### geometryWithPolygon:

```objectivec
+ (nonnull YMKGeometry *)geometryWithPolygon:(nonnull YMKPolygon *)polygon;
```

### geometryWithMultiPolygon:

```objectivec
+ (nonnull YMKGeometry *)geometryWithMultiPolygon:(nonnull YMKMultiPolygon *)multiPolygon;
```

### geometryWithBoundingBox:

```objectivec
+ (nonnull YMKGeometry *)geometryWithBoundingBox:(nonnull YMKBoundingBox *)boundingBox;
```

### geometryWithCircle:

```objectivec
+ (nonnull YMKGeometry *)geometryWithCircle:(nonnull YMKCircle *)circle;
```

## Properties

### point

```objectivec
@property (nonatomic, readonly, nullable) YMKPoint *point
```

### polyline

```objectivec
@property (nonatomic, readonly, nullable) YMKPolyline *polyline
```

### polygon

```objectivec
@property (nonatomic, readonly, nullable) YMKPolygon *polygon
```

### multiPolygon

```objectivec
@property (nonatomic, readonly, nullable) YMKMultiPolygon *multiPolygon
```

### boundingBox

```objectivec
@property (nonatomic, readonly, nullable) YMKBoundingBox *boundingBox
```

### circle

```objectivec
@property (nonatomic, readonly, nullable) YMKCircle *circle
```
