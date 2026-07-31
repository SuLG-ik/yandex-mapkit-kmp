---
title: "YMKDrivingWeight"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingWeight"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingWeight.html"
---
# YMKDrivingWeight

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingWeight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingWeight : NSObject
```

Quantitative characteristics of any segment of the route.

## Summary

### Class methods

```swift
 init(time: YMKLocalizedValue,
 timeWithTraffic: YMKLocalizedValue,
  distance: YMKLocalizedValue)
```

### Properties

```swift
var time: YMKLocalizedValue { get }
```

Time to travel, not considering traffic

```swift
var timeWithTraffic: YMKLocalizedValue { get }
```

Time to travel, considering traffic

```swift
var distance: YMKLocalizedValue { get }
```

Distance to travel

## Class methods

### init(time:timeWithTraffic:distance:)

```swift
 init(time: YMKLocalizedValue,
 timeWithTraffic: YMKLocalizedValue,
  distance: YMKLocalizedValue)
```

## Properties

### time

```swift
var time: YMKLocalizedValue { get }
```

Time to travel, not considering traffic.

### timeWithTraffic

```swift
var timeWithTraffic: YMKLocalizedValue { get }
```

Time to travel, considering traffic.

### distance

```swift
var distance: YMKLocalizedValue { get }
```

Distance to travel.
