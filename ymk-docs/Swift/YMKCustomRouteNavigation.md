---
title: "YMKCustomRouteNavigation"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKCustomRouteNavigation"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCustomRouteNavigation.html"
---
# YMKCustomRouteNavigation

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKCustomRouteNavigation.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKCustomRouteNavigation : NSObject
```

## Summary

### Instance methods

```swift
func createCamera(with mapWindow: YMKMapWindow) -> YMKCamera
```

This method allows to create camera which used in standart automotive navigation

```swift
func startGuidance(with route: YMKDrivingRoute?)
```

Start navigation with specified route

### Properties

```swift
var navigation: YMKNavigation { get }
```

This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class

## Instance methods

### createCamera(with:)

```swift
func createCamera(with mapWindow: YMKMapWindow) -> YMKCamera
```

This method allows to create camera which used in standart automotive navigation

### startGuidance(with:)

```swift
func startGuidance(with route: YMKDrivingRoute?)
```

Start navigation with specified route.

## Properties

### navigation

```swift
var navigation: YMKNavigation { get }
```

This navigation is equal to standart automotive navigation BUT without alternatives without rerouting without working "requestRoutes" method traffic information will not be updated while driving along the route start guidance must be called only through the special method (startGuidance) of this class
