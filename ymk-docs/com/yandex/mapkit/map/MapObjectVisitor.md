---
title: "MapObjectVisitor"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObjectVisitor"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectVisitor.html"
---
# MapObjectVisitor

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectVisitor.html)

**Package** com.yandex.mapkit.map

`interface MapObjectVisitor`

Used to traverse over the children of the MapObjectCollection.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPlacemarkVisited(@NonNull PlacemarkMapObject placemark)`<br>Called when a placemark is visited. |
| `void` | `onPolylineVisited(@NonNull PolylineMapObject polyline)`<br>Called when a polyline is visited. |
| `void` | `onPolygonVisited(@NonNull PolygonMapObject polygon)`<br>Called when a polygon is visited. |
| `void` | `onCircleVisited(@NonNull CircleMapObject circle)`<br>Called when a circle is visited. |
| `boolean` | `onCollectionVisitStart(@NonNull MapObjectCollection collection)`<br>Called for every child collection. |
| `void` | `onCollectionVisitEnd(@NonNull MapObjectCollection collection)`<br>Called for visited collections only. |
| `boolean` | `onClusterizedCollectionVisitStart(@NonNull ClusterizedPlacemarkCollection collection)`<br>Called for clusterized placemark collection. |
| `void` | `onClusterizedCollectionVisitEnd(@NonNull ClusterizedPlacemarkCollection collection)`<br>Called for visited clusterized placemark collections only. |

## Methods

### onPlacemarkVisited

```java
@UiThread
void onPlacemarkVisited(@NonNull PlacemarkMapObject placemark)
```

Called when a placemark is visited.

### onPolylineVisited

```java
@UiThread
void onPolylineVisited(@NonNull PolylineMapObject polyline)
```

Called when a polyline is visited.

### onPolygonVisited

```java
@UiThread
void onPolygonVisited(@NonNull PolygonMapObject polygon)
```

Called when a polygon is visited.

### onCircleVisited

```java
@UiThread
void onCircleVisited(@NonNull CircleMapObject circle)
```

Called when a circle is visited.

### onCollectionVisitStart

```java
@UiThread
boolean onCollectionVisitStart(@NonNull MapObjectCollection collection)
```

Called for every child collection.

The collection is ignored if this method returns false.

### onCollectionVisitEnd

```java
@UiThread
void onCollectionVisitEnd(@NonNull MapObjectCollection collection)
```

Called for visited collections only.

If an exception occurred during the visit, the method might be skipped.

### onClusterizedCollectionVisitStart

```java
@UiThread
boolean onClusterizedCollectionVisitStart(@NonNull ClusterizedPlacemarkCollection collection)
```

Called for clusterized placemark collection.

The collection is ignored if this method returns false.

### onClusterizedCollectionVisitEnd

```java
@UiThread
void onClusterizedCollectionVisitEnd(@NonNull ClusterizedPlacemarkCollection collection)
```

Called for visited clusterized placemark collections only.

If an exception occurred during the visit, the method might be skipped.
