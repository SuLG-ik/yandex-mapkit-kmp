---
title: "Polyline"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Polyline"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Polyline.html"
---
# Polyline

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Polyline.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Polyline

`class Polyline implements Serializable`

A polyline between a number of points.

A polyline is drawn between consecutive points.

## Summary

### Constructors

**Signature and Description**

```java
Polyline()
```

Use constructor with parameters in your code.

```java
Polyline(@NonNull java.util.List<Point> points)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Point>` | `getPoints()`<br>The list of points to connect. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Polyline

```java
Polyline()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Polyline

```java
Polyline(@NonNull java.util.List<Point> points)
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
