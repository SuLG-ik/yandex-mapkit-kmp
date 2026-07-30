---
title: "Projection"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry.geo"
section: "Android / Справочник / com.yandex.mapkit.geometry.geo / Projection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/Projection.html"
---
# Projection

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/Projection.html)

**Package** com.yandex.mapkit.geometry.geo

`interface Projection`

Makes two conversions: world->XY and XY->world, where XY are tile indexes.

There are two main derived classes: spherical mercator (google, osm) and wgs84 mercator (yandex).

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `XYPoint` | `worldToXY(@NonNull Point geoPoint, int zoom)`<br>Converts the world coordinates to a flat world position. |
| `Point` | `xyToWorld(@NonNull XYPoint xyPoint, int zoom)`<br>Converts the flat world position to world coordinates. |
| `boolean` | `isValid()`<br>Tells if this **Projection** is valid or not. |

## Methods

### worldToXY

```java
@NonNull
XYPoint worldToXY(@NonNull Point geoPoint,
                  int zoom)
```

Converts the world coordinates to a flat world position.

### xyToWorld

```java
@NonNull
Point xyToWorld(@NonNull XYPoint xyPoint,
                int zoom)
```

Converts the flat world position to world coordinates.

### isValid

```java
boolean isValid()
```

Tells if this **Projection** is valid or not.

Any other method (except for this one) called on an invalid **Projection** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
