---
title: "YMKPanoramaTileUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKPanoramaTileUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileUrlProvider.html"
---
# YMKPanoramaTileUrlProvider

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@protocol YMKPanoramaTileUrlProvider <NSObject>
```

## Summary

### Instance methods

```objectivec
- (nonnull NSString *)formatUrlWithPanoramaId:(nonnull NSString *)panoramaId
                                            x:(NSUInteger)x
                                            y:(NSUInteger)y
                                    tileLevel:(NSUInteger)tileLevel;
```

Called once the tile within the view frustum

## Instance methods

### formatUrlWithPanoramaId:x:y:tileLevel:

```objectivec
- (nonnull NSString *)formatUrlWithPanoramaId:(nonnull NSString *)panoramaId
                                            x:(NSUInteger)x
                                            y:(NSUInteger)y
                                    tileLevel:(NSUInteger)tileLevel;
```

Called once the tile within the view frustum.

This method may be called on any thread. Its implementation must be thread-safe.

| Parameters |   |
| --- | --- |
| panoramaId | The id of the panorama to get tile for. |
| x | Tile x coordinate in range [0..tileLevels[tileLevel].width/tileSize.width] x=0,y=0 is the left top corner |
| y | Tile y coordinate in range [0..ceil(tileLevels[tileLevel].height/tileSize.height)] |
| tileLevel | Tile level coordinate. One of the given tilelevels level] |
