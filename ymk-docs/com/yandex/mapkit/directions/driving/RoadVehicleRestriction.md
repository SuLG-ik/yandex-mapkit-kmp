---
title: "RoadVehicleRestriction"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RoadVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RoadVehicleRestriction.html"
---
# RoadVehicleRestriction

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RoadVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RoadVehicleRestriction

`class RoadVehicleRestriction implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RoadVehicleRestriction(@NonNull VehicleRestriction vehicleRestriction,
                       @NonNull Subpolyline position)
```

```java
RoadVehicleRestriction()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `VehicleRestriction` | `getVehicleRestriction()` |
| `Subpolyline` | `getPosition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RoadVehicleRestriction

```java
RoadVehicleRestriction(@NonNull VehicleRestriction vehicleRestriction,
                       @NonNull Subpolyline position)
```

### RoadVehicleRestriction

```java
RoadVehicleRestriction()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getVehicleRestriction

```java
@NonNull
VehicleRestriction getVehicleRestriction()
```

### getPosition

```java
@NonNull
Subpolyline getPosition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
