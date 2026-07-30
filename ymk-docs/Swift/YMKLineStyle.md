---
title: "YMKLineStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLineStyle.html"
---
# YMKLineStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLineStyle.html)

```swift
class YMKLineStyle : NSObject
```

The style of the polyline.

## Summary

### Class methods

```swift
 init(strokeWidth: Float,
   gradientLength: Float,
     outlineColor: UIColor,
     outlineWidth: Float,
 innerOutlineEnabled: Bool,
       turnRadius: Float,
 arcApproximationStep: Float,
       dashLength: Float,
        gapLength: Float,
       dashOffset: Float)
```

### Instance methods

```swift
init()
```

### Properties

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
var innerOutlineEnabled: Bool { get set }
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

## Class methods

### init(strokeWidth:gradientLength:outlineColor:outlineWidth:innerOutlineEnabled:turnRadius:arcApproximationStep:dashLength:gapLength:dashOffset:)

```swift
 init(strokeWidth: Float,
   gradientLength: Float,
     outlineColor: UIColor,
     outlineWidth: Float,
 innerOutlineEnabled: Bool,
       turnRadius: Float,
 arcApproximationStep: Float,
       dashLength: Float,
        gapLength: Float,
       dashOffset: Float)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### strokeWidth

```swift
var strokeWidth: Float { get set }
```

The stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### gradientLength

```swift
var gradientLength: Float { get set }
```

Maximum length (in units) of the gradient from one color to another. Default: 0.

### outlineColor

```swift
var outlineColor: UIColor { get set }
```

The outline color. Default: hexademical RGBA code 0x00000000.

### outlineWidth

```swift
var outlineWidth: Float { get set }
```

Width of the outline in units. Default: 0.

### innerOutlineEnabled

```swift
var innerOutlineEnabled: Bool { get set }
```

Enables the inner outline if true (a dark border along the edge of the outline). Default: false.

### turnRadius

```swift
var turnRadius: Float { get set }
```

Maximum radius of a turn. Measured in units. Default: 10.

### arcApproximationStep

```swift
var arcApproximationStep: Float { get set }
```

Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees. Default: 12.

### dashLength

```swift
var dashLength: Float { get set }
```

Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### gapLength

```swift
var gapLength: Float { get set }
```

Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### dashOffset

```swift
var dashOffset: Float { get set }
```

Offset from the start of the polyline to the reference dash in units. Default: 0.
