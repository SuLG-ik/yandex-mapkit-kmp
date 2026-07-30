---
title: "YMKStylingProportionFunction"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKStylingProportionFunction"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStylingProportionFunction.html"
---
# YMKStylingProportionFunction

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKStylingProportionFunction.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKStylingProportionFunction : NSObject
```

## Summary

### Class methods

```swift
 init(constantFunction: YMKStylingConstantFunctionPoints)
```

```swift
 init(zoomFunction: YMKStylingLinearZoomFunctionPoints)
```

```swift
 init(tiltFunction: YMKStylingLinearTiltFunctionPoints)
```

```swift
 init(zoomTiltFunction: YMKStylingBilinearFunctionMatrix)
```

### Properties

```swift
var constantFunction: YMKStylingConstantFunctionPoints? { get }
```

```swift
var zoomFunction: YMKStylingLinearZoomFunctionPoints? { get }
```

```swift
var tiltFunction: YMKStylingLinearTiltFunctionPoints? { get }
```

```swift
var zoomTiltFunction: YMKStylingBilinearFunctionMatrix? { get }
```

## Class methods

### init(constantFunction:)

```swift
 init(constantFunction: YMKStylingConstantFunctionPoints)
```

### init(zoomFunction:)

```swift
 init(zoomFunction: YMKStylingLinearZoomFunctionPoints)
```

### init(tiltFunction:)

```swift
 init(tiltFunction: YMKStylingLinearTiltFunctionPoints)
```

### init(zoomTiltFunction:)

```swift
 init(zoomTiltFunction: YMKStylingBilinearFunctionMatrix)
```

## Properties

### constantFunction

```swift
var constantFunction: YMKStylingConstantFunctionPoints? { get }
```

### zoomFunction

```swift
var zoomFunction: YMKStylingLinearZoomFunctionPoints? { get }
```

### tiltFunction

```swift
var tiltFunction: YMKStylingLinearTiltFunctionPoints? { get }
```

### zoomTiltFunction

```swift
var zoomTiltFunction: YMKStylingBilinearFunctionMatrix? { get }
```
