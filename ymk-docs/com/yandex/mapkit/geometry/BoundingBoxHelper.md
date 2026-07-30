---
title: "BoundingBoxHelper"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / BoundingBoxHelper"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/BoundingBoxHelper.html"
---
# BoundingBoxHelper

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/BoundingBoxHelper.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.BoundingBoxHelper

`class BoundingBoxHelper`

## Summary

### Constructors

**Signature and Description**

```java
BoundingBoxHelper()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native BoundingBox` | `getBounds(@NonNull BoundingBox bbox)`<br>Gets bounds based on a bounding box. |
| `static native BoundingBox` | `getBounds(@NonNull Point point)`<br>Gets bounds based on a point. |
| `static native BoundingBox` | `getBounds(@NonNull Polyline polyline)`<br>Gets bounds based on a polyline. |
| `static native BoundingBox` | `getBounds(@NonNull LinearRing ring)`<br>Gets bounds based on a linear ring. |
| `static native BoundingBox` | `getBounds(@NonNull Polygon polygon)`<br>Gets bounds based on a polygon. |
| `static native BoundingBox` | `getBounds(@NonNull BoundingBox first, @NonNull BoundingBox second)`<br>Gets bounds based on two bounding boxes. |

## Constuctors

### BoundingBoxHelper

```java
BoundingBoxHelper()
```

## Methods

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull BoundingBox bbox)
```

Gets bounds based on a bounding box.

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull Point point)
```

Gets bounds based on a point.

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull Polyline polyline)
```

Gets bounds based on a polyline.

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull LinearRing ring)
```

Gets bounds based on a linear ring.

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull Polygon polygon)
```

Gets bounds based on a polygon.

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull BoundingBox first,
                      @NonNull BoundingBox second)
```

Gets bounds based on two bounding boxes.
