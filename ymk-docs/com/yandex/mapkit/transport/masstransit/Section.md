---
title: "Section"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Section"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Section.html"
---
# Section

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Section.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Section

`class Section implements Serializable`

Contains information about an individual section of a mass transit [mapkit.transport.masstransit.Route](Route.md).

The only fields that are always set are [mapkit.transport.masstransit.Section#metadata](Section.md#metadata).[mapkit.transport.masstransit.SectionMetadata#weight](SectionMetadata.md#weight), [mapkit.transport.masstransit.Section#geometry](Section.md#geometry) and [mapkit.transport.masstransit.Section#metadata](Section.md#metadata).[mapkit.transport.masstransit.SectionMetadata#data](SectionMetadata.md#data).

## Summary

### Constructors

**Signature and Description**

```java
Section()
```

Use constructor with parameters in your code.

```java
Section(@NonNull SectionMetadata metadata,
        @NonNull Subpolyline geometry,
        @NonNull java.util.List<RouteStop> stops,
        @NonNull java.util.List<Subpolyline> rideLegs)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized SectionMetadata` | `getMetadata()`<br>General information about a section of a route. |
| `synchronized Subpolyline` | `getGeometry()`<br>Geometry of the section as a fragment of a [mapkit.transport.masstransit.Route](Route.md) polyline. |
| `synchronized java.util.List<RouteStop>` | `getStops()`<br>Vector of stops along the route. |
| `synchronized java.util.List<Subpolyline>` | `getRideLegs()`<br>Vector of polylines each connecting two consecutive stops. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Section

```java
Section()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Section

```java
Section(@NonNull SectionMetadata metadata,
        @NonNull Subpolyline geometry,
        @NonNull java.util.List<RouteStop> stops,
        @NonNull java.util.List<Subpolyline> rideLegs)
```

## Methods

### getMetadata

```java
@NonNull
SectionMetadata getMetadata()
```

General information about a section of a route.

### getGeometry

```java
@NonNull
Subpolyline getGeometry()
```

Geometry of the section as a fragment of a [mapkit.transport.masstransit.Route](Route.md) polyline.

### getStops

```java
@NonNull
java.util.List<RouteStop> getStops()
```

Vector of stops along the route.

The first stop in the vector is the stop for boarding the transport, and the last stop in the vector is the stop for exiting the transport.

### getRideLegs

```java
@NonNull
java.util.List<Subpolyline> getRideLegs()
```

Vector of polylines each connecting two consecutive stops.

This vector is only filled for mass transit ride sections, so this geometry represents a part of the mass transit thread geometry between two stops.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
