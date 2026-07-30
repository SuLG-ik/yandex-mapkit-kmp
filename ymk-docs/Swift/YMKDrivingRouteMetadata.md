---
title: "YMKDrivingRouteMetadata"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingRouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouteMetadata.html"
---
# YMKDrivingRouteMetadata

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingRouteMetadata : NSObject, YMKBaseMetadata
```

Information about driving route metadata.

## Summary

### Class methods

```swift
 init(weight: YMKDrivingWeight,
       flags: YMKDrivingFlags,
 routePoints: [YMKDrivingRoutePoint],
         uri: String?,
 nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures?)
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
var routePoints: [YMKDrivingRoutePoint] { get }
```

Route points

```swift
var uri: String? { get }
```

Route URI

Optional field, can be nil

```swift
var nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures? { get }
```

Route features that cannot be avoided

Optional field, can be nil

## Class methods

### init(weight:flags:routePoints:uri:nonAvoidedFeatures:)

```swift
 init(weight: YMKDrivingWeight,
       flags: YMKDrivingFlags,
 routePoints: [YMKDrivingRoutePoint],
         uri: String?,
 nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures?)
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

### routePoints

```swift
var routePoints: [YMKDrivingRoutePoint] { get }
```

Route points. In addition to point coordinates each route point may have a selected arrival point

### uri

```swift
var uri: String? { get }
```

Route URI

Optional field, can be nil.

### nonAvoidedFeatures

```swift
var nonAvoidedFeatures: YMKDrivingNonAvoidedFeatures? { get }
```

Route features that cannot be avoided

Optional field, can be nil.
