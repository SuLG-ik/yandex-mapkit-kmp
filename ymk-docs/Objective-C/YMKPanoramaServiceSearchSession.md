---
title: "YMKPanoramaServiceSearchSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKPanoramaServiceSearchSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaServiceSearchSession.html"
---
# YMKPanoramaServiceSearchSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKPanoramaServiceSearchSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKPanoramaServiceSearchSession : NSObject
```

Session for receiving the result of the findNearest() method.

Should be stored until the listener is notified. Can be used to cancel the active request. Can be used to retry the last request (for example, if it failed).

## Summary

### Instance methods

```objectivec
- (void)retryWithSearchHandler:
    (nonnull YMKPanoramaServiceSearchHandler)searchHandler;
```

Retries the last request

```objectivec
- (void)cancel;
```

Cancels the active request

## Instance methods

### retryWithSearchHandler:

```objectivec
- (void)retryWithSearchHandler:
    (nonnull YMKPanoramaServiceSearchHandler)searchHandler;
```

Retries the last request.

### cancel

```objectivec
- (void)cancel;
```

Cancels the active request.
