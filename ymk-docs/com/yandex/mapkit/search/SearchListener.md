---
title: "SearchListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SearchListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchListener.html"
---
# SearchListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SearchListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`static interface SearchListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onSearchResponse(@NonNull Response response)`<br>Callback for results processing. |
| `void` | `onSearchError(@NonNull Error error)`<br>Callback for error processing. |

## Methods

### onSearchResponse

```java
@UiThread
void onSearchResponse(@NonNull Response response)
```

Callback for results processing.

| Parameters |   |
| --- | --- |
| `response` | Response with search result. |

### onSearchError

```java
@UiThread
void onSearchError(@NonNull Error error)
```

Callback for error processing.

| Parameters |   |
| --- | --- |
| `error` | Error information. |
