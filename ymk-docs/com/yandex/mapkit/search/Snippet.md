---
title: "Snippet"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Snippet"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Snippet.html"
---
# Snippet

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Snippet.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.Snippet

`final enum Snippet`

Requested snippets bitmask.

Snippets are additional pieces of information (possibly from different services) which are not directly stored in object metadata but may be requested separately based on client needs.

Different snippets are applicable to different objects: some of the snippets can be provided only for toponyms, some for businesses and some for all object types.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NONE](Snippet.md#none) | Default value: no snippets requested. |
| [PHOTOS](Snippet.md#photos) | Related photos snippet (can be requested for a business or toponym). |
| [BUSINESS_RATING1X](Snippet.md#business_rating1x) | Information about ratings (can be requested for a business). |
| [PANORAMAS](Snippet.md#panoramas) | Nearest panoramas to this point. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static Snippet[]` | `values()` |
| `static Snippet` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NONE

|   |   |   |
| --- | --- | --- |
| `static final` | [Snippet](Snippet.md) | NONE |

Default value: no snippets requested.

### PHOTOS

|   |   |   |
| --- | --- | --- |
| `static final` | [Snippet](Snippet.md) | PHOTOS |

Related photos snippet (can be requested for a business or toponym).

See [mapkit.search.BusinessPhotoObjectMetadata](BusinessPhotoObjectMetadata.md).

### BUSINESS_RATING1X

|   |   |   |
| --- | --- | --- |
| `static final` | [Snippet](Snippet.md) | BUSINESS_RATING1X |

Information about ratings (can be requested for a business).

See [mapkit.search.BusinessRating1xObjectMetadata](BusinessRating1xObjectMetadata.md).

### PANORAMAS

|   |   |   |
| --- | --- | --- |
| `static final` | [Snippet](Snippet.md) | PANORAMAS |

Nearest panoramas to this point.

See [mapkit.search.PanoramasObjectMetadata](PanoramasObjectMetadata.md).

## Methods

### values

```java
Snippet[] values()
```

### valueOf

```java
Snippet valueOf(java.lang.String name)
```
