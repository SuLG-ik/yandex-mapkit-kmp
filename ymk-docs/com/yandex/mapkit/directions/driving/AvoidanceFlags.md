---
title: "AvoidanceFlags"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / AvoidanceFlags"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/AvoidanceFlags.html"
---
# AvoidanceFlags

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/AvoidanceFlags.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.AvoidanceFlags

`final class AvoidanceFlags implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
AvoidanceFlags(boolean avoidTolls,
               boolean avoidUnpaved,
               boolean avoidPoorCondition,
               boolean avoidRailwayCrossing,
               boolean avoidBoatFerry,
               boolean avoidFordCrossing,
               boolean avoidTunnel,
               boolean avoidHighway)
```

```java
AvoidanceFlags()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getAvoidTolls()`<br>The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible. |
| `AvoidanceFlags` | `setAvoidTolls(boolean avoidTolls)`<br>See **#getAvoidTolls()**. |
| `boolean` | `getAvoidUnpaved()`<br>The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible. |
| `AvoidanceFlags` | `setAvoidUnpaved(boolean avoidUnpaved)`<br>See **#getAvoidUnpaved()**. |
| `boolean` | `getAvoidPoorCondition()`<br>The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible. |
| `AvoidanceFlags` | `setAvoidPoorCondition(boolean avoidPoorCondition)`<br>See **#getAvoidPoorCondition()**. |
| `boolean` | `getAvoidRailwayCrossing()`<br>The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible. |
| `AvoidanceFlags` | `setAvoidRailwayCrossing(boolean avoidRailwayCrossing)`<br>See **#getAvoidRailwayCrossing()**. |
| `boolean` | `getAvoidBoatFerry()`<br>The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible. |
| `AvoidanceFlags` | `setAvoidBoatFerry(boolean avoidBoatFerry)`<br>See **#getAvoidBoatFerry()**. |
| `boolean` | `getAvoidFordCrossing()`<br>The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible. |
| `AvoidanceFlags` | `setAvoidFordCrossing(boolean avoidFordCrossing)`<br>See **#getAvoidFordCrossing()**. |
| `boolean` | `getAvoidTunnel()`<br>The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible. |
| `AvoidanceFlags` | `setAvoidTunnel(boolean avoidTunnel)`<br>See **#getAvoidTunnel()**. |
| `boolean` | `getAvoidHighway()`<br>The 'avoidHighway' option instructs the router to return routes that avoid highways when possible. |
| `AvoidanceFlags` | `setAvoidHighway(boolean avoidHighway)`<br>See **#getAvoidHighway()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### AvoidanceFlags

```java
AvoidanceFlags(boolean avoidTolls,
               boolean avoidUnpaved,
               boolean avoidPoorCondition,
               boolean avoidRailwayCrossing,
               boolean avoidBoatFerry,
               boolean avoidFordCrossing,
               boolean avoidTunnel,
               boolean avoidHighway)
```

### AvoidanceFlags

```java
AvoidanceFlags()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getAvoidTolls

```java
boolean getAvoidTolls()
```

The 'avoidTolls' option instructs the router to return routes that avoid tolls when possible.

### setAvoidTolls

```java
AvoidanceFlags setAvoidTolls(boolean avoidTolls)
```

See **#getAvoidTolls()**.

### getAvoidUnpaved

```java
boolean getAvoidUnpaved()
```

The 'avoidUnpaved' option instructs the router to return routes that avoid unpaved roads when possible.

### setAvoidUnpaved

```java
AvoidanceFlags setAvoidUnpaved(boolean avoidUnpaved)
```

See **#getAvoidUnpaved()**.

### getAvoidPoorCondition

```java
boolean getAvoidPoorCondition()
```

The 'avoidPoorCondition' option instructs the router to return routes that avoid roads in poor conditions when possible.

### setAvoidPoorCondition

```java
AvoidanceFlags setAvoidPoorCondition(boolean avoidPoorCondition)
```

See **#getAvoidPoorCondition()**.

### getAvoidRailwayCrossing

```java
boolean getAvoidRailwayCrossing()
```

The 'avoidPoorConditions' option instructs the router to return routes that avoid railway crossings when possible.

### setAvoidRailwayCrossing

```java
AvoidanceFlags setAvoidRailwayCrossing(boolean avoidRailwayCrossing)
```

See **#getAvoidRailwayCrossing()**.

### getAvoidBoatFerry

```java
boolean getAvoidBoatFerry()
```

The 'avoidBoatFerry' option instructs the router to return routes that avoid ferries when possible.

### setAvoidBoatFerry

```java
AvoidanceFlags setAvoidBoatFerry(boolean avoidBoatFerry)
```

See **#getAvoidBoatFerry()**.

### getAvoidFordCrossing

```java
boolean getAvoidFordCrossing()
```

The 'avoidFordCrossing' option instructs the router to return routes that avoid ford crossings when possible.

### setAvoidFordCrossing

```java
AvoidanceFlags setAvoidFordCrossing(boolean avoidFordCrossing)
```

See **#getAvoidFordCrossing()**.

### getAvoidTunnel

```java
boolean getAvoidTunnel()
```

The 'avoidTunnel' option instructs the router to return routes that avoid tunnels when possible.

### setAvoidTunnel

```java
AvoidanceFlags setAvoidTunnel(boolean avoidTunnel)
```

See **#getAvoidTunnel()**.

### getAvoidHighway

```java
boolean getAvoidHighway()
```

The 'avoidHighway' option instructs the router to return routes that avoid highways when possible.

### setAvoidHighway

```java
AvoidanceFlags setAvoidHighway(boolean avoidHighway)
```

See **#getAvoidHighway()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
