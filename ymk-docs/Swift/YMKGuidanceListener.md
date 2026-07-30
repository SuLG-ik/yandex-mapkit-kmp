---
title: "YMKGuidanceListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKGuidanceListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGuidanceListener.html"
---
# YMKGuidanceListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGuidanceListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKGuidanceListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onLocationChanged()
```

```swift
func onCurrentRouteChanged(with reason: YMKRouteChangeReason)
```

```swift
func onRouteLost()
```

```swift
func onReturnedToRoute()
```

```swift
func onRouteFinished()
```

```swift
func onWayPointReached()
```

```swift
func onStandingStatusChanged()
```

```swift
func onRoadNameChanged()
```

```swift
func onSpeedLimitUpdated()
```

```swift
func onSpeedLimitStatusUpdated()
```

```swift
func onAlternativesChanged()
```

```swift
func onFastestAlternativeChanged()
```

## Instance methods

### onLocationChanged()

```swift
func onLocationChanged()
```

### onCurrentRouteChanged(with:)

```swift
func onCurrentRouteChanged(with reason: YMKRouteChangeReason)
```

### onRouteLost()

```swift
func onRouteLost()
```

### onReturnedToRoute()

```swift
func onReturnedToRoute()
```

### onRouteFinished()

```swift
func onRouteFinished()
```

### onWayPointReached()

```swift
func onWayPointReached()
```

### onStandingStatusChanged()

```swift
func onStandingStatusChanged()
```

### onRoadNameChanged()

```swift
func onRoadNameChanged()
```

### onSpeedLimitUpdated()

```swift
func onSpeedLimitUpdated()
```

### onSpeedLimitStatusUpdated()

```swift
func onSpeedLimitStatusUpdated()
```

### onAlternativesChanged()

```swift
func onAlternativesChanged()
```

### onFastestAlternativeChanged()

```swift
func onFastestAlternativeChanged()
```
