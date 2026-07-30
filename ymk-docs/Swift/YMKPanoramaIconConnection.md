---
title: "YMKPanoramaIconConnection"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaIconConnection"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconConnection.html"
---
# YMKPanoramaIconConnection

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaIconConnection.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaIconConnection : NSObject
```

## Summary

### Class methods

```swift
 init(angularPosition: YMKDirection, iconId: String, panoramaId: String)
```

### Properties

```swift
var angularPosition: YMKDirection { get }
```

Angular position, degrees

```swift
var iconId: String { get }
```

The connection iconId

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method

## Class methods

### init(angularPosition:iconId:panoramaId:)

```swift
 init(angularPosition: YMKDirection, iconId: String, panoramaId: String)
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

The connection iconId. The iconId is passed as a parameter to the IconImageFactory and IconUrlProvider once iconId is visible

### panoramaId

```swift
var panoramaId: String { get }
```

panoramaId is passed as a parameter to the onPanoramaChangeIntent method.
