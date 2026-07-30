---
title: "Checkpoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Checkpoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Checkpoint.html"
---
# Checkpoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Checkpoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Checkpoint

`class Checkpoint implements Serializable`

A checkpoint object.

## Summary

### Constructors

**Signature and Description**

```java
Checkpoint(@NonNull PolylinePosition position)
```

```java
Checkpoint()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()`<br>The position of the checkpoint. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Checkpoint

```java
Checkpoint(@NonNull PolylinePosition position)
```

### Checkpoint

```java
Checkpoint()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of the checkpoint.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
