---
title: "YMKDrivingDirectionSign"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingDirectionSign"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingDirectionSign.html"
---
# YMKDrivingDirectionSign

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingDirectionSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingDirectionSign : NSObject
```

The sign showing named directions.

## Summary

### Class methods

```swift
 init(position: YMKPolylinePosition,
     direction: NSNumber?,
         items: [YMKDrivingDirectionSignItem])
```

### Properties

```swift
var position: YMKPolylinePosition { get }
```

The position of the sign

```swift
var direction: NSNumber? { get }
```

Optional field, can be nil

```swift
var items: [YMKDrivingDirectionSignItem] { get }
```

## Class methods

### init(position:direction:items:)

```swift
 init(position: YMKPolylinePosition,
     direction: NSNumber?,
         items: [YMKDrivingDirectionSignItem])
```

## Properties

### position

```swift
var position: YMKPolylinePosition { get }
```

The position of the sign.

### direction

```swift
var direction: NSNumber? { get }
```

Optional field, can be nil.

### items

```swift
var items: [YMKDrivingDirectionSignItem] { get }
```
