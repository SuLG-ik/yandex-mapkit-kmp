---
title: "YMKPanoramaArrowConnection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaArrowConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaArrowConnection.html"
---
# YMKPanoramaArrowConnection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaArrowConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaArrowConnection : NSObject
```

## Summary

### Class methods

```swift
 init(angularPosition: YMKDirection,
                label: String,
           arrowStyle: YMKPanoramaArrowConnectionStyle,
           panoramaId: String)
```

### Properties

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees

```swift
var label: String { get }
```

label is shown near the arrow

```swift
var arrowStyle: YMKPanoramaArrowConnectionStyle { get }
```

Arrow style

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method

## Class methods

### init(angularPosition:label:arrowStyle:panoramaId:)

```swift
 init(angularPosition: YMKDirection,
                label: String,
           arrowStyle: YMKPanoramaArrowConnectionStyle,
           panoramaId: String)
```

## Properties

### angularPosition

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### label

```swift
var label: String { get }
```

label is shown near the arrow

### arrowStyle

```swift
var arrowStyle: YMKPanoramaArrowConnectionStyle { get }
```

Arrow style.

### panoramaId

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method.
