---
title: "YMKDirections"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKDirections"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDirections.html"
---
# YMKDirections

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKDirections.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKDirections : NSObject
```

## Summary

### Instance methods

```swift
func createCarparksLayer(with mapWindow: YMKMapWindow) -> YMKCarparksLayer
```

Creates the carparks layer

```swift
func createDrivingRouter(withType type: YMKDrivingRouterType) -> YMKDrivingRouter
```

Creates a manager that builds driving routes

### Properties

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### createCarparksLayer(with:)

```swift
func createCarparksLayer(with mapWindow: YMKMapWindow) -> YMKCarparksLayer
```

Creates the carparks layer.

### createDrivingRouter(withType:)

```swift
func createDrivingRouter(withType type: YMKDrivingRouterType) -> YMKDrivingRouter
```

Creates a manager that builds driving routes.

## Properties

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
