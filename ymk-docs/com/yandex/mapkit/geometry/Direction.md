---
title: "Direction"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Direction"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Direction.html"
---
# Direction

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Direction.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Direction

`class Direction implements Serializable`

Represents the panorama direction.

## Summary

### Constructors

**Signature and Description**

```java
Direction(double azimuth,
          double tilt)
```

```java
Direction()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getAzimuth()`<br>Panorama azimuth. |
| `double` | `getTilt()`<br>Panorama tilt. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Direction

```java
Direction(double azimuth,
          double tilt)
```

### Direction

```java
Direction()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAzimuth

```java
double getAzimuth()
```

Panorama azimuth.

### getTilt

```java
double getTilt()
```

Panorama tilt.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
