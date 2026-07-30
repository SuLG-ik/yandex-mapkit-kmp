---
title: "YMKPanoramaTileLevel"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaTileLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileLevel.html"
---
# YMKPanoramaTileLevel

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaTileLevel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaTileLevel : NSObject
```

The TileLevel struct.

## Summary

### Class methods

```objectivec
+ (nonnull YMKPanoramaTileLevel *)tileLevelWithLevel:( NSUInteger)level
                                           imageSize:(nonnull YMKPanoramaImageSize *)imageSize;
```

### Properties

```objectivec
@property (nonatomic, readonly) NSUInteger level;
```

level is passed as a parameter to the TileImageFactory or to the TileUrlProvider

```objectivec
@property (nonatomic, readonly, nonnull) YMKPanoramaImageSize *imageSize;
```

Source image size

## Class methods

### tileLevelWithLevel:imageSize:

```objectivec
+ (nonnull YMKPanoramaTileLevel *)tileLevelWithLevel:( NSUInteger)level
                                           imageSize:(nonnull YMKPanoramaImageSize *)imageSize;
```

## Properties

### level

```objectivec
@property (nonatomic, readonly) NSUInteger level;
```

level is passed as a parameter to the TileImageFactory or to the TileUrlProvider. Each panorama description tile level must have unique value.

### imageSize

```objectivec
@property (nonatomic, readonly, nonnull) YMKPanoramaImageSize *imageSize;
```

Source image size. The imageSize width must be multiples of the tileSize width. The imageSize height must be in range [1..imageSize.width/2]
