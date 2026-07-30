---
title: "SpeedLimitsPolicy"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / SpeedLimitsPolicy"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitsPolicy.html"
---
# SpeedLimitsPolicy

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedLimitsPolicy.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface SpeedLimitsPolicy`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SpeedLimits` | `getLegalSpeedLimits()`<br>For example for Russia 60/90/110 km/h |
| `SpeedLimits` | `customSpeedLimits(double toleranceRatio)`<br>For example ratio = 0.8 and current speed limit is 60 km/h - for Russia: enforcement tolerance is 20 km/h for all speed limits => we should start warning the user when current speed > 60 + 20 * 0.8 = 76 km/h - for Turkey: enforcement tolerance is 10 percent over the speed limit => we should start warning the user when current speed > 60 + 60 * 0.1 * 0.8 = 64.8 km/h |
| `SpeedLimitsRules` | `getSpeedLimitsRules()` |

## Methods

### getLegalSpeedLimits

```java
@NonNull
SpeedLimits getLegalSpeedLimits()
```

For example for Russia 60/90/110 km/h

### customSpeedLimits

```java
@NonNull
SpeedLimits customSpeedLimits(double toleranceRatio)
```

For example ratio = 0.8 and current speed limit is 60 km/h - for Russia: enforcement tolerance is 20 km/h for all speed limits => we should start warning the user when current speed > 60 + 20 * 0.8 = 76 km/h - for Turkey: enforcement tolerance is 10 percent over the speed limit => we should start warning the user when current speed > 60 + 60 * 0.1 * 0.8 = 64.8 km/h

### getSpeedLimitsRules

```java
@NonNull
SpeedLimitsRules getSpeedLimitsRules()
```
