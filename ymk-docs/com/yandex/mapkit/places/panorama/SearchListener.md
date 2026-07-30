---
title: "SearchListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / SearchListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SearchListener.html"
---
# SearchListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SearchListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`static interface SearchListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPanoramaSearchResult(@NonNull java.lang.String panoramaId)`<br>Callback for panoramaId result. |
| `void` | `onPanoramaSearchError(@NonNull Error error)`<br>Callback for error processing. |

## Methods

### onPanoramaSearchResult

```java
@UiThread
void onPanoramaSearchResult(@NonNull java.lang.String panoramaId)
```

Callback for panoramaId result.

| Parameters |   |
| --- | --- |
| `panoramaId` | The ID of the nearest panorama for the requested position. |

### onPanoramaSearchError

```java
@UiThread
void onPanoramaSearchError(@NonNull Error error)
```

Callback for error processing.

| Parameters |   |
| --- | --- |
| `error` | Error description. |
