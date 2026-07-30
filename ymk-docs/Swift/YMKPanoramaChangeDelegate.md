---
title: "YMKPanoramaChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaChangeDelegate.html"
---
# YMKPanoramaChangeDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaChangeDelegate : NSObjectProtocol
```

Listener to handle the panorama being opened or changed.

## Summary

### Instance methods

```swift
func onPanoramaChanged(with player: YMKPanoramaPlayer)
```

Called if the panorama was opened or changed by the user

## Instance methods

### onPanoramaChanged(with:)

```swift
func onPanoramaChanged(with player: YMKPanoramaPlayer)
```

Called if the panorama was opened or changed by the user. You can get the panoramaId by using the panoramaId() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
