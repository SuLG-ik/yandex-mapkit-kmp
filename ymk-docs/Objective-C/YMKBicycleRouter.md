---
title: "YMKBicycleRouter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRouter.html"
---
# YMKBicycleRouter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleRouter : NSObject
```

Provides methods for submitting bicycle routing requests.

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead

## Summary

### Instance methods

```objectivec
- (nonnull YMKBicycleSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                       type:(YMKBicycleVehicleType)type
              routeListener:
                  (nonnull YMKBicycleSessionRouteListener)routeListener;
```

Submits a request to find a bicycle route

```objectivec
- (nonnull YMKBicycleSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                              type:(YMKBicycleVehicleType)type
                    summaryHandler:
                        (nonnull YMKBicycleSummarySessionSummaryHandler)
                            summaryHandler;
```

Submits a request to fetch a brief summary of the bicycle routes

```objectivec
- (nonnull YMKBicycleSession *)
    resolveUriWithUri:(nonnull NSString *)uri
        routeListener:(nonnull YMKBicycleSessionRouteListener)routeListener;
```

Submits a request to retrieve detailed information on a bicycle route by URI

## Instance methods

### requestRoutesWithPoints:type:routeListener:

```objectivec
- (nonnull YMKBicycleSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                       type:(YMKBicycleVehicleType)type
              routeListener:
                  (nonnull YMKBicycleSessionRouteListener)routeListener;
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Submits a request to find a bicycle route.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish). |
| routeListener | Listener to retrieve a list of Route objects. |

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead

### requestRoutesSummaryWithPoints:type:summaryHandler:

```objectivec
- (nonnull YMKBicycleSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                              type:(YMKBicycleVehicleType)type
                    summaryHandler:
                        (nonnull YMKBicycleSummarySessionSummaryHandler)
                            summaryHandler;
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Submits a request to fetch a brief summary of the bicycle routes.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish). |
| summaryListener | Listener to retrieve a list of Route objects. |

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead

### resolveUriWithUri:routeListener:

```objectivec
- (nonnull YMKBicycleSession *)
    resolveUriWithUri:(nonnull NSString *)uri
        routeListener:(nonnull YMKBicycleSessionRouteListener)routeListener;
```

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

Submits a request to retrieve detailed information on a bicycle route by URI.

| Parameters |   |
| --- | --- |
| uri | The URI of the bicycle route. Starts with "ymapsbm1://route/bicycle". |
| routeListener | Listener to retrieve a list of Route objects. |

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead
