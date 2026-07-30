---
title: "YMKMapObjectDragListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapObjectDragListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectDragListener.html"
---
# YMKMapObjectDragListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectDragListener.html)

```swift
protocol YMKMapObjectDragListener : NSObjectProtocol
```

This listener is notified when a map object is being dragged. Note that the map object's "draggable" property needs to be set to True in order to activate dragging. A long tap on a map object activates dragging mode.

## Summary

### Instance methods

```swift
func onMapObjectDragStart(with mapObject: YMKMapObject)
```

Raised when dragging mode is active for the given map object

```swift
func onMapObjectDrag(with mapObject: YMKMapObject, point: YMKPoint)
```

Raised when the user is moving a finger and the map object follows it

```swift
func onMapObjectDragEnd(with mapObject: YMKMapObject)
```

Raised when the user released the tap

## Instance methods

### onMapObjectDragStart(with:)

```swift
func onMapObjectDragStart(with mapObject: YMKMapObject)
```

Raised when dragging mode is active for the given map object.

### onMapObjectDrag(with:point:)

```swift
func onMapObjectDrag(with mapObject: YMKMapObject, point: YMKPoint)
```

Raised when the user is moving a finger and the map object follows it.

### onMapObjectDragEnd(with:)

```swift
func onMapObjectDragEnd(with mapObject: YMKMapObject)
```

Raised when the user released the tap.
