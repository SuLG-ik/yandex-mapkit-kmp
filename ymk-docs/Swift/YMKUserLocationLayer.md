---
title: "YMKUserLocationLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKUserLocationLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationLayer.html"
---
# YMKUserLocationLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKUserLocationLayer.html)

```swift
class YMKUserLocationLayer : NSObject
```

Use the UserLocationLayer interface to manage the location icon: its appearance, following mode, data source and so on.

## Summary

### Instance methods

```swift
func setVisibleWithOn(_ on: Bool)
```

Sets user location visibility

```swift
func isVisible() -> Bool
```

Checks if user location is visible

```swift
func setAnchorWithAnchorNormal(_ anchorNormal: CGPoint, anchorCourse: CGPoint)
```

Sets the anchor to the specified position in pixels and enables Anchor mode

```swift
func resetAnchor()
```

Resets anchor mode

```swift
func cameraPosition() -> YMKCameraPosition?
```

Calculates the camera position that projects the current location into view

```swift
func setSourceWith(_ source: YMKLocationViewSource?)
```

Sets/gets the data source

```swift
func setDefaultSource()
```

Sets the data source with the global location manager

```swift
func setTapListenerWith(_ tapListener: (any YMKUserLocationTapListener)?)
```

Sets/resets the tap listener

```swift
func setObjectListenerWith(_ objectListener: (any YMKUserLocationObjectListener)?)
```

Sets/resets the object listener

### Properties

```swift
var isHeadingModeActive: Bool { get set }
```

Enables/disables heading mode

```swift
var isAnchorEnabled: Bool { get }
```

Returns true if anchor mode is set, and false otherwise

```swift
var isAutoZoomEnabled: Bool { get set }
```

Enables/disables auto zoom

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setVisibleWithOn(_:)

```swift
func setVisibleWithOn(_ on: Bool)
```

Sets user location visibility.

### isVisible()

```swift
func isVisible() -> Bool
```

Checks if user location is visible.

### setAnchorWithAnchorNormal(_:anchorCourse:)

```swift
func setAnchorWithAnchorNormal(_ anchorNormal: CGPoint, anchorCourse: CGPoint)
```

Sets the anchor to the specified position in pixels and enables Anchor mode. (0, 0) denotes the top-left corner of the screen.

| Parameters |   |
| --- | --- |
| anchorNormal | The anchor position when the app is not on a steady course; usually, the center of the screen. |
| anchorCourse | An anchor position near the bottom line for steady course mode. |

### resetAnchor()

```swift
func resetAnchor()
```

Resets anchor mode.

### cameraPosition()

```swift
func cameraPosition() -> YMKCameraPosition?
```

Calculates the camera position that projects the current location into view. If the current location is unknown, returns none. If the current location is known, returns the camera position that displays the location position.

### setSourceWith(_:)

```swift
func setSourceWith(_ source: YMKLocationViewSource?)
```

Sets/gets the data source.

### setDefaultSource()

```swift
func setDefaultSource()
```

Sets the data source with the global location manager

### setTapListenerWith(_:)

```swift
func setTapListenerWith(_ tapListener: (any YMKUserLocationTapListener)?)
```

Sets/resets the tap listener.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### setObjectListenerWith(_:)

```swift
func setObjectListenerWith(_ objectListener: (any YMKUserLocationObjectListener)?)
```

Sets/resets the object listener.

The class does not retain the object in the 'objectListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### isHeadingModeActive

```swift
var isHeadingModeActive: Bool { get set }
```

Enables/disables heading mode. If heading mode is enabled, the map is rotated. If heading mode is disabled, the location icon is rotated.

### isAnchorEnabled

```swift
var isAnchorEnabled: Bool { get }
```

Returns true if anchor mode is set, and false otherwise.

### isAutoZoomEnabled

```swift
var isAutoZoomEnabled: Bool { get set }
```

Enables/disables auto zoom.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
