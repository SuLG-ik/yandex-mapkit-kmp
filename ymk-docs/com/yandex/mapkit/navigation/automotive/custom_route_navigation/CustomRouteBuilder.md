---
title: "CustomRouteBuilder"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive.custom_route_navigation"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive.custom_route_navigation / CustomRouteBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteBuilder.html"
---
# CustomRouteBuilder

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/custom_route_navigation/CustomRouteBuilder.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive.custom_route_navigation

`interface CustomRouteBuilder`

Interface for building driving route along a user-provided polyline.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `DrivingSession` | `requestRoute(@NonNull Polyline polyline, @NonNull Point initialPoint, @Nullable java.lang.Double initialAzimuth, @NonNull CustomRouteOptions customRouteOptions, @NonNull DrivingRouteListener routeListener)`<br>Builds a route. |

## Methods

### requestRoute

```java
@NonNull
DrivingSession requestRoute(@NonNull Polyline polyline,
                            @NonNull Point initialPoint,
                            @Nullable java.lang.Double initialAzimuth,
                            @NonNull CustomRouteOptions customRouteOptions,
                            @NonNull DrivingRouteListener routeListener)
```

Builds a route.

| Parameters |   |
| --- | --- |
| `polyline` | Route polyline. |
| `initialPoint` | Initial point. |
| `initialAzimuth` | Initial azimuth. |
| `customRouteOptions` | Custom route options. |
| `routeListener` | Route listener object. |
