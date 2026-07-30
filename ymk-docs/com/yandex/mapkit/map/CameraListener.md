---
title: "CameraListener"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / CameraListener"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraListener.html"
---
# CameraListener

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/CameraListener.html)

**Package** com.yandex.mapkit.map

`interface CameraListener`

Listens for updates to the camera position.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `onCameraPositionChanged(@NonNull Map map, @NonNull CameraPosition cameraPosition, @NonNull CameraUpdateReason cameraUpdateReason, boolean finished)`<br>Triggered when the camera position changed. |

## Methods

### onCameraPositionChanged

```java
@UiThread
void onCameraPositionChanged(@NonNull Map map,
                             @NonNull CameraPosition cameraPosition,
                             @NonNull CameraUpdateReason cameraUpdateReason,
                             boolean finished)
```

Triggered when the camera position changed.

| Parameters |   |
| --- | --- |
| `map` | Event source. |
| `cameraPosition` | Current camera position. |
| `cameraUpdateReason` | The reason of camera update. |
| `finished` | True if the camera finished moving, false otherwise. If a movement is cancelled then cameraUpdateReason represents initiator of cancellation. |
