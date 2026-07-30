---
title: "Position"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / Position"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/Position.html"
---
# Position

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/Position.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

java.lang.Object
↳ com.yandex.mapkit.places.panorama.Position

`class Position implements Serializable`

Position struct

## Summary

### Constructors

**Signature and Description**

```java
Position(@NonNull Point point,
         double altitude)
```

```java
Position()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Point` | `getPoint()`<br>Longitude and latitude, degrees. |
| `double` | `getAltitude()`<br>Altitude, meters. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Position

```java
Position(@NonNull Point point,
         double altitude)
```

### Position

```java
Position()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getPoint

```java
@NonNull
Point getPoint()
```

Longitude and latitude, degrees.

### getAltitude

```java
double getAltitude()
```

Altitude, meters.

Positive is above sea-level

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
