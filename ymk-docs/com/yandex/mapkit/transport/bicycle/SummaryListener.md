---
title: "SummaryListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / SummaryListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/SummaryListener.html"
---
# SummaryListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/SummaryListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

`static interface SummaryListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onBicycleSummaries(@NonNull java.util.List<Summary> routes)`<br>Mass bicycle summaries are generated. |
| `void` | `onBicycleSummariesError(@NonNull Error error)`<br>There was an error with generating bicycle summaries. |

## Methods

### onBicycleSummaries

```java
@UiThread
void onBicycleSummaries(@NonNull java.util.List<Summary> routes)
```

Mass bicycle summaries are generated.

### onBicycleSummariesError

```java
@UiThread
void onBicycleSummariesError(@NonNull Error error)
```

There was an error with generating bicycle summaries.
