---
title: "YMKNavigationJamStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKNavigationJamStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationJamStyle.html"
---
# YMKNavigationJamStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationJamStyle.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKNavigationJamStyle : NSObject
```

The style that is used to display traffic intensity.

## Summary

### Instance methods

```swift
func setColorsWith(_ colors: [YMKJamTypeColor])
```

Collection of colors for traffic intensity

```swift
func setGradientLengthWithGradientLength(_ gradientLength: Float)
```

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setColorsWith(_:)

```swift
func setColorsWith(_ colors: [YMKJamTypeColor])
```

Collection of colors for traffic intensity.

### setGradientLengthWithGradientLength(_:)

```swift
func setGradientLengthWithGradientLength(_ gradientLength: Float)
```

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
