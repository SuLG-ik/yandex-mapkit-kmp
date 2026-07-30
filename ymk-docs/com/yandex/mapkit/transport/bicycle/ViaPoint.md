---
title: "ViaPoint"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / ViaPoint"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ViaPoint.html"
---
# ViaPoint

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/ViaPoint.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

java.lang.Object
↳ com.yandex.mapkit.transport.bicycle.ViaPoint

`class ViaPoint implements Serializable`

Via points (throughpoints) are key points on the route geometry that the route passes through.

Via points are taken from the request.

## Summary

### Constructors

**Signature and Description**

```java
ViaPoint()
```

Use constructor with parameters in your code.

```java
ViaPoint(@NonNull PolylinePosition position)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized PolylinePosition` | `getPosition()`<br>Via point position on the route geometry. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### ViaPoint

```java
ViaPoint()
```

Use constructor with parameters in your code.

This one is for serialization only!

### ViaPoint

```java
ViaPoint(@NonNull PolylinePosition position)
```

## Methods

### getPosition

```java
@NonNull
PolylinePosition getPosition()
```

Via point position on the route geometry.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
