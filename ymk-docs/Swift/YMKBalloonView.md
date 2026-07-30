---
title: "YMKBalloonView"
kind: "Class"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Classes / YMKBalloonView"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonView.html"
---
# YMKBalloonView

`IOS` · `Swift` · `Class` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonView.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
class YMKBalloonView : NSObject
```

## Summary

### Properties

```swift
var anchor: YMKBalloonAnchor { get }
```

```swift
var balloon: YMKBalloon { get }
```

```swift
var isIsVisible: Bool { get }
```

True if balloon currently visible on the screen

```swift
var isIsEnabled: Bool { get set }
```

If 'true', balloons will be shown whenever it possible

```swift
var hostRoute: YMKDrivingRoute { get }
```

The route to which this balloon belongs

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no

## Properties

### anchor

```swift
var anchor: YMKBalloonAnchor { get }
```

### balloon

```swift
var balloon: YMKBalloon { get }
```

### isIsVisible

```swift
var isIsVisible: Bool { get }
```

True if balloon currently visible on the screen. Always false if balloon disabled

### isIsEnabled

```swift
var isIsEnabled: Bool { get set }
```

If 'true', balloons will be shown whenever it possible. If 'false', balloons will be always hidden. `BalloonViewListener.onBalloonContentChanged` is called regardless of isEnabled value. `RouteView.showBalloons` call changes this attribute. Enabled by default.

### hostRoute

```swift
var hostRoute: YMKDrivingRoute { get }
```

The route to which this balloon belongs.

### isValid

```swift
var isValid: Bool { get }
```

Tells if this object is valid or no. Any method called on an invalid object will throw an exception. The object becomes invalid only on UI thread, and only when its implementation depends on objects already destroyed by now. Please refer to general docs about the interface for details on its invalidation.
