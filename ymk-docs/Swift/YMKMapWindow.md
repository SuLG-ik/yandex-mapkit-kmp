---
title: "YMKMapWindow"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapWindow.html"
---
# YMKMapWindow

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapWindow.html)

```swift
class YMKMapWindow : NSObject
```

Handles the MapWindow element.

## Summary

### Instance methods

```swift
func width() -> Int
```

Window width in physical pixels

```swift
func height() -> Int
```

Window height in physical pixels

```swift
func worldToScreen(withWorldPoint worldPoint: YMKPoint) -> YMKScreenPoint?
```

Transforms the position from world coordinates to screen coordinates

```swift
func screenToWorld(with screenPoint: YMKScreenPoint) -> YMKPoint?
```

Transforms coordinates from screen space to world space

```swift
func addSizeChangedListener(with sizeChangedListener: any YMKMapSizeChangedListener)
```

Adds a SizeChangedListener

```swift
func removeSizeChangedListener(with sizeChangedListener: any YMKMapSizeChangedListener)
```

Removes a SizeChangedListener

```swift
func setMaxFpsWithFps(_ fps: UInt)
```

Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable

```swift
func addSurface(with surface: YRTSurface)
```

Adds additional surface to render frames on

```swift
func removeSurface(with surface: YRTSurface)
```

Removes external surface

```swift
func addRasterScreenOverlay() -> YMKOverlay
```

Adds raster screen overlay

### Properties

```swift
var map: YMKMap { get }
```

Gets the map interface

```swift
var focusRect: YMKScreenRect? { get set }
```

When using controls that overlay the map view, calculating the proper camera position can be tricky

```swift
var focusPoint: YMKScreenPoint? { get set }
```

The point on the screen that corresponds to camera position

```swift
var gestureFocusPoint: YMKScreenPoint? { get set }
```

Defines the focus point of gestures

```swift
var gestureFocusPointMode: YMKGestureFocusPointMode { get set }
```

Specifies the way provided gesture focus point affects gestures

```swift
var pointOfView: YMKPointOfView { get set }
```

Defines the position of the point of view

```swift
var focusRegion: YMKVisibleRegion { get }
```

Gets the focused region

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### width()

```swift
func width() -> Int
```

Window width in physical pixels

### height()

```swift
func height() -> Int
```

Window height in physical pixels

### worldToScreen(withWorldPoint:)

```swift
func worldToScreen(withWorldPoint worldPoint: YMKPoint) -> YMKScreenPoint?
```

Transforms the position from world coordinates to screen coordinates.

| Parameters |   |
| --- | --- |
| worldPoint | Latitude and longitude information. |

**Returns**

The point in screen space corresponding to worldPoint;

returns none if the point is behind the camera.

### screenToWorld(with:)

```swift
func screenToWorld(with screenPoint: YMKScreenPoint) -> YMKPoint?
```

Transforms coordinates from screen space to world space.

| Parameters |   |
| --- | --- |
| screenPoint | The point in screen coordinates relative to the top left of the map. These coordinates are in physical pixels and not in device independent (virtual) pixels. |

**Returns**

Latitude and longitude information.

### addSizeChangedListener(with:)

```swift
func addSizeChangedListener(with sizeChangedListener: any YMKMapSizeChangedListener)
```

Adds a SizeChangedListener.

The class does not retain the object in the 'sizeChangedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeSizeChangedListener(with:)

```swift
func removeSizeChangedListener(with sizeChangedListener: any YMKMapSizeChangedListener)
```

Removes a SizeChangedListener.

### setMaxFpsWithFps(_:)

```swift
func setMaxFpsWithFps(_ fps: UInt)
```

Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable. Valid range: [0, ]. Default max fps depends on max display refresh rate. If `fps` == 0, max fps value is set to max display refresh rate.

### addSurface(with:)

```swift
func addSurface(with surface: YRTSurface)
```

Adds additional surface to render frames on. A part of the frame with center in focusPoint will be sent to surface. Dimesions of this part are determined by dimensions of surface. If surface larger than map, the map will be scaled to fit the surface This method is android only

### removeSurface(with:)

```swift
func removeSurface(with surface: YRTSurface)
```

Removes external surface. This method is android only

### addRasterScreenOverlay()

```swift
func addRasterScreenOverlay() -> YMKOverlay
```

Adds raster screen overlay.

## Properties

### map

```swift
var map: YMKMap { get }
```

Gets the map interface.

### focusRect

```swift
var focusRect: YMKScreenRect? { get set }
```

When using controls that overlay the map view, calculating the proper camera position can be tricky. This property simplifies the task by defining the area of interest (the focus rectangle) inside the view. Map methods that calculate the camera position based on a world bounding box ensure that this bounding box will fit into the focusRect.

For example, when using a semi-transparent control that overlays the top half of the map view, define the focus rectangle as the lower half of the view to ensure that object of interest appear in the lower half of map view. In addition, if focusPoint is null all camera movements will have the center of the lower half as their target.

If focusRect is null, the whole map view is used instead.

On iOS, if you change the focus rectangle in the viewDidLayoutSubviews callback, it's recommended to call MapView.layoutIfNeeded just before that action.

Optional property, can be nil.

### focusPoint

```swift
var focusPoint: YMKScreenPoint? { get set }
```

The point on the screen that corresponds to camera position. Changing camera position or focusPoint makes the new camera target appear exactly at the focusPoint on screen.

If focusPoint is null, the center of focusRect is used instead.

Optional property, can be nil.

### gestureFocusPoint

```swift
var gestureFocusPoint: YMKScreenPoint? { get set }
```

Defines the focus point of gestures. Actual behaviour depends on gestureFocusPointMode. If the point is not set, the source point of the gesture will be used as the focus point. Default: none.

Optional property, can be nil.

### gestureFocusPointMode

```swift
var gestureFocusPointMode: YMKGestureFocusPointMode { get set }
```

Specifies the way provided gesture focus point affects gestures. Default: TapGestures.

### pointOfView

```swift
var pointOfView: YMKPointOfView { get set }
```

Defines the position of the point of view. Cameras use perspective projection, which causes perspective deformations. Perspective projection has an axis, and points on this axis are not affected by perspective deformations. This axis is a line parallel to the view's direction, so its projection to the screen is a point - the "point of view". By default, this point is at the center of the screen, but some applications might want to set it to the center of focusRect. Use this flag to do so. Default: ScreenCenter

### focusRegion

```swift
var focusRegion: YMKVisibleRegion { get }
```

Gets the focused region.

**Returns**

A region that corresponds to the current focusRect or the

visible region if focusRect is not set. Region IS bounded by latitude

limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180].

If longitude exceeds its limits, we see the world's edge and another

instance of the world beyond this edge.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
