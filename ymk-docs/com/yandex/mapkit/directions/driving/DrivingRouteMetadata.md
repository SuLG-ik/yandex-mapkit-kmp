---
title: "DrivingRouteMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingRouteMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouteMetadata.html"
---
# DrivingRouteMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouteMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DrivingRouteMetadata

## All Superinterfaces:

*[BaseMetadata](../../BaseMetadata.md)*

`class DrivingRouteMetadata implements BaseMetadata, Serializable`

Information about driving route metadata.

## Summary

### Constructors

**Signature and Description**

```java
DrivingRouteMetadata()
```

Use constructor with parameters in your code.

```java
DrivingRouteMetadata(@NonNull Weight weight,
                     @NonNull Flags flags,
                     @NonNull java.util.List<RoutePoint> routePoints,
                     @Nullable java.lang.String uri,
                     @Nullable NonAvoidedFeatures nonAvoidedFeatures)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Route "weight". |
| `synchronized Flags` | `getFlags()`<br>Overall route characteristics. |
| `synchronized java.util.List<RoutePoint>` | `getRoutePoints()`<br>Route points. |
| `synchronized java.lang.String` | `getUri()`<br>Route URI<br>Optional field, can be null. |
| `synchronized NonAvoidedFeatures` | `getNonAvoidedFeatures()`<br>Route features that cannot be avoided<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### DrivingRouteMetadata

```java
DrivingRouteMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### DrivingRouteMetadata

```java
DrivingRouteMetadata(@NonNull Weight weight,
                     @NonNull Flags flags,
                     @NonNull java.util.List<RoutePoint> routePoints,
                     @Nullable java.lang.String uri,
                     @Nullable NonAvoidedFeatures nonAvoidedFeatures)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Route "weight".

### getFlags

```java
@NonNull
Flags getFlags()
```

Overall route characteristics.

### getRoutePoints

```java
@NonNull
java.util.List<RoutePoint> getRoutePoints()
```

Route points.

In addition to point coordinates each route point may have a selected arrival point

### getUri

```java
@Nullable
java.lang.String getUri()
```

Route URI

Optional field, can be null.

### getNonAvoidedFeatures

```java
@Nullable
NonAvoidedFeatures getNonAvoidedFeatures()
```

Route features that cannot be avoided

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
