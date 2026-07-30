---
title: "YMKRotationType"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKRotationType"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRotationType.html"
---
# YMKRotationType

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRotationType.html)

```swift
enum YMKRotationType : UInt, @unchecked Sendable
```

The way rotation is handled.

## Summary

### Enum cases

```swift
case noRotation = 0
```

Ignores the placemark direction; stable in screen space

```swift
case rotate = 1
```

Follows the placemark direction

## Enum cases

### noRotation

```swift
case noRotation = 0
```

Ignores the placemark direction; stable in screen space.

### rotate

```swift
case rotate = 1
```

Follows the placemark direction. For non-flat placemarks, the direction vector is projected onto the screen plane.
