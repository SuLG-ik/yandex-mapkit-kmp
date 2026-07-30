---
title: "Annotation"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.masstransit"
section: "Android / Справочник / com.yandex.mapkit.transport.masstransit / Annotation"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Annotation.html"
---
# Annotation

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/masstransit/Annotation.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.masstransit

java.lang.Object
↳ com.yandex.mapkit.transport.masstransit.Annotation

`class Annotation implements Serializable`

Contains info about actions on part of route.

Either `action` or `landmark` should be non-empty.

## Summary

### Constructors

**Signature and Description**

```java
Annotation()
```

Use constructor with parameters in your code.

```java
Annotation(@NonNull PolylinePosition position,
           @Nullable ActionID action,
           @Nullable LandmarkID landmark,
           @Nullable Toponym toponym)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPosition()`<br>Position of annotation on part of route |
| `synchronized ActionID` | `getAction()`<br>Action<br>Optional field, can be null. |
| `synchronized LandmarkID` | `getLandmark()`<br>Landmark<br>Optional field, can be null. |
| `synchronized Toponym` | `getToponym()`<br>The toponym of the location. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Annotation

```java
Annotation()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Annotation

```java
Annotation(@NonNull PolylinePosition position,
           @Nullable ActionID action,
           @Nullable LandmarkID landmark,
           @Nullable Toponym toponym)
```

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

Position of annotation on part of route

### getAction

```java
@Nullable
ActionID getAction()
```

Action

Optional field, can be null.

### getLandmark

```java
@Nullable
LandmarkID getLandmark()
```

Landmark

Optional field, can be null.

### getToponym

```java
@Nullable
Toponym getToponym()
```

The toponym of the location.

Optional field, can be null.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
