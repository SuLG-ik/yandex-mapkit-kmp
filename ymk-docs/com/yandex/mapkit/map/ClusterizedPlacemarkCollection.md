---
title: "ClusterizedPlacemarkCollection"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / ClusterizedPlacemarkCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterizedPlacemarkCollection.html"
---
# ClusterizedPlacemarkCollection

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/ClusterizedPlacemarkCollection.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[BaseMapObjectCollection](BaseMapObjectCollection.md)*, *[MapObject](MapObject.md)*

`interface ClusterizedPlacemarkCollection extends BaseMapObjectCollection`

A collection that displays large groups of placemarks efficiently.

Placemarks that are too close to each other with current zoom are rendered as a single cluster. Placemarks and clusters are not shown until clusterPlacemarks method is called explicitly.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PlacemarkMapObject` | `addPlacemark()`<br>Creates a new empty placemark and adds it to the current collection. |
| `PlacemarkMapObject` | `addPlacemark(@NonNull PlacemarkCreatedCallback placemarkCreatedCallback)`<br>Creates a new empty placemark and adds it to the current collection. |
| `PlacemarkMapObject` | `addEmptyPlacemark(@NonNull Point point)` |
| `java.util.List<PlacemarkMapObject>` | `addEmptyPlacemarks(@NonNull java.util.List<Point> points)`<br>Creates new empty placemarks and adds them to the current collection. |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ImageProvider image)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ImageProvider image, @NonNull IconStyle style)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ViewProvider view)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ViewProvider view, @NonNull IconStyle style)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull AnimatedImageProvider animatedImage, @NonNull IconStyle style)` |
| `java.util.List<PlacemarkMapObject>` | `addPlacemarks(@NonNull java.util.List<Point> points, @NonNull ImageProvider image, @NonNull IconStyle style)`<br>Creates new placemarks and adds them to the current collection. |
| `void` | `clusterPlacemarks(double clusterRadius, int minZoom)`<br>Updates clustered representations of placemark groups. |

## Methods

### addPlacemark

```java
@NonNull
PlacemarkMapObject addPlacemark()
```

Creates a new empty placemark and adds it to the current collection.

### addPlacemark

```java
@NonNull
PlacemarkMapObject addPlacemark(@NonNull PlacemarkCreatedCallback placemarkCreatedCallback)
```

Creates a new empty placemark and adds it to the current collection.

Callback can be used to setup placemark style and position Callback will be called before MapObjectCollectionListener#onMapObjectAdded

### addEmptyPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addEmptyPlacemark(@NonNull Point point)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) Creates a new empty placemark and adds it to the current collection. Hint: to add a large amount of empty placemarks use addEmptyPlacemarks method.

### addEmptyPlacemarks

```java
@NonNull
java.util.List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull java.util.List<Point> points)
```

Creates new empty placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(your_own_blue_dot_icon). Default icon (also known as blue dot) is no longer provided. Creates a new placemark with the default icon and style, and adds it to the current collection.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point,
                                @NonNull ImageProvider image)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image) Creates a new placemark with the default style and adds it to the current collection.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point,
                                @NonNull ImageProvider image,
                                @NonNull IconStyle style)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setIcon(image, style) Creates a new placemark and adds it to the current collection. Hint: to add a large amount of placemarks use addPlacemarks method.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point,
                                @NonNull ViewProvider view)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view) Creates a new view placemark with default style and adds it to the current collection.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point,
                                @NonNull ViewProvider view,
                                @NonNull IconStyle style)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + setView(view, style) Creates a new view placemark and adds it to the current collection.

### addPlacemark

```java
@Deprecated @NonNull
PlacemarkMapObject addPlacemark(@NonNull Point point,
                                @NonNull AnimatedImageProvider animatedImage,
                                @NonNull IconStyle style)
```

> [!CAUTION] Внимание
> Use addPlacemark() + setGeometry(point) + useAnimation() + setIcon(animatedImage, style) Creates a new placemark with animated icon and adds it to the current collection.

### addPlacemarks

```java
@NonNull
java.util.List<PlacemarkMapObject> addPlacemarks(@NonNull java.util.List<Point> points,
                                                 @NonNull ImageProvider image,
                                                 @NonNull IconStyle style)
```

Creates new placemarks and adds them to the current collection.

Relevant for Android: this method provides better performance for adding a large number of placemarks than multiple calls of addPlacemark.

### clusterPlacemarks

```java
void clusterPlacemarks(double clusterRadius,
                       int minZoom)
```

Updates clustered representations of placemark groups.

This method must be called explicitly to render placemarks and clusters when collection is created and update them after collection change.

| Parameters |   |
| --- | --- |
| `clusterRadius` | Minimal distance in units between objects that remain separate. The size of the unit is equal to the size of a pixel when the camera position's tilt is equal to 0 and the scale factor is equal to 1. |
| `minZoom` | Minimal zoom level that displays clusters. All placemarks will be rendered separately at more detailed zoom levels. The value will be clipped between 0 and 19 (most detailed zoom). |
