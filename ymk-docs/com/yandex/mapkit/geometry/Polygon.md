---
title: "Polygon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Polygon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Polygon.html"
---
# Polygon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Polygon.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Polygon

`class Polygon implements Serializable`

A polygon with one or more polygons in it.

The exterior and interior areas are specified using LinearRing.

## Summary

### Constructors

**Signature and Description**

```java
Polygon()
```

Use constructor with parameters in your code.

```java
Polygon(@NonNull LinearRing outerRing,
        @NonNull java.util.List<LinearRing> innerRings)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized LinearRing` | `getOuterRing()`<br>The ring specifying the area. |
| `synchronized java.util.List<LinearRing>` | `getInnerRings()`<br>The list of rings in the specified area. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Polygon

```java
Polygon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Polygon

```java
Polygon(@NonNull LinearRing outerRing,
        @NonNull java.util.List<LinearRing> innerRings)
```

## Methods

### getOuterRing

```java
@NonNull
LinearRing getOuterRing()
```

The ring specifying the area.

### getInnerRings

```java
@NonNull
java.util.List<LinearRing> getInnerRings()
```

The list of rings in the specified area.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
