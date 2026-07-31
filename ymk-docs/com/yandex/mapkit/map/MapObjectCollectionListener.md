---
title: "MapObjectCollectionListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObjectCollectionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectCollectionListener.html"
---
# MapObjectCollectionListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectCollectionListener.html)

**Package** com.yandex.mapkit.map

`interface MapObjectCollectionListener`

The map object collection can't be modified in callbacks.

A runtime::RuntimeError exception is thrown if this happens.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMapObjectAdded(@NonNull MapObject mapObject)`<br>Called every time a new map object is added to the collection. |
| `void` | `onMapObjectRemoved(@NonNull MapObject mapObject)`<br>Called every time a map object is removed from the collection. |

## Methods

### onMapObjectAdded

```java
@UiThread
void onMapObjectAdded(@NonNull MapObject mapObject)
```

Called every time a new map object is added to the collection.

### onMapObjectRemoved

```java
@UiThread
void onMapObjectRemoved(@NonNull MapObject mapObject)
```

Called every time a map object is removed from the collection.
