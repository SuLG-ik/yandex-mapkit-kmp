---
title: "YMKPanoramaTileUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaTileUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileUrlProvider.html"
---
# YMKPanoramaTileUrlProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaTileUrlProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func formatUrl(withPanoramaId panoramaId: String,
                                       x: UInt,
                                       y: UInt,
                               tileLevel: UInt) -> String
```

Called once the tile within the view frustum

## Instance methods

### formatUrl(withPanoramaId:x:y:tileLevel:)

```swift
func formatUrl(withPanoramaId panoramaId: String,
                                       x: UInt,
                                       y: UInt,
                               tileLevel: UInt) -> String
```

Called once the tile within the view frustum.

This method may be called on any thread. Its implementation must be thread-safe.

| Parameters |   |
| --- | --- |
| panoramaId | The id of the panorama to get tile for. |
| x | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| y | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| tileLevel | Tile level coordinate. One of the given tilelevels level] |
