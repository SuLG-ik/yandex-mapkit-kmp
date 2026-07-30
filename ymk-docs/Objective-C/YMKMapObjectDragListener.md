---
title: "YMKMapObjectDragListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapObjectDragListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectDragListener.html"
---
# YMKMapObjectDragListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectDragListener.html)

```objectivec
@protocol YMKMapObjectDragListener <NSObject>
```

This listener is notified when a map object is being dragged. Note that the map object's "draggable" property needs to be set to True in order to activate dragging. A long tap on a map object activates dragging mode.

## Summary

### Instance methods

```objectivec
- (void)onMapObjectDragStartWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Raised when dragging mode is active for the given map object

```objectivec
- (void)onMapObjectDragWithMapObject:(nonnull YMKMapObject *)mapObject
                               point:(nonnull YMKPoint *)point;
```

Raised when the user is moving a finger and the map object follows it

```objectivec
- (void)onMapObjectDragEndWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Raised when the user released the tap

## Instance methods

### onMapObjectDragStartWithMapObject:

```objectivec
- (void)onMapObjectDragStartWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Raised when dragging mode is active for the given map object.

### onMapObjectDragWithMapObject:point:

```objectivec
- (void)onMapObjectDragWithMapObject:(nonnull YMKMapObject *)mapObject
                               point:(nonnull YMKPoint *)point;
```

Raised when the user is moving a finger and the map object follows it.

### onMapObjectDragEndWithMapObject:

```objectivec
- (void)onMapObjectDragEndWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Raised when the user released the tap.
