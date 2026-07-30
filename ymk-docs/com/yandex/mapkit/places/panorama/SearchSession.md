---
title: "SearchSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.places.panorama"
section: "Android / Справочник / com.yandex.mapkit.places.panorama / SearchSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SearchSession.html"
---
# SearchSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/places/panorama/SearchSession.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.places.panorama

`static interface SearchSession`

Session for receiving the result of the findNearest() method.

Should be stored until the listener is notified. Can be used to cancel the active request. Can be used to retry the last request (for example, if it failed).

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `retry(@NonNull SearchListener searchListener)`<br>Retries the last request. |
| `void` | `cancel()`<br>Cancels the active request. |

## Methods

### retry

```java
void retry(@NonNull SearchListener searchListener)
```

Retries the last request.

### cancel

```java
void cancel()
```

Cancels the active request.
