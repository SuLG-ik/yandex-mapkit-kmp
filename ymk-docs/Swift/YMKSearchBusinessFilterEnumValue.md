---
title: "YMKSearchBusinessFilterEnumValue"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchBusinessFilterEnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterEnumValue.html"
---
# YMKSearchBusinessFilterEnumValue

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchBusinessFilterEnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchBusinessFilterEnumValue : NSObject
```

Value for enum filters.

## Summary

### Class methods

```swift
 init(value: YMKSearchFeatureEnumValue,
   selected: NSNumber?,
   disabled: NSNumber?)
```

### Properties

```swift
var value: YMKSearchFeatureEnumValue { get }
```

Filter value

```swift
var selected: NSNumber? { get }
```

Selected marker

```swift
var disabled: NSNumber? { get }
```

Same as YMKSearchBusinessFilter::disabled, but for this specific enum value

## Class methods

### init(value:selected:disabled:)

```swift
 init(value: YMKSearchFeatureEnumValue,
   selected: NSNumber?,
   disabled: NSNumber?)
```

## Properties

### value

```swift
var value: YMKSearchFeatureEnumValue { get }
```

Filter value. Set in server response for selected filters.

### selected

```swift
var selected: NSNumber? { get }
```

Selected marker. Set in server response for selected filters.

Optional field, can be nil.

### disabled

```swift
var disabled: NSNumber? { get }
```

Same as YMKSearchBusinessFilter::disabled, but for this specific enum value.

Optional field, can be nil.
