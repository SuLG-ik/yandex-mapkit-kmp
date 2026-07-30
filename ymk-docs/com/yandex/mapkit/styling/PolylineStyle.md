---
title: "PolylineStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / PolylineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/PolylineStyle.html"
---
# PolylineStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/PolylineStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

`interface PolylineStyle`

Zoom and tilt independent styling parameters for outline.

Default values for PolylineStyle fields are the same as corresponding PolylineMapObject if not specified explicitly.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setStrokeWidth(@NonNull ProportionFunction strokeWidth)`<br>The stroke width in units (see mapkit.map.PolylineMapObject.strokeWidth for details). |
| `void` | `setOutlineWidth(@NonNull ProportionFunction outlineWidth)`<br>Width of the outline in units. |
| `void` | `setStrokeColor(int strokeColor)`<br>Primary color of polyline. |
| `void` | `setOutlineColor(int outlineColor)`<br>Color of outline in polyline. |
| `void` | `setInnerOutlineEnabled(boolean innerOutlineEnabled)`<br>Enables the inner outline if true (a dark border along the edge of the outline). |
| `void` | `setTurnRadius(float turnRadius)`<br>Maximum radius of a turn. |
| `void` | `setArcApproximationStep(float arcApproximationStep)`<br>Defines step of arc approximation. |
| `void` | `setDashLength(float dashLength)`<br>Length of a dash in units. |
| `void` | `setGapLength(float gapLength)`<br>Length of the gap between two dashes in units. |
| `void` | `setDashOffset(float dashOffset)`<br>Offset from the start of the polyline to the reference dash in units. |
| `boolean` | `isValid()`<br>Tells if this **PolylineStyle** is valid or not. |

## Methods

### setStrokeWidth

```java
void setStrokeWidth(@NonNull ProportionFunction strokeWidth)
```

The stroke width in units (see mapkit.map.PolylineMapObject.strokeWidth for details).

Default: constantValue: 5

### setOutlineWidth

```java
void setOutlineWidth(@NonNull ProportionFunction outlineWidth)
```

Width of the outline in units.

Default: 0

### setStrokeColor

```java
void setStrokeColor(int strokeColor)
```

Primary color of polyline.

Used only if jams disabled or unavailable.

### setOutlineColor

```java
void setOutlineColor(int outlineColor)
```

Color of outline in polyline.

### setInnerOutlineEnabled

```java
void setInnerOutlineEnabled(boolean innerOutlineEnabled)
```

Enables the inner outline if true (a dark border along the edge of the outline).

### setTurnRadius

```java
void setTurnRadius(float turnRadius)
```

Maximum radius of a turn.

Measured in units.

### setArcApproximationStep

```java
void setArcApproximationStep(float arcApproximationStep)
```

Defines step of arc approximation.

Smaller values make polyline smoother. Measured in degrees.

### setDashLength

```java
void setDashLength(float dashLength)
```

Length of a dash in units.

Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setGapLength

```java
void setGapLength(float gapLength)
```

Length of the gap between two dashes in units.

Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setDashOffset

```java
void setDashOffset(float dashOffset)
```

Offset from the start of the polyline to the reference dash in units.

Default: 0.

### isValid

```java
boolean isValid()
```

Tells if this **PolylineStyle** is valid or not.

Any other method (except for this one) called on an invalid **PolylineStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
