---
title: "BoundingBox"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / BoundingBox"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/BoundingBox.html"
---
# BoundingBox

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/BoundingBox.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.BoundingBox

`class BoundingBox implements Serializable`

A rectangular box around the object.

## Summary

### Constructors

**Signature and Description**

```java
BoundingBox(@NonNull Point southWest,
            @NonNull Point northEast)
```

```java
BoundingBox()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getSouthWest()`<br>The coordinates of the southwest corner of the box. |
| `Point` | `getNorthEast()`<br>The coordinates of the northeast corner of the box. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### BoundingBox

```java
BoundingBox(@NonNull Point southWest,
            @NonNull Point northEast)
```

### BoundingBox

```java
BoundingBox()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSouthWest

```java
@NonNull
Point getSouthWest()
```

The coordinates of the southwest corner of the box.

### getNorthEast

```java
@NonNull
Point getNorthEast()
```

The coordinates of the northeast corner of the box.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
