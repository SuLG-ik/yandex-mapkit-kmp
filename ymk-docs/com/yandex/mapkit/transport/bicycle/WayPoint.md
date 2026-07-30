---
title: "WayPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / WayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/WayPoint.html"
---
# WayPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/WayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.WayPoint

`class WayPoint implements Serializable`

A waypoint is the origin, destination or intermediate destination on the route.

For each way point, the corresponding selected arrival point can be stored.

## Summary

### Constructors

**Signature and Description**

```java
WayPoint()
```

Use constructor with parameters in your code.

```java
WayPoint(@NonNull Point position,
         @Nullable Point selectedArrivalPoint)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Point` | `getPosition()`<br>Coordinates of the original waypoint from the request. |
| `synchronized Point` | `getSelectedArrivalPoint()`<br>Coordinates of the selected arrival point. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### WayPoint

```java
WayPoint()
```

Use constructor with parameters in your code.

This one is for serialization only!

### WayPoint

```java
WayPoint(@NonNull Point position,
         @Nullable Point selectedArrivalPoint)
```

## Methods

### getPosition

```java
@NonNull
Point getPosition()
```

Coordinates of the original waypoint from the request.

### getSelectedArrivalPoint

```java
@Nullable
Point getSelectedArrivalPoint()
```

Coordinates of the selected arrival point.

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
