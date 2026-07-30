---
title: "YMKMapObjectTapListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectTapListener.html"
---
# YMKMapObjectTapListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectTapListener.html)

```swift
protocol YMKMapObjectTapListener : NSObjectProtocol
```

If an event is not handled by the source object then it's propagated to its parent. This listener can be attached to any MapObject including MapObjectCollection.

## Summary

### Instance methods

```swift
func onMapObjectTap(with mapObject: YMKMapObject, point: YMKPoint) -> Bool
```

Returns true if the event was handled

## Instance methods

### onMapObjectTap(with:point:)

```swift
func onMapObjectTap(with mapObject: YMKMapObject, point: YMKPoint) -> Bool
```

Returns true if the event was handled. The event will not be propagated to the parent. Returns false if the event wasn't handled. The event will be propagated to the parent.
