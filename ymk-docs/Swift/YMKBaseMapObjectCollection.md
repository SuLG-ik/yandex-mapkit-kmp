---
title: "YMKBaseMapObjectCollection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBaseMapObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseMapObjectCollection.html"
---
# YMKBaseMapObjectCollection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBaseMapObjectCollection.html)

```swift
class YMKBaseMapObjectCollection : YMKMapObject
```

## Summary

### Instance methods

```swift
func traverse(with mapObjectVisitor: any YMKMapObjectVisitor)
```

Traverses through the collection with a visitor object

```swift
func remove(with mapObject: YMKMapObject)
```

Removes the given map object from the collection

```swift
func clear()
```

Removes all map objects from the collection

```swift
func addListener(with collectionListener: any YMKMapObjectCollectionListener)
```

Adds a listener to track notifications of changes to the collection

```swift
func removeListener(with collectionListener: any YMKMapObjectCollectionListener)
```

Removes a listener

## Instance methods

### traverse(with:)

```swift
func traverse(with mapObjectVisitor: any YMKMapObjectVisitor)
```

Traverses through the collection with a visitor object. Used for iteration over map objects in the collection.

The class does not retain the object in the 'mapObjectVisitor' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### remove(with:)

```swift
func remove(with mapObject: YMKMapObject)
```

Removes the given map object from the collection.

### clear()

```swift
func clear()
```

Removes all map objects from the collection.

### addListener(with:)

```swift
func addListener(with collectionListener: any YMKMapObjectCollectionListener)
```

Adds a listener to track notifications of changes to the collection.

The class does not retain the object in the 'collectionListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeListener(with:)

```swift
func removeListener(with collectionListener: any YMKMapObjectCollectionListener)
```

Removes a listener.
