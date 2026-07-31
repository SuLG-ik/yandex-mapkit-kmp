---
title: "YMKMasstransitTransportContourStyle"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKMasstransitTransportContourStyle"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportContourStyle.html"
---
# YMKMasstransitTransportContourStyle

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKMasstransitTransportContourStyle.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKMasstransitTransportContourStyle : NSObject
```

Describes the style of transport contour objects

## Summary

### Class methods

```swift
 init(mainColor: NSNumber?, mainColorNight: NSNumber?)
```

### Properties

```swift
var mainColor: NSNumber? { get }
```

Describes the main color of transport contour

```swift
var mainColorNight: NSNumber? { get }
```

Optional field, can be nil

## Class methods

### init(mainColor:mainColorNight:)

```swift
 init(mainColor: NSNumber?, mainColorNight: NSNumber?)
```

## Properties

### mainColor

```swift
var mainColor: NSNumber? { get }
```

Describes the main color of transport contour. Main color is used to identify the object among others. For example, the color of MCD line icon meant to be the main color of the contour. Presented in versions for light and dark themes.

Optional field, can be nil.

### mainColorNight

```swift
var mainColorNight: NSNumber? { get }
```

Optional field, can be nil.
