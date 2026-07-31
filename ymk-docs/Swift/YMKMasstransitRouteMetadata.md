---
title: "YMKMasstransitRouteMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteMetadata.html"
---
# YMKMasstransitRouteMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouteMetadata : NSObject, YMKBaseMetadata
```

Contains information associated with a route constructed by the mass transit router.

## Summary

### Class methods

```swift
 init(weight: YMKMasstransitWeight,
    settings: YMKMasstransitRouteSettings?,
  estimation: YMKMasstransitTravelEstimation?,
   wayPoints: [YMKMasstransitWayPoint],
     routeId: String?,
       flags: YMKMasstransitFlags?,
 comfortTags: [NSNumber],
 stairsSummary: YMKMasstransitStairsSummary,
 paymentOptions: [YMKMasstransitRoutePaymentOption],
 routeExplanation: String?)
```

### Properties

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route time, distance of the walking part, and the number of transfers

```swift
var settings: YMKMasstransitRouteSettings? { get }
```

Route settings that were used by the mass transit router

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations for time-dependent routes

```swift
var wayPoints: [YMKMasstransitWayPoint] { get }
```

List of route waypoints

```swift
var routeId: String? { get }
```

Unique route id

```swift
var flags: YMKMasstransitFlags? { get }
```

Flags which contains route properties

Optional field, can be nil

```swift
var comfortTags: [NSNumber] { get }
```

```swift
var stairsSummary: YMKMasstransitStairsSummary { get }
```

```swift
var paymentOptions: [YMKMasstransitRoutePaymentOption] { get }
```

List of payment options with prices for the whole route

```swift
var routeExplanation: String? { get }
```

Optional field, can be nil

## Class methods

### init(weight:settings:estimation:wayPoints:routeId:flags:comfortTags:stairsSummary:paymentOptions:routeExplanation:)

```swift
 init(weight: YMKMasstransitWeight,
    settings: YMKMasstransitRouteSettings?,
  estimation: YMKMasstransitTravelEstimation?,
   wayPoints: [YMKMasstransitWayPoint],
     routeId: String?,
       flags: YMKMasstransitFlags?,
 comfortTags: [NSNumber],
 stairsSummary: YMKMasstransitStairsSummary,
 paymentOptions: [YMKMasstransitRoutePaymentOption],
 routeExplanation: String?)
```

## Properties

### weight

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route time, distance of the walking part, and the number of transfers.

### settings

```swift
var settings: YMKMasstransitRouteSettings? { get }
```

Route settings that were used by the mass transit router.

Optional field, can be nil.

### estimation

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations for time-dependent routes.

Optional field, can be nil.

### wayPoints

```swift
var wayPoints: [YMKMasstransitWayPoint] { get }
```

List of route waypoints. See YMKMasstransitWayPoint for details

### routeId

```swift
var routeId: String? { get }
```

Unique route id.

Optional field, can be nil.

### flags

```swift
var flags: YMKMasstransitFlags? { get }
```

Flags which contains route properties

Optional field, can be nil.

### comfortTags

```swift
var comfortTags: [NSNumber] { get }
```

### stairsSummary

```swift
var stairsSummary: YMKMasstransitStairsSummary { get }
```

### paymentOptions

```swift
var paymentOptions: [YMKMasstransitRoutePaymentOption] { get }
```

List of payment options with prices for the whole route.

### routeExplanation

```swift
var routeExplanation: String? { get }
```

Optional field, can be nil.
