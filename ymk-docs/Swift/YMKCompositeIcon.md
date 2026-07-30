---
title: "YMKCompositeIcon"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCompositeIcon"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCompositeIcon.html"
---
# YMKCompositeIcon

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCompositeIcon.html)

```swift
class YMKCompositeIcon : YMKPlacemarkPresentation
```

Combines multiple icons into one.

## Summary

### Instance methods

```swift
func setIconWithName(_ name: String, image: UIImage)
```

Creates or resets a named layer with an icon and its style

```swift
func setIconWithName(_ name: String, image: UIImage, style: YMKIconStyle?)
```

Creates or resets a named layer with an icon and its style

```swift
func setIconWithName(_ name: String,
                      image: UIImage,
                      style: YMKIconStyle?,
                   callback: YMKCallback? = nil)
```

Creates or resets a named layer with an icon and its style

```swift
func setIconStyleWithName(_ name: String, style: YMKIconStyle)
```

Changes the icon style for a specific layer

```swift
func icon(withName name: String) -> YMKIcon
```

Returns named Icon object that can be used to set icon and its style

```swift
func remove(withName name: String)
```

Removes the named layer

```swift
func removeAll()
```

Removes all layers

## Instance methods

### setIconWithName(_:image:)

```swift
func setIconWithName(_ name: String, image: UIImage)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconWithName(_:image:style:)

```swift
func setIconWithName(_ name: String, image: UIImage, style: YMKIconStyle?)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconWithName(_:image:style:callback:)

```swift
func setIconWithName(_ name: String,
                      image: UIImage,
                      style: YMKIconStyle?,
                   callback: YMKCallback? = nil)
```

Creates or resets a named layer with an icon and its style.

| Parameters |   |
| --- | --- |
| name | Unique identifier of the icon layer. Used to create or update. |
| style | The icon style. If not specified, the default style is used. |
| onFinished | Optional callback invoked when the icon is loaded. |

### setIconStyleWithName(_:style:)

```swift
func setIconStyleWithName(_ name: String, style: YMKIconStyle)
```

Changes the icon style for a specific layer.

### icon(withName:)

```swift
func icon(withName name: String) -> YMKIcon
```

Returns named Icon object that can be used to set icon and its style. Creates an empty Icon if it didn't exist.

### remove(withName:)

```swift
func remove(withName name: String)
```

Removes the named layer.

### removeAll()

```swift
func removeAll()
```

Removes all layers.
