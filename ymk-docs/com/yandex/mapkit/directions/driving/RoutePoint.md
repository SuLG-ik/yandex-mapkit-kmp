---
title: "RoutePoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RoutePoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RoutePoint.html"
---
# RoutePoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RoutePoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RoutePoint

`class RoutePoint implements Serializable`

Route point metadata (exists for both waypoints and via points).

## Summary

### Constructors

**Signature and Description**

```java
RoutePoint()
```

Use constructor with parameters in your code.

```java
RoutePoint(@NonNull Point position,
           @Nullable Point selectedArrivalPoint)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Point` | `getPosition()`<br>Position of original route point. |
| `synchronized Point` | `getSelectedArrivalPoint()`<br>Arrival point selected for routing. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RoutePoint

```java
RoutePoint()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RoutePoint

```java
RoutePoint(@NonNull Point position,
           @Nullable Point selectedArrivalPoint)
```

## Methods

### getPosition

```java
@NonNull
Point getPosition()
```

Position of original route point.

### getSelectedArrivalPoint

```java
@Nullable
Point getSelectedArrivalPoint()
```

Arrival point selected for routing.

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
