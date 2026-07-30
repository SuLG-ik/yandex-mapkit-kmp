---
title: "RegionsAtPointListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / RegionsAtPointListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionsAtPointListener.html"
---
# RegionsAtPointListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionsAtPointListener.html)

**Package** com.yandex.mapkit.offline_cache

`interface RegionsAtPointListener`

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onRegions(@NonNull java.util.List<java.lang.Integer> regions)` |
| `void` | `onError(@NonNull Error error)` |

## Methods

### onRegions

```java
@UiThread
void onRegions(@NonNull java.util.List<java.lang.Integer> regions)
```

### onError

```java
@UiThread
void onError(@NonNull Error error)
```
