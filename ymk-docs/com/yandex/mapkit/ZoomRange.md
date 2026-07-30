---
title: "ZoomRange"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / ZoomRange"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ZoomRange.html"
---
# ZoomRange

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/ZoomRange.html)

**Package** com.yandex.mapkit

java.lang.Object
↳ com.yandex.mapkit.ZoomRange

`class ZoomRange implements Serializable`

Describes the range of zoom levels.

Zooming is allowed between zMin and zMax values.

## Summary

### Constructors

**Signature and Description**

```java
ZoomRange(int zMin,
          int zMax)
```

```java
ZoomRange()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getZMin()`<br>Lower limit of zoom range, inclusive. |
| `int` | `getZMax()`<br>Upper limit of zoom range, exclusive. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ZoomRange

```java
ZoomRange(int zMin,
          int zMax)
```

### ZoomRange

```java
ZoomRange()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getZMin

```java
int getZMin()
```

Lower limit of zoom range, inclusive.

### getZMax

```java
int getZMax()
```

Upper limit of zoom range, exclusive.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
