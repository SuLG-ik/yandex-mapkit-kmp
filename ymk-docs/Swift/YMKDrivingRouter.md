---
title: "YMKDrivingRouter"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDrivingRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouter.html"
---
# YMKDrivingRouter

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDrivingRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDrivingRouter : NSObject
```

Interface for the driving router.

## Summary

### Instance methods

```swift
func requestRoutes(with points: [YMKRequestPoint],
                drivingOptions: YMKDrivingOptions,
                vehicleOptions: YMKDrivingVehicleOptions,
                  routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route

```swift
func matchRoute(with polyline: YMKPolyline,
               drivingOptions: YMKDrivingOptions,
               vehicleOptions: YMKDrivingVehicleOptions,
                 routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route based on a custom route geometry

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                       drivingOptions: YMKDrivingOptions,
                       vehicleOptions: YMKDrivingVehicleOptions,
                       summaryHandler: @escaping YMKDrivingSummarySessionSummaryHandler) -> YMKDrivingSummarySession
```

Creates a route summary

## Instance methods

### requestRoutes(with:drivingOptions:vehicleOptions:routeHandler:)

```swift
func requestRoutes(with points: [YMKRequestPoint],
                drivingOptions: YMKDrivingOptions,
                vehicleOptions: YMKDrivingVehicleOptions,
                  routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route.

| Parameters |   |
| --- | --- |
| points | Route points. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| routeListener | Route listener object. |

### matchRoute(with:drivingOptions:vehicleOptions:routeHandler:)

```swift
func matchRoute(with polyline: YMKPolyline,
               drivingOptions: YMKDrivingOptions,
               vehicleOptions: YMKDrivingVehicleOptions,
                 routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route based on a custom route geometry.

| Parameters |   |
| --- | --- |
| polyline | Custom route geometry. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| routeListener | Route listener object. |

### requestRoutesSummary(with:drivingOptions:vehicleOptions:summaryHandler:)

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                       drivingOptions: YMKDrivingOptions,
                       vehicleOptions: YMKDrivingVehicleOptions,
                       summaryHandler: @escaping YMKDrivingSummarySessionSummaryHandler) -> YMKDrivingSummarySession
```

Creates a route summary.

| Parameters |   |
| --- | --- |
| points | Route points. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| summaryListener | Summary listener object. |
