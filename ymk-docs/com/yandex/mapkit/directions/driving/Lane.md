---
title: "Lane"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / Lane"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Lane.html"
---
# Lane

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/Lane.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.Lane

`class Lane implements Serializable`

The lane object.

## Summary

### Constructors

**Signature and Description**

```java
Lane()
```

Use constructor with parameters in your code.

```java
Lane(@NonNull LaneKind laneKind,
     @NonNull java.util.List<LaneDirection> directions,
     @Nullable LaneDirection highlightedDirection)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized LaneKind` | `getLaneKind()`<br>The type of lane. |
| `synchronized java.util.List<LaneDirection>` | `getDirections()`<br>Lane direction. |
| `synchronized LaneDirection` | `getHighlightedDirection()`<br>Highlighted lane direction. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Lane

```java
Lane()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Lane

```java
Lane(@NonNull LaneKind laneKind,
     @NonNull java.util.List<LaneDirection> directions,
     @Nullable LaneDirection highlightedDirection)
```

## Methods

### getLaneKind

```java
@NonNull
LaneKind getLaneKind()
```

The type of lane.

### getDirections

```java
@NonNull
java.util.List<LaneDirection> getDirections()
```

Lane direction.

### getHighlightedDirection

```java
@Nullable
LaneDirection getHighlightedDirection()
```

Highlighted lane direction.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
