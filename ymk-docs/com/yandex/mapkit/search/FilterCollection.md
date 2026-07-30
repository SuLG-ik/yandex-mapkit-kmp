---
title: "FilterCollection"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / FilterCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection.html"
---
# FilterCollection

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/FilterCollection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.FilterCollection

`class FilterCollection implements Serializable`

Filters for search request.

Use builder to setup this class.

## Nested Class Summary

| Modifier and Type | Interface | Description |
| --- | --- | --- |
| `static` | [NumberRange](FilterCollection_NumberRange.md) | Number range.<br>Used for range filter. |
| `static` | [DateRange](FilterCollection_DateRange.md) | Date range.<br>Dates are encoded as strings in YYYYMMDD format. |

## Summary

### Constructors

**Signature and Description**

```java
FilterCollection()
```

Use constructor with parameters in your code.

```java
FilterCollection(@NonNull java.util.List<java.lang.String> booleanFilters,
                 @NonNull java.util.Map<java.lang.String, java.util.List<java.lang.String>> enumFilters,
                 @NonNull java.util.Map<java.lang.String, NumberRange> rangeFilters,
                 @NonNull java.util.Map<java.lang.String, DateRange> dateFilters)
```

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `synchronized java.util.List<java.lang.String>` | `getBooleanFilters()`<br>List of boolean filter ids to be set. |
| `synchronized java.util.Map<java.lang.String, java.util.List<java.lang.String>>` | `getEnumFilters()`<br>Mapping of enum filter ids to list of enum value ids. |
| `synchronized java.util.Map<java.lang.String, NumberRange>` | `getRangeFilters()`<br>Mapping of range filter ids to number range. |
| `synchronized java.util.Map<java.lang.String, DateRange>` | `getDateFilters()`<br>Mapping of date filter ids to date range. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |
| `static java.lang.String` | `getNativeName()` |

## Constuctors

### FilterCollection

```java
FilterCollection()
```

Use constructor with parameters in your code.

This one is for serialization only!

### FilterCollection

```java
FilterCollection(@NonNull java.util.List<java.lang.String> booleanFilters,
                 @NonNull java.util.Map<java.lang.String, java.util.List<java.lang.String>> enumFilters,
                 @NonNull java.util.Map<java.lang.String, NumberRange> rangeFilters,
                 @NonNull java.util.Map<java.lang.String, DateRange> dateFilters)
```

## Methods

### getBooleanFilters

```java
@NonNull
java.util.List<java.lang.String> getBooleanFilters()
```

List of boolean filter ids to be set.

### getEnumFilters

```java
@NonNull
java.util.Map<java.lang.String, java.util.List<java.lang.String>> getEnumFilters()
```

Mapping of enum filter ids to list of enum value ids.

### getRangeFilters

```java
@NonNull
java.util.Map<java.lang.String, NumberRange> getRangeFilters()
```

Mapping of range filter ids to number range.

### getDateFilters

```java
@NonNull
java.util.Map<java.lang.String, DateRange> getDateFilters()
```

Mapping of date filter ids to date range.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```

### getNativeName

```java
java.lang.String getNativeName()
```
