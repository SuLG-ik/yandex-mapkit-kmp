---
title: "YMKPanoramaSpanChangeDelegate"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKPanoramaSpanChangeDelegate"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaSpanChangeDelegate.html"
---
# YMKPanoramaSpanChangeDelegate

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaSpanChangeDelegate.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
protocol YMKPanoramaSpanChangeDelegate : NSObjectProtocol
```

Listener to handle the change in panorama span.

## Summary

### Instance methods

```swift
func onPanoramaSpanChanged(with player: YMKPanoramaPlayer)
```

Called if the user changed the zoom level or the span has been changed by the setSpan() method

## Instance methods

### onPanoramaSpanChanged(with:)

```swift
func onPanoramaSpanChanged(with player: YMKPanoramaPlayer)
```

Called if the user changed the zoom level or the span has been changed by the setSpan() method.

| Parameters |   |
| --- | --- |
| player | Panorama player that sent the event. |
