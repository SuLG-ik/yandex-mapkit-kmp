---
title: "RelatedPlacesObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / RelatedPlacesObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/RelatedPlacesObjectMetadata.html"
---
# RelatedPlacesObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/RelatedPlacesObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.RelatedPlacesObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class RelatedPlacesObjectMetadata implements BaseMetadata, Serializable`

Snippet data to get related places info.

## Summary

### Constructors

**Signature and Description**

```java
RelatedPlacesObjectMetadata()
```

Use constructor with parameters in your code.

```java
RelatedPlacesObjectMetadata(@NonNull java.util.List<PlaceInfo> similarPlaces)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<PlaceInfo>` | `getSimilarPlaces()`<br>List of similar places. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### RelatedPlacesObjectMetadata

```java
RelatedPlacesObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### RelatedPlacesObjectMetadata

```java
RelatedPlacesObjectMetadata(@NonNull java.util.List<PlaceInfo> similarPlaces)
```

## Methods

### getSimilarPlaces

```java
@NonNull
java.util.List<PlaceInfo> getSimilarPlaces()
```

List of similar places.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
