---
title: "Geometry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Geometry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Geometry.html"
---
# Geometry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Geometry.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Geometry

`class Geometry implements Serializable`

A container of other geometry objects.

Point - A point on the map. Polyline - A polyline between a number of points. Polygon - A polygon with one or more polygons in it. BoundingBox - A rectangular box around the object. Circle - A circle around the specified point.

## Summary

### Constructors

**Signature and Description**

```java
Geometry()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Geometry` | `fromPoint(@NonNull Point point)` |
| `static Geometry` | `fromPolyline(@NonNull Polyline polyline)` |
| `static Geometry` | `fromPolygon(@NonNull Polygon polygon)` |
| `static Geometry` | `fromMultiPolygon(@NonNull MultiPolygon multiPolygon)` |
| `static Geometry` | `fromBoundingBox(@NonNull BoundingBox boundingBox)` |
| `static Geometry` | `fromCircle(@NonNull Circle circle)` |
| `Point` | `getPoint()` |
| `Polyline` | `getPolyline()` |
| `Polygon` | `getPolygon()` |
| `MultiPolygon` | `getMultiPolygon()` |
| `BoundingBox` | `getBoundingBox()` |
| `Circle` | `getCircle()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Geometry

```java
Geometry()
```

## Methods

### fromPoint

```java
@NonNull
Geometry fromPoint(@NonNull Point point)
```

### fromPolyline

```java
@NonNull
Geometry fromPolyline(@NonNull Polyline polyline)
```

### fromPolygon

```java
@NonNull
Geometry fromPolygon(@NonNull Polygon polygon)
```

### fromMultiPolygon

```java
@NonNull
Geometry fromMultiPolygon(@NonNull MultiPolygon multiPolygon)
```

### fromBoundingBox

```java
@NonNull
Geometry fromBoundingBox(@NonNull BoundingBox boundingBox)
```

### fromCircle

```java
@NonNull
Geometry fromCircle(@NonNull Circle circle)
```

### getPoint

```java
@Nullable
Point getPoint()
```

### getPolyline

```java
@Nullable
Polyline getPolyline()
```

### getPolygon

```java
@Nullable
Polygon getPolygon()
```

### getMultiPolygon

```java
@Nullable
MultiPolygon getMultiPolygon()
```

### getBoundingBox

```java
@Nullable
BoundingBox getBoundingBox()
```

### getCircle

```java
@Nullable
Circle getCircle()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
