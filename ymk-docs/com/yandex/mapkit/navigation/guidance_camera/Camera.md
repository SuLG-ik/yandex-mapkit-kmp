---
title: "Camera"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.navigation.guidance_camera"
section: "Android / Справочник / com.yandex.mapkit.navigation.guidance_camera / Camera"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/guidance_camera/Camera.html"
---
# Camera

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/navigation/guidance_camera/Camera.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

**Package** com.yandex.mapkit.navigation.guidance_camera

`interface Camera`

Camera tracks location, user input and provide new CameraPosition for map.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `void` | `addListener(@NonNull CameraListener cameraListener)`<br>The class does not retain the object in the 'cameraListener' parameter. |
| `void` | `removeListener(@NonNull CameraListener cameraListener)` |
| `void` | `setAutoZoom(boolean enabled, @Nullable Animation animation)`<br>Set autozoom in 'Following' camera mode. |
| `void` | `setAutoRotation(boolean enabled, @Nullable Animation animation)`<br>Set autorotation in 'Following' camera mode. |
| `void` | `setFollowingModeZoomOffset(float offset, @Nullable Animation animation)`<br>Add `offset` value to zoom in following mode. |
| `boolean` | `isSwitchModesAutomatically()`<br>If enabled, camera will automatically switch between modes:<br>- Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations.<br>- Camera will become into 'Following' mode from 'Overview' mode on guidance start.<br>- Camera will become into 'Overview' when routes requested, but current route does not selected yet.<br>- Camera will become into 'Free' mode from 'Following' mode on any external move (gesture / call `map.move`)<br>- Camera will become into 'Following' mode from 'Free' mode if requirements from (1) satisfied and there are no any camera moving activity for 10 seconds<br>Camera will become into 'Indoor' mode from 'Following'/'Free' modes during active pedestrian guidance when user enters at indoor<br>Enabled by default. \| |
| `void` | `setSwitchModesAutomatically(boolean switchModesAutomatically)` |
| `void` | `setOverviewRect(@Nullable ScreenRect rect, @Nullable Animation animation)`<br>Defines area, where all routes should be shown in 'Overview' mode. |
| `void` | `setExtraOverviewPoints(@Nullable java.util.List<Point> points)`<br>Given points will be visible when camera switches to 'Overview' mode. |
| `CameraMode` | `cameraMode()` |
| `void` | `setCameraMode(@NonNull CameraMode mode, @Nullable Animation animation)` |
| `boolean` | `isValid()`<br>Tells if this **Camera** is valid or not. |

## Methods

### addListener

```java
void addListener(@NonNull CameraListener cameraListener)
```

The class does not retain the object in the 'cameraListener' parameter.

It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener

```java
void removeListener(@NonNull CameraListener cameraListener)
```

### setAutoZoom

```java
void setAutoZoom(boolean enabled,
                 @Nullable Animation animation)
```

Set autozoom in 'Following' camera mode.

`animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setAutoRotation

```java
void setAutoRotation(boolean enabled,
                     @Nullable Animation animation)
```

Set autorotation in 'Following' camera mode.

If disabled, the map will be rotated so that the north is on top. `animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setFollowingModeZoomOffset

```java
void setFollowingModeZoomOffset(float offset,
                                @Nullable Animation animation)
```

Add `offset` value to zoom in following mode.

0.0 by default.

### isSwitchModesAutomatically

```java
boolean isSwitchModesAutomatically()
```

If enabled, camera will automatically switch between modes:

- Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations.
- Camera will become into 'Following' mode from 'Overview' mode on guidance start.
- Camera will become into 'Overview' when routes requested, but current route does not selected yet.
- Camera will become into 'Free' mode from 'Following' mode on any external move (gesture / call `map.move`)
- Camera will become into 'Following' mode from 'Free' mode if requirements from (1) satisfied and there are no any camera moving activity for 10 seconds

Camera will become into 'Indoor' mode from 'Following'/'Free' modes during active pedestrian guidance when user enters at indoor Enabled by default.

Enabled by default.

### setSwitchModesAutomatically

```java
void setSwitchModesAutomatically(boolean switchModesAutomatically)
```

### setOverviewRect

```java
void setOverviewRect(@Nullable ScreenRect rect,
                     @Nullable Animation animation)
```

Defines area, where all routes should be shown in 'Overview' mode.

If `overviewRect` is null, mapWindow.focusRect used.

### setExtraOverviewPoints

```java
void setExtraOverviewPoints(@Nullable java.util.List<Point> points)
```

Given points will be visible when camera switches to 'Overview' mode.

It is useful when you draw some extra info on the map out of routes.

### cameraMode

```java
@NonNull
CameraMode cameraMode()
```

### setCameraMode

```java
void setCameraMode(@NonNull CameraMode mode,
                   @Nullable Animation animation)
```

### isValid

```java
boolean isValid()
```

Tells if this **Camera** is valid or not.

Any other method (except for this one) called on an invalid **Camera** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
