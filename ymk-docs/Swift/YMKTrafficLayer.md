---
title: "YMKTrafficLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTrafficLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTrafficLayer.html"
---
# YMKTrafficLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTrafficLayer.html)

```swift
class YMKTrafficLayer : NSObject
```

A layer with traffic information.

## Summary

### Instance methods

```swift
func isTrafficVisible() -> Bool
```

Checks if traffic is visible

```swift
func setTrafficVisibleWithOn(_ on: Bool)
```

Sets traffic visibility

```swift
func setTrafficStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the traffic layer

```swift
func setTrafficStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the traffic layer

```swift
func resetTrafficStyles()
```

Resets all JSON style transformations applied to the traffic layer

```swift
func addTrafficListener(withTrafficListener trafficListener: any YMKTrafficDelegate)
```

Adds a traffic listener

```swift
func removeTrafficListener(withTrafficListener trafficListener: any YMKTrafficDelegate)
```

Removes a traffic listener

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### isTrafficVisible()

```swift
func isTrafficVisible() -> Bool
```

Checks if traffic is visible.

### setTrafficVisibleWithOn(_:)

```swift
func setTrafficVisibleWithOn(_ on: Bool)
```

Sets traffic visibility.

### setTrafficStyleWithStyle(_:)

```swift
func setTrafficStyleWithStyle(_ style: String) -> Bool
```

Applies JSON style transformations to the traffic layer. Same as setTrafficStyle(0, style). Set to empty string to clear previous styling. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### setTrafficStyleWithId(_:style:)

```swift
func setTrafficStyleWithId(_ id: Int, style: String) -> Bool
```

Applies JSON style transformations to the traffic layer. Replaces previous styling with the specified ID (if such exists). Stylings are applied in an ascending order. Set to empty string to clear previous styling with the specified ID. Returns true if the style was successfully parsed; false otherwise. If the return value is false, the current traffic style remains unchanged.

### resetTrafficStyles()

```swift
func resetTrafficStyles()
```

Resets all JSON style transformations applied to the traffic layer.

### addTrafficListener(withTrafficListener:)

```swift
func addTrafficListener(withTrafficListener trafficListener: any YMKTrafficDelegate)
```

Adds a traffic listener.

The class does not retain the object in the 'trafficListener' parameter. It is your responsibility to maintain a strong reference to the target object while it is attached to a class.

### removeTrafficListener(withTrafficListener:)

```swift
func removeTrafficListener(withTrafficListener trafficListener: any YMKTrafficDelegate)
```

Removes a traffic listener.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
