---
title: "YMKLogo"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKLogo"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLogo.html"
---
# YMKLogo

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKLogo.html)

```swift
class YMKLogo : NSObject
```

The object that allows to control logo display properties.

## Summary

### Instance methods

```swift
func setAlignmentWith(_ alignment: YMKLogoAlignment)
```

Set logo alignment in the container

```swift
func setPaddingWith(_ padding: YMKLogoPadding)
```

Set logo padding relative to the left/right and top/bottom edges

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setAlignmentWith(_:)

```swift
func setAlignmentWith(_ alignment: YMKLogoAlignment)
```

Set logo alignment in the container.

### setPaddingWith(_:)

```swift
func setPaddingWith(_ padding: YMKLogoPadding)
```

Set logo padding relative to the left/right and top/bottom edges. Values must be positive.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
