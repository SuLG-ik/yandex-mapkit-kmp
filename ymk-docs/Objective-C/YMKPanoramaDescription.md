---
title: "YMKPanoramaDescription"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaDescription"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaDescription.html"
---
# YMKPanoramaDescription

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaDescription.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaDescription : NSObject
```

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaDescription *)panoramaDescriptionWithPanoramaId:(nonnull NSString *)panoramaId
                                                             position:(nullable YMKPanoramaPosition *)position
                                                          angularBBox:(nonnull YMKPanoramaAngularBoundingBox *)angularBBox
                                                             tileSize:(nonnull YMKPanoramaImageSize *)tileSize
                                                           tileLevels:(nonnull NSArray<YMKPanoramaTileLevel *> *)tileLevels
                                                          iconMarkers:(nonnull NSArray<YMKPanoramaIconMarker *> *)iconMarkers
                                                          textMarkers:(nonnull NSArray<YMKPanoramaTextMarker *> *)textMarkers
                                                       companyMarkers:(nonnull NSArray<YMKPanoramaCompanyMarker *> *)companyMarkers
                                                      iconConnections:(nonnull NSArray<YMKPanoramaIconConnection *> *)iconConnections
                                                     arrowConnections:(nonnull NSArray<YMKPanoramaArrowConnection *> *)arrowConnections
                                                            direction:(nonnull YMKDirection *)direction
                                                                 span:(nonnull YMKSpan *)span
                                                          attribution:(nullable YMKAttribution *)attribution;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider

```objectivec
@property (nonatomic, readonly, nullable) YMKPanoramaPosition *position;
```

Geo position

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKPanoramaAngularBoundingBox *angularBBox;
```

The angularBBox field sets how the tile tilelevels oriented in space

```objectivec
@property (nonatomic, readonly, nonnull) YMKPanoramaImageSize *tileSize;
```

Any tile level imageSize width must be multiple of the tileSize width

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaTileLevel *> *tileLevels;
```

The tileLevels is a set of the TileLevel structs

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaIconMarker *> *iconMarkers;
```

Add marker icons to the panorama

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaTextMarker *> *textMarkers;
```

Add marker text to the panorama

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaCompanyMarker *> *companyMarkers;
```

Add company icons and labels to the panorama

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaIconConnection *> *iconConnections;
```

Add icons with interaction

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaArrowConnection *> *arrowConnections;
```

Add standard player arrow connections

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *direction;
```

Suggest where to look at once panorama is opened

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpan *span;
```

Suggest view area span

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Panorama author information

## Class methods

### panoramaDescriptionWithPanoramaId:position:angularBBox:tileSize:tileLevels:iconMarkers:textMarkers:companyMarkers:iconConnections:arrowConnections:direction:span:attribution:

```objectivec
+ (nonnull YMKPanoramaDescription *)panoramaDescriptionWithPanoramaId:(nonnull NSString *)panoramaId
                                                             position:(nullable YMKPanoramaPosition *)position
                                                          angularBBox:(nonnull YMKPanoramaAngularBoundingBox *)angularBBox
                                                             tileSize:(nonnull YMKPanoramaImageSize *)tileSize
                                                           tileLevels:(nonnull NSArray<YMKPanoramaTileLevel *> *)tileLevels
                                                          iconMarkers:(nonnull NSArray<YMKPanoramaIconMarker *> *)iconMarkers
                                                          textMarkers:(nonnull NSArray<YMKPanoramaTextMarker *> *)textMarkers
                                                       companyMarkers:(nonnull NSArray<YMKPanoramaCompanyMarker *> *)companyMarkers
                                                      iconConnections:(nonnull NSArray<YMKPanoramaIconConnection *> *)iconConnections
                                                     arrowConnections:(nonnull NSArray<YMKPanoramaArrowConnection *> *)arrowConnections
                                                            direction:(nonnull YMKDirection *)direction
                                                                 span:(nonnull YMKSpan *)span
                                                          attribution:(nullable YMKAttribution *)attribution;
```

## Properties

### panoramaId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *panoramaId;
```

panoramaId is passed as a parameter to the TileImageFactory or to the TileUrlProvider

### position

```objectivec
@property (nonatomic, readonly, nullable) YMKPanoramaPosition *position;
```

Geo position.

Optional field, can be nil.

### angularBBox

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKPanoramaAngularBoundingBox *angularBBox;
```

The angularBBox field sets how the tile tilelevels oriented in space. Direction + span will be limited between top and bottom The recommendation for initializing angular bbox: (right - left) == 360. Non 360 degrees panoramas are not supported yet. (top - bottom) <= 180 The angular aspect ratio must be the same as any tileLevel aspect ratio. (right - left)/(top - bottom) == tileLevel[i].width/tileLevel[i].height

### tileSize

```objectivec
@property (nonatomic, readonly, nonnull) YMKPanoramaImageSize *tileSize;
```

Any tile level imageSize width must be multiple of the tileSize width. Only 256x256 and 512x512 tiles are supported.

### tileLevels

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaTileLevel *> *tileLevels;
```

The tileLevels is a set of the TileLevel structs. Tile levels can be added in any order. It's recommended to have at least 2 tile levels: - low quality zoom. For example 512x200 - high quality zoom. For axample 20480x8000

It can be useful to have several tile levels for huge images to save network traffic and reduce memory and power consumption. So the final tile levels list may look like that: level, width, height 0, 512, 200 1, 2048, 800 2, 5120, 2000 6, 10240, 4000 9, 20480, 8000

Player takes into account the view area size and available tile levels and downloads the most suitable level.

The tileLevels[i] aspect ratio must be the same. At first low quality zoom is loaded. Once it's done, the panorama player notifies that the panorama is opened and starts loading high quality zoom tiles.

### iconMarkers

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaIconMarker *> *iconMarkers;
```

Add marker icons to the panorama

### textMarkers

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaTextMarker *> *textMarkers;
```

Add marker text to the panorama

### companyMarkers

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaCompanyMarker *> *companyMarkers;
```

Add company icons and labels to the panorama

### iconConnections

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaIconConnection *> *iconConnections;
```

Add icons with interaction

### arrowConnections

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPanoramaArrowConnection *> *arrowConnections;
```

Add standard player arrow connections

### direction

```objectivec
@property (nonatomic, readonly, nonnull) YMKDirection *direction;
```

Suggest where to look at once panorama is opened. It's just a recommendation because it depends on angularBBox and span.

### span

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpan *span;
```

Suggest view area span. It's just a recommendation because it depends on angularBBox and direction.

### attribution

```objectivec
@property (nonatomic, readonly, nullable) YMKAttribution *attribution;
```

Panorama author information.

Optional field, can be nil.
