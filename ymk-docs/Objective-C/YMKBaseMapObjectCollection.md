---
title: "YMKBaseMapObjectCollection"
kind: "Class"
platform: "ios"
language: "Objective-C"
section: "iOS / Справочник / Objective-C / Classes / YMKBaseMapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseMapObjectCollection.html"
---
# YMKBaseMapObjectCollection

`IOS` · `Objective-C` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Objective-C/YMKBaseMapObjectCollection.html)

```objectivec
@interface YMKBaseMapObjectCollection : YMKMapObject
```

## Summary

### Instance methods

```objectivec
- (void)traverseWithMapObjectVisitor:
    (nonnull id<YMKMapObjectVisitor>)mapObjectVisitor;
```

Traverses through the collection with a visitor object

```objectivec
- (void)removeWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Removes the given map object from the collection

```objectivec
- (void)clear;
```

Removes all map objects from the collection

```objectivec
- (void)addListenerWithCollectionListener:
    (nonnull id<YMKMapObjectCollectionListener>)collectionListener;
```

Adds a listener to track notifications of changes to the collection

```objectivec
- (void)removeListenerWithCollectionListener:
    (nonnull id<YMKMapObjectCollectionListener>)collectionListener;
```

Removes a listener

## Instance methods

### traverseWithMapObjectVisitor:

```objectivec
- (void)traverseWithMapObjectVisitor:
    (nonnull id<YMKMapObjectVisitor>)mapObjectVisitor;
```

Traverses through the collection with a visitor object. Used for iteration over map objects in the collection.

The class does not retain the object in the 'mapObjectVisitor' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeWithMapObject:

```objectivec
- (void)removeWithMapObject:(nonnull YMKMapObject *)mapObject;
```

Removes the given map object from the collection.

### clear

```objectivec
- (void)clear;
```

Removes all map objects from the collection.

### addListenerWithCollectionListener:

```objectivec
- (void)addListenerWithCollectionListener:
    (nonnull id<YMKMapObjectCollectionListener>)collectionListener;
```

Adds a listener to track notifications of changes to the collection.

The class does not retain the object in the 'collectionListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListenerWithCollectionListener:

```objectivec
- (void)removeListenerWithCollectionListener:
    (nonnull id<YMKMapObjectCollectionListener>)collectionListener;
```

Removes a listener.
