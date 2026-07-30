---
title: "Flags"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Flags"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Flags.html"
---
# Flags

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Flags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Flags

`class Flags implements Serializable`

Overall characteristics of the route.

## Summary

### Constructors

**Signature and Description**

```java
Flags(boolean blocked,
      boolean hasFerries,
      boolean hasTolls,
      boolean requiresAccessPass,
      boolean forParking,
      boolean futureBlocked,
      boolean deadJam,
      boolean builtOffline,
      boolean predicted,
      boolean hasRuggedRoads,
      boolean hasFordCrossing,
      boolean hasVehicleRestrictions,
      boolean hasUnpavedRoads,
      boolean hasInPoorConditionRoads,
      boolean hasRailwayCrossing,
      boolean hasCheckpoints,
      boolean scheduledDeparture,
      boolean hasNonTransactionalTolls,
      boolean hasTunnels,
      boolean hasHighways)
```

```java
Flags()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getBlocked()`<br>Route is blocked. |
| `boolean` | `getHasFerries()`<br>Route has ferries on it. |
| `boolean` | `getHasTolls()`<br>Route has toll posts, which are always paid. |
| `boolean` | `getRequiresAccessPass()`<br>Route requires special access. |
| `boolean` | `getForParking()`<br>Route is made for parking. |
| `boolean` | `getFutureBlocked()`<br>Route will be blocked soon. |
| `boolean` | `getDeadJam()`<br>Route has a severe traffic jam. |
| `boolean` | `getBuiltOffline()`<br>Route was built by using offline data. |
| `boolean` | `getPredicted()`<br>Predicted optimal route. |
| `boolean` | `getHasRuggedRoads()`<br>Route has rugged roads on it. |
| `boolean` | `getHasFordCrossing()`<br>Route has ford crossing on it. |
| `boolean` | `getHasVehicleRestrictions()`<br>Route has vehicle restrictions on it. |
| `boolean` | `getHasUnpavedRoads()`<br>Route has unpaved roads on it. |
| `boolean` | `getHasInPoorConditionRoads()`<br>Route has poor condition roads on it. |
| `boolean` | `getHasRailwayCrossing()`<br>Route has railway crossing on it. |
| `boolean` | `getHasCheckpoints()`<br>Route has checkpoints on it. |
| `boolean` | `getScheduledDeparture()`<br>Route was requested with custom departure time. |
| `boolean` | `getHasNonTransactionalTolls()`<br>Route has conditionally-toll-free toll posts |
| `boolean` | `getHasTunnels()`<br>Route has tunnels on it. |
| `boolean` | `getHasHighways()`<br>Route has highways on it. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Flags

```java
Flags(boolean blocked,
      boolean hasFerries,
      boolean hasTolls,
      boolean requiresAccessPass,
      boolean forParking,
      boolean futureBlocked,
      boolean deadJam,
      boolean builtOffline,
      boolean predicted,
      boolean hasRuggedRoads,
      boolean hasFordCrossing,
      boolean hasVehicleRestrictions,
      boolean hasUnpavedRoads,
      boolean hasInPoorConditionRoads,
      boolean hasRailwayCrossing,
      boolean hasCheckpoints,
      boolean scheduledDeparture,
      boolean hasNonTransactionalTolls,
      boolean hasTunnels,
      boolean hasHighways)
```

### Flags

```java
Flags()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getBlocked

```java
boolean getBlocked()
```

Route is blocked.

### getHasFerries

```java
boolean getHasFerries()
```

Route has ferries on it.

### getHasTolls

```java
boolean getHasTolls()
```

Route has toll posts, which are always paid.

### getRequiresAccessPass

```java
boolean getRequiresAccessPass()
```

Route requires special access.

### getForParking

```java
boolean getForParking()
```

Route is made for parking.

### getFutureBlocked

```java
boolean getFutureBlocked()
```

Route will be blocked soon.

### getDeadJam

```java
boolean getDeadJam()
```

Route has a severe traffic jam.

### getBuiltOffline

```java
boolean getBuiltOffline()
```

Route was built by using offline data.

### getPredicted

```java
boolean getPredicted()
```

Predicted optimal route.

### getHasRuggedRoads

```java
boolean getHasRuggedRoads()
```

Route has rugged roads on it.

### getHasFordCrossing

```java
boolean getHasFordCrossing()
```

Route has ford crossing on it.

### getHasVehicleRestrictions

```java
boolean getHasVehicleRestrictions()
```

Route has vehicle restrictions on it.

### getHasUnpavedRoads

```java
boolean getHasUnpavedRoads()
```

Route has unpaved roads on it.

### getHasInPoorConditionRoads

```java
boolean getHasInPoorConditionRoads()
```

Route has poor condition roads on it.

### getHasRailwayCrossing

```java
boolean getHasRailwayCrossing()
```

Route has railway crossing on it.

### getHasCheckpoints

```java
boolean getHasCheckpoints()
```

Route has checkpoints on it.

### getScheduledDeparture

```java
boolean getScheduledDeparture()
```

Route was requested with custom departure time.

### getHasNonTransactionalTolls

```java
boolean getHasNonTransactionalTolls()
```

Route has conditionally-toll-free toll posts

### getHasTunnels

```java
boolean getHasTunnels()
```

Route has tunnels on it.

### getHasHighways

```java
boolean getHasHighways()
```

Route has highways on it.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
