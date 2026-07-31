---
title: "YMKPanoramaTileImageFactory"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaTileImageFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileImageFactory.html"
---
# YMKPanoramaTileImageFactory

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileImageFactory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaTileImageFactory : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func load(withPanoramaId panoramaId: String,
                                  x: UInt,
                                  y: UInt,
                          tileLevel: UInt) -> UIImage?
```

Called once the tile is within the view frustum

## Instance methods

### load(withPanoramaId:x:y:tileLevel:)

```swift
func load(withPanoramaId panoramaId: String,
                                  x: UInt,
                                  y: UInt,
                          tileLevel: UInt) -> UIImage?
```

Called once the tile is within the view frustum. If tile can't be loaded, empty value must be returned.

This method will be called on a background thread.

| Parameters |   |
| --- | --- |
| panoramaId | The id of the panorama to get tile for. |
| x | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| y | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| tileLevel | Tile level coordinate. One of the given tilelevels level] |
