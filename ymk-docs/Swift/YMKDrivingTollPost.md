---
title: "YMKDrivingTollPost"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingTollPost"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingTollPost.html"
---
# YMKDrivingTollPost

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingTollPost.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingTollPost : NSObject
```

A toll post object.

## Summary

### Class methods

```swift
 init(position: YMKPolylinePosition,
            id: NSNumber?,
 time_with_traffic: NSNumber?,
 nonTransactional: NSNumber?)
```

### Properties

```swift
var position: YMKPolylinePosition { get }
```

```swift
var id: NSNumber? { get }
```

Optional field, can be nil

```swift
var time_with_traffic: NSNumber? { get }
```

Optional field, can be nil

```swift
var nonTransactional: NSNumber? { get }
```

Optional field, can be nil

## Class methods

### init(position:id:time_with_traffic:nonTransactional:)

```swift
 init(position: YMKPolylinePosition,
            id: NSNumber?,
 time_with_traffic: NSNumber?,
 nonTransactional: NSNumber?)
```

## Properties

### position

```swift
var position: YMKPolylinePosition { get }
```

### id

```swift
var id: NSNumber? { get }
```

Optional field, can be nil.

### time_with_traffic

```swift
var time_with_traffic: NSNumber? { get }
```

Optional field, can be nil.

### nonTransactional

```swift
var nonTransactional: NSNumber? { get }
```

Optional field, can be nil.
