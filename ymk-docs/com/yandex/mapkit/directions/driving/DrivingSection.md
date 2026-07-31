---
title: "DrivingSection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingSection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSection.html"
---
# DrivingSection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DrivingSection

`class DrivingSection implements Serializable`

Route section.

## Summary

### Constructors

**Signature and Description**

```java
DrivingSection()
```

Use constructor with parameters in your code.

```java
DrivingSection(@NonNull DrivingSectionMetadata metadata,
               @NonNull Subpolyline geometry)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized DrivingSectionMetadata` | `getMetadata()`<br>Metadata information for the route section. |
| `synchronized Subpolyline` | `getGeometry()`<br>A polyline of the route section. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### DrivingSection

```java
DrivingSection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### DrivingSection

```java
DrivingSection(@NonNull DrivingSectionMetadata metadata,
               @NonNull Subpolyline geometry)
```

## Methods

### getMetadata

```java
@NonNull
DrivingSectionMetadata getMetadata()
```

Metadata information for the route section.

### getGeometry

```java
@NonNull
Subpolyline getGeometry()
```

A polyline of the route section.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
