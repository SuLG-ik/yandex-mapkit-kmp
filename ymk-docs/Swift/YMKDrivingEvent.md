---
title: "YMKDrivingEvent"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingEvent.html"
---
# YMKDrivingEvent

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingEvent.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingEvent : NSObject
```

Road event.

## Summary

### Class methods

```swift
 init(polylinePosition: YMKPolylinePosition,
               eventId: String,
       descriptionText: String?,
                  tags: [NSNumber],
              location: YMKPoint,
            speedLimit: NSNumber?)
```

### Properties

```swift
var polylinePosition: YMKPolylinePosition { get }
```

The position of the polyline

```swift
var eventId: String { get }
```

The unique ID of the event

```swift
var descriptionText: String? { get }
```

The description of the event

```swift
var tags: [NSNumber] { get }
```

The types of the road event

```swift
var location: YMKPoint { get }
```

The location of the road event

```swift
var speedLimit: NSNumber? { get }
```

The speed limit on the road

## Class methods

### init(polylinePosition:eventId:descriptionText:tags:location:speedLimit:)

```swift
 init(polylinePosition: YMKPolylinePosition,
               eventId: String,
       descriptionText: String?,
                  tags: [NSNumber],
              location: YMKPoint,
            speedLimit: NSNumber?)
```

## Properties

### polylinePosition

```swift
var polylinePosition: YMKPolylinePosition { get }
```

The position of the polyline.

### eventId

```swift
var eventId: String { get }
```

The unique ID of the event.

### descriptionText

```swift
var descriptionText: String? { get }
```

The description of the event.

Optional field, can be nil.

### tags

```swift
var tags: [NSNumber] { get }
```

The types of the road event.

### location

```swift
var location: YMKPoint { get }
```

The location of the road event.

### speedLimit

```swift
var speedLimit: NSNumber? { get }
```

The speed limit on the road. Valid only for cameras.

Optional field, can be nil.
