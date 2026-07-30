---
title: "YMKPedestrianRouter"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPedestrianRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPedestrianRouter.html"
---
# YMKPedestrianRouter

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPedestrianRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPedestrianRouter : NSObject
```

Provides methods for submitting pedestrian routing requests.

## Summary

### Instance methods

```swift
func requestRoutes(with points: [YMKRequestPoint],
                   timeOptions: YMKTimeOptions,
                  routeOptions: YMKRouteOptions,
                  routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to find a pedestrian route

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                          timeOptions: YMKTimeOptions,
                         routeOptions: YMKRouteOptions,
                       summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of a pedestrian route

```swift
func requestRoutesSummaryWith(from: YMKRequestPoint,
                                to: [YMKRequestPoint],
                       timeOptions: YMKTimeOptions,
                      routeOptions: YMKRouteOptions,
                    summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of the pedestrian routes from one to many points

```swift
func resolveUri(withUri uri: String,
                timeOptions: YMKTimeOptions,
               routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to retrieve detailed information on the pedestrian route by URI

```swift
func routeSerializer() -> YMKMasstransitRouteSerializer
```

Route serializer

## Instance methods

### requestRoutes(with:timeOptions:routeOptions:routeHandler:)

```swift
func requestRoutes(with points: [YMKRequestPoint],
                   timeOptions: YMKTimeOptions,
                  routeOptions: YMKRouteOptions,
                  routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to find a pedestrian route.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummary(with:timeOptions:routeOptions:summaryHandler:)

```swift
func requestRoutesSummary(with points: [YMKRequestPoint],
                          timeOptions: YMKTimeOptions,
                         routeOptions: YMKRouteOptions,
                       summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of a pedestrian route.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| summaryListener | Listener to retrieve a list of summaries. |

### requestRoutesSummaryWith(from:to:timeOptions:routeOptions:summaryHandler:)

```swift
func requestRoutesSummaryWith(from: YMKRequestPoint,
                                to: [YMKRequestPoint],
                       timeOptions: YMKTimeOptions,
                      routeOptions: YMKRouteOptions,
                    summaryHandler: @escaping YMKMasstransitSummarySessionSummaryHandler) -> YMKMasstransitSummarySession
```

Submits a request to fetch a brief summary of the pedestrian routes from one to many points.

| Parameters |   |
| --- | --- |
| from | Starting point (See YMKRequestPoint for details). |
| to | End points. |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| summaryListener | Listener to retrieve a list of summaries. |

### resolveUri(withUri:timeOptions:routeHandler:)

```swift
func resolveUri(withUri uri: String,
                timeOptions: YMKTimeOptions,
               routeHandler: @escaping YMKMasstransitSessionRouteHandler) -> YMKMasstransitSession
```

Submits a request to retrieve detailed information on the pedestrian route by URI.

| Parameters |   |
| --- | --- |
| uri | Pedestrian route URI. Begins with "ymapsbm1://route/pedestrian". |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer()

```swift
func routeSerializer() -> YMKMasstransitRouteSerializer
```

Route serializer.
