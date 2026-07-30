---
title: "SearchMode"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / ToponymResultMetadata_SearchMode"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata_SearchMode.html"
---
# SearchMode

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/ToponymResultMetadata_SearchMode.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.ToponymResultMetadata.SearchMode

`static final enum SearchMode`

Search mode.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [GEOCODE](ToponymResultMetadata_SearchMode.md#geocode) | Search from text to toponym. |
| [REVERSE](ToponymResultMetadata_SearchMode.md#reverse) | Search from coordinates to toponym. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SearchMode[]` | `values()` |
| `static SearchMode` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### GEOCODE

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchMode](ToponymResultMetadata_SearchMode.md) | GEOCODE |

Search from text to toponym.

### REVERSE

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchMode](ToponymResultMetadata_SearchMode.md) | REVERSE |

Search from coordinates to toponym.

## Methods

### values

```java
SearchMode[] values()
```

### valueOf

```java
SearchMode valueOf(java.lang.String name)
```
