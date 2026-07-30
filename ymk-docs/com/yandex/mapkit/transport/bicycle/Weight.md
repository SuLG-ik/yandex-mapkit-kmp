---
title: "Weight"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Weight"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Weight.html"
---
# Weight

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Weight.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.Weight

`class Weight implements Serializable`

Quantitative characteristics of a route or route section.

## Summary

### Constructors

**Signature and Description**

```java
Weight(@NonNull LocalizedValue time,
       @NonNull LocalizedValue distance)
```

```java
Weight()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `LocalizedValue` | `getTime()`<br>Time to travel. |
| `LocalizedValue` | `getDistance()`<br>Distance to travel. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Weight

```java
Weight(@NonNull LocalizedValue time,
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

Time to travel.

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
