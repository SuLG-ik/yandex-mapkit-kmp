---
title: "Weight"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Weight"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Weight.html"
---
# Weight

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Weight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Weight

`class Weight implements Serializable`

Numeric characteristics of a route or a route section.

## Summary

### Constructors

**Signature and Description**

```java
Weight(@NonNull LocalizedValue time,
       @NonNull LocalizedValue walkingDistance,
       int transfersCount)
```

```java
Weight()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `LocalizedValue` | `getTime()`<br>Travel time for a route or a route section. |
| `LocalizedValue` | `getWalkingDistance()`<br>Distance of the pedestrian part of the route or a route section. |
| `int` | `getTransfersCount()`<br>The number of transfers for a route or a route section. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Weight

```java
Weight(@NonNull LocalizedValue time,
       @NonNull LocalizedValue walkingDistance,
       int transfersCount)
```

### Weight

```java
Weight()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTime

```java
@NonNull
LocalizedValue getTime()
```

Travel time for a route or a route section.

### getWalkingDistance

```java
@NonNull
LocalizedValue getWalkingDistance()
```

Distance of the pedestrian part of the route or a route section.

### getTransfersCount

```java
int getTransfersCount()
```

The number of transfers for a route or a route section.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
