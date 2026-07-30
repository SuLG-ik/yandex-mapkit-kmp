---
title: "ConstructionMask"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ConstructionMask"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ConstructionMask.html"
---
# ConstructionMask

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ConstructionMask.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.ConstructionMask

`class ConstructionMask implements Serializable`

Constructions that can be found on pedestrian, bicycle paths or on mass transit transfers.

## Summary

### Constructors

**Signature and Description**

```java
ConstructionMask(@Nullable Stairs stairs,
                 @Nullable Pass pass,
                 boolean crosswalk,
                 boolean binding,
                 boolean transition,
                 boolean tunnel,
                 @Nullable Travolator travolator,
                 boolean indoor,
                 boolean spiral,
                 @Nullable Escalator escalator,
                 @Nullable Elevator elevator)
```

```java
ConstructionMask()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Stairs` | `getStairs()`<br>Optional field, can be null. |
| `Pass` | `getPass()`<br>Optional field, can be null. |
| `boolean` | `getCrosswalk()`<br>Crossing that is not an underground tunnel or a bridge. |
| `boolean` | `getBinding()`<br>Edge connecting the route endpoint to the route network. |
| `boolean` | `getTransition()`<br>Transfer. |
| `boolean` | `getTunnel()`<br>Tunnel that is not a crossing. |
| `Travolator` | `getTravolator()`<br>Optional field, can be null. |
| `boolean` | `getIndoor()`<br>Air-conditioned place. |
| `boolean` | `getSpiral()`<br>Spiral object, e.g. |
| `Escalator` | `getEscalator()`<br>Optional field, can be null. |
| `Elevator` | `getElevator()`<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ConstructionMask

```java
ConstructionMask(@Nullable Stairs stairs,
                 @Nullable Pass pass,
                 boolean crosswalk,
                 boolean binding,
                 boolean transition,
                 boolean tunnel,
                 @Nullable Travolator travolator,
                 boolean indoor,
                 boolean spiral,
                 @Nullable Escalator escalator,
                 @Nullable Elevator elevator)
```

### ConstructionMask

```java
ConstructionMask()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getStairs

```java
@Nullable
Stairs getStairs()
```

Optional field, can be null.

### getPass

```java
@Nullable
Pass getPass()
```

Optional field, can be null.

### getCrosswalk

```java
boolean getCrosswalk()
```

Crossing that is not an underground tunnel or a bridge.

### getBinding

```java
boolean getBinding()
```

Edge connecting the route endpoint to the route network.

### getTransition

```java
boolean getTransition()
```

Transfer.

For example, transfer from one underground line to another or transfer from an underground station to an exit from it.

### getTunnel

```java
boolean getTunnel()
```

Tunnel that is not a crossing.

### getTravolator

```java
@Nullable
Travolator getTravolator()
```

Optional field, can be null.

### getIndoor

```java
boolean getIndoor()
```

Air-conditioned place.

Can be a covered gallery, a mall or any other climate-static edges.

### getSpiral

```java
boolean getSpiral()
```

Spiral object, e.g.

stairs

### getEscalator

```java
@Nullable
Escalator getEscalator()
```

Optional field, can be null.

### getElevator

```java
@Nullable
Elevator getElevator()
```

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
