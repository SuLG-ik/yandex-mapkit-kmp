---
title: "SortType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SortType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SortType.html"
---
# SortType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SortType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SortType

`final enum SortType`

Sort type as returned in response.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [RANK](SortType.md#rank) | Results are ordered by rank (or "goodness"). |
| [DISTANCE](SortType.md#distance) | Results are ordered by distance from some origin. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SortType[]` | `values()` |
| `static SortType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### RANK

|   |   |   |
| --- | --- | --- |
| `static final` | [SortType](SortType.md) | RANK |

Results are ordered by rank (or "goodness").

### DISTANCE

|   |   |   |
| --- | --- | --- |
| `static final` | [SortType](SortType.md) | DISTANCE |

Results are ordered by distance from some origin.

## Methods

### values

```java
SortType[] values()
```

### valueOf

```java
SortType valueOf(java.lang.String name)
```
