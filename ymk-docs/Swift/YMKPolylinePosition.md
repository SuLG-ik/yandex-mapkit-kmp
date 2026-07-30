---
title: "YMKPolylinePosition"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPolylinePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylinePosition.html"
---
# YMKPolylinePosition

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPolylinePosition.html)

```swift
class YMKPolylinePosition : NSObject
```

The position on a polyline.

## Summary

### Class methods

```swift
 init(segmentIndex: UInt, segmentPosition: Double)
```

### Properties

```swift
var segmentIndex: UInt { get }
```

Zero-based index of the polyline segment

```swift
var segmentPosition: Double { get }
```

Position in the specified segment

## Class methods

### init(segmentIndex:segmentPosition:)

```swift
 init(segmentIndex: UInt, segmentPosition: Double)
```

## Properties

### segmentIndex

```swift
var segmentIndex: UInt { get }
```

Zero-based index of the polyline segment.

### segmentPosition

```swift
var segmentPosition: Double { get }
```

Position in the specified segment. Possible values: from 0 to 1, where 0 is the start of the segment and 1 is the end of it.
