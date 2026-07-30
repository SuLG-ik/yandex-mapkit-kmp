---
title: "YMKNavigationBalloonImageProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationBalloonImageProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationBalloonImageProvider.html"
---
# YMKNavigationBalloonImageProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationBalloonImageProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationBalloonImageProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func geometriesForBalloon(with balloon: YMKBalloon,
                           scaleFactor: Float,
                           isNightMode: Bool) -> [YMKBalloonGeometry]
```

returns geometry for all possible anchor placements

```swift
func createImage(with balloon: YMKBalloon,
                       anchor: YMKBalloonAnchor,
                  scaleFactor: Float,
                  isNightMode: Bool) -> UIImage
```

## Instance methods

### geometriesForBalloon(with:scaleFactor:isNightMode:)

```swift
func geometriesForBalloon(with balloon: YMKBalloon,
                           scaleFactor: Float,
                           isNightMode: Bool) -> [YMKBalloonGeometry]
```

returns geometry for all possible anchor placements

### createImage(with:anchor:scaleFactor:isNightMode:)

```swift
func createImage(with balloon: YMKBalloon,
                       anchor: YMKBalloonAnchor,
                  scaleFactor: Float,
                  isNightMode: Bool) -> UIImage
```
