---
title: "YMKSpeedControlHighlightStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSpeedControlHighlightStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedControlHighlightStyle.html"
---
# YMKSpeedControlHighlightStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedControlHighlightStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKSpeedControlHighlightStyle : NSObject
```

## Summary

### Class methods

```swift
 init(stroke strokeColor: UIColor,
             strokeWidth: Float,
          fill fillColor: UIColor,
           maximumRadius: Float,
       animationDuration: TimeInterval,
         pulsationCenter: CGPoint)
```

### Properties

```swift
var strokeColor: UIColor { get }
```

```swift
var strokeWidth: Float { get }
```

Sets the stroke width in units

```swift
var fillColor: UIColor { get }
```

```swift
var maximumRadius: Float { get }
```

Sets the maximum circle radius in units

```swift
var animationDuration: TimeInterval { get }
```

Sets the time it takes for the circle to reach its maximum size

```swift
var pulsationCenter: CGPoint { get }
```

Pulsation center on road event pin image

## Class methods

### init(stroke:strokeWidth:fill:maximumRadius:animationDuration:pulsationCenter:)

```swift
 init(stroke strokeColor: UIColor,
             strokeWidth: Float,
          fill fillColor: UIColor,
           maximumRadius: Float,
       animationDuration: TimeInterval,
         pulsationCenter: CGPoint)
```

## Properties

### strokeColor

```swift
var strokeColor: UIColor { get }
```

### strokeWidth

```swift
var strokeWidth: Float { get }
```

Sets the stroke width in units. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### fillColor

```swift
var fillColor: UIColor { get }
```

### maximumRadius

```swift
var maximumRadius: Float { get }
```

Sets the maximum circle radius in units.

### animationDuration

```swift
var animationDuration: TimeInterval { get }
```

Sets the time it takes for the circle to reach its maximum size.

### pulsationCenter

```swift
var pulsationCenter: CGPoint { get }
```

Pulsation center on road event pin image. (0, 0) is top left and (1.0, 1.0) is bottom right.
