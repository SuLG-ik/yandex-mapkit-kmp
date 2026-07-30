---
title: "PolylineBuilder"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / PolylineBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/PolylineBuilder.html"
---
# PolylineBuilder

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/PolylineBuilder.html)

**Package** com.yandex.mapkit.geometry

`interface PolylineBuilder`

A builder class for polyline elements.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `append(@NonNull Polyline polyline)`<br>Appends a polyline. |
| `void` | `append(@NonNull Point point)`<br>Appends a point. |
| `Polyline` | `build()`<br>Builds a polyline. |

## Methods

### append

```java
void append(@NonNull Polyline polyline)
```

Appends a polyline.

### append

```java
void append(@NonNull Point point)
```

Appends a point.

### build

```java
@NonNull
Polyline build()
```

Builds a polyline.
