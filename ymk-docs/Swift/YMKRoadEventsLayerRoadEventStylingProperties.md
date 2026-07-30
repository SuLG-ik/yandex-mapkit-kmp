---
title: "YMKRoadEventsLayerRoadEventStylingProperties"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoadEventsLayerRoadEventStylingProperties"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEventStylingProperties.html"
---
# YMKRoadEventsLayerRoadEventStylingProperties

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsLayerRoadEventStylingProperties.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKRoadEventsLayerRoadEventStylingProperties : NSObject
```

Interface that has subset of fields of RoadEvent necessary for providing style.

## Summary

### Instance methods

```swift
func hasSignificanceGreaterOrEqual(with significance: YMKRoadEventSignificance) -> Bool
```

Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only

### Properties

```swift
var tags: [NSNumber] { get }
```

Set of road event tags

```swift
var isInFuture: Bool { get }
```

Whether road event will become active in the future

```swift
var isOnRoute: Bool { get }
```

Road event placed on a route

```swift
var isSelected: Bool { get }
```

Road event was selected by RoadEventsLayer

```swift
var isUserEvent: Bool { get }
```

Currently logged in user is either an author of this road event or has commented it

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### hasSignificanceGreaterOrEqual(with:)

```swift
func hasSignificanceGreaterOrEqual(with significance: YMKRoadEventSignificance) -> Bool
```

Road events with a high significance can be visible on overview zooms, while events with low significance usually visible on detailed zooms only. Significance of a road event can depend on a road category this event is snapped to, number of comments of this event and other factors. Two road events with same significance but different tag sets can be visible on different zoom ranges.

## Properties

### tags

```swift
var tags: [NSNumber] { get }
```

Set of road event tags.

### isInFuture

```swift
var isInFuture: Bool { get }
```

Whether road event will become active in the future. See RoadEvent for details.

### isOnRoute

```swift
var isOnRoute: Bool { get }
```

Road event placed on a route. See RoadEventsLayer.setRoadEventsOnRoute.

### isSelected

```swift
var isSelected: Bool { get }
```

Road event was selected by RoadEventsLayer.selectRoadEvent.

### isUserEvent

```swift
var isUserEvent: Bool { get }
```

Currently logged in user is either an author of this road event or has commented it.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
