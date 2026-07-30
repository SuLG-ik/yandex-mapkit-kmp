---
title: "UserPanoramaEventListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / UserPanoramaEventListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/UserPanoramaEventListener.html"
---
# UserPanoramaEventListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/UserPanoramaEventListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface UserPanoramaEventListener`

Listener to handle event from user panoramas

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaChangeIntent(@NonNull java.lang.String panoramaId)`<br>Called when user presses to the arrow or icon connection. |

## Methods

### onPanoramaChangeIntent

```java
@UiThread
void onPanoramaChangeIntent(@NonNull java.lang.String panoramaId)
```

Called when user presses to the arrow or icon connection.

It's a good place to handle panoramaId and call openPanorama...

| Parameters |   |
| --- | --- |
| `panoramaId` | The clicked connection panoramaId |
