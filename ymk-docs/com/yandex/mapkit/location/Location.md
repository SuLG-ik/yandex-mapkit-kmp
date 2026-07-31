---
title: "Location"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.location"
section: "Android / Справочник / com.yandex.mapkit.location / Location"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Location.html"
---
# Location

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/location/Location.html)

**Package** com.yandex.mapkit.location

java.lang.Object
↳ com.yandex.mapkit.location.Location

`class Location implements Serializable`

The geographical position of the object.

## Summary

### Constructors

**Signature and Description**

```java
Location(@NonNull Point position,
         @Nullable java.lang.Double accuracy,
         @Nullable java.lang.Double altitude,
         @Nullable java.lang.Double altitudeAccuracy,
         @Nullable java.lang.Double heading,
         @Nullable java.lang.Double speed,
         @Nullable java.lang.String indoorLevelId,
         long absoluteTimestamp,
         long relativeTimestamp)
```

```java
Location()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getPosition()`<br>The geographical position. |
| `java.lang.Double` | `getAccuracy()`<br>Location accuracy in meters. |
| `java.lang.Double` | `getAltitude()`<br>The altitude of the location in meters. |
| `java.lang.Double` | `getAltitudeAccuracy()`<br>The accuracy of the altitude in meters. |
| `java.lang.Double` | `getHeading()`<br>The current heading in degrees relative to true north, clockwise. |
| `java.lang.Double` | `getSpeed()`<br>The speed in meters per second. |
| `java.lang.String` | `getIndoorLevelId()`<br>The universal identifier of indoor level. |
| `long` | `getAbsoluteTimestamp()`<br>Absolute timestamp, in milliseconds since January 1, 1970. |
| `long` | `getRelativeTimestamp()`<br>Relative timestamp, number of milliseconds passed on steady clock. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Location

```java
Location(@NonNull Point position,
         @Nullable java.lang.Double accuracy,
         @Nullable java.lang.Double altitude,
         @Nullable java.lang.Double altitudeAccuracy,
         @Nullable java.lang.Double heading,
         @Nullable java.lang.Double speed,
         @Nullable java.lang.String indoorLevelId,
         long absoluteTimestamp,
         long relativeTimestamp)
```

### Location

```java
Location()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
Point getPosition()
```

The geographical position.

### getAccuracy

```java
@Nullable
java.lang.Double getAccuracy()
```

Location accuracy in meters.

Optional field, can be null.

### getAltitude

```java
@Nullable
java.lang.Double getAltitude()
```

The altitude of the location in meters.

Optional field, can be null.

### getAltitudeAccuracy

```java
@Nullable
java.lang.Double getAltitudeAccuracy()
```

The accuracy of the altitude in meters.

Optional field, can be null.

### getHeading

```java
@Nullable
java.lang.Double getHeading()
```

The current heading in degrees relative to true north, clockwise.

Optional field, can be null.

### getSpeed

```java
@Nullable
java.lang.Double getSpeed()
```

The speed in meters per second.

Optional field, can be null.

### getIndoorLevelId

```java
@Nullable
java.lang.String getIndoorLevelId()
```

The universal identifier of indoor level.

Optional field, can be null.

### getAbsoluteTimestamp

```java
long getAbsoluteTimestamp()
```

Absolute timestamp, in milliseconds since January 1, 1970.

### getRelativeTimestamp

```java
long getRelativeTimestamp()
```

Relative timestamp, number of milliseconds passed on steady clock.

Use for interval calculation.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
