---
title: "ConstructionSegment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / ConstructionSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ConstructionSegment.html"
---
# ConstructionSegment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ConstructionSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.ConstructionSegment

`class ConstructionSegment implements Serializable`

Describes part of bicycle path with the same construction.

## Summary

### Constructors

**Signature and Description**

```java
ConstructionSegment(@NonNull ConstructionID construction,
                    @NonNull Subpolyline subpolyline)
```

```java
ConstructionSegment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `ConstructionID` | `getConstruction()` |
| `Subpolyline` | `getSubpolyline()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ConstructionSegment

```java
ConstructionSegment(@NonNull ConstructionID construction,
                    @NonNull Subpolyline subpolyline)
```

### ConstructionSegment

```java
ConstructionSegment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getConstruction

```java
@NonNull
ConstructionID getConstruction()
```

### getSubpolyline

```java
@NonNull
Subpolyline getSubpolyline()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
