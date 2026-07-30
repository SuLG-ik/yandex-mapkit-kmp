---
title: "PolylineMapObject"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PolylineMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PolylineMapObject.html"
---
# PolylineMapObject

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PolylineMapObject.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[MapObject](MapObject.md)*

`interface PolylineMapObject extends MapObject`

A polyline object with adjustable segment colors.

Supports outlines, dash, arrows, and hiding parts of the polyline efficiently.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Polyline` | `getGeometry()`<br>The polyline's geometry. |
| `void` | `setGeometry(@NonNull Polyline geometry)` |
| `LineStyle` | `getStyle()`<br>The polyline's style. |
| `void` | `setStyle(@NonNull LineStyle style)` |
| `float` | `getStrokeWidth()` |
| `void` | `setStrokeWidth(float strokeWidth)` |
| `float` | `getGradientLength()` |
| `void` | `setGradientLength(float gradientLength)` |
| `int` | `getOutlineColor()` |
| `void` | `setOutlineColor(int outlineColor)` |
| `float` | `getOutlineWidth()` |
| `void` | `setOutlineWidth(float outlineWidth)` |
| `boolean` | `isInnerOutlineEnabled()` |
| `void` | `setInnerOutlineEnabled(boolean innerOutlineEnabled)` |
| `float` | `getTurnRadius()` |
| `void` | `setTurnRadius(float turnRadius)` |
| `float` | `getArcApproximationStep()` |
| `void` | `setArcApproximationStep(float arcApproximationStep)` |
| `float` | `getDashLength()` |
| `void` | `setDashLength(float dashLength)` |
| `float` | `getGapLength()` |
| `void` | `setGapLength(float gapLength)` |
| `float` | `getDashOffset()` |
| `void` | `setDashOffset(float dashOffset)` |
| `void` | `select(int selectionColor, @NonNull Subpolyline subpolyline)`<br>Highlights a subpolyline using the specified color. |
| `void` | `hide(@NonNull Subpolyline subpolyline)`<br>Hides the subpolyline, canceling any previous hides. |
| `void` | `hide(@NonNull java.util.List<Subpolyline> subpolylines)`<br>Hides multiple subpolylines, canceling any previous hides. |
| `void` | `setStrokeColors(@NonNull java.util.List<java.lang.Integer> colors, @NonNull java.util.List<java.lang.Double> weights)`<br>Sets indexes of colors in palette for line segments. |
| `void` | `setStrokeColors(@NonNull java.util.List<java.lang.Integer> colors)`<br>Sets indexes of colors in palette for line segments. |
| `void` | `setPaletteColor(int colorIndex, int color)`<br>Sets color in RGBA mode for colorIndex. |
| `int` | `getPaletteColor(int colorIndex)`<br>Returns the palette color for the specified index. |
| `void` | `setStrokeColor(int color)`<br>Sets the polyline color. |
| `int` | `getStrokeColor(int segmentIndex)`<br>Returns the palette index used by segment with the specified index. |
| `Arrow` | `addArrow(@NonNull PolylinePosition position, float length, int fillColor)`<br>Adds an arrow. |
| `java.util.List<Arrow>` | `arrows()`<br>Provides arrows. |

## Methods

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

The polyline's geometry.

Should contain at least 2 points. Changing geometry resets polyline color indices to 0.

### setGeometry

```java
void setGeometry(@NonNull Polyline geometry)
```

### getStyle

```java
@NonNull
LineStyle getStyle()
```

The polyline's style.

### setStyle

```java
void setStyle(@NonNull LineStyle style)
```

### getStrokeWidth

```java
@Deprecated
float getStrokeWidth()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. The stroke width in units. Default: 5. The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### setStrokeWidth

```java
@Deprecated
void setStrokeWidth(float strokeWidth)
```

### getGradientLength

```java
@Deprecated
float getGradientLength()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Maximum length (in units) of the gradient from one color to another. Default: 0.

### setGradientLength

```java
@Deprecated
void setGradientLength(float gradientLength)
```

### getOutlineColor

```java
@Deprecated
int getOutlineColor()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. The outline color. Default: hexademical RGBA code 0x00000000.

