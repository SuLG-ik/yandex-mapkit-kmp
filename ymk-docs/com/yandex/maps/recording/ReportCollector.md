---
title: "ReportCollector"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.maps.recording"
section: "Android / Справочник / com.yandex.maps.recording / ReportCollector"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/maps/recording/ReportCollector.html"
---
# ReportCollector

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/maps/recording/ReportCollector.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.maps.recording

`interface ReportCollector`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.util.List<ReportData>` | `reports()`<br>Get all stored reports. |
| `boolean` | `isValid()`<br>Tells if this **ReportCollector** is valid or not. |

## Methods

### reports

```java
@NonNull
java.util.List<ReportData> reports()
```

Get all stored reports.

The reports are not stored forever. There is an internal limit on the total size of all reports so older reports will be removed if space is needed for a newer report. The reports are sorted by their start time: the oldest report is first, the newest is last.

### isValid

```java
boolean isValid()
```

Tells if this **ReportCollector** is valid or not.

Any other method (except for this one) called on an invalid **ReportCollector** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
