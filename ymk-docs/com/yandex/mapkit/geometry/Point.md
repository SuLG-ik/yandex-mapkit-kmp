---
title: "Point"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Point"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Point.html"
---
# Point

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Point.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Point

`class Point implements Serializable`

A point at the specified coordinates.

## Summary

### Constructors

**Signature and Description**

```java
Point(double latitude,
      double longitude)
```

```java
Point()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getLatitude()`<br>The point's latitude. |
| `double` | `getLongitude()`<br>The point's longitude. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Point

```java
Point(double latitude,
      double longitude)
```

### Point

```java
Point()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getLatitude

```java
double getLatitude()
```

The point's latitude.

### getLongitude

```java
double getLongitude()
```

The point's longitude.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
