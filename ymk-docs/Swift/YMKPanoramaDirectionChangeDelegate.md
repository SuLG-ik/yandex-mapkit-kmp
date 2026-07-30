---
title: "YMKPanoramaDirectionChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaDirectionChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaDirectionChangeDelegate.html"
---
# YMKPanoramaDirectionChangeDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaDirectionChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaDirectionChangeDelegate : NSObjectProtocol
```

Listener to handle the change in panorama direction.

## Summary

### Instance methods

```swift
func onPanoramaDirectionChanged(with player: YMKPanoramaPlayer)
```

Called if the panorama direction was changed by the user or by the setDirection() method

## Instance methods

### onPanoramaDirectionChanged(with:)

```swift
func onPanoramaDirectionChanged(with player: YMKPanoramaPlayer)
```

Called if the panorama direction was changed by the user or by the setDirection() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
