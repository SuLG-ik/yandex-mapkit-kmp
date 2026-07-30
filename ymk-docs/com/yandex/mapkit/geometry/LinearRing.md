---
title: "LinearRing"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / LinearRing"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/LinearRing.html"
---
# LinearRing

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/LinearRing.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.LinearRing

`class LinearRing implements Serializable`

A sequence of four or more vertices, with all points along the linearly-interpolated curves (line segments) between each pair of consecutive vertices.

A ring must have either 0, 4 or more points. The first and last points of the ring must be in the same position. The ring must not intersect with itself.

## Summary

### Constructors

**Signature and Description**

```java
LinearRing()
```

Use constructor with parameters in your code.

```java
LinearRing(@NonNull java.util.List<Point> points)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Point>` | `getPoints()`<br>The list of points to connect. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LinearRing

```java
LinearRing()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LinearRing

```java
LinearRing(@NonNull java.util.List<Point> points)
```

## Methods

### getPoints

```java
@NonNull
java.util.List<Point> getPoints()
```

The list of points to connect.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
