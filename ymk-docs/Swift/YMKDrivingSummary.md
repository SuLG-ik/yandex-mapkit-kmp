---
title: "YMKDrivingSummary"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSummary.html"
---
# YMKDrivingSummary

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingSummary : NSObject
```

Route summary.

## Summary

### Class methods

```swift
 init(weight: YMKDrivingWeight,
       flags: YMKDrivingFlags,
 nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures)
```

### Properties

```swift
var weight: YMKDrivingWeight { get }
```

Route "weight"

```swift
var flags: YMKDrivingFlags { get }
```

Overall route characteristics

```swift
var nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures { get }
```

Route features that cannot be avoided

## Class methods

### init(weight:flags:nonAvoidedFeatures:)

```swift
 init(weight: YMKDrivingWeight,
       flags: YMKDrivingFlags,
 nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures)
```

## Properties

### weight

```swift
var weight: YMKDrivingWeight { get }
```

Route "weight".

### flags

```swift
var flags: YMKDrivingFlags { get }
```

Overall route characteristics.

### nonAvoidedFeatures

```swift
var nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures { get }
```

Route features that cannot be avoided
