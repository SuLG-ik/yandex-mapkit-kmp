---
title: "IconUrlProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / IconUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconUrlProvider.html"
---
# IconUrlProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/IconUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface IconUrlProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `formatUrl(@NonNull java.lang.String iconId, double scale)`<br>Called once the icon is visible in view frustum Scale - scale factor. |

## Methods

### formatUrl

```java
@AnyThread @NonNull
java.lang.String formatUrl(@NonNull java.lang.String iconId,
                           double scale)
```

Called once the icon is visible in view frustum Scale - scale factor.

mdpi: 1.0 , xhdpi: 2.0 etc.

This method may be called on any thread. Its implementation must be thread-safe.
