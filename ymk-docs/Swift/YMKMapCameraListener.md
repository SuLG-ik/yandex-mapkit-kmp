---
title: "YMKMapCameraListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapCameraListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapCameraListener.html"
---
# YMKMapCameraListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapCameraListener.html)

```swift
protocol YMKMapCameraListener : NSObjectProtocol
```

Listens for updates to the camera position.

## Summary

### Instance methods

```swift
func onCameraPositionChanged(with map: YMKMap,
                       cameraPosition: YMKCameraPosition,
                   cameraUpdateReason: YMKCameraUpdateReason,
                             finished: Bool)
```

Triggered when the camera position changed

## Instance methods

### onCameraPositionChanged(with:cameraPosition:cameraUpdateReason:finished:)

```swift
func onCameraPositionChanged(with map: YMKMap,
                       cameraPosition: YMKCameraPosition,
                   cameraUpdateReason: YMKCameraUpdateReason,
                             finished: Bool)
```

Triggered when the camera position changed.

| Parameters |   |
| --- | --- |
| map | Event source. |
| cameraPosition | Current camera position. |
| cameraUpdateReason | The reason of camera update. |
| finished | True if the camera finished moving, false otherwise. If a movement is cancelled then cameraUpdateReason represents initiator of cancellation. |
