---
title: "SearchOptions"
kind: "Class"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchOptions"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchOptions.html"
---
# SearchOptions

`ANDROID` · `Java` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchOptions.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

java.lang.Object
↳ com.yandex.mapkit.search.SearchOptions

`final class SearchOptions implements Serializable`

Struct to fine-tune search request.

## Summary

### Constructors

**Signature and Description**

```java
SearchOptions(int searchTypes,
              @Nullable java.lang.Integer resultPageSize,
              int snippets,
              @Nullable Point userPosition,
              @Nullable java.lang.String origin,
              boolean geometry,
              boolean disableSpellingCorrection,
              @Nullable FilterCollection filters)
```

```java
SearchOptions()
```

Use constructor with parameters in your code.

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `int` | `getSearchTypes()`<br>The search type can be one of the [mapkit.search.SearchType](SearchType.md) values or their bitwise 'OR' combination. |
| `SearchOptions` | `setSearchTypes(int searchTypes)`<br>See **#getSearchTypes()**. |
| `java.lang.Integer` | `getResultPageSize()`<br>Maximum number of search results per page. |
| `SearchOptions` | `setResultPageSize(@Nullable java.lang.Integer resultPageSize)`<br>See **#getResultPageSize()**. |
| `int` | `getSnippets()`<br>Snippets that will be requested. |
| `SearchOptions` | `setSnippets(int snippets)`<br>See **#getSnippets()**. |
| `Point` | `getUserPosition()`<br>The server uses the user position to calculate the distance from the user to search results. |
| `SearchOptions` | `setUserPosition(@Nullable Point userPosition)`<br>See **#getUserPosition()**. |
| `java.lang.String` | `getOrigin()`<br>String that sets an identifier for the request source. |
| `SearchOptions` | `setOrigin(@Nullable java.lang.String origin)`<br>See **#getOrigin()**. |
| `boolean` | `getGeometry()`<br>Adds the geometry to the server response. |
| `SearchOptions` | `setGeometry(boolean geometry)`<br>See **#getGeometry()**. |
| `boolean` | `getDisableSpellingCorrection()`<br>Force disable correction of spelling mistakes. |
| `SearchOptions` | `setDisableSpellingCorrection(boolean disableSpellingCorrection)`<br>See **#getDisableSpellingCorrection()**. |
| `FilterCollection` | `getFilters()`<br>Filter set that will be requested. |
| `SearchOptions` | `setFilters(@Nullable FilterCollection filters)`<br>See **#getFilters()**. |
| `void` | `serialize(com.yandex.runtime.bindings.Archive archive)` |

## Constuctors

### SearchOptions

```java
SearchOptions(int searchTypes,
              @Nullable java.lang.Integer resultPageSize,
              int snippets,
              @Nullable Point userPosition,
              @Nullable java.lang.String origin,
              boolean geometry,
              boolean disableSpellingCorrection,
              @Nullable FilterCollection filters)
```

### SearchOptions

```java
SearchOptions()
```

Use constructor with parameters in your code.

This one is for bindings only!

## Methods

### getSearchTypes

```java
int getSearchTypes()
```

The search type can be one of the [mapkit.search.SearchType](SearchType.md) values or their bitwise 'OR' combination.

If searchType is not initialized, it means to search in all the sources.

### setSearchTypes

```java
SearchOptions setSearchTypes(int searchTypes)
```

See **#getSearchTypes()**.

### getResultPageSize

```java
@Nullable
java.lang.Integer getResultPageSize()
```

Maximum number of search results per page.

Optional field, can be null.

### setResultPageSize

```java
SearchOptions setResultPageSize(@Nullable java.lang.Integer resultPageSize)
```

See **#getResultPageSize()**.

### getSnippets

```java
int getSnippets()
```

Snippets that will be requested.

The value should be one of [mapkit.search.Snippet](Snippet.md), or their bitwise 'OR' combination.

### setSnippets

```java
SearchOptions setSnippets(int snippets)
```

See **#getSnippets()**.

### getUserPosition

```java
@Nullable
Point getUserPosition()
```

The server uses the user position to calculate the distance from the user to search results.

Optional field, can be null.

### setUserPosition

```java
SearchOptions setUserPosition(@Nullable Point userPosition)
```

See **#getUserPosition()**.

### getOrigin

```java
@Nullable
java.lang.String getOrigin()
```

String that sets an identifier for the request source.

Optional field, can be null.

### setOrigin

```java
SearchOptions setOrigin(@Nullable java.lang.String origin)
```

See **#getOrigin()**.

### getGeometry

```java
boolean getGeometry()
```

Adds the geometry to the server response.

### setGeometry

```java
SearchOptions setGeometry(boolean geometry)
```

See **#getGeometry()**.

### getDisableSpellingCorrection

```java
boolean getDisableSpellingCorrection()
```

Force disable correction of spelling mistakes.

### setDisableSpellingCorrection

```java
SearchOptions setDisableSpellingCorrection(boolean disableSpellingCorrection)
```

See **#getDisableSpellingCorrection()**.

### getFilters

```java
@Nullable
FilterCollection getFilters()
```

Filter set that will be requested.

Please note that the full set of filters that can be applied can only be obtained after the primary request. If you pass an invalid filter to the primary request (for example, "pharmacy with swimming pool"), the behavior is undefined. That is the search can either ignore an invalid filter or return an empty response.

Optional field, can be null.

### setFilters

```java
SearchOptions setFilters(@Nullable FilterCollection filters)
```

See **#getFilters()**.

### serialize

```java
@Override
void serialize(com.yandex.runtime.bindings.Archive archive)
```
