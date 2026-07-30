---
title: "YMKRoadEventsLayerRoadEvent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoadEventsLayerRoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEvent.html"
---
# YMKRoadEventsLayerRoadEvent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEvent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKRoadEventsLayerRoadEvent : NSObject
```

## Summary

### Class methods

```swift
class func roadEventsLayerRoadEvent(withId id: String,
                                     position: YMKPoint,
                                         tags: [NSNumber],
                                      caption: String,
                                   isInFuture: Bool) -> YMKRoadEventsLayerRoadEvent
```

### Properties

```swift
var id: String { get }
```

The road event unique id

```swift
var position: YMKPoint { get }
```

Position of the road event on the globe

```swift
var tags: [NSNumber] { get }
```

Set of road event tags

```swift
var caption: String { get }
```

Text caption displayed under the road event icon

```swift
var isInFuture: Bool { get }
```

Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures

## Class methods

### roadEventsLayerRoadEvent(withId:position:tags:caption:isInFuture:)

```swift
class func roadEventsLayerRoadEvent(withId id: String,
                                     position: YMKPoint,
                                         tags: [NSNumber],
                                      caption: String,
                                   isInFuture: Bool) -> YMKRoadEventsLayerRoadEvent
```

## Properties

### id

```swift
var id: String { get }
```

The road event unique id.

### position

```swift
var position: YMKPoint { get }
```

Position of the road event on the globe.

### tags

```swift
var tags: [NSNumber] { get }
```

Set of road event tags.

### caption

```swift
var caption: String { get }
```

Text caption displayed under the road event icon.

### isInFuture

```swift
var isInFuture: Bool { get }
```

Some road events can be not active yet, but still must be displayed to notify users about future events, for example drawbridges or closures. Usually such events have a greyscale icon and/or clock drawn in the icon's corner.
