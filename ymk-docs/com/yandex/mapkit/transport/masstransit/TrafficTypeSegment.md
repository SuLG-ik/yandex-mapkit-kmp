---
title: "TrafficTypeSegment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / TrafficTypeSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TrafficTypeSegment.html"
---
# TrafficTypeSegment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/TrafficTypeSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.TrafficTypeSegment

`class TrafficTypeSegment implements Serializable`

Describes part of bicycle or scooter path with the same traffic type.

## Summary

### Constructors

**Signature and Description**

```java
TrafficTypeSegment(@NonNull TrafficTypeID trafficType,
                   @NonNull Subpolyline subpolyline)
```

```java
TrafficTypeSegment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `TrafficTypeID` | `getTrafficType()` |
| `Subpolyline` | `getSubpolyline()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TrafficTypeSegment

```java
TrafficTypeSegment(@NonNull TrafficTypeID trafficType,
                   @NonNull Subpolyline subpolyline)
```

### TrafficTypeSegment

```java
TrafficTypeSegment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTrafficType

```java
@NonNull
TrafficTypeID getTrafficType()
```

### getSubpolyline

```java
@NonNull
Subpolyline getSubpolyline()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
