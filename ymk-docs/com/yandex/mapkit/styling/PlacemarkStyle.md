---
title: "PlacemarkStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.styling"
section: "Android / Справочник / com.yandex.mapkit.styling / PlacemarkStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/PlacemarkStyle.html"
---
# PlacemarkStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/styling/PlacemarkStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.styling

`interface PlacemarkStyle`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setArrowModel()`<br>Set the placemark to be an 3D arrow. |
| `void` | `setGltfModel(@NonNull DataProviderWithId model, @NonNull ModelStyle modelStyle)`<br>The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated. |
| `void` | `setImage(@NonNull ImageProvider image)` |
| `void` | `setAnimatedImage(@NonNull AnimatedImageProvider iconImage)` |
| `void` | `setIconAnchor(@NonNull android.graphics.PointF iconAnchor)`<br>Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right. |
| `void` | `setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)`<br>Piecewise linear scale function. |
| `void` | `setMinZoomVisible(@Nullable java.lang.Float minZoom)`<br>Minimal zoom for placemark to be visible. |
| `boolean` | `isValid()`<br>Tells if this **PlacemarkStyle** is valid or not. |

## Methods

### setArrowModel

```java
void setArrowModel()
```

Set the placemark to be an 3D arrow.

Usable only for user position placemark.

### setGltfModel

```java
void setGltfModel(@NonNull DataProviderWithId model,
                  @NonNull ModelStyle modelStyle)
```

The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated.

### setImage

```java
void setImage(@NonNull ImageProvider image)
```

### setAnimatedImage

```java
void setAnimatedImage(@NonNull AnimatedImageProvider iconImage)
```

### setIconAnchor

```java
void setIconAnchor(@NonNull android.graphics.PointF iconAnchor)
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### setScaleFunction

```java
void setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)
```

Piecewise linear scale function.

See Placemark's scale function.

### setMinZoomVisible

```java
void setMinZoomVisible(@Nullable java.lang.Float minZoom)
```

Minimal zoom for placemark to be visible.

### isValid

```java
boolean isValid()
```

Tells if this **PlacemarkStyle** is valid or not.

Any other method (except for this one) called on an invalid **PlacemarkStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
