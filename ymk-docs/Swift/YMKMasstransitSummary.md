---
title: "YMKMasstransitSummary"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitSummary"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSummary.html"
---
# YMKMasstransitSummary

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSummary.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitSummary : NSObject
```

Contains brief information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```swift
 init(weight: YMKMasstransitWeight,
  estimation: YMKMasstransitTravelEstimation?,
       flags: YMKMasstransitFlags?)
```

### Properties

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route time, distance of the walking part, and the number of transfers

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations for time-dependent routes

```swift
var flags: YMKMasstransitFlags? { get }
```

Specific properties of the route

## Class methods

### init(weight:estimation:flags:)

```swift
 init(weight: YMKMasstransitWeight,
  estimation: YMKMasstransitTravelEstimation?,
       flags: YMKMasstransitFlags?)
```

## Properties

### weight

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route time, distance of the walking part, and the number of transfers.

### estimation

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations for time-dependent routes.

Optional field, can be nil.

### flags

```swift
var flags: YMKMasstransitFlags? { get }
```

Specific properties of the route.

Optional field, can be nil.
