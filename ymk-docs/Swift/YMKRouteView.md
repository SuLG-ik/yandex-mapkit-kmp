---
title: "YMKRouteView"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKRouteView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteView.html"
---
# YMKRouteView

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKRouteView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKRouteView : NSObject
```

## Summary

### Properties

```swift
var route: YMKDrivingRoute { get }
```

```swift
var balloonViews: [YMKBalloonView] { get }
```

Balloons displayed on map about the route

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### route

```swift
var route: YMKDrivingRoute { get }
```

### balloonViews

```swift
var balloonViews: [YMKBalloonView] { get }
```

Balloons displayed on map about the route.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
