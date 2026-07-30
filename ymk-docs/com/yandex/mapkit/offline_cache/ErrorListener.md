---
title: "ErrorListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / ErrorListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/ErrorListener.html"
---
# ErrorListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/ErrorListener.html)

**Package** com.yandex.mapkit.offline_cache

`static interface ErrorListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onError(@NonNull Error error)` |
| `void` | `onRegionError(@NonNull Error error, int regionId)` |

## Methods

### onError

```java
@UiThread
void onError(@NonNull Error error)
```

| Parameters |   |
| --- | --- |
| `error` | Error has occurred in offline cache manager. Expected error types: 1. [runtime.network.RemoteError](../../runtime/network/RemoteError.md) 2. [runtime.LocalError](../../runtime/LocalError.md) |

### onRegionError

```java
@UiThread
void onRegionError(@NonNull Error error,
                   int regionId)
```

| Parameters |   |
| --- | --- |
| `error` | Error has occurred in specific region. Expected error types: 1. [runtime.network.RemoteError](../../runtime/network/RemoteError.md) 2. [runtime.LocalError](../../runtime/LocalError.md) |
