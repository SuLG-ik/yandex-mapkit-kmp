---
title: "YMKIcon"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIcon.html"
---
# YMKIcon

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKIcon.html)

```swift
class YMKIcon : YMKPlacemarkPresentation
```

Provides an interface to set icon and its style for a placemark.

## Summary

### Instance methods

```swift
func setImageWith(_ image: UIImage)
```

Sets the image for the icon

```swift
func setImageWith(_ image: UIImage, style: YMKIconStyle?)
```

Sets the image for the icon

```swift
func setImageWith(_ image: UIImage,
                    style: YMKIconStyle?,
                 callback: YMKCallback? = nil)
```

Sets the image for the icon

```swift
func setViewWithView(_ view: YRTViewProvider)
```

Sets the view for the icon

```swift
func setViewWithView(_ view: YRTViewProvider, style: YMKIconStyle?)
```

Sets the view for the icon

```swift
func setViewWithView(_ view: YRTViewProvider,
                      style: YMKIconStyle?,
                   callback: YMKCallback? = nil)
```

Sets the view for the icon

### Properties

```swift
var style: YMKIconStyle { get set }
```

The style properties (scale, zIndex, etc

## Instance methods

### setImageWith(_:)

```swift
func setImageWith(_ image: UIImage)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setImageWith(_:style:)

```swift
func setImageWith(_ image: UIImage, style: YMKIconStyle?)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setImageWith(_:style:callback:)

```swift
func setImageWith(_ image: UIImage,
                    style: YMKIconStyle?,
                 callback: YMKCallback? = nil)
```

Sets the image for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView(_:)

```swift
func setViewWithView(_ view: YRTViewProvider)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView(_:style:)

```swift
func setViewWithView(_ view: YRTViewProvider, style: YMKIconStyle?)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setViewWithView(_:style:callback:)

```swift
func setViewWithView(_ view: YRTViewProvider,
                      style: YMKIconStyle?,
                   callback: YMKCallback? = nil)
```

Sets the view for the icon.

| Parameters |   |
| --- | --- |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

## Properties

### style

```swift
var style: YMKIconStyle { get set }
```

The style properties (scale, zIndex, etc.) of the icon placemark. Note: The current style cannot be modified directly - you must reset it to apply changes.
