---
title: "YMKMapObjectTapListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapObjectTapListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectTapListener.html"
---
# YMKMapObjectTapListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectTapListener.html)

```objectivec
@protocol YMKMapObjectTapListener <NSObject>
```

If an event is not handled by the source object then it's propagated to its parent. This listener can be attached to any MapObject including MapObjectCollection.

## Summary

### Instance methods

```objectivec
- (BOOL)onMapObjectTapWithMapObject:(nonnull YMKMapObject *)mapObject
                              point:(nonnull YMKPoint *)point;
```

Returns true if the event was handled

## Instance methods

### onMapObjectTapWithMapObject:point:

```objectivec
- (BOOL)onMapObjectTapWithMapObject:(nonnull YMKMapObject *)mapObject
                              point:(nonnull YMKPoint *)point;
```

Returns true if the event was handled. The event will not be propagated to the parent. Returns false if the event wasn't handled. The event will be propagated to the parent.
