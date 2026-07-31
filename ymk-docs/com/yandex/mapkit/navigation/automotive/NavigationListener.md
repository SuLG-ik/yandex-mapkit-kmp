---
title: "NavigationListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / NavigationListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationListener.html"
---
# NavigationListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/NavigationListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface NavigationListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onRoutesRequested(@NonNull java.util.List<RequestPoint> points)` |
| `void` | `onAlternativesRequested(@NonNull DrivingRoute currentRoute)`<br>Calls when a user requested alternatives for the current route. |
| `void` | `onUriResolvingRequested(@NonNull java.lang.String uri)` |
| `void` | `onMatchRouteResolvingRequested()` |
| `void` | `onRoutesBuilt()`<br>Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation.routes() will have current route and fastest alternative for the request moment along with received alternatives. |
| `void` | `onRoutesRequestError(@NonNull Error error)`<br>Will be called when an error occurs during routes, alternatives or uri request |
| `void` | `onResetRoutes()` |

## Methods

### onRoutesRequested

```java
@UiThread
void onRoutesRequested(@NonNull java.util.List<RequestPoint> points)
```

### onAlternativesRequested

```java
@UiThread
void onAlternativesRequested(@NonNull DrivingRoute currentRoute)
```

Calls when a user requested alternatives for the current route.

After this callback Navigation will have the current route and fastest alternative route (if available) in Navigation.routes()

### onUriResolvingRequested

```java
@UiThread
void onUriResolvingRequested(@NonNull java.lang.String uri)
```

### onMatchRouteResolvingRequested

```java
@UiThread
void onMatchRouteResolvingRequested()
```

### onRoutesBuilt

```java
@UiThread
void onRoutesBuilt()
```

Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation.routes() will have current route and fastest alternative for the request moment along with received alternatives.

### onRoutesRequestError

```java
@UiThread
void onRoutesRequestError(@NonNull Error error)
```

Will be called when an error occurs during routes, alternatives or uri request

### onResetRoutes

```java
@UiThread
void onResetRoutes()
```
