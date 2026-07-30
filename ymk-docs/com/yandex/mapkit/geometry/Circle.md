---
title: "Circle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Circle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Circle.html"
---
# Circle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Circle.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Circle

`class Circle implements Serializable`

A circle around the specified point.

## Summary

### Constructors

**Signature and Description**

```java
Circle(@NonNull Point center,
       float radius)
```

```java
Circle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getCenter()`<br>The coordinates of the center of the circle. |
| `float` | `getRadius()`<br>The radius of the circle in meters. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Circle

```java
Circle(@NonNull Point center,
       float radius)
```

### Circle

```java
Circle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getCenter

```java
@NonNull
Point getCenter()
```

The coordinates of the center of the circle.

### getRadius

```java
float getRadius()
```

The radius of the circle in meters.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
