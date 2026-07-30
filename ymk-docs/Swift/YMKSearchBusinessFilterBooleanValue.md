---
title: "YMKSearchBusinessFilterBooleanValue"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessFilterBooleanValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterBooleanValue.html"
---
# YMKSearchBusinessFilterBooleanValue

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterBooleanValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessFilterBooleanValue : NSObject
```

Value for boolean filters.

## Summary

### Class methods

```swift
 init(value: Bool, selected: NSNumber?)
```

### Properties

```swift
var value: Bool { get }
```

Filter value

```swift
var selected: NSNumber? { get }
```

Selected marker

## Class methods

### init(value:selected:)

```swift
 init(value: Bool, selected: NSNumber?)
```

## Properties

### value

```swift
var value: Bool { get }
```

Filter value. Set in server reponse for selected filters.

### selected

```swift
var selected: NSNumber? { get }
```

Selected marker. Set in server response for selected filters.

Optional field, can be nil.
