---
title: "MapObjectDragListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObjectDragListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectDragListener.html"
---
# MapObjectDragListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectDragListener.html)

**Package** com.yandex.mapkit.map

`interface MapObjectDragListener`

This listener is notified when a map object is being dragged.

Note that the map object's "draggable" property needs to be set to True in order to activate dragging. A long tap on a map object activates dragging mode.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMapObjectDragStart(@NonNull MapObject mapObject)`<br>Raised when dragging mode is active for the given map object. |
| `void` | `onMapObjectDrag(@NonNull MapObject mapObject, @NonNull Point point)`<br>Raised when the user is moving a finger and the map object follows it. |
| `void` | `onMapObjectDragEnd(@NonNull MapObject mapObject)`<br>Raised when the user released the tap. |

## Methods

### onMapObjectDragStart

```java
@UiThread
void onMapObjectDragStart(@NonNull MapObject mapObject)
```

Raised when dragging mode is active for the given map object.

### onMapObjectDrag

```java
@UiThread
void onMapObjectDrag(@NonNull MapObject mapObject,
                     @NonNull Point point)
```

Raised when the user is moving a finger and the map object follows it.

### onMapObjectDragEnd

```java
@UiThread
void onMapObjectDragEnd(@NonNull MapObject mapObject)
```

Raised when the user released the tap.
