---
title: "YMKBalloonViewListener"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKBalloonViewListener"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonViewListener.html"
---
# YMKBalloonViewListener

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKBalloonViewListener.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKBalloonViewListener : NSObjectProtocol
```

## Summary

### Instance methods

```swift
func onBalloonViewsChanged(withRoute route: YMKRouteView)
```

```swift
func onBalloonViewTap(withBalloon balloon: YMKBalloonView)
```

```swift
func onBalloonVisibilityChanged(withBalloon balloon: YMKBalloonView)
```

```swift
func onBalloonContentChanged(withBalloon balloon: YMKBalloonView)
```

called on BalloonView

## Instance methods

### onBalloonViewsChanged(withRoute:)

```swift
func onBalloonViewsChanged(withRoute route: YMKRouteView)
```

### onBalloonViewTap(withBalloon:)

```swift
func onBalloonViewTap(withBalloon balloon: YMKBalloonView)
```

### onBalloonVisibilityChanged(withBalloon:)

```swift
func onBalloonVisibilityChanged(withBalloon balloon: YMKBalloonView)
```

### onBalloonContentChanged(withBalloon:)

```swift
func onBalloonContentChanged(withBalloon balloon: YMKBalloonView)
```

called on BalloonView.balloon changing
