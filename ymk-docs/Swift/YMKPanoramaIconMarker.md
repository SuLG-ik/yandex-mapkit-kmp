---
title: "YMKPanoramaIconMarker"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaIconMarker"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconMarker.html"
---
# YMKPanoramaIconMarker

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconMarker.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaIconMarker : NSObject
```

Icon marker struct

## Summary

### Class methods

```swift
 init(angularPosition: YMKDirection, iconId: String)
```

### Properties

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees

```swift
var iconId: String { get }
```

The marker iconId

## Class methods

### init(angularPosition:iconId:)

```swift
 init(angularPosition: YMKDirection, iconId: String)
```

## Properties

### angularPosition

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees. (bearing, tilt) (0, 0) - (north, horizon)

### iconId

```swift
var iconId: String { get }
```

The marker iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider
