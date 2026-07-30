---
title: "Stairs"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Stairs"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Stairs.html"
---
# Stairs

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Stairs.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Stairs

`class Stairs implements Serializable`

Represents stairs objects along the route

## Summary

### Constructors

**Signature and Description**

```java
Stairs(@NonNull StairsDirection direction,
       boolean hasRamp)
```

```java
Stairs()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `StairsDirection` | `getDirection()` |
| `boolean` | `getHasRamp()`<br>Does stairs have a ramp |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Stairs

```java
Stairs(@NonNull StairsDirection direction,
       boolean hasRamp)
```

### Stairs

```java
Stairs()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getDirection

```java
@NonNull
StairsDirection getDirection()
```

### getHasRamp

```java
boolean getHasRamp()
```

Does stairs have a ramp

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
