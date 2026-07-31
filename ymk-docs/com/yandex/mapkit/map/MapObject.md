---
title: "MapObject"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObject.html"
---
# MapObject

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObject.html)

**Package** com.yandex.mapkit.map

## All known Subinterfaces:

*[BaseMapObjectCollection](BaseMapObjectCollection.md)*, *[CircleMapObject](CircleMapObject.md)*, *[PlacemarkMapObject](PlacemarkMapObject.md)*, *[PolygonMapObject](PolygonMapObject.md)*, *[PolylineMapObject](PolylineMapObject.md)*

`interface MapObject`

An object displayed on the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `BaseMapObjectCollection` | `getParent()`<br>Returns the collection of map objects that the current map object belongs to. |
| `boolean` | `isVisible()`<br>Manages visibility of the object on the map. |
| `void` | `setVisible(boolean visible)` |
| `void` | `setVisible(boolean visible, @NonNull Animation animation)`<br>Manages visibility of the object. |
| `void` | `setVisible(boolean visible, @NonNull Animation animation, @Nullable Callback onFinished)`<br>Manages visibility of the object. |
| `float` | `getZIndex()`<br>Gets the z-index, which affects:<br>- Rendering order.<br>- Dispatching of UI events (taps and drags are dispatched to objects with higher z-indexes first).<br>Z-index is relative to the parent. |
| `void` | `setZIndex(float zIndex)` |
| `boolean` | `isDraggable()`<br>If true, the map object can be dragged by the user. |
| `void` | `setDraggable(boolean draggable)` |
| `java.lang.Object` | `getUserData()`<br>Use this property to attach any object-related metadata. |
| `void` | `setUserData(@Nullable java.lang.Object userData)` |
| `void` | `addTapListener(@NonNull java.lang.ref.WeakReference<MapObjectTapListener> tapListener)`<br>Adds a tap listener to the object. |
| `void` | `removeTapListener(@NonNull java.lang.ref.WeakReference<MapObjectTapListener> tapListener)`<br>Removes the tap listener from the object. |
| `void` | `setDragListener(@Nullable java.lang.ref.WeakReference<MapObjectDragListener> dragListener)`<br>Sets a drag listener for the object. |
| `boolean` | `isValid()`<br>Tells if this **MapObject** is valid or not. |

## Methods

### getParent

```java
@NonNull
BaseMapObjectCollection getParent()
```

Returns the collection of map objects that the current map object belongs to.

### isVisible

```java
boolean isVisible()
```

Manages visibility of the object on the map.

Default: true.

### setVisible

```java
void setVisible(boolean visible)
```

### setVisible

```java
void setVisible(boolean visible,
                @NonNull Animation animation)
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| `animation` | Describes the transition between visible and not visible states. |
| `onFinished` | Called when the transition is finished. |

### setVisible

```java
void setVisible(boolean visible,
                @NonNull Animation animation,
                @Nullable Callback onFinished)
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| `animation` | Describes the transition between visible and not visible states. |
| `onFinished` | Called when the transition is finished. |

### getZIndex

```java
float getZIndex()
```

Gets the z-index, which affects:

- Rendering order.
- Dispatching of UI events (taps and drags are dispatched to objects with higher z-indexes first).

Z-index is relative to the parent.

### setZIndex

```java
void setZIndex(float zIndex)
```

### isDraggable

```java
boolean isDraggable()
```

If true, the map object can be dragged by the user.

Default: false.

### setDraggable

```java
void setDraggable(boolean draggable)
```

### getUserData

```java
@Nullable
java.lang.Object getUserData()
```

Use this property to attach any object-related metadata.

Optional property, can be null.

### setUserData

```java
void setUserData(@Nullable java.lang.Object userData)
```

### addTapListener

```java
void addTapListener(@NonNull java.lang.ref.WeakReference<MapObjectTapListener> tapListener)
```

Adds a tap listener to the object.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListener

```java
void removeTapListener(@NonNull java.lang.ref.WeakReference<MapObjectTapListener> tapListener)
```

Removes the tap listener from the object.

### setDragListener

```java
void setDragListener(@Nullable java.lang.ref.WeakReference<MapObjectDragListener> dragListener)
```

Sets a drag listener for the object.

Each object can only have one drag listener.

The class does not retain the object in the 'dragListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### isValid

```java
boolean isValid()
```

Tells if this **MapObject** is valid or not.

Any other method (except for this one) called on an invalid **MapObject** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
