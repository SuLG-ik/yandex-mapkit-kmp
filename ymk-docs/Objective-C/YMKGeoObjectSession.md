---
title: "YMKGeoObjectSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKGeoObjectSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectSession.html"
---
# YMKGeoObjectSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGeoObjectSession.html)

```objectivec
@interface YMKGeoObjectSession : NSObject
```

The interface for working with the session.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Cancels the current request

```objectivec
- (void)retryWithGeoObjectHandler:
    (nonnull YMKGeoObjectSessionGeoObjectHandler)geoObjectHandler;
```

Retries the last request

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Cancels the current request.

### retryWithGeoObjectHandler:

```objectivec
- (void)retryWithGeoObjectHandler:
    (nonnull YMKGeoObjectSessionGeoObjectHandler)geoObjectHandler;
```

Retries the last request. Cancels the current request if it is active.
