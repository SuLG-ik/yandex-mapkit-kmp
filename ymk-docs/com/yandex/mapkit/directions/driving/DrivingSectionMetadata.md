---
title: "DrivingSectionMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.directions.driving"
section: "Android / Справочник / com.yandex.mapkit.directions.driving / DrivingSectionMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSectionMetadata.html"
---
# DrivingSectionMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/directions/driving/DrivingSectionMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.directions.driving

java.lang.Object
↳ com.yandex.mapkit.directions.driving.DrivingSectionMetadata

`class DrivingSectionMetadata implements Serializable`

Information about section metadata.

## Summary

### Constructors

**Signature and Description**

```java
DrivingSectionMetadata()
```

Use constructor with parameters in your code.

```java
DrivingSectionMetadata(int legIndex,
                       @NonNull Weight weight,
                       @NonNull Annotation annotation,
                       @NonNull java.util.List<java.lang.Integer> viaPointPositions)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getLegIndex()`<br>A leg is a section of the route between two consecutive waypoints. |
| `synchronized Weight` | `getWeight()`<br>The "weight" of the section. |
| `synchronized Annotation` | `getAnnotation()`<br>Section annotation. |
| `synchronized java.util.List<java.lang.Integer>` | `getViaPointPositions()`<br>Via points (throughpoints) can appear only at nodes of the section's geometry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### DrivingSectionMetadata

```java
DrivingSectionMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### DrivingSectionMetadata

```java
DrivingSectionMetadata(int legIndex,
                       @NonNull Weight weight,
                       @NonNull Annotation annotation,
                       @NonNull java.util.List<java.lang.Integer> viaPointPositions)
```

## Methods

### getLegIndex

```java
int getLegIndex()
```

A leg is a section of the route between two consecutive waypoints.

### getWeight

```java
@NonNull
Weight getWeight()
```

The "weight" of the section.

### getAnnotation

```java
@NonNull
Annotation getAnnotation()
```

Section annotation.

### getViaPointPositions

```java
@NonNull
java.util.List<java.lang.Integer> getViaPointPositions()
```

Via points (throughpoints) can appear only at nodes of the section's geometry.

The vector contains the positions of all corresponding nodes. These positions should be listed in ascending order.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
