---
title: "YMKGeoObjectCollection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeoObjectCollection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectCollection.html"
---
# YMKGeoObjectCollection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObjectCollection.html)

```swift
class YMKGeoObjectCollection : NSObject
```

A collection of geo objects. Allows you to group geo objects for adding them to the map, setting options, etc. Collections are geo objects too.

## Summary

### Class methods

```swift
 init(boundingBox: YMKBoundingBox?,
 metadataContainer: YRTTypeDictionary<any YMKBaseMetadata>,
         children: [YMKGeoObjectCollectionItem])
```

### Properties

```swift
var boundingBox: YMKBoundingBox? { get }
```

The bounds around the collection of objects

```swift
var metadataContainer: YRTTypeDictionary<any YMKBaseMetadata> { get }
```

The metadata for the objects

```swift
var children: [YMKGeoObjectCollectionItem] { get }
```

## Class methods

### init(boundingBox:metadataContainer:children:)

```swift
 init(boundingBox: YMKBoundingBox?,
 metadataContainer: YRTTypeDictionary<any YMKBaseMetadata>,
         children: [YMKGeoObjectCollectionItem])
```

## Properties

### boundingBox

```swift
var boundingBox: YMKBoundingBox? { get }
```

The bounds around the collection of objects.

Optional field, can be nil.

### metadataContainer

```swift
var metadataContainer: YRTTypeDictionary<any YMKBaseMetadata> { get }
```

The metadata for the objects.

### children

```swift
var children: [YMKGeoObjectCollectionItem] { get }
```
