---
title: "SummarySession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / SummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SummarySession.html"
---
# SummarySession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`interface SummarySession`

Handler for an async request for a summary of mass transit routes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Tries to cancel the current request for a summary of mass transit routes. |
| `void` | `retry(@NonNull SummaryListener summaryListener)`<br>Retries the request for a summary of mass transit routes, using the specified callback. |

## Methods

### cancel

```java
void cancel()
```

Tries to cancel the current request for a summary of mass transit routes.

### retry

```java
void retry(@NonNull SummaryListener summaryListener)
```

Retries the request for a summary of mass transit routes, using the specified callback.
