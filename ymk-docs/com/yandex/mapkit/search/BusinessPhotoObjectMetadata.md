---
title: "BusinessPhotoObjectMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessPhotoObjectMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessPhotoObjectMetadata.html"
---
# BusinessPhotoObjectMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessPhotoObjectMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessPhotoObjectMetadata

## All Superinterfaces:

*[BaseMetadata](../BaseMetadata.md)*

`class BusinessPhotoObjectMetadata implements BaseMetadata, Serializable`

Snippet for company-related photos (becoming obsolete).

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [Photo](BusinessPhotoObjectMetadata_Photo.md) | Information about single photos. |

## Summary

### Constructors

**Signature and Description**

```java
BusinessPhotoObjectMetadata()
```

Use constructor with parameters in your code.

```java
BusinessPhotoObjectMetadata(int count,
                            @NonNull java.util.List<Photo> photos)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized int` | `getCount()`<br>Number of photos for the organisation. |
| `synchronized java.util.List<Photo>` | `getPhotos()`<br>List of photos for the company (usually first three) |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessPhotoObjectMetadata

```java
BusinessPhotoObjectMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessPhotoObjectMetadata

```java
BusinessPhotoObjectMetadata(int count,
                            @NonNull java.util.List<Photo> photos)
```

## Methods

### getCount

```java
int getCount()
```

Number of photos for the organisation.

(see PhotosManager for details)

### getPhotos

```java
@NonNull
java.util.List<Photo> getPhotos()
```

List of photos for the company (usually first three)

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
