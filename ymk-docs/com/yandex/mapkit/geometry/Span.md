---
title: "Span"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.geometry"
section: "Android / Справочник / com.yandex.mapkit.geometry / Span"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Span.html"
---
# Span

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/geometry/Span.html)

**Package** com.yandex.mapkit.geometry

java.lang.Object
↳ com.yandex.mapkit.geometry.Span

`class Span implements Serializable`

The panorama field of view.

## Summary

### Constructors

**Signature and Description**

```java
Span(double horizontalAngle,
     double verticalAngle)
```

```java
Span()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getHorizontalAngle()`<br>The horizontal view angle. |
| `double` | `getVerticalAngle()`<br>The vertical view angle. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Span

```java
Span(double horizontalAngle,
     double verticalAngle)
```

### Span

```java
Span()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getHorizontalAngle

```java
double getHorizontalAngle()
```

The horizontal view angle.

### getVerticalAngle

```java
double getVerticalAngle()
```

The vertical view angle.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
