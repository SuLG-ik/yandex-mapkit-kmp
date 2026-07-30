---
title: "YMKLocalizedValue"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLocalizedValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocalizedValue.html"
---
# YMKLocalizedValue

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLocalizedValue.html)

```swift
class YMKLocalizedValue : NSObject
```

A value respecting the device locale.

## Summary

### Class methods

```swift
 init(value: Double, text: String)
```

### Properties

```swift
var value: Double { get }
```

Value in SI units for distance, speed and duration

```swift
var text: String { get }
```

Localized text

## Class methods

### init(value:text:)

```swift
 init(value: Double, text: String)
```

## Properties

### value

```swift
var value: Double { get }
```

Value in SI units for distance, speed and duration.

### text

```swift
var text: String { get }
```

Localized text. For example: "15 ft" or "42 km".
