---
title: "ErrorListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / ErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/ErrorListener.html"
---
# ErrorListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/ErrorListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface ErrorListener`

Listener to handle possible errors.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaOpenError(@NonNull Player player, @NonNull Error error)`<br>Error notification listener for the panoramaOpen class. |

## Methods

### onPanoramaOpenError

```java
@UiThread
void onPanoramaOpenError(@NonNull Player player,
                         @NonNull Error error)
```

Error notification listener for the panoramaOpen class.

Called if the panorama could not be opened.
