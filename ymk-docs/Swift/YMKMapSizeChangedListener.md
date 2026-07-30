---
title: "YMKMapSizeChangedListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKMapSizeChangedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapSizeChangedListener.html"
---
# YMKMapSizeChangedListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapSizeChangedListener.html)

```swift
protocol YMKMapSizeChangedListener : NSObjectProtocol
```

Listener for MapWindow size changes.

## Summary

### Instance methods

```swift
func onMapWindowSizeChanged(with mapWindow: YMKMapWindow,
                                  newWidth: Int,
                                 newHeight: Int)
```

Called when MapWindow handles the platform SizeChanged event

## Instance methods

### onMapWindowSizeChanged(with:newWidth:newHeight:)

```swift
func onMapWindowSizeChanged(with mapWindow: YMKMapWindow,
                                  newWidth: Int,
                                 newHeight: Int)
```

Called when MapWindow handles the platform SizeChanged event. param@ absolute Screen coordinates.
