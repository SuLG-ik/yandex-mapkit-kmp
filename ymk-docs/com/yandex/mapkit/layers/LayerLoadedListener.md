---
title: "LayerLoadedListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.layers"
section: "Android / Справочник / com.yandex.mapkit.layers / LayerLoadedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/LayerLoadedListener.html"
---
# LayerLoadedListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/layers/LayerLoadedListener.html)

**Package** com.yandex.mapkit.layers

`interface LayerLoadedListener`

Allows user to be notified when the layer has finished loading.

This occurs after all tiles required to render the layer have been fetched, and are ready to be rendered. This event will not fire if the layer never loads due to connectivity issues, or if the layer is continuously changing and never completes loading due to the user constantly interacting with the map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onLayerLoaded()`<br>Called after the layer has finished loading all visible tiles. |

## Methods

### onLayerLoaded

```java
@UiThread
void onLayerLoaded()
```

Called after the layer has finished loading all visible tiles.

This will only be called once. You must set another listener if you want to be notified again.
