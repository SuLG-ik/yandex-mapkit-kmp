---
title: "DrivingSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSession.html"
---
# DrivingSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

`interface DrivingSession`

Driving session information.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Cancels the driving session. |
| `void` | `retry(@NonNull DrivingRouteListener routeListener)`<br>Tries to create a driving session again. |

## Methods

### cancel

```java
void cancel()
```

Cancels the driving session.

### retry

```java
void retry(@NonNull DrivingRouteListener routeListener)
```

Tries to create a driving session again.
