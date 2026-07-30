---
title: "GestureFocusPointMode"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / GestureFocusPointMode"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GestureFocusPointMode.html"
---
# GestureFocusPointMode

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GestureFocusPointMode.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.map.GestureFocusPointMode

`final enum GestureFocusPointMode`

Specifies the way provided zoom focus point affects gestures.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [AFFECTS_TAP_GESTURES](GestureFocusPointMode.md#affects_tap_gestures) | Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point. |
| [AFFECTS_ALL_GESTURES](GestureFocusPointMode.md#affects_all_gestures) | All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static GestureFocusPointMode[]` | `values()` |
| `static GestureFocusPointMode` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### AFFECTS_TAP_GESTURES

|   |   |   |
| --- | --- | --- |
| `static final` | [GestureFocusPointMode](GestureFocusPointMode.md) | AFFECTS_TAP_GESTURES |

Only "double tap" (zoom in) and "tap with two fingers" (zoom out) use provided gesture focus point.

Other gestures ignore it and continue to use their source point for transformation.

### AFFECTS_ALL_GESTURES

|   |   |   |
| --- | --- | --- |
| `static final` | [GestureFocusPointMode](GestureFocusPointMode.md) | AFFECTS_ALL_GESTURES |

All gestures: pinch and stretch, tap and swipe, double tap, tap with two fingers, rotation use provided gesture focus point and ignore their source point.

@attention Scroll is suppressed when this mode is on and "pinch and stretch" or "rotation" gesture performed

## Methods

### values

```java
GestureFocusPointMode[] values()
```

### valueOf

```java
GestureFocusPointMode valueOf(java.lang.String name)
```
