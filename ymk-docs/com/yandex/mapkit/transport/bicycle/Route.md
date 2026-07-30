---
title: "Route"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Route"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Route.html"
---
# Route

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Route.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

`interface Route`

Bicycle route.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Weight` | `getWeight()`<br>Quantitative characteristics of the route. |
| `java.util.List<Section>` | `getSections()`<br>Sections of the route. |
| `java.util.List<Leg>` | `getLegs()`<br>Legs of the route. |
| `Polyline` | `getGeometry()`<br>Polyline with geometry of the route. |
| `Flags` | `getFlags()`<br>Specific properties of the route. |
| `java.util.List<ConstructionSegment>` | `getConstructions()`<br>List of specific constructions along the bicycle path, such as stairs or crossings. |
| `java.util.List<TrafficTypeSegment>` | `getTrafficTypes()`<br>List of traffic types ([mapkit.transport.bicycle.TrafficTypeID](TrafficTypeID.md)) along the path. |
| `java.util.List<RestrictedEntry>` | `getRestrictedEntries()`<br>List of restricted entries with their positions along the path. |
| `java.util.List<ViaPoint>` | `getViaPoints()`<br>List of via points on the path. |
| `java.util.List<WayPoint>` | `getWayPoints()`<br>List of waypoints on the route. |
| `UriObjectMetadata` | `getUriMetadata()`<br>Route URI, which can be used with [mapkit.transport.bicycle.BicycleRouter](BicycleRouter.md) to fetch additional information about the route or can be bookmarked for future reference. |
| `java.lang.String` | `getRouteId()`<br>Unique route id. |

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Quantitative characteristics of the route.

### getSections

```java
@NonNull
java.util.List<Section> getSections()
```

Sections of the route.

### getLegs

```java
@NonNull
java.util.List<Leg> getLegs()
```

Legs of the route.

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

Polyline with geometry of the route.

### getFlags

```java
@Nullable
Flags getFlags()
```

Specific properties of the route.

Optional property, can be null.

### getConstructions

```java
@NonNull
java.util.List<ConstructionSegment> getConstructions()
```

List of specific constructions along the bicycle path, such as stairs or crossings.

See [mapkit.transport.bicycle.ConstructionID](ConstructionID.md) for a complete list of constructions. [mapkit.transport.bicycle.ConstructionSegment#subpolyline](ConstructionSegment.md#subpolyline) fields of all segments cover the entire [mapkit.transport.bicycle.Route#geometry](Route.md#geometry).

### getTrafficTypes

```java
@NonNull
java.util.List<TrafficTypeSegment> getTrafficTypes()
```

List of traffic types ([mapkit.transport.bicycle.TrafficTypeID](TrafficTypeID.md)) along the path.

Traffic type for an edge means who the road is designed for,  such as pedestrians or cyclists. See [mapkit.transport.bicycle.TrafficTypeID](TrafficTypeID.md) for a complete list of types. Fields [mapkit.transport.bicycle.TrafficTypeSegment#subpolyline](TrafficTypeSegment.md#subpolyline) of all segments cover whole [mapkit.transport.bicycle.Route#geometry](Route.md#geometry)

### getRestrictedEntries

```java
@NonNull
java.util.List<RestrictedEntry> getRestrictedEntries()
```

List of restricted entries with their positions along the path.

### getViaPoints

```java
@NonNull
java.util.List<ViaPoint> getViaPoints()
```

List of via points on the path.

See [mapkit.transport.bicycle.ViaPoint](ViaPoint.md) for details

### getWayPoints

```java
@NonNull
java.util.List<WayPoint> getWayPoints()
```

List of waypoints on the route.

See [mapkit.transport.bicycle.WayPoint](WayPoint.md) for details.

### getUriMetadata

```java
@NonNull
UriObjectMetadata getUriMetadata()
```

Route URI, which can be used with [mapkit.transport.bicycle.BicycleRouter](BicycleRouter.md) to fetch additional information about the route or can be bookmarked for future reference.

### getRouteId

```java
@Nullable
java.lang.String getRouteId()
```

Unique route id.

Optional property, can be null.
