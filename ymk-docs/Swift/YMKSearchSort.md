---
title: "YMKSearchSort"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchSort"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSort.html"
---
# YMKSearchSort

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchSort.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchSort : NSObject
```

Describes response sort.

## Summary

### Class methods

```swift
 init(type: YMKSearchSortType, origin: NSNumber?)
```

### Properties

```swift
var type: YMKSearchSortType { get }
```

Sorting type

```swift
var origin: NSNumber? { get }
```

Sort origin (if results are ordered by distance)

## Class methods

### init(type:origin:)

```swift
 init(type: YMKSearchSortType, origin: NSNumber?)
```

## Properties

### type

```swift
var type: YMKSearchSortType { get }
```

Sorting type.

### origin

```swift
var origin: NSNumber? { get }
```

Sort origin (if results are ordered by distance).

Optional field, can be nil.
