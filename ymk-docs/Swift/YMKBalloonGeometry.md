---
title: "YMKBalloonGeometry"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBalloonGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonGeometry.html"
---
# YMKBalloonGeometry

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonGeometry.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKBalloonGeometry : NSObject
```

## Summary

### Class methods

```swift
 init(anchor: YMKBalloonAnchor,
       width: Float,
      height: Float,
 imageAnchor: CGPoint,
 contentRect: YMKRect,
 balloonRect: YMKRect)
```

### Properties

```swift
var anchor: YMKBalloonAnchor { get }
```

```swift
var width: Float { get }
```

Total balloon image size

```swift
var height: Float { get }
```

```swift
var imageAnchor: CGPoint { get }
```

Anchor inside image rect

```swift
var contentRect: YMKRect { get }
```

area with main information, except leg/borders

```swift
var balloonRect: YMKRect { get }
```

area with balloon, except leg, shadows, etc

## Class methods

### init(anchor:width:height:imageAnchor:contentRect:balloonRect:)

```swift
 init(anchor: YMKBalloonAnchor,
       width: Float,
      height: Float,
 imageAnchor: CGPoint,
 contentRect: YMKRect,
 balloonRect: YMKRect)
```

## Properties

### anchor

```swift
var anchor: YMKBalloonAnchor { get }
```

### width

```swift
var width: Float { get }
```

Total balloon image size

### height

```swift
var height: Float { get }
```

### imageAnchor

```swift
var imageAnchor: CGPoint { get }
```

Anchor inside image rect. Coordinates from 0 to 1 are inside the image.

### contentRect

```swift
var contentRect: YMKRect { get }
```

area with main information, except leg/borders

### balloonRect

```swift
var balloonRect: YMKRect { get }
```

area with balloon, except leg, shadows, etc.
