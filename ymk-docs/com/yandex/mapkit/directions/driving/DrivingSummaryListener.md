---
title: "DrivingSummaryListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingSummaryListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSummaryListener.html"
---
# DrivingSummaryListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSummaryListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`static interface DrivingSummaryListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onDrivingSummaries(@NonNull java.util.List<Summary> summaries)`<br>Happens when the summaries are generated. |
| `void` | `onDrivingSummariesError(@NonNull Error error)`<br>Happens when there is an error. |

## Methods

### onDrivingSummaries

```java
@UiThread
void onDrivingSummaries(@NonNull java.util.List<Summary> summaries)
```

Happens when the summaries are generated.

### onDrivingSummariesError

```java
@UiThread
void onDrivingSummariesError(@NonNull Error error)
```

Happens when there is an error.
