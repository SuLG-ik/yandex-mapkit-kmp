---
title: "YMKSearchDeleteAllPersonalSuggestSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSearchDeleteAllPersonalSuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDeleteAllPersonalSuggestSession.html"
---
# YMKSearchDeleteAllPersonalSuggestSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSearchDeleteAllPersonalSuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```objectivec
@interface YMKSearchDeleteAllPersonalSuggestSession : NSObject
```

Interface to handle remove all user personalized suggest request. Allows request cancellation and retry.

## Summary

### Instance methods

```objectivec
- (void)cancel;
```

Cancels the current request

```objectivec
- (void)retryWithPersonalSuggestHandler:
    (nonnull YMKSearchDeleteAllPersonalSuggestSessionPersonalSuggestHandler)
        personalSuggestHandler;
```

Retries the last request

## Instance methods

### cancel

```objectivec
- (void)cancel;
```

Cancels the current request.

### retryWithPersonalSuggestHandler:

```objectivec
- (void)retryWithPersonalSuggestHandler:
    (nonnull YMKSearchDeleteAllPersonalSuggestSessionPersonalSuggestHandler)
        personalSuggestHandler;
```

Retries the last request. If there is an active request, it is cancelled.

| Parameters |   |
| --- | --- |
| personalSuggestListener | Listener to handle result. |
