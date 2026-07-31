---
title: "Surface"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.runtime.view"
section: "Android / Справочник / com.yandex.runtime.view / Surface"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/view/Surface.html"
---
# Surface

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/runtime/view/Surface.html)

**Package** com.yandex.runtime.view

`interface Surface`

Here is android only implementation

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `android.graphics.PointF` | `getAnchorPoint()`<br>Anchor shifts the region of the frame that will be rendered on the surface. |
| `void` | `setAnchorPoint(@NonNull android.graphics.PointF anchorPoint)` |

## Methods

### getAnchorPoint

```java
@NonNull
android.graphics.PointF getAnchorPoint()
```

Anchor shifts the region of the frame that will be rendered on the surface.

Anchor coordinates are within [0; 1] bounds. Position of frame’s focusPoint will match specified anchorPoint in the surface: - (0, 0) - left bottom corner of the surface; - (1, 1) - right top corner of the surface; Default value is (0.5, 0.5)

### setAnchorPoint

```java
void setAnchorPoint(@NonNull android.graphics.PointF anchorPoint)
```
