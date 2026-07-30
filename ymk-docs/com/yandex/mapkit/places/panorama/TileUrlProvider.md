---
title: "TileUrlProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / TileUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileUrlProvider.html"
---
# TileUrlProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface TileUrlProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `formatUrl(@NonNull java.lang.String panoramaId, int x, int y, int tileLevel)`<br>Called once the tile within the view frustum. |

## Methods

### formatUrl

```java
@AnyThread @NonNull
java.lang.String formatUrl(@NonNull java.lang.String panoramaId,
                           int x,
                           int y,
                           int tileLevel)
```

Called once the tile within the view frustum.

This method may be called on any thread. Its implementation must be thread-safe.

| Parameters |   |
| --- | --- |
| `panoramaId` | The id of the panorama to get tile for. |
| `x` | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| `y` | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| `tileLevel` | Tile level coordinate. One of the given tilelevels level] |
