---
title: "YMKCarparksLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCarparksLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCarparksLayer.html"
---
# YMKCarparksLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCarparksLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKCarparksLayer : NSObject
```

## Summary

### Instance methods

```swift
func isVisible() -> Bool
```

Indicates whether the layer is displayed on a map

```swift
func setVisibleWithOn(_ on: Bool)
```

Display or hide the layer on a map

```swift
func setCarparksStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the carparks layer

```swift
func setCarparksStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the carparks layer

```swift
func resetCarparksStyles()
```

Resets all JSON style transformations applied to the carparks layer

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### isVisible()

```swift
func isVisible() -> Bool
```

Indicates whether the layer is displayed on a map.

### setVisibleWithOn(_:)

```swift
func setVisibleWithOn(_ on: Bool)
```

Display or hide the layer on a map.

### setCarparksStyleWithStyle(_:)

```swift
func setCarparksStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the carparks layer. Same as setCarparksStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### setCarparksStyleWithId(_:style:)

```swift
func setCarparksStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the carparks layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current carparks style remains unchanged.

### resetCarparksStyles()

```swift
func resetCarparksStyles()
```

Resets all JSON style transformations applied to the carparks layer.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
