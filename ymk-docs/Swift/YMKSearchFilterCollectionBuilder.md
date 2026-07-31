---
title: "YMKSearchFilterCollectionBuilder"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFilterCollectionBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFilterCollectionBuilder.html"
---
# YMKSearchFilterCollectionBuilder

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFilterCollectionBuilder.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFilterCollectionBuilder : NSObject
```

Builder for filter collection.

## Summary

### Instance methods

```swift
func addBooleanFilter(withFilterId filterId: String)
```

Adds boolean filter with given id to collection

```swift
func addEnumFilter(withFilterId filterId: String, valueIds: [String])
```

Adds enum filter with given id and values to the collection

```swift
func addRangeFilter(withFilterId filterId: String, from: Double, to: Double)
```

Adds range filter with given id and limits to the collection

```swift
func addDateFilter(withFilterId filterId: String, from: String, to: String)
```

Adds date filter with given id and limits to the collection

```swift
func build() -> YMKSearchFilterCollection
```

Builds resulting collection

## Instance methods

### addBooleanFilter(withFilterId:)

```swift
func addBooleanFilter(withFilterId filterId: String)
```

Adds boolean filter with given id to collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |

### addEnumFilter(withFilterId:valueIds:)

```swift
func addEnumFilter(withFilterId filterId: String, valueIds: [String])
```

Adds enum filter with given id and values to the collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| valueIds | list of value ids for the enum filter. |

### addRangeFilter(withFilterId:from:to:)

```swift
func addRangeFilter(withFilterId filterId: String, from: Double, to: Double)
```

Adds range filter with given id and limits to the collection.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| from | lower range limit. |
| to | upper range limit. |

### addDateFilter(withFilterId:from:to:)

```swift
func addDateFilter(withFilterId filterId: String, from: String, to: String)
```

Adds date filter with given id and limits to the collection. Limits are encoded as strings in YYYYMMDD format.

| Parameters |   |
| --- | --- |
| filterId | filter id to add. |
| from | lower range limit. |
| to | upper range limit. |

### build()

```swift
func build() -> YMKSearchFilterCollection
```

Builds resulting collection.

**Returns**

collection built from previously given filters.
