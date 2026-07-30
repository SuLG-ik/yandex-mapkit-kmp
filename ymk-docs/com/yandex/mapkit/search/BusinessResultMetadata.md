---
title: "BusinessResultMetadata"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / BusinessResultMetadata"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessResultMetadata.html"
---
# BusinessResultMetadata

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/BusinessResultMetadata.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.BusinessResultMetadata

`class BusinessResultMetadata implements Serializable`

Common info for business search response.

## Summary

### Constructors

**Signature and Description**

```java
BusinessResultMetadata()
```

Use constructor with parameters in your code.

```java
BusinessResultMetadata(@NonNull java.util.List<Category> categories,
                       @NonNull java.util.List<Chain> chains,
                       @NonNull java.util.List<BusinessFilter> businessFilters,
                       @Nullable FilterSet importantFilters,
                       @NonNull java.util.List<BusinessFilterGroup> filterGroups,
                       @NonNull java.util.List<java.lang.String> pricesCurrencies)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<Category>` | `getCategories()`<br>List of categories (also known as rubrics) present in response. |
| `synchronized java.util.List<Chain>` | `getChains()`<br>List of chains present in response. |
| `synchronized java.util.List<BusinessFilter>` | `getBusinessFilters()`<br>List of applicable filters. |
| `synchronized FilterSet` | `getImportantFilters()`<br>Collection of filters that probably are of utmost interest to the user. |
| `synchronized java.util.List<BusinessFilterGroup>` | `getFilterGroups()`<br>Grouped BusinessFilter's by their meaning. |
| `synchronized java.util.List<java.lang.String>` | `getPricesCurrencies()`<br>Relevant currency for the prices |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### BusinessResultMetadata

```java
BusinessResultMetadata()
```

Use constructor with parameters in your code.

This one is for serialization only!

### BusinessResultMetadata

```java
BusinessResultMetadata(@NonNull java.util.List<Category> categories,
                       @NonNull java.util.List<Chain> chains,
                       @NonNull java.util.List<BusinessFilter> businessFilters,
                       @Nullable FilterSet importantFilters,
                       @NonNull java.util.List<BusinessFilterGroup> filterGroups,
                       @NonNull java.util.List<java.lang.String> pricesCurrencies)
```

## Methods

### getCategories

```java
@NonNull
java.util.List<Category> getCategories()
```

List of categories (also known as rubrics) present in response.

Non-empty list means that the request was treated as a 'category request' by the server (for example requests like "where to eat", "cinema", and other).

### getChains

```java
@NonNull
java.util.List<Chain> getChains()
```

List of chains present in response.

Non-empty list means that the request was treaded as 'chain request' (for example "mcdonalds", "starbucks", and other).

### getBusinessFilters

```java
@NonNull
java.util.List<BusinessFilter> getBusinessFilters()
```

List of applicable filters.

### getImportantFilters

```java
@Nullable
FilterSet getImportantFilters()
```

Collection of filters that probably are of utmost interest to the user.

Optional field, can be null.

### getFilterGroups

```java
@NonNull
java.util.List<BusinessFilterGroup> getFilterGroups()
```

Grouped BusinessFilter's by their meaning.

### getPricesCurrencies

```java
@NonNull
java.util.List<java.lang.String> getPricesCurrencies()
```

Relevant currency for the prices

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
