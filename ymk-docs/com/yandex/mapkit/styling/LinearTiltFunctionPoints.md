---
title: "LinearTiltFunctionPoints"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / LinearTiltFunctionPoints"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/LinearTiltFunctionPoints.html"
---
# LinearTiltFunctionPoints

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/LinearTiltFunctionPoints.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

java.lang.Object
↳ com.yandex.mapkit.styling.LinearTiltFunctionPoints

`class LinearTiltFunctionPoints implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LinearTiltFunctionPoints()
```

Use constructor with parameters in your code.

```java
LinearTiltFunctionPoints(@NonNull java.util.List<android.graphics.PointF> points)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<android.graphics.PointF>` | `getPoints()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LinearTiltFunctionPoints

```java
LinearTiltFunctionPoints()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LinearTiltFunctionPoints

```java
LinearTiltFunctionPoints(@NonNull java.util.List<android.graphics.PointF> points)
```

## Methods

### getPoints

```java
@NonNull
java.util.List<android.graphics.PointF> getPoints()
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
