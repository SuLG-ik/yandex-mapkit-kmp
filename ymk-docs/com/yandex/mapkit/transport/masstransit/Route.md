---
title: "Route"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Route"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Route.html"
---
# Route

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Route.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface Route`

Contains information about a route constructed by the mass transit router.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `RouteMetadata` | `getMetadata()`<br>General route information. |
| `java.util.List<WayPoint>` | `getWayPoints()`<br>List of route waypoints. |
| `java.util.List<Section>` | `getSections()`<br>Vector of sections of the route. |
| `Polyline` | `getGeometry()`<br>Polyline of the entire route. |
| `UriObjectMetadata` | `getUriMetadata()`<br>Route URI, which can be used with [mapkit.transport.masstransit.MasstransitRouter](MasstransitRouter.md) to fetch additional information about the route or can be bookmarked for future reference. |
| `double` | `distanceBetweenPolylinePositions(@NonNull PolylinePosition from, @NonNull PolylinePosition to)`<br>Return distance between two polyline positions. |
| `double` | `timeBetweenPolylinePositions(@NonNull PolylinePosition from, @NonNull PolylinePosition to)`<br>Return travel time between two polyline positions. |

## Methods

### getMetadata

```java
@NonNull
RouteMetadata getMetadata()
```

General route information.

### getWayPoints

```java
@NonNull
java.util.List<WayPoint> getWayPoints()
```

List of route waypoints.

See [mapkit.transport.masstransit.WayPoint](WayPoint.md) for details

### getSections

```java
@NonNull
java.util.List<Section> getSections()
```

Vector of sections of the route.

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

Polyline of the entire route.

### getUriMetadata

```java
@NonNull
UriObjectMetadata getUriMetadata()
```

Route URI, which can be used with [mapkit.transport.masstransit.MasstransitRouter](MasstransitRouter.md) to fetch additional information about the route or can be bookmarked for future reference.

### distanceBetweenPolylinePositions

```java
double distanceBetweenPolylinePositions(@NonNull PolylinePosition from,
                                        @NonNull PolylinePosition to)
```

Return distance between two polyline positions.

### timeBetweenPolylinePositions

```java
double timeBetweenPolylinePositions(@NonNull PolylinePosition from,
                                    @NonNull PolylinePosition to)
```

Return travel time between two polyline positions.
