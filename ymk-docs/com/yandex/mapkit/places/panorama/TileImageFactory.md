---
title: "TileImageFactory"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / TileImageFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileImageFactory.html"
---
# TileImageFactory

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/TileImageFactory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`interface TileImageFactory`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ImageProvider` | `load(@NonNull java.lang.String panoramaId, int x, int y, int tileLevel)`<br>Called once the tile is within the view frustum. |

## Methods

### load

```java
@WorkerThread @Nullable
ImageProvider load(@NonNull java.lang.String panoramaId,
                   int x,
                   int y,
                   int tileLevel)
```

Called once the tile is within the view frustum.

If tile can't be loaded, empty value must be returned.

This method will be called on a background thread.

| Parameters |   |
| --- | --- |
| `panoramaId` | The id of the panorama to get tile for. |
| `x` | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| `y` | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| `tileLevel` | Tile level coordinate. One of the given tilelevels level] |
