---
title: "RuggedRoad"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RuggedRoad"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RuggedRoad.html"
---
# RuggedRoad

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RuggedRoad.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RuggedRoad

`class RuggedRoad implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RuggedRoad(@NonNull Subpolyline position,
           boolean unpaved,
           boolean inPoorCondition)
```

```java
RuggedRoad()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Subpolyline` | `getPosition()` |
| `boolean` | `getUnpaved()` |
| `boolean` | `getInPoorCondition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RuggedRoad

```java
RuggedRoad(@NonNull Subpolyline position,
           boolean unpaved,
           boolean inPoorCondition)
```

### RuggedRoad

```java
RuggedRoad()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
Subpolyline getPosition()
```

### getUnpaved

```java
boolean getUnpaved()
```

### getInPoorCondition

```java
boolean getInPoorCondition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
