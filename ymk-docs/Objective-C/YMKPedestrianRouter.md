---
title: "YMKPedestrianRouter"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPedestrianRouter"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPedestrianRouter.html"
---
# YMKPedestrianRouter

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPedestrianRouter.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPedestrianRouter : NSObject
```

Provides methods for submitting pedestrian routing requests.

## Summary

### Instance methods

```objectivec
- (nonnull YMKMasstransitSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                timeOptions:(nonnull YMKTimeOptions *)timeOptions
               routeOptions:(nonnull YMKRouteOptions *)routeOptions
               routeHandler:
                   (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to find a pedestrian route

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                       timeOptions:(nonnull YMKTimeOptions *)timeOptions
                      routeOptions:(nonnull YMKRouteOptions *)routeOptions
                    summaryHandler:
                        (nonnull YMKMasstransitSummarySessionSummaryHandler)
                            summaryHandler;
```

Submits a request to fetch a brief summary of a pedestrian route

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithFrom:(nonnull YMKRequestPoint *)from
                              to:(nonnull NSArray<YMKRequestPoint *> *)to
                     timeOptions:(nonnull YMKTimeOptions *)timeOptions
                    routeOptions:(nonnull YMKRouteOptions *)routeOptions
                  summaryHandler:
                      (nonnull YMKMasstransitSummarySessionSummaryHandler)
                          summaryHandler;
```

Submits a request to fetch a brief summary of the pedestrian routes from one to many points

```objectivec
- (nonnull YMKMasstransitSession *)
    resolveUriWithUri:(nonnull NSString *)uri
          timeOptions:(nonnull YMKTimeOptions *)timeOptions
         routeHandler:(nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to retrieve detailed information on the pedestrian route by URI

```objectivec
- (nonnull YMKMasstransitRouteSerializer *)routeSerializer;
```

Route serializer

## Instance methods

### requestRoutesWithPoints:timeOptions:routeOptions:routeHandler:

```objectivec
- (nonnull YMKMasstransitSession *)
    requestRoutesWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                timeOptions:(nonnull YMKTimeOptions *)timeOptions
               routeOptions:(nonnull YMKRouteOptions *)routeOptions
               routeHandler:
                   (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to find a pedestrian route.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### requestRoutesSummaryWithPoints:timeOptions:routeOptions:summaryHandler:

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithPoints:(nonnull NSArray<YMKRequestPoint *> *)points
                       timeOptions:(nonnull YMKTimeOptions *)timeOptions
                      routeOptions:(nonnull YMKRouteOptions *)routeOptions
                    summaryHandler:
                        (nonnull YMKMasstransitSummarySessionSummaryHandler)
                            summaryHandler;
```

Submits a request to fetch a brief summary of a pedestrian route.

| Parameters |   |
| --- | --- |
| points | Route points (See YMKRequestPoint for details). Currently only two points are supported (start and finish) |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| summaryListener | Listener to retrieve a list of summaries. |

### requestRoutesSummaryWithFrom:to:timeOptions:routeOptions:summaryHandler:

```objectivec
- (nonnull YMKMasstransitSummarySession *)
    requestRoutesSummaryWithFrom:(nonnull YMKRequestPoint *)from
                              to:(nonnull NSArray<YMKRequestPoint *> *)to
                     timeOptions:(nonnull YMKTimeOptions *)timeOptions
                    routeOptions:(nonnull YMKRouteOptions *)routeOptions
                  summaryHandler:
                      (nonnull YMKMasstransitSummarySessionSummaryHandler)
                          summaryHandler;
```

Submits a request to fetch a brief summary of the pedestrian routes from one to many points.

| Parameters |   |
| --- | --- |
| from | Starting point (See YMKRequestPoint for details). |
| to | End points. |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeOptions | Options for route personalization. |
| summaryListener | Listener to retrieve a list of summaries. |

### resolveUriWithUri:timeOptions:routeHandler:

```objectivec
- (nonnull YMKMasstransitSession *)
    resolveUriWithUri:(nonnull NSString *)uri
          timeOptions:(nonnull YMKTimeOptions *)timeOptions
         routeHandler:(nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Submits a request to retrieve detailed information on the pedestrian route by URI.

| Parameters |   |
| --- | --- |
| uri | Pedestrian route URI. Begins with "ymapsbm1://route/pedestrian". |
| timeOptions | Desired departure/arrival time settings. Empty YMKTimeOptions for requests that are not time-dependent. |
| routeListener | Listener to retrieve a list of MasstransitRoute objects. |

### routeSerializer

```objectivec
- (nonnull YMKMasstransitRouteSerializer *)routeSerializer;
```

Route serializer.
