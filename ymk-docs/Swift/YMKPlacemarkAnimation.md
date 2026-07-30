---
title: "YMKPlacemarkAnimation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlacemarkAnimation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkAnimation.html"
---
# YMKPlacemarkAnimation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkAnimation.html)

```swift
class YMKPlacemarkAnimation : YMKPlacemarkPresentation
```

Provides an interface to load and control animation of placemark.

## Summary

### Instance methods

```swift
func setIconWithImage(_ image: any YRTAnimatedImageProvider,
                        style: YMKIconStyle)
```

Sets the animated image and icon style

```swift
func setIconWithImage(_ image: any YRTAnimatedImageProvider,
                        style: YMKIconStyle,
                     callback: @escaping YMKCallback)
```

Sets the animated image and icon style

```swift
func setIconStyleWith(_ style: YMKIconStyle)
```

Changes the icon style

```swift
func play()
```

Starts animation

```swift
func play(callback: @escaping YMKCallback)
```

Starts animation and handles the callback

```swift
func resume()
```

Resumes paused animation

```swift
func stop()
```

Stops animation

```swift
func pause()
```

Pauses animation

### Properties

```swift
var isReversed: Bool { get set }
```

If true, animation will be played in the reverse direction

## Instance methods

### setIconWithImage(_:style:)

```swift
func setIconWithImage(_ image: any YRTAnimatedImageProvider,
                        style: YMKIconStyle)
```

Sets the animated image and icon style. The new animation will be in the paused state.

### setIconWithImage(_:style:callback:)

```swift
func setIconWithImage(_ image: any YRTAnimatedImageProvider,
                        style: YMKIconStyle,
                     callback: @escaping YMKCallback)
```

Sets the animated image and icon style. The new animation will be in the paused state.

| Parameters |   |
| --- | --- |
| onFinished | is called when the icon is loaded. |

### setIconStyleWith(_:)

```swift
func setIconStyleWith(_ style: YMKIconStyle)
```

Changes the icon style.

### play()

```swift
func play()
```

Starts animation. Removes the current play callback. Same as play(null).

### play(callback:)

```swift
func play(callback: @escaping YMKCallback)
```

Starts animation and handles the callback.

| Parameters |   |
| --- | --- |
| onFinished | is called when animation finishes and replaces the previous callback. |

### resume()

```swift
func resume()
```

Resumes paused animation. Callback (if any) is NOT removed.

### stop()

```swift
func stop()
```

Stops animation. Animation returns to the initial paused state.

### pause()

```swift
func pause()
```

Pauses animation.

## Properties

### isReversed

```swift
var isReversed: Bool { get set }
```

If true, animation will be played in the reverse direction. Default value is false.
