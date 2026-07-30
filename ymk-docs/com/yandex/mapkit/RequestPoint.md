---
title: "RequestPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / RequestPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RequestPoint.html"
---
# RequestPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/RequestPoint.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.RequestPoint

`class RequestPoint implements Serializable`

There are two types of request points.

A waypoint is a destination. Use it when you plan to stop there. Via points (throughpoints) correct the route to make it pass through all the via points. Waypoints are guaranteed to be between sections in the resulting route. Via points are embedded into sections.

For each request point, you can provide a point context. It's an opaque string that describe entrances, driving arrival points and so on. If such context is provided then a client will get routes to those additional points.

## Summary

### Constructors

**Signature and Description**

```java
RequestPoint()
```

Use constructor with parameters in your code.

```java
RequestPoint(@NonNull Point point,
             @NonNull RequestPointType type,
             @Nullable java.lang.String pointContext,
             @Nullable java.lang.String drivingArrivalPointId,
             @Nullable java.lang.String indoorLevelId)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Point` | `getPoint()`<br>The request point. |
| `synchronized RequestPointType` | `getType()`<br>The type of request point specified. |
| `synchronized java.lang.String` | `getPointContext()`<br>Opaque string that describe entrances, driving arrival points and so on. |
| `synchronized java.lang.String` | `getDrivingArrivalPointId()`<br>Specifies what driving arrival point to use. |
| `synchronized java.lang.String` | `getIndoorLevelId()`<br>Indoor level (floor) id<br>Optional field, can be null. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RequestPoint

```java
RequestPoint()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RequestPoint

```java
RequestPoint(@NonNull Point point,
             @NonNull RequestPointType type,
             @Nullable java.lang.String pointContext,
             @Nullable java.lang.String drivingArrivalPointId,
             @Nullable java.lang.String indoorLevelId)
```

## Methods

### getPoint

```java
@NonNull
Point getPoint()
```

The request point.

### getType

```java
@NonNull
RequestPointType getType()
```

The type of request point specified.

### getPointContext

```java
@Nullable
java.lang.String getPointContext()
```

Opaque string that describe entrances, driving arrival points and so on.

Optional field, can be null.

### getDrivingArrivalPointId

```java
@Nullable
java.lang.String getDrivingArrivalPointId()
```

Specifies what driving arrival point to use.

If point is not specified then server will select one.

Optional field, can be null.

### getIndoorLevelId

```java
@Nullable
java.lang.String getIndoorLevelId()
```

Indoor level (floor) id

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
