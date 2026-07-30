---
title: "PedestrianRouter"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / PedestrianRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/PedestrianRouter.html"
---
# PedestrianRouter

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/PedestrianRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface PedestrianRouter`

Provides methods for submitting pedestrian routing requests.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Session` | `requestRoutes(@NonNull java.util.List<RequestPoint> points, @NonNull TimeOptions timeOptions, @NonNull RouteOptions routeOptions, @NonNull RouteListener routeListener)`<br>Submits a request to find a pedestrian route. |
| `SummarySession` | `requestRoutesSummary(@NonNull java.util.List<RequestPoint> points, @NonNull TimeOptions timeOptions, @NonNull RouteOptions routeOptions, @NonNull SummaryListener summaryListener)`<br>Submits a request to fetch a brief summary of a pedestrian route. |
| `SummarySession` | `requestRoutesSummary(@NonNull RequestPoint from, @NonNull java.util.List<RequestPoint> to, @NonNull TimeOptions timeOptions, @NonNull RouteOptions routeOptions, @NonNull SummaryListener summaryListener)`<br>Submits a request to fetch a brief summary of the pedestrian routes from one to many points. |
| `Session` | `resolveUri(@NonNull java.lang.String uri, @NonNull TimeOptions timeOptions, @NonNull RouteListener routeListener)`<br>Submits a request to retrieve detailed information on the pedestrian route by URI. |
| `MasstransitRouteSerializer` | `routeSerializer()`<br>Route serializer. |

## Methods

### requestRoutes

```java
@NonNull
Session requestRoutes(@NonNull java.util.List<RequestPoint> points,
                      @NonNull TimeOptions timeOptions,
                      @NonNull RouteOptions routeOptions,
                      @NonNull RouteListener routeListener)
```

Submits a request to find a pedestrian route.

| Parameters |   |
| --- | --- |
| `points` | Route points (See [mapkit.RequestPoint](../../RequestPoint.md) for details). Currently only two points are supported (start and finish) |
| `timeOptions` | Desired departure/arrival time settings. Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent. |
| `routeOptions` | Options for route personalization. |
| `routeListener` | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummary

```java
@NonNull
SummarySession requestRoutesSummary(@NonNull java.util.List<RequestPoint> points,
                                    @NonNull TimeOptions timeOptions,
                                    @NonNull RouteOptions routeOptions,
                                    @NonNull SummaryListener summaryListener)
```

Submits a request to fetch a brief summary of a pedestrian route.

| Parameters |   |
| --- | --- |
| `points` | Route points (See [mapkit.RequestPoint](../../RequestPoint.md) for details). Currently only two points are supported (start and finish) |
| `timeOptions` | Desired departure/arrival time settings. Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent. |
| `routeOptions` | Options for route personalization. |
| `summaryListener` | Listener to retrieve a list of summaries. |

### requestRoutesSummary

```java
@NonNull
SummarySession requestRoutesSummary(@NonNull RequestPoint from,
                                    @NonNull java.util.List<RequestPoint> to,
                                    @NonNull TimeOptions timeOptions,
                                    @NonNull RouteOptions routeOptions,
                                    @NonNull SummaryListener summaryListener)
```

Submits a request to fetch a brief summary of the pedestrian routes from one to many points.

| Parameters |   |
| --- | --- |
| `from` | Starting point (See [mapkit.RequestPoint](../../RequestPoint.md) for details). |
| `to` | End points. |
| `timeOptions` | Desired departure/arrival time settings. Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent. |
| `routeOptions` | Options for route personalization. |
| `summaryListener` | Listener to retrieve a list of summaries. |

### resolveUri

```java
@NonNull
Session resolveUri(@NonNull java.lang.String uri,
                   @NonNull TimeOptions timeOptions,
                   @NonNull RouteListener routeListener)
```

Submits a request to retrieve detailed information on the pedestrian route by URI.

| Parameters |   |
| --- | --- |
| `uri` | Pedestrian route URI. Begins with "ymapsbm1://route/pedestrian". |
| `timeOptions` | Desired departure/arrival time settings. Empty [mapkit.transport.masstransit.TimeOptions](TimeOptions.md) for requests that are not time-dependent. |
| `routeListener` | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer

```java
@NonNull
MasstransitRouteSerializer routeSerializer()
```

Route serializer.
