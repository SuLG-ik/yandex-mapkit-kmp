---
title: "YMKGestureFocusPointMode"
kind: "Enum"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Enums / YMKGestureFocusPointMode"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGestureFocusPointMode.html"
---
# YMKGestureFocusPointMode

`IOS` · `Objective-C` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGestureFocusPointMode.html)

```objectivec
enum YMKGestureFocusPointMode : NSUInteger {}
```

Specifies the way provided zoom focus point affects gestures.

## Summary

### Enum cases

```objectivec
YMKGestureFocusPointModeAffectsTapGestures
```

Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point

```objectivec
YMKGestureFocusPointModeAffectsAllGestures
```

All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point

## Enum cases

### YMKGestureFocusPointModeAffectsTapGestures

```objectivec
YMKGestureFocusPointModeAffectsTapGestures
```

Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point. Other gestures ignore it and continue to use their source point for transformation.

### YMKGestureFocusPointModeAffectsAllGestures

```objectivec
YMKGestureFocusPointModeAffectsAllGestures
```

All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point. Scroll is suppressed when this mode is on and "pinch and stretch" or "rotation" gesture performed
