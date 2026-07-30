---
title: "DirectionChangeListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / DirectionChangeListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/DirectionChangeListener.html"
---
# DirectionChangeListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/DirectionChangeListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface DirectionChangeListener`

Listener to handle the change in panorama direction.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaDirectionChanged(@NonNull Player player)`<br>Called if the panorama direction was changed by the user or by the setDirection() method. |

## Methods

### onPanoramaDirectionChanged

```java
@UiThread
void onPanoramaDirectionChanged(@NonNull Player player)
```

Called if the panorama direction was changed by the user or by the setDirection() method.

| Parameters |   |
| --- | --- |
| `player` | Panorama player that sent the event. |
