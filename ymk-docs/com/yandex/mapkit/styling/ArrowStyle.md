---
title: "ArrowStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / ArrowStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/ArrowStyle.html"
---
# ArrowStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/ArrowStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

`interface ArrowStyle`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setOutlineWidth(@NonNull ProportionFunction outlineWidth)`<br>Width of the arrow's outline in units. |
| `void` | `setLength(@NonNull ProportionFunction length)`<br>Overall length of the arrow (including the tip) in units. |
| `void` | `setTriangleHeight(@NonNull ProportionFunction triangleHeight)`<br>Height of the arrow tip in units. |
| `void` | `setFillColor(int fillColor)`<br>Fill color of the arrow. |
| `void` | `setOutlineColor(int outlineColor)`<br>Color of the arrow's outline. |
| `void` | `setMinZoomVisible(@Nullable java.lang.Float minZoom)`<br>Minimal zoom for maneuvers to be visible. |
| `boolean` | `isValid()`<br>Tells if this **ArrowStyle** is valid or not. |

## Methods

### setOutlineWidth

```java
void setOutlineWidth(@NonNull ProportionFunction outlineWidth)
```

Width of the arrow's outline in units.

Default: 0

### setLength

```java
void setLength(@NonNull ProportionFunction length)
```

Overall length of the arrow (including the tip) in units.

Default: constantValue: 90

### setTriangleHeight

```java
void setTriangleHeight(@NonNull ProportionFunction triangleHeight)
```

Height of the arrow tip in units.

Default: constantValue: 24

### setFillColor

```java
void setFillColor(int fillColor)
```

Fill color of the arrow.

Default: RGBA 0xFFFFFFFF.

### setOutlineColor

```java
void setOutlineColor(int outlineColor)
```

Color of the arrow's outline.

Default: RGBA 0x000000FF.

### setMinZoomVisible

```java
void setMinZoomVisible(@Nullable java.lang.Float minZoom)
```

Minimal zoom for maneuvers to be visible.

Default: null

### isValid

```java
boolean isValid()
```

Tells if this **ArrowStyle** is valid or not.

Any other method (except for this one) called on an invalid **ArrowStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
