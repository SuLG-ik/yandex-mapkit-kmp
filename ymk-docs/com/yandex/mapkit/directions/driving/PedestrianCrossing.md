---
title: "PedestrianCrossing"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / PedestrianCrossing"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/PedestrianCrossing.html"
---
# PedestrianCrossing

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/PedestrianCrossing.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.PedestrianCrossing

`class PedestrianCrossing implements Serializable`

A pedestrian crossing object.

## Summary

### Constructors

**Signature and Description**

```java
PedestrianCrossing(@NonNull PolylinePosition position)
```

```java
PedestrianCrossing()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>The position of pedestrian crossing. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### PedestrianCrossing

```java
PedestrianCrossing(@NonNull PolylinePosition position)
```

### PedestrianCrossing

```java
PedestrianCrossing()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of pedestrian crossing.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
