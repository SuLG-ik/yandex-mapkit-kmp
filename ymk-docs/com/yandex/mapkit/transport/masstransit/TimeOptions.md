---
title: "TimeOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TimeOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TimeOptions.html"
---
# TimeOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TimeOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TimeOptions

`final class TimeOptions implements Serializable`

Desired departure/arrival time settings.

Only one the departureTime and arrivalTime fields should be specified.

## Summary

### Constructors

**Signature and Description**

```java
TimeOptions(@Nullable java.lang.Long departureTime,
            @Nullable java.lang.Long arrivalTime)
```

```java
TimeOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Long` | `getDepartureTime()`<br>Desired departure time in UTC for a time-dependent route request. |
| `TimeOptions` | `setDepartureTime(@Nullable java.lang.Long departureTime)`<br>See **#getDepartureTime()**. |
| `java.lang.Long` | `getArrivalTime()`<br>Desired arrival time in UTC for a time-dependent route request. |
| `TimeOptions` | `setArrivalTime(@Nullable java.lang.Long arrivalTime)`<br>See **#getArrivalTime()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TimeOptions

```java
TimeOptions(@Nullable java.lang.Long departureTime,
            @Nullable java.lang.Long arrivalTime)
```

### TimeOptions

```java
TimeOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getDepartureTime

```java
@Nullable
java.lang.Long getDepartureTime()
```

Desired departure time in UTC for a time-dependent route request.

The value is specified in milliseconds. This option cannot be used with arrivalTime.

Optional field, can be null.

### setDepartureTime

```java
TimeOptions setDepartureTime(@Nullable java.lang.Long departureTime)
```

See **#getDepartureTime()**.

### getArrivalTime

```java
@Nullable
java.lang.Long getArrivalTime()
```

Desired arrival time in UTC for a time-dependent route request.

The value is specified in milliseconds. This option cannot be used with departureTime.

Optional field, can be null.

### setArrivalTime

```java
TimeOptions setArrivalTime(@Nullable java.lang.Long arrivalTime)
```

See **#getArrivalTime()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
