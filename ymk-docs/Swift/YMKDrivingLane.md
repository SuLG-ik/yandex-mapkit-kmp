---
title: "YMKDrivingLane"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingLane"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingLane.html"
---
# YMKDrivingLane

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingLane.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingLane : NSObject
```

The lane object.

## Summary

### Class methods

```swift
 init(laneKind: YMKDrivingLaneKind,
    directions: [NSNumber],
 highlightedDirection: NSNumber?)
```

### Properties

```swift
var laneKind: YMKDrivingLaneKind { get }
```

The type of lane

```swift
var directions: [NSNumber] { get }
```

Lane direction

```swift
var highlightedDirection: NSNumber? { get }
```

Highlighted lane direction

## Class methods

### init(laneKind:directions:highlightedDirection:)

```swift
 init(laneKind: YMKDrivingLaneKind,
    directions: [NSNumber],
 highlightedDirection: NSNumber?)
```

## Properties

### laneKind

```swift
var laneKind: YMKDrivingLaneKind { get }
```

The type of lane.

### directions

```swift
var directions: [NSNumber] { get }
```

Lane direction.

### highlightedDirection

```swift
var highlightedDirection: NSNumber? { get }
```

Highlighted lane direction.

Optional field, can be nil.
