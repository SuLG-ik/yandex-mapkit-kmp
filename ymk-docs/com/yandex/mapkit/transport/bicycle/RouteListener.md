---
title: "RouteListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / RouteListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/RouteListener.html"
---
# RouteListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/RouteListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

`static interface RouteListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onBicycleRoutes(@NonNull java.util.List<Route> routes)` |
| `void` | `onBicycleRoutesError(@NonNull Error error)` |

## Methods

### onBicycleRoutes

```java
@UiThread
void onBicycleRoutes(@NonNull java.util.List<Route> routes)
```

### onBicycleRoutesError

```java
@UiThread
void onBicycleRoutesError(@NonNull Error error)
```
