---
title: "YMKSearchBusinessFilter"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessFilter"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilter.html"
---
# YMKSearchBusinessFilter

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessFilter : NSObject
```

A filter that could be applied to search results.

Filters can be either boolean (that is Wi-Fi availability in a cafe) or enumerated (that is cuisine type in a restaurant). Enumerated filters support multiple selected values (OR-combined), to search, for example, for restaurants with Armenian or Georgian cuisine at once.

This class is used in two separate ways: server response contains all filters applicable to current search request and client can use some of these filters to get more specific results in the following search requests

## Summary

### Class methods

```swift
 init(id: String,
    name: String?,
 disabled: NSNumber?,
 iconLight: YMKImage?,
 iconDark: YMKImage?,
 iconAfterLight: YMKImage?,
 iconAfterDark: YMKImage?,
 singleSelect: NSNumber?,
  values: YMKSearchBusinessFilterValues)
```

### Properties

```swift
var id: String { get }
```

Filter id

```swift
var name: String? { get }
```

Human-readable filter name

```swift
var disabled: NSNumber? { get }
```

The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found * (selected:false, disabled:true)

```swift
var iconLight: YMKImage? { get }
```

Optional field, can be nil

```swift
var iconDark: YMKImage? { get }
```

Optional field, can be nil

```swift
var iconAfterLight: YMKImage? { get }
```

Optional field, can be nil

```swift
var iconAfterDark: YMKImage? { get }
```

Optional field, can be nil

```swift
var singleSelect: NSNumber? { get }
```

Only one of multiple available values should be selected

```swift
var values: YMKSearchBusinessFilterValues { get }
```

Filter values

## Class methods

### init(id:name:disabled:iconLight:iconDark:iconAfterLight:iconAfterDark:singleSelect:values:)

```swift
 init(id: String,
    name: String?,
 disabled: NSNumber?,
 iconLight: YMKImage?,
 iconDark: YMKImage?,
 iconAfterLight: YMKImage?,
 iconAfterDark: YMKImage?,
 singleSelect: NSNumber?,
  values: YMKSearchBusinessFilterValues)
```

## Properties

### id

```swift
var id: String { get }
```

Filter id.

### name

```swift
var name: String? { get }
```

Human-readable filter name.

Optional field, can be nil.

### disabled

```swift
var disabled: NSNumber? { get }
```

The filter should not be used by the client, because filter is either used already (selected:true, disabled:true) or nothing would be found * (selected:false, disabled:true).

Optional field, can be nil.

### iconLight

```swift
var iconLight: YMKImage? { get }
```

Optional field, can be nil.

### iconDark

```swift
var iconDark: YMKImage? { get }
```

Optional field, can be nil.

### iconAfterLight

```swift
var iconAfterLight: YMKImage? { get }
```

Optional field, can be nil.

### iconAfterDark

```swift
var iconAfterDark: YMKImage? { get }
```

Optional field, can be nil.

### singleSelect

```swift
var singleSelect: NSNumber? { get }
```

Only one of multiple available values should be selected.

Optional field, can be nil.

### values

```swift
var values: YMKSearchBusinessFilterValues { get }
```

Filter values.
