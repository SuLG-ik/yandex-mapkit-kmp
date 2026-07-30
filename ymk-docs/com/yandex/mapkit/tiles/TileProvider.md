---
title: "TileProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.tiles"
section: "Android / Справочник / com.yandex.mapkit.tiles / TileProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/tiles/TileProvider.html"
---
# TileProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/tiles/TileProvider.html)

**Package** com.yandex.mapkit.tiles

`interface TileProvider`

Generates tiles.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `RawTile` | `load(@NonNull TileId tileId, @NonNull Version version, @NonNull java.util.Map<java.lang.String, java.lang.String> features, @NonNull java.lang.String etag)`<br>Generates tile. |

## Methods

### load

```java
@WorkerThread @NonNull
RawTile load(@NonNull TileId tileId,
             @NonNull Version version,
             @NonNull java.util.Map<java.lang.String, java.lang.String> features,
             @NonNull java.lang.String etag)
```

Generates tile.

This method will be called on a background thread.
