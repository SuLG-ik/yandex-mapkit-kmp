---
title: "YMKPolygonMapObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolygonMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolygonMapObject.html"
---
# YMKPolygonMapObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolygonMapObject.html)

```objectivec
@interface YMKPolygonMapObject : YMKMapObject
```

A polygon displayed on the map.

## Summary

### Instance methods

```objectivec
- (void)setPatternWithAnimatedImage:
            (nonnull id<YRTAnimatedImageProvider>)animatedImage
                              scale:(float)scale;
```

Sets pattern to fill polygon

```objectivec
- (void)setPatternWithImage:(nonnull UIImage *)image scale:(float)scale;
```

Sets pattern to fill polygon

```objectivec
- (void)resetPattern;
```

Removes pattern

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolygon *geometry;
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

The object geometry can be interpreted in two different ways: <ul><li>If the object mode is 'geodesic', the object geometry is defined on a sphere

## Instance methods

### setPatternWithAnimatedImage:scale:

```objectivec
- (void)setPatternWithAnimatedImage:
            (nonnull id<YRTAnimatedImageProvider>)animatedImage
                              scale:(float)scale;
```

> [!NOTE] Примечание
> Original linear sizes of pattern should be equal to power of 2.

Sets pattern to fill polygon.  @attention Fill color is ignored if a pattern is set.

### setPatternWithImage:scale:

```objectivec
- (void)setPatternWithImage:(nonnull UIImage *)image scale:(float)scale;
```

> [!NOTE] Примечание
> Original linear sizes of pattern should be equal to power of 2.

Sets pattern to fill polygon.  @attention Fill color is ignored if pattern is set.

### resetPattern

```objectivec
- (void)resetPattern;
```

Removes pattern.

## Properties

### geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolygon *geometry;
```

### strokeColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *strokeColor;
```

Sets the stroke color. Default: hexademical RGBA code 0x0066FFFF. Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke.

### strokeWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

Sets the stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### fillColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *fillColor;
```

> [!NOTE] Примечание
> Fill color is ignored if a pattern is set.

Sets the fill color. Default: hexademical RGBA code 0x0066FF99.

### geodesic

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isGeodesic)
    BOOL geodesic;
```

The object geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object geometry is defined on a sphere.
- Otherwise, the object geometry is defined in projected space.

Default: false.
