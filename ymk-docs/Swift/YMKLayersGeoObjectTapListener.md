---
title: "YMKLayersGeoObjectTapListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKLayersGeoObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayersGeoObjectTapListener.html"
---
# YMKLayersGeoObjectTapListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayersGeoObjectTapListener.html)

```swift
protocol YMKLayersGeoObjectTapListener : NSObjectProtocol
```

Retrieves the brief geoObject info when an object is tapped.

## Summary

### Instance methods

```swift
func onObjectTap(with event: YMKGeoObjectTapEvent) -> Bool
```

Listener that retrieves brief geoObject info for the tapped object

## Instance methods

### onObjectTap(with:)

```swift
func onObjectTap(with event: YMKGeoObjectTapEvent) -> Bool
```

Listener that retrieves brief geoObject info for the tapped object. Returns false if the event wasn't handled. The event will be propagated to the map.
