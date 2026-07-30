---
title: "Subpolyline"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Subpolyline"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Subpolyline.html"
---
# Subpolyline

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Subpolyline.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Subpolyline

`class Subpolyline implements Serializable`

A part of a polyline.

## Summary

### Constructors

**Signature and Description**

```java
Subpolyline(@NonNull PolylinePosition begin,
            @NonNull PolylinePosition end)
```

```java
Subpolyline()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getBegin()`<br>The start of the selected part of the polyline. |
| `PolylinePosition` | `getEnd()`<br>The end of the selected part of the polyline. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Subpolyline

```java
Subpolyline(@NonNull PolylinePosition begin,
            @NonNull PolylinePosition end)
```

### Subpolyline

```java
Subpolyline()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getBegin

```java
@NonNull
PolylinePosition getBegin()
```

The start of the selected part of the polyline.

### getEnd

```java
@NonNull
PolylinePosition getEnd()
```

The end of the selected part of the polyline.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
