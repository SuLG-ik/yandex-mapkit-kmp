---
title: "YMKSearchTimeRange"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchTimeRange"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchTimeRange.html"
---
# YMKSearchTimeRange

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchTimeRange.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchTimeRange : NSObject
```

The time interval used to compose availability info.

Can describe two kinds of intervals: 1. 24-hour interval (`isTwentyFourHours` is true, `from` and `to` are not used). 2. Smaller time interval (`isTwentyFourHours` is false, `from` and `to` are set to the begin and end of the interval)

## Summary

### Class methods

```swift
 init(isTwentyFourHours: NSNumber?, from: NSNumber?, to: NSNumber?)
```

### Properties

```swift
var isTwentyFourHours: NSNumber? { get }
```

All day (24 hours) time range marker

```swift
var from: NSNumber? { get }
```

Interval start (seconds from midnight)

```swift
var to: NSNumber? { get }
```

Interval end (seconds from midnight)

## Class methods

### init(isTwentyFourHours:from:to:)

```swift
 init(isTwentyFourHours: NSNumber?, from: NSNumber?, to: NSNumber?)
```

## Properties

### isTwentyFourHours

```swift
var isTwentyFourHours: NSNumber? { get }
```

All day (24 hours) time range marker.

Optional field, can be nil.

### from

```swift
var from: NSNumber? { get }
```

Interval start (seconds from midnight).

Optional field, can be nil.

### to

```swift
var to: NSNumber? { get }
```

Interval end (seconds from midnight).

Optional field, can be nil.
