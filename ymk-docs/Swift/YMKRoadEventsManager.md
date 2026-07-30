---
title: "YMKRoadEventsManager"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRoadEventsManager"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsManager.html"
---
# YMKRoadEventsManager

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRoadEventsManager.html)

```swift
class YMKRoadEventsManager : NSObject
```

## Summary

### Instance methods

```swift
func requestEventInfo(withEventId eventId: String,
                          responseHandler: @escaping YMKRoadEventsEventInfoSessionResponseHandler) -> YMKRoadEventsEventInfoSession
```

Begins asynchronous request for road event info

## Instance methods

### requestEventInfo(withEventId:responseHandler:)

```swift
func requestEventInfo(withEventId eventId: String,
                          responseHandler: @escaping YMKRoadEventsEventInfoSessionResponseHandler) -> YMKRoadEventsEventInfoSession
```

Begins asynchronous request for road event info.

| Parameters |   |
| --- | --- |
| eventId | ID of the event to request information for. |
| eventInfoListener | Listener for result or error. |
