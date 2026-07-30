---
title: "BalloonAnchor"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.balloons"
section: "Android / Справочник / com.yandex.mapkit.navigation.balloons / BalloonAnchor"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/balloons/BalloonAnchor.html"
---
# BalloonAnchor

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/balloons/BalloonAnchor.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.balloons

java.lang.Object
↳ com.yandex.mapkit.navigation.balloons.BalloonAnchor

`class BalloonAnchor implements Serializable`

BalloonAnchor represents where balloon image has a leg

## Summary

### Constructors

**Signature and Description**

```java
BalloonAnchor(@NonNull VerticalPosition vertical,
              @NonNull HorizontalPosition horizontal)
```

```java
BalloonAnchor()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `VerticalPosition` | `getVertical()` |
| `HorizontalPosition` | `getHorizontal()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### BalloonAnchor

```java
BalloonAnchor(@NonNull VerticalPosition vertical,
              @NonNull HorizontalPosition horizontal)
```

### BalloonAnchor

```java
BalloonAnchor()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getVertical

```java
@NonNull
VerticalPosition getVertical()
```

### getHorizontal

```java
@NonNull
HorizontalPosition getHorizontal()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
