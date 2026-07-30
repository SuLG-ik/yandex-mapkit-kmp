---
title: "TravelEstimation"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TravelEstimation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TravelEstimation.html"
---
# TravelEstimation

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TravelEstimation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TravelEstimation

`class TravelEstimation implements Serializable`

Arrival and departure time estimations for time-dependent routes or sections of time-dependent routes.

## Summary

### Constructors

**Signature and Description**

```java
TravelEstimation(@NonNull Time departureTime,
                 @NonNull Time arrivalTime)
```

```java
TravelEstimation()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Time` | `getDepartureTime()`<br>Departure time for a route or a route section. |
| `Time` | `getArrivalTime()`<br>Arrival time for a route or a route section. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TravelEstimation

```java
TravelEstimation(@NonNull Time departureTime,
                 @NonNull Time arrivalTime)
```

### TravelEstimation

```java
TravelEstimation()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getDepartureTime

```java
@NonNull
Time getDepartureTime()
```

Departure time for a route or a route section.

### getArrivalTime

```java
@NonNull
Time getArrivalTime()
```

Arrival time for a route or a route section.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
