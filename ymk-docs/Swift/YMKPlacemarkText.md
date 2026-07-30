---
title: "YMKPlacemarkText"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlacemarkText"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkText.html"
---
# YMKPlacemarkText

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkText.html)

```swift
class YMKPlacemarkText : NSObject
```

Provides an interface to set text and its style for a placemark.

## Summary

### Properties

```swift
var text: String { get set }
```

UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text

```swift
var style: YMKTextStyle { get set }
```

The style properties (size, color, etc

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### text

```swift
var text: String { get set }
```

UTF-8 encoded text to be displayed with the PlacemarkMapObject Empty string means no text

### style

```swift
var style: YMKTextStyle { get set }
```

The style properties (size, color, etc.) of the placemark text. Note: The current style cannot be modified directly - you must reset it to apply changes.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
