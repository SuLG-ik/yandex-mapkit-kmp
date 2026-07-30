---
title: "YMKMasstransitTravelEstimation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTravelEstimation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTravelEstimation.html"
---
# YMKMasstransitTravelEstimation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTravelEstimation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTravelEstimation : NSObject
```

Arrival and departure time estimations for time-dependent routes or sections of time-dependent routes.

## Summary

### Class methods

```swift
 init(departureTime: YMKTime, arrivalTime: YMKTime)
```

### Properties

```swift
var departureTime: YMKTime { get }
```

Departure time for a route or a route section

```swift
var arrivalTime: YMKTime { get }
```

Arrival time for a route or a route section

## Class methods

### init(departureTime:arrivalTime:)

```swift
 init(departureTime: YMKTime, arrivalTime: YMKTime)
```

## Properties

### departureTime

```swift
var departureTime: YMKTime { get }
```

Departure time for a route or a route section.

### arrivalTime

```swift
var arrivalTime: YMKTime { get }
```

Arrival time for a route or a route section.
