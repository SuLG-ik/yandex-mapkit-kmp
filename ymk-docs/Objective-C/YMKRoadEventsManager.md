---
title: "YMKRoadEventsManager"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKRoadEventsManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsManager.html"
---
# YMKRoadEventsManager

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKRoadEventsManager.html)

```objectivec
@interface YMKRoadEventsManager : NSObject
```

## Summary

### Instance methods

```objectivec
- (nonnull YMKRoadEventsEventInfoSession *)
    requestEventInfoWithEventId:(nonnull NSString *)eventId
                responseHandler:
                    (nonnull YMKRoadEventsEventInfoSessionResponseHandler)
                        responseHandler;
```

Begins asynchronous request for road event info

## Instance methods

### requestEventInfoWithEventId:responseHandler:

```objectivec
- (nonnull YMKRoadEventsEventInfoSession *)
    requestEventInfoWithEventId:(nonnull NSString *)eventId
                responseHandler:
                    (nonnull YMKRoadEventsEventInfoSessionResponseHandler)
                        responseHandler;
```

Begins asynchronous request for road event info.

| Parameters |   |
| --- | --- |
| eventId | ID of the event to request information for. |
| eventInfoListener | Listener for result or error. |
