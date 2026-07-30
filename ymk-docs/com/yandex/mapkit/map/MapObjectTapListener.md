---
title: "MapObjectTapListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectTapListener.html"
---
# MapObjectTapListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapObjectTapListener.html)

**Package** com.yandex.mapkit.map

`interface MapObjectTapListener`

If an event is not handled by the source object then it's propagated to its parent.

This listener can be attached to any MapObject including MapObjectCollection.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `onMapObjectTap(@NonNull MapObject mapObject, @NonNull Point point)`<br>Returns true if the event was handled. |

## Methods

### onMapObjectTap

```java
@UiThread
boolean onMapObjectTap(@NonNull MapObject mapObject,
                       @NonNull Point point)
```

Returns true if the event was handled.

The event will not be propagated to the parent. Returns false if the event wasn't handled. The event will be propagated to the parent.
