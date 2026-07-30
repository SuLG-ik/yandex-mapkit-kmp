---
title: "SuggestType"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestType"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestType.html"
---
# SuggestType

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestType.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SuggestType

`final enum SuggestType`

Bitmask for requested suggest types.

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [UNSPECIFIED](SuggestType.md#unspecified) | Default value: server-defined types are returned. |
| [GEO](SuggestType.md#geo) | Toponyms. |
| [BIZ](SuggestType.md#biz) | Companies. |
| [TRANSIT](SuggestType.md#transit) | Mass transit routes. |
| [ONE_ORG](SuggestType.md#one_org) | Organization that can be uniquely identified by search request. |
| [CHAIN](SuggestType.md#chain) | Chains. |
| [RUBRIC](SuggestType.md#rubric) | Rubrics. |
| [TEXT_HINT](SuggestType.md#text_hint) | Text hints. |
| [PROMO_QUERY](SuggestType.md#promo_query) | Promo queries. |
| [COORDS](SuggestType.md#coords) | Coordinates. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SuggestType[]` | `values()` |
| `static SuggestType` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### UNSPECIFIED

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | UNSPECIFIED |

Default value: server-defined types are returned.

### GEO

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | GEO |

Toponyms.

### BIZ

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | BIZ |

Companies.

### TRANSIT

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | TRANSIT |

Mass transit routes.

### ONE_ORG

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | ONE_ORG |

Organization that can be uniquely identified by search request.

### CHAIN

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | CHAIN |

Chains.

### RUBRIC

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | RUBRIC |

Rubrics.

### TEXT_HINT

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | TEXT_HINT |

Text hints.

### PROMO_QUERY

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | PROMO_QUERY |

Promo queries.

### COORDS

|   |   |   |
| --- | --- | --- |
| `static final` | [SuggestType](SuggestType.md) | COORDS |

Coordinates.

## Methods

### values

```java
SuggestType[] values()
```

### valueOf

```java
SuggestType valueOf(java.lang.String name)
```
