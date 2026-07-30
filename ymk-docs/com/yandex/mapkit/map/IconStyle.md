---
title: "IconStyle"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / IconStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/IconStyle.html"
---
# IconStyle

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/IconStyle.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.IconStyle

`final class IconStyle implements Serializable`

The style of created icons.

## Summary

### Constructors

**Signature and Description**

```java
IconStyle(@Nullable android.graphics.PointF anchor,
          @Nullable RotationType rotationType,
          @Nullable java.lang.Float zIndex,
          @Nullable java.lang.Boolean flat,
          @Nullable java.lang.Boolean visible,
          @Nullable java.lang.Float scale,
          float opacity,
          @Nullable Rect tappableArea)
```

```java
IconStyle()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `android.graphics.PointF` | `getAnchor()`<br>An anchor is used to alter image placement. |
| `IconStyle` | `setAnchor(@Nullable android.graphics.PointF anchor)`<br>See **#getAnchor()**. |
| `RotationType` | `getRotationType()`<br>Icon rotation type. |
| `IconStyle` | `setRotationType(@Nullable RotationType rotationType)`<br>See **#getRotationType()**. |
| `java.lang.Float` | `getZIndex()`<br>Z-index of the icon, relative to the placemark's z-index. |
| `IconStyle` | `setZIndex(@Nullable java.lang.Float zIndex)`<br>See **#getZIndex()**. |
| `java.lang.Boolean` | `getFlat()`<br>If true, the icon is displayed on the map surface. |
| `IconStyle` | `setFlat(@Nullable java.lang.Boolean flat)`<br>See **#getFlat()**. |
| `java.lang.Boolean` | `getVisible()`<br>Sets icon visibility. |
| `IconStyle` | `setVisible(@Nullable java.lang.Boolean visible)`<br>See **#getVisible()**. |
| `java.lang.Float` | `getScale()`<br>Scale of the icon. |
| `IconStyle` | `setScale(@Nullable java.lang.Float scale)`<br>See **#getScale()**. |
| `float` | `getOpacity()`<br>Opacity of the icon |
| `IconStyle` | `setOpacity(float opacity)`<br>See **#getOpacity()**. |
| `Rect` | `getTappableArea()`<br>Tappable area on the icon. |
| `IconStyle` | `setTappableArea(@Nullable Rect tappableArea)`<br>See **#getTappableArea()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### IconStyle

```java
IconStyle(@Nullable android.graphics.PointF anchor,
          @Nullable RotationType rotationType,
          @Nullable java.lang.Float zIndex,
          @Nullable java.lang.Boolean flat,
          @Nullable java.lang.Boolean visible,
          @Nullable java.lang.Float scale,
          float opacity,
          @Nullable Rect tappableArea)
```

### IconStyle

```java
IconStyle()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAnchor

```java
@Nullable
android.graphics.PointF getAnchor()
```

An anchor is used to alter image placement.

Normalized: (0.0f, 0.0f) denotes the top left image corner; (1.0f, 1.0f) denotes bottom right. Default is (0.5f, 0.5f).

Optional field, can be null.

### setAnchor

```java
IconStyle setAnchor(@Nullable android.graphics.PointF anchor)
```

See **#getAnchor()**.

### getRotationType

```java
@Nullable
RotationType getRotationType()
```

Icon rotation type.

Default: NoRotation.

Optional field, can be null.

### setRotationType

```java
IconStyle setRotationType(@Nullable RotationType rotationType)
```

See **#getRotationType()**.

### getZIndex

```java
@Nullable
java.lang.Float getZIndex()
```

Z-index of the icon, relative to the placemark's z-index.

Optional field, can be null.

### setZIndex

```java
IconStyle setZIndex(@Nullable java.lang.Float zIndex)
```

See **#getZIndex()**.

### getFlat

```java
@Nullable
java.lang.Boolean getFlat()
```

If true, the icon is displayed on the map surface.

If false, the icon is displayed on the screen surface. Default: false.

Optional field, can be null.

### setFlat

```java
IconStyle setFlat(@Nullable java.lang.Boolean flat)
```

See **#getFlat()**.

### getVisible

```java
@Nullable
java.lang.Boolean getVisible()
```

Sets icon visibility.

Default: true.

Optional field, can be null.

### setVisible

```java
IconStyle setVisible(@Nullable java.lang.Boolean visible)
```

See **#getVisible()**.

### getScale

```java
@Nullable
java.lang.Float getScale()
```

Scale of the icon.

Default: 1.0f.

Optional field, can be null.

### setScale

```java
IconStyle setScale(@Nullable java.lang.Float scale)
```

See **#getScale()**.

### getOpacity

```java
float getOpacity()
```

Opacity of the icon

### setOpacity

```java
IconStyle setOpacity(float opacity)
```

See **#getOpacity()**.

### getTappableArea

```java
@Nullable
Rect getTappableArea()
```

Tappable area on the icon.

Coordinates are measured the same way as anchor coordinates. If rect is empty or invalid, the icon will not process taps. By default, icons process all taps.

Optional field, can be null.

### setTappableArea

```java
IconStyle setTappableArea(@Nullable Rect tappableArea)
```

See **#getTappableArea()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
