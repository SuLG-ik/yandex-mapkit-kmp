---
title: "YMKOverlay"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKOverlay"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOverlay.html"
---
# YMKOverlay

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOverlay.html)

```swift
class YMKOverlay : NSObject
```

Allows to render overlay on the screen.

## Summary

### Instance methods

```swift
func setImageWith(_ image: UIImage, rect: YMKScreenRect)
```

Sets image as content of overlay, resets view

```swift
func setViewWithView(_ view: YRTViewProvider, rect: YMKScreenRect)
```

Sets view as content of overlay, resets image

```swift
func remove()
```

Removes the overlay from the map

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setImageWith(_:rect:)

```swift
func setImageWith(_ image: UIImage, rect: YMKScreenRect)
```

Sets image as content of overlay, resets view. Window origin (0, 0) - top left corner.

### setViewWithView(_:rect:)

```swift
func setViewWithView(_ view: YRTViewProvider, rect: YMKScreenRect)
```

Sets view as content of overlay, resets image. Window origin (0, 0) - top left corner.

### remove()

```swift
func remove()
```

Removes the overlay from the map.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
