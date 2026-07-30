---
title: "ScreenPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / ScreenPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ScreenPoint.html"
---
# ScreenPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ScreenPoint.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.ScreenPoint

`class ScreenPoint implements Serializable`

A point on the device screen.

## Summary

### Constructors

**Signature and Description**

```java
ScreenPoint(float x,
            float y)
```

```java
ScreenPoint()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getX()`<br>The horizontal position of the point in pixels from the left screen border. |
| `float` | `getY()`<br>The vertical position of the point in pixels from the top screen border. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ScreenPoint

```java
ScreenPoint(float x,
            float y)
```

### ScreenPoint

```java
ScreenPoint()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getX

```java
float getX()
```

The horizontal position of the point in pixels from the left screen border.

### getY

```java
float getY()
```

The vertical position of the point in pixels from the top screen border.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
