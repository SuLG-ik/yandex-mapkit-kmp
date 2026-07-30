---
title: "YMKCamera"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKCamera"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCamera.html"
---
# YMKCamera

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKCamera.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```objectivec
@interface YMKCamera : NSObject
```

Camera tracks location, user input and provide new CameraPosition for map.

## Summary

### Instance methods

```objectivec
- (void)addListenerWithCameraListener:
    (nonnull id<YMKCameraListener>)cameraListener;
```

The class does not retain the object in the 'cameraListener' parameter

```objectivec
- (void)removeListenerWithCameraListener:
    (nonnull id<YMKCameraListener>)cameraListener;
```

```objectivec
- (void)setAutoZoomWithEnabled:(BOOL)enabled
                     animation:(nullable YMKAnimation *)animation;
```

Set autozoom in 'Following' camera mode

```objectivec
- (void)setAutoRotationWithEnabled:(BOOL)enabled
                         animation:(nullable YMKAnimation *)animation;
```

Set autorotation in 'Following' camera mode

```objectivec
- (void)setFollowingModeZoomOffsetWithOffset:(float)offset
                                   animation:(nullable YMKAnimation *)animation;
```

Add `offset` value to zoom in following mode

```objectivec
- (void)setOverviewRectWithRect:(nullable YMKScreenRect *)rect
                      animation:(nullable YMKAnimation *)animation;
```

Defines area, where all routes should be shown in 'Overview' mode

```objectivec
- (void)setExtraOverviewPointsWithPoints:(nullable NSArray<YMKPoint *> *)points;
```

Given points will be visible when camera switches to 'Overview' mode

```objectivec
- (YMKCameraMode)cameraMode;
```

```objectivec
- (void)setCameraModeWithMode:(YMKCameraMode)mode
                    animation:(nullable YMKAnimation *)animation;
```

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isSwitchModesAutomatically) BOOL switchModesAutomatically;
```

If enabled, camera will automatically switch between modes: <ul><li>Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### addListenerWithCameraListener:

```objectivec
- (void)addListenerWithCameraListener:
    (nonnull id<YMKCameraListener>)cameraListener;
```

The class does not retain the object in the 'cameraListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithCameraListener:

```objectivec
- (void)removeListenerWithCameraListener:
    (nonnull id<YMKCameraListener>)cameraListener;
```

### setAutoZoomWithEnabled:animation:

```objectivec
- (void)setAutoZoomWithEnabled:(BOOL)enabled
                     animation:(nullable YMKAnimation *)animation;
```

Set autozoom in 'Following' camera mode. `animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setAutoRotationWithEnabled:animation:

```objectivec
- (void)setAutoRotationWithEnabled:(BOOL)enabled
                         animation:(nullable YMKAnimation *)animation;
```

Set autorotation in 'Following' camera mode. If disabled, the map will be rotated so that the north is on top. `animation` parameter ignored if camera currently not in the 'Following' mode. Enabled by default.

### setFollowingModeZoomOffsetWithOffset:animation:

```objectivec
- (void)setFollowingModeZoomOffsetWithOffset:(float)offset
                                   animation:(nullable YMKAnimation *)animation;
```

Add `offset` value to zoom in following mode. 0.0 by default.

### setOverviewRectWithRect:animation:

```objectivec
- (void)setOverviewRectWithRect:(nullable YMKScreenRect *)rect
                      animation:(nullable YMKAnimation *)animation;
```

Defines area, where all routes should be shown in 'Overview' mode. If `overviewRect` is null, mapWindow.focusRect used.

### setExtraOverviewPointsWithPoints:

```objectivec
- (void)setExtraOverviewPointsWithPoints:(nullable NSArray<YMKPoint *> *)points;
```

Given points will be visible when camera switches to 'Overview' mode. It is useful when you draw some extra info on the map out of routes.

### cameraMode

```objectivec
- (YMKCameraMode)cameraMode;
```

### setCameraModeWithMode:animation:

```objectivec
- (void)setCameraModeWithMode:(YMKCameraMode)mode
                    animation:(nullable YMKAnimation *)animation;
```

## Properties

### switchModesAutomatically

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isSwitchModesAutomatically) BOOL switchModesAutomatically;
```

If enabled, camera will automatically switch between modes:

- Camera will become into 'Following' mode if current route in navigation selected or current speed is greater than: 10 km/h for auto and 5 km/h for pedestrian navigations.
- Camera will become into 'Following' mode from 'Overview' mode on guidance start.
- Camera will become into 'Overview' when routes requested, but current route does not selected yet.
- Camera will become into 'Free' mode from 'Following' mode on any external move (gesture / call `map.move`)
- Camera will become into 'Following' mode from 'Free' mode if requirements from (1) satisfied and there are no any camera moving activity for 10 seconds

Camera will become into 'Indoor' mode from 'Following'/'Free' modes during active pedestrian guidance when user enters at indoor Enabled by default.

Enabled by default.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
