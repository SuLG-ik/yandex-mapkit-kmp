---
title: "AngularBoundingBox"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / AngularBoundingBox"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/AngularBoundingBox.html"
---
# AngularBoundingBox

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/AngularBoundingBox.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.AngularBoundingBox

`class AngularBoundingBox implements Serializable`

Angular bbox.

Direction + span will be limited between top and bottom It's recommended to have (right - left) = 360.

## Summary

### Constructors

**Signature and Description**

```java
AngularBoundingBox(float left,
                   float top,
                   float right,
                   float bottom)
```

```java
AngularBoundingBox()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getLeft()` |
| `float` | `getTop()` |
| `float` | `getRight()` |
| `float` | `getBottom()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### AngularBoundingBox

```java
AngularBoundingBox(float left,
                   float top,
                   float right,
                   float bottom)
```

### AngularBoundingBox

```java
AngularBoundingBox()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getLeft

```java
float getLeft()
```

### getTop

```java
float getTop()
```

### getRight

```java
float getRight()
```

### getBottom

```java
float getBottom()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
