---
title: "DrivingRouteListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingRouteListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouteListener.html"
---
# DrivingRouteListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingRouteListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`static interface DrivingRouteListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onDrivingRoutes(@NonNull java.util.List<DrivingRoute> routes)`<br>Happens when driving routes are generated. |
| `void` | `onDrivingRoutesError(@NonNull Error error)`<br>Happens when there is an error. |

## Methods

### onDrivingRoutes

```java
@UiThread
void onDrivingRoutes(@NonNull java.util.List<DrivingRoute> routes)
```

Happens when driving routes are generated.

### onDrivingRoutesError

```java
@UiThread
void onDrivingRoutesError(@NonNull Error error)
```

Happens when there is an error.
