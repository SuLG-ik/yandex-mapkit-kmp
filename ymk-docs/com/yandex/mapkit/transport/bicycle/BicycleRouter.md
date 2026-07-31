---
title: "BicycleRouter"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / BicycleRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/BicycleRouter.html"
---
# BicycleRouter

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/BicycleRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

`interface BicycleRouter`

> [!CAUTION] Внимание
> use masstransit.BicycleRouterV2 instead Provides methods for submitting bicycle routing requests.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Session` | `requestRoutes(@NonNull java.util.List<RequestPoint> points, @NonNull VehicleType type, @NonNull RouteListener routeListener)`<br>Submits a request to find a bicycle route. |
| `SummarySession` | `requestRoutesSummary(@NonNull java.util.List<RequestPoint> points, @NonNull VehicleType type, @NonNull SummaryListener summaryListener)`<br>Submits a request to fetch a brief summary of the bicycle routes. |
| `Session` | `resolveUri(@NonNull java.lang.String uri, @NonNull RouteListener routeListener)`<br>Submits a request to retrieve detailed information on a bicycle route by URI. |

## Methods

### requestRoutes

```java
@NonNull
Session requestRoutes(@NonNull java.util.List<RequestPoint> points,
                      @NonNull VehicleType type,
                      @NonNull RouteListener routeListener)
```

Submits a request to find a bicycle route.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

| Parameters |   |
| --- | --- |
| `points` | Route points (See [mapkit.RequestPoint](../../RequestPoint.md) for details). Currently only two points are supported (start and finish). |
| `routeListener` | Listener to retrieve a list of Route objects. |

### requestRoutesSummary

```java
@NonNull
SummarySession requestRoutesSummary(@NonNull java.util.List<RequestPoint> points,
                                    @NonNull VehicleType type,
                                    @NonNull SummaryListener summaryListener)
```

Submits a request to fetch a brief summary of the bicycle routes.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

| Parameters |   |
| --- | --- |
| `points` | Route points (See [mapkit.RequestPoint](../../RequestPoint.md) for details). Currently only two points are supported (start and finish). |
| `summaryListener` | Listener to retrieve a list of Route objects. |

### resolveUri

```java
@NonNull
Session resolveUri(@NonNull java.lang.String uri,
                   @NonNull RouteListener routeListener)
```

Submits a request to retrieve detailed information on a bicycle route by URI.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

| Parameters |   |
| --- | --- |
| `uri` | The URI of the bicycle route. Starts with "ymapsbm1://route/bicycle". |
| `routeListener` | Listener to retrieve a list of Route objects. |
