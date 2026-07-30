---
title: "Cluster"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / Cluster"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Cluster.html"
---
# Cluster

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/Cluster.html)

**Package** com.yandex.mapkit.map

`interface Cluster`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<PlacemarkMapObject>` | `getPlacemarks()`<br>A list of placemarks the cluster contains. |
| `int` | `getSize()`<br>Cluster size. |
| `PlacemarkMapObject` | `getAppearance()`<br>Cluster representation displayed on the map. |
| `void` | `addClusterTapListener(@NonNull java.lang.ref.WeakReference<ClusterTapListener> clusterTapListener)`<br>Adds a tap listener for cluster. |
| `void` | `removeClusterTapListener(@NonNull java.lang.ref.WeakReference<ClusterTapListener> clusterTapListener)`<br>Removes tap listener. |
| `boolean` | `isValid()`<br>Tells if this **Cluster** is valid or not. |

## Methods

### getPlacemarks

```java
@NonNull
java.util.List<PlacemarkMapObject> getPlacemarks()
```

A list of placemarks the cluster contains.

### getSize

```java
int getSize()
```

Cluster size.

### getAppearance

```java
@NonNull
PlacemarkMapObject getAppearance()
```

Cluster representation displayed on the map.

### addClusterTapListener

```java
void addClusterTapListener(@NonNull java.lang.ref.WeakReference<ClusterTapListener> clusterTapListener)
```

Adds a tap listener for cluster.

The class does not retain the object in the 'clusterTapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeClusterTapListener

```java
void removeClusterTapListener(@NonNull java.lang.ref.WeakReference<ClusterTapListener> clusterTapListener)
```

Removes tap listener.

### isValid

```java
boolean isValid()
```

Tells if this **Cluster** is valid or not.

Any other method (except for this one) called on an invalid **Cluster** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
