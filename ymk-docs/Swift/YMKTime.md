---
title: "YMKTime"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTime"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTime.html"
---
# YMKTime

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTime.html)

```swift
class YMKTime : NSObject
```

Time in I18nTime format.

## Summary

### Class methods

```swift
 init(value: Int64, tzOffset: Int, text: String)
```

### Properties

```swift
var value: Int64 { get }
```

Time value

```swift
var tzOffset: Int { get }
```

Time offset to account for time zones

```swift
var text: String { get }
```

The description of the timer

## Class methods

### init(value:tzOffset:text:)

```swift
 init(value: Int64, tzOffset: Int, text: String)
```

## Properties

### value

```swift
var value: Int64 { get }
```

Time value.

### tzOffset

```swift
var tzOffset: Int { get }
```

Time offset to account for time zones.

### text

```swift
var text: String { get }
```

The description of the timer.
