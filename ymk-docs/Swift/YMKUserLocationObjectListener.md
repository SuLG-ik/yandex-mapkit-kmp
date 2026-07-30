---
title: "YMKUserLocationObjectListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKUserLocationObjectListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationObjectListener.html"
---
# YMKUserLocationObjectListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationObjectListener.html)

```swift
protocol YMKUserLocationObjectListener : NSObjectProtocol
```

User location events object listener. Use it to customize the user location view. Although some callbacks are unused, the generic structure of the interface is suitable for object layer listeners.

## Summary

### Instance methods

```swift
func onObjectAdded(with view: YMKUserLocationView)
```

Called when the layer object is added

```swift
func onObjectRemoved(with view: YMKUserLocationView)
```

Called when the layer object is being removed

```swift
func onObjectUpdated(with view: YMKUserLocationView, event: YMKObjectEvent)
```

Called when the layer object is being updated

## Instance methods

### onObjectAdded(with:)

```swift
func onObjectAdded(with view: YMKUserLocationView)
```

Called when the layer object is added. It is called once when the user location icon appears the first time.

### onObjectRemoved(with:)

```swift
func onObjectRemoved(with view: YMKUserLocationView)
```

Called when the layer object is being removed. It is never called for the user location icon.

### onObjectUpdated(with:event:)

```swift
func onObjectUpdated(with view: YMKUserLocationView, event: YMKObjectEvent)
```

Called when the layer object is being updated. The 'event' parameter can be one of the derived types.
