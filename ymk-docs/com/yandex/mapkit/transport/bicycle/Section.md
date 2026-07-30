---
title: "Section"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Section"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Section.html"
---
# Section

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Section.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.Section

`class Section implements Serializable`

Section of the route.

## Summary

### Constructors

**Signature and Description**

```java
Section()
```

Use constructor with parameters in your code.

```java
Section(@NonNull Weight weight,
        @NonNull Subpolyline geometry)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized Weight` | `getWeight()`<br>Quantitative characteristics of a route or route section. |
| `synchronized Subpolyline` | `getGeometry()`<br>Path of the route polyline for this section. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Section

```java
Section()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Section

```java
Section(@NonNull Weight weight,
        @NonNull Subpolyline geometry)
```

## Methods

### getWeight

```java
@NonNull
Weight getWeight()
```

Quantitative characteristics of a route or route section.

### getGeometry

```java
@NonNull
Subpolyline getGeometry()
```

Path of the route polyline for this section.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
