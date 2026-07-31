---
title: "YMKDrivingSummarySession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKDrivingSummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSummarySession.html"
---
# YMKDrivingSummarySession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKDrivingSummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKDrivingSummarySession : NSObject
```

Driving session summary.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Cancels route summary generation

```objectivec
- (void)retryWithSummaryHandler:
    (nonnull YMKDrivingSummarySessionSummaryHandler)summaryHandler;
```

Tries to generate a driving session summary again

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Cancels route summary generation.

### retryWithSummaryHandler:

```objectivec
- (void)retryWithSummaryHandler:
    (nonnull YMKDrivingSummarySessionSummaryHandler)summaryHandler;
```

Tries to generate a driving session summary again.
