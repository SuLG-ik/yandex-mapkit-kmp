---
title: "TransportThread"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Transport_TransportThread"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transport_TransportThread.html"
---
# TransportThread

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Transport_TransportThread.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Transport.TransportThread

`static class TransportThread implements Serializable`

[mapkit.transport.masstransit.Thread](Thread.md) specific properties of a mass transit ride section of a [mapkit.transport.masstransit.Route](Route.md).

## Summary

### Constructors

**Signature and Description**

```java
TransportThread()
```

Use constructor with parameters in your code.

```java
TransportThread(@NonNull Thread thread,
                boolean isRecommended,
                @NonNull java.util.List<TransportThreadAlert> alerts,
                @Nullable Stop alternateDepartureStop,
                @Nullable BoardingOptions boardingOptions,
                @NonNull DropOffOptions dropOffOptions,
                @Nullable TravelEstimation estimation,
                @NonNull java.util.List<TransportStop> stops,
                @NonNull Polyline geometry)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Thread` | `getThread()`<br>Mass transit thread. |
| `synchronized boolean` | `getIsRecommended()`<br>Indicates that the mass transit router considers this thread the best one for the current section of the constucted route. |
| `synchronized java.util.List<TransportThreadAlert>` | `getAlerts()`<br>Collection of important annotations for the section. |
| `synchronized Stop` | `getAlternateDepartureStop()`<br>If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section. |
| `synchronized BoardingOptions` | `getBoardingOptions()`<br>Recommended underground or railway boarding options for this section. |
| `synchronized DropOffOptions` | `getDropOffOptions()`<br>Railway drop-off options for this section. |
| `synchronized TravelEstimation` | `getEstimation()`<br>Time estimation for transport thread. |
| `synchronized java.util.List<TransportStop>` | `getStops()`<br>Collection of stops for the section. |
| `synchronized Polyline` | `getGeometry()`<br>Transport thread geometry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### TransportThread

```java
TransportThread()
```

Use constructor with parameters in your code.

This one is for serialization only!

### TransportThread

```java
TransportThread(@NonNull Thread thread,
                boolean isRecommended,
                @NonNull java.util.List<TransportThreadAlert> alerts,
                @Nullable Stop alternateDepartureStop,
                @Nullable BoardingOptions boardingOptions,
                @NonNull DropOffOptions dropOffOptions,
                @Nullable TravelEstimation estimation,
                @NonNull java.util.List<TransportStop> stops,
                @NonNull Polyline geometry)
```

## Methods

### getThread

```java
@NonNull
Thread getThread()
```

Mass transit thread.

### getIsRecommended

```java
boolean getIsRecommended()
```

Indicates that the mass transit router considers this thread the best one for the current section of the constucted route.

### getAlerts

```java
@NonNull
java.util.List<TransportThreadAlert> getAlerts()
```

Collection of important annotations for the section.

### getAlternateDepartureStop

```java
@Nullable
Stop getAlternateDepartureStop()
```

If alternateDepartureStop is specified, it specifies the departure location for this particular Thread instead of the first Stop of the Section.

Optional field, can be null.

### getBoardingOptions

```java
@Nullable
BoardingOptions getBoardingOptions()
```

Recommended underground or railway boarding options for this section.

Optional field, can be null.

### getDropOffOptions

```java
@NonNull
DropOffOptions getDropOffOptions()
```

Railway drop-off options for this section.

### getEstimation

```java
@Nullable
TravelEstimation getEstimation()
```

Time estimation for transport thread.

Optional field, can be null.

### getStops

```java
@NonNull
java.util.List<TransportStop> getStops()
```

Collection of stops for the section.

The first stop in the collection is the stop for boarding the transport, and the last stop in the collection is the stop for exiting the transport.

### getGeometry

```java
@NonNull
Polyline getGeometry()
```

Transport thread geometry.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
