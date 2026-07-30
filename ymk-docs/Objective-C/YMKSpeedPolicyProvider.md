---
title: "YMKSpeedPolicyProvider"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKSpeedPolicyProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedPolicyProvider.html"
---
# YMKSpeedPolicyProvider

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKSpeedPolicyProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKSpeedPolicyProvider : NSObject
```

## Summary

### Instance methods

```objectivec
- (void)addListenerWithSpeedLimitsListener:
    (nonnull id<YMKSpeedPolicyListener>)speedLimitsListener;
```

The class does not retain the object in the 'speedLimitsListener' parameter

```objectivec
- (void)removeListenerWithSpeedLimitsListener:
    (nonnull id<YMKSpeedPolicyListener>)speedLimitsListener;
```

The class does not retain the object in the 'speedLimitsListener' parameter

```objectivec
- (void)updateSpeedLimitsPolicyWithPosition:(nonnull YMKPoint *)position;
```

Call this method, then wait for YMKSpeedPolicyListener::onSpeedPolicyChanged to read speed policy due to asynchronous updates

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpeedLimitsPolicy *speedLimitsPolicy;
```

Returns the speed policy corresponding to the last position that was set

## Instance methods

### addListenerWithSpeedLimitsListener:

```objectivec
- (void)addListenerWithSpeedLimitsListener:
    (nonnull id<YMKSpeedPolicyListener>)speedLimitsListener;
```

The class does not retain the object in the 'speedLimitsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithSpeedLimitsListener:

```objectivec
- (void)removeListenerWithSpeedLimitsListener:
    (nonnull id<YMKSpeedPolicyListener>)speedLimitsListener;
```

The class does not retain the object in the 'speedLimitsListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### updateSpeedLimitsPolicyWithPosition:

```objectivec
- (void)updateSpeedLimitsPolicyWithPosition:(nonnull YMKPoint *)position;
```

Call this method, then wait for YMKSpeedPolicyListener::onSpeedPolicyChanged to read speed policy due to asynchronous updates. YMKSpeedPolicyListener::onSpeedPolicyChanged will be called only if `speedLimitsPolicy` changed

## Properties

### speedLimitsPolicy

```objectivec
@property (nonatomic, readonly, nonnull) YMKSpeedLimitsPolicy *speedLimitsPolicy;
```

Returns the speed policy corresponding to the last position that was set. If no position has been previously set, the function returns the standard speed policy.
