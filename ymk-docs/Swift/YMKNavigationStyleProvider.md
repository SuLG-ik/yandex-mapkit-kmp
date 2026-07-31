---
title: "YMKNavigationStyleProvider"
kind: "Protocol"
platform: "ios"
language: "Swift"
section: "iOS / Справочник / Swift / Protocols / YMKNavigationStyleProvider"
source: "https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationStyleProvider.html"
---
# YMKNavigationStyleProvider

`IOS` · `Swift` · `Protocol` — [оригинал](https://yandex.ru/maps-api/docs/mapkit/Swift/YMKNavigationStyleProvider.html)

> [!WARNING] Важно
> This feature is available in the NaviKit SDK version.

```swift
protocol YMKNavigationStyleProvider : NSObjectProtocol
```

Provides default style and icons when for navigation_layer objects when their look is refreshed (for example on creation or on night mode switch).

## Summary

### Instance methods

```swift
func routeViewStyleProvider() -> any YMKNavigationRouteViewStyleProvider
```

```swift
func balloonImageProvider() -> any YMKNavigationBalloonImageProvider
```

```swift
func requestPointStyleProvider() -> any YMKNavigationRequestPointStyleProvider
```

```swift
func userPlacemarkStyleProvider() -> any YMKNavigationUserPlacemarkStyleProvider
```

```swift
func routePinsStyleProvider() -> any YMKNavigationRoutePinsStyleProvider
```

```swift
func highlight() -> any YMKHighlightStyleProvider
```

## Instance methods

### routeViewStyleProvider()

```swift
func routeViewStyleProvider() -> any YMKNavigationRouteViewStyleProvider
```

### balloonImageProvider()

```swift
func balloonImageProvider() -> any YMKNavigationBalloonImageProvider
```

### requestPointStyleProvider()

```swift
func requestPointStyleProvider() -> any YMKNavigationRequestPointStyleProvider
```

### userPlacemarkStyleProvider()

```swift
func userPlacemarkStyleProvider() -> any YMKNavigationUserPlacemarkStyleProvider
```

### routePinsStyleProvider()

```swift
func routePinsStyleProvider() -> any YMKNavigationRoutePinsStyleProvider
```

### highlight()

```swift
func highlight() -> any YMKHighlightStyleProvider
```
