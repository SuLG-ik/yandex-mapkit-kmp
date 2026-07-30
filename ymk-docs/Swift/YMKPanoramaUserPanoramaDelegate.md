---
title: "YMKPanoramaUserPanoramaDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaUserPanoramaDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaUserPanoramaDelegate.html"
---
# YMKPanoramaUserPanoramaDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaUserPanoramaDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaUserPanoramaDelegate : NSObjectProtocol
```

Listener to handle event from user panoramas

## Summary

### Instance methods

```swift
func onPanoramaChangeIntent(withPanoramaId panoramaId: String)
```

Called when user presses to the arrow or icon connection

## Instance methods

### onPanoramaChangeIntent(withPanoramaId:)

```swift
func onPanoramaChangeIntent(withPanoramaId panoramaId: String)
```

Called when user presses to the arrow or icon connection. It's a good place to handle panoramaId and call openPanorama...

| Parameters |   |
| --- | --- |
| panoramaId | The clicked connection panoramaId |
