---
title: "YMKMapWindow"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapWindow.html"
---
# YMKMapWindow

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapWindow.html)

```objectivec
@interface YMKMapWindow : NSObject
```

Handles the MapWindow element.

## Summary

### Instance methods

```objectivec
- (NSInteger)width;
```

Window width in physical pixels

```objectivec
- (NSInteger)height;
```

Window height in physical pixels

```objectivec
- (nullable YMKScreenPoint *)worldToScreenWithWorldPoint:
    (nonnull YMKPoint *)worldPoint;
```

Transforms the position from world coordinates to screen coordinates

```objectivec
- (nullable YMKPoint *)screenToWorldWithScreenPoint:
    (nonnull YMKScreenPoint *)screenPoint;
```

Transforms coordinates from screen space to world space

```objectivec
- (void)addSizeChangedListenerWithSizeChangedListener:
    (nonnull id<YMKMapSizeChangedListener>)sizeChangedListener;
```

Adds a SizeChangedListener

```objectivec
- (void)removeSizeChangedListenerWithSizeChangedListener:
    (nonnull id<YMKMapSizeChangedListener>)sizeChangedListener;
```

Removes a SizeChangedListener

```objectivec
- (void)setMaxFpsWithFps:(NSUInteger)fps;
```

Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable

```objectivec
- (void)addSurfaceWithSurface:(nonnull YRTSurface *)surface;
```

Adds additional surface to render frames on

```objectivec
- (void)removeSurfaceWithSurface:(nonnull YRTSurface *)surface;
```

Removes external surface

```objectivec
- (nonnull YMKOverlay *)addRasterScreenOverlay;
```

Adds raster screen overlay

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKMap *map;
```

Gets the map interface

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenRect *focusRect;
```

When using controls that overlay the map view, calculating the proper camera position can be tricky

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenPoint *focusPoint;
```

The point on the screen that corresponds to camera position

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenPoint *gestureFocusPoint;
```

Defines the focus point of gestures

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKGestureFocusPointMode gestureFocusPointMode;
```

Specifies the way provided gesture focus point affects gestures

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKPointOfView pointOfView;
```

Defines the position of the point of view

```objectivec
@property (nonatomic, readonly, nonnull) YMKVisibleRegion *focusRegion;
```

Gets the focused region

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### width

```objectivec
- (NSInteger)width;
```

Window width in physical pixels

### height

```objectivec
- (NSInteger)height;
```

Window height in physical pixels

### worldToScreenWithWorldPoint:

```objectivec
- (nullable YMKScreenPoint *)worldToScreenWithWorldPoint:
    (nonnull YMKPoint *)worldPoint;
```

Transforms the position from world coordinates to screen coordinates.

| Parameters |   |
| --- | --- |
| worldPoint | Latitude and longitude information. |

**Returns**

The point in screen space corresponding to worldPoint;

returns none if the point is behind the camera.

### screenToWorldWithScreenPoint:

```objectivec
- (nullable YMKPoint *)screenToWorldWithScreenPoint:
    (nonnull YMKScreenPoint *)screenPoint;
```

Transforms coordinates from screen space to world space.

| Parameters |   |
| --- | --- |
| screenPoint | The point in screen coordinates relative to the top left of the map. These coordinates are in physical pixels and not in device independent (virtual) pixels. |

**Returns**

Latitude and longitude information.

### addSizeChangedListenerWithSizeChangedListener:

```objectivec
- (void)addSizeChangedListenerWithSizeChangedListener:
    (nonnull id<YMKMapSizeChangedListener>)sizeChangedListener;
```

Adds a SizeChangedListener.

The class does not retain the object in the 'sizeChangedListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeSizeChangedListenerWithSizeChangedListener:

```objectivec
- (void)removeSizeChangedListenerWithSizeChangedListener:
    (nonnull id<YMKMapSizeChangedListener>)sizeChangedListener;
```

Removes a SizeChangedListener.

### setMaxFpsWithFps:

```objectivec
- (void)setMaxFpsWithFps:(NSUInteger)fps;
```

Allows to reduce CPU/GPU/battery usage in specific scenarios, where lower framerate is acceptable. Valid range: [0, ]. Default max fps depends on max display refresh rate. If `fps` == 0, max fps value is set to max display refresh rate.

### addSurfaceWithSurface:

```objectivec
- (void)addSurfaceWithSurface:(nonnull YRTSurface *)surface;
```

Adds additional surface to render frames on. A part of the frame with center in focusPoint will be sent to surface. Dimesions of this part are determined by dimensions of surface. If surface larger than map, the map will be scaled to fit the surface This method is android only

### removeSurfaceWithSurface:

```objectivec
- (void)removeSurfaceWithSurface:(nonnull YRTSurface *)surface;
```

Removes external surface. This method is android only

### addRasterScreenOverlay

```objectivec
- (nonnull YMKOverlay *)addRasterScreenOverlay;
```

Adds raster screen overlay.

## Properties

### map

```objectivec
@property (nonatomic, readonly, nonnull) YMKMap *map;
```

Gets the map interface.

### focusRect

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenRect *focusRect;
```

When using controls that overlay the map view, calculating the proper camera position can be tricky. This property simplifies the task by defining the area of interest (the focus rectangle) inside the view. Map methods that calculate the camera position based on a world bounding box ensure that this bounding box will fit into the focusRect.

For example, when using a semi-transparent control that overlays the top half of the map view, define the focus rectangle as the lower half of the view to ensure that object of interest appear in the lower half of map view. In addition, if focusPoint is null all camera movements will have the center of the lower half as their target.

If focusRect is null, the whole map view is used instead.

On iOS, if you change the focus rectangle in the viewDidLayoutSubviews callback, it's recommended to call MapView.layoutIfNeeded just before that action.

Optional property, can be nil.

### focusPoint

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenPoint *focusPoint;
```

The point on the screen that corresponds to camera position. Changing camera position or focusPoint makes the new camera target appear exactly at the focusPoint on screen.

If focusPoint is null, the center of focusRect is used instead.

Optional property, can be nil.

### gestureFocusPoint

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    YMKScreenPoint *gestureFocusPoint;
```

Defines the focus point of gestures. Actual behaviour depends on gestureFocusPointMode. If the point is not set, the source point of the gesture will be used as the focus point. Default: none.

Optional property, can be nil.

### gestureFocusPointMode

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKGestureFocusPointMode gestureFocusPointMode;
```

Specifies the way provided gesture focus point affects gestures. Default: TapGestures.

### pointOfView

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite)
    YMKPointOfView pointOfView;
```

Defines the position of the point of view. Cameras use perspective projection, which causes perspective deformations. Perspective projection has an axis, and points on this axis are not affected by perspective deformations. This axis is a line parallel to the view's direction, so its projection to the screen is a point - the "point of view". By default, this point is at the center of the screen, but some applications might want to set it to the center of focusRect. Use this flag to do so. Default: ScreenCenter

### focusRegion

```objectivec
@property (nonatomic, readonly, nonnull) YMKVisibleRegion *focusRegion;
```

Gets the focused region.

**Returns**

A region that corresponds to the current focusRect or the

visible region if focusRect is not set. Region IS bounded by latitude

limits [-90, 90] and IS NOT bounded by longitude limits [-180, 180].

If longitude exceeds its limits, we see the world's edge and another

instance of the world beyond this edge.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
