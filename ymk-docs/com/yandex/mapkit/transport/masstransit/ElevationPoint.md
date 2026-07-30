---
title: "ElevationPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / ElevationPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ElevationPoint.html"
---
# ElevationPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/ElevationPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.ElevationPoint

`class ElevationPoint implements Serializable`

Information of elevation in point

## Summary

### Constructors

**Signature and Description**

```java
ElevationPoint(float elevation)
```

```java
ElevationPoint()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `float` | `getElevation()`<br>Elevation levels in meters |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### ElevationPoint

```java
ElevationPoint(float elevation)
```

### ElevationPoint

```java
ElevationPoint()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getElevation

```java
float getElevation()
```

Elevation levels in meters

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
