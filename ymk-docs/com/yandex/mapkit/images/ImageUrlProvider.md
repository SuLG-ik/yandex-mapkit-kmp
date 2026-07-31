---
title: "ImageUrlProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.images"
section: "Android / Справочник / com.yandex.mapkit.images / ImageUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/images/ImageUrlProvider.html"
---
# ImageUrlProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/images/ImageUrlProvider.html)

**Package** com.yandex.mapkit.images

`interface ImageUrlProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `formatUrl(@NonNull ImageDataDescriptor descriptor)`<br>Generates an URL that is used to load described image. |

## Methods

### formatUrl

```java
@AnyThread @NonNull
java.lang.String formatUrl(@NonNull ImageDataDescriptor descriptor)
```

Generates an URL that is used to load described image.

This method may be called on any thread. Its implementation must be thread-safe.
