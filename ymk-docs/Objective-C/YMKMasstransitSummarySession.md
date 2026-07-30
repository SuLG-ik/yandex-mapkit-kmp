---
title: "YMKMasstransitSummarySession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMasstransitSummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSummarySession.html"
---
# YMKMasstransitSummarySession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMasstransitSummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKMasstransitSummarySession : NSObject
```

Handler for an async request for a summary of mass transit routes.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Tries to cancel the current request for a summary of mass transit routes

```objectivec
- (void)retryWithSummaryHandler:
    (nonnull YMKMasstransitSummarySessionSummaryHandler)summaryHandler;
```

Retries the request for a summary of mass transit routes, using the specified callback

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Tries to cancel the current request for a summary of mass transit routes.

### retryWithSummaryHandler:

```objectivec
- (void)retryWithSummaryHandler:
    (nonnull YMKMasstransitSummarySessionSummaryHandler)summaryHandler;
```

Retries the request for a summary of mass transit routes, using the specified callback.
