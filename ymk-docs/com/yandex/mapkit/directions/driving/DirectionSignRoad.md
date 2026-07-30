---
title: "DirectionSignRoad"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignRoad"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignRoad.html"
---
# DirectionSignRoad

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignRoad.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignRoad

`class DirectionSignRoad implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignRoad(@NonNull java.lang.String name,
                  @NonNull DirectionSignStyle style)
```

```java
DirectionSignRoad()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getName()` |
| `DirectionSignStyle` | `getStyle()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignRoad

```java
DirectionSignRoad(@NonNull java.lang.String name,
                  @NonNull DirectionSignStyle style)
```

### DirectionSignRoad

```java
DirectionSignRoad()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getName

```java
@NonNull
java.lang.String getName()
```

### getStyle

```java
@NonNull
DirectionSignStyle getStyle()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
