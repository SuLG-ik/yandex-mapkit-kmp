---
title: "YMKMapView"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMapView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapView.html"
---
# YMKMapView

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMapView.html)

```swift
class YMKMapView : UIView
```

## Summary

### Instance methods

```swift
func setNoninteractive(_ is: Bool)
```

```swift
init!(coder aDecoder: NSCoder!)
```

```swift
init!(coder aDecoder: NSCoder!, transparencySupport: Bool)
```

```swift
init!(frame: CGRect)
```

```swift
init!(frame: CGRect, transparencySupport: Bool)
```

### Properties

```swift
var mapWindow: YMKMapWindow! { get }
```

```swift
var transparencySupport: Bool { get }
```

When YES, the underlying rendering surface will be non-opaque, allowing views behind the map to show through transparent areas

## Instance methods

### setNoninteractive(_:)

```swift
func setNoninteractive(_ is: Bool)
```

### init(coder:)

```swift
init!(coder aDecoder: NSCoder!)
```

### init(coder:transparencySupport:)

```swift
init!(coder aDecoder: NSCoder!, transparencySupport: Bool)
```

### init(frame:)

```swift
init!(frame: CGRect)
```

### init(frame:transparencySupport:)

```swift
init!(frame: CGRect, transparencySupport: Bool)
```

## Properties

### mapWindow

```swift
var mapWindow: YMKMapWindow! { get }
```

### transparencySupport

```swift
var transparencySupport: Bool { get }
```

When YES, the underlying rendering surface will be non-opaque, allowing views behind the map to show through transparent areas. Must be set before the view is displayed. Default is NO.
