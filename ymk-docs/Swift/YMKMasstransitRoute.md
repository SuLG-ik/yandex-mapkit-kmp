---
title: "YMKMasstransitRoute"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRoute.html"
---
# YMKMasstransitRoute

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRoute : NSObject
```

Contains information about a route constructed by the mass transit router.

## Summary

### Instance methods

```swift
func distanceBetweenPolylinePositionsWith(from: YMKPolylinePosition,
                                            to: YMKPolylinePosition) -> Double
```

Return distance between two polyline positions

```swift
func timeBetweenPolylinePositionsWith(from: YMKPolylinePosition,
                                        to: YMKPolylinePosition) -> Double
```

Return travel time between two polyline positions

### Properties

```swift
var metadata: YMKMasstransitRouteMetadata { get }
```

General route information

```swift
var wayPoints: [YMKMasstransitWayPoint] { get }
```

List of route waypoints

```swift
var sections: [YMKMasstransitSection] { get }
```

Vector of sections of the route

```swift
var geometry: YMKPolyline { get }
```

Polyline of the entire route

```swift
var uriMetadata: YMKUriObjectMetadata { get }
```

Route URI, which can be used with YMKMasstransitRouter to fetch additional information about the route or can be bookmarked for future reference

## Instance methods

### distanceBetweenPolylinePositionsWith(from:to:)

```swift
func distanceBetweenPolylinePositionsWith(from: YMKPolylinePosition,
                                            to: YMKPolylinePosition) -> Double
```

Return distance between two polyline positions.

### timeBetweenPolylinePositionsWith(from:to:)

```swift
func timeBetweenPolylinePositionsWith(from: YMKPolylinePosition,
                                        to: YMKPolylinePosition) -> Double
```

Return travel time between two polyline positions.

## Properties

### metadata

```swift
var metadata: YMKMasstransitRouteMetadata { get }
```

General route information.

### wayPoints

```swift
var wayPoints: [YMKMasstransitWayPoint] { get }
```

List of route waypoints. See YMKMasstransitWayPoint for details

### sections

```swift
var sections: [YMKMasstransitSection] { get }
```

Vector of sections of the route.

### geometry

```swift
var geometry: YMKPolyline { get }
```

Polyline of the entire route.

### uriMetadata

```swift
var uriMetadata: YMKUriObjectMetadata { get }
```

Route URI, which can be used with YMKMasstransitRouter to fetch additional information about the route or can be bookmarked for future reference.
