---
title: "YMKPolylineMapObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylineMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineMapObject.html"
---
# YMKPolylineMapObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineMapObject.html)

```objectivec
@interface YMKPolylineMapObject : YMKMapObject
```

A polyline object with adjustable segment colors. Supports outlines, dash, arrows, and hiding parts of the polyline efficiently.

## Summary

### Instance methods

```objectivec
- (void)selectWithSelectionColor:(nonnull UIColor *)selectionColor
                     subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Highlights a subpolyline using the specified color

```objectivec
- (void)hideWithSubpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Hides the subpolyline, canceling any previous hides

```objectivec
- (void)hideWithSubpolylines:(nonnull NSArray<YMKSubpolyline *> *)subpolylines;
```

Hides multiple subpolylines, canceling any previous hides

```objectivec
- (void)setStrokeColorsWithColors:(nonnull NSArray<NSNumber *> *)colors
                          weights:(nonnull NSArray<NSNumber *> *)weights;
```

Sets indexes of colors in palette for line segments

```objectivec
- (void)setStrokeColorsWithColors:(nonnull NSArray<NSNumber *> *)colors;
```

Sets indexes of colors in palette for line segments

```objectivec
- (void)setPaletteColorWithColorIndex:(NSUInteger)colorIndex
                                color:(nonnull UIColor *)color;
```

Sets color in RGBA mode for colorIndex

```objectivec
- (nonnull UIColor *)getPaletteColorWithColorIndex:(NSUInteger)colorIndex;
```

Returns the palette color for the specified index

```objectivec
- (void)setStrokeColorWithColor:(nonnull UIColor *)color;
```

Sets the polyline color

```objectivec
- (NSUInteger)getStrokeColorWithSegmentIndex:(NSUInteger)segmentIndex;
```

Returns the palette index used by segment with the specified index

```objectivec
- (nonnull YMKArrow *)addArrowWithPosition:
                          (nonnull YMKPolylinePosition *)position
                                    length:(float)length
                                 fillColor:(nonnull UIColor *)fillColor;
```

Adds an arrow

```objectivec
- (nonnull NSArray<YMKArrow *> *)arrows;
```

Provides arrows

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolyline *geometry;
```

The polyline's geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKLineStyle *style;
```

The polyline's style

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

The stroke width in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gradientLength;
```

Maximum length (in units) of the gradient from one color to another

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *outlineColor;
```

The outline color

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Width of the outline in units

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isInnerOutlineEnabled) BOOL innerOutlineEnabled;
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

## Instance methods

### selectWithSelectionColor:subpolyline:

```objectivec
- (void)selectWithSelectionColor:(nonnull UIColor *)selectionColor
                     subpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Highlights a subpolyline using the specified color.

### hideWithSubpolyline:

```objectivec
- (void)hideWithSubpolyline:(nonnull YMKSubpolyline *)subpolyline;
```

Hides the subpolyline, canceling any previous hides.

### hideWithSubpolylines:

```objectivec
- (void)hideWithSubpolylines:(nonnull NSArray<YMKSubpolyline *> *)subpolylines;
```

Hides multiple subpolylines, canceling any previous hides.

### setStrokeColorsWithColors:weights:

```objectivec
- (void)setStrokeColorsWithColors:(nonnull NSArray<NSNumber *> *)colors
                          weights:(nonnull NSArray<NSNumber *> *)weights;
```

Sets indexes of colors in palette for line segments. Weights are used for generalization of colors. By default, all segments use palette index 0.

### setStrokeColorsWithColors:

```objectivec
- (void)setStrokeColorsWithColors:(nonnull NSArray<NSNumber *> *)colors;
```

Sets indexes of colors in palette for line segments. All the weights are equal to 1.

### setPaletteColorWithColorIndex:color:

```objectivec
- (void)setPaletteColorWithColorIndex:(NSUInteger)colorIndex
                                color:(nonnull UIColor *)color;
```

Sets color in RGBA mode for colorIndex. If the color is not provided for some index, the default value 0x0066FFFF is used.

### getPaletteColorWithColorIndex:

```objectivec
- (nonnull UIColor *)getPaletteColorWithColorIndex:(NSUInteger)colorIndex;
```

Returns the palette color for the specified index.

### setStrokeColorWithColor:

```objectivec
- (void)setStrokeColorWithColor:(nonnull UIColor *)color;
```

Sets the polyline color. Effectively sets a single-color palette and sets all segments' palette indices to 0.

### getStrokeColorWithSegmentIndex:

```objectivec
- (NSUInteger)getStrokeColorWithSegmentIndex:(NSUInteger)segmentIndex;
```

Returns the palette index used by segment with the specified index.

### addArrowWithPosition:length:fillColor:

```objectivec
- (nonnull YMKArrow *)addArrowWithPosition:
                          (nonnull YMKPolylinePosition *)position
                                    length:(float)length
                                 fillColor:(nonnull UIColor *)fillColor;
```

Adds an arrow.

| Parameters |   |
| --- | --- |
| position | Coordinates of the center of the arrow. |
| length | Overall length of the arrow (including the tip) in units. |
| fillColor | Color of the arrow. Adding arrows disables dash for this polyline. |

### arrows

```objectivec
- (nonnull NSArray<YMKArrow *> *)arrows;
```

Provides arrows.

## Properties

### geometry

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolyline *geometry;
```

The polyline's geometry. Should contain at least 2 points. Changing geometry resets polyline color indices to 0.

### style

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKLineStyle *style;
```

The polyline's style.

### strokeWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float strokeWidth;
```

The stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### gradientLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gradientLength;
```

Maximum length (in units) of the gradient from one color to another. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### outlineColor

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    UIColor *outlineColor;
```

The outline color. Default: hexademical RGBA code 0x00000000.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### outlineWidth

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float outlineWidth;
```

Width of the outline in units. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### innerOutlineEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isInnerOutlineEnabled) BOOL innerOutlineEnabled;
```

Enables the inner outline if true (a dark border along the edge of the outline). Default: false.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### turnRadius

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float turnRadius;
```

Maximum radius of a turn. Measured in units. Default: 10.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### arcApproximationStep

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    float arcApproximationStep;
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees. Default: 12.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### dashLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashLength;
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### gapLength

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float gapLength;
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### dashOffset

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float dashOffset;
```

Offset from the start of the polyline to the reference dash in units. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.
