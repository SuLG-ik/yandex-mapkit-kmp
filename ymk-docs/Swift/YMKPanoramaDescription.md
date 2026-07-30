---
title: "YMKPanoramaDescription"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaDescription"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaDescription.html"
---
# YMKPanoramaDescription

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaDescription.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaDescription : NSObject
```

## Summary

### Class methods

```swift
 init(panoramaId: String,
        position: YMKPanoramaPosition?,
     angularBBox: YMKPanoramaAngularBoundingBox,
        tileSize: YMKPanoramaImageSize,
      tileLevels: [YMKPanoramaTileLevel],
     iconMarkers: [YMKPanoramaIconMarker],
     textMarkers: [YMKPanoramaTextMarker],
  companyMarkers: [YMKPanoramaCompanyMarker],
 iconConnections: [YMKPanoramaIconConnection],
 arrowConnections: [YMKPanoramaArrowConnection],
       direction: YMKDirection,
            span: YMKSpan,
     attribution: YMKAttribution?)
```

### Properties

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider

```swift
var position: YMKPanoramaPosition? { get }
```

Geo position

```swift
var angularBBox: YMKPanoramaAngularBoundingBox { get }
```

The angularBBox field sets how the tile tilelevels oriented in space

```swift
var tileSize: YMKPanoramaImageSize { get }
```

Any tile level imageSize width must be multiple of the tileSize width

```swift
var tileLevels: [YMKPanoramaTileLevel] { get }
```

The tileLevels is a set of the TileLevel structs

```swift
var iconMarkers: [YMKPanoramaIconMarker] { get }
```

Add marker icons to the panorama

```swift
var textMarkers: [YMKPanoramaTextMarker] { get }
```

Add marker text to the panorama

```swift
var companyMarkers: [YMKPanoramaCompanyMarker] { get }
```

Add company icons and labels to the panorama

```swift
var iconConnections: [YMKPanoramaIconConnection] { get }
```

Add icons with interaction

```swift
var arrowConnections: [YMKPanoramaArrowConnection] { get }
```

Add standard player arrow connections

```swift
var direction: YMKDirection { get }
```

Suggest where to look at once panorama is opened

```swift
var span: YMKSpan { get }
```

Suggest view area span

```swift
var attribution: YMKAttribution? { get }
```

Panorama author information

## Class methods

### init(panoramaId:position:angularBBox:tileSize:tileLevels:iconMarkers:textMarkers:companyMarkers:iconConnections:arrowConnections:direction:span:attribution:)

```swift
 init(panoramaId: String,
        position: YMKPanoramaPosition?,
     angularBBox: YMKPanoramaAngularBoundingBox,
        tileSize: YMKPanoramaImageSize,
      tileLevels: [YMKPanoramaTileLevel],
     iconMarkers: [YMKPanoramaIconMarker],
     textMarkers: [YMKPanoramaTextMarker],
  companyMarkers: [YMKPanoramaCompanyMarker],
 iconConnections: [YMKPanoramaIconConnection],
 arrowConnections: [YMKPanoramaArrowConnection],
       direction: YMKDirection,
            span: YMKSpan,
     attribution: YMKAttribution?)
```

## Properties

### panoramaId

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider

### position

```swift
var position: YMKPanoramaPosition? { get }
```

Geo position.

Optional field, can be nil.

### angularBBox

```swift
var angularBBox: YMKPanoramaAngularBoundingBox { get }
```

The angularBBox field sets how the tile tilelevels oriented in space. Direction + span will be limited between top and bottom The recommendation for initializing angular bbox: (right - left) == 360. Non 360 degrees panoramas are not supported yet. (top - bottom) <= 180 The angular aspect ratio must be the same as any tileLevel aspect ratio. (right - left)/(top - bottom) == tileLevel[i].width/tileLevel[i].height

### tileSize

```swift
var tileSize: YMKPanoramaImageSize { get }
```

Any tile level imageSize width must be multiple of the tileSize width. Only 256x256 and 512x512 tiles are supported.

### tileLevels

```swift
var tileLevels: [YMKPanoramaTileLevel] { get }
```

The tileLevels is a set of the TileLevel structs. Tile levels can be added in any order. It's recommended to have at least 2 tile levels: - low quality zoom. For example 512x200 - high quality zoom. For axample 20480x8000

It can be useful to have several tile levels for huge images to save network traffic and reduce memory and power consumption. So the final tile levels list may look like that: level, width, height 0, 512, 200 1, 2048, 800 2, 5120, 2000 6, 10240, 4000 9, 20480, 8000

Player takes into account the view area size and available tile levels and downloads the most suitable level.

The tileLevels[i] aspect ratio must be the same. At first low quality zoom is loaded. Once it's done, the panorama player notifies that the panorama is opened and starts loading high quality zoom tiles.

### iconMarkers

```swift
var iconMarkers: [YMKPanoramaIconMarker] { get }
```

Add marker icons to the panorama

### textMarkers

```swift
var textMarkers: [YMKPanoramaTextMarker] { get }
```

Add marker text to the panorama

### companyMarkers

```swift
var companyMarkers: [YMKPanoramaCompanyMarker] { get }
```

Add company icons and labels to the panorama

### iconConnections

```swift
var iconConnections: [YMKPanoramaIconConnection] { get }
```

Add icons with interaction

### arrowConnections

```swift
var arrowConnections: [YMKPanoramaArrowConnection] { get }
```

Add standard player arrow connections

### direction

```swift
var direction: YMKDirection { get }
```

Suggest where to look at once panorama is opened. It's just a recommendation because it depends on angularBBox and span.

### span

```swift
var span: YMKSpan { get }
```

Suggest view area span. It's just a recommendation because it depends on angularBBox and direction.

### attribution

```swift
var attribution: YMKAttribution? { get }
```

Panorama author information.

Optional field, can be nil.
