---
title: "YMKPolylineStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolylineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineStyle.html"
---
# YMKPolylineStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKPolylineStyle : NSObject
```

Zoom and tilt independent styling parameters for outline. Default values for PolylineStyle fields are the same as corresponding PolylineMapObject if not specified explicitly.

## Summary

### Instance methods

```swift
func setStrokeWidthWithStrokeWidth(_ strokeWidth: YMKStylingProportionFunction)
```

The stroke width in units (see mapkit

```swift
func setOutlineWidthWithOutlineWidth(_ outlineWidth: YMKStylingProportionFunction)
```

Width of the outline in units

```swift
func setStrokeColorWithStroke(_ strokeColor: UIColor)
```

Primary color of polyline

```swift
func setOutlineColorWithOutlineColor(_ outlineColor: UIColor)
```

Color of outline in polyline

```swift
func setInnerOutlineEnabledWithInnerOutlineEnabled(_ innerOutlineEnabled: Bool)
```

Enables the inner outline if true (a dark border along the edge of the outline)

```swift
func setTurnRadiusWithTurnRadius(_ turnRadius: Float)
```

Maximum radius of a turn

```swift
func setArcApproximationStepWithArcApproximationStep(_ arcApproximationStep: Float)
```

Defines step of arc approximation

```swift
func setDashLengthWithDashLength(_ dashLength: Float)
```

Length of a dash in units

```swift
func setGapLengthWithGapLength(_ gapLength: Float)
```

Length of the gap between two dashes in units

```swift
func setDashOffsetWithDashOffset(_ dashOffset: Float)
```

Offset from the start of the polyline to the reference dash in units

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setStrokeWidthWithStrokeWidth(_:)

```swift
func setStrokeWidthWithStrokeWidth(_ strokeWidth: YMKStylingProportionFunction)
```

The stroke width in units (see mapkit.map.PolylineMapObject.strokeWidth for details). Default: constantValue: 5

### setOutlineWidthWithOutlineWidth(_:)

```swift
func setOutlineWidthWithOutlineWidth(_ outlineWidth: YMKStylingProportionFunction)
```

Width of the outline in units. Default: 0

### setStrokeColorWithStroke(_:)

```swift
func setStrokeColorWithStroke(_ strokeColor: UIColor)
```

Primary color of polyline. Used only if jams disabled or unavailable.

### setOutlineColorWithOutlineColor(_:)

```swift
func setOutlineColorWithOutlineColor(_ outlineColor: UIColor)
```

Color of outline in polyline.

### setInnerOutlineEnabledWithInnerOutlineEnabled(_:)

```swift
func setInnerOutlineEnabledWithInnerOutlineEnabled(_ innerOutlineEnabled: Bool)
```

Enables the inner outline if true (a dark border along the edge of the outline).

### setTurnRadiusWithTurnRadius(_:)

```swift
func setTurnRadiusWithTurnRadius(_ turnRadius: Float)
```

Maximum radius of a turn. Measured in units.

### setArcApproximationStepWithArcApproximationStep(_:)

```swift
func setArcApproximationStepWithArcApproximationStep(_ arcApproximationStep: Float)
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees.

### setDashLengthWithDashLength(_:)

```swift
func setDashLengthWithDashLength(_ dashLength: Float)
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setGapLengthWithGapLength(_:)

```swift
func setGapLengthWithGapLength(_ gapLength: Float)
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setDashOffsetWithDashOffset(_:)

```swift
func setDashOffsetWithDashOffset(_ dashOffset: Float)
```

Offset from the start of the polyline to the reference dash in units. Default: 0.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
