---
title: "LinearZoomFunctionPoints"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / LinearZoomFunctionPoints"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/LinearZoomFunctionPoints.html"
---
# LinearZoomFunctionPoints

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/LinearZoomFunctionPoints.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

java.lang.Object
↳ com.yandex.mapkit.styling.LinearZoomFunctionPoints

`class LinearZoomFunctionPoints implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LinearZoomFunctionPoints()
```

Use constructor with parameters in your code.

```java
LinearZoomFunctionPoints(@NonNull java.util.List<android.graphics.PointF> points)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<android.graphics.PointF>` | `getPoints()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LinearZoomFunctionPoints

```java
LinearZoomFunctionPoints()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LinearZoomFunctionPoints

```java
LinearZoomFunctionPoints(@NonNull java.util.List<android.graphics.PointF> points)
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
