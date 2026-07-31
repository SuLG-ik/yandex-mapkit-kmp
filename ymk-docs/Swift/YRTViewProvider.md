---
title: "YRTViewProvider"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YRTViewProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YRTViewProvider.html"
---
# YRTViewProvider

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YRTViewProvider.html)

```swift
class YRTViewProvider : NSObject
```

This class can be used to associate any custom view with PlacemarkMapObject. Snapshot of provided view is taken in constructor and updated any time snapshot method is called by user.

## Summary

### Instance methods

```swift
init!(uiView view: UIView!, cacheable: Bool)
```

Constructor of YRTViewProvider

```swift
init!(uiView view: UIView!)
```

Constructor of YRTViewProvider

```swift
func snapshot()
```

Takes a snapshot of the given view

### Properties

```swift
var cacheable: Bool { get }
```

True if view provider is cacheable

## Instance methods

### init(uiView:cacheable:)

```swift
init!(uiView view: UIView!, cacheable: Bool)
```

Constructor of YRTViewProvider. Attention: This blocks the UI via executing snapshot function.

### init(uiView:)

```swift
init!(uiView view: UIView!)
```

Constructor of YRTViewProvider. Cacheable flag will have YES value by default. Attention: This blocks the UI via executing snapshot function.

### snapshot()

```swift
func snapshot()
```

Takes a snapshot of the given view. Attention: This blocks the UI.

## Properties

### cacheable

```swift
var cacheable: Bool { get }
```

True if view provider is cacheable. False otherwise.
