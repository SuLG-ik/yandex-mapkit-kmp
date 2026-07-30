---
title: "YMKDrivingRoute"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoute.html"
---
# YMKDrivingRoute

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRoute : NSObject
```

Driving route. A route consists of multiple sections. Each section has a corresponding annotation that describes the action at the beginning of the section.

## Summary

### Instance methods

```objectivec
- (void)addConditionsListenerWithConditionsListener:
    (nonnull id<YMKDrivingConditionsListener>)conditionsListener;
```

Adds a listener for route condition changes

```objectivec
- (void)removeConditionsListenerWithConditionsListener:
    (nonnull id<YMKDrivingConditionsListener>)conditionsListener;
```

Removes the listener for route condition changes

```objectivec
- (NSUInteger)sectionIndexWithSegmentIndex:(NSUInteger)segmentIndex;
```

Section index

```objectivec
- (nonnull YMKDrivingRouteMetadata *)metadataAtWithPosition:
    (nonnull YMKPolylinePosition *)position;
```

Metadata location

```objectivec
- (void)requestConditionsUpdate;
```

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) NSString *routeId;
```

The ID of the route

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRouteMetadata *metadata;
```

The route metadata

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingSection *> *sections;
```

Manoeuvre-to-Manoeuvre route sections

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Route geometry

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamSegment *> *jamSegments;
```

Traffic conditions on the given route

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingEvent *> *events;
```

Events on the given route

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *speedLimits;
```

Speed limits for segments in the geometry

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleOptions *vehicleOptions;
```

Vehicle options

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingLaneSign *> *laneSigns;
```

Lane signs

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingDirectionSign *> *directionSigns;
```

Direction signs

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRestrictedEntry *> *restrictedEntries;
```

Route restricted entries

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingTrafficLight *> *trafficLights;
```

Route traffic lights

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRestrictedTurn *> *restrictedTurns;
```

Route points with time-dependent restrictions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRailwayCrossing *> *railwayCrossings;
```

Railway crossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingPedestrianCrossing *> *pedestrianCrossings;
```

Pedestrian crossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingSpeedBump *> *speedBumps;
```

Speed bumps

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingCheckpoint *> *checkpoints;
```

Checkpoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRuggedRoad *> *ruggedRoads;
```

Route roads

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingTollRoad *> *tollRoads;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingFordCrossing *> *fordCrossings;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingFerry *> *ferries;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingHighway *> *highways;
```

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingTunnel *> *tunnels;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingZoneCrossing *> *zoneCrossings;
```

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRoadVehicleRestriction *> *roadVehicleRestrictions;
```

Route vehicle restrictions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingManoeuvreVehicleRestriction *>
        *manoeuvreVehicleRestrictions;
```

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *annotationLanguage;
```

Language of string annotations (for example street names) in this route object

```objectivec
@property (nonatomic, readonly, nullable)
    NSArray<YMKRequestPoint *> *requestPoints;
```

Request points that were specified in the router request that this route originated from

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolylinePosition *position;
```

The reached position on the given route

```objectivec
@property (nonatomic, readonly, nonnull) YMKRoutePosition *routePosition;
```

The reached position on the given route

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) NSUInteger legIndex;
```

A leg is a section of the route between two consecutive waypoints

```objectivec
@property (nonatomic, readonly, getter=isAreConditionsOutdated)
    BOOL areConditionsOutdated;
```

Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPolylinePosition *> *wayPoints;
```

Polyline positions of waypoints including start and finish point

## Instance methods

### addConditionsListenerWithConditionsListener:

```objectivec
- (void)addConditionsListenerWithConditionsListener:
    (nonnull id<YMKDrivingConditionsListener>)conditionsListener;
```

Adds a listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeConditionsListenerWithConditionsListener:

```objectivec
- (void)removeConditionsListenerWithConditionsListener:
    (nonnull id<YMKDrivingConditionsListener>)conditionsListener;
```

Removes the listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### sectionIndexWithSegmentIndex:

```objectivec
- (NSUInteger)sectionIndexWithSegmentIndex:(NSUInteger)segmentIndex;
```

