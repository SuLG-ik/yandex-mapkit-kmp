---
title: "LaneSign"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / LaneSign"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/LaneSign.html"
---
# LaneSign

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/LaneSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.LaneSign

`class LaneSign implements Serializable`

The sign showing a lane.

## Summary

### Constructors

**Signature and Description**

```java
LaneSign()
```

Use constructor with parameters in your code.

```java
LaneSign(@NonNull PolylinePosition position,
         @Nullable java.lang.Boolean annotated,
         @NonNull java.util.List<Lane> lanes)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPosition()`<br>The position of the sign. |
| `synchronized java.lang.Boolean` | `getAnnotated()`<br>Determines whether the sign should be annotated. |
| `synchronized java.util.List<Lane>` | `getLanes()`<br>The lane to display the sign in. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### LaneSign

```java
LaneSign()
```

Use constructor with parameters in your code.

This one is for serialization only!

### LaneSign

```java
LaneSign(@NonNull PolylinePosition position,
         @Nullable java.lang.Boolean annotated,
         @NonNull java.util.List<Lane> lanes)
```

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of the sign.

### getAnnotated

```java
@Nullable
java.lang.Boolean getAnnotated()
```

Determines whether the sign should be annotated.

Optional field, can be null.

### getLanes

```java
@NonNull
java.util.List<Lane> getLanes()
```

The lane to display the sign in.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
