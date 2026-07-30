---
title: "PolygonMapObject"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PolygonMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PolygonMapObject.html"
---
# PolygonMapObject

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PolygonMapObject.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[MapObject](MapObject.md)*

`interface PolygonMapObject extends MapObject`

A polygon displayed on the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Polygon` | `getGeometry()` |
| `void` | `setGeometry(@NonNull Polygon geometry)` |
| `int` | `getStrokeColor()`<br>Sets the stroke color. |
| `void` | `setStrokeColor(int strokeColor)` |
| `float` | `getStrokeWidth()`<br>Sets the stroke width in units. |
| `void` | `setStrokeWidth(float strokeWidth)` |
| `int` | `getFillColor()`<br>Sets the fill color. |
| `void` | `setFillColor(int fillColor)` |
| `boolean` | `isGeodesic()`<br>The object geometry can be interpreted in two different ways:<br>- If the object mode is 'geodesic', the object geometry is defined on a sphere.<br>- Otherwise, the object geometry is defined in projected space.<br>Default: false. |
| `void` | `setGeodesic(boolean geodesic)` |
| `void` | `setPattern(@NonNull AnimatedImageProvider animatedImage, float scale)`<br>Sets pattern to fill polygon. |
| `void` | `setPattern(@NonNull ImageProvider image, float scale)`<br>Sets pattern to fill polygon. |
| `void` | `resetPattern()`<br>Removes pattern. |

## Methods

### getGeometry

```java
@NonNull
Polygon getGeometry()
```

### setGeometry

```java
void setGeometry(@NonNull Polygon geometry)
```

### getStrokeColor

```java
int getStrokeColor()
```

Sets the stroke color.

Default: hexademical RGBA code 0x0066FFFF. Setting the stroke color to any transparent color (for example, RGBA code 0x00000000) effectively disables the stroke.

### setStrokeColor

```java
void setStrokeColor(int strokeColor)
```

### getStrokeWidth

```java
float getStrokeWidth()
```

Sets the stroke width in units.

Default: 5. The size of a unit is equal to the size of a pixel at the current zoom when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### setStrokeWidth

```java
void setStrokeWidth(float strokeWidth)
```

### getFillColor

```java
int getFillColor()
```

Sets the fill color.

Default: hexademical RGBA code 0x0066FF99.

> [!NOTE] Примечание
> Fill color is ignored if a pattern is set.

### setFillColor

```java
void setFillColor(int fillColor)
```

### isGeodesic

```java
boolean isGeodesic()
```

The object geometry can be interpreted in two different ways:

- If the object mode is 'geodesic', the object geometry is defined on a sphere.
- Otherwise, the object geometry is defined in projected space.

Default: false.

### setGeodesic

```java
void setGeodesic(boolean geodesic)
```

### setPattern

```java
void setPattern(@NonNull AnimatedImageProvider animatedImage,
                float scale)
```

Sets pattern to fill polygon.

@attention Original linear sizes of pattern should be equal to power of 2. @attention Fill color is ignored if a pattern is set.

### setPattern

```java
void setPattern(@NonNull ImageProvider image,
                float scale)
```

Sets pattern to fill polygon.

@attention Original linear sizes of pattern should be equal to power of 2. @attention Fill color is ignored if pattern is set.

### resetPattern

```java
void resetPattern()
```

Removes pattern.