### setOutlineColor

```java
@Deprecated
void setOutlineColor(int outlineColor)
```

### getOutlineWidth

```java
@Deprecated
float getOutlineWidth()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Width of the outline in units. Default: 0.

### setOutlineWidth

```java
@Deprecated
void setOutlineWidth(float outlineWidth)
```

### isInnerOutlineEnabled

```java
@Deprecated
boolean isInnerOutlineEnabled()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Enables the inner outline if true (a dark border along the edge of the outline). Default: false.

### setInnerOutlineEnabled

```java
@Deprecated
void setInnerOutlineEnabled(boolean innerOutlineEnabled)
```

### getTurnRadius

```java
@Deprecated
float getTurnRadius()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Maximum radius of a turn. Measured in units. Default: 10.

### setTurnRadius

```java
@Deprecated
void setTurnRadius(float turnRadius)
```

### getArcApproximationStep

```java
@Deprecated
float getArcApproximationStep()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Defines step of arc approximation. Smaller values make polyline smoother. Measured in degrees. Default: 12.

### setArcApproximationStep

```java
@Deprecated
void setArcApproximationStep(float arcApproximationStep)
```

### getDashLength

```java
@Deprecated
float getDashLength()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Length of a dash in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setDashLength

```java
@Deprecated
void setDashLength(float dashLength)
```

### getGapLength

```java
@Deprecated
float getGapLength()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Length of the gap between two dashes in units. Default: 0 (dashing is turned off). Arrows are ignored in dashed polylines.

### setGapLength

```java
@Deprecated
void setGapLength(float gapLength)
```

### getDashOffset

```java
@Deprecated
float getDashOffset()
```

> [!CAUTION] Внимание
> Use LineStyle for actions with properties. Offset from the start of the polyline to the reference dash in units. Default: 0.

### setDashOffset

```java
@Deprecated
void setDashOffset(float dashOffset)
```

### select

```java
void select(int selectionColor,
            @NonNull Subpolyline subpolyline)
```

Highlights a subpolyline using the specified color.

### hide

```java
void hide(@NonNull Subpolyline subpolyline)
```

Hides the subpolyline, canceling any previous hides.

### hide

```java
void hide(@NonNull java.util.List<Subpolyline> subpolylines)
```

Hides multiple subpolylines, canceling any previous hides.

### setStrokeColors

```java
void setStrokeColors(@NonNull java.util.List<java.lang.Integer> colors,
                     @NonNull java.util.List<java.lang.Double> weights)
```

Sets indexes of colors in palette for line segments.

Weights are used for generalization of colors. By default, all segments use palette index 0.

### setStrokeColors

```java
void setStrokeColors(@NonNull java.util.List<java.lang.Integer> colors)
```

Sets indexes of colors in palette for line segments.

All the weights are equal to 1.

### setPaletteColor

```java
void setPaletteColor(int colorIndex,
                     int color)
```

Sets color in RGBA mode for colorIndex.

If the color is not provided for some index, the default value 0x0066FFFF is used.

### getPaletteColor

```java
int getPaletteColor(int colorIndex)
```

Returns the palette color for the specified index.

### setStrokeColor

```java
void setStrokeColor(int color)
```

Sets the polyline color.

Effectively sets a single-color palette and sets all segments' palette indices to 0.

### getStrokeColor

```java
int getStrokeColor(int segmentIndex)
```

Returns the palette index used by segment with the specified index.

### addArrow

```java
@NonNull
Arrow addArrow(@NonNull PolylinePosition position,
               float length,
               int fillColor)
```

Adds an arrow.

| Parameters |   |
| --- | --- |
| `position` | Coordinates of the center of the arrow. |
| `length` | Overall length of the arrow (including the tip) in units. |
| `fillColor` | Color of the arrow. Adding arrows disables dash for this polyline. |

### arrows

```java
@NonNull
java.util.List<Arrow> arrows()
```

Provides arrows.
