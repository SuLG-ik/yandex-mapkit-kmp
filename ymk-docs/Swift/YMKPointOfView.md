---
title: "YMKPointOfView"
kind: "Enum"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Enums / YMKPointOfView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPointOfView.html"
---
# YMKPointOfView

`IOS` · `Swift` · `Enum` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPointOfView.html)

```swift
enum YMKPointOfView : UInt, @unchecked Sendable
```

The point of view.

## Summary

### Enum cases

```swift
case screenCenter = 0
```

Point of View is centered on the screen

```swift
case adaptToFocusPointHorizontally = 1
```

Point of View has an x-coordinate at focusPoint and a y-coordinate at the center of the screen

## Enum cases

### screenCenter

```swift
case screenCenter = 0
```

Point of View is centered on the screen.

### adaptToFocusPointHorizontally

```swift
case adaptToFocusPointHorizontally = 1
```

Point of View has an x-coordinate at focusPoint and a y-coordinate at the center of the screen.
