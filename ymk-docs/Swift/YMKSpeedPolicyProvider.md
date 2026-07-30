---
title: "YMKSpeedPolicyProvider"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSpeedPolicyProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedPolicyProvider.html"
---
# YMKSpeedPolicyProvider

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSpeedPolicyProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKSpeedPolicyProvider : NSObject
```

## Summary

### Instance methods

```swift
func addListener(withSpeedLimitsListener speedLimitsListener: any YMKSpeedPolicyListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter

```swift
func removeListener(withSpeedLimitsListener speedLimitsListener: any YMKSpeedPolicyListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter

```swift
func updateSpeedLimitsPolicy(withPosition position: YMKPoint)
```

Call this method, then wait for YMKSpeedPolicyListener::onSpeedPolicyChanged to read speed policy due to asynchronous updates

### Properties

```swift
var speedLimitsPolicy: YMKSpeedLimitsPolicy { get }
```

Returns the speed policy corresponding to the last position that was set

## Instance methods

### addListener(withSpeedLimitsListener:)

```swift
func addListener(withSpeedLimitsListener speedLimitsListener: any YMKSpeedPolicyListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(withSpeedLimitsListener:)

```swift
func removeListener(withSpeedLimitsListener speedLimitsListener: any YMKSpeedPolicyListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### updateSpeedLimitsPolicy(withPosition:)

```swift
func updateSpeedLimitsPolicy(withPosition position: YMKPoint)
```

Call this method, then wait for YMKSpeedPolicyListener::onSpeedPolicyChanged to read speed policy due to asynchronous updates. YMKSpeedPolicyListener::onSpeedPolicyChanged will be called only if `speedLimitsPolicy` changed

## Properties

### speedLimitsPolicy

```swift
var speedLimitsPolicy: YMKSpeedLimitsPolicy { get }
```

Returns the speed policy corresponding to the last position that was set. If no position has been previously set, the function returns the standard speed policy.
