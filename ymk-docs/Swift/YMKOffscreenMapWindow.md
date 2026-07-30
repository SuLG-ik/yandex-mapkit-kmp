---
title: "YMKOffscreenMapWindow"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKOffscreenMapWindow"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOffscreenMapWindow.html"
---
# YMKOffscreenMapWindow

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKOffscreenMapWindow.html)

```swift
class YMKOffscreenMapWindow : NSObject
```

Wraps YMKMapWindow without its own view to render. Allows to render map on additional surfaces in separate processes without having to create MapView control in the main process.

## Summary

### Instance methods

```swift
func captureScreenshot() -> UIImage
```

### Properties

```swift
var mapWindow: YMKMapWindow { get }
```

## Instance methods

### captureScreenshot()

```swift
func captureScreenshot() -> UIImage
```

## Properties

### mapWindow

```swift
var mapWindow: YMKMapWindow { get }
```
