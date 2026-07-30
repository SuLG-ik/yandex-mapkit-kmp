---
title: "YMKPlaces"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKPlaces"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlaces.html"
---
# YMKPlaces

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKPlaces.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKPlaces : NSObject
```

## Summary

### Instance methods

```swift
func createPanoramaService() -> YMKPanoramaService
```

Creates a service that allows to find a panorama closest to the chosen point

```swift
func createPanoramaLayer(with mapWindow: YMKMapWindow) -> YMKPanoramaLayer
```

Creates a layer representing where panoramas are available

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### createPanoramaService()

```swift
func createPanoramaService() -> YMKPanoramaService
```

Creates a service that allows to find a panorama closest to the chosen point.

### createPanoramaLayer(with:)

```swift
func createPanoramaLayer(with mapWindow: YMKMapWindow) -> YMKPanoramaLayer
```

Creates a layer representing where panoramas are available.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
