---
title: "TurnMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / TurnMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/TurnMetadata.html"
---
# TurnMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/TurnMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.TurnMetadata

`class TurnMetadata implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
TurnMetadata(int turnNumber)
```

```java
TurnMetadata()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getTurnNumber()`<br>The turn number. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### TurnMetadata

```java
TurnMetadata(int turnNumber)
```

### TurnMetadata

```java
TurnMetadata()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getTurnNumber

```java
int getTurnNumber()
```

The turn number.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
