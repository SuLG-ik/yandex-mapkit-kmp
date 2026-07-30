---
title: "YMKTimeOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTimeOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTimeOptions.html"
---
# YMKTimeOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTimeOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKTimeOptions : NSObject
```

Desired departure/arrival time settings. Only one the departureTime and arrivalTime fields should be specified.

## Summary

### Class methods

```swift
 init(departureTime: Date?, arrivalTime: Date?)
```

### Properties

```swift
var departureTime: Date? { get set }
```

Desired departure time in UTC for a time-dependent route request

```swift
var arrivalTime: Date? { get set }
```

Desired arrival time in UTC for a time-dependent route request

## Class methods

### init(departureTime:arrivalTime:)

```swift
 init(departureTime: Date?, arrivalTime: Date?)
```

## Properties

### departureTime

```swift
var departureTime: Date? { get set }
```

Desired departure time in UTC for a time-dependent route request. The value is specified in milliseconds. This option cannot be used with arrivalTime.

Optional field, can be nil.

### arrivalTime

```swift
var arrivalTime: Date? { get set }
```

Desired arrival time in UTC for a time-dependent route request. The value is specified in milliseconds. This option cannot be used with departureTime.

Optional field, can be nil.
