---
title: "MultiPolygon"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / MultiPolygon"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/MultiPolygon.html"
---
# MultiPolygon

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/MultiPolygon.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.MultiPolygon

`class MultiPolygon implements Serializable`

An area consisting of multiple external polygons.

## Summary

### Constructors

**Signature and Description**

```java
MultiPolygon()
```

Use constructor with parameters in your code.

```java
MultiPolygon(@NonNull java.util.List<Polygon> polygons)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Polygon>` | `getPolygons()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### MultiPolygon

```java
MultiPolygon()
```

Use constructor with parameters in your code.

This one is for serialization only!

### MultiPolygon

```java
MultiPolygon(@NonNull java.util.List<Polygon> polygons)
```

## Methods

### getPolygons

```java
@NonNull
java.util.List<Polygon> getPolygons()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
