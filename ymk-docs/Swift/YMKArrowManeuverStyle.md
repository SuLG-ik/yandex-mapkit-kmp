---
title: "YMKArrowManeuverStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKArrowManeuverStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrowManeuverStyle.html"
---
# YMKArrowManeuverStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKArrowManeuverStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKArrowManeuverStyle : NSObject
```

The style that is used to display arrow maneuvers on the map.

## Summary

### Class methods

```swift
 init(fill fillColor: UIColor,
        outlineColor: UIColor,
        outlineWidth: Float,
              length: Float,
      triangleHeight: Float,
             enabled: Bool)
```

### Properties

```swift
var fillColor: UIColor { get }
```

Fill color of the arrow

```swift
var outlineColor: UIColor { get }
```

Color of the arrow's outline

```swift
var outlineWidth: Float { get }
```

Width of the arrow's outline in units

```swift
var length: Float { get }
```

Overall length of the arrow (including the tip) in units

```swift
var triangleHeight: Float { get }
```

Height of the arrow tip in units

```swift
var enabled: Bool { get }
```

Enables/disables arrow maneuvers

## Class methods

### init(fill:outlineColor:outlineWidth:length:triangleHeight:enabled:)

```swift
 init(fill fillColor: UIColor,
        outlineColor: UIColor,
        outlineWidth: Float,
              length: Float,
      triangleHeight: Float,
             enabled: Bool)
```

## Properties

### fillColor

```swift
var fillColor: UIColor { get }
```

Fill color of the arrow.

### outlineColor

```swift
var outlineColor: UIColor { get }
```

Color of the arrow's outline.

### outlineWidth

```swift
var outlineWidth: Float { get }
```

Width of the arrow's outline in units.

### length

```swift
var length: Float { get }
```

Overall length of the arrow (including the tip) in units.

### triangleHeight

```swift
var triangleHeight: Float { get }
```

Height of the arrow tip in units.

### enabled

```swift
var enabled: Bool { get }
```

Enables/disables arrow maneuvers.
