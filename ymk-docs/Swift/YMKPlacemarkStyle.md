---
title: "YMKPlacemarkStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlacemarkStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkStyle.html"
---
# YMKPlacemarkStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKPlacemarkStyle : NSObject
```

## Summary

### Instance methods

```swift
func setArrowModel()
```

Set the placemark to be an 3D arrow

```swift
func setGltfModelWithModel(_ model: any YRTDataProviderWithId,
                        modelStyle: YMKModelStyle)
```

The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated

```swift
func setImageWith(_ image: UIImage)
```

```swift
func setAnimatedImageWithIconImage(_ iconImage: any YRTAnimatedImageProvider)
```

```swift
func setIconAnchorWithIconAnchor(_ iconAnchor: CGPoint)
```

Icon anchor, (0, 0) is top left and (1

```swift
func setScaleFunctionWithPoints(_ points: [NSValue])
```

Piecewise linear scale function

```swift
func setMinZoomVisibleWithMinZoom(_ minZoom: NSNumber?)
```

Minimal zoom for placemark to be visible

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setArrowModel()

```swift
func setArrowModel()
```

Set the placemark to be an 3D arrow. Usable only for user position placemark.

### setGltfModelWithModel(_:modelStyle:)

```swift
func setGltfModelWithModel(_ model: any YRTDataProviderWithId,
                        modelStyle: YMKModelStyle)
```

The class maintains a strong reference to the object in the 'model' parameter until it (the class) is invalidated.

### setImageWith(_:)

```swift
func setImageWith(_ image: UIImage)
```

### setAnimatedImageWithIconImage(_:)

```swift
func setAnimatedImageWithIconImage(_ iconImage: any YRTAnimatedImageProvider)
```

### setIconAnchorWithIconAnchor(_:)

```swift
func setIconAnchorWithIconAnchor(_ iconAnchor: CGPoint)
```

Icon anchor, (0, 0) is top left and (1.0, 1.0) is bottom right.

### setScaleFunctionWithPoints(_:)

```swift
func setScaleFunctionWithPoints(_ points: [NSValue])
```

Piecewise linear scale function. See Placemark's scale function.

### setMinZoomVisibleWithMinZoom(_:)

```swift
func setMinZoomVisibleWithMinZoom(_ minZoom: NSNumber?)
```

Minimal zoom for placemark to be visible.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
