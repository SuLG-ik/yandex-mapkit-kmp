---
title: "CameraPosition"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CameraPosition"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraPosition.html"
---
# CameraPosition

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraPosition.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.CameraPosition

`class CameraPosition implements Serializable`

The position of the camera.

## Summary

### Constructors

**Signature and Description**

```java
CameraPosition(@NonNull Point target,
               float zoom,
               float azimuth,
               float tilt)
```

```java
CameraPosition()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getTarget()`<br>The point the camera is looking at. |
| `float` | `getZoom()`<br>Zoom level. |
| `float` | `getAzimuth()`<br>Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360). |
| `float` | `getTilt()`<br>Camera tilt in degrees. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### CameraPosition

```java
CameraPosition(@NonNull Point target,
               float zoom,
               float azimuth,
               float tilt)
```

### CameraPosition

```java
CameraPosition()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTarget

```java
@NonNull
Point getTarget()
```

The point the camera is looking at.

### getZoom

```java
float getZoom()
```

Zoom level.

0 corresponds to the whole world displayed in a single tile.

### getAzimuth

```java
float getAzimuth()
```

Angle between north and the direction of interest on the map plane, in degrees in the range [0, 360).

### getTilt

```java
float getTilt()
```

Camera tilt in degrees.

0 means vertical downward.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
