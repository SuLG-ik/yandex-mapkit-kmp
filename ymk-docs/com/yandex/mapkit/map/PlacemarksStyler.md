---
title: "PlacemarksStyler"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / PlacemarksStyler"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarksStyler.html"
---
# PlacemarksStyler

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/PlacemarksStyler.html)

**Package** com.yandex.mapkit.map

`interface PlacemarksStyler`

Represents a styler for all placemarks in the map object collection, including placemarks in child collections.

When a new placemark is added to a collection, the placemark tries to get style properties from the collection where it has been added. If this collection doesn't have a style property, the placemark tries to get it from the closest parent collection. If none of these collections have a specific style property, the placemark sets the default value for this property.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)`<br>Sets piecewise linear scale, depending on the zoom. |
| `boolean` | `isValid()`<br>Tells if this **PlacemarksStyler** is valid or not. |

## Methods

### setScaleFunction

```java
void setScaleFunction(@NonNull java.util.List<android.graphics.PointF> points)
```

Sets piecewise linear scale, depending on the zoom.

The 'points' must be sorted by x; x coordinates must be unique. If zoom  minZoom(points) or zoom > maxZoom(points), it is set within the defined bounds before applying the function. By default, the scale function is defined by a single point (1, 1). If points is null or points.empty(), it resets the function to the default. If points.size() == 1, the scale is constant and equals point.y.

### isValid

```java
boolean isValid()
```

Tells if this **PlacemarksStyler** is valid or not.

Any other method (except for this one) called on an invalid **PlacemarksStyler** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
