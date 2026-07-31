---
title: "MapLoadedListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapLoadedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadedListener.html"
---
# MapLoadedListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapLoadedListener.html)

**Package** com.yandex.mapkit.map

`interface MapLoadedListener`

Listener interface for when the map has finished loading.

This occurs after all tiles required to render the map have been fetched, and are ready to be rendered. This event will not fire if the map never loads due to connectivity issues, or if the map is continuously changing and never completes loading due to the user constantly interacting with the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMapLoaded(@NonNull MapLoadStatistics statistics)`<br>Called after the map has finished loading all visible tiles. |

## Methods

### onMapLoaded

```java
@UiThread
void onMapLoaded(@NonNull MapLoadStatistics statistics)
```

Called after the map has finished loading all visible tiles.

This will only be called once. You must set another listener if you want to be notified again.
