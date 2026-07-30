---
title: "RouteListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / RouteListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteListener.html"
---
# RouteListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/RouteListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`static interface RouteListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMasstransitRoutes(@NonNull java.util.List<Route> routes)`<br>The route is generated. |
| `void` | `onMasstransitRoutesError(@NonNull Error error)`<br>An error occurred while generating the route. |

## Methods

### onMasstransitRoutes

```java
@UiThread
void onMasstransitRoutes(@NonNull java.util.List<Route> routes)
```

The route is generated.

### onMasstransitRoutesError

```java
@UiThread
void onMasstransitRoutesError(@NonNull Error error)
```

An error occurred while generating the route.
