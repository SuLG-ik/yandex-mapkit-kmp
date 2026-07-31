---
title: "YMKPanoramaLayer"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPanoramaLayer"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaLayer.html"
---
# YMKPanoramaLayer

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPanoramaLayer.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPanoramaLayer : NSObject
```

Panorama coverage layer

## Summary

### Instance methods

```swift
func setStreetPanoramaVisibleWithOn(_ on: Bool)
```

Enables or disables the street coverage layer

```swift
func setAirshipPanoramaVisibleWithOn(_ on: Bool)
```

Enables or disables the airship icons

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### setStreetPanoramaVisibleWithOn(_:)

```swift
func setStreetPanoramaVisibleWithOn(_ on: Bool)
```

Enables or disables the street coverage layer.

### setAirshipPanoramaVisibleWithOn(_:)

```swift
func setAirshipPanoramaVisibleWithOn(_ on: Bool)
```

Enables or disables the airship icons.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
