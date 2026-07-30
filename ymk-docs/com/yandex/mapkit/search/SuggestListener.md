---
title: "SuggestListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestListener.html"
---
# SuggestListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`static interface SuggestListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onResponse(@NonNull SuggestResponse suggest)`<br>Callback for results processing. |
| `void` | `onError(@NonNull Error error)`<br>Callback for error processing. |

## Methods

### onResponse

```java
@UiThread
void onResponse(@NonNull SuggestResponse suggest)
```

Callback for results processing.

| Parameters |   |
| --- | --- |
| `suggest` | List of suggest results. |

### onError

```java
@UiThread
void onError(@NonNull Error error)
```

Callback for error processing.

| Parameters |   |
| --- | --- |
| `error` | Error information. |
