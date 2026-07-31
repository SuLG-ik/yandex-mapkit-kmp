---
title: "YMKPolylineMapObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolylineMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineMapObject.html"
---
# YMKPolylineMapObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylineMapObject.html)

```swift
class YMKPolylineMapObject : YMKMapObject
```

A polyline object with adjustable segment colors. Supports outlines, dash, arrows, and hiding parts of the polyline efficiently.

## Summary

### Instance methods

```swift
func select(withSelectionColor selectionColor: UIColor,
                                  subpolyline: YMKSubpolyline)
```

Highlights a subpolyline using the specified color

```swift
func hide(with subpolyline: YMKSubpolyline)
```

Hides the subpolyline, canceling any previous hides

```swift
func hide(with subpolylines: [YMKSubpolyline])
```

Hides multiple subpolylines, canceling any previous hides

```swift
func setStrokeColorsWithColors(_ colors: [NSNumber], weights: [NSNumber])
```

Sets indexes of colors in palette for line segments

```swift
func setStrokeColorsWithColors(_ colors: [NSNumber])
```

Sets indexes of colors in palette for line segments

```swift
func setPaletteColorWithColorIndex(_ colorIndex: UInt, color: UIColor)
```

Sets color in RGBA mode for colorIndex

```swift
func getPaletteColor(withColorIndex colorIndex: UInt) -> UIColor
```

Returns the palette color for the specified index

```swift
func setStrokeColorWith(_ color: UIColor)
```

Sets the polyline color

```swift
func getStrokeColor(withSegmentIndex segmentIndex: UInt) -> UInt
```

Returns the palette index used by segment with the specified index

```swift
func addArrow(with position: YMKPolylinePosition,
                     length: Float,
             fill fillColor: UIColor) -> YMKArrow
```

Adds an arrow

```swift
func arrows() -> [YMKArrow]
```

Provides arrows

### Properties

```swift
var geometry: YMKPolyline { get set }
```

The polyline's geometry

```swift
var style: YMKLineStyle { get set }
```

The polyline's style

```swift
var strokeWidth: Float { get set }
```

The stroke width in units

```swift
var gradientLength: Float { get set }
```

Maximum length (in units) of the gradient from one color to another

```swift
var outlineColor: UIColor { get set }
```

The outline color

```swift
var outlineWidth: Float { get set }
```

Width of the outline in units

```swift
var isInnerOutlineEnabled: Bool { get set }
```

Enables the inner outline if true (a dark border along the edge of the outline)

```swift
var turnRadius: Float { get set }
```

Maximum radius of a turn

```swift
var arcApproximationStep: Float { get set }
```

Defines step of arc approximation

```swift
var dashLength: Float { get set }
```

Length of a dash in units

```swift
var gapLength: Float { get set }
```

Length of the gap between two dashes in units

```swift
var dashOffset: Float { get set }
```

Offset from the start of the polyline to the reference dash in units

## Instance methods

### select(withSelectionColor:subpolyline:)

```swift
func select(withSelectionColor selectionColor: UIColor,
                                  subpolyline: YMKSubpolyline)
```

Highlights a subpolyline using the specified color.

### hide(with:)

```swift
func hide(with subpolyline: YMKSubpolyline)
```

Hides the subpolyline, canceling any previous hides.

### hide(with:)

```swift
func hide(with subpolylines: [YMKSubpolyline])
```

Hides multiple subpolylines, canceling any previous hides.

### setStrokeColorsWithColors(_:weights:)

```swift
func setStrokeColorsWithColors(_ colors: [NSNumber], weights: [NSNumber])
```

Sets indexes of colors in palette for line segments. Weights are used for generalization of colors. By default, all segments use palette index 0.

### setStrokeColorsWithColors(_:)

```swift
func setStrokeColorsWithColors(_ colors: [NSNumber])
```

Sets indexes of colors in palette for line segments. All the weights are equal to 1.

### setPaletteColorWithColorIndex(_:color:)

```swift
func setPaletteColorWithColorIndex(_ colorIndex: UInt, color: UIColor)
```

Sets color in RGBA mode for colorIndex. If the color is not provided for some index, the default value 0x0066FFFF is used.

### getPaletteColor(withColorIndex:)

```swift
func getPaletteColor(withColorIndex colorIndex: UInt) -> UIColor
```

Returns the palette color for the specified index.

### setStrokeColorWith(_:)

```swift
func setStrokeColorWith(_ color: UIColor)
```

Sets the polyline color. Effectively sets a single-color palette and sets all segments' palette indices to 0.

### getStrokeColor(withSegmentIndex:)

```swift
func getStrokeColor(withSegmentIndex segmentIndex: UInt) -> UInt
```

Returns the palette index used by segment with the specified index.

### addArrow(with:length:fill:)

```swift
func addArrow(with position: YMKPolylinePosition,
                     length: Float,
             fill fillColor: UIColor) -> YMKArrow
```

Adds an arrow.

| Parameters |   |
| --- | --- |
| position | Coordinates of the center of the arrow. |
| length | Overall length of the arrow (including the tip) in units. |
| fillColor | Color of the arrow. Adding arrows disables dash for this polyline. |

### arrows()

```swift
func arrows() -> [YMKArrow]
```

Provides arrows.

## Properties

### geometry

```swift
var geometry: YMKPolyline { get set }
```

The polyline's geometry. Should contain at least 2 points. Changing geometry resets polyline color indices to 0.

### style

```swift
var style: YMKLineStyle { get set }
```

The polyline's style.

### strokeWidth

```swift
var strokeWidth: Float { get set }
```

The stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### gradientLength

```swift
var gradientLength: Float { get set }
```

Maximum length (in units) of the gradient from one color to another. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### outlineColor

```swift
var outlineColor: UIColor { get set }
```

The outline color. Default: hexademical RGBA code 0x00000000.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### outlineWidth

```swift
var outlineWidth: Float { get set }
```

Width of the outline in units. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### isInnerOutlineEnabled

```swift
var isInnerOutlineEnabled: Bool { get set }
```

Enables the inner outline if true (a dark border along the edge of the outline). Default: false.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### turnRadius

```swift
var turnRadius: Float { get set }
```

Maximum radius of a turn. Measured in units. Default: 10.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### arcApproximationStep

```swift
var arcApproximationStep: Float { get set }
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees. Default: 12.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### dashLength

```swift
var dashLength: Float { get set }
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### gapLength

```swift
var gapLength: Float { get set }
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.

### dashOffset

```swift
var dashOffset: Float { get set }
```

Offset from the start of the polyline to the reference dash in units. Default: 0.

> [!CAUTION] Внимание
> Use LineStyle for actions with properties.
