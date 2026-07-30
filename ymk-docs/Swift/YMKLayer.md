---
title: "YMKLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayer.html"
---
# YMKLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLayer.html)

```swift
class YMKLayer : NSObject
```

Interface for working with the layer.

## Summary

### Instance methods

```swift
func remove()
```

Removes the layer from the map

```swift
func dataSourceLayer() -> YMKDataSourceLayer
```

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### remove()

```swift
func remove()
```

Removes the layer from the map. The object becomes invalid after that.

### dataSourceLayer()

```swift
func dataSourceLayer() -> YMKDataSourceLayer
```

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
