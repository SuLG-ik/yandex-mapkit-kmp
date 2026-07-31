---
title: "YMKNavigationCustomRouteBuilder"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationCustomRouteBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationCustomRouteBuilder.html"
---
# YMKNavigationCustomRouteBuilder

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationCustomRouteBuilder.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationCustomRouteBuilder : NSObject
```

Interface for building driving route along a user-provided polyline.

## Summary

### Instance methods

```swift
func requestRoute(with polyline: YMKPolyline,
                   initialPoint: YMKPoint,
                 initialAzimuth: NSNumber?,
             customRouteOptions: YMKNavigationCustomRouteOptions,
                   routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route

## Instance methods

### requestRoute(with:initialPoint:initialAzimuth:customRouteOptions:routeHandler:)

```swift
func requestRoute(with polyline: YMKPolyline,
                   initialPoint: YMKPoint,
                 initialAzimuth: NSNumber?,
             customRouteOptions: YMKNavigationCustomRouteOptions,
                   routeHandler: @escaping YMKDrivingSessionRouteHandler) -> YMKDrivingSession
```

Builds a route.

| Parameters |   |
| --- | --- |
| polyline | Route polyline. |
| initialPoint | Initial point. |
| initialAzimuth | Initial azimuth. |
| customRouteOptions | Custom route options. |
| routeListener | Route listener object. |
