---
title: "PathSetterListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / PathSetterListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/PathSetterListener.html"
---
# PathSetterListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/PathSetterListener.html)

**Package** com.yandex.mapkit.offline_cache

`static interface PathSetterListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onPathSet()`<br>New cache path was set. |
| `void` | `onPathSetError(@NonNull Error error)`<br>Error occurred. |

## Methods

### onPathSet

```java
@UiThread
void onPathSet()
```

New cache path was set.

### onPathSetError

```java
@UiThread
void onPathSetError(@NonNull Error error)
```

Error occurred.

Cache path wasn't change Expected error types: 1. [mapkit.offline_cache.CachePathUnavailable](CachePathUnavailable.md): target path doesn't exist or there no read permissions
