---
title: "LocationSettings"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / LocationSettings"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationSettings.html"
---
# LocationSettings

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/LocationSettings.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.LocationSettings

`final class LocationSettings implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
LocationSettings(boolean provideAccuracy,
                 @Nullable Range accuracy,
                 @Nullable TimeInterval locationTimeInterval,
                 boolean provideSpeed,
                 double speed,
                 boolean provideHeading,
                 @Nullable Range headingError,
                 @Nullable LocationError locationError,
                 boolean provideWheelSpeed,
                 @Nullable TimeInterval wheelSpeedTimeInterval)
```

```java
LocationSettings()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `boolean` | `getProvideAccuracy()`<br>Flag whether to provide accuracy value. |
| `LocationSettings` | `setProvideAccuracy(boolean provideAccuracy)`<br>See **#getProvideAccuracy()**. |
| `Range` | `getAccuracy()`<br>Location accuracy range in meters. |
| `LocationSettings` | `setAccuracy(@Nullable Range accuracy)`<br>See **#getAccuracy()**. |
| `TimeInterval` | `getLocationTimeInterval()`<br>Location time interval in milliseconds. |
| `LocationSettings` | `setLocationTimeInterval(@Nullable TimeInterval locationTimeInterval)`<br>See **#getLocationTimeInterval()**. |
| `boolean` | `getProvideSpeed()`<br>Flag whether to provide speed value. |
| `LocationSettings` | `setProvideSpeed(boolean provideSpeed)`<br>See **#getProvideSpeed()**. |
| `double` | `getSpeed()`<br>The speed in meters per second. |
| `LocationSettings` | `setSpeed(double speed)`<br>See **#getSpeed()**. |
| `boolean` | `getProvideHeading()`<br>Flag whether to provide error of heading. |
| `LocationSettings` | `setProvideHeading(boolean provideHeading)`<br>See **#getProvideHeading()**. |
| `Range` | `getHeadingError()`<br>The current heading error range in degrees relative to true heading, clockwise. |
| `LocationSettings` | `setHeadingError(@Nullable Range headingError)`<br>See **#getHeadingError()**. |
| `LocationError` | `getLocationError()`<br>Optional field, can be null. |
| `LocationSettings` | `setLocationError(@Nullable LocationError locationError)`<br>See **#getLocationError()**. |
| `boolean` | `getProvideWheelSpeed()`<br>Flag whether to provide wheel speed value. |
| `LocationSettings` | `setProvideWheelSpeed(boolean provideWheelSpeed)`<br>See **#getProvideWheelSpeed()**. |
| `TimeInterval` | `getWheelSpeedTimeInterval()`<br>Time interval of getting the wheel speed in milliseconds. |
| `LocationSettings` | `setWheelSpeedTimeInterval(@Nullable TimeInterval wheelSpeedTimeInterval)`<br>See **#getWheelSpeedTimeInterval()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### LocationSettings

```java
LocationSettings(boolean provideAccuracy,
                 @Nullable Range accuracy,
                 @Nullable TimeInterval locationTimeInterval,
                 boolean provideSpeed,
                 double speed,
                 boolean provideHeading,
                 @Nullable Range headingError,
                 @Nullable LocationError locationError,
                 boolean provideWheelSpeed,
                 @Nullable TimeInterval wheelSpeedTimeInterval)
```

### LocationSettings

```java
LocationSettings()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getProvideAccuracy

```java
boolean getProvideAccuracy()
```

Flag whether to provide accuracy value.

### setProvideAccuracy

```java
LocationSettings setProvideAccuracy(boolean provideAccuracy)
```

See **#getProvideAccuracy()**.

### getAccuracy

```java
@Nullable
Range getAccuracy()
```

Location accuracy range in meters.

Optional field, can be null.

### setAccuracy

```java
LocationSettings setAccuracy(@Nullable Range accuracy)
```

See **#getAccuracy()**.

### getLocationTimeInterval

```java
@Nullable
TimeInterval getLocationTimeInterval()
```

Location time interval in milliseconds.

Optional field, can be null.

### setLocationTimeInterval

```java
LocationSettings setLocationTimeInterval(@Nullable TimeInterval locationTimeInterval)
```

See **#getLocationTimeInterval()**.

### getProvideSpeed

```java
boolean getProvideSpeed()
```

Flag whether to provide speed value.

### setProvideSpeed

```java
LocationSettings setProvideSpeed(boolean provideSpeed)
```

See **#getProvideSpeed()**.

### getSpeed

```java
double getSpeed()
```

The speed in meters per second.

### setSpeed

```java
LocationSettings setSpeed(double speed)
```

See **#getSpeed()**.

### getProvideHeading

```java
boolean getProvideHeading()
```

Flag whether to provide error of heading.

### setProvideHeading

```java
LocationSettings setProvideHeading(boolean provideHeading)
```

See **#getProvideHeading()**.

### getHeadingError

```java
@Nullable
Range getHeadingError()
```

The current heading error range in degrees relative to true heading, clockwise.

Optional field, can be null.

### setHeadingError

```java
LocationSettings setHeadingError(@Nullable Range headingError)
```

See **#getHeadingError()**.

### getLocationError

```java
@Nullable
LocationError getLocationError()
```

Optional field, can be null.

### setLocationError

```java
LocationSettings setLocationError(@Nullable LocationError locationError)
```

See **#getLocationError()**.

### getProvideWheelSpeed

```java
boolean getProvideWheelSpeed()
```

Flag whether to provide wheel speed value.

### setProvideWheelSpeed

```java
LocationSettings setProvideWheelSpeed(boolean provideWheelSpeed)
```

See **#getProvideWheelSpeed()**.

### getWheelSpeedTimeInterval

```java
@Nullable
TimeInterval getWheelSpeedTimeInterval()
```

Time interval of getting the wheel speed in milliseconds.

After publication the wheel speed corresponds to the speed value.

Optional field, can be null.

### setWheelSpeedTimeInterval

```java
LocationSettings setWheelSpeedTimeInterval(@Nullable TimeInterval wheelSpeedTimeInterval)
```

See **#getWheelSpeedTimeInterval()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
