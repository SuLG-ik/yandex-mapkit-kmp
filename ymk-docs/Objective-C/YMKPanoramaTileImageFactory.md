---
title: "YMKPanoramaTileImageFactory"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaTileImageFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileImageFactory.html"
---
# YMKPanoramaTileImageFactory

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileImageFactory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaTileImageFactory <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nullable UIImage *)loadWithPanoramaId:(nonnull NSString *)panoramaId
                                       x:(NSUInteger)x
                                       y:(NSUInteger)y
                               tileLevel:(NSUInteger)tileLevel;
```

Called once the tile is within the view frustum

## Instance methods

### loadWithPanoramaId:x:y:tileLevel:

```objectivec
- (nullable UIImage *)loadWithPanoramaId:(nonnull NSString *)panoramaId
                                       x:(NSUInteger)x
                                       y:(NSUInteger)y
                               tileLevel:(NSUInteger)tileLevel;
```

Called once the tile is within the view frustum. If tile can't be loaded, empty value must be returned.

This method will be called on a background thread.

| Parameters |   |
| --- | --- |
| panoramaId | The id of the panorama to get tile for. |
| x | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| y | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| tileLevel | Tile level coordinate. One of the given tilelevels level] |
