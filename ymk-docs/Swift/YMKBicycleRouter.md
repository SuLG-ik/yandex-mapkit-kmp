---
title: "YMKBicycleRouter"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBicycleRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRouter.html"
---
# YMKBicycleRouter

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBicycleRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKBicycleRouter : NSObject
```

Provides methods for submitting bicycle routing requests.

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead

## Summary

### Instance methods

```swift
func requestRoutes(with points: [YMKRequestPoint],
                          type: YMKBicycleVehicleType,
                 routeListener: @escaping YMKBicycleSessionRouteListener) -> YMKBicycleSession
```

Submits a request to find a bicycle route

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                                 type: YMKBicycleVehicleType,
                       summaryHandler: @escaping YMKBicycleSummarySessionSummaryHandler) -> YMKBicycleSummarySession
```

Submits a request to fetch a brief summary of the bicycle routes

```swift
func resolveUri(withUri uri: String,
              routeListener: @escaping YMKBicycleSessionRouteListener) -> YMKBicycleSession
```

Submits a request to retrieve detailed information on a bicycle route by URI

## Instance methods

### requestRoutes(with:type:routeListener:)

```swift
func requestRoutes(with points: [YMKRequestPoint],
                          type: YMKBicycleVehicleType,
                 routeListener: @escaping YMKBicycleSessionRouteListener) -> YMKBicycleSession
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

### requestRoutesSummary(with:type:summaryHandler:)

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                                 type: YMKBicycleVehicleType,
                       summaryHandler: @escaping YMKBicycleSummarySessionSummaryHandler) -> YMKBicycleSummarySession
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

### resolveUri(withUri:routeListener:)

```swift
func resolveUri(withUri uri: String,
              routeListener: @escaping YMKBicycleSessionRouteListener) -> YMKBicycleSession
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
