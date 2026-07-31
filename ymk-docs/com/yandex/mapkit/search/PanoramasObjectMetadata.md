---
title: "PanoramasObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / PanoramasObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PanoramasObjectMetadata.html"
---
# PanoramasObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PanoramasObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.PanoramasObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class PanoramasObjectMetadata implements BaseMetadata, Serializable`

Snippet data to get panoramas info.

## Summary

### Constructors

**Signature and Description**

```java
PanoramasObjectMetadata()
```

Use constructor with parameters in your code.

```java
PanoramasObjectMetadata(@NonNull java.util.List<Panorama> panoramas)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Panorama>` | `getPanoramas()`<br>List of panoramas. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PanoramasObjectMetadata

```java
PanoramasObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PanoramasObjectMetadata

```java
PanoramasObjectMetadata(@NonNull java.util.List<Panorama> panoramas)
```

## Methods

### getPanoramas

```java
@NonNull
java.util.List<Panorama> getPanoramas()
```

List of panoramas.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
