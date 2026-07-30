---
title: "ConstructionSegment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ConstructionSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ConstructionSegment.html"
---
# ConstructionSegment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ConstructionSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.ConstructionSegment

`class ConstructionSegment implements Serializable`

Describes part of pedestrian or bicycle path with the same construction.

## Summary

### Constructors

**Signature and Description**

```java
ConstructionSegment(@NonNull Subpolyline subpolyline,
                    @NonNull ConstructionMask constructionMask)
```

```java
ConstructionSegment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Subpolyline` | `getSubpolyline()` |
| `ConstructionMask` | `getConstructionMask()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ConstructionSegment

```java
ConstructionSegment(@NonNull Subpolyline subpolyline,
                    @NonNull ConstructionMask constructionMask)
```

### ConstructionSegment

```java
ConstructionSegment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSubpolyline

```java
@NonNull
Subpolyline getSubpolyline()
```

### getConstructionMask

```java
@NonNull
ConstructionMask getConstructionMask()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
