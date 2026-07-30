---
title: "YMKMapInputListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapInputListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapInputListener.html"
---
# YMKMapInputListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapInputListener.html)

```swift
protocol YMKMapInputListener : NSObjectProtocol
```

Listener for user interactions with the map.

## Summary

### Instance methods

```swift
func onMapTap(with map: YMKMap, point: YMKPoint)
```

Called when a tap occurred unless a tap was handled by geo objects or map objects

```swift
func onMapLongTap(with map: YMKMap, point: YMKPoint)
```

Called when a long tap occurred

## Instance methods

### onMapTap(with:point:)

```swift
func onMapTap(with map: YMKMap, point: YMKPoint)
```

Called when a tap occurred unless a tap was handled by geo objects or map objects. param@ position absolute screen coordinates

### onMapLongTap(with:point:)

```swift
func onMapLongTap(with map: YMKMap, point: YMKPoint)
```

Called when a long tap occurred.
