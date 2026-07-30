---
title: "MasstransitRouter"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / MasstransitRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/MasstransitRouter.html"
---
# MasstransitRouter

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/MasstransitRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface MasstransitRouter`

Provides methods for submitting mass transit routing requests.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Session` | `requestRoutes(@NonNull java.util.List<RequestPoint> points, @NonNull TransitOptions transitOptions, @NonNull RouteOptions routeOptions, @NonNull RouteListener routeListener)`<br>Submits a request to find mass transit routes. |
| `SummarySession` | `requestRoutesSummary(@NonNull java.util.List<RequestPoint> points, @NonNull TransitOptions transitOptions, @NonNull RouteOptions routeOptions, @NonNull SummaryListener summaryListener)`<br>Submits a request to fetch a brief summary of a mass transit route. |
| `Session` | `resolveUri(@NonNull java.lang.String uri, @NonNull TimeOptions timeOptions, @NonNull RouteListener routeListener)`<br>Submits a request to retrieve detailed information on a mass transit route by URI. |
| `MasstransitRouteSerializer` | `routeSerializer()`<br>Returns a route serializer instance. |

## Methods

### requestRoutes

```java
@NonNull
Session requestRoutes(@NonNull java.util.List<RequestPoint> points,
                      @NonNull TransitOptions transitOptions,
                      @NonNull RouteOptions routeOptions,
                      @NonNull RouteListener routeListener)
```

Submits a request to find mass transit routes.

| Parameters |   |
| --- | --- |
| `points` | Route points (See [mapkit.RequestPoint](../../RequestPoint.md) for details). Currently only two points are supported (start and finish) |
| `transitOptions` | Additional parameters for building routes. |
| `routeOptions` | Options for route personalization. |
| `routeListener` | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummary

```java
@NonNull
SummarySession requestRoutesSummary(@NonNull java.util.List<RequestPoint> points,
                                    @NonNull TransitOptions transitOptions,
                                    @NonNull RouteOptions routeOptions,
                                    @NonNull SummaryListener summaryListener)
```

Submits a request to fetch a brief summary of a mass transit route.

### resolveUri

```java
@NonNull
Session resolveUri(@NonNull java.lang.String uri,
                   @NonNull TimeOptions timeOptions,
                   @NonNull RouteListener routeListener)
```

Submits a request to retrieve detailed information on a mass transit route by URI.

| Parameters |   |
| --- | --- |
| `uri` | The URI of the mass transit route. Starts with "ymapsbm1://route/transit". |
| `timeOptions` | Desired departure/arrival time settings. Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent. |
| `routeListener` | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer

```java
@NonNull
MasstransitRouteSerializer routeSerializer()
```

Returns a route serializer instance.
