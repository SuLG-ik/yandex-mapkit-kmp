---
title: "YMKBicycleRoute"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRoute.html"
---
# YMKBicycleRoute

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleRoute : NSObject
```

Bicycle route.

## Summary

### Properties

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route

```swift
var sections: [YMKBicycleSection] { get }
```

Sections of the route

```swift
var legs: [YMKBicycleLeg] { get }
```

Legs of the route

```swift
var geometry: YMKPolyline { get }
```

Polyline with geometry of the route

```swift
var flags: YMKBicycleFlags? { get }
```

Specific properties of the route

```swift
var constructions: [YMKBicycleConstructionSegment] { get }
```

List of specific constructions along the bicycle path, such as stairs or crossings

```swift
var trafficTypes: [YMKBicycleTrafficTypeSegment] { get }
```

List of traffic types (YMKBicycleTrafficTypeID) along the path

```swift
var restrictedEntries: [YMKBicycleRestrictedEntry] { get }
```

List of restricted entries with their positions along the path

```swift
var viaPoints: [YMKBicycleViaPoint] { get }
```

List of via points on the path

```swift
var wayPoints: [YMKBicycleWayPoint] { get }
```

List of waypoints on the route

```swift
var uriMetadata: YMKUriObjectMetadata { get }
```

Route URI, which can be used with YMKBicycleRouter to fetch additional information about the route or can be bookmarked for future reference

```swift
var routeId: String? { get }
```

Unique route id

## Properties

### weight

```swift
var weight: YMKBicycleWeight { get }
```

Quantitative characteristics of the route.

### sections

```swift
var sections: [YMKBicycleSection] { get }
```

Sections of the route.

### legs

```swift
var legs: [YMKBicycleLeg] { get }
```

Legs of the route.

### geometry

```swift
var geometry: YMKPolyline { get }
```

Polyline with geometry of the route.

### flags

```swift
var flags: YMKBicycleFlags? { get }
```

Specific properties of the route.

Optional property, can be nil.

### constructions

```swift
var constructions: [YMKBicycleConstructionSegment] { get }
```

List of specific constructions along the bicycle path, such as stairs or crossings. See YMKBicycleConstructionID for a complete list of constructions. YMKBicycleConstructionSegment::subpolyline fields of all segments cover the entire YMKBicycleRoute::geometry.

### trafficTypes

```swift
var trafficTypes: [YMKBicycleTrafficTypeSegment] { get }
```

List of traffic types (YMKBicycleTrafficTypeID) along the path. Traffic type for an edge means who the road is designed for, such as pedestrians or cyclists. See YMKBicycleTrafficTypeID for a complete list of types. Fields YMKBicycleTrafficTypeSegment::subpolyline of all segments cover whole YMKBicycleRoute::geometry

### restrictedEntries

```swift
var restrictedEntries: [YMKBicycleRestrictedEntry] { get }
```

List of restricted entries with their positions along the path.

### viaPoints

```swift
var viaPoints: [YMKBicycleViaPoint] { get }
```

List of via points on the path. See YMKBicycleViaPoint for details

### wayPoints

```swift
var wayPoints: [YMKBicycleWayPoint] { get }
```

List of waypoints on the route. See YMKBicycleWayPoint for details.

### uriMetadata

```swift
var uriMetadata: YMKUriObjectMetadata { get }
```

Route URI, which can be used with YMKBicycleRouter to fetch additional information about the route or can be bookmarked for future reference.

### routeId

```swift
var routeId: String? { get }
```

Unique route id.

Optional property, can be nil.
