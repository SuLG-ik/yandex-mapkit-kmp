---
title: "RoutePosition"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation / RoutePosition"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/RoutePosition.html"
---
# RoutePosition

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/RoutePosition.html)

**Package** com.yandex.mapkit.navigation

`interface RoutePosition`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `onRoute(@NonNull java.lang.String routeId)`<br>Check if this position on the same route as passed. |
| `PolylinePosition` | `positionOnRoute(@NonNull java.lang.String routeId)`<br>Return polyline position on route. |
| `Point` | `getPoint()`<br>As point on the map |
| `RoutePosition` | `advance(double distance)`<br>Create position shifted by distance. |
| `java.lang.Double` | `distanceTo(@NonNull RoutePosition to)`<br>Distance to another point on the route. |
| `boolean` | `precedes(@NonNull RoutePosition another)`<br>Determines if position precedes another position on the route. |
| `boolean` | `precedesOrEquals(@NonNull RoutePosition another)`<br>Determines if position precedes or equals another position on the route. |
| `boolean` | `equals(@NonNull RoutePosition another)`<br>Determines if position equals another position on the route. |
| `double` | `heading()`<br>Heading movement on the route at this position. |
| `double` | `distanceToFinish()`<br>Distance to the end of the route. |
| `double` | `timeToFinish()`<br>Time to the end of the route. |

## Methods

### onRoute

```java
boolean onRoute(@NonNull java.lang.String routeId)
```

Check if this position on the same route as passed.

### positionOnRoute

```java
@Nullable
PolylinePosition positionOnRoute(@NonNull java.lang.String routeId)
```

Return polyline position on route.

If the position not on the passed route none will be returned.

### getPoint

```java
@NonNull
Point getPoint()
```

As point on the map

### advance

```java
@NonNull
RoutePosition advance(double distance)
```

Create position shifted by distance.

If the distance is more than remains route length, the end of the route will be returned. If the distance is less than a negative distance from the start, the beginning of the route will be returned.

### distanceTo

```java
@Nullable
java.lang.Double distanceTo(@NonNull RoutePosition to)
```

Distance to another point on the route.

Return none if point on another route. May be less 0 if position "to" stay before this position.

### precedes

```java
boolean precedes(@NonNull RoutePosition another)
```

Determines if position precedes another position on the route.

Throws if another position belongs to another route.

### precedesOrEquals

```java
boolean precedesOrEquals(@NonNull RoutePosition another)
```

Determines if position precedes or equals another position on the route.

Throws if another position belongs to another route.

### equals

```java
boolean equals(@NonNull RoutePosition another)
```

Determines if position equals another position on the route.

Throws if another position belongs to another route.

### heading

```java
double heading()
```

Heading movement on the route at this position.

It is equal heading of the segment which is belonged position.

### distanceToFinish

```java
double distanceToFinish()
```

Distance to the end of the route.

### timeToFinish

```java
double timeToFinish()
```

Time to the end of the route.
