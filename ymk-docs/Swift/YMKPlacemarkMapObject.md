---
title: "YMKPlacemarkMapObject"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlacemarkMapObject"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkMapObject.html"
---
# YMKPlacemarkMapObject

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkMapObject.html)

```swift
class YMKPlacemarkMapObject : YMKMapObject
```

Represents a geo-positioned object on the map.

## Summary

### Instance methods

```swift
func setIconWith(_ image: UIImage)
```

Sets an icon with the default style for the placemark

```swift
func setIconWith(_ image: UIImage, style: YMKIconStyle)
```

Sets an icon with the given style for the placemark

```swift
func setIconWith(_ image: UIImage, callback: @escaping YMKCallback)
```

Sets an icon with the default style for the placemark

```swift
func setIconWith(_ image: UIImage,
                   style: YMKIconStyle,
                callback: @escaping YMKCallback)
```

Sets an icon with the given style for the placemark

```swift
func setIconStyleWith(_ style: YMKIconStyle)
```

Changes the icon style

```swift
func useIcon() -> YMKIcon
```

Returns Icon object that can be used to set image or view and its style for the placemark

```swift
func useCompositeIcon() -> YMKCompositeIcon
```

Returns CompositeIcon object that can be used to set icons and their styles for the placemark

```swift
func useModel() -> YMKModel
```

Returns Model object that can be used to set model and its style for the placemark

```swift
func useAnimation() -> YMKPlacemarkAnimation
```

Returns PlacemarkAnimation object that can be used to control animation of the placemark

```swift
func setViewWithView(_ view: YRTViewProvider)
```

Sets the view with the default style for the placemark

```swift
func setViewWithView(_ view: YRTViewProvider, style: YMKIconStyle)
```

Sets the view with the given style for the placemark

```swift
func setViewWithView(_ view: YRTViewProvider, callback: @escaping YMKCallback)
```

Sets the view with the default style for the placemark

```swift
func setViewWithView(_ view: YRTViewProvider,
                      style: YMKIconStyle,
                   callback: @escaping YMKCallback)
```

Sets the view with the given style for the placemark

```swift
func setScaleFunctionWithPoints(_ points: [NSValue])
```

Sets piecewise linear scale, depending on the zoom

```swift
func setTextWithText(_ text: String)
```

Sets the text for the placemark, current text style is used

```swift
func setTextWithText(_ text: String, style: YMKTextStyle)
```

Sets the text with the given style for the placemark

```swift
func setTextStyleWith(_ style: YMKTextStyle)
```

Changes the text style

### Properties

```swift
var geometry: YMKPoint { get set }
```

```swift
var direction: Float { get set }
```

Angle between the direction of an object and the direction to north

```swift
var opacity: Float { get set }
```

Opacity multiplicator for the placemark content

```swift
var text: YMKPlacemarkText { get }
```

PlacemarkText can be used to set text and its style for the placemark

## Instance methods

### setIconWith(_:)

```swift
func setIconWith(_ image: UIImage)
```

Sets an icon with the default style for the placemark. Switches off and resets model/composite icon/animation/view.

### setIconWith(_:style:)

```swift
func setIconWith(_ image: UIImage, style: YMKIconStyle)
```

Sets an icon with the given style for the placemark. Switches off and resets model/composite icon/animation/view.

### setIconWith(_:callback:)

```swift
func setIconWith(_ image: UIImage, callback: @escaping YMKCallback)
```

Sets an icon with the default style for the placemark. Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setIconWith(_:style:callback:)

```swift
func setIconWith(_ image: UIImage,
                   style: YMKIconStyle,
                callback: @escaping YMKCallback)
```

Sets an icon with the given style for the placemark. Switches off and resets model/composite icon/animation/view. The callback is called immediately after the image finished loading. This means you can, for example, change the placemark visibility with a new icon.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setIconStyleWith(_:)

```swift
func setIconStyleWith(_ style: YMKIconStyle)
```

Changes the icon style. Valid only for the single icon, the view and the animated icon.

### useIcon()

```swift
func useIcon() -> YMKIcon
```

Returns Icon object that can be used to set image or view and its style for the placemark. Switches off and resets composite icon/model/animation/view.

### useCompositeIcon()

```swift
func useCompositeIcon() -> YMKCompositeIcon
```

Returns CompositeIcon object that can be used to set icons and their styles for the placemark. Switches off and resets icon/model/animation/view.

### useModel()

```swift
func useModel() -> YMKModel
```

Returns Model object that can be used to set model and its style for the placemark. Switches off and resets icon/composite icon/animation/view.

### useAnimation()

```swift
func useAnimation() -> YMKPlacemarkAnimation
```

Returns PlacemarkAnimation object that can be used to control animation of the placemark. Switches off and resets icon/composite icon/model/view.

### setViewWithView(_:)

```swift
func setViewWithView(_ view: YRTViewProvider)
```

Sets the view with the default style for the placemark. Switches off and resets icon/composite icon/animation/model.

### setViewWithView(_:style:)

```swift
func setViewWithView(_ view: YRTViewProvider, style: YMKIconStyle)
```

Sets the view with the given style for the placemark. Switches off and resets icon/composite icon/animation/view.

### setViewWithView(_:callback:)

```swift
func setViewWithView(_ view: YRTViewProvider, callback: @escaping YMKCallback)
```

Sets the view with the default style for the placemark. Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setViewWithView(_:style:callback:)

```swift
func setViewWithView(_ view: YRTViewProvider,
                      style: YMKIconStyle,
                   callback: @escaping YMKCallback)
```

Sets the view with the given style for the placemark. Switches off and resets icon/composite icon/animation/view. The callback will be called immediately after the view finished loading.

| Parameters |   |
| --- | --- |
| onFinished | Called when the icon is loaded. |

### setScaleFunctionWithPoints(_:)

```swift
func setScaleFunctionWithPoints(_ points: [NSValue])
```

Sets piecewise linear scale, depending on the zoom. The 'points' must be sorted by x; x coordinates must be unique. If zoom < minZoom(points) or zoom > maxZoom(points), it is set within the defined bounds before applying the function. By default, the scale function is defined by a single point (1, 1). If points is null or points.empty(), it resets the function to the default. If points.size() == 1, the scale is constant and equals point.y.

### setTextWithText(_:)

```swift
func setTextWithText(_ text: String)
```

Sets the text for the placemark, current text style is used

| Parameters |   |
| --- | --- |
| text | is a string in UTF-8 encoding |

### setTextWithText(_:style:)

```swift
func setTextWithText(_ text: String, style: YMKTextStyle)
```

Sets the text with the given style for the placemark

| Parameters |   |
| --- | --- |
| text | is a string in UTF-8 encoding |

### setTextStyleWith(_:)

```swift
func setTextStyleWith(_ style: YMKTextStyle)
```

Changes the text style.

## Properties

### geometry

```swift
var geometry: YMKPoint { get set }
```

### direction

```swift
var direction: Float { get set }
```

Angle between the direction of an object and the direction to north. Measured in degrees. Default: 0.f.

### opacity

```swift
var opacity: Float { get set }
```

Opacity multiplicator for the placemark content. Values below 0 will be set to 0. Default: 1.

### text

```swift
var text: YMKPlacemarkText { get }
```

PlacemarkText can be used to set text and its style for the placemark. It's optional parameter and can be used in addition to placemark objects
