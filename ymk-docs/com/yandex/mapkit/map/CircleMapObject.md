---
title: "CircleMapObject"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CircleMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CircleMapObject.html"
---
# CircleMapObject

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CircleMapObject.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[MapObject](MapObject.md)*

`interface CircleMapObject extends MapObject`

The circle element.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Circle` | `getGeometry()` |
| `void` | `setGeometry(@NonNull Circle geometry)` |
| `int` | `getStrokeColor()`<br>Sets the stroke color. |
| `void` | `setStrokeColor(int strokeColor)` |
| `float` | `getStrokeWidth()`<br>Sets the stroke width in units. |
| `void` | `setStrokeWidth(float strokeWidth)` |
| `int` | `getFillColor()`<br>Sets the fill color. |
| `void` | `setFillColor(int fillColor)` |
| `boolean` | `isGeodesic()`<br>The object's geometry can be interpreted in two different ways:<br>- If the object mode is 'geodesic', the object's geometry is defined on a sphere.<br>- Otherwise, the object's geometry is defined in projected space.<br>Default: false. |
| `void` | `setGeodesic(boolean geodesic)` |

## Methods

### getGeometry

```java
@NonNull
Circle getGeometry()
```

### setGeometry

```java
void setGeometry(@NonNull Circle geometry)
```

### getStrokeColor

```java
int getStrokeColor()
```

Sets the stroke color.

Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke. default: 0x0066FFFF

### setStrokeColor

```java
void setStrokeColor(int strokeColor)
```

### getStrokeWidth

```java
float getStrokeWidth()
```

Sets the stroke width in units.

The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1. default: 5

### setStrokeWidth

```java
void setStrokeWidth(float strokeWidth)
```

### getFillColor

```java
int getFillColor()
```

Sets the fill color.

default: 0x0066FF99

### setFillColor

```java
void setFillColor(int fillColor)
```

### isGeodesic

```java
boolean isGeodesic()
```

The object's geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object's geometry is defined on a sphere.
- Otherwise, the object's geometry is defined in projected space.

Default: false.

### setGeodesic

```java
void setGeodesic(boolean geodesic)
```
