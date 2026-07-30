---
title: "YMKCameraUpdateReason"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKCameraUpdateReason"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraUpdateReason.html"
---
# YMKCameraUpdateReason

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCameraUpdateReason.html)

```swift
enum YMKCameraUpdateReason : UInt, @unchecked Sendable
```

The reason of the camera update.

## Summary

### Enum cases

```swift
case gestures = 0
```

User manipulation, for example: zoom, scroll, rotate, fling

```swift
case application = 1
```

Application, by calling the map::move method

## Enum cases

### gestures

```swift
case gestures = 0
```

User manipulation, for example: zoom, scroll, rotate, fling.

### application

```swift
case application = 1
```

Application, by calling the map::move method.
