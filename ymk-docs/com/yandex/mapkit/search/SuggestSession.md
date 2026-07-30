---
title: "SuggestSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.search"
section: "Android / Справочник / com.yandex.mapkit.search / SuggestSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestSession.html"
---
# SuggestSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/search/SuggestSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.search

`interface SuggestSession`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `suggest(@NonNull java.lang.String text, @NonNull BoundingBox window, @NonNull SuggestOptions suggestOptions, @NonNull SuggestListener suggestListener)`<br>Begin a suggest request. |
| `void` | `reset()`<br>Cancels current suggest request and resets internal state. |

## Methods

### suggest

```java
void suggest(@NonNull java.lang.String text,
             @NonNull BoundingBox window,
             @NonNull SuggestOptions suggestOptions,
             @NonNull SuggestListener suggestListener)
```

Begin a suggest request.

The current request is cancelled, if present.

| Parameters |   |
| --- | --- |
| `text` | Text to get suggestions for. |
| `window` | Current map window position. |
| `suggestOptions` | Various additional suggest parameters. See the [mapkit.search.SuggestOptions](SuggestOptions.md) definition for details. |
| `suggestListener` | Function called when the result is ready. |

### reset

```java
void reset()
```

Cancels current suggest request and resets internal state.

Next queries via this suggest session will be seen as a new suggest session from backend point of view.
