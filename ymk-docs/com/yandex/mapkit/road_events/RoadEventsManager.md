---
title: "RoadEventsManager"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events"
section: "Android / Справочник / com.yandex.mapkit.road_events / RoadEventsManager"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/RoadEventsManager.html"
---
# RoadEventsManager

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/RoadEventsManager.html)

**Package** com.yandex.mapkit.road_events

`interface RoadEventsManager`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `EventInfoSession` | `requestEventInfo(@NonNull java.lang.String eventId, @NonNull EventInfoListener eventInfoListener)`<br>Begins asynchronous request for road event info. |

## Methods

### requestEventInfo

```java
@NonNull
EventInfoSession requestEventInfo(@NonNull java.lang.String eventId,
                                  @NonNull EventInfoListener eventInfoListener)
```

Begins asynchronous request for road event info.

| Parameters |   |
| --- | --- |
| `eventId` | ID of the event to request information for. |
| `eventInfoListener` | Listener for result or error. |
