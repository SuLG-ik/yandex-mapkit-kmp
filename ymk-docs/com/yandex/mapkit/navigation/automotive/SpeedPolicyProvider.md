---
title: "SpeedPolicyProvider"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / SpeedPolicyProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedPolicyProvider.html"
---
# SpeedPolicyProvider

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/SpeedPolicyProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface SpeedPolicyProvider`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addListener(@NonNull SpeedPolicyListener speedLimitsListener)`<br>The class does not retain the object in the 'speedLimitsListener' parameter. |
| `void` | `removeListener(@NonNull SpeedPolicyListener speedLimitsListener)`<br>The class does not retain the object in the 'speedLimitsListener' parameter. |
| `SpeedLimitsPolicy` | `getSpeedLimitsPolicy()`<br>Returns the speed policy corresponding to the last position that was set. |
| `void` | `updateSpeedLimitsPolicy(@NonNull Point position)`<br>Call this method, then wait for [mapkit.navigation.automotive.SpeedPolicyListener#onSpeedPolicyChanged()](SpeedPolicyListener.md#onspeedpolicychanged) to read speed policy due to asynchronous updates. |

## Methods

### addListener

```java
void addListener(@NonNull SpeedPolicyListener speedLimitsListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull SpeedPolicyListener speedLimitsListener)
```

The class does not retain the object in the 'speedLimitsListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### getSpeedLimitsPolicy

```java
@NonNull
SpeedLimitsPolicy getSpeedLimitsPolicy()
```

Returns the speed policy corresponding to the last position that was set.

If no position has been previously set, the function returns the standard speed policy.

### updateSpeedLimitsPolicy

```java
void updateSpeedLimitsPolicy(@NonNull Point position)
```

Call this method, then wait for [mapkit.navigation.automotive.SpeedPolicyListener#onSpeedPolicyChanged()](SpeedPolicyListener.md#onspeedpolicychanged) to read speed policy due to asynchronous updates.

[mapkit.navigation.automotive.SpeedPolicyListener#onSpeedPolicyChanged()](SpeedPolicyListener.md#onspeedpolicychanged) will be called only if `speedLimitsPolicy` changed
