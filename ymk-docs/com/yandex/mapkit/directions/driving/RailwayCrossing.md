---
title: "RailwayCrossing"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RailwayCrossing"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RailwayCrossing.html"
---
# RailwayCrossing

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RailwayCrossing.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RailwayCrossing

`class RailwayCrossing implements Serializable`

A railway crossing object.

## Summary

### Constructors

**Signature and Description**

```java
RailwayCrossing(@NonNull RailwayCrossingType type,
                @NonNull PolylinePosition position)
```

```java
RailwayCrossing()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `RailwayCrossingType` | `getType()` |
| `PolylinePosition` | `getPosition()`<br>The position of railway crossing. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RailwayCrossing

```java
RailwayCrossing(@NonNull RailwayCrossingType type,
                @NonNull PolylinePosition position)
```

### RailwayCrossing

```java
RailwayCrossing()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getType

```java
@NonNull
RailwayCrossingType getType()
```

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of railway crossing.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
