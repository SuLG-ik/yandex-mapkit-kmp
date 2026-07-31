---
title: "MapObjectCollection"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectCollection.html"
---
# MapObjectCollection

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectCollection.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[BaseMapObjectCollection](BaseMapObjectCollection.md)*, *[MapObject](MapObject.md)*

## All known Subinterfaces:

*[RootMapObjectCollection](RootMapObjectCollection.md)*

`interface MapObjectCollection extends BaseMapObjectCollection`

A collection of map objects that can hold any set of MapObject items, including nested collections.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PlacemarkMapObject` | `addPlacemark()`<br>Creates a new empty placemark and adds it to the current collection. |
| `PlacemarkMapObject` | `addPlacemark(@NonNull PlacemarkCreatedCallback placemarkCreatedCallback)`<br>Creates a new empty placemark and adds it to the current collection. |
| `PlacemarkMapObject` | `addEmptyPlacemark(@NonNull Point point)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ImageProvider image)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ImageProvider image, @NonNull IconStyle style)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ViewProvider view)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull ViewProvider view, @NonNull IconStyle style)` |
| `PlacemarkMapObject` | `addPlacemark(@NonNull Point point, @NonNull AnimatedImageProvider animatedImage, @NonNull IconStyle style)` |
| `java.util.List<PlacemarkMapObject>` | `addPlacemarks(@NonNull java.util.List<Point> points, @NonNull ImageProvider image, @NonNull IconStyle style)` |
| `java.util.List<PlacemarkMapObject>` | `addEmptyPlacemarks(@NonNull java.util.List<Point> points)` |
| `PolylineMapObject` | `addPolyline(@NonNull Polyline polyline)`<br>Creates a new polyline and adds it to the current collection. |
| `PolylineMapObject` | `addPolyline()`<br>Creates a new polyline with an empty geometry and adds it to the current collection. |
| `PolygonMapObject` | `addPolygon(@NonNull Polygon polygon)`<br>Creates a new polygon and adds it to the current collection. |
| `CircleMapObject` | `addCircle(@NonNull Circle circle)`<br>Creates a new circle and adds it to the current collection. |
| `MapObjectCollection` | `addCollection()`<br>Creates a new nested collection of map objects. |
| `ClusterizedPlacemarkCollection` | `addClusterizedPlacemarkCollection(@NonNull java.lang.ref.WeakReference<ClusterListener> clusterListener)`<br>Creates a new nested collection of clusterized placemarks. |
| `PlacemarksStyler` | `placemarksStyler()`<br>A styler for all placemarks in this collection, including placemarks in child collections. |

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
> Use addPlacemark() + setGeometry(point) Creates a new empty placemark and adds it to the current collection.

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
> Use addPlacemark() + setGeometry(point) + setIcon(image, style) Creates a new placemark with the default style and adds it to the current collection.

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
@Deprecated @NonNull
java.util.List<PlacemarkMapObject> addPlacemarks(@NonNull java.util.List<Point> points,
                                                 @NonNull ImageProvider image,
                                                 @NonNull IconStyle style)
```

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection Creates new placemarks and adds them to the current collection. Relevant for Android: this method provides better performance for adding a large number of placemarks than multiple calls of addPlacemark.

### addEmptyPlacemarks

```java
@Deprecated @NonNull
java.util.List<PlacemarkMapObject> addEmptyPlacemarks(@NonNull java.util.List<Point> points)
```

> [!CAUTION] Внимание
> Use ClusterizedPlacemarkCollection Creates new empty placemarks and adds them to the current collection.
>
>
> Relevant for Android: this method provides better performance for adding a large number of empty placemarks than multiple calls of addEmptyPlacemark.

### addPolyline

```java
@NonNull
PolylineMapObject addPolyline(@NonNull Polyline polyline)
```

Creates a new polyline and adds it to the current collection.

### addPolyline

```java
@NonNull
PolylineMapObject addPolyline()
```

Creates a new polyline with an empty geometry and adds it to the current collection.

### addPolygon

```java
@NonNull
PolygonMapObject addPolygon(@NonNull Polygon polygon)
```

Creates a new polygon and adds it to the current collection.

### addCircle

```java
@NonNull
CircleMapObject addCircle(@NonNull Circle circle)
```

Creates a new circle and adds it to the current collection.

### addCollection

```java
@NonNull
MapObjectCollection addCollection()
```

Creates a new nested collection of map objects.

### addClusterizedPlacemarkCollection

```java
@NonNull
ClusterizedPlacemarkCollection addClusterizedPlacemarkCollection(@NonNull java.lang.ref.WeakReference<ClusterListener> clusterListener)
```

Creates a new nested collection of clusterized placemarks.

The class does not retain the object in the 'clusterListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

| Parameters |   |
| --- | --- |
| `clusterListener` | Listener that controls cluster appearance once they are added to the map. |

### placemarksStyler

```java
@NonNull
PlacemarksStyler placemarksStyler()
```

A styler for all placemarks in this collection, including placemarks in child collections.
