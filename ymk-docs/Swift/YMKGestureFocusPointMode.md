---
title: "YMKGestureFocusPointMode"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKGestureFocusPointMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGestureFocusPointMode.html"
---
# YMKGestureFocusPointMode

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGestureFocusPointMode.html)

```swift
enum YMKGestureFocusPointMode : UInt, @unchecked Sendable
```

Specifies the way provided zoom focus point affects gestures.

## Summary

### Enum cases

```swift
case affectsTapGestures = 0
```

Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point

```swift
case affectsAllGestures = 1
```

All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point

## Enum cases

### affectsTapGestures

```swift
case affectsTapGestures = 0
```

Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point. Other gestures ignore it and continue to use their source point for transformation.

### affectsAllGestures

```swift
case affectsAllGestures = 1
```

All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point. Scroll is suppressed when this mode is on and "pinch and stretch" or "rotation" gesture performed
