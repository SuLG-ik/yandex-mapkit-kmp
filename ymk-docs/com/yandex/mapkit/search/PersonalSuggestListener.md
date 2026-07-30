---
title: "PersonalSuggestListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / PersonalSuggestListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PersonalSuggestListener.html"
---
# PersonalSuggestListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/PersonalSuggestListener.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`static interface PersonalSuggestListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPersonalSuggestSuccess()`<br>Callback for result processing. |
| `void` | `onPersonalSuggestError(@NonNull Error error)`<br>Callback for error processing. |

## Methods

### onPersonalSuggestSuccess

```java
@UiThread
void onPersonalSuggestSuccess()
```

Callback for result processing.

### onPersonalSuggestError

```java
@UiThread
void onPersonalSuggestError(@NonNull Error error)
```

Callback for error processing.

| Parameters |   |
| --- | --- |
| `error` | Error information. |
