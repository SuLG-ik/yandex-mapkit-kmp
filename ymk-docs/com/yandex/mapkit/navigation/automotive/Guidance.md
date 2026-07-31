---
title: "Guidance"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.automotive"
section: "Android / Справочник / com.yandex.mapkit.navigation.automotive / Guidance"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Guidance.html"
---
# Guidance

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/automotive/Guidance.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.automotive

`interface Guidance`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `isEnableAlternatives()`<br>Enables/Disables alternatives suggestion while guiding. |
| `void` | `setEnableAlternatives(boolean enableAlternatives)` |
| `boolean` | `isEnableReroutes()`<br>Enables/Disables rerouting. |
| `void` | `setEnableReroutes(boolean enableReroutes)` |
| `Windshield` | `getWindshield()` |
| `Annotator` | `getAnnotator()` |
| `DrivingRoute` | `getCurrentRoute()`<br>Optional property, can be null. |
| `java.util.List<Alternative>` | `getAlternatives()`<br>Vector with all alternatives ahead. |
| `Alternative` | `getFastestAlternative()`<br>Optional property, can be null. |
| `Location` | `getLocation()`<br>Optional property, can be null. |
| `LocationClass` | `getLocationClass()`<br>Optional property, can be null. |
| `java.lang.String` | `getRoadName()`<br>Optional property, can be null. |
| `RouteStatus` | `getRouteStatus()` |
| `SpeedLimitsPolicy` | `getSpeedLimitsPolicy()`<br>In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used. |
| `double` | `getSpeedLimitTolerance()` |
| `void` | `setSpeedLimitTolerance(double speedLimitTolerance)` |
| `LocalizedValue` | `getSpeedLimit()`<br>Speed limit of the current road. |
| `SpeedLimitStatus` | `getSpeedLimitStatus()` |
| `void` | `switchToRoute(@NonNull DrivingRoute route)`<br>Start guidance with given alternative. |
| `void` | `addListener(@NonNull GuidanceListener guidanceListener)`<br>The class does not retain the object in the 'guidanceListener' parameter. |
| `void` | `removeListener(@NonNull GuidanceListener guidanceListener)` |
| `boolean` | `isValid()`<br>Tells if this **Guidance** is valid or not. |

## Methods

### isEnableAlternatives

```java
boolean isEnableAlternatives()
```

Enables/Disables alternatives suggestion while guiding.

Enabled by default.

### setEnableAlternatives

```java
void setEnableAlternatives(boolean enableAlternatives)
```

### isEnableReroutes

```java
boolean isEnableReroutes()
```

Enables/Disables rerouting.

Enabled by default.

### setEnableReroutes

```java
void setEnableReroutes(boolean enableReroutes)
```

### getWindshield

```java
@NonNull
Windshield getWindshield()
```

### getAnnotator

```java
@NonNull
Annotator getAnnotator()
```

### getCurrentRoute

```java
@Nullable
DrivingRoute getCurrentRoute()
```

Optional property, can be null.

### getAlternatives

```java
@NonNull
java.util.List<Alternative> getAlternatives()
```

Vector with all alternatives ahead.

Sorted by distance.

### getFastestAlternative

```java
@Nullable
Alternative getFastestAlternative()
```

Optional property, can be null.

### getLocation

```java
@Nullable
Location getLocation()
```

Optional property, can be null.

### getLocationClass

```java
@Nullable
LocationClass getLocationClass()
```

Optional property, can be null.

### getRoadName

```java
@Nullable
java.lang.String getRoadName()
```

Optional property, can be null.

### getRouteStatus

```java
@NonNull
RouteStatus getRouteStatus()
```

### getSpeedLimitsPolicy

```java
@NonNull
SpeedLimitsPolicy getSpeedLimitsPolicy()
```

In case region is not yet available, SpeedingPolicy::region is empty and default speeding config is used.

### getSpeedLimitTolerance

```java
double getSpeedLimitTolerance()
```

### setSpeedLimitTolerance

```java
void setSpeedLimitTolerance(double speedLimitTolerance)
```

### getSpeedLimit

```java
@Nullable
LocalizedValue getSpeedLimit()
```

Speed limit of the current road.

Optional property, can be null.

### getSpeedLimitStatus

```java
@NonNull
SpeedLimitStatus getSpeedLimitStatus()
```

### switchToRoute

```java
void switchToRoute(@NonNull DrivingRoute route)
```

Start guidance with given alternative.

It only accepts routes obtained from this Guidance.routes field.

### addListener

```java
void addListener(@NonNull GuidanceListener guidanceListener)
```

The class does not retain the object in the 'guidanceListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull GuidanceListener guidanceListener)
```

### isValid

```java
boolean isValid()
```

Tells if this **Guidance** is valid or not.

Any other method (except for this one) called on an invalid **Guidance** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
