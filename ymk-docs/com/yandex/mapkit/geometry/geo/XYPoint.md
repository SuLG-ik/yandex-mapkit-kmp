---
title: "XYPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry.geo"
section: "Android / Справочник / com.yandex.mapkit.geometry.geo / XYPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/XYPoint.html"
---
# XYPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/XYPoint.html)

**Package** com.yandex.mapkit.geometry.geo

java.lang.Object
↳ com.yandex.mapkit.geometry.geo.XYPoint

`class XYPoint implements Serializable`

World coordinates.

## Summary

### Constructors

**Signature and Description**

```java
XYPoint(double x,
        double y)
```

```java
XYPoint()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getX()`<br>The horizontal position of the point. |
| `double` | `getY()`<br>The vertical position of the point. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### XYPoint

```java
XYPoint(double x,
        double y)
```

### XYPoint

```java
XYPoint()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getX

```java
double getX()
```

The horizontal position of the point.

### getY

```java
double getY()
```

The vertical position of the point.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
