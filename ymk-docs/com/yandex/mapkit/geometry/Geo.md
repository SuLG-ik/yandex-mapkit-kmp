---
title: "Geo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Geo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Geo.html"
---
# Geo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Geo.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Geo

`class Geo`

## Summary

### Constructors

**Signature and Description**

```java
Geo()
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static native double` | `distance(@NonNull Point firstPoint, @NonNull Point secondPoint)`<br>Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en.wikipedia.org/wiki/Haversine_formula<br>This formula is numerically better-conditioned for small distances, according to http://en.wikipedia.org/wiki/Great-circle_distance |
| `static native Point` | `closestPoint(@NonNull Point point, @NonNull Segment segment)`<br>Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point. |
| `static native Point` | `pointOnSegmentByFactor(@NonNull Segment segment, double factor)`<br>Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1]. |
| `static native double` | `course(@NonNull Point firstPoint, @NonNull Point secondPoint)`<br>Calculate the course (bearing) between two points in degrees in the range [0, 360]. |

## Constuctors

### Geo

```java
Geo()
```

## Methods

### distance

```java
double distance(@NonNull Point firstPoint,
                @NonNull Point secondPoint)
```

Calculate the great-circle distance between two points on a sphere with a radius equal to the Earth's radius using the haversine formula described here: http://en.wikipedia.org/wiki/Haversine_formula

This formula is numerically better-conditioned for small distances, according to http://en.wikipedia.org/wiki/Great-circle_distance

### closestPoint

```java
@NonNull
Point closestPoint(@NonNull Point point,
                   @NonNull Segment segment)
```

Find the point on a given segment (great-circle arc or shorter arc) that is closest to a given point.

### pointOnSegmentByFactor

```java
@NonNull
Point pointOnSegmentByFactor(@NonNull Segment segment,
                             double factor)
```

Find a point X on a given segment AB such that d(AX)/d(AB) = factor, where factor is a given number in [0, 1].

### course

```java
double course(@NonNull Point firstPoint,
              @NonNull Point secondPoint)
```

Calculate the course (bearing) between two points in degrees in the range [0, 360].
