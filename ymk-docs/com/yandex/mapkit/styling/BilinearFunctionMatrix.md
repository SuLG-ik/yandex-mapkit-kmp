---
title: "BilinearFunctionMatrix"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / BilinearFunctionMatrix"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/BilinearFunctionMatrix.html"
---
# BilinearFunctionMatrix

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/BilinearFunctionMatrix.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

java.lang.Object
↳ com.yandex.mapkit.styling.BilinearFunctionMatrix

`class BilinearFunctionMatrix implements Serializable`

defines function `func(zoom, tilt)` as `func(zooms[x], tilts[y]) == points[x][y]` for all x in [0, zooms.size()), y in [0, tilts.size()) https://en.wikipedia.org/wiki/Bilinear_interpolation

## Summary

### Constructors

**Signature and Description**

```java
BilinearFunctionMatrix()
```

Use constructor with parameters in your code.

```java
BilinearFunctionMatrix(@NonNull java.util.List<java.lang.Float> zooms,
                       @NonNull java.util.List<java.lang.Float> tilts,
                       @NonNull java.util.List<java.util.List<java.lang.Float>> points)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.Float>` | `getZooms()` |
| `synchronized java.util.List<java.lang.Float>` | `getTilts()` |
| `synchronized java.util.List<java.util.List<java.lang.Float>>` | `getPoints()`<br>requires: points.size() == zooms.size() subpoints.size() == tilts.size() for all subpoints in points |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BilinearFunctionMatrix

```java
BilinearFunctionMatrix()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BilinearFunctionMatrix

```java
BilinearFunctionMatrix(@NonNull java.util.List<java.lang.Float> zooms,
                       @NonNull java.util.List<java.lang.Float> tilts,
                       @NonNull java.util.List<java.util.List<java.lang.Float>> points)
```

## Methods

### getZooms

```java
@NonNull
java.util.List<java.lang.Float> getZooms()
```

### getTilts

```java
@NonNull
java.util.List<java.lang.Float> getTilts()
```

### getPoints

```java
@NonNull
java.util.List<java.util.List<java.lang.Float>> getPoints()
```

requires: points.size() == zooms.size() subpoints.size() == tilts.size() for all subpoints in points

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
