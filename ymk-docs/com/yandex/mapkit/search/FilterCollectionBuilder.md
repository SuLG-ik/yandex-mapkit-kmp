---
title: "FilterCollectionBuilder"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FilterCollectionBuilder"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollectionBuilder.html"
---
# FilterCollectionBuilder

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollectionBuilder.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface FilterCollectionBuilder`

Builder for filter collection.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addBooleanFilter(@NonNull java.lang.String filterId)`<br>Adds boolean filter with given id to collection. |
| `void` | `addEnumFilter(@NonNull java.lang.String filterId, @NonNull java.util.List<java.lang.String> valueIds)`<br>Adds enum filter with given id and values to the collection. |
| `void` | `addRangeFilter(@NonNull java.lang.String filterId, double from, double to)`<br>Adds range filter with given id and limits to the collection. |
| `void` | `addDateFilter(@NonNull java.lang.String filterId, @NonNull java.lang.String from, @NonNull java.lang.String to)`<br>Adds date filter with given id and limits to the collection. |
| `FilterCollection` | `build()`<br>Builds resulting collection. |

## Methods

### addBooleanFilter

```java
void addBooleanFilter(@NonNull java.lang.String filterId)
```

Adds boolean filter with given id to collection.

| Parameters |   |
| --- | --- |
| `filterId` | filter id to add. |

### addEnumFilter

```java
void addEnumFilter(@NonNull java.lang.String filterId,
                   @NonNull java.util.List<java.lang.String> valueIds)
```

Adds enum filter with given id and values to the collection.

| Parameters |   |
| --- | --- |
| `filterId` | filter id to add. |
| `valueIds` | list of value ids for the enum filter. |

### addRangeFilter

```java
void addRangeFilter(@NonNull java.lang.String filterId,
                    double from,
                    double to)
```

Adds range filter with given id and limits to the collection.

| Parameters |   |
| --- | --- |
| `filterId` | filter id to add. |
| `from` | lower range limit. |
| `to` | upper range limit. |

### addDateFilter

```java
void addDateFilter(@NonNull java.lang.String filterId,
                   @NonNull java.lang.String from,
                   @NonNull java.lang.String to)
```

Adds date filter with given id and limits to the collection.

Limits are encoded as strings in YYYYMMDD format.

| Parameters |   |
| --- | --- |
| `filterId` | filter id to add. |
| `from` | lower range limit. |
| `to` | upper range limit. |

### build

```java
@NonNull
FilterCollection build()
```

Builds resulting collection.

**Returns**

collection built from previously given filters.
