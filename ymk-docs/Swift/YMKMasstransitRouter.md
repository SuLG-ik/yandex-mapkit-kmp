---
title: "YMKMasstransitRouter"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouter.html"
---
# YMKMasstransitRouter

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitRouter : NSObject
```

Provides methods for submitting mass transit routing requests.

## Summary

### Instance methods

```swift
func requestRoutes(with points: [YMKRequestPoint],
                transitOptions: YMKTransitOptions,
                  routeOptions: YMKRouteOptions,
                  routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to find mass transit routes

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                       transitOptions: YMKTransitOptions,
                         routeOptions: YMKRouteOptions,
                       summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of a mass transit route

```swift
func resolveUri(withUri uri: String,
                timeOptions: YMKTimeOptions,
               routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to retrieve detailed information on a mass transit route by URI

```swift
func routeSerializer() -> YMKMasstransitRouteSerializer
```

Returns a route serializer instance

## Instance methods

### requestRoutes(with:transitOptions:routeOptions:routeHandler:)

```swift
func requestRoutes(with points: [YMKRequestPoint],
                transitOptions: YMKTransitOptions,
                  routeOptions: YMKRouteOptions,
                  routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to find mass transit routes.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| transitOptions | Additional parameters for building routes. |
| routeOptions | Options for route personalization. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummary(with:transitOptions:routeOptions:summaryHandler:)

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                       transitOptions: YMKTransitOptions,
                         routeOptions: YMKRouteOptions,
                       summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of a mass transit route.

### resolveUri(withUri:timeOptions:routeHandler:)

```swift
func resolveUri(withUri uri: String,
                timeOptions: YMKTimeOptions,
               routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to retrieve detailed information on a mass transit route by URI.

| Parameters |   |
| --- | --- |
| uri | The URI of the mass transit route. Starts with "ymapsbm1://route/transit". |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer()

```swift
func routeSerializer() -> YMKMasstransitRouteSerializer
```

Returns a route serializer instance.
