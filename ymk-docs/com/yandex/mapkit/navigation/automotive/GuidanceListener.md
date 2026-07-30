---
title: "GuidanceListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / GuidanceListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/GuidanceListener.html"
---
# GuidanceListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/GuidanceListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface GuidanceListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onLocationChanged()` |
| `void` | `onCurrentRouteChanged(@NonNull RouteChangeReason reason)` |
| `void` | `onRouteLost()` |
| `void` | `onReturnedToRoute()` |
| `void` | `onRouteFinished()` |
| `void` | `onWayPointReached()` |
| `void` | `onStandingStatusChanged()` |
| `void` | `onRoadNameChanged()` |
| `void` | `onSpeedLimitUpdated()` |
| `void` | `onSpeedLimitStatusUpdated()` |
| `void` | `onAlternativesChanged()` |
| `void` | `onFastestAlternativeChanged()` |

## Methods

### onLocationChanged

```java
@UiThread
void onLocationChanged()
```

### onCurrentRouteChanged

```java
@UiThread
void onCurrentRouteChanged(@NonNull RouteChangeReason reason)
```

### onRouteLost

```java
@UiThread
void onRouteLost()
```

### onReturnedToRoute

```java
@UiThread
void onReturnedToRoute()
```

### onRouteFinished

```java
@UiThread
void onRouteFinished()
```

### onWayPointReached

```java
@UiThread
void onWayPointReached()
```

### onStandingStatusChanged

```java
@UiThread
void onStandingStatusChanged()
```

### onRoadNameChanged

```java
@UiThread
void onRoadNameChanged()
```

### onSpeedLimitUpdated

```java
@UiThread
void onSpeedLimitUpdated()
```

### onSpeedLimitStatusUpdated

```java
@UiThread
void onSpeedLimitStatusUpdated()
```

### onAlternativesChanged

```java
@UiThread
void onAlternativesChanged()
```

### onFastestAlternativeChanged

```java
@UiThread
void onFastestAlternativeChanged()
```
