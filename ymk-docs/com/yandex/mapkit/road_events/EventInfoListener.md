---
title: "EventInfoListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events"
section: "Android / Справочник / com.yandex.mapkit.road_events / EventInfoListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventInfoListener.html"
---
# EventInfoListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventInfoListener.html)

**Package** com.yandex.mapkit.road_events

`static interface EventInfoListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onEventInfoReceived(@NonNull GeoObject event)` |
| `void` | `onEventInfoError(@NonNull Error error)` |

## Methods

### onEventInfoReceived

```java
@UiThread
void onEventInfoReceived(@NonNull GeoObject event)
```

### onEventInfoError

```java
@UiThread
void onEventInfoError(@NonNull Error error)
```