Section index.

### metadataAtWithPosition:

```objectivec
- (nonnull YMKDrivingRouteMetadata *)metadataAtWithPosition:
    (nonnull YMKPolylinePosition *)position;
```

Metadata location.

### requestConditionsUpdate

```objectivec
- (void)requestConditionsUpdate;
```

## Properties

### routeId

```objectivec
@property (nonatomic, readonly, nonnull) NSString *routeId;
```

The ID of the route.

### metadata

```objectivec
@property (nonatomic, readonly, nonnull) YMKDrivingRouteMetadata *metadata;
```

The route metadata.

### sections

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingSection *> *sections;
```

Manoeuvre-to-Manoeuvre route sections.

### geometry

```objectivec
@property (nonatomic, readonly, nonnull) YMKPolyline *geometry;
```

Route geometry.

### jamSegments

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKJamSegment *> *jamSegments;
```

Traffic conditions on the given route.

### events

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingEvent *> *events;
```

Events on the given route.

### speedLimits

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<NSNumber *> *speedLimits;
```

Speed limits for segments in the geometry.

### vehicleOptions

```objectivec
@property (nonatomic, readonly, nonnull)
    YMKDrivingVehicleOptions *vehicleOptions;
```

Vehicle options.

### laneSigns

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingLaneSign *> *laneSigns;
```

Lane signs.

### directionSigns

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingDirectionSign *> *directionSigns;
```

Direction signs.

### restrictedEntries

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRestrictedEntry *> *restrictedEntries;
```

Route restricted entries.

### trafficLights

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingTrafficLight *> *trafficLights;
```

Route traffic lights.

### restrictedTurns

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRestrictedTurn *> *restrictedTurns;
```

Route points with time-dependent restrictions.

### railwayCrossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRailwayCrossing *> *railwayCrossings;
```

Railway crossings

### pedestrianCrossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingPedestrianCrossing *> *pedestrianCrossings;
```

Pedestrian crossings

### speedBumps

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingSpeedBump *> *speedBumps;
```

Speed bumps

### checkpoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingCheckpoint *> *checkpoints;
```

Checkpoints

### ruggedRoads

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRuggedRoad *> *ruggedRoads;
```

Route roads.

### tollRoads

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingTollRoad *> *tollRoads;
```

### fordCrossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingFordCrossing *> *fordCrossings;
```

### ferries

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingFerry *> *ferries;
```

### highways

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingHighway *> *highways;
```

### tunnels

```objectivec
@property (nonatomic, readonly, nonnull) NSArray<YMKDrivingTunnel *> *tunnels;
```

### zoneCrossings

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingZoneCrossing *> *zoneCrossings;
```

### roadVehicleRestrictions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingRoadVehicleRestriction *> *roadVehicleRestrictions;
```

Route vehicle restrictions.

### manoeuvreVehicleRestrictions

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKDrivingManoeuvreVehicleRestriction *>
        *manoeuvreVehicleRestrictions;
```

### annotationLanguage

```objectivec
@property (nonatomic, readonly, nullable) NSNumber *annotationLanguage;
```

Language of string annotations (for example street names) in this route object.

Optional property, can be nil.

### requestPoints

```objectivec
@property (nonatomic, readonly, nullable)
    NSArray<YMKRequestPoint *> *requestPoints;
```

Request points that were specified in the router request that this route originated from.

Optional property, can be nil.

### position

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nonnull)
    YMKPolylinePosition *position;
```

The reached position on the given route. The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### routePosition

```objectivec
@property (nonatomic, readonly, nonnull) YMKRoutePosition *routePosition;
```

The reached position on the given route. The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### legIndex

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) NSUInteger legIndex;
```

A leg is a section of the route between two consecutive waypoints.

### areConditionsOutdated

```objectivec
@property (nonatomic, readonly, getter=isAreConditionsOutdated)
    BOOL areConditionsOutdated;
```

Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time.

### wayPoints

```objectivec
@property (nonatomic, readonly, nonnull)
    NSArray<YMKPolylinePosition *> *wayPoints;
```

Polyline positions of waypoints including start and finish point.
