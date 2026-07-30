---
title: "Places"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places"
section: "Android / Справочник / com.yandex.mapkit.places / Places"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/Places.html"
---
# Places

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/Places.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places

`interface Places`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PanoramaService` | `createPanoramaService()`<br>Creates a service that allows to find a panorama closest to the chosen point. |
| `PanoramaLayer` | `createPanoramaLayer(@NonNull MapWindow mapWindow)`<br>Creates a layer representing where panoramas are available. |
| `boolean` | `isValid()`<br>Tells if this **Places** is valid or not. |

## Methods

### createPanoramaService

```java
@NonNull
PanoramaService createPanoramaService()
```

Creates a service that allows to find a panorama closest to the chosen point.

### createPanoramaLayer

```java
@NonNull
PanoramaLayer createPanoramaLayer(@NonNull MapWindow mapWindow)
```

Creates a layer representing where panoramas are available.

### isValid

```java
boolean isValid()
```

Tells if this **Places** is valid or not.

Any other method (except for this one) called on an invalid **Places** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
