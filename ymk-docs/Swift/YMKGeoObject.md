---
title: "YMKGeoObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKGeoObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObject.html"
---
# YMKGeoObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKGeoObject.html)

```swift
class YMKGeoObject : NSObject
```

Geo object. Can be displayed as a placemark, polyline, polygon, and other, depending on the geometry type.

## Summary

### Class methods

```swift
 init(name: String?,
 descriptionText: String?,
  geometry: [YMKGeometry],
 boundingBox: YMKBoundingBox?,
 attributionMap: [String : YMKAttribution],
 metadataContainer: YRTTypeDictionary<any YMKBaseMetadata>,
      aref: [String])
```

### Properties

```swift
var name: String? { get }
```

Object name

```swift
var descriptionText: String? { get }
```

The description of the object

```swift
var geometry: [YMKGeometry] { get }
```

The object's geometry

```swift
var boundingBox: YMKBoundingBox? { get }
```

A rectangular box around the object

```swift
var attributionMap: [String : YMKAttribution] { get }
```

The attribution of information to a specific author

```swift
var metadataContainer: YRTTypeDictionary<any YMKBaseMetadata> { get }
```

The object's metadata

```swift
var aref: [String] { get }
```

The name of the internet resource

## Class methods

### init(name:descriptionText:geometry:boundingBox:attributionMap:metadataContainer:aref:)

```swift
 init(name: String?,
 descriptionText: String?,
  geometry: [YMKGeometry],
 boundingBox: YMKBoundingBox?,
 attributionMap: [String : YMKAttribution],
 metadataContainer: YRTTypeDictionary<any YMKBaseMetadata>,
      aref: [String])
```

## Properties

### name

```swift
var name: String? { get }
```

Object name.

Optional field, can be nil.

### descriptionText

```swift
var descriptionText: String? { get }
```

The description of the object.

Optional field, can be nil.

### geometry

```swift
var geometry: [YMKGeometry] { get }
```

The object's geometry.

### boundingBox

```swift
var boundingBox: YMKBoundingBox? { get }
```

A rectangular box around the object.

Optional field, can be nil.

### attributionMap

```swift
var attributionMap: [String : YMKAttribution] { get }
```

The attribution of information to a specific author.

### metadataContainer

```swift
var metadataContainer: YRTTypeDictionary<any YMKBaseMetadata> { get }
```

The object's metadata.

### aref

```swift
var aref: [String] { get }
```

The name of the internet resource.
