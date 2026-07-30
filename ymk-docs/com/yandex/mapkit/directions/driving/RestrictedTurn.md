---
title: "RestrictedTurn"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / RestrictedTurn"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RestrictedTurn.html"
---
# RestrictedTurn

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/RestrictedTurn.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.RestrictedTurn

`class RestrictedTurn implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
RestrictedTurn(@NonNull PolylinePosition position)
```

```java
RestrictedTurn()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `PolylinePosition` | `getPosition()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### RestrictedTurn

```java
RestrictedTurn(@NonNull PolylinePosition position)
```

### RestrictedTurn

```java
RestrictedTurn()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
