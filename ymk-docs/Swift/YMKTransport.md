---
title: "YMKTransport"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKTransport"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTransport.html"
---
# YMKTransport

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKTransport.html)

> [!WARNING] Важно
> This feature is available in the Full MapKit SDK version

```swift
class YMKTransport : NSObject
```

## Summary

### Instance methods

```swift
func createBicycleRouter() -> YMKBicycleRouter
```

Creates a manager that builds bicycle routes using the origin and destination points

```swift
func createMasstransitRouter() -> YMKMasstransitRouter
```

Creates a manager that builds public transit routes using the origin and destination points

```swift
func createPedestrianRouter() -> YMKPedestrianRouter
```

Creates a manager that builds pedestrian routes using the origin and destination points

```swift
func createBicycleRouterV2() -> YMKBicycleRouterV2
```

Creates a manager that builds bicycle routes using the origin and destination points

```swift
func createScooterRouter() -> YMKBicycleRouterV2
```

Creates a manager that builds scooter routes using the origin and destination points

```swift
func createElectricBikeRouter() -> YMKBicycleRouterV2
```

Creates a manager that builds electric bike routes using the origin and destination points

### Properties

```swift
var adjustedClock: YMKAdjustedClock { get }
```

Returns the clock that is constantly synchronized with the server

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Instance methods

### createBicycleRouter()

```swift
func createBicycleRouter() -> YMKBicycleRouter
```

Creates a manager that builds bicycle routes using the origin and destination points.

> [!CAUTION] Внимание
> use createBicycleRouterV2 instead

### createMasstransitRouter()

```swift
func createMasstransitRouter() -> YMKMasstransitRouter
```

Creates a manager that builds public transit routes using the origin and destination points.

### createPedestrianRouter()

```swift
func createPedestrianRouter() -> YMKPedestrianRouter
```

Creates a manager that builds pedestrian routes using the origin and destination points.

### createBicycleRouterV2()

```swift
func createBicycleRouterV2() -> YMKBicycleRouterV2
```

Creates a manager that builds bicycle routes using the origin and destination points.

### createScooterRouter()

```swift
func createScooterRouter() -> YMKBicycleRouterV2
```

Creates a manager that builds scooter routes using the origin and destination points.

### createElectricBikeRouter()

```swift
func createElectricBikeRouter() -> YMKBicycleRouterV2
```

Creates a manager that builds electric bike routes using the origin and destination points.

## Properties

### adjustedClock

```swift
var adjustedClock: YMKAdjustedClock { get }
```

Returns the clock that is constantly synchronized with the server.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
