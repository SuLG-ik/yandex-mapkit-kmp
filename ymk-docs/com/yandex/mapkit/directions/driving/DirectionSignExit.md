---
title: "DirectionSignExit"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DirectionSignExit"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignExit.html"
---
# DirectionSignExit

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DirectionSignExit.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DirectionSignExit

`class DirectionSignExit implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
DirectionSignExit(@NonNull java.lang.String name,
                  @NonNull DirectionSignStyle style)
```

```java
DirectionSignExit()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getName()` |
| `DirectionSignStyle` | `getStyle()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### DirectionSignExit

```java
DirectionSignExit(@NonNull java.lang.String name,
                  @NonNull DirectionSignStyle style)
```

### DirectionSignExit

```java
DirectionSignExit()
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
