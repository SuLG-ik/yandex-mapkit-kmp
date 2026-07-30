---
title: "YMKDrivingRouter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouter.html"
---
# YMKDrivingRouter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingRouter : NSObject
```

Interface for the driving router.

## Summary

### Instance methods

```objectivec
- (nonnull YMKDrivingSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
             drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
             vehicleOptions:(nonnull YMKDrivingVehicleOptions *)vehicleOptions
               routeHandler:(nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route

```objectivec
- (nonnull YMKDrivingSession *)
    matchRouteWithPolyline:(nonnull YMKPolyline *)polyline
            drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
            vehicleOptions:(nonnull YMKDrivingVehicleOptions *)vehicleOptions
              routeHandler:(nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route based on a custom route geometry

```objectivec
- (nonnull YMKDrivingSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                    drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
                    vehicleOptions:
                        (nonnull YMKDrivingVehicleOptions *)vehicleOptions
                    summaryHandler:
                        (nonnull YMKDrivingSummarySessionSummaryHandler)
                            summaryHandler;
```

Creates a route summary

## Instance methods

### requestRoutesWithPoints:drivingOptions:vehicleOptions:routeHandler:

```objectivec
- (nonnull YMKDrivingSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
             drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
             vehicleOptions:(nonnull YMKDrivingVehicleOptions *)vehicleOptions
               routeHandler:(nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route.

| Parameters |   |
| --- | --- |
| points | Route points. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| routeListener | Route listener object. |

### matchRouteWithPolyline:drivingOptions:vehicleOptions:routeHandler:

```objectivec
- (nonnull YMKDrivingSession *)
    matchRouteWithPolyline:(nonnull YMKPolyline *)polyline
            drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
            vehicleOptions:(nonnull YMKDrivingVehicleOptions *)vehicleOptions
              routeHandler:(nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route based on a custom route geometry.

| Parameters |   |
| --- | --- |
| polyline | Custom route geometry. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| routeListener | Route listener object. |

### requestRoutesSummaryWithPoints:drivingOptions:vehicleOptions:summaryHandler:

```objectivec
- (nonnull YMKDrivingSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                    drivingOptions:(nonnull YMKDrivingOptions *)drivingOptions
                    vehicleOptions:
                        (nonnull YMKDrivingVehicleOptions *)vehicleOptions
                    summaryHandler:
                        (nonnull YMKDrivingSummarySessionSummaryHandler)
                            summaryHandler;
```

Creates a route summary.

| Parameters |   |
| --- | --- |
| points | Route points. |
| drivingOptions | Driving options. |
| vehicleOptions | Vehicle options. |
| summaryListener | Summary listener object. |
