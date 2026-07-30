---
title: "Session"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.transport.bicycle"
section: "Android / Справочник / com.yandex.mapkit.transport.bicycle / Session"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Session.html"
---
# Session

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/transport/bicycle/Session.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

**Package** com.yandex.mapkit.transport.bicycle

`interface Session`

Handler for an async request for bicycle routes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `cancel()`<br>Tries to cancel the current request for bicycle routes. |
| `void` | `retry(@NonNull RouteListener routeListener)`<br>Retries the request for bicycle routes using the specified callback. |

## Methods

### cancel

```java
void cancel()
```

Tries to cancel the current request for bicycle routes.

### retry

```java
void retry(@NonNull RouteListener routeListener)
```

Retries the request for bicycle routes using the specified callback.
