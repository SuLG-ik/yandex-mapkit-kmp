---
title: "YMKMasstransitRouter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouter.html"
---
# YMKMasstransitRouter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitRouter : NSObject
```

Provides methods for submitting mass transit routing requests.

## Summary

### Instance methods

```objectivec
- (nonnull YMKMasstransitSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
             transitOptions:(nonnull YMKTransitOptions *)transitOptions
               routeOptions:(nonnull YMKRouteOptions *)routeOptions
               routeHandler:
                   (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to find mass transit routes

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                    transitOptions:(nonnull YMKTransitOptions *)transitOptions
                      routeOptions:(nonnull YMKRouteOptions *)routeOptions
                    summaryHandler:
                        (nonnull YMKMasstransitSummarySessionSummaryHandler)
                            summaryHandler;
```

Submits a request to fetch a brief summary of a mass transit route

```objectivec
- (nonnull YMKMasstransitSession *)
    resolveUriWithUri:(nonnull NSString *)uri
          timeOptions:(nonnull YMKTimeOptions *)timeOptions
         routeHandler:(nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to retrieve detailed information on a mass transit route by URI

```objectivec
- (nonnull YMKMasstransitRouteSerializer *)routeSerializer;
```

Returns a route serializer instance

## Instance methods

### requestRoutesWithPoints:transitOptions:routeOptions:routeHandler:

```objectivec
- (nonnull YMKMasstransitSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
             transitOptions:(nonnull YMKTransitOptions *)transitOptions
               routeOptions:(nonnull YMKRouteOptions *)routeOptions
               routeHandler:
                   (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to find mass transit routes.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| transitOptions | Additional parameters for building routes. |
| routeOptions | Options for route personalization. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummaryWithPoints:transitOptions:routeOptions:summaryHandler:

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                    transitOptions:(nonnull YMKTransitOptions *)transitOptions
                      routeOptions:(nonnull YMKRouteOptions *)routeOptions
                    summaryHandler:
                        (nonnull YMKMasstransitSummarySessionSummaryHandler)
                            summaryHandler;
```

Submits a request to fetch a brief summary of a mass transit route.

### resolveUriWithUri:timeOptions:routeHandler:

```objectivec
- (nonnull YMKMasstransitSession *)
    resolveUriWithUri:(nonnull NSString *)uri
          timeOptions:(nonnull YMKTimeOptions *)timeOptions
         routeHandler:(nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to retrieve detailed information on a mass transit route by URI.

| Parameters |   |
| --- | --- |
| uri | The URI of the mass transit route. Starts with "ymapsbm1://route/transit". |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer

```objectivec
- (nonnull YMKMasstransitRouteSerializer *)routeSerializer;
```

Returns a route serializer instance.
