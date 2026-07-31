---
title: "Segment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Segment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Segment.html"
---
# Segment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Segment.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Segment

`class Segment implements Serializable`

A line between two points.

## Summary

### Constructors

**Signature and Description**

```java
Segment(@NonNull Point startPoint,
        @NonNull Point endPoint)
```

```java
Segment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getStartPoint()`<br>Starting point of the segment. |
| `Point` | `getEndPoint()`<br>End point of the segment. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Segment

```java
Segment(@NonNull Point startPoint,
        @NonNull Point endPoint)
```

### Segment

```java
Segment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getStartPoint

```java
@NonNull
Point getStartPoint()
```

Starting point of the segment.

### getEndPoint

```java
@NonNull
Point getEndPoint()
```

End point of the segment.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
