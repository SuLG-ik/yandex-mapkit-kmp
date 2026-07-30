---
title: "Leg"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Leg"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Leg.html"
---
# Leg

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Leg.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.Leg

`class Leg implements Serializable`

Leg of the route.

## Summary

### Constructors

**Signature and Description**

```java
Leg()
```

Use constructor with parameters in your code.

```java
Leg(@NonNull Weight weight,
    @NonNull Subpolyline geometry)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Quantitative characteristics of the route leg. |
| `synchronized Subpolyline` | `getGeometry()`<br>Path of the route polyline for the route leg. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Leg

```java
Leg()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Leg

```java
Leg(@NonNull Weight weight,
    @NonNull Subpolyline geometry)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Quantitative characteristics of the route leg.

### getGeometry

```java
@NonNull
Subpolyline getGeometry()
```

Path of the route polyline for the route leg.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
