---
title: "YMKPanoView"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoView.html"
---
# YMKPanoView

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoView.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoView : UIView
```

## Summary

### Instance methods

```swift
init!(coder aDecoder: NSCoder!)
```

```swift
init!(frame: CGRect, vulkanPreferred: Bool)
```

```swift
init!(frame: CGRect, scaleFactor: Float, vulkanPreferred: Bool)
```

```swift
init!(frame: CGRect,
 vulkanPreferred: Bool,
 lifecycleProvider: (any YRTLifecycleProvider)!)
```

```swift
init!(frame: CGRect,
 scaleFactor: Float,
 vulkanPreferred: Bool,
 lifecycleProvider: (any YRTLifecycleProvider)!)
```

```swift
func setNoninteractive(_ is: Bool)
```

### Properties

```swift
var player: YMKPanoramaPlayer! { get }
```

## Instance methods

### init(coder:)

```swift
init!(coder aDecoder: NSCoder!)
```

### init(frame:vulkanPreferred:)

```swift
init!(frame: CGRect, vulkanPreferred: Bool)
```

### init(frame:scaleFactor:vulkanPreferred:)

```swift
init!(frame: CGRect, scaleFactor: Float, vulkanPreferred: Bool)
```

### init(frame:vulkanPreferred:lifecycleProvider:)

```swift
init!(frame: CGRect,
 vulkanPreferred: Bool,
 lifecycleProvider: (any YRTLifecycleProvider)!)
```

### init(frame:scaleFactor:vulkanPreferred:lifecycleProvider:)

```swift
init!(frame: CGRect,
 scaleFactor: Float,
 vulkanPreferred: Bool,
 lifecycleProvider: (any YRTLifecycleProvider)!)
```

### setNoninteractive(_:)

```swift
func setNoninteractive(_ is: Bool)
```

## Properties

### player

```swift
var player: YMKPanoramaPlayer! { get }
```
