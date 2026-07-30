---
title: "YMKMasstransitSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSession.html"
---
# YMKMasstransitSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSession : NSObject
```

Handler for an async request for mass transit routes.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Tries to cancel the current request for mass transit routes

```objectivec
- (void)retryWithRouteHandler:
    (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Retries the request for mass transit routes using the specified callback

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Tries to cancel the current request for mass transit routes.

### retryWithRouteHandler:

```objectivec
- (void)retryWithRouteHandler:
    (nonnull YMKMasstransitSessionRouteHandler)routeHandler;
```

Retries the request for mass transit routes using the specified callback.
