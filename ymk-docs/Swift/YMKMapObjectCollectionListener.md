---
title: "YMKMapObjectCollectionListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapObjectCollectionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectCollectionListener.html"
---
# YMKMapObjectCollectionListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObjectCollectionListener.html)

```swift
protocol YMKMapObjectCollectionListener : NSObjectProtocol
```

The map object collection can't be modified in callbacks. A runtime::RuntimeError exception is thrown if this happens.

## Summary

### Instance methods

```swift
func onMapObjectAdded(with mapObject: YMKMapObject)
```

Called every time a new map object is added to the collection

```swift
func onMapObjectRemoved(with mapObject: YMKMapObject)
```

Called every time a map object is removed from the collection

## Instance methods

### onMapObjectAdded(with:)

```swift
func onMapObjectAdded(with mapObject: YMKMapObject)
```

Called every time a new map object is added to the collection.

### onMapObjectRemoved(with:)

```swift
func onMapObjectRemoved(with mapObject: YMKMapObject)
```

Called every time a map object is removed from the collection.
