---
title: "MapWindow"
kind: "Interface"
platform: "android"
language: "Java"
package: "com.yandex.mapkit.map"
section: "Android / Справочник / com.yandex.mapkit.map / MapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapWindow.html"
---
# MapWindow

`ANDROID` · `Java` · `Interface` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/com/yandex/mapkit/map/MapWindow.html)

**Package** com.yandex.mapkit.map

`interface MapWindow`

Handles the MapWindow element.

## Summary

### Methods

| Type and modifiers | Method and Description |
| --- | --- |
| `Map` | `getMap()`<br>Gets the map interface. |
| `int` | `width()`<br>Window width in physical pixels |
| `int` | `height()`<br>Window height in physical pixels |
| `ScreenPoint` | `worldToScreen(@NonNull Point worldPoint)`<br>Transforms the position from world coordinates to screen coordinates. |
| `Point` | `screenToWorld(@NonNull ScreenPoint screenPoint)`<br>Transforms coordinates from screen space to world space. |
| `ScreenRect` | `getFocusRect()`<br>When using controls that overlay the map view, calculating the proper camera position can be tricky. |
| `void` | `setFocusRect(@Nullable ScreenRect focusRect)` |
| `ScreenPoint` | `getFocusPoint()`<br>The point on the screen that corresponds to camera position. |
| `void` | `setFocusPoint(@Nullable ScreenPoint focusPoint)` |
| `ScreenPoint` | `getGestureFocusPoint()`<br>Defines the focus point of gestures. |
| `void` | `setGestureFocusPoint(@Nullable ScreenPoint gestureFocusPoint)` |
| `GestureFocusPointMode` | `getGestureFocusPointMode()`<br>Specifies the way provided gesture focus point affects gestures. |
| `void` | `setGestureFocusPointMode(@NonNull GestureFocusPointMode gestureFocusPointMode)` |
| `PointOfView` | `getPointOfView()`<br>Defines the position of the point of view. |
| `void` | `setPointOfView(@NonNull PointOfView pointOfView)` |
| `VisibleRegion` | `getFocusRegion()`<br>Gets the focused region. |
| `void` | `addSizeChangedListener(@NonNull java.lang.ref.WeakReference<SizeChangedListener> sizeChangedListener)`<br>Adds a SizeChangedListener. |
| `void` | `removeSizeChangedListener(@NonNull java.lang.ref.WeakReference<SizeChangedListener> sizeChangedListener)`<br>Removes a SizeChangedListener. |
| `void` | `setScaleFactor(float scaleFactor)` |
| `void` | `setMaxFps(int fps)`<br>Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable. |
| `void` | `addSurface(@NonNull Surface surface)`<br>Adds additional surface to render frames on. |
| `void` | `removeSurface(@NonNull Surface surface)`<br>Removes external surface. |
| `Overlay` | `addRasterScreenOverlay()`<br>Adds raster screen overlay. |
| `boolean` | `isValid()`<br>Tells if this **MapWindow** is valid or not. |

## Methods

### getMap

```java
@NonNull
Map getMap()
```

Gets the map interface.

### width

```java
int width()
```

Window width in physical pixels

### height

```java
int height()
```

Window height in physical pixels

### worldToScreen

```java
@Nullable
ScreenPoint worldToScreen(@NonNull Point worldPoint)
```

Transforms the position from world coordinates to screen coordinates.

| Parameters |   |
| --- | --- |
| `worldPoint` | Latitude and longitude information. |

**Returns**

The point in screen space corresponding to worldPoint; returns none if the point is behind the camera.

### screenToWorld

```java
@Nullable
Point screenToWorld(@NonNull ScreenPoint screenPoint)
```

Transforms coordinates from screen space to world space.

| Parameters |   |
| --- | --- |
| `screenPoint` | The point in screen coordinates relative to the top left of the map. These coordinates are in physical pixels and not in device independent (virtual) pixels. |

**Returns**

Latitude and longitude information.

### getFocusRect

```java
@Nullable
ScreenRect getFocusRect()
```

When using controls that overlay the map view, calculating the proper camera position can be tricky.

