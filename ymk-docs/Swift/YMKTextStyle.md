---
title: "YMKTextStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTextStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTextStyle.html"
---
# YMKTextStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTextStyle.html)

```swift
class YMKTextStyle : NSObject
```

The style of placemarks's text.

## Summary

### Class methods

```swift
 init(size: Float,
     color: UIColor,
 outlineWidth: Float,
 outlineColor: UIColor,
 placement: YMKTextStylePlacement,
    offset: Float,
 offsetFromIcon: Bool,
 textOptional: Bool)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var size: Float { get set }
```

Text font size in units

```swift
var color: UIColor { get set }
```

Text color

```swift
var outlineWidth: Float { get set }
```

Outline width in units

```swift
var outlineColor: UIColor { get set }
```

Outline color

```swift
var placement: YMKTextStylePlacement { get set }
```

Text placement position

```swift
var offset: Float { get set }
```

Text offset in units

```swift
var offsetFromIcon: Bool { get set }
```

When set, YMKTextStyle::offset is a padding between the text and icon edges

```swift
var textOptional: Bool { get set }
```

Allow dropping text but keeping icon during conflict resolution default: false

## Class methods

### init(size:color:outlineWidth:outlineColor:placement:offset:offsetFromIcon:textOptional:)

```swift
 init(size: Float,
     color: UIColor,
 outlineWidth: Float,
 outlineColor: UIColor,
 placement: YMKTextStylePlacement,
    offset: Float,
 offsetFromIcon: Bool,
 textOptional: Bool)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### size

```swift
var size: Float { get set }
```

Text font size in units. default: 8

### color

```swift
var color: UIColor { get set }
```

Text color. default: black

### outlineWidth

```swift
var outlineWidth: Float { get set }
```

Outline width in units. default: 1

### outlineColor

```swift
var outlineColor: UIColor { get set }
```

Outline color. default: white

### placement

```swift
var placement: YMKTextStylePlacement { get set }
```

Text placement position. default: Center

### offset

```swift
var offset: Float { get set }
```

Text offset in units. Measured either from point or form icon edges, depending on YMKTextStyle::offsetFromIcon value Direction of the offset specified with YMKTextStyle::placement property Ignored when placement is 'Center' default: 0

### offsetFromIcon

```swift
var offsetFromIcon: Bool { get set }
```

When set, YMKTextStyle::offset is a padding between the text and icon edges. default: true

### textOptional

```swift
var textOptional: Bool { get set }
```

Allow dropping text but keeping icon during conflict resolution default: false
