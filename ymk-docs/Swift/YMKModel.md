---
title: "YMKModel"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKModel"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModel.html"
---
# YMKModel

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKModel.html)

```swift
class YMKModel : YMKPlacemarkPresentation
```

describes model presentation of PlacemarkMapObject

## Summary

### Instance methods

```swift
func setDataWithGltfDataProvider(_ gltfDataProvider: any YRTDataProviderWithId)
```

Sets glTF data provider

```swift
func setDataWithGltfDataProvider(_ gltfDataProvider: any YRTDataProviderWithId,
                                           callback: YMKCallback? = nil)
```

Sets glTF data provider

### Properties

```swift
var modelStyle: YMKModelStyle { get set }
```

The style properties (scale, unitType, etc

## Instance methods

### setDataWithGltfDataProvider(_:)

```swift
func setDataWithGltfDataProvider(_ gltfDataProvider: any YRTDataProviderWithId)
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| onFinished | Called when the model is loaded. |

### setDataWithGltfDataProvider(_:callback:)

```swift
func setDataWithGltfDataProvider(_ gltfDataProvider: any YRTDataProviderWithId,
                                           callback: YMKCallback? = nil)
```

Sets glTF data provider.

The class maintains a strong reference to the object in the 'gltfDataProvider' parameter until it (the class) is invalidated.

| Parameters |   |
| --- | --- |
| onFinished | Called when the model is loaded. |

## Properties

### modelStyle

```swift
var modelStyle: YMKModelStyle { get set }
```

The style properties (scale, unitType, etc.) of the model placemark. Note: The current style cannot be modified directly - you must reset it to apply changes.
