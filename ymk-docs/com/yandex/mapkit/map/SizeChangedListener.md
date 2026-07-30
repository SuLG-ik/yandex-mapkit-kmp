---
title: "SizeChangedListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / SizeChangedListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/SizeChangedListener.html"
---
# SizeChangedListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/SizeChangedListener.html)

**Package** com.yandex.mapkit.map

`interface SizeChangedListener`

Listener for MapWindow size changes.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onMapWindowSizeChanged(@NonNull MapWindow mapWindow, int newWidth, int newHeight)`<br>Called when MapWindow handles the platform SizeChanged event. |

## Methods

### onMapWindowSizeChanged

```java
@UiThread
void onMapWindowSizeChanged(@NonNull MapWindow mapWindow,
                            int newWidth,
                            int newHeight)
```

Called when MapWindow handles the platform SizeChanged event.

param@ absolute Screen coordinates.
