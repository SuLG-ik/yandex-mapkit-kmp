---
title: "GeoObjectTapListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / GeoObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/GeoObjectTapListener.html"
---
# GeoObjectTapListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/GeoObjectTapListener.html)

**Package** com.yandex.mapkit.layers

`interface GeoObjectTapListener`

Retrieves the brief geoObject info when an object is tapped.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `onObjectTap(@NonNull GeoObjectTapEvent event)`<br>Listener that retrieves brief geoObject info for the tapped object. |

## Methods

### onObjectTap

```java
@UiThread
boolean onObjectTap(@NonNull GeoObjectTapEvent event)
```

Listener that retrieves brief geoObject info for the tapped object.

Returns false if the event wasn't handled. The event will be propagated to the map.
