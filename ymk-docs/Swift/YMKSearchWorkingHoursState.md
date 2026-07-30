---
title: "YMKSearchWorkingHoursState"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchWorkingHoursState"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchWorkingHoursState.html"
---
# YMKSearchWorkingHoursState

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchWorkingHoursState.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchWorkingHoursState : NSObject
```

Describes if an organization is open or closed now.

## Summary

### Class methods

```swift
 init(isOpenNow: NSNumber?, text: String?, shortText: String?, tags: [String])
```

### Properties

```swift
var isOpenNow: NSNumber? { get }
```

Is open right now

```swift
var text: String? { get }
```

Human-readable localized description of current state

```swift
var shortText: String? { get }
```

Human-readable short localized description of current state

```swift
var tags: [String] { get }
```

One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'

## Class methods

### init(isOpenNow:text:shortText:tags:)

```swift
 init(isOpenNow: NSNumber?, text: String?, shortText: String?, tags: [String])
```

## Properties

### isOpenNow

```swift
var isOpenNow: NSNumber? { get }
```

Is open right now.

Optional field, can be nil.

### text

```swift
var text: String? { get }
```

Human-readable localized description of current state.

Optional field, can be nil.

### shortText

```swift
var shortText: String? { get }
```

Human-readable short localized description of current state.

Optional field, can be nil.

### tags

```swift
var tags: [String] { get }
```

One of the following 3 tags: 'break', 'opening_soon', 'closing_soon'. Additional tag values may be added eventually.
