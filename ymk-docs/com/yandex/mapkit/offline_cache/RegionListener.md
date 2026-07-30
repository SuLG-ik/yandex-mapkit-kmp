---
title: "RegionListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.offline_cache"
section: "Android / Справочник / com.yandex.mapkit.offline_cache / RegionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionListener.html"
---
# RegionListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/offline_cache/RegionListener.html)

**Package** com.yandex.mapkit.offline_cache

`interface RegionListener`

Listener to handle region information.

> [!NOTE] Примечание
> This feature is not available in the free MapKit version.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onRegionStateChanged(int regionId)`<br>Region state was changed. |
| `void` | `onRegionProgress(int regionId)`<br>Progress of specific region download was updated. |

## Methods

### onRegionStateChanged

```java
@UiThread
void onRegionStateChanged(int regionId)
```

Region state was changed.

### onRegionProgress

```java
@UiThread
void onRegionProgress(int regionId)
```

Progress of specific region download was updated.
