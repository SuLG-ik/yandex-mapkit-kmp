---
title: "YMKMasstransitTransportTransportThread"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransportTransportThread"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportTransportThread.html"
---
# YMKMasstransitTransportTransportThread

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportTransportThread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransportTransportThread : NSObject
```

YMKMasstransitThread specific properties of a mass transit ride section of a YMKMasstransitRoute.

## Summary

### Class methods

```swift
 init(thread: YMKMasstransitThread,
 isRecommended: Bool,
      alerts: [YMKMasstransitTransportThreadAlert],
 alternateDepartureStop: YMKMasstransitStop?,
 boardingOptions: YMKMasstransitBoardingOptions?,
 dropOffOptions: YMKMasstransitDropOffOptions,
  estimation: YMKMasstransitTravelEstimation?,
       stops: [YMKMasstransitTransportStop],
    geometry: YMKPolyline)
```

### Properties

```swift
var thread: YMKMasstransitThread { get }
```

Mass transit thread

```swift
var isRecommended: Bool { get }
```

Indicates that the mass transit router considers this thread the best one for the current section of the constucted route

```swift
var alerts: [YMKMasstransitTransportThreadAlert] { get }
```

Collection of important annotations for the section

```swift
var alternateDepartureStop: YMKMasstransitStop? { get }
```

If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section

```swift
var boardingOptions: YMKMasstransitBoardingOptions? { get }
```

Recommended underground or railway boarding options for this section

```swift
var dropOffOptions: YMKMasstransitDropOffOptions { get }
```

Railway drop-off options for this section

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Time estimation for transport thread

```swift
var stops: [YMKMasstransitTransportStop] { get }
```

Collection of stops for the section

```swift
var geometry: YMKPolyline { get }
```

Transport thread geometry

## Class methods

### init(thread:isRecommended:alerts:alternateDepartureStop:boardingOptions:dropOffOptions:estimation:stops:geometry:)

```swift
 init(thread: YMKMasstransitThread,
 isRecommended: Bool,
      alerts: [YMKMasstransitTransportThreadAlert],
 alternateDepartureStop: YMKMasstransitStop?,
 boardingOptions: YMKMasstransitBoardingOptions?,
 dropOffOptions: YMKMasstransitDropOffOptions,
  estimation: YMKMasstransitTravelEstimation?,
       stops: [YMKMasstransitTransportStop],
    geometry: YMKPolyline)
```

## Properties

### thread

```swift
var thread: YMKMasstransitThread { get }
```

Mass transit thread.

### isRecommended

```swift
var isRecommended: Bool { get }
```

Indicates that the mass transit router considers this thread the best one for the current section of the constucted route.

### alerts

```swift
var alerts: [YMKMasstransitTransportThreadAlert] { get }
```

Collection of important annotations for the section.

### alternateDepartureStop

```swift
var alternateDepartureStop: YMKMasstransitStop? { get }
```

If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section.

Optional field, can be nil.

### boardingOptions

```swift
var boardingOptions: YMKMasstransitBoardingOptions? { get }
```

Recommended underground or railway boarding options for this section.

Optional field, can be nil.

### dropOffOptions

```swift
var dropOffOptions: YMKMasstransitDropOffOptions { get }
```

Railway drop-off options for this section.

### estimation

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Time estimation for transport thread.

Optional field, can be nil.

### stops

```swift
var stops: [YMKMasstransitTransportStop] { get }
```

Collection of stops for the section. The first stop in the collection is the stop for boarding the transport, and the last stop in the collection is the stop for exiting the transport.

### geometry

```swift
var geometry: YMKPolyline { get }
```

Transport thread geometry.
