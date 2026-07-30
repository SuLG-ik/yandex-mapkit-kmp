---
title: "YMKRoadEventsLayerRoadEventStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoadEventsLayerRoadEventStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEventStyle.html"
---
# YMKRoadEventsLayerRoadEventStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEventStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKRoadEventsLayerRoadEventStyle : NSObject
```

## Summary

### Instance methods

```swift
func setIconImage(_ image: UIImage)
```

Road event icon image

### Properties

```swift
var zoomMin: Int { get set }
```

Road event is visible only if current camera zoom is greater or equal than this value

```swift
var iconAnchor: CGPoint { get set }
```

Icon anchor, (0, 0) is top left and (1

```swift
var zoomScaleFunction: [NSValue] { get set }
```

Piecewise linear scale function

```swift
var captionStyle: YMKRoadEventsLayerTextStyle? { get set }
```

Style of caption displayed under the road event icon

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setIconImage(_:)

```swift
func setIconImage(_ image: UIImage)
```

Road event icon image.

## Properties

### zoomMin

```swift
var zoomMin: Int { get set }
```

Road event is visible only if current camera zoom is greater or equal than this value.

### iconAnchor

```swift
var iconAnchor: CGPoint { get set }
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### zoomScaleFunction

```swift
var zoomScaleFunction: [NSValue] { get set }
```

Piecewise linear scale function. See Placemark's scale function.

### captionStyle

```swift
var captionStyle: YMKRoadEventsLayerTextStyle? { get set }
```

Style of caption displayed under the road event icon.

Optional property, can be nil.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
