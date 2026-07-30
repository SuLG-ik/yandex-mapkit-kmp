---
title: "BalloonGeometry"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.balloons"
section: "Android / Справочник / com.yandex.mapkit.navigation.balloons / BalloonGeometry"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/balloons/BalloonGeometry.html"
---
# BalloonGeometry

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/balloons/BalloonGeometry.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.balloons

java.lang.Object
↳ com.yandex.mapkit.navigation.balloons.BalloonGeometry

`class BalloonGeometry implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
BalloonGeometry(@NonNull BalloonAnchor anchor,
                float width,
                float height,
                @NonNull android.graphics.PointF imageAnchor,
                @NonNull Rect contentRect,
                @NonNull Rect balloonRect)
```

```java
BalloonGeometry()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `BalloonAnchor` | `getAnchor()` |
| `float` | `getWidth()`<br>Total balloon image size |
| `float` | `getHeight()` |
| `android.graphics.PointF` | `getImageAnchor()`<br>Anchor inside image rect. |
| `Rect` | `getContentRect()`<br>area with main information, except leg/borders |
| `Rect` | `getBalloonRect()`<br>area with balloon, except leg, shadows, etc. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### BalloonGeometry

```java
BalloonGeometry(@NonNull BalloonAnchor anchor,
                float width,
                float height,
                @NonNull android.graphics.PointF imageAnchor,
                @NonNull Rect contentRect,
                @NonNull Rect balloonRect)
```

### BalloonGeometry

```java
BalloonGeometry()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAnchor

```java
@NonNull
BalloonAnchor getAnchor()
```

### getWidth

```java
float getWidth()
```

Total balloon image size

### getHeight

```java
float getHeight()
```

### getImageAnchor

```java
@NonNull
android.graphics.PointF getImageAnchor()
```

Anchor inside image rect.

Coordinates from 0 to 1 are inside the image.

### getContentRect

```java
@NonNull
Rect getContentRect()
```

area with main information, except leg/borders

### getBalloonRect

```java
@NonNull
Rect getBalloonRect()
```

area with balloon, except leg, shadows, etc.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
