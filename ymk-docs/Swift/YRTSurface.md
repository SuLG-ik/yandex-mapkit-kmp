---
title: "YRTSurface"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTSurface"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTSurface.html"
---
# YRTSurface

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTSurface.html)

```swift
class YRTSurface : NSObject
```

Here is android only implementation

## Summary

### Properties

```swift
var anchorPoint: CGPoint { get set }
```

Anchor shifts the region of the frame that will be rendered on the surface

## Properties

### anchorPoint

```swift
var anchorPoint: CGPoint { get set }
```

Anchor shifts the region of the frame that will be rendered on the surface. Anchor coordinates are within [0; 1] bounds. Position of frame’s focusPoint will match specified anchorPoint in the surface: - (0, 0) - left bottom corner of the surface; - (1, 1) - right top corner of the surface; Default value is (0.5, 0.5)
