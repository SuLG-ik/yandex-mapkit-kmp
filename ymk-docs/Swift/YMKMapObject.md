---
title: "YMKMapObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObject.html"
---
# YMKMapObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapObject.html)

```swift
class YMKMapObject : NSObject
```

An object displayed on the map.

## Summary

### Instance methods

```swift
func setVisibleWithVisible(_ visible: Bool, animation: YMKAnimation)
```

Manages visibility of the object

```swift
func setVisibleWithVisible(_ visible: Bool,
                           animation: YMKAnimation,
                            callback: YMKCallback? = nil)
```

Manages visibility of the object

```swift
func addTapListener(with tapListener: any YMKMapObjectTapListener)
```

Adds a tap listener to the object

```swift
func removeTapListener(with tapListener: any YMKMapObjectTapListener)
```

Removes the tap listener from the object

```swift
func setDragListenerWith(_ dragListener: (any YMKMapObjectDragListener)?)
```

Sets a drag listener for the object

### Properties

```swift
var parent: YMKBaseMapObjectCollection { get }
```

Returns the collection of map objects that the current map object belongs to

```swift
var isVisible: Bool { get set }
```

Manages visibility of the object on the map

```swift
var zIndex: Float { get set }
```

Gets the z-index, which affects: <ul><li>Rendering order

```swift
var isDraggable: Bool { get set }
```

If true, the map object can be dragged by the user

```swift
var userData: Any? { get set }
```

Use this property to attach any object-related metadata

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setVisibleWithVisible(_:animation:)

```swift
func setVisibleWithVisible(_ visible: Bool, animation: YMKAnimation)
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| animation | Describes the transition between visible and not visible states. |
| onFinished | Called when the transition is finished. |

### setVisibleWithVisible(_:animation:callback:)

```swift
func setVisibleWithVisible(_ visible: Bool,
                           animation: YMKAnimation,
                            callback: YMKCallback? = nil)
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| animation | Describes the transition between visible and not visible states. |
| onFinished | Called when the transition is finished. |

### addTapListener(with:)

```swift
func addTapListener(with tapListener: any YMKMapObjectTapListener)
```

Adds a tap listener to the object.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListener(with:)

```swift
func removeTapListener(with tapListener: any YMKMapObjectTapListener)
```

Removes the tap listener from the object.

### setDragListenerWith(_:)

```swift
func setDragListenerWith(_ dragListener: (any YMKMapObjectDragListener)?)
```

Sets a drag listener for the object. Each object can only have one drag listener.

The class does not retain the object in the 'dragListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### parent

```swift
var parent: YMKBaseMapObjectCollection { get }
```

Returns the collection of map objects that the current map object belongs to.

### isVisible

```swift
var isVisible: Bool { get set }
```

Manages visibility of the object on the map. Default: true.

### zIndex

```swift
var zIndex: Float { get set }
```

Gets the z-index, which affects:

- Rendering order.
- Dispatching of UI events (taps and drags are dispatched to objects with higher z-indexes first).

Z-index is relative to the parent.

### isDraggable

```swift
var isDraggable: Bool { get set }
```

If true, the map object can be dragged by the user. Default: false.

### userData

```swift
var userData: Any? { get set }
```

Use this property to attach any object-related metadata.

Optional property, can be nil.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
