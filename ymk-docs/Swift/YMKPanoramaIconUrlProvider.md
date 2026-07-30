---
title: "YMKPanoramaIconUrlProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaIconUrlProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconUrlProvider.html"
---
# YMKPanoramaIconUrlProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconUrlProvider.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaIconUrlProvider : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func formatUrl(withIconId iconId: String, scale: Double) -> String
```

Called once the icon is visible in view frustum Scale - scale factor

## Instance methods

### formatUrl(withIconId:scale:)

```swift
func formatUrl(withIconId iconId: String, scale: Double) -> String
```

Called once the icon is visible in view frustum Scale - scale factor. mdpi: 1.0 , xhdpi: 2.0 etc.

This method may be called on any thread. Its implementation must be thread-safe.
