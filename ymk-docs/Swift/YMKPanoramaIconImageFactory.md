---
title: "YMKPanoramaIconImageFactory"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaIconImageFactory"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconImageFactory.html"
---
# YMKPanoramaIconImageFactory

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconImageFactory.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaIconImageFactory : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func load(withIconId iconId: String, scale: Double) -> UIImage?
```

Called once the icon is visible in view frustum If the icon can't be loaded, empty value must be returned

## Instance methods

### load(withIconId:scale:)

```swift
func load(withIconId iconId: String, scale: Double) -> UIImage?
```

Called once the icon is visible in view frustum If the icon can't be loaded, empty value must be returned. Scale - scale factor. mdpi: 1.0 , xhdpi: 2.0, etc. If you have image resources for different pixel densities, just ignore this parameter.

This method will be called on a background thread.
