---
title: "Photo"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessPhotoObjectMetadata_Photo"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessPhotoObjectMetadata_Photo.html"
---
# Photo

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessPhotoObjectMetadata_Photo.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessPhotoObjectMetadata.Photo

`static class Photo implements Serializable`

Information about single photos.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [PhotoLink](Photo_BusinessPhotoObjectMetadata_PhotoLink.md) | Photo link details. |

## Summary

### Constructors

**Signature and Description**

```java
Photo()
```

Use constructor with parameters in your code.

```java
Photo(@NonNull java.lang.String id,
      @NonNull java.util.List<PhotoLink> links)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getId()`<br>To get a valid download link use the value of id + /[size], where [size] is one of: 1. |
| `synchronized java.util.List<PhotoLink>` | `getLinks()`<br>Photo links. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### Photo

```java
Photo()
```

Use constructor with parameters in your code.

This one is for serialization only!

### Photo

```java
Photo(@NonNull java.lang.String id,
      @NonNull java.util.List<PhotoLink> links)
```

## Methods

### getId

```java
@NonNull
java.lang.String getId()
```

To get a valid download link use the value of id + /[size], where [size] is one of: 1.

XXXS 2. XXS 3. XS 4. S 5. M 6. L 7. XL 8. XXL 9. XXXL 10. orig

### getLinks

```java
@NonNull
java.util.List<PhotoLink> getLinks()
```

Photo links.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
