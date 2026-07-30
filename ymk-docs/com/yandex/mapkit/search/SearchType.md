---
title: "SearchType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchType.html"
---
# SearchType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SearchType

`final enum SearchType`

Bitmask for requested search types.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [NONE](SearchType.md#none) | Default value: all types requested. |
| [GEO](SearchType.md#geo) | Toponyms. |
| [BIZ](SearchType.md#biz) | Companies. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SearchType[]` | `values()` |
| `static SearchType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### NONE

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchType](SearchType.md) | NONE |

Default value: all types requested.

### GEO

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchType](SearchType.md) | GEO |

Toponyms.

### BIZ

|   |   |   |
| --- | --- | --- |
| `static final` | [SearchType](SearchType.md) | BIZ |

Companies.

## Methods

### values

```java
SearchType[] values()
```

### valueOf

```java
SearchType valueOf(java.lang.String name)
```
