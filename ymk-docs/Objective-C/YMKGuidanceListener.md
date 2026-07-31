---
title: "YMKGuidanceListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKGuidanceListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGuidanceListener.html"
---
# YMKGuidanceListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKGuidanceListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@protocol YMKGuidanceListener <NSObject>
```

## Summary

### Instance methods

```objectivec
- (void)onLocationChanged;
```

```objectivec
- (void)onCurrentRouteChangedWithReason:(YMKRouteChangeReason)reason;
```

```objectivec
- (void)onRouteLost;
```

```objectivec
- (void)onReturnedToRoute;
```

```objectivec
- (void)onRouteFinished;
```

```objectivec
- (void)onWayPointReached;
```

```objectivec
- (void)onStandingStatusChanged;
```

```objectivec
- (void)onRoadNameChanged;
```

```objectivec
- (void)onSpeedLimitUpdated;
```

```objectivec
- (void)onSpeedLimitStatusUpdated;
```

```objectivec
- (void)onAlternativesChanged;
```

```objectivec
- (void)onFastestAlternativeChanged;
```

## Instance methods

### onLocationChanged

```objectivec
- (void)onLocationChanged;
```

### onCurrentRouteChangedWithReason:

```objectivec
- (void)onCurrentRouteChangedWithReason:(YMKRouteChangeReason)reason;
```

### onRouteLost

```objectivec
- (void)onRouteLost;
```

### onReturnedToRoute

```objectivec
- (void)onReturnedToRoute;
```

### onRouteFinished

```objectivec
- (void)onRouteFinished;
```

### onWayPointReached

```objectivec
- (void)onWayPointReached;
```

### onStandingStatusChanged

```objectivec
- (void)onStandingStatusChanged;
```

### onRoadNameChanged

```objectivec
- (void)onRoadNameChanged;
```

### onSpeedLimitUpdated

```objectivec
- (void)onSpeedLimitUpdated;
```

### onSpeedLimitStatusUpdated

```objectivec
- (void)onSpeedLimitStatusUpdated;
```

### onAlternativesChanged

```objectivec
- (void)onAlternativesChanged;
```

### onFastestAlternativeChanged

```objectivec
- (void)onFastestAlternativeChanged;
```
