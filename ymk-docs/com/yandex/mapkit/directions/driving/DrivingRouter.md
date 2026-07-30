---
title: "DrivingRouter"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouter.html"
---
# DrivingRouter

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`interface DrivingRouter`

Interface for the driving router.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `DrivingSession` | `requestRoutes(@NonNull java.util.List<RequestPoint> points, @NonNull DrivingOptions drivingOptions, @NonNull VehicleOptions vehicleOptions, @NonNull DrivingRouteListener routeListener)`<br>Builds a route. |
| `DrivingSession` | `matchRoute(@NonNull Polyline polyline, @NonNull DrivingOptions drivingOptions, @NonNull VehicleOptions vehicleOptions, @NonNull DrivingRouteListener routeListener)`<br>Builds a route based on a custom route geometry. |
| `DrivingSummarySession` | `requestRoutesSummary(@NonNull java.util.List<RequestPoint> points, @NonNull DrivingOptions drivingOptions, @NonNull VehicleOptions vehicleOptions, @NonNull DrivingSummaryListener summaryListener)`<br>Creates a route summary. |

## Methods

### requestRoutes

```java
@NonNull
DrivingSession requestRoutes(@NonNull java.util.List<RequestPoint> points,
                             @NonNull DrivingOptions drivingOptions,
                             @NonNull VehicleOptions vehicleOptions,
                             @NonNull DrivingRouteListener routeListener)
```

Builds a route.

| Parameters |   |
| --- | --- |
| `points` | Route points. |
| `drivingOptions` | Driving options. |
| `vehicleOptions` | Vehicle options. |
| `routeListener` | Route listener object. |

### matchRoute

```java
@NonNull
DrivingSession matchRoute(@NonNull Polyline polyline,
                          @NonNull DrivingOptions drivingOptions,
                          @NonNull VehicleOptions vehicleOptions,
                          @NonNull DrivingRouteListener routeListener)
```

Builds a route based on a custom route geometry.

| Parameters |   |
| --- | --- |
| `polyline` | Custom route geometry. |
| `drivingOptions` | Driving options. |
| `vehicleOptions` | Vehicle options. |
| `routeListener` | Route listener object. |

### requestRoutesSummary

```java
@NonNull
DrivingSummarySession requestRoutesSummary(@NonNull java.util.List<RequestPoint> points,
                                           @NonNull DrivingOptions drivingOptions,
                                           @NonNull VehicleOptions vehicleOptions,
                                           @NonNull DrivingSummaryListener summaryListener)
```

Creates a route summary.

| Parameters |   |
| --- | --- |
| `points` | Route points. |
| `drivingOptions` | Driving options. |
| `vehicleOptions` | Vehicle options. |
| `summaryListener` | Summary listener object. |
