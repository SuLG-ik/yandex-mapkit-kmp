---
title: "GeoObjectTapEvent"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / GeoObjectTapEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/GeoObjectTapEvent.html"
---
# GeoObjectTapEvent

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/GeoObjectTapEvent.html)

**Package** com.yandex.mapkit.layers

`interface GeoObjectTapEvent`

Information about the tapped object.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `GeoObject` | `getGeoObject()` |
| `boolean` | `isValid()`<br>Tells if this **GeoObjectTapEvent** is valid or not. |

## Methods

### getGeoObject

```java
@NonNull
GeoObject getGeoObject()
```

**Returns**

GeoObject The object that was tapped.

### isValid

```java
boolean isValid()
```

Tells if this **GeoObjectTapEvent** is valid or not.

Any other method (except for this one) called on an invalid **GeoObjectTapEvent** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
