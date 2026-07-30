---
title: "Rect"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Rect"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Rect.html"
---
# Rect

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Rect.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.Rect

`class Rect implements Serializable`

The rectangle to display on the map.

## Summary

### Constructors

**Signature and Description**

```java
Rect(@NonNull android.graphics.PointF min,
     @NonNull android.graphics.PointF max)
```

```java
Rect()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `android.graphics.PointF` | `getMin()`<br>Minimum rectangle coordinates. |
| `android.graphics.PointF` | `getMax()`<br>Maximum rectangle coordinates. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Rect

```java
Rect(@NonNull android.graphics.PointF min,
     @NonNull android.graphics.PointF max)
```

### Rect

```java
Rect()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getMin

```java
@NonNull
android.graphics.PointF getMin()
```

Minimum rectangle coordinates.

### getMax

```java
@NonNull
android.graphics.PointF getMax()
```

Maximum rectangle coordinates.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
