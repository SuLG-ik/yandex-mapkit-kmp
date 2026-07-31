---
title: "GeoObjectTags"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / GeoObjectTags"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectTags.html"
---
# GeoObjectTags

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/GeoObjectTags.html)

**Package** com.yandex.mapkit.map

java.lang.Object
↳ com.yandex.mapkit.map.GeoObjectTags

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class GeoObjectTags implements BaseMetadata, Serializable`

Geo object tags.

## Summary

### Constructors

**Signature and Description**

```java
GeoObjectTags()
```

Use constructor with parameters in your code.

```java
GeoObjectTags(@NonNull java.util.List<java.lang.String> tags)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.String>` | `getTags()` |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### GeoObjectTags

```java
GeoObjectTags()
```

Use constructor with parameters in your code.

This one is for serialization only!

### GeoObjectTags

```java
GeoObjectTags(@NonNull java.util.List<java.lang.String> tags)
```

## Methods

### getTags

```java
@NonNull
java.util.List<java.lang.String> getTags()
```

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
