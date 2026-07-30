---
title: "YMKBicycleSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBicycleSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSession.html"
---
# YMKBicycleSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBicycleSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKBicycleSession : NSObject
```

Handler for an async request for bicycle routes.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Tries to cancel the current request for bicycle routes

```objectivec
- (void)retryWithRouteListener:
    (nonnull YMKBicycleSessionRouteListener)routeListener;
```

Retries the request for bicycle routes using the specified callback

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Tries to cancel the current request for bicycle routes.

### retryWithRouteListener:

```objectivec
- (void)retryWithRouteListener:
    (nonnull YMKBicycleSessionRouteListener)routeListener;
```

Retries the request for bicycle routes using the specified callback.
