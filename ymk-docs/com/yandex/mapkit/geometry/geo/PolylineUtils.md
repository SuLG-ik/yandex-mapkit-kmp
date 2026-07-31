---
title: "PolylineUtils"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry.geo"
section: "Android / Справочник / com.yandex.mapkit.geometry.geo / PolylineUtils"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/PolylineUtils.html"
---
# PolylineUtils

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/geo/PolylineUtils.html)

**Package** com.yandex.mapkit.geometry.geo

java.lang.Object
↳ com.yandex.mapkit.geometry.geo.PolylineUtils

`class PolylineUtils`

## Summary

### Constructors

**Signature and Description**

```java
PolylineUtils()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native java.util.List<PolylinePosition>` | `positionsOfFork(@NonNull Polyline firstPolyline, @NonNull PolylinePosition firstPolylinePosition, @NonNull Polyline secondPolyline, @NonNull PolylinePosition secondPolylinePosition)`<br>The position of the fork on the road. |
| `static native PolylinePosition` | `advancePolylinePosition(@NonNull Polyline polyline, @NonNull PolylinePosition position, double distance)`<br>Advance the polyline position by a specified distance in meters. |
| `static native Point` | `pointByPolylinePosition(@NonNull Polyline geometry, @NonNull PolylinePosition position)`<br>The point in the polyline. |
| `static native double` | `distanceBetweenPolylinePositions(@NonNull Polyline polyline, @NonNull PolylinePosition from, @NonNull PolylinePosition to)` |
| `static native PolylineIndex` | `createPolylineIndex(@NonNull Polyline polyline)`<br>Creates PolylineIndex for polyline. |

## Constuctors

### PolylineUtils

```java
PolylineUtils()
```

## Methods

### positionsOfFork

```java
@NonNull
java.util.List<PolylinePosition> positionsOfFork(@NonNull Polyline firstPolyline,
                                                 @NonNull PolylinePosition firstPolylinePosition,
                                                 @NonNull Polyline secondPolyline,
                                                 @NonNull PolylinePosition secondPolylinePosition)
```

The position of the fork on the road.

| Parameters |   |
| --- | --- |
| `firstPolyline` | The first path of the fork. |
| `firstPolylinePosition` | The position of the first path. |
| `secondPolyline` | The second path of the fork. |
| `secondPolylinePosition` | The position of the second path. |

### advancePolylinePosition

```java
@NonNull
PolylinePosition advancePolylinePosition(@NonNull Polyline polyline,
                                         @NonNull PolylinePosition position,
                                         double distance)
```

Advance the polyline position by a specified distance in meters.

| Parameters |   |
| --- | --- |
| `polyline` | The polyline. |
| `position` | The polyline position. |
| `distance` | Distance. |

### pointByPolylinePosition

```java
@NonNull
Point pointByPolylinePosition(@NonNull Polyline geometry,
                              @NonNull PolylinePosition position)
```

The point in the polyline.

| Parameters |   |
| --- | --- |
| `geometry` | The polyline. |
| `position` | The polyline position. |

### distanceBetweenPolylinePositions

```java
double distanceBetweenPolylinePositions(@NonNull Polyline polyline,
                                        @NonNull PolylinePosition from,
                                        @NonNull PolylinePosition to)
```

### createPolylineIndex

```java
@NonNull
PolylineIndex createPolylineIndex(@NonNull Polyline polyline)
```

Creates PolylineIndex for polyline.

See [mapkit.geometry.geo.PolylineIndex](PolylineIndex.md) for details.
