---
title: "PanoramaLayer"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / PanoramaLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaLayer.html"
---
# PanoramaLayer

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/PanoramaLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface PanoramaLayer`

Panorama coverage layer

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `setStreetPanoramaVisible(boolean on)`<br>Enables or disables the street coverage layer. |
| `void` | `setAirshipPanoramaVisible(boolean on)`<br>Enables or disables the airship icons. |
| `boolean` | `isValid()`<br>Tells if this **PanoramaLayer** is valid or not. |

## Methods

### setStreetPanoramaVisible

```java
void setStreetPanoramaVisible(boolean on)
```

Enables or disables the street coverage layer.

### setAirshipPanoramaVisible

```java
void setAirshipPanoramaVisible(boolean on)
```

Enables or disables the airship icons.

### isValid

```java
boolean isValid()
```

Tells if this **PanoramaLayer** is valid or not.

Any other method (except for this one) called on an invalid **PanoramaLayer** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
