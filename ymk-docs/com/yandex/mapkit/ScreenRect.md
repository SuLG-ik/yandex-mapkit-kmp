---
title: "ScreenRect"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / ScreenRect"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ScreenRect.html"
---
# ScreenRect

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ScreenRect.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.ScreenRect

`class ScreenRect implements Serializable`

A rectangle on the device screen.

## Summary

### Constructors

**Signature and Description**

```java
ScreenRect(@NonNull ScreenPoint topLeft,
           @NonNull ScreenPoint bottomRight)
```

```java
ScreenRect()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ScreenPoint` | `getTopLeft()`<br>The position of the top left corner of the rectangle. |
| `ScreenPoint` | `getBottomRight()`<br>The position of the bottom right corner of the rectangle. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ScreenRect

```java
ScreenRect(@NonNull ScreenPoint topLeft,
           @NonNull ScreenPoint bottomRight)
```

### ScreenRect

```java
ScreenRect()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTopLeft

```java
@NonNull
ScreenPoint getTopLeft()
```

The position of the top left corner of the rectangle.

### getBottomRight

```java
@NonNull
ScreenPoint getBottomRight()
```

The position of the bottom right corner of the rectangle.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
