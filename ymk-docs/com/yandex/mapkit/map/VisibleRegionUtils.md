---
title: "VisibleRegionUtils"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / VisibleRegionUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/VisibleRegionUtils.html"
---
# VisibleRegionUtils

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/VisibleRegionUtils.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.VisibleRegionUtils

`class VisibleRegionUtils`

## Summary

### Constructors

**Signature and Description**

```java
VisibleRegionUtils()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native Geometry` | `toPolygon(@NonNull VisibleRegion visibleRegion)`<br>Converts visible region to polygon geometry |
| `static native BoundingBox` | `getBounds(@NonNull VisibleRegion visibleRegion)` |

## Constuctors

### VisibleRegionUtils

```java
VisibleRegionUtils()
```

## Methods

### toPolygon

```java
@NonNull
Geometry toPolygon(@NonNull VisibleRegion visibleRegion)
```

Converts visible region to polygon geometry

### getBounds

```java
@NonNull
BoundingBox getBounds(@NonNull VisibleRegion visibleRegion)
```

**Returns**

BoundingBox for provided [mapkit.map.VisibleRegion](VisibleRegion.md)
