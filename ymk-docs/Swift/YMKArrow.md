---
title: "YMKArrow"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKArrow"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrow.html"
---
# YMKArrow

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrow.html)

```swift
class YMKArrow : NSObject
```

The arrow element.

## Summary

### Properties

```swift
var position: YMKPolylinePosition { get }
```

Arrow center

```swift
var fillColor: UIColor { get set }
```

Arrow fill color

```swift
var outlineColor: UIColor { get set }
```

Color of the arrow's outline

```swift
var outlineWidth: Float { get set }
```

The width of the outline in units

```swift
var length: Float { get set }
```

The overall length of the arrow (including the tip) in units

```swift
var isVisible: Bool { get set }
```

Arrow visibility

```swift
var triangleHeight: Float { get set }
```

Describes height of the arrowhead in units

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### position

```swift
var position: YMKPolylinePosition { get }
```

Arrow center.

### fillColor

```swift
var fillColor: UIColor { get set }
```

Arrow fill color.

### outlineColor

```swift
var outlineColor: UIColor { get set }
```

Color of the arrow's outline. Default: white.

### outlineWidth

```swift
var outlineWidth: Float { get set }
```

The width of the outline in units. Default: 2.

### length

```swift
var length: Float { get set }
```

The overall length of the arrow (including the tip) in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera tilt is equal to 0 and the scale factor is equal to 1.

### isVisible

```swift
var isVisible: Bool { get set }
```

Arrow visibility. Default: true.

### triangleHeight

```swift
var triangleHeight: Float { get set }
```

Describes height of the arrowhead in units. Default: 0.2 * length.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
