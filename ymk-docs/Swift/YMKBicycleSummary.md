---
title: "YMKBicycleSummary"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSummary.html"
---
# YMKBicycleSummary

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleSummary : NSObject
```

Contains brief information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```swift
 init(weight: YMKBicycleWeight, flags: YMKBicycleFlags?)
```

### Properties

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route

```swift
var flags: YMKBicycleFlags? { get }
```

Specific properties of the route

## Class methods

### init(weight:flags:)

```swift
 init(weight: YMKBicycleWeight, flags: YMKBicycleFlags?)
```

## Properties

### weight

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route.

### flags

```swift
var flags: YMKBicycleFlags? { get }
```

Specific properties of the route.

Optional field, can be nil.
