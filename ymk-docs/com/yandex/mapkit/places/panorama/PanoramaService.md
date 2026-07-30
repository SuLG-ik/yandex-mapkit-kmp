---
title: "PanoramaService"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / PanoramaService"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaService.html"
---
# PanoramaService

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaService.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface PanoramaService`

The interface that handles panoramas.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SearchSession` | `findNearest(@NonNull Point position, @NonNull SearchListener searchListener)`<br>Requests the ID of the panorama that is closest to the specified position. |

## Methods

### findNearest

```java
@NonNull
SearchSession findNearest(@NonNull Point position,
                          @NonNull SearchListener searchListener)
```

Requests the ID of the panorama that is closest to the specified position.

| Parameters |   |
| --- | --- |
| `position` | Position to find the nearest panoramaId to. |
| `searchListener` | Receives the panorama search result. |

**Returns**

Session handle that should be stored until searchListener is notified.
