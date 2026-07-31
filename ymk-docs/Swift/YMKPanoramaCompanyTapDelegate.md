---
title: "YMKPanoramaCompanyTapDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaCompanyTapDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaCompanyTapDelegate.html"
---
# YMKPanoramaCompanyTapDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaCompanyTapDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaCompanyTapDelegate : NSObjectProtocol
```

Listener to handle the taps on company text and icon.

## Summary

### Instance methods

```swift
func onCompanyTap(with player: YMKPanoramaPlayer, info: YMKCompanyTapInfo)
```

Called if the user tapped on company icon or text below it

## Instance methods

### onCompanyTap(with:info:)

```swift
func onCompanyTap(with player: YMKPanoramaPlayer, info: YMKCompanyTapInfo)
```

Called if the user tapped on company icon or text below it.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
| info | Information about tapped company. |