This property simplifies the task by defining the area of interest (the focus rectangle) inside the view. Map methods that calculate the camera position based on a world bounding box ensure that this bounding box will fit into the focusRect.

For example, when using a semi-transparent control that overlays the top half of the map view, define the focus rectangle as the lower half of the view to ensure that object of interest appear in the lower half of map view. In addition, if focusPoint is null all camera movements will have the center of the lower half as their target.

If focusRect is null, the whole map view is used instead.

On iOS, if you change the focus rectangle in the viewDidLayoutSubviews callback, it's recommended to call MapView.layoutIfNeeded just before that action.

Optional property, can be null.

### setFocusRect

```java
void setFocusRect(@Nullable ScreenRect focusRect)
```

### getFocusPoint

```java
@Nullable
ScreenPoint getFocusPoint()
```

The point on the screen that corresponds to camera position.

Changing camera position or focusPoint makes the new camera target appear exactly at the focusPoint on screen.

If focusPoint is null, the center of focusRect is used instead.

Optional property, can be null.

### setFocusPoint

```java
void setFocusPoint(@Nullable ScreenPoint focusPoint)
```

### getGestureFocusPoint

```java
@Nullable
ScreenPoint getGestureFocusPoint()
```

Defines the focus point of gestures.

Actual behaviour depends on gestureFocusPointMode. If the point is not set, the source point of the gesture will be used as the focus point. Default: none.

Optional property, can be null.

### setGestureFocusPoint

```java
void setGestureFocusPoint(@Nullable ScreenPoint gestureFocusPoint)
```

### getGestureFocusPointMode

```java
@NonNull
GestureFocusPointMode getGestureFocusPointMode()
```

Specifies the way provided gesture focus point affects gestures.

Default: TapGestures.

### setGestureFocusPointMode

```java
void setGestureFocusPointMode(@NonNull GestureFocusPointMode gestureFocusPointMode)
```

### getPointOfView

```java
@NonNull
PointOfView getPointOfView()
```

Defines the position of the point of view.

Cameras use perspective projection, which causes perspective deformations. Perspective projection has an axis, and points on this axis are not affected by perspective deformations. This axis is a line parallel to the view's direction, so its projection to the screen is a point - the "point of view". By default, this point is at the center of the screen, but some applications might want to set it to the center of focusRect. Use this flag to do so. Default: ScreenCenter

### setPointOfView

```java
void setPointOfView(@NonNull PointOfView pointOfView)
```

### getFocusRegion

```java
@NonNull
VisibleRegion getFocusRegion()
```

Gets the focused region.

**Returns**

A region that corresponds to the current focusRect or the visible region if focusRect is not set. Region IS bounded by latitude limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180]. If longitude exceeds its limits, we see the world's edge and another instance of the world beyond this edge.

### addSizeChangedListener

```java
void addSizeChangedListener(@NonNull java.lang.ref.WeakReference<SizeChangedListener> sizeChangedListener)
```

Adds a SizeChangedListener.

The class does not retain the object in the 'sizeChangedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeSizeChangedListener

```java
void removeSizeChangedListener(@NonNull java.lang.ref.WeakReference<SizeChangedListener> sizeChangedListener)
```

Removes a SizeChangedListener.

### setScaleFactor

```java
void setScaleFactor(float scaleFactor)
```

### setMaxFps

```java
void setMaxFps(int fps)
```

Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable.

Valid range: [0, ]. Default max fps depends on max display refresh rate. If `fps` == 0, max fps value is set to max display refresh rate.

### addSurface

```java
void addSurface(@NonNull Surface surface)
```

Adds additional surface to render frames on.

A part of the frame with center in focusPoint will be sent to surface. Dimesions of this part are determined by dimensions of surface. If surface larger than map, the map will be scaled to fit the surface This method is android only

### removeSurface

```java
void removeSurface(@NonNull Surface surface)
```

Removes external surface.

This method is android only

### addRasterScreenOverlay

```java
@NonNull
Overlay addRasterScreenOverlay()
```

Adds raster screen overlay.

### isValid

```java
boolean isValid()
```

Tells if this **MapWindow** is valid or not.

Any other method (except for this one) called on an invalid **MapWindow** will throw **java.lang.RuntimeException**. An instance becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
