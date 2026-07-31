---
title: "YMKUserLocationLayer"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKUserLocationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationLayer.html"
---
# YMKUserLocationLayer

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKUserLocationLayer.html)

```objectivec
@interface YMKUserLocationLayer : NSObject
```

Use the UserLocationLayer interface to manage the location icon: its appearance, following mode, data source and so on.

## Summary

### Instance methods

```objectivec
- (void)setVisibleWithOn:(BOOL)on;
```

Sets user location visibility

```objectivec
- (BOOL)isVisible;
```

Checks if user location is visible

```objectivec
- (void)setAnchorWithAnchorNormal:(CGPoint)anchorNormal
                     anchorCourse:(CGPoint)anchorCourse;
```

Sets the anchor to the specified position in pixels and enables Anchor mode

```objectivec
- (void)resetAnchor;
```

Resets anchor mode

```objectivec
- (nullable YMKCameraPosition *)cameraPosition;
```

Calculates the camera position that projects the current location into view

```objectivec
- (void)setSourceWithSource:(nullable YMKLocationViewSource *)source;
```

Sets/gets the data source

```objectivec
- (void)setDefaultSource;
```

Sets the data source with the global location manager

```objectivec
- (void)setTapListenerWithTapListener:
    (nullable id<YMKUserLocationTapListener>)tapListener;
```

Sets/resets the tap listener

```objectivec
- (void)setObjectListenerWithObjectListener:
    (nullable id<YMKUserLocationObjectListener>)objectListener;
```

Sets/resets the object listener

### Properties

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isHeadingModeActive) BOOL headingModeActive;
```

Enables/disables heading mode

```objectivec
@property (nonatomic, readonly, getter=isAnchorEnabled) BOOL anchorEnabled;
```

Returns true if anchor mode is set, and false otherwise

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isAutoZoomEnabled) BOOL autoZoomEnabled;
```

Enables/disables auto zoom

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setVisibleWithOn:

```objectivec
- (void)setVisibleWithOn:(BOOL)on;
```

Sets user location visibility.

### isVisible

```objectivec
- (BOOL)isVisible;
```

Checks if user location is visible.

### setAnchorWithAnchorNormal:anchorCourse:

```objectivec
- (void)setAnchorWithAnchorNormal:(CGPoint)anchorNormal
                     anchorCourse:(CGPoint)anchorCourse;
```

Sets the anchor to the specified position in pixels and enables Anchor mode. (0, 0) denotes the top-left corner of the screen.

| Parameters |   |
| --- | --- |
| anchorNormal | The anchor position when the app is not on a steady course; usually, the center of the screen. |
| anchorCourse | An anchor position near the bottom line for steady course mode. |

### resetAnchor

```objectivec
- (void)resetAnchor;
```

Resets anchor mode.

### cameraPosition

```objectivec
- (nullable YMKCameraPosition *)cameraPosition;
```

Calculates the camera position that projects the current location into view. If the current location is unknown, returns none. If the current location is known, returns the camera position that displays the location position.

### setSourceWithSource:

```objectivec
- (void)setSourceWithSource:(nullable YMKLocationViewSource *)source;
```

Sets/gets the data source.

### setDefaultSource

```objectivec
- (void)setDefaultSource;
```

Sets the data source with the global location manager

### setTapListenerWithTapListener:

```objectivec
- (void)setTapListenerWithTapListener:
    (nullable id<YMKUserLocationTapListener>)tapListener;
```

Sets/resets the tap listener.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setObjectListenerWithObjectListener:

```objectivec
- (void)setObjectListenerWithObjectListener:
    (nullable id<YMKUserLocationObjectListener>)objectListener;
```

Sets/resets the object listener.

The class does not retain the object in the 'objectListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### headingModeActive

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isHeadingModeActive) BOOL headingModeActive;
```

Enables/disables heading mode. If heading mode is enabled, the map is rotated. If heading mode is disabled, the location icon is rotated.

### anchorEnabled

```objectivec
@property (nonatomic, readonly, getter=isAnchorEnabled) BOOL anchorEnabled;
```

Returns true if anchor mode is set, and false otherwise.

### autoZoomEnabled

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite,
          getter=isAutoZoomEnabled) BOOL autoZoomEnabled;
```

Enables/disables auto zoom.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
