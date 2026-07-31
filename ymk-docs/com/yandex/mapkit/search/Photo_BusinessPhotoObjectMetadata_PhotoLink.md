---
title: "PhotoLink"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Photo_BusinessPhotoObjectMetadata_PhotoLink"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Photo_BusinessPhotoObjectMetadata_PhotoLink.html"
---
# PhotoLink

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Photo_BusinessPhotoObjectMetadata_PhotoLink.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessPhotoObjectMetadata.Photo.PhotoLink

`static class PhotoLink implements Serializable`

Photo link details.

## Summary

### Constructors

**Signature and Description**

```java
PhotoLink()
```

Use constructor with parameters in your code.

```java
PhotoLink(@Nullable java.lang.String type,
          @NonNull java.lang.String uri)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.lang.String` | `getType()`<br>Optional link type, for example "panorama". |
| `synchronized java.lang.String` | `getUri()`<br>Link URI. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### PhotoLink

```java
PhotoLink()
```

Use constructor with parameters in your code.

This one is for serialization only!

### PhotoLink

```java
PhotoLink(@Nullable java.lang.String type,
          @NonNull java.lang.String uri)
```

## Methods

### getType

```java
@Nullable
java.lang.String getType()
```

Optional link type, for example "panorama".

Optional field, can be null.

### getUri

```java
@NonNull
java.lang.String getUri()
```

Link URI.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
