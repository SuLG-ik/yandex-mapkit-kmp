---
title: "Search"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / Search"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Search.html"
---
# Search

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/Search.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface Search`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `SearchLayer` | `createSearchLayer(@NonNull MapWindow mapWindow)`<br>Gets the search_layer object. |
| `SearchManager` | `createSearchManager(@NonNull SearchManagerType searchManagerType)`<br>Creates a manager that allows to search for various geographical objects using a variety of parameters. |
| `boolean` | `isValid()`<br>Tells if this **Search** is valid or not. |

## Methods

### createSearchLayer

```java
@NonNull
SearchLayer createSearchLayer(@NonNull MapWindow mapWindow)
```

Gets the search_layer object.

### createSearchManager

```java
@NonNull
SearchManager createSearchManager(@NonNull SearchManagerType searchManagerType)
```

Creates a manager that allows to search for various geographical objects using a variety of parameters.

### isValid

```java
boolean isValid()
```

Tells if this **Search** is valid or not.

Any other method (except for this one) called on an invalid **Search** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
