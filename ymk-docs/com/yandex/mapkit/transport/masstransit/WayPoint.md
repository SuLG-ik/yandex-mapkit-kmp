---
title: "WayPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / WayPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/WayPoint.html"
---
# WayPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/WayPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.WayPoint

`class WayPoint implements Serializable`

A waypoint is the origin, destination or intermediate destination on the route.

For each waypoint, the corresponding selected arrival point can be stored.

## Summary

### Constructors

**Signature and Description**

```java
WayPoint()
```

Use constructor with parameters in your code.

```java
WayPoint(@NonNull Point position,
         @Nullable Point selectedArrivalPoint,
         @Nullable Point selectedDeparturePoint,
         @Nullable java.lang.String context,
         @Nullable java.lang.String levelId,
         @Nullable java.lang.String levelName)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Point` | `getPosition()`<br>Coordinates of the original waypoint from the request. |
| `synchronized Point` | `getSelectedArrivalPoint()`<br>Coordinates of the arrival point that was selected for arrival at the waypoint. |
| `synchronized Point` | `getSelectedDeparturePoint()`<br>Coordinates of the arrival point that was selected for departure from the waypoint. |
| `synchronized java.lang.String` | `getContext()`<br>request's context for this point<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getLevelId()`<br>Indoor level (floor) id<br>Optional field, can be null. |
| `synchronized java.lang.String` | `getLevelName()`<br>Indoor level (floor) name<br>Optional field, can be null. |
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
         @Nullable Point selectedArrivalPoint,
         @Nullable Point selectedDeparturePoint,
         @Nullable java.lang.String context,
         @Nullable java.lang.String levelId,
         @Nullable java.lang.String levelName)
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

Coordinates of the arrival point that was selected for arrival at the waypoint.

Optional field, can be null.

### getSelectedDeparturePoint

```java
@Nullable
Point getSelectedDeparturePoint()
```

Coordinates of the arrival point that was selected for departure from the waypoint.

Optional field, can be null.

### getContext

```java
@Nullable
java.lang.String getContext()
```

request's context for this point

Optional field, can be null.

### getLevelId

```java
@Nullable
java.lang.String getLevelId()
```

Indoor level (floor) id

Optional field, can be null.

### getLevelName

```java
@Nullable
java.lang.String getLevelName()
```

Indoor level (floor) name

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
