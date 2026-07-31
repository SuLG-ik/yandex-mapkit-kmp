---
title: "YMKPanoramaTileLevel"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaTileLevel"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileLevel.html"
---
# YMKPanoramaTileLevel

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTileLevel.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaTileLevel : NSObject
```

The TileLevel struct.

## Summary

### Class methods

```swift
 init(level: UInt, imageSize: YMKPanoramaImageSize)
```

### Properties

```swift
var level: UInt { get }
```

level is passed as a parameter to the TileImageFactory or to the TileUrlProvider

```swift
var imageSize: YMKPanoramaImageSize { get }
```

Source image size

## Class methods

### init(level:imageSize:)

```swift
 init(level: UInt, imageSize: YMKPanoramaImageSize)
```

## Properties

### level

```swift
var level: UInt { get }
```

level is passed as a parameter to the TileImageFactory or to the TileUrlProvider. Each panorama description tile level must have unique value.

### imageSize

```swift
var imageSize: YMKPanoramaImageSize { get }
```

Source image size. The imageSize width must be multiples of the tileSize width. The imageSize height must be in range [1..imageSize.width/2]
