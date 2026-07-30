---
title: "SortOrigin"
kind: "Enum"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SortOrigin"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SortOrigin.html"
---
# SortOrigin

`ANDROID` · `Java` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SortOrigin.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ java.lang.Enum
↳ com.yandex.mapkit.search.SortOrigin

`final enum SortOrigin`

Sort origin types when results are ordered by distance (see [mapkit.search.SortType](SortType.md)).

## Enum Constant Summary

| Enum Constants | Description |
| --- | --- |
| [USER](SortOrigin.md#user) | Sort origin is a user position. |
| [QUERY](SortOrigin.md#query) | Sort origin is a toponym extracted from the user query. |
| [REQUEST](SortOrigin.md#request) | Sort origin is directly specified by client. |

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `static SortOrigin[]` | `values()` |
| `static SortOrigin` | `valueOf(java.lang.String name)` |

## Enum Constants Detail

### USER

|   |   |   |
| --- | --- | --- |
| `static final` | [SortOrigin](SortOrigin.md) | USER |

Sort origin is a user position.

User position can be set via {link SearchOptions}.

### QUERY

|   |   |   |
| --- | --- | --- |
| `static final` | [SortOrigin](SortOrigin.md) | QUERY |

Sort origin is a toponym extracted from the user query.

For example this type can be set for queries like "cafe near Central Park".

### REQUEST

|   |   |   |
| --- | --- | --- |
| `static final` | [SortOrigin](SortOrigin.md) | REQUEST |

Sort origin is directly specified by client.

This type can be set for sessions with {link search.Session#setSortByDistance(const mapkit.geometry.Geometry)} called.

## Methods

### values

```java
SortOrigin[] values()
```

### valueOf

```java
SortOrigin valueOf(java.lang.String name)
```
