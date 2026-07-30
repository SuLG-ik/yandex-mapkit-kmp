---
title: "YMKNavigationCustomRouteBuilder"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKNavigationCustomRouteBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationCustomRouteBuilder.html"
---
# YMKNavigationCustomRouteBuilder

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationCustomRouteBuilder.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKNavigationCustomRouteBuilder : NSObject
```

Interface for building driving route along a user-provided polyline.

## Summary

### Instance methods

```objectivec
- (nonnull YMKDrivingSession *)
    requestRouteWithPolyline:(nonnull YMKPolyline *)polyline
                initialPoint:(nonnull YMKPoint *)initialPoint
              initialAzimuth:(nullable NSNumber *)initialAzimuth
          customRouteOptions:
              (nonnull YMKNavigationCustomRouteOptions *)customRouteOptions
                routeHandler:
                    (nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route

## Instance methods

### requestRouteWithPolyline:initialPoint:initialAzimuth:customRouteOptions:routeHandler:

```objectivec
- (nonnull YMKDrivingSession *)
    requestRouteWithPolyline:(nonnull YMKPolyline *)polyline
                initialPoint:(nonnull YMKPoint *)initialPoint
              initialAzimuth:(nullable NSNumber *)initialAzimuth
          customRouteOptions:
              (nonnull YMKNavigationCustomRouteOptions *)customRouteOptions
                routeHandler:
                    (nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Builds a route.

| Parameters |   |
| --- | --- |
| polyline | Route polyline. |
| initialPoint | Initial point. |
| initialAzimuth | Initial azimuth. |
| customRouteOptions | Custom route options. |
| routeListener | Route listener object. |
