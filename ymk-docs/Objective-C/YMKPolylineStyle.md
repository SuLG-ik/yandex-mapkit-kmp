---
title: "YMKPolylineStyle"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPolylineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineStyle.html"
---
# YMKPolylineStyle

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPolylineStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKPolylineStyle : NSObject
```

Zoom and tilt independent styling parameters for outline. Default values for PolylineStyle fields are the same as corresponding PolylineMapObject if not specified explicitly.

## Summary

### Instance methods

```objectivec
- (void)setStrokeWidthWithStrokeWidth:
    (nonnull YMKStylingProportionFunction *)strokeWidth;
```

The stroke width in units (see mapkit

```objectivec
- (void)setOutlineWidthWithOutlineWidth:
    (nonnull YMKStylingProportionFunction *)outlineWidth;
```

Width of the outline in units

```objectivec
- (void)setStrokeColorWithStrokeColor:(nonnull UIColor *)strokeColor;
```

Primary color of polyline

```objectivec
- (void)setOutlineColorWithOutlineColor:(nonnull UIColor *)outlineColor;
```

Color of outline in polyline

```objectivec
- (void)setInnerOutlineEnabledWithInnerOutlineEnabled:(BOOL)innerOutlineEnabled;
```

Enables the inner outline if true (a dark border along the edge of the outline)

```objectivec
- (void)setTurnRadiusWithTurnRadius:(float)turnRadius;
```

Maximum radius of a turn

```objectivec
- (void)setArcApproximationStepWithArcApproximationStep:
    (float)arcApproximationStep;
```

Defines step of arc approximation

```objectivec
- (void)setDashLengthWithDashLength:(float)dashLength;
```

Length of a dash in units

```objectivec
- (void)setGapLengthWithGapLength:(float)gapLength;
```

Length of the gap between two dashes in units

```objectivec
- (void)setDashOffsetWithDashOffset:(float)dashOffset;
```

Offset from the start of the polyline to the reference dash in units

### Properties

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setStrokeWidthWithStrokeWidth:

```objectivec
- (void)setStrokeWidthWithStrokeWidth:
    (nonnull YMKStylingProportionFunction *)strokeWidth;
```

The stroke width in units (see mapkit.map.PolylineMapObject.strokeWidth for details). Default: constantValue: 5

### setOutlineWidthWithOutlineWidth:

```objectivec
- (void)setOutlineWidthWithOutlineWidth:
    (nonnull YMKStylingProportionFunction *)outlineWidth;
```

Width of the outline in units. Default: 0

### setStrokeColorWithStrokeColor:

```objectivec
- (void)setStrokeColorWithStrokeColor:(nonnull UIColor *)strokeColor;
```

Primary color of polyline. Used only if jams disabled or unavailable.

### setOutlineColorWithOutlineColor:

```objectivec
- (void)setOutlineColorWithOutlineColor:(nonnull UIColor *)outlineColor;
```

Color of outline in polyline.

### setInnerOutlineEnabledWithInnerOutlineEnabled:

```objectivec
- (void)setInnerOutlineEnabledWithInnerOutlineEnabled:(BOOL)innerOutlineEnabled;
```

Enables the inner outline if true (a dark border along the edge of the outline).

### setTurnRadiusWithTurnRadius:

```objectivec
- (void)setTurnRadiusWithTurnRadius:(float)turnRadius;
```

Maximum radius of a turn. Measured in units.

### setArcApproximationStepWithArcApproximationStep:

```objectivec
- (void)setArcApproximationStepWithArcApproximationStep:
    (float)arcApproximationStep;
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees.

### setDashLengthWithDashLength:

```objectivec
- (void)setDashLengthWithDashLength:(float)dashLength;
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setGapLengthWithGapLength:

```objectivec
- (void)setGapLengthWithGapLength:(float)gapLength;
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setDashOffsetWithDashOffset:

```objectivec
- (void)setDashOffsetWithDashOffset:(float)dashOffset;
```

Offset from the start of the polyline to the reference dash in units. Default: 0.

## Properties

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
