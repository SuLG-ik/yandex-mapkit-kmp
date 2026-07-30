---
title: "YMKTransitOptions"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTransitOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTransitOptions.html"
---
# YMKTransitOptions

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTransitOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKTransitOptions : NSObject
```

User-defined options, like time options and filter options.

## Summary

### Class methods

```swift
 init(avoid: YMKFilterVehicleTypes, timeOptions: YMKTimeOptions)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var avoid: YMKFilterVehicleTypes { get }
```

Transport types that the router will avoid

```swift
var timeOptions: YMKTimeOptions { get }
```

Desired departure/arrival time settings

## Class methods

### init(avoid:timeOptions:)

```swift
 init(avoid: YMKFilterVehicleTypes, timeOptions: YMKTimeOptions)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### avoid

```swift
var avoid: YMKFilterVehicleTypes { get }
```

Transport types that the router will avoid. The value should be one of YMKFilterVehicleTypes, or their bitwise 'OR' combination.

### timeOptions

```swift
var timeOptions: YMKTimeOptions { get }
```

Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent.
