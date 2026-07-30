---
title: "YMKSearchFilterCollection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFilterCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFilterCollection.html"
---
# YMKSearchFilterCollection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFilterCollection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFilterCollection : NSObject
```

Filters for search request. Use builder to setup this class.

## Summary

### Class methods

```swift
 init(booleanFilters: [String],
         enumFilters: [String : [String]],
        rangeFilters: [String : YMKSearchFilterCollectionNumberRange],
         dateFilters: [String : YMKSearchFilterCollectionDateRange])
```

### Properties

```swift
var booleanFilters: [String] { get }
```

List of boolean filter ids to be set

```swift
var enumFilters: [String : [String]] { get }
```

Mapping of enum filter ids to list of enum value ids

```swift
var rangeFilters: [String : YMKSearchFilterCollectionNumberRange] { get }
```

Mapping of range filter ids to number range

```swift
var dateFilters: [String : YMKSearchFilterCollectionDateRange] { get }
```

Mapping of date filter ids to date range

## Class methods

### init(booleanFilters:enumFilters:rangeFilters:dateFilters:)

```swift
 init(booleanFilters: [String],
         enumFilters: [String : [String]],
        rangeFilters: [String : YMKSearchFilterCollectionNumberRange],
         dateFilters: [String : YMKSearchFilterCollectionDateRange])
```

## Properties

### booleanFilters

```swift
var booleanFilters: [String] { get }
```

List of boolean filter ids to be set.

### enumFilters

```swift
var enumFilters: [String : [String]] { get }
```

Mapping of enum filter ids to list of enum value ids.

### rangeFilters

```swift
var rangeFilters: [String : YMKSearchFilterCollectionNumberRange] { get }
```

Mapping of range filter ids to number range.

### dateFilters

```swift
var dateFilters: [String : YMKSearchFilterCollectionDateRange] { get }
```

Mapping of date filter ids to date range.
