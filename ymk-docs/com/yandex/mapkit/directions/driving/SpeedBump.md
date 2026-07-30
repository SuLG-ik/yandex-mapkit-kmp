---
title: "SpeedBump"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / SpeedBump"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/SpeedBump.html"
---
# SpeedBump

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/SpeedBump.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.SpeedBump

`class SpeedBump implements Serializable`

A speed bump object.

## Summary

### Constructors

**Signature and Description**

```java
SpeedBump(@NonNull PolylinePosition position)
```

```java
SpeedBump()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>The position of speed bump. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SpeedBump

```java
SpeedBump(@NonNull PolylinePosition position)
```

### SpeedBump

```java
SpeedBump()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of speed bump.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
