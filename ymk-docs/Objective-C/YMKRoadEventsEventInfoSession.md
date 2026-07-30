---
title: "YMKRoadEventsEventInfoSession"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsEventInfoSession"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsEventInfoSession.html"
---
# YMKRoadEventsEventInfoSession

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsEventInfoSession.html)

```objectivec
@interface YMKRoadEventsEventInfoSession : NSObject
```

Session for requesting road event info.

## Summary

### Instance methods

```objectivec
- (void)retryWithResponseHandler:
    (nonnull YMKRoadEventsEventInfoSessionResponseHandler)responseHandler;
```

One of the following errors can happen: YRTNotFoundError, YRTNetworkError, YRTRemoteError

```objectivec
- (void)cancel;
```

## Instance methods

### retryWithResponseHandler:

```objectivec
- (void)retryWithResponseHandler:
    (nonnull YMKRoadEventsEventInfoSessionResponseHandler)responseHandler;
```

One of the following errors can happen: YRTNotFoundError, YRTNetworkError, YRTRemoteError.

### cancel

```objectivec
- (void)cancel;
```
