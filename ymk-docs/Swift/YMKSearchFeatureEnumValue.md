---
title: "YMKSearchFeatureEnumValue"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKSearchFeatureEnumValue"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeatureEnumValue.html"
---
# YMKSearchFeatureEnumValue

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKSearchFeatureEnumValue.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKSearchFeatureEnumValue : NSObject
```

Value for enumerated features.

## Summary

### Class methods

```swift
 init(id: String, name: String, imageUrlTemplate: String?, tags: [String])
```

### Properties

```swift
var id: String { get }
```

Machine readable value identifier

```swift
var name: String { get }
```

Human readable localized representation

```swift
var imageUrlTemplate: String? { get }
```

urlTemplate for the image

```swift
var tags: [String] { get }
```

## Class methods

### init(id:name:imageUrlTemplate:tags:)

```swift
 init(id: String, name: String, imageUrlTemplate: String?, tags: [String])
```

## Properties

### id

```swift
var id: String { get }
```

Machine readable value identifier.

### name

```swift
var name: String { get }
```

Human readable localized representation.

### imageUrlTemplate

```swift
var imageUrlTemplate: String? { get }
```

urlTemplate for the image. Available sizes are listed here: http://api.yandex.ru/fotki/doc/format-ref/f-img.xml

Optional field, can be nil.

### tags

```swift
var tags: [String] { get }
```
