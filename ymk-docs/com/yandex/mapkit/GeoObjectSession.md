---
title: "GeoObjectSession"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit"
section: "Android / Справочник / com.yandex.mapkit / GeoObjectSession"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectSession.html"
---
# GeoObjectSession

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/GeoObjectSession.html)

**Package** com.yandex.mapkit

`interface GeoObjectSession`

The interface for working with the session.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Cancels the current request. |
| `void` | `retry(@NonNull GeoObjectListener objListener)`<br>Retries the last request. |

## Methods

### cancel

```java
void cancel()
```

Cancels the current request.

### retry

```java
void retry(@NonNull GeoObjectListener objListener)
```

Retries the last request.

Cancels the current request if it is active.
