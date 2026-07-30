---
title: "OffscreenMapWindow"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / OffscreenMapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/OffscreenMapWindow.html"
---
# OffscreenMapWindow

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/OffscreenMapWindow.html)

**Package** com.yandex.mapkit.map

`interface OffscreenMapWindow`

Wraps [mapkit.map.MapWindow](MapWindow.md) without its own view to render.

Allows to render map on additional surfaces in separate processes without having to create MapView control in the main process.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `MapWindow` | `getMapWindow()` |
| `android.graphics.Bitmap` | `captureScreenshot()` |

## Methods

### getMapWindow

```java
@NonNull
MapWindow getMapWindow()
```

### captureScreenshot

```java
@NonNull
android.graphics.Bitmap captureScreenshot()
```
