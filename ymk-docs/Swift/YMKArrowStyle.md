---
title: "YMKArrowStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKArrowStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrowStyle.html"
---
# YMKArrowStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrowStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKArrowStyle : NSObject
```

## Summary

### Instance methods

```swift
func setOutlineWidthWithOutlineWidth(_ outlineWidth: YMKStylingProportionFunction)
```

Width of the arrow's outline in units

```swift
func setLengthWithLength(_ length: YMKStylingProportionFunction)
```

Overall length of the arrow (including the tip) in units

```swift
func setTriangleHeightWithTriangleHeight(_ triangleHeight: YMKStylingProportionFunction)
```

Height of the arrow tip in units

```swift
func setFillColorWithFill(_ fillColor: UIColor)
```

Fill color of the arrow

```swift
func setOutlineColorWithOutlineColor(_ outlineColor: UIColor)
```

Color of the arrow's outline

```swift
func setMinZoomVisibleWithMinZoom(_ minZoom: NSNumber?)
```

Minimal zoom for maneuvers to be visible

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setOutlineWidthWithOutlineWidth(_:)

```swift
func setOutlineWidthWithOutlineWidth(_ outlineWidth: YMKStylingProportionFunction)
```

Width of the arrow's outline in units. Default: 0

### setLengthWithLength(_:)

```swift
func setLengthWithLength(_ length: YMKStylingProportionFunction)
```

Overall length of the arrow (including the tip) in units. Default: constantValue: 90

### setTriangleHeightWithTriangleHeight(_:)

```swift
func setTriangleHeightWithTriangleHeight(_ triangleHeight: YMKStylingProportionFunction)
```

Height of the arrow tip in units. Default: constantValue: 24

### setFillColorWithFill(_:)

```swift
func setFillColorWithFill(_ fillColor: UIColor)
```

Fill color of the arrow. Default: RGBA 0xFFFFFFFF.

### setOutlineColorWithOutlineColor(_:)

```swift
func setOutlineColorWithOutlineColor(_ outlineColor: UIColor)
```

Color of the arrow's outline. Default: RGBA 0x000000FF.

### setMinZoomVisibleWithMinZoom(_:)

```swift
func setMinZoomVisibleWithMinZoom(_ minZoom: NSNumber?)
```

Minimal zoom for maneuvers to be visible. Default: null

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
