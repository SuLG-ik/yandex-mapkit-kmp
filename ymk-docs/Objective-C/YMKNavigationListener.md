---
title: "YMKNavigationListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKNavigationListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationListener.html"
---
# YMKNavigationListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKNavigationListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKNavigationListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onRoutesRequestedWithPoints:
    (nonnull NSArray<YMKRequestPoint *> *)points;
```

```objectivec
- (void)onAlternativesRequestedWithCurrentRoute:
    (nonnull YMKDrivingRoute *)currentRoute;
```

Calls when a user requested alternatives for the current route

```objectivec
- (void)onUriResolvingRequestedWithUri:(nonnull NSString *)uri;
```

```objectivec
- (void)onMatchRouteResolvingRequested;
```

```objectivec
- (void)onRoutesBuilt;
```

Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation

```objectivec
- (void)onRoutesRequestErrorWithError:(nonnull NSError *)error;
```

Will be called when an error occurs during routes, alternatives or uri request

```objectivec
- (void)onResetRoutes;
```

## Instance methods

### onRoutesRequestedWithPoints:

```objectivec
- (void)onRoutesRequestedWithPoints:
    (nonnull NSArray<YMKRequestPoint *> *)points;
```

### onAlternativesRequestedWithCurrentRoute:

```objectivec
- (void)onAlternativesRequestedWithCurrentRoute:
    (nonnull YMKDrivingRoute *)currentRoute;
```

Calls when a user requested alternatives for the current route. After this callback Navigation will have the current route and fastest alternative route (if available) in Navigation.routes()

### onUriResolvingRequestedWithUri:

```objectivec
- (void)onUriResolvingRequestedWithUri:(nonnull NSString *)uri;
```

### onMatchRouteResolvingRequested

```objectivec
- (void)onMatchRouteResolvingRequested;
```

### onRoutesBuilt

```objectivec
- (void)onRoutesBuilt;
```

Calls when routes, alternatives, or URI request succeeds After alternatives request Navigation.routes() will have current route and fastest alternative for the request moment along with received alternatives.

### onRoutesRequestErrorWithError:

```objectivec
- (void)onRoutesRequestErrorWithError:(nonnull NSError *)error;
```

Will be called when an error occurs during routes, alternatives or uri request

### onResetRoutes

```objectivec
- (void)onResetRoutes;
```
