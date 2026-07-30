---
title: "YMKCamera"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCamera"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCamera.html"
---
# YMKCamera

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCamera.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKCamera : NSObject
```

Camera tracks location, user input and provide new CameraPosition for map.

## Summary

### Instance methods

```swift
func addListener(with cameraListener: any YMKCameraListener)
```

The class does not retain the object in the 'cameraListener' parameter

```swift
func removeListener(with cameraListener: any YMKCameraListener)
```

```swift
func setAutoZoomWithEnabled(_ enabled: Bool, animation: YMKAnimation?)
```

Set autozoom in 'Following' camera mode

```swift
func setAutoRotationWithEnabled(_ enabled: Bool, animation: YMKAnimation?)
```

Set autorotation in 'Following' camera mode

```swift
func setFollowingModeZoomOffsetWithOffset(_ offset: Float,
                                         animation: YMKAnimation?)
```

Add `offset` value to zoom in following mode

```swift
func setOverviewRectWith(_ rect: YMKScreenRect?, animation: YMKAnimation?)
```

Defines area, where all routes should be shown in 'Overview' mode

```swift
func setExtraOverviewPointsWith(_ points: [YMKPoint]?)
```

Given points will be visible when camera switches to 'Overview' mode

```swift
func cameraMode() -> YMKCameraMode
```

```swift
func setCameraModeWith(_ mode: YMKCameraMode, animation: YMKAnimation?)
```

### Properties

```swift
var isSwitchModesAutomatically: Bool { get set }
```

If enabled, camera will automatically switch between modes: <ul><li>Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### addListener(with:)

```swift
func addListener(with cameraListener: any YMKCameraListener)
```

The class does not retain the object in the 'cameraListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with cameraListener: any YMKCameraListener)
```

### setAutoZoomWithEnabled(_:animation:)

```swift
func setAutoZoomWithEnabled(_ enabled: Bool, animation: YMKAnimation?)
```

Set autozoom in 'Following' camera mode. `animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setAutoRotationWithEnabled(_:animation:)

```swift
func setAutoRotationWithEnabled(_ enabled: Bool, animation: YMKAnimation?)
```

Set autorotation in 'Following' camera mode. If disabled, the map will be rotated so that the north is on top. `animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setFollowingModeZoomOffsetWithOffset(_:animation:)

```swift
func setFollowingModeZoomOffsetWithOffset(_ offset: Float,
                                         animation: YMKAnimation?)
```

Add `offset` value to zoom in following mode. 0.0 by default.

### setOverviewRectWith(_:animation:)

```swift
func setOverviewRectWith(_ rect: YMKScreenRect?, animation: YMKAnimation?)
```

Defines area, where all routes should be shown in 'Overview' mode. If `overviewRect` is null, mapWindow.focusRect used.

### setExtraOverviewPointsWith(_:)

```swift
func setExtraOverviewPointsWith(_ points: [YMKPoint]?)
```

Given points will be visible when camera switches to 'Overview' mode. It is useful when you draw some extra info on the map out of routes.

### cameraMode()

```swift
func cameraMode() -> YMKCameraMode
```

### setCameraModeWith(_:animation:)

```swift
func setCameraModeWith(_ mode: YMKCameraMode, animation: YMKAnimation?)
```

## Properties

### isSwitchModesAutomatically

```swift
var isSwitchModesAutomatically: Bool { get set }
```

If enabled, camera will automatically switch between modes:

- Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations.
- Camera will become into 'Following' mode from 'Overview' mode on guidance start.
- Camera will become into 'Overview' when routes requested, but current route does not selected yet.
- Camera will become into 'Free' mode from 'Following' mode on any external move (gesture / call `map.move`)
- Camera will become into 'Following' mode from 'Free' mode if requirements from (1) satisfied and there are no any camera moving activity for 10 seconds

Camera will become into 'Indoor' mode from 'Following'/'Free' modes during active pedestrian guidance when user enters at indoor Enabled by default.

Enabled by default.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
