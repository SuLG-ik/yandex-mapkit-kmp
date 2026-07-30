---
title: "SpeedControlHighlightStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.layer.styling"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.layer.styling / SpeedControlHighlightStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/SpeedControlHighlightStyle.html"
---
# SpeedControlHighlightStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/layer/styling/SpeedControlHighlightStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.layer.styling

java.lang.Object
↳ com.yandex.mapkit.navigation.automotive.layer.styling.SpeedControlHighlightStyle

`class SpeedControlHighlightStyle implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
SpeedControlHighlightStyle(int strokeColor,
                           float strokeWidth,
                           int fillColor,
                           float maximumRadius,
                           long animationDuration,
                           @NonNull android.graphics.PointF pulsationCenter)
```

```java
SpeedControlHighlightStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getStrokeColor()` |
| `float` | `getStrokeWidth()`<br>Sets the stroke width in units. |
| `int` | `getFillColor()` |
| `float` | `getMaximumRadius()`<br>Sets the maximum circle radius in units. |
| `long` | `getAnimationDuration()`<br>Sets the time it takes for the circle to reach its maximum size. |
| `android.graphics.PointF` | `getPulsationCenter()`<br>Pulsation center on road event pin image. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SpeedControlHighlightStyle

```java
SpeedControlHighlightStyle(int strokeColor,
                           float strokeWidth,
                           int fillColor,
                           float maximumRadius,
                           long animationDuration,
                           @NonNull android.graphics.PointF pulsationCenter)
```

### SpeedControlHighlightStyle

```java
SpeedControlHighlightStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getStrokeColor

```java
int getStrokeColor()
```

### getStrokeWidth

```java
float getStrokeWidth()
```

Sets the stroke width in units.

The size of a unit is equal to the size of a pixel at the current zoom level when the camera position's tilt is equal to 0 and the scale factor is equal to 1.

### getFillColor

```java
int getFillColor()
```

### getMaximumRadius

```java
float getMaximumRadius()
```

Sets the maximum circle radius in units.

### getAnimationDuration

```java
long getAnimationDuration()
```

Sets the time it takes for the circle to reach its maximum size.

### getPulsationCenter

```java
@NonNull
android.graphics.PointF getPulsationCenter()
```

Pulsation center on road event pin image.

(0, 0) is top left and (1.0, 1.0) is bottom right.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
