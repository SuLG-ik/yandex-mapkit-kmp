---
title: "UpcomingRoadEvent"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / UpcomingRoadEvent"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/UpcomingRoadEvent.html"
---
# UpcomingRoadEvent

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/UpcomingRoadEvent.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface UpcomingRoadEvent`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Event` | `getEvent()` |
| `SpeedLimitStatus` | `getSpeedLimitStatus()`<br>Optional property, can be null. |
| `java.lang.Double` | `getEffectiveSpeedLimit()`<br>Effective speed limit. |
| `RoutePosition` | `getPosition()` |

## Methods

### getEvent

```java
@NonNull
Event getEvent()
```

### getSpeedLimitStatus

```java
@Nullable
SpeedLimitStatus getSpeedLimitStatus()
```

Optional property, can be null.

### getEffectiveSpeedLimit

```java
@Nullable
java.lang.Double getEffectiveSpeedLimit()
```

Effective speed limit.

Non-empty only for speed control camera events. If a camera has no speed limit then some standard urban speed limit will be used.

Optional property, can be null.

### getPosition

```java
@NonNull
RoutePosition getPosition()
```
