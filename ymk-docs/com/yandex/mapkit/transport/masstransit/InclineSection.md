---
title: "InclineSection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / InclineSection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/InclineSection.html"
---
# InclineSection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/InclineSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.InclineSection

`class InclineSection implements Serializable`

represents a section of continuous non-trivial gradient

## Summary

### Constructors

**Signature and Description**

```java
InclineSection(@NonNull InclineType type,
               @NonNull Subpolyline subpolyline)
```

```java
InclineSection()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `InclineType` | `getType()`<br>Vague characteristic of this gradient secion |
| `Subpolyline` | `getSubpolyline()`<br>A subpolyline of the route where the section is located |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### InclineSection

```java
InclineSection(@NonNull InclineType type,
               @NonNull Subpolyline subpolyline)
```

### InclineSection

```java
InclineSection()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getType

```java
@NonNull
InclineType getType()
```

Vague characteristic of this gradient secion

### getSubpolyline

```java
@NonNull
Subpolyline getSubpolyline()
```

A subpolyline of the route where the section is located

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
