---
title: "YMKPlacemarkPresentation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlacemarkPresentation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkPresentation.html"
---
# YMKPlacemarkPresentation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlacemarkPresentation.html)

```swift
class YMKPlacemarkPresentation : NSObject
```

A general interface for placemark presentation objects

## Summary

### Instance methods

```swift
func remove()
```

Removes the presentation

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

Removes the presentation. This method invalidates object.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
