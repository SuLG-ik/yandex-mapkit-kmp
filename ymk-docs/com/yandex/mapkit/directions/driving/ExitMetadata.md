---
title: "ExitMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / ExitMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ExitMetadata.html"
---
# ExitMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/ExitMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.ExitMetadata

`class ExitMetadata implements Serializable`

## Summary

### Constructors

**Signature and Description**

```java
ExitMetadata(@Nullable java.lang.Integer sequentialNumber,
             @Nullable java.lang.Integer numerationProximityMask)
```

```java
ExitMetadata()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.Integer` | `getSequentialNumber()`<br>The number in the sequence of consecutive exits. |
| `java.lang.Integer` | `getNumerationProximityMask()`<br>Determines whether it is necessary to annotate the exit number in the imm stage. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ExitMetadata

```java
ExitMetadata(@Nullable java.lang.Integer sequentialNumber,
             @Nullable java.lang.Integer numerationProximityMask)
```

### ExitMetadata

```java
ExitMetadata()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSequentialNumber

```java
@Nullable
java.lang.Integer getSequentialNumber()
```

The number in the sequence of consecutive exits.

Optional field, can be null.

### getNumerationProximityMask

```java
@Nullable
java.lang.Integer getNumerationProximityMask()
```

Determines whether it is necessary to annotate the exit number in the imm stage.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
