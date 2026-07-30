---
title: "Arrow"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Arrow"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Arrow.html"
---
# Arrow

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Arrow.html)

**Package** com.yandex.mapkit.map

`interface Arrow`

The arrow element.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>Arrow center. |
| `int` | `getFillColor()`<br>Arrow fill color. |
| `void` | `setFillColor(int fillColor)` |
| `int` | `getOutlineColor()`<br>Color of the arrow's outline. |
| `void` | `setOutlineColor(int outlineColor)` |
| `float` | `getOutlineWidth()`<br>The width of the outline in units. |
| `void` | `setOutlineWidth(float outlineWidth)` |
| `float` | `getLength()`<br>The overall length of the arrow (including the tip) in units. |
| `void` | `setLength(float length)` |
| `boolean` | `isVisible()`<br>Arrow visibility. |
| `void` | `setVisible(boolean visible)` |
| `float` | `getTriangleHeight()`<br>Describes height of the arrowhead in units. |
| `void` | `setTriangleHeight(float triangleHeight)` |
| `boolean` | `isValid()`<br>Tells if this **Arrow** is valid or not. |

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

Arrow center.

### getFillColor

```java
int getFillColor()
```

Arrow fill color.

### setFillColor

```java
void setFillColor(int fillColor)
```

### getOutlineColor

```java
int getOutlineColor()
```

Color of the arrow's outline.

Default: white.

### setOutlineColor

```java
void setOutlineColor(int outlineColor)
```

### getOutlineWidth

```java
float getOutlineWidth()
```

The width of the outline in units.

Default: 2.

### setOutlineWidth

```java
void setOutlineWidth(float outlineWidth)
```

### getLength

```java
float getLength()
```

The overall length of the arrow (including the tip) in units.

The size of a unit is equal to the size of a pixel at the current zoom level when the camera tilt is equal to 0 and the scale factor is equal to 1.

### setLength

```java
void setLength(float length)
```

### isVisible

```java
boolean isVisible()
```

Arrow visibility.

Default: true.

### setVisible

```java
void setVisible(boolean visible)
```

### getTriangleHeight

```java
float getTriangleHeight()
```

Describes height of the arrowhead in units.

Default: 0.2 * length.

### setTriangleHeight

```java
void setTriangleHeight(float triangleHeight)
```

### isValid

```java
boolean isValid()
```

Tells if this **Arrow** is valid or not.

Any other method (except for this one) called on an invalid **Arrow** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
