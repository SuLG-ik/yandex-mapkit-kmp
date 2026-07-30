---
title: "YMKModelStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKModelStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModelStyle.html"
---
# YMKModelStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModelStyle.html)

```swift
class YMKModelStyle : NSObject
```

The style of the model.

## Summary

### Class methods

```swift
 init(scale: Float,
   unitType: YMKModelStyleUnitType,
 renderMode: YMKModelStyleRenderMode,
 variantName: String?)
```

### Instance methods

```swift
init()
```

### Properties

```swift
var scale: Float { get set }
```

Scale the model by this value

```swift
var unitType: YMKModelStyleUnitType { get set }
```

Unit type of the model

```swift
var renderMode: YMKModelStyleRenderMode { get set }
```

Defines should it be rendered with buildings from ground layer

```swift
var variantName: String? { get set }
```

Name of variant to render model with

## Class methods

### init(scale:unitType:renderMode:variantName:)

```swift
 init(scale: Float,
   unitType: YMKModelStyleUnitType,
 renderMode: YMKModelStyleRenderMode,
 variantName: String?)
```

## Instance methods

### init()

```swift
init()
```

## Properties

### scale

```swift
var scale: Float { get set }
```

Scale the model by this value.

### unitType

```swift
var unitType: YMKModelStyleUnitType { get set }
```

Unit type of the model.

### renderMode

```swift
var renderMode: YMKModelStyleRenderMode { get set }
```

Defines should it be rendered with buildings from ground layer.

### variantName

```swift
var variantName: String? { get set }
```

Name of variant to render model with. See KHR_materials_variants gltf extension. This works only for glTF models.

Optional field, can be nil.
