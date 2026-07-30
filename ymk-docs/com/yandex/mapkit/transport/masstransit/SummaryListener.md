---
title: "SummaryListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / SummaryListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SummaryListener.html"
---
# SummaryListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/SummaryListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

`static interface SummaryListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMasstransitSummaries(@NonNull java.util.List<Summary> routes)`<br>Mass transit summaries are generated. |
| `void` | `onMasstransitSummariesError(@NonNull Error error)`<br>There was an error with generating mass transit summaries. |

## Methods

### onMasstransitSummaries

```java
@UiThread
void onMasstransitSummaries(@NonNull java.util.List<Summary> routes)
```

Mass transit summaries are generated.

### onMasstransitSummariesError

```java
@UiThread
void onMasstransitSummariesError(@NonNull Error error)
```

There was an error with generating mass transit summaries.
