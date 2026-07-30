---
title: "YMKDrivingRoute"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRoute.html"
---
# YMKDrivingRoute

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingRoute : NSObject
```

Driving route. A route consists of multiple sections. Each section has a corresponding annotation that describes the action at the beginning of the section.

## Summary

### Instance methods

```swift
func addConditionsListener(with conditionsListener: any YMKDrivingConditionsListener)
```

Adds a listener for route condition changes

```swift
func removeConditionsListener(with conditionsListener: any YMKDrivingConditionsListener)
```

Removes the listener for route condition changes

```swift
func sectionIndex(withSegmentIndex segmentIndex: UInt) -> UInt
```

Section index

```swift
func metadataAt(with position: YMKPolylinePosition) -> YMKDrivingRouteMetadata
```

Metadata location

```swift
func requestConditionsUpdate()
```

### Properties

```swift
var routeId: String { get }
```

The ID of the route

```swift
var metadata: YMKDrivingRouteMetadata { get }
```

The route metadata

```swift
var sections: [YMKDrivingSection] { get }
```

Manoeuvre-to-Manoeuvre route sections

```swift
var geometry: YMKPolyline { get }
```

Route geometry

```swift
var jamSegments: [YMKJamSegment] { get }
```

Traffic conditions on the given route

```swift
var events: [YMKDrivingEvent] { get }
```

Events on the given route

```swift
var speedLimits: [NSNumber] { get }
```

Speed limits for segments in the geometry

```swift
var vehicleOptions: YMKDrivingVehicleOptions { get }
```

Vehicle options

```swift
var laneSigns: [YMKDrivingLaneSign] { get }
```

Lane signs

```swift
var directionSigns: [YMKDrivingDirectionSign] { get }
```

Direction signs

```swift
var restrictedEntries: [YMKDrivingRestrictedEntry] { get }
```

Route restricted entries

```swift
var trafficLights: [YMKDrivingTrafficLight] { get }
```

Route traffic lights

```swift
var restrictedTurns: [YMKDrivingRestrictedTurn] { get }
```

Route points with time-dependent restrictions

```swift
var railwayCrossings: [YMKDrivingRailwayCrossing] { get }
```

Railway crossings

```swift
var pedestrianCrossings: [YMKDrivingPedestrianCrossing] { get }
```

Pedestrian crossings

```swift
var speedBumps: [YMKDrivingSpeedBump] { get }
```

Speed bumps

```swift
var checkpoints: [YMKDrivingCheckpoint] { get }
```

Checkpoints

```swift
var ruggedRoads: [YMKDrivingRuggedRoad] { get }
```

Route roads

```swift
var tollRoads: [YMKDrivingTollRoad] { get }
```

```swift
var fordCrossings: [YMKDrivingFordCrossing] { get }
```

```swift
var ferries: [YMKDrivingFerry] { get }
```

```swift
var highways: [YMKDrivingHighway] { get }
```

```swift
var tunnels: [YMKDrivingTunnel] { get }
```

```swift
var zoneCrossings: [YMKDrivingZoneCrossing] { get }
```

```swift
var roadVehicleRestrictions: [YMKDrivingRoadVehicleRestriction] { get }
```

Route vehicle restrictions

```swift
var manoeuvreVehicleRestrictions: [YMKDrivingManoeuvreVehicleRestriction] { get }
```

```swift
var annotationLanguage: NSNumber? { get }
```

Language of string annotations (for example street names) in this route object

```swift
var requestPoints: [YMKRequestPoint]? { get }
```

Request points that were specified in the router request that this route originated from

```swift
var position: YMKPolylinePosition { get set }
```

The reached position on the given route

```swift
var routePosition: YMKRoutePosition { get }
```

The reached position on the given route

```swift
var legIndex: UInt { get set }
```

A leg is a section of the route between two consecutive waypoints

```swift
var isAreConditionsOutdated: Bool { get }
```

Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time

```swift
var wayPoints: [YMKPolylinePosition] { get }
```

Polyline positions of waypoints including start and finish point

## Instance methods

### addConditionsListener(with:)

```swift
func addConditionsListener(with conditionsListener: any YMKDrivingConditionsListener)
```

Adds a listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeConditionsListener(with:)

```swift
func removeConditionsListener(with conditionsListener: any YMKDrivingConditionsListener)
```

Removes the listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### sectionIndex(withSegmentIndex:)

```swift
func sectionIndex(withSegmentIndex segmentIndex: UInt) -> UInt
```

Section index.

### metadataAt(with:)

```swift
func metadataAt(with position: YMKPolylinePosition) -> YMKDrivingRouteMetadata
```

Metadata location.

### requestConditionsUpdate()

```swift
func requestConditionsUpdate()
```

## Properties

### routeId

```swift
var routeId: String { get }
```

The ID of the route.

### metadata

```swift
var metadata: YMKDrivingRouteMetadata { get }
```

The route metadata.

### sections

```swift
var sections: [YMKDrivingSection] { get }
```

Manoeuvre-to-Manoeuvre route sections.

### geometry

```swift
var geometry: YMKPolyline { get }
```

Route geometry.

### jamSegments

```swift
var jamSegments: [YMKJamSegment] { get }
```

Traffic conditions on the given route.

### events

```swift
var events: [YMKDrivingEvent] { get }
```

Events on the given route.

### speedLimits

```swift
var speedLimits: [NSNumber] { get }
```

Speed limits for segments in the geometry.

### vehicleOptions

```swift
var vehicleOptions: YMKDrivingVehicleOptions { get }
```

Vehicle options.

### laneSigns

```swift
var laneSigns: [YMKDrivingLaneSign] { get }
```

Lane signs.

### directionSigns

```swift
var directionSigns: [YMKDrivingDirectionSign] { get }
```

Direction signs.

### restrictedEntries

```swift
var restrictedEntries: [YMKDrivingRestrictedEntry] { get }
```

Route restricted entries.

### trafficLights

```swift
var trafficLights: [YMKDrivingTrafficLight] { get }
```

Route traffic lights.

### restrictedTurns

```swift
var restrictedTurns: [YMKDrivingRestrictedTurn] { get }
```

Route points with time-dependent restrictions.

### railwayCrossings

```swift
var railwayCrossings: [YMKDrivingRailwayCrossing] { get }
```

Railway crossings

### pedestrianCrossings

```swift
var pedestrianCrossings: [YMKDrivingPedestrianCrossing] { get }
```

Pedestrian crossings

### speedBumps

```swift
var speedBumps: [YMKDrivingSpeedBump] { get }
```

Speed bumps

### checkpoints

```swift
var checkpoints: [YMKDrivingCheckpoint] { get }
```

Checkpoints

### ruggedRoads

```swift
var ruggedRoads: [YMKDrivingRuggedRoad] { get }
```

Route roads.

### tollRoads

```swift
var tollRoads: [YMKDrivingTollRoad] { get }
```

### fordCrossings

```swift
var fordCrossings: [YMKDrivingFordCrossing] { get }
```

### ferries

```swift
var ferries: [YMKDrivingFerry] { get }
```

### highways

```swift
var highways: [YMKDrivingHighway] { get }
```

### tunnels

```swift
var tunnels: [YMKDrivingTunnel] { get }
```

### zoneCrossings

```swift
var zoneCrossings: [YMKDrivingZoneCrossing] { get }
```

### roadVehicleRestrictions

```swift
var roadVehicleRestrictions: [YMKDrivingRoadVehicleRestriction] { get }
```

Route vehicle restrictions.

### manoeuvreVehicleRestrictions

```swift
var manoeuvreVehicleRestrictions: [YMKDrivingManoeuvreVehicleRestriction] { get }
```

### annotationLanguage

```swift
var annotationLanguage: NSNumber? { get }
```

Language of string annotations (for example street names) in this route object.

Optional property, can be nil.

### requestPoints

```swift
var requestPoints: [YMKRequestPoint]? { get }
```

Request points that were specified in the router request that this route originated from.

Optional property, can be nil.

### position

```swift
var position: YMKPolylinePosition { get set }
```

The reached position on the given route. The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### routePosition

```swift
var routePosition: YMKRoutePosition { get }
```

The reached position on the given route. The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### legIndex

```swift
var legIndex: UInt { get set }
```

A leg is a section of the route between two consecutive waypoints.

### isAreConditionsOutdated

```swift
var isAreConditionsOutdated: Bool { get }
```

Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time.

### wayPoints

```swift
var wayPoints: [YMKPolylinePosition] { get }
```

Polyline positions of waypoints including start and finish point.
