---
title: "UturnMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / UturnMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/UturnMetadata.html"
---
# UturnMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/UturnMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.UturnMetadata

`class UturnMetadata implements Serializable`

The length of the U-turn.

## Summary

### Constructors

**Signature and Description**

```java
UturnMetadata(double length)
```

```java
UturnMetadata()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `double` | `getLength()`<br>The length of the turn. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### UturnMetadata

```java
UturnMetadata(double length)
```

### UturnMetadata

```java
UturnMetadata()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getLength

```java
double getLength()
```

The length of the turn.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
