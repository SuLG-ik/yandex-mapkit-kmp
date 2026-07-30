---
title: "YMKLineStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKLineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLineStyle.html"
---
# YMKLineStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKLineStyle.html)

```objectivec
@interface YMKLineStyle : NSObject
```

The style of the polyline.

## Summary

### Class methods

```objectivec
+ (nonnull YMKLineStyle *)lineStyleWithStrokeWidth:( float)strokeWidth
                                    gradientLength:( float)gradientLength
                                      outlineColor:(nonnull UIColor *)outlineColor
                                      outlineWidth:( float)outlineWidth
                               innerOutlineEnabled:( BOOL)innerOutlineEnabled
                                        turnRadius:( float)turnRadius
                              arcApproximationStep:( float)arcApproximationStep
                                        dashLength:( float)dashLength
                                         gapLength:( float)gapLength
                                        dashOffset:( float)dashOffset;
```

### Instance methods

```objectivec
- (nonnull YMKLineStyle *)init;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

The stroke width in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gradientLength;
```

Maximum length (in units) of the gradient from one color to another

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *outlineColor;
```

The outline color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Width of the outline in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL innerOutlineEnabled;
```

Enables the inner outline if true (a dark border along the edge of the outline)

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float turnRadius;
```

Maximum radius of a turn

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    float arcApproximationStep;
```

Defines step of arc approximation

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashLength;
```

Length of a dash in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gapLength;
```

Length of the gap between two dashes in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashOffset;
```

Offset from the start of the polyline to the reference dash in units

## Class methods

### lineStyleWithStrokeWidth:gradientLength:outlineColor:outlineWidth:innerOutlineEnabled:turnRadius:arcApproximationStep:dashLength:gapLength:dashOffset:

```objectivec
+ (nonnull YMKLineStyle *)lineStyleWithStrokeWidth:( float)strokeWidth
                                    gradientLength:( float)gradientLength
                                      outlineColor:(nonnull UIColor *)outlineColor
                                      outlineWidth:( float)outlineWidth
                               innerOutlineEnabled:( BOOL)innerOutlineEnabled
                                        turnRadius:( float)turnRadius
                              arcApproximationStep:( float)arcApproximationStep
                                        dashLength:( float)dashLength
                                         gapLength:( float)gapLength
                                        dashOffset:( float)dashOffset;
```

## Instance methods

### init

```objectivec
- (nonnull YMKLineStyle *)init;
```

## Properties

### strokeWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

The stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### gradientLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gradientLength;
```

Maximum length (in units) of the gradient from one color to another. Default: 0.

### outlineColor

```objectivec
@property (nonatomic, strong, readwrite, nonnull) UIColor *outlineColor;
```

The outline color. Default: hexademical RGBA code 0x00000000.

### outlineWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Width of the outline in units. Default: 0.

### innerOutlineEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    BOOL innerOutlineEnabled;
```

Enables the inner outline if true (a dark border along the edge of the outline). Default: false.

### turnRadius

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float turnRadius;
```

Maximum radius of a turn. Measured in units. Default: 10.

### arcApproximationStep

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    float arcApproximationStep;
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees. Default: 12.

### dashLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashLength;
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### gapLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gapLength;
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### dashOffset

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashOffset;
```

Offset from the start of the polyline to the reference dash in units. Default: 0.
