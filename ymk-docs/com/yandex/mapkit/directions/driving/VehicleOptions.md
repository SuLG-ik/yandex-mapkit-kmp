---
title: "VehicleOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / VehicleOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/VehicleOptions.html"
---
# VehicleOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/VehicleOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.VehicleOptions

`final class VehicleOptions implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
VehicleOptions(@NonNull VehicleType vehicleType,
               @Nullable java.lang.Float weight,
               @Nullable java.lang.Float axleWeight,
               @Nullable java.lang.Float maxWeight,
               @Nullable java.lang.Float height,
               @Nullable java.lang.Float width,
               @Nullable java.lang.Float length,
               @Nullable java.lang.Float payload,
               @Nullable java.lang.Integer ecoClass,
               @Nullable java.lang.Boolean hasTrailer,
               @Nullable java.lang.Boolean buswayPermitted)
```

```java
VehicleOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `VehicleType` | `getVehicleType()`<br>Sets the vehicle type for special routing. |
| `VehicleOptions` | `setVehicleType(@NonNull VehicleType vehicleType)`<br>See **#getVehicleType()**. |
| `java.lang.Float` | `getWeight()`<br>Real vehicle weight. |
| `VehicleOptions` | `setWeight(@Nullable java.lang.Float weight)`<br>See **#getWeight()**. |
| `java.lang.Float` | `getAxleWeight()`<br>Maximal weight supported by a vehicle axle. |
| `VehicleOptions` | `setAxleWeight(@Nullable java.lang.Float axleWeight)`<br>See **#getAxleWeight()**. |
| `java.lang.Float` | `getMaxWeight()`<br>Maximal allowed weight for the vehicle. |
| `VehicleOptions` | `setMaxWeight(@Nullable java.lang.Float maxWeight)`<br>See **#getMaxWeight()**. |
| `java.lang.Float` | `getHeight()`<br>Vehicle height. |
| `VehicleOptions` | `setHeight(@Nullable java.lang.Float height)`<br>See **#getHeight()**. |
| `java.lang.Float` | `getWidth()`<br>Vehicle width. |
| `VehicleOptions` | `setWidth(@Nullable java.lang.Float width)`<br>See **#getWidth()**. |
| `java.lang.Float` | `getLength()`<br>Vehicle length. |
| `VehicleOptions` | `setLength(@Nullable java.lang.Float length)`<br>See **#getLength()**. |
| `java.lang.Float` | `getPayload()`<br>Vehicle cargo weight. |
| `VehicleOptions` | `setPayload(@Nullable java.lang.Float payload)`<br>See **#getPayload()**. |
| `java.lang.Integer` | `getEcoClass()`<br>Vehicle eco class. |
| `VehicleOptions` | `setEcoClass(@Nullable java.lang.Integer ecoClass)`<br>See **#getEcoClass()**. |
| `java.lang.Boolean` | `getHasTrailer()`<br>The vehicle has a trailer attached. |
| `VehicleOptions` | `setHasTrailer(@Nullable java.lang.Boolean hasTrailer)`<br>See **#getHasTrailer()**. |
| `java.lang.Boolean` | `getBuswayPermitted()`<br>The vehicle is permitted for busway. |
| `VehicleOptions` | `setBuswayPermitted(@Nullable java.lang.Boolean buswayPermitted)`<br>See **#getBuswayPermitted()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### VehicleOptions

```java
VehicleOptions(@NonNull VehicleType vehicleType,
               @Nullable java.lang.Float weight,
               @Nullable java.lang.Float axleWeight,
               @Nullable java.lang.Float maxWeight,
               @Nullable java.lang.Float height,
               @Nullable java.lang.Float width,
               @Nullable java.lang.Float length,
               @Nullable java.lang.Float payload,
               @Nullable java.lang.Integer ecoClass,
               @Nullable java.lang.Boolean hasTrailer,
               @Nullable java.lang.Boolean buswayPermitted)
```

### VehicleOptions

```java
VehicleOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getVehicleType

```java
@NonNull
VehicleType getVehicleType()
```

Sets the vehicle type for special routing.

### setVehicleType

```java
VehicleOptions setVehicleType(@NonNull VehicleType vehicleType)
```

See **#getVehicleType()**.

### getWeight

```java
@Nullable
java.lang.Float getWeight()
```

Real vehicle weight.

Optional field, can be null.

### setWeight

```java
VehicleOptions setWeight(@Nullable java.lang.Float weight)
```

See **#getWeight()**.

### getAxleWeight

```java
@Nullable
java.lang.Float getAxleWeight()
```

Maximal weight supported by a vehicle axle.

Optional field, can be null.

### setAxleWeight

```java
VehicleOptions setAxleWeight(@Nullable java.lang.Float axleWeight)
```

See **#getAxleWeight()**.

### getMaxWeight

```java
@Nullable
java.lang.Float getMaxWeight()
```

Maximal allowed weight for the vehicle.

Optional field, can be null.

### setMaxWeight

```java
VehicleOptions setMaxWeight(@Nullable java.lang.Float maxWeight)
```

See **#getMaxWeight()**.

### getHeight

```java
@Nullable
java.lang.Float getHeight()
```

Vehicle height.

Optional field, can be null.

### setHeight

```java
VehicleOptions setHeight(@Nullable java.lang.Float height)
```

See **#getHeight()**.

### getWidth

```java
@Nullable
java.lang.Float getWidth()
```

Vehicle width.

Optional field, can be null.

### setWidth

```java
VehicleOptions setWidth(@Nullable java.lang.Float width)
```

See **#getWidth()**.

### getLength

```java
@Nullable
java.lang.Float getLength()
```

Vehicle length.

Optional field, can be null.

### setLength

```java
VehicleOptions setLength(@Nullable java.lang.Float length)
```

See **#getLength()**.

### getPayload

```java
@Nullable
java.lang.Float getPayload()
```

Vehicle cargo weight.

Optional field, can be null.

### setPayload

```java
VehicleOptions setPayload(@Nullable java.lang.Float payload)
```

See **#getPayload()**.

### getEcoClass

```java
@Nullable
java.lang.Integer getEcoClass()
```

Vehicle eco class.

Optional field, can be null.

### setEcoClass

```java
VehicleOptions setEcoClass(@Nullable java.lang.Integer ecoClass)
```

See **#getEcoClass()**.

### getHasTrailer

```java
@Nullable
java.lang.Boolean getHasTrailer()
```

The vehicle has a trailer attached.

Optional field, can be null.

### setHasTrailer

```java
VehicleOptions setHasTrailer(@Nullable java.lang.Boolean hasTrailer)
```

See **#getHasTrailer()**.

### getBuswayPermitted

```java
@Nullable
java.lang.Boolean getBuswayPermitted()
```

The vehicle is permitted for busway.

Optional field, can be null.

### setBuswayPermitted

```java
VehicleOptions setBuswayPermitted(@Nullable java.lang.Boolean buswayPermitted)
```

See **#getBuswayPermitted()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
