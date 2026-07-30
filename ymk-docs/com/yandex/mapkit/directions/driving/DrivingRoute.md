---
title: "DrivingRoute"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingRoute"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRoute.html"
---
# DrivingRoute

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRoute.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`interface DrivingRoute`

Driving route.

A route consists of multiple sections. Each section has a corresponding annotation that describes the action at the beginning of the section.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getRouteId()`<br>The ID of the route. |
| `DrivingRouteMetadata` | `getMetadata()`<br>The route metadata. |
| `java.util.List<DrivingSection>` | `getSections()`<br>Manoeuvre-to-Manoeuvre route sections. |
| `Polyline` | `getGeometry()`<br>Route geometry. |
| `java.util.List<JamSegment>` | `getJamSegments()`<br>Traffic conditions on the given route. |
| `java.util.List<Event>` | `getEvents()`<br>Events on the given route. |
| `java.util.List<java.lang.Float>` | `getSpeedLimits()`<br>Speed limits for segments in the geometry. |
| `VehicleOptions` | `getVehicleOptions()`<br>Vehicle options. |
| `java.util.List<LaneSign>` | `getLaneSigns()`<br>Lane signs. |
| `java.util.List<DirectionSign>` | `getDirectionSigns()`<br>Direction signs. |
| `java.util.List<RestrictedEntry>` | `getRestrictedEntries()`<br>Route restricted entries. |
| `java.util.List<TrafficLight>` | `getTrafficLights()`<br>Route traffic lights. |
| `java.util.List<RestrictedTurn>` | `getRestrictedTurns()`<br>Route points with time-dependent restrictions. |
| `java.util.List<RailwayCrossing>` | `getRailwayCrossings()`<br>Railway crossings |
| `java.util.List<PedestrianCrossing>` | `getPedestrianCrossings()`<br>Pedestrian crossings |
| `java.util.List<SpeedBump>` | `getSpeedBumps()`<br>Speed bumps |
| `java.util.List<Checkpoint>` | `getCheckpoints()`<br>Checkpoints |
| `java.util.List<RuggedRoad>` | `getRuggedRoads()`<br>Route roads. |
| `java.util.List<TollRoad>` | `getTollRoads()` |
| `java.util.List<FordCrossing>` | `getFordCrossings()` |
| `java.util.List<Ferry>` | `getFerries()` |
| `java.util.List<Highway>` | `getHighways()` |
| `java.util.List<Tunnel>` | `getTunnels()` |
| `java.util.List<ZoneCrossing>` | `getZoneCrossings()` |
| `java.util.List<RoadVehicleRestriction>` | `getRoadVehicleRestrictions()`<br>Route vehicle restrictions. |
| `java.util.List<ManoeuvreVehicleRestriction>` | `getManoeuvreVehicleRestrictions()` |
| `AnnotationLanguage` | `getAnnotationLanguage()`<br>Language of string annotations (for example street names) in this route object. |
| `java.util.List<RequestPoint>` | `getRequestPoints()`<br>Request points that were specified in the router request that this route originated from. |
| `PolylinePosition` | `getPosition()`<br>The reached position on the given route. |
| `void` | `setPosition(@NonNull PolylinePosition position)` |
| `RoutePosition` | `getRoutePosition()`<br>The reached position on the given route. |
| `int` | `getLegIndex()`<br>A leg is a section of the route between two consecutive waypoints. |
| `void` | `setLegIndex(int legIndex)` |
| `boolean` | `isAreConditionsOutdated()`<br>Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time. |
| `void` | `addConditionsListener(@NonNull ConditionsListener conditionsListener)`<br>Adds a listener for route condition changes. |
| `void` | `removeConditionsListener(@NonNull ConditionsListener conditionsListener)`<br>Removes the listener for route condition changes. |
| `int` | `sectionIndex(int segmentIndex)`<br>Section index. |
| `DrivingRouteMetadata` | `metadataAt(@NonNull PolylinePosition position)`<br>Metadata location. |
| `java.util.List<PolylinePosition>` | `getWayPoints()`<br>Polyline positions of waypoints including start and finish point. |
| `void` | `requestConditionsUpdate()` |

## Methods

### getRouteId

```java
@NonNull
java.lang.String getRouteId()
```

The ID of the route.

### getMetadata

```java
@NonNull
DrivingRouteMetadata getMetadata()
```

The route metadata.

### getSections

```java
@NonNull
java.util.List<DrivingSection> getSections()
```

Manoeuvre-to-Manoeuvre route sections.

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

Route geometry.

### getJamSegments

```java
@NonNull
java.util.List<JamSegment> getJamSegments()
```

Traffic conditions on the given route.

### getEvents

```java
@NonNull
java.util.List<Event> getEvents()
```

Events on the given route.

### getSpeedLimits

```java
@NonNull
java.util.List<java.lang.Float> getSpeedLimits()
```

Speed limits for segments in the geometry.

### getVehicleOptions

```java
@NonNull
VehicleOptions getVehicleOptions()
```

Vehicle options.

### getLaneSigns

```java
@NonNull
java.util.List<LaneSign> getLaneSigns()
```

Lane signs.

### getDirectionSigns

```java
@NonNull
java.util.List<DirectionSign> getDirectionSigns()
```

Direction signs.

### getRestrictedEntries

```java
@NonNull
java.util.List<RestrictedEntry> getRestrictedEntries()
```

Route restricted entries.

### getTrafficLights

```java
@NonNull
java.util.List<TrafficLight> getTrafficLights()
```

Route traffic lights.

### getRestrictedTurns

```java
@NonNull
java.util.List<RestrictedTurn> getRestrictedTurns()
```

Route points with time-dependent restrictions.

### getRailwayCrossings

```java
@NonNull
java.util.List<RailwayCrossing> getRailwayCrossings()
```

Railway crossings

### getPedestrianCrossings

```java
@NonNull
java.util.List<PedestrianCrossing> getPedestrianCrossings()
```

Pedestrian crossings

### getSpeedBumps

```java
@NonNull
java.util.List<SpeedBump> getSpeedBumps()
```

Speed bumps

### getCheckpoints

```java
@NonNull
java.util.List<Checkpoint> getCheckpoints()
```

Checkpoints

### getRuggedRoads

```java
@NonNull
java.util.List<RuggedRoad> getRuggedRoads()
```

Route roads.

### getTollRoads

```java
@NonNull
java.util.List<TollRoad> getTollRoads()
```

### getFordCrossings

```java
@NonNull
java.util.List<FordCrossing> getFordCrossings()
```

### getFerries

```java
@NonNull
java.util.List<Ferry> getFerries()
```

### getHighways

```java
@NonNull
java.util.List<Highway> getHighways()
```

### getTunnels

```java
@NonNull
java.util.List<Tunnel> getTunnels()
```

### getZoneCrossings

```java
@NonNull
java.util.List<ZoneCrossing> getZoneCrossings()
```

### getRoadVehicleRestrictions

```java
@NonNull
java.util.List<RoadVehicleRestriction> getRoadVehicleRestrictions()
```

Route vehicle restrictions.

### getManoeuvreVehicleRestrictions

```java
@NonNull
java.util.List<ManoeuvreVehicleRestriction> getManoeuvreVehicleRestrictions()
```

### getAnnotationLanguage

```java
@Nullable
AnnotationLanguage getAnnotationLanguage()
```

Language of string annotations (for example street names) in this route object.

Optional property, can be null.

### getRequestPoints

```java
@Nullable
java.util.List<RequestPoint> getRequestPoints()
```

Request points that were specified in the router request that this route originated from.

Optional property, can be null.

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The reached position on the given route.

The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### setPosition

```java
void setPosition(@NonNull PolylinePosition position)
```

### getRoutePosition

```java
@NonNull
RoutePosition getRoutePosition()
```

The reached position on the given route.

The 'RouteMetadata::weight' field contains data for the part of the route beyond this position.

### getLegIndex

```java
int getLegIndex()
```

A leg is a section of the route between two consecutive waypoints.

### setLegIndex

```java
void setLegIndex(int legIndex)
```

### isAreConditionsOutdated

```java
boolean isAreConditionsOutdated()
```

Indicates whether driving conditions (jamSegments and events) have become outdated when we are not able to fetch updates for some predefined time.

### addConditionsListener

```java
void addConditionsListener(@NonNull ConditionsListener conditionsListener)
```

Adds a listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeConditionsListener

```java
void removeConditionsListener(@NonNull ConditionsListener conditionsListener)
```

Removes the listener for route condition changes.

The class does not retain the object in the 'conditionsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### sectionIndex

```java
int sectionIndex(int segmentIndex)
```

Section index.

### metadataAt

```java
@NonNull
DrivingRouteMetadata metadataAt(@NonNull PolylinePosition position)
```

Metadata location.

### getWayPoints

```java
@NonNull
java.util.List<PolylinePosition> getWayPoints()
```

Polyline positions of waypoints including start and finish point.

### requestConditionsUpdate

```java
void requestConditionsUpdate()
```
