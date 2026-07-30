---
title: "YMKDrivingLaneSign"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingLaneSign"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingLaneSign.html"
---
# YMKDrivingLaneSign

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingLaneSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingLaneSign : NSObject
```

The sign showing a lane.

## Summary

### Class methods

```swift
 init(position: YMKPolylinePosition,
     annotated: NSNumber?,
         lanes: [YMKDrivingLane])
```

### Properties

```swift
var position: YMKPolylinePosition { get }
```

The position of the sign

```swift
var annotated: NSNumber? { get }
```

Determines whether the sign should be annotated

```swift
var lanes: [YMKDrivingLane] { get }
```

The lane to display the sign in

## Class methods

### init(position:annotated:lanes:)

```swift
 init(position: YMKPolylinePosition,
     annotated: NSNumber?,
         lanes: [YMKDrivingLane])
```

## Properties

### position

```swift
var position: YMKPolylinePosition { get }
```

The position of the sign.

### annotated

```swift
var annotated: NSNumber? { get }
```

Determines whether the sign should be annotated.

Optional field, can be nil.

### lanes

```swift
var lanes: [YMKDrivingLane] { get }
```

The lane to display the sign in.
