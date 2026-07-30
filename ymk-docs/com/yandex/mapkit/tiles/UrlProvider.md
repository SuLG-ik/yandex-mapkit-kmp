---
title: "UrlProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.tiles"
section: "Android / Справочник / com.yandex.mapkit.tiles / UrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/tiles/UrlProvider.html"
---
# UrlProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/tiles/UrlProvider.html)

**Package** com.yandex.mapkit.tiles

`interface UrlProvider`

Provides a formatted URL.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `formatUrl(@NonNull TileId tileId, @NonNull Version version, @NonNull java.util.Map<java.lang.String, java.lang.String> features)`<br>Create s a URL based on the tile ID, version, and features. |

## Methods

### formatUrl

```java
@AnyThread @NonNull
java.lang.String formatUrl(@NonNull TileId tileId,
                           @NonNull Version version,
                           @NonNull java.util.Map<java.lang.String, java.lang.String> features)
```

Create s a URL based on the tile ID, version, and features.

Features are some layer customisations. Tiles with appropriate features are prioretized over tiles without them when loading.

This method may be called on any thread. Its implementation must be thread-safe.
