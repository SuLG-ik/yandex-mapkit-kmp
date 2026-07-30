---
title: "ArrowManeuverStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ArrowManeuverStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ArrowManeuverStyle.html"
---
# ArrowManeuverStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ArrowManeuverStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ArrowManeuverStyle

`class ArrowManeuverStyle implements Serializable`

The style that is used to display arrow maneuvers on the map.

## Summary

### Constructors

**Signature and Description**

```java
ArrowManeuverStyle(int fillColor,
                   int outlineColor,
                   float outlineWidth,
                   float length,
                   float triangleHeight,
                   boolean enabled)
```

```java
ArrowManeuverStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getFillColor()`<br>Fill color of the arrow. |
| `int` | `getOutlineColor()`<br>Color of the arrow's outline. |
| `float` | `getOutlineWidth()`<br>Width of the arrow's outline in units. |
| `float` | `getLength()`<br>Overall length of the arrow (including the tip) in units. |
| `float` | `getTriangleHeight()`<br>Height of the arrow tip in units. |
| `boolean` | `getEnabled()`<br>Enables/disables arrow maneuvers. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ArrowManeuverStyle

```java
ArrowManeuverStyle(int fillColor,
                   int outlineColor,
                   float outlineWidth,
                   float length,
                   float triangleHeight,
                   boolean enabled)
```

### ArrowManeuverStyle

```java
ArrowManeuverStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getFillColor

```java
int getFillColor()
```

Fill color of the arrow.

### getOutlineColor

```java
int getOutlineColor()
```

Color of the arrow's outline.

### getOutlineWidth

```java
float getOutlineWidth()
```

Width of the arrow's outline in units.

### getLength

```java
float getLength()
```

Overall length of the arrow (including the tip) in units.

### getTriangleHeight

```java
float getTriangleHeight()
```

Height of the arrow tip in units.

### getEnabled

```java
boolean getEnabled()
```

Enables/disables arrow maneuvers.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
