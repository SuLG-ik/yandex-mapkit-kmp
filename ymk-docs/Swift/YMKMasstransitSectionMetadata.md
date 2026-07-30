---
title: "YMKMasstransitSectionMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitSectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSectionMetadata.html"
---
# YMKMasstransitSectionMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitSectionMetadata : NSObject
```

General information about a section of a route. The YMKMasstransitSectionMetadata::data field describes the type of section: wait, walk, transfer, or transport, and related data. Related data can be set for walk and transfer sections. This data is a vector of construction types of corresponding geometry segments.

## Summary

### Class methods

```swift
 init(weight: YMKMasstransitWeight,
        data: YMKMasstransitSectionMetadataSectionData,
  estimation: YMKMasstransitTravelEstimation?,
    legIndex: UInt,
 paymentOptions: [YMKMasstransitSectionPaymentOption])
```

### Properties

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route traveling time, distance of the walking part, and the number of transfers

```swift
var data: YMKMasstransitSectionMetadataSectionData { get }
```

Contains information that is specific to a section type: wait, walk, transfer, or ride transport

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations

```swift
var legIndex: UInt { get }
```

Part of the route polyline for the route leg

```swift
var paymentOptions: [YMKMasstransitSectionPaymentOption] { get }
```

List of payment options with prices for the current section

## Class methods

### init(weight:data:estimation:legIndex:paymentOptions:)

```swift
 init(weight: YMKMasstransitWeight,
        data: YMKMasstransitSectionMetadataSectionData,
  estimation: YMKMasstransitTravelEstimation?,
    legIndex: UInt,
 paymentOptions: [YMKMasstransitSectionPaymentOption])
```

## Properties

### weight

```swift
var weight: YMKMasstransitWeight { get }
```

Contains the route traveling time, distance of the walking part, and the number of transfers.

### data

```swift
var data: YMKMasstransitSectionMetadataSectionData { get }
```

Contains information that is specific to a section type: wait, walk, transfer, or ride transport.

### estimation

```swift
var estimation: YMKMasstransitTravelEstimation? { get }
```

Arrival and departure time estimations. This field is set only for time-dependent routes.

Optional field, can be nil.

### legIndex

```swift
var legIndex: UInt { get }
```

Part of the route polyline for the route leg. A leg is a part of the route between two consecutive waypoints.

### paymentOptions

```swift
var paymentOptions: [YMKMasstransitSectionPaymentOption] { get }
```

List of payment options with prices for the current section.
