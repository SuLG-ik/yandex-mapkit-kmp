---
title: "Weight"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Weight"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Weight.html"
---
# Weight

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Weight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Weight

`class Weight implements Serializable`

Quantitative characteristics of any segment of the route.

## Summary

### Constructors

**Signature and Description**

```java
Weight(@NonNull LocalizedValue time,
       @NonNull LocalizedValue timeWithTraffic,
       @NonNull LocalizedValue distance)
```

```java
Weight()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `LocalizedValue` | `getTime()`<br>Time to travel, not considering traffic. |
| `LocalizedValue` | `getTimeWithTraffic()`<br>Time to travel, considering traffic. |
| `LocalizedValue` | `getDistance()`<br>Distance to travel. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Weight

```java
Weight(@NonNull LocalizedValue time,
       @NonNull LocalizedValue timeWithTraffic,
       @NonNull LocalizedValue distance)
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

Time to travel, not considering traffic.

### getTimeWithTraffic

```java
@NonNull
LocalizedValue getTimeWithTraffic()
```

Time to travel, considering traffic.

### getDistance

```java
@NonNull
LocalizedValue getDistance()
```

Distance to travel.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
