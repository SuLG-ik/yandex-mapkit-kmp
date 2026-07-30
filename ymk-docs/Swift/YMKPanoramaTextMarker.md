---
title: "YMKPanoramaTextMarker"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaTextMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTextMarker.html"
---
# YMKPanoramaTextMarker

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaTextMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaTextMarker : NSObject
```

Text marker struct

## Summary

### Class methods

```swift
 init(angularPosition: YMKDirection, shortLabel: String, fullLabel: String)
```

### Properties

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees

```swift
var shortLabel: String { get }
```

The text displayed in short mode

```swift
var fullLabel: String { get }
```

The text displayed in full mode

## Class methods

### init(angularPosition:shortLabel:fullLabel:)

```swift
 init(angularPosition: YMKDirection, shortLabel: String, fullLabel: String)
```

## Properties

### angularPosition

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### shortLabel

```swift
var shortLabel: String { get }
```

The text displayed in short mode. For example, a house name '14b'

### fullLabel

```swift
var fullLabel: String { get }
```

The text displayed in full mode. For example, street name + house name 'Lesnaya ul. 14b'
