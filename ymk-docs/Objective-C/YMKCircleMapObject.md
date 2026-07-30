---
title: "YMKCircleMapObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCircleMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCircleMapObject.html"
---
# YMKCircleMapObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCircleMapObject.html)

```objectivec
@interface YMKCircleMapObject : YMKMapObject
```

The circle element.

## Summary

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKCircle *geometry;
```

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *strokeColor;
```

Sets the stroke color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

Sets the stroke width in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *fillColor;
```

Sets the fill color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isGeodesic)
    BOOL geodesic;
```

The object's geometry can be interpreted in two different ways: <ul><li>If the object mode is 'geodesic', the object's geometry is defined on a sphere

## Properties

### geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKCircle *geometry;
```

### strokeColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *strokeColor;
```

Sets the stroke color. Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke. default: 0x0066FFFF

### strokeWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

Sets the stroke width in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1. default: 5

### fillColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *fillColor;
```

Sets the fill color. default: 0x0066FF99

### geodesic

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isGeodesic)
    BOOL geodesic;
```

The object's geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object's geometry is defined on a sphere.
- Otherwise, the object's geometry is defined in projected space.

Default: false.
