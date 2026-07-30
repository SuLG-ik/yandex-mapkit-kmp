---
title: "ManoeuvreVehicleRestriction"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ManoeuvreVehicleRestriction"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ManoeuvreVehicleRestriction.html"
---
# ManoeuvreVehicleRestriction

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ManoeuvreVehicleRestriction.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ManoeuvreVehicleRestriction

`class ManoeuvreVehicleRestriction implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ManoeuvreVehicleRestriction(@NonNull VehicleRestriction vehicleRestriction,
                            @NonNull PolylinePosition position)
```

```java
ManoeuvreVehicleRestriction()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `VehicleRestriction` | `getVehicleRestriction()` |
| `PolylinePosition` | `getPosition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ManoeuvreVehicleRestriction

```java
ManoeuvreVehicleRestriction(@NonNull VehicleRestriction vehicleRestriction,
                            @NonNull PolylinePosition position)
```

### ManoeuvreVehicleRestriction

```java
ManoeuvreVehicleRestriction()
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
PolylinePosition getPosition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
