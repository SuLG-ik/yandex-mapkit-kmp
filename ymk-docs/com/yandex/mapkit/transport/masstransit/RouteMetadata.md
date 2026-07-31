---
title: "RouteMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteMetadata.html"
---
# RouteMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.RouteMetadata

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class RouteMetadata implements BaseMetadata, Serializable`

Contains information associated with a route constructed by the mass transit router.

## Summary

### Constructors

**Signature and Description**

```java
RouteMetadata()
```

Use constructor with parameters in your code.

```java
RouteMetadata(@NonNull Weight weight,
              @Nullable RouteSettings settings,
              @Nullable TravelEstimation estimation,
              @NonNull java.util.List<WayPoint> wayPoints,
              @Nullable java.lang.String routeId,
              @Nullable Flags flags,
              @NonNull java.util.List<ComfortTag> comfortTags,
              @NonNull StairsSummary stairsSummary,
              @NonNull java.util.List<RoutePaymentOption> paymentOptions,
              @Nullable java.lang.String routeExplanation)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Contains the route time, distance of the walking part, and the number of transfers. |
| `synchronized RouteSettings` | `getSettings()`<br>Route settings that were used by the mass transit router. |
| `synchronized TravelEstimation` | `getEstimation()`<br>Arrival and departure time estimations for time-dependent routes. |
| `synchronized java.util.List<WayPoint>` | `getWayPoints()`<br>List of route waypoints. |
| `synchronized java.lang.String` | `getRouteId()`<br>Unique route id. |
| `synchronized Flags` | `getFlags()`<br>Flags which contains route properties<br>Optional field, can be null. |
| `synchronized java.util.List<ComfortTag>` | `getComfortTags()` |
| `synchronized StairsSummary` | `getStairsSummary()` |
| `synchronized java.util.List<RoutePaymentOption>` | `getPaymentOptions()`<br>List of payment options with prices for the whole route. |
| `synchronized java.lang.String` | `getRouteExplanation()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RouteMetadata

```java
RouteMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RouteMetadata

```java
RouteMetadata(@NonNull Weight weight,
              @Nullable RouteSettings settings,
              @Nullable TravelEstimation estimation,
              @NonNull java.util.List<WayPoint> wayPoints,
              @Nullable java.lang.String routeId,
              @Nullable Flags flags,
              @NonNull java.util.List<ComfortTag> comfortTags,
              @NonNull StairsSummary stairsSummary,
              @NonNull java.util.List<RoutePaymentOption> paymentOptions,
              @Nullable java.lang.String routeExplanation)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Contains the route time, distance of the walking part, and the number of transfers.

### getSettings

```java
@Nullable
RouteSettings getSettings()
```

Route settings that were used by the mass transit router.

Optional field, can be null.

### getEstimation

```java
@Nullable
TravelEstimation getEstimation()
```

Arrival and departure time estimations for time-dependent routes.

Optional field, can be null.

### getWayPoints

```java
@NonNull
java.util.List<WayPoint> getWayPoints()
```

List of route waypoints.

See [mapkit.transport.masstransit.WayPoint](WayPoint.md) for details

### getRouteId

```java
@Nullable
java.lang.String getRouteId()
```

Unique route id.

Optional field, can be null.

### getFlags

```java
@Nullable
Flags getFlags()
```

Flags which contains route properties

Optional field, can be null.

### getComfortTags

```java
@NonNull
java.util.List<ComfortTag> getComfortTags()
```

### getStairsSummary

```java
@NonNull
StairsSummary getStairsSummary()
```

### getPaymentOptions

```java
@NonNull
java.util.List<RoutePaymentOption> getPaymentOptions()
```

List of payment options with prices for the whole route.

### getRouteExplanation

```java
@Nullable
java.lang.String getRouteExplanation()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
