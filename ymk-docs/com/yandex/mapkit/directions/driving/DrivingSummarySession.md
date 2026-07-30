---
title: "DrivingSummarySession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingSummarySession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSummarySession.html"
---
# DrivingSummarySession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSummarySession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`interface DrivingSummarySession`

Driving session summary.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Cancels route summary generation. |
| `void` | `retry(@NonNull DrivingSummaryListener summaryListener)`<br>Tries to generate a driving session summary again. |

## Methods

### cancel

```java
void cancel()
```

Cancels route summary generation.

### retry

```java
void retry(@NonNull DrivingSummaryListener summaryListener)
```

Tries to generate a driving session summary again.
