---
title: "RoadEventStyle"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events_layer"
section: "Android / Справочник / com.yandex.mapkit.road_events_layer / RoadEventStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEventStyle.html"
---
# RoadEventStyle

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events_layer/RoadEventStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.road_events_layer

`interface RoadEventStyle`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getZoomMin()`<br>Road event is visible only if current camera zoom is greater or equal than this value. |
| `void` | `setZoomMin(int zoomMin)` |
| `void` | `setIconImage(@NonNull ImageProvider image)`<br>Road event icon image. |
| `android.graphics.PointF` | `getIconAnchor()`<br>Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right. |
| `void` | `setIconAnchor(@NonNull android.graphics.PointF iconAnchor)` |
| `java.util.List<android.graphics.PointF>` | `getZoomScaleFunction()`<br>Piecewise linear scale function. |
| `void` | `setZoomScaleFunction(@NonNull java.util.List<android.graphics.PointF> zoomScaleFunction)` |
| `TextStyle` | `getCaptionStyle()`<br>Style of caption displayed under the road event icon. |
| `void` | `setCaptionStyle(@Nullable TextStyle captionStyle)` |
| `boolean` | `isValid()`<br>Tells if this **RoadEventStyle** is valid or not. |

## Methods

### getZoomMin

```java
int getZoomMin()
```

Road event is visible only if current camera zoom is greater or equal than this value.

### setZoomMin

```java
void setZoomMin(int zoomMin)
```

### setIconImage

```java
void setIconImage(@NonNull ImageProvider image)
```

Road event icon image.

### getIconAnchor

```java
@NonNull
android.graphics.PointF getIconAnchor()
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### setIconAnchor

```java
void setIconAnchor(@NonNull android.graphics.PointF iconAnchor)
```

### getZoomScaleFunction

```java
@NonNull
java.util.List<android.graphics.PointF> getZoomScaleFunction()
```

Piecewise linear scale function.

See Placemark's scale function.

### setZoomScaleFunction

```java
void setZoomScaleFunction(@NonNull java.util.List<android.graphics.PointF> zoomScaleFunction)
```

### getCaptionStyle

```java
@Nullable
TextStyle getCaptionStyle()
```

Style of caption displayed under the road event icon.

Optional property, can be null.

### setCaptionStyle

```java
void setCaptionStyle(@Nullable TextStyle captionStyle)
```

### isValid

```java
boolean isValid()
```

Tells if this **RoadEventStyle** is valid or not.

Any other method (except for this one) called on an invalid **RoadEventStyle** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
