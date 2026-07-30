---
title: "Transport"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport"
section: "Android / Справочник / com.yandex.mapkit.transport / Transport"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/Transport.html"
---
# Transport

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/Transport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport

`interface Transport`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `BicycleRouter` | `createBicycleRouter()` |
| `MasstransitRouter` | `createMasstransitRouter()`<br>Creates a manager that builds public transit routes using the origin and destination points. |
| `PedestrianRouter` | `createPedestrianRouter()`<br>Creates a manager that builds pedestrian routes using the origin and destination points. |
| `BicycleRouterV2` | `createBicycleRouterV2()`<br>Creates a manager that builds bicycle routes using the origin and destination points. |
| `BicycleRouterV2` | `createScooterRouter()`<br>Creates a manager that builds scooter routes using the origin and destination points. |
| `BicycleRouterV2` | `createElectricBikeRouter()`<br>Creates a manager that builds electric bike routes using the origin and destination points. |
| `AdjustedClock` | `getAdjustedClock()`<br>Returns the clock that is constantly synchronized with the server. |
| `boolean` | `isValid()`<br>Tells if this **Transport** is valid or not. |

## Methods

### createBicycleRouter

```java
@Deprecated @NonNull
BicycleRouter createBicycleRouter()
```

> [!CAUTION] Внимание
> use createBicycleRouterV2 instead Creates a manager that builds bicycle routes using the origin and destination points.

### createMasstransitRouter

```java
@NonNull
MasstransitRouter createMasstransitRouter()
```

Creates a manager that builds public transit routes using the origin and destination points.

### createPedestrianRouter

```java
@NonNull
PedestrianRouter createPedestrianRouter()
```

Creates a manager that builds pedestrian routes using the origin and destination points.

### createBicycleRouterV2

```java
@NonNull
BicycleRouterV2 createBicycleRouterV2()
```

Creates a manager that builds bicycle routes using the origin and destination points.

### createScooterRouter

```java
@NonNull
BicycleRouterV2 createScooterRouter()
```

Creates a manager that builds scooter routes using the origin and destination points.

### createElectricBikeRouter

```java
@NonNull
BicycleRouterV2 createElectricBikeRouter()
```

Creates a manager that builds electric bike routes using the origin and destination points.

### getAdjustedClock

```java
@NonNull
AdjustedClock getAdjustedClock()
```

Returns the clock that is constantly synchronized with the server.

### isValid

```java
boolean isValid()
```

Tells if this **Transport** is valid or not.

Any other method (except for this one) called on an invalid **Transport** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
