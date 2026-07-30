---
title: "PanoramaChangeListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / PanoramaChangeListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaChangeListener.html"
---
# PanoramaChangeListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaChangeListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface PanoramaChangeListener`

Listener to handle the panorama being opened or changed.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaChanged(@NonNull Player player)`<br>Called if the panorama was opened or changed by the user. |

## Methods

### onPanoramaChanged

```java
@UiThread
void onPanoramaChanged(@NonNull Player player)
```

Called if the panorama was opened or changed by the user.

You can get the panoramaId by using the panoramaId() method.

| Parameters |   |
| --- | --- |
| `player` | Panorama player that sent the event. |
