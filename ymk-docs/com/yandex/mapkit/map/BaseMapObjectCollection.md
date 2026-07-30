---
title: "BaseMapObjectCollection"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / BaseMapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/BaseMapObjectCollection.html"
---
# BaseMapObjectCollection

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/BaseMapObjectCollection.html)

**Package** com.yandex.mapkit.map

## All Superinterfaces:

*[MapObject](MapObject.md)*

## All known Subinterfaces:

*[ClusterizedPlacemarkCollection](ClusterizedPlacemarkCollection.md)*, *[MapObjectCollection](MapObjectCollection.md)*

`interface BaseMapObjectCollection extends MapObject`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `traverse(@NonNull java.lang.ref.WeakReference<MapObjectVisitor> mapObjectVisitor)`<br>Traverses through the collection with a visitor object. |
| `void` | `remove(@NonNull MapObject mapObject)`<br>Removes the given map object from the collection. |
| `void` | `clear()`<br>Removes all map objects from the collection. |
| `void` | `addListener(@NonNull java.lang.ref.WeakReference<MapObjectCollectionListener> collectionListener)`<br>Adds a listener to track notifications of changes to the collection. |
| `void` | `removeListener(@NonNull java.lang.ref.WeakReference<MapObjectCollectionListener> collectionListener)`<br>Removes a listener. |

## Methods

### traverse

```java
void traverse(@NonNull java.lang.ref.WeakReference<MapObjectVisitor> mapObjectVisitor)
```

Traverses through the collection with a visitor object.

Used for iteration over map objects in the collection.

The class does not retain the object in the 'mapObjectVisitor' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### remove

```java
void remove(@NonNull MapObject mapObject)
```

Removes the given map object from the collection.

### clear

```java
void clear()
```

Removes all map objects from the collection.

### addListener

```java
void addListener(@NonNull java.lang.ref.WeakReference<MapObjectCollectionListener> collectionListener)
```

Adds a listener to track notifications of changes to the collection.

The class does not retain the object in the 'collectionListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull java.lang.ref.WeakReference<MapObjectCollectionListener> collectionListener)
```

Removes a listener.
