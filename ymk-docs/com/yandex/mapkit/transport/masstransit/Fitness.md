---
title: "Fitness"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Fitness"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Fitness.html"
---
# Fitness

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Fitness.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Fitness

`class Fitness implements Serializable`

Represent a section where we have to move by ourself (like pedestrian, or by bicycle and scooter)

## Summary

### Constructors

**Signature and Description**

```java
Fitness()
```

Use constructor with parameters in your code.

```java
Fitness(@NonNull FitnessType type,
        @NonNull java.util.List<ConstructionSegment> constructions,
        @NonNull java.util.List<RestrictedEntry> restrictedEntries,
        @NonNull java.util.List<PolylinePosition> viaPoints,
        @NonNull java.util.List<Annotation> annotations,
        @NonNull java.util.List<TrafficTypeSegment> trafficTypes,
        @Nullable ElevationData elevationData,
        @NonNull java.util.List<IndoorSegment> indoorSegments)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized FitnessType` | `getType()` |
| `synchronized java.util.List<ConstructionSegment>` | `getConstructions()`<br>Compressed information about constructions along the path. |
| `synchronized java.util.List<RestrictedEntry>` | `getRestrictedEntries()`<br>List of restricted entries with their coordinates along the path. |
| `synchronized java.util.List<PolylinePosition>` | `getViaPoints()`<br>List of via points on the path. |
| `synchronized java.util.List<Annotation>` | `getAnnotations()`<br>List of annotations on the path. |
| `synchronized java.util.List<TrafficTypeSegment>` | `getTrafficTypes()`<br>List of traffic types on path |
| `synchronized ElevationData` | `getElevationData()`<br>Information on elevation gain and loss in a fitness section<br>Optional field, can be null. |
| `synchronized java.util.List<IndoorSegment>` | `getIndoorSegments()`<br>List of indoor segments (levels or connectors) on path. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Fitness

```java
Fitness()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Fitness

```java
Fitness(@NonNull FitnessType type,
        @NonNull java.util.List<ConstructionSegment> constructions,
        @NonNull java.util.List<RestrictedEntry> restrictedEntries,
        @NonNull java.util.List<PolylinePosition> viaPoints,
        @NonNull java.util.List<Annotation> annotations,
        @NonNull java.util.List<TrafficTypeSegment> trafficTypes,
        @Nullable ElevationData elevationData,
        @NonNull java.util.List<IndoorSegment> indoorSegments)
```

## Methods

### getType

```java
@NonNull
FitnessType getType()
```

### getConstructions

```java
@NonNull
java.util.List<ConstructionSegment> getConstructions()
```

Compressed information about constructions along the path.

[mapkit.transport.masstransit.ConstructionSegment#subpolyline](ConstructionSegment.md#subpolyline) fields of all segments cover the entire geometry of corresponding section".

### getRestrictedEntries

```java
@NonNull
java.util.List<RestrictedEntry> getRestrictedEntries()
```

List of restricted entries with their coordinates along the path.

### getViaPoints

```java
@NonNull
java.util.List<PolylinePosition> getViaPoints()
```

List of via points on the path.

A via point is described by the index of the point in the route geometry polyline.

### getAnnotations

```java
@NonNull
java.util.List<Annotation> getAnnotations()
```

List of annotations on the path.

### getTrafficTypes

```java
@NonNull
java.util.List<TrafficTypeSegment> getTrafficTypes()
```

List of traffic types on path

### getElevationData

```java
@Nullable
ElevationData getElevationData()
```

Information on elevation gain and loss in a fitness section

Optional field, can be null.

### getIndoorSegments

```java
@NonNull
java.util.List<IndoorSegment> getIndoorSegments()
```

List of indoor segments (levels or connectors) on path.

Compressed information about levels along the path. [mapkit.transport.masstransit.IndoorSegment#subpolyline](IndoorSegment.md#subpolyline) fields of all indoor segments cover only the indoor geometry, it does not cover outdoor parts.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
