---
title: "YMKMapObjectCollectionListener"
kind: "Protocol"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Protocols / YMKMapObjectCollectionListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectCollectionListener.html"
---
# YMKMapObjectCollectionListener

`IOS` · `Objective-C` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKMapObjectCollectionListener.html)

```objectivec
@protocol YMKMapObjectCollectionListener <NSObject>
```

The map object collection can't be modified in callbacks. A runtime::RuntimeError exception is thrown if this happens.

## Summary

### Instance methods

```objectivec
- (void)onMapObjectAddedWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Called every time a new map object is added to the collection

```objectivec
- (void)onMapObjectRemovedWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Called every time a map object is removed from the collection

## Instance methods

### onMapObjectAddedWithMapObject:

```objectivec
- (void)onMapObjectAddedWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Called every time a new map object is added to the collection.

### onMapObjectRemovedWithMapObject:

```objectivec
- (void)onMapObjectRemovedWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Called every time a map object is removed from the collection.
