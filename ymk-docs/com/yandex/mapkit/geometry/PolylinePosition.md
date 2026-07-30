---
title: "PolylinePosition"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / PolylinePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/PolylinePosition.html"
---
# PolylinePosition

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/PolylinePosition.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.PolylinePosition

`class PolylinePosition implements Serializable`

The position on a polyline.

## Summary

### Constructors

**Signature and Description**

```java
PolylinePosition(int segmentIndex,
                 double segmentPosition)
```

```java
PolylinePosition()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getSegmentIndex()`<br>Zero-based index of the polyline segment. |
| `double` | `getSegmentPosition()`<br>Position in the specified segment. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### PolylinePosition

```java
PolylinePosition(int segmentIndex,
                 double segmentPosition)
```

### PolylinePosition

```java
PolylinePosition()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSegmentIndex

```java
int getSegmentIndex()
```

Zero-based index of the polyline segment.

### getSegmentPosition

```java
double getSegmentPosition()
```

Position in the specified segment.

Possible values: from 0 to 1, where 0 is the start of the segment and 1 is the end of it.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
