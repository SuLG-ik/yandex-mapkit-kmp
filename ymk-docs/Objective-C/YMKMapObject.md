---
title: "YMKMapObject"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObject.html"
---
# YMKMapObject

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObject.html)

```objectivec
@interface YMKMapObject : NSObject
```

An object displayed on the map.

## Summary

### Instance methods

```objectivec
- (void)setVisibleWithVisible:(BOOL)visible
                    animation:(nonnull YMKAnimation *)animation;
```

Manages visibility of the object

```objectivec
- (void)setVisibleWithVisible:(BOOL)visible
                    animation:(nonnull YMKAnimation *)animation
                     callback:(nullable YMKCallback)callback;
```

Manages visibility of the object

```objectivec
- (void)addTapListenerWithTapListener:
    (nonnull id<YMKMapObjectTapListener>)tapListener;
```

Adds a tap listener to the object

```objectivec
- (void)removeTapListenerWithTapListener:
    (nonnull id<YMKMapObjectTapListener>)tapListener;
```

Removes the tap listener from the object

```objectivec
- (void)setDragListenerWithDragListener:
    (nullable id<YMKMapObjectDragListener>)dragListener;
```

Sets a drag listener for the object

### Properties

```objectivec
@property (nonatomic, readonly, nonnull) YMKBaseMapObjectCollection *parent;
```

Returns the collection of map objects that the current map object belongs to

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Manages visibility of the object on the map

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float zIndex;
```

Gets the z-index, which affects: <ul><li>Rendering order

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isDraggable)
    BOOL draggable;
```

If true, the map object can be dragged by the user

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    id userData;
```

Use this property to attach any object-related metadata

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no

## Instance methods

### setVisibleWithVisible:animation:

```objectivec
- (void)setVisibleWithVisible:(BOOL)visible
                    animation:(nonnull YMKAnimation *)animation;
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| animation | Describes the transition between visible and not visible states. |
| onFinished | Called when the transition is finished. |

### setVisibleWithVisible:animation:callback:

```objectivec
- (void)setVisibleWithVisible:(BOOL)visible
                    animation:(nonnull YMKAnimation *)animation
                     callback:(nullable YMKCallback)callback;
```

Manages visibility of the object.

| Parameters |   |
| --- | --- |
| animation | Describes the transition between visible and not visible states. |
| onFinished | Called when the transition is finished. |

### addTapListenerWithTapListener:

```objectivec
- (void)addTapListenerWithTapListener:
    (nonnull id<YMKMapObjectTapListener>)tapListener;
```

Adds a tap listener to the object.

The class does not retain the object in the 'tapListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTapListenerWithTapListener:

```objectivec
- (void)removeTapListenerWithTapListener:
    (nonnull id<YMKMapObjectTapListener>)tapListener;
```

Removes the tap listener from the object.

### setDragListenerWithDragListener:

```objectivec
- (void)setDragListenerWithDragListener:
    (nullable id<YMKMapObjectDragListener>)dragListener;
```

Sets a drag listener for the object. Each object can only have one drag listener.

The class does not retain the object in the 'dragListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

## Properties

### parent

```objectivec
@property (nonatomic, readonly, nonnull) YMKBaseMapObjectCollection *parent;
```

Returns the collection of map objects that the current map object belongs to.

### visible

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isVisible)
    BOOL visible;
```

Manages visibility of the object on the map. Default: true.

### zIndex

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite) float zIndex;
```

Gets the z-index, which affects:

- Rendering order.
- Dispatching of UI events (taps and drags are dispatched to objects with higher z-indexes first).

Z-index is relative to the parent.

### draggable

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, getter=isDraggable)
    BOOL draggable;
```

If true, the map object can be dragged by the user. Default: false.

### userData

```objectivec
@property (nonatomic, assign, unsafe_unretained, readwrite, nullable)
    id userData;
```

Use this property to attach any object-related metadata.

Optional property, can be nil.

### valid

```objectivec
@property (nonatomic, readonly, getter=isValid) BOOL valid;
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
