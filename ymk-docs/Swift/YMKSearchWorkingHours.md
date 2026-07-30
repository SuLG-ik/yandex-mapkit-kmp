---
title: "YMKSearchWorkingHours"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchWorkingHours"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchWorkingHours.html"
---
# YMKSearchWorkingHours

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchWorkingHours.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchWorkingHours : NSObject
```

Open hours for an organization.

## Summary

### Class methods

```swift
 init(text: String,
 availabilities: [YMKSearchAvailability],
     state: YMKSearchWorkingHoursState?)
```

### Properties

```swift
var text: String { get }
```

Human-readable localized open hours description

```swift
var availabilities: [YMKSearchAvailability] { get }
```

Structured open hours information

```swift
var state: YMKSearchWorkingHoursState? { get }
```

Current company working status

Optional field, can be nil

## Class methods

### init(text:availabilities:state:)

```swift
 init(text: String,
 availabilities: [YMKSearchAvailability],
     state: YMKSearchWorkingHoursState?)
```

## Properties

### text

```swift
var text: String { get }
```

Human-readable localized open hours description.

### availabilities

```swift
var availabilities: [YMKSearchAvailability] { get }
```

Structured open hours information.

### state

```swift
var state: YMKSearchWorkingHoursState? { get }
```

Current company working status

Optional field, can be nil.
