---
title: "YMKDrivingSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSession.html"
---
# YMKDrivingSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSession : NSObject
```

Driving session information.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Cancels the driving session

```objectivec
- (void)retryWithRouteHandler:
    (nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Tries to create a driving session again

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Cancels the driving session.

### retryWithRouteHandler:

```objectivec
- (void)retryWithRouteHandler:
    (nonnull YMKDrivingSessionRouteHandler)routeHandler;
```

Tries to create a driving session again.
