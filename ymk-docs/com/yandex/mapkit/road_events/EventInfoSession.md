---
title: "EventInfoSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.road_events"
section: "Android / Справочник / com.yandex.mapkit.road_events / EventInfoSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventInfoSession.html"
---
# EventInfoSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/road_events/EventInfoSession.html)

**Package** com.yandex.mapkit.road_events

`interface EventInfoSession`

Session for requesting road event info.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `retry(@NonNull EventInfoListener eventInfoListener)`<br>One of the following errors can happen: [runtime.network.NotFoundError](../../runtime/network/NotFoundError.md), [runtime.network.NetworkError](../../runtime/network/NetworkError.md), [runtime.network.RemoteError](../../runtime/network/RemoteError.md). |
| `void` | `cancel()` |

## Methods

### retry

```java
void retry(@NonNull EventInfoListener eventInfoListener)
```

One of the following errors can happen: [runtime.network.NotFoundError](../../runtime/network/NotFoundError.md), [runtime.network.NetworkError](../../runtime/network/NetworkError.md), [runtime.network.RemoteError](../../runtime/network/RemoteError.md).

### cancel

```java
void cancel()
```
