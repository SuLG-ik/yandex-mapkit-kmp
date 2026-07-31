---
title: "YMKMasstransitSection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitSection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSection.html"
---
# YMKMasstransitSection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitSection : NSObject
```

Contains information about an individual section of a mass transit YMKMasstransitRoute. The only fields that are always set are YMKMasstransitSection::metadata.YMKMasstransitSectionMetadata::weight, YMKMasstransitSection::geometry and YMKMasstransitSection::metadata.YMKMasstransitSectionMetadata::data.

## Summary

### Class methods

```swift
 init(metadata: YMKMasstransitSectionMetadata,
      geometry: YMKSubpolyline,
         stops: [YMKMasstransitRouteStop],
      rideLegs: [YMKSubpolyline])
```

### Properties

```swift
var metadata: YMKMasstransitSectionMetadata { get }
```

General information about a section of a route

```swift
var geometry: YMKSubpolyline { get }
```

Geometry of the section as a fragment of a YMKMasstransitRoute polyline

```swift
var stops: [YMKMasstransitRouteStop] { get }
```

Vector of stops along the route

```swift
var rideLegs: [YMKSubpolyline] { get }
```

Vector of polylines each connecting two consecutive stops

## Class methods

### init(metadata:geometry:stops:rideLegs:)

```swift
 init(metadata: YMKMasstransitSectionMetadata,
      geometry: YMKSubpolyline,
         stops: [YMKMasstransitRouteStop],
      rideLegs: [YMKSubpolyline])
```

## Properties

### metadata

```swift
var metadata: YMKMasstransitSectionMetadata { get }
```

General information about a section of a route.

### geometry

```swift
var geometry: YMKSubpolyline { get }
```

Geometry of the section as a fragment of a YMKMasstransitRoute polyline.

### stops

```swift
var stops: [YMKMasstransitRouteStop] { get }
```

Vector of stops along the route. The first stop in the vector is the stop for boarding the transport, and the last stop in the vector is the stop for exiting the transport.

### rideLegs

```swift
var rideLegs: [YMKSubpolyline] { get }
```

Vector of polylines each connecting two consecutive stops. This vector is only filled for mass transit ride sections, so this geometry represents a part of the mass transit thread geometry between two stops.
