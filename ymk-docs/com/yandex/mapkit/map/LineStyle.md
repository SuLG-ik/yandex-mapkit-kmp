---
title: "LineStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / LineStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/LineStyle.html"
---
# LineStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/LineStyle.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.LineStyle

`final class LineStyle implements Serializable`

The style of the polyline.

## Summary

### Constructors

**Signature and Description**

```java
LineStyle(float strokeWidth,
          float gradientLength,
          int outlineColor,
          float outlineWidth,
          boolean innerOutlineEnabled,
          float turnRadius,
          float arcApproximationStep,
          float dashLength,
          float gapLength,
          float dashOffset)
```

```java
LineStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getStrokeWidth()`<br>The stroke width in units. |
| `LineStyle` | `setStrokeWidth(float strokeWidth)`<br>See **#getStrokeWidth()**. |
| `float` | `getGradientLength()`<br>Maximum length (in units) of the gradient from one color to another. |
| `LineStyle` | `setGradientLength(float gradientLength)`<br>See **#getGradientLength()**. |
| `int` | `getOutlineColor()`<br>The outline color. |
| `LineStyle` | `setOutlineColor(int outlineColor)`<br>See **#getOutlineColor()**. |
| `float` | `getOutlineWidth()`<br>Width of the outline in units. |
| `LineStyle` | `setOutlineWidth(float outlineWidth)`<br>See **#getOutlineWidth()**. |
| `boolean` | `getInnerOutlineEnabled()`<br>Enables the inner outline if true (a dark border along the edge of the outline). |
| `LineStyle` | `setInnerOutlineEnabled(boolean innerOutlineEnabled)`<br>See **#getInnerOutlineEnabled()**. |
| `float` | `getTurnRadius()`<br>Maximum radius of a turn. |
| `LineStyle` | `setTurnRadius(float turnRadius)`<br>See **#getTurnRadius()**. |
| `float` | `getArcApproximationStep()`<br>Defines step of arc approximation. |
| `LineStyle` | `setArcApproximationStep(float arcApproximationStep)`<br>See **#getArcApproximationStep()**. |
| `float` | `getDashLength()`<br>Length of a dash in units. |
| `LineStyle` | `setDashLength(float dashLength)`<br>See **#getDashLength()**. |
| `float` | `getGapLength()`<br>Length of the gap between two dashes in units. |
| `LineStyle` | `setGapLength(float gapLength)`<br>See **#getGapLength()**. |
| `float` | `getDashOffset()`<br>Offset from the start of the polyline to the reference dash in units. |
| `LineStyle` | `setDashOffset(float dashOffset)`<br>See **#getDashOffset()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LineStyle

```java
LineStyle(float strokeWidth,
          float gradientLength,
          int outlineColor,
          float outlineWidth,
          boolean innerOutlineEnabled,
          float turnRadius,
          float arcApproximationStep,
          float dashLength,
          float gapLength,
          float dashOffset)
```

### LineStyle

```java
LineStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getStrokeWidth

```java
float getStrokeWidth()
```

The stroke width in units.

Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### setStrokeWidth

```java
LineStyle setStrokeWidth(float strokeWidth)
```

See **#getStrokeWidth()**.

### getGradientLength

```java
float getGradientLength()
```

Maximum length (in units) of the gradient from one color to another.

Default: 0.

### setGradientLength

```java
LineStyle setGradientLength(float gradientLength)
```

See **#getGradientLength()**.

### getOutlineColor

```java
int getOutlineColor()
```

The outline color.

Default: hexademical RGBA code 0x00000000.

### setOutlineColor

```java
LineStyle setOutlineColor(int outlineColor)
```

See **#getOutlineColor()**.

### getOutlineWidth

```java
float getOutlineWidth()
```

Width of the outline in units.

Default: 0.

### setOutlineWidth

```java
LineStyle setOutlineWidth(float outlineWidth)
```

See **#getOutlineWidth()**.

### getInnerOutlineEnabled

```java
boolean getInnerOutlineEnabled()
```

Enables the inner outline if true (a dark border along the edge of the outline).

Default: false.

### setInnerOutlineEnabled

```java
LineStyle setInnerOutlineEnabled(boolean innerOutlineEnabled)
```

See **#getInnerOutlineEnabled()**.

### getTurnRadius

```java
float getTurnRadius()
```

Maximum radius of a turn.

Measured in units. Default: 10.

### setTurnRadius

```java
LineStyle setTurnRadius(float turnRadius)
```

See **#getTurnRadius()**.

### getArcApproximationStep

```java
float getArcApproximationStep()
```

Defines step of arc approximation.

Smaller values make polyline smoother. Measured in degrees. Default: 12.

### setArcApproximationStep

```java
LineStyle setArcApproximationStep(float arcApproximationStep)
```

See **#getArcApproximationStep()**.

### getDashLength

```java
float getDashLength()
```

Length of a dash in units.

Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setDashLength

```java
LineStyle setDashLength(float dashLength)
```

See **#getDashLength()**.

### getGapLength

```java
float getGapLength()
```

Length of the gap between two dashes in units.

Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setGapLength

```java
LineStyle setGapLength(float gapLength)
```

See **#getGapLength()**.

### getDashOffset

```java
float getDashOffset()
```

Offset from the start of the polyline to the reference dash in units.

Default: 0.

### setDashOffset

```java
LineStyle setDashOffset(float dashOffset)
```

See **#getDashOffset()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
