---
title: "IndoorSegment"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / IndoorSegment"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorSegment.html"
---
# IndoorSegment

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/IndoorSegment.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.IndoorSegment

`class IndoorSegment implements Serializable`

Indoor segment of the fitness section.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [IndoorData](IndoorSegment_IndoorData.md) |   |

## Summary

### Constructors

**Signature and Description**

```java
IndoorSegment(@NonNull IndoorData indoorData,
              @NonNull Subpolyline subpolyline)
```

```java
IndoorSegment()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `IndoorData` | `getIndoorData()` |
| `Subpolyline` | `getSubpolyline()`<br>A span of this level on the route geometry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### IndoorSegment

```java
IndoorSegment(@NonNull IndoorData indoorData,
              @NonNull Subpolyline subpolyline)
```

### IndoorSegment

```java
IndoorSegment()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getIndoorData

```java
@NonNull
IndoorData getIndoorData()
```

### getSubpolyline

```java
@NonNull
Subpolyline getSubpolyline()
```

A span of this level on the route geometry.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
