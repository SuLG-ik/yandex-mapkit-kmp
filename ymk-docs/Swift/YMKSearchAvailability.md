---
title: "YMKSearchAvailability"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchAvailability"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAvailability.html"
---
# YMKSearchAvailability

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchAvailability.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchAvailability : NSObject
```

A single value of availability information.

Allows to describe business schedule for a group of days. For example, an organization open on weekdays from 9 AM to 6 PM with a lunch break from 1 PM to 2 PM can be described as a single `Availability` with `days` equal to `DayGroup::Weekdays` and two time ranges (9:00-13:00, 14:00-18:00). More complicated schedules will require multiple `Availabilities`.

## Summary

### Class methods

```swift
 init(days: YMKSearchDayGroup, timeRanges: [YMKSearchTimeRange])
```

### Properties

```swift
var days: YMKSearchDayGroup { get }
```

Days where time ranges are applicable

```swift
var timeRanges: [YMKSearchTimeRange] { get }
```

Ranges for open hours

## Class methods

### init(days:timeRanges:)

```swift
 init(days: YMKSearchDayGroup, timeRanges: [YMKSearchTimeRange])
```

## Properties

### days

```swift
var days: YMKSearchDayGroup { get }
```

Days where time ranges are applicable

### timeRanges

```swift
var timeRanges: [YMKSearchTimeRange] { get }
```

Ranges for open hours
