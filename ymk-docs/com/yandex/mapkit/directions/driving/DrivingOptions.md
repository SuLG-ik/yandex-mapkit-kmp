---
title: "DrivingOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingOptions.html"
---
# DrivingOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DrivingOptions

`final class DrivingOptions implements Serializable`

Driving options.

## Summary

### Constructors

**Signature and Description**

```java
DrivingOptions(@Nullable java.lang.Double initialAzimuth,
               @Nullable java.lang.Integer routesCount,
               @Nullable java.lang.Long departureTime,
               @Nullable AnnotationLanguage annotationLanguage,
               @Nullable AvoidanceFlags avoidanceFlags)
```

```java
DrivingOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Double` | `getInitialAzimuth()`<br>Starting location azimuth. |
| `DrivingOptions` | `setInitialAzimuth(@Nullable java.lang.Double initialAzimuth)`<br>See **#getInitialAzimuth()**. |
| `java.lang.Integer` | `getRoutesCount()`<br>The number of alternatives. |
| `DrivingOptions` | `setRoutesCount(@Nullable java.lang.Integer routesCount)`<br>See **#getRoutesCount()**. |
| `java.lang.Long` | `getDepartureTime()`<br>Optional field, can be null. |
| `DrivingOptions` | `setDepartureTime(@Nullable java.lang.Long departureTime)`<br>See **#getDepartureTime()**. |
| `AnnotationLanguage` | `getAnnotationLanguage()`<br>A method to set the annotation language. |
| `DrivingOptions` | `setAnnotationLanguage(@Nullable AnnotationLanguage annotationLanguage)`<br>See **#getAnnotationLanguage()**. |
| `AvoidanceFlags` | `getAvoidanceFlags()`<br>The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible. |
| `DrivingOptions` | `setAvoidanceFlags(@Nullable AvoidanceFlags avoidanceFlags)`<br>See **#getAvoidanceFlags()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DrivingOptions

```java
DrivingOptions(@Nullable java.lang.Double initialAzimuth,
               @Nullable java.lang.Integer routesCount,
               @Nullable java.lang.Long departureTime,
               @Nullable AnnotationLanguage annotationLanguage,
               @Nullable AvoidanceFlags avoidanceFlags)
```

### DrivingOptions

```java
DrivingOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getInitialAzimuth

```java
@Nullable
java.lang.Double getInitialAzimuth()
```

Starting location azimuth.

Optional field, can be null.

### setInitialAzimuth

```java
DrivingOptions setInitialAzimuth(@Nullable java.lang.Double initialAzimuth)
```

See **#getInitialAzimuth()**.

### getRoutesCount

```java
@Nullable
java.lang.Integer getRoutesCount()
```

The number of alternatives.

Optional field, can be null.

### setRoutesCount

```java
DrivingOptions setRoutesCount(@Nullable java.lang.Integer routesCount)
```

See **#getRoutesCount()**.

### getDepartureTime

```java
@Nullable
java.lang.Long getDepartureTime()
```

Optional field, can be null.

### setDepartureTime

```java
DrivingOptions setDepartureTime(@Nullable java.lang.Long departureTime)
```

See **#getDepartureTime()**.

### getAnnotationLanguage

```java
@Nullable
AnnotationLanguage getAnnotationLanguage()
```

A method to set the annotation language.

lang The annotation language.

Optional field, can be null.

### setAnnotationLanguage

```java
DrivingOptions setAnnotationLanguage(@Nullable AnnotationLanguage annotationLanguage)
```

See **#getAnnotationLanguage()**.

### getAvoidanceFlags

```java
@Nullable
AvoidanceFlags getAvoidanceFlags()
```

The 'avoidanceFlags' instruct the router to return routes that avoid roads with the specified properties when possible.

Optional field, can be null.

### setAvoidanceFlags

```java
DrivingOptions setAvoidanceFlags(@Nullable AvoidanceFlags avoidanceFlags)
```

See **#getAvoidanceFlags()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
