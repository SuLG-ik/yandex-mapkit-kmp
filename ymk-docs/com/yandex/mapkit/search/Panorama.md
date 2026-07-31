---
title: "Panorama"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Panorama"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Panorama.html"
---
# Panorama

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Panorama.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.Panorama

`class Panorama implements Serializable`

Panorama info.

## Summary

### Constructors

**Signature and Description**

```java
Panorama(@NonNull java.lang.String id,
         @NonNull Direction direction,
         @NonNull Span span,
         @NonNull Point point)
```

```java
Panorama()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `java.lang.String` | `getId()`<br>Machine readable panorama identifier. |
| `Direction` | `getDirection()`<br>Direction of the panorama center. |
| `Span` | `getSpan()`<br>H-Span and V-Span hints for the panorama player. |
| `Point` | `getPoint()`<br>Panorama point. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### Panorama

```java
Panorama(@NonNull java.lang.String id,
         @NonNull Direction direction,
         @NonNull Span span,
         @NonNull Point point)
```

### Panorama

```java
Panorama()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

Machine readable panorama identifier.

### getDirection

```java
@NonNull
Direction getDirection()
```

Direction of the panorama center.

### getSpan

```java
@NonNull
Span getSpan()
```

H-Span and V-Span hints for the panorama player.

### getPoint

```java
@NonNull
Point getPoint()
```

Panorama point.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
