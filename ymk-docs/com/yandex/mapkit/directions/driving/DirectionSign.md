---
title: "DirectionSign"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSign"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSign.html"
---
# DirectionSign

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSign.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSign

`class DirectionSign implements Serializable`

The sign showing named directions.

## Summary

### Constructors

**Signature and Description**

```java
DirectionSign()
```

Use constructor with parameters in your code.

```java
DirectionSign(@NonNull PolylinePosition position,
              @Nullable DirectionSignDirection direction,
              @NonNull java.util.List<DirectionSignItem> items)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPosition()`<br>The position of the sign. |
| `synchronized DirectionSignDirection` | `getDirection()`<br>Optional field, can be null. |
| `synchronized java.util.List<DirectionSignItem>` | `getItems()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### DirectionSign

```java
DirectionSign()
```

Use constructor with parameters in your code.

This one is for serialization only!

### DirectionSign

```java
DirectionSign(@NonNull PolylinePosition position,
              @Nullable DirectionSignDirection direction,
              @NonNull java.util.List<DirectionSignItem> items)
```

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

The position of the sign.

### getDirection

```java
@Nullable
DirectionSignDirection getDirection()
```

Optional field, can be null.

### getItems

```java
@NonNull
java.util.List<DirectionSignItem> getItems()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
